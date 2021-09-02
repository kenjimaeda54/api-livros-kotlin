package com.example.mercadolivro.controler.customerResponse

import com.example.mercadolivro.enum.EnumCustomer

data class CustomerResponse(

    var id: Int? = null,

    var email: String,

    var name: String,

    var status: EnumCustomer

)
