package com.example.mercadolivro.extension

import com.example.mercadolivro.controler.booksReponse.BookResponse
import com.example.mercadolivro.controler.customerResponse.CustomerResponse
import com.example.mercadolivro.enum.EnumBooks
import com.example.mercadolivro.enum.EnumCustomer
import com.example.mercadolivro.model.BooksModel
import com.example.mercadolivro.model.CustomerModel
import com.example.mercadolivro.request.PostBookRequest
import com.example.mercadolivro.request.PostCustomerRequest
import com.example.mercadolivro.request.PutBookRequest
import com.example.mercadolivro.request.PutCustomerRequest

fun PostCustomerRequest.toCustomModel(): CustomerModel {
    return CustomerModel(name = this.name, email = this.email, status = EnumCustomer.ATIVO)
}

fun PutCustomerRequest.toCustomModel(previousValue: CustomerResponse): CustomerModel {
    return CustomerModel(id = previousValue.id, name = this.name, email = this.email, status = previousValue.status)
}

fun PostBookRequest.toCustomBookModel(customer: CustomerModel): BooksModel {
    return BooksModel(
        name = this.name,
        price = this.price,
        status = EnumBooks.Ativo,
        customer = customer
    )
}

fun PutBookRequest.toCustomUpdate(previousValue: BooksModel): BooksModel {
    return BooksModel(
        id = previousValue.id,
        name = this.name ?: previousValue.name,
        price = this.price ?: previousValue.price,
        status = previousValue.status,
        customer = previousValue.customer


    )
}
//Ideal e retornar nas requestes valores pre determinados nao o modelo completo do banco,por isso criado o response
//Model e a modelagem do banco, por isso nao e aconselhado. Response podemos determinar retornar alguns valores, algo que nao e
//possível so com model

fun CustomerModel.toResponse(): CustomerResponse {
    return CustomerResponse(
        id = this.id,
        email = this.email,
        name = this.name,
        status = this.status
    )

}

fun BooksModel.toResponse(): BookResponse {
    return BookResponse(
        id = this.id,
        name = this.name,
        price = this.price,
        customer = this.customer,
        status = this.status
    )
}