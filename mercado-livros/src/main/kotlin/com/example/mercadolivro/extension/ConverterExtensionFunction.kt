package com.example.mercadolivro.extension

import com.example.mercadolivro.model.CustomerModel
import com.example.mercadolivro.request.PostCustomerRequest
import com.example.mercadolivro.request.PutCustomerRequest

fun PostCustomerRequest.toCustomModel(): CustomerModel {
    return CustomerModel(name = this.name, email = this.email)
}

fun PutCustomerRequest.toCustomModel(id: Int): CustomerModel{
    return CustomerModel(id = id,name =this.name,email = this.email)
}