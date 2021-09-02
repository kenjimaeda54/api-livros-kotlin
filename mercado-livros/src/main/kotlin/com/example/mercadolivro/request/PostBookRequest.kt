package com.example.mercadolivro.request

import com.fasterxml.jackson.annotation.JsonAlias

import java.math.BigDecimal
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class PostBookRequest(

    @field:NotEmpty(message = "Name can't be empty")
    var name: String,

    @field: NotNull(message = "Price need be informed")
    var price: BigDecimal,
    //variável vem em snack case entao com jsonALias eu faco um apelido

    @field:NotEmpty(message = "Customer Id can't be empty")
    @JsonAlias("customer_id")
    val customerId: Int
)
