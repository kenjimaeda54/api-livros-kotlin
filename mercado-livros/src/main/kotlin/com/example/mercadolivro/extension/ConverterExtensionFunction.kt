package com.example.mercadolivro.extension

import com.example.mercadolivro.enum.EnumBooks
import com.example.mercadolivro.model.BooksModel
import com.example.mercadolivro.model.CustomerModel
import com.example.mercadolivro.request.PostBookRequest
import com.example.mercadolivro.request.PostCustomerRequest
import com.example.mercadolivro.request.PutCustomerRequest

fun PostCustomerRequest.toCustomModel(): CustomerModel {
    return CustomerModel(name = this.name, email = this.email)
}

fun PutCustomerRequest.toCustomModel(id: Int): CustomerModel{
    return CustomerModel(id = id,name =this.name,email = this.email)
}

fun PostBookRequest.toCustomBookModel(customer: CustomerModel): BooksModel {
    return  BooksModel(
        name = this.name,
        price = this.price,
        status = EnumBooks.Ativo,
        customer = customer
    )
}