package com.example.mercadolivro.controler.booksReponse

import com.example.mercadolivro.enum.EnumBooks
import com.example.mercadolivro.model.CustomerModel
import java.math.BigDecimal

data class BookResponse(

    var id: Int? = null,


    var name: String,


    var price: BigDecimal,


    var customer: CustomerModel? = null,

    var status: EnumBooks?
)
