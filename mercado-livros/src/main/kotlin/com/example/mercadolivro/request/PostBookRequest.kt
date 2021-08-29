package com.example.mercadolivro.request

import com.fasterxml.jackson.annotation.JsonAlias

import java.math.BigDecimal

data class PostBookRequest(
    var name: String,
    var price: BigDecimal,
    //variável vem em snack case entao com jsonALias eu faco um apelido
    @JsonAlias("customer_id")
    val customerId: Int
)
