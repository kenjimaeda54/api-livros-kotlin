package com.example.mercadolivro.service

import com.example.mercadolivro.model.CustomerModel
import org.springframework.stereotype.Service
import com.example.mercadolivro.reposytory.CustomRepository

@Service
class CustomService(val repository: CustomRepository) {


    //camada service nao pode ter request
    fun customers(name: String?): List<CustomerModel> {
        name?.let {  return repository.findByNameContaining(it) }
        return repository.findAll().toList()
    }

    fun create(customer: CustomerModel) {
        repository.save(customer)
    }

    fun getId(id: Int): CustomerModel {
        return repository.findById(id).orElseThrow()
    }

    fun update(customer: CustomerModel) {
        //existByid e para verificar se existe id. Metodo usado para salvar e atulizar sao  iguais entao
        //primeiro verifica se possui id,se existir eu salvo
        if (!repository.existsById(customer.id!!)) {
            return throw  Exception()
        }
        repository.save(customer)
    }

    fun delete(id: Int) {
        if (!repository.existsById(id)) {
            return throw Exception()
        }
        repository.deleteById(id)
    }
}