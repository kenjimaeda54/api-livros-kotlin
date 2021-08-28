package com.example.mercadolivro.service

import com.example.mercadolivro.model.CustomerModel
import org.springframework.stereotype.Service

@Service
class CustomService {

    private val customers = mutableListOf<CustomerModel>()
    //camada service nao pode ter request
    fun customers(name: String?): List<CustomerModel> {
        //no parametro usando ponto de iterrogacao, digo que nao sera um valor obrigatório, ou seja,sera permitido null.
        //Para  evitar retorno null sera tratado com let. Operador elvis nao pode ser usado, porque caso de uso diferente
        //nao e ideal ficar recebendo request no parametro, então sera criado uma extension function para receber
        //apenas o model. As requests sao do controler
        name?.let {
            //com contains vou verificar se possui o nome, com ignoreCase vou ignorar letras maiúsculas e minúsculas
            return customers.filter { it.name.contains(name, true) }
        }
        return customers
    }

    fun create(customer: CustomerModel) {
        //no koltin a variável consegue assumir o valor do if
        val id = if (customers.isEmpty()) {
            1
        } else {
            //primeiro preciso verificar se estava vazio. Last()  pega o valor anterior adicionado,mas caso for vazio retorna exception.
            //Então trato se esta vazio e depois somo
            customers.last().id!!.toInt() + 1
        }.toString()
        customer.id = id
        customers.add(customer)
    }

    fun getId(id: String): CustomerModel {
        return customers.first { it.id == id }
    }

    fun update(customer: CustomerModel) {
        customers.filter { it.id == customer.id }.first().let {
            it.name = customer.name
            it.email = customer.email
        }
    }

    fun delete(id: String) {
        customers.removeIf { it.id == id }
    }
}