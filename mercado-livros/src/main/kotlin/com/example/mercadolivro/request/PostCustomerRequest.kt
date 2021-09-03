package com.example.mercadolivro.request

import com.example.mercadolivro.validation.EmailAvailable
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty


data class PostCustomerRequest(

    @field:NotEmpty(message = "Name can't be empty")
    var name: String,

    @field:Email(message = "Email need be valid")
    @EmailAvailable
    var email: String
)