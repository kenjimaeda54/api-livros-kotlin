package com.example.mercadolivro.reposytory

import com.example.mercadolivro.model.CustomerModel
import org.springframework.data.repository.CrudRepository


//‘Interface’ CrudRepository espera uma entidade do banco e outro e tipo do id
interface CustomRepository : CrudRepository<CustomerModel, Int> {
    fun findByNameContaining(name: String): List<CustomerModel>
}