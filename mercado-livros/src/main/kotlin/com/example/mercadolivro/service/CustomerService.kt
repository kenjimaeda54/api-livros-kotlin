package com.example.mercadolivro.service

import com.example.mercadolivro.enum.EnumCustomer
import com.example.mercadolivro.enum.Erros
import com.example.mercadolivro.exception.NotFoundException
import com.example.mercadolivro.model.CustomerModel
import org.springframework.stereotype.Service
import com.example.mercadolivro.reposytory.CustomRepository

@Service
class CustomerService(val repository: CustomRepository) {


    //camada service nao pode ter request
    fun customers(name: String?): List<CustomerModel> {
        name?.let { return repository.findByNameContaining(it) }
        return repository.findAll().toList()
    }

    fun create(customer: CustomerModel) {
        repository.save(customer)
    }

    fun getId(id: Int): CustomerModel {
        return repository.findById(id)
            .orElseThrow { NotFoundException(Erros.ML_2000.message.format(id), Erros.ML_2000.code) }
    }

    fun update(customer: CustomerModel) {
        //existByid e para verificar se existe id. Metodo usado para salvar e atualizar sao  iguais então
        //primeiro verifica se possui id,se existir eu salvo
        if (!repository.existsById(customer.id!!)) {
            return throw  Exception()
        }
        repository.save(customer)
    }

    fun delete(id: Int) {
        val customer = getId(id)
        customer.status = EnumCustomer.INATIVO
        repository.save(customer)

    }

    //se existir o email retorna true,então passo false para a funcao
    fun validateEmail(email: String): Boolean {
        //existsByEmail e uma query precisa ser o valor correto
        //querys estão em like query jpa
        //estou a dizer se email existe,retorna false
        return  !repository.existsByEmail(email)
    }
}