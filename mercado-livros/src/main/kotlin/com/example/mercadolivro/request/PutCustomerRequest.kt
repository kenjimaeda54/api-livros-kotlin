package com.example.mercadolivro.request

import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty


data class PutCustomerRequest(
    @field:NotEmpty(message = "Name can't be empty")
    var name: String,
    @field:Email(message = "Email need be valid")
    var email: String
)