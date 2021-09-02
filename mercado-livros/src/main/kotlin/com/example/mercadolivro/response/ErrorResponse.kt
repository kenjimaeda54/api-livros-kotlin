package com.example.mercadolivro.response

data class ErrorResponse(
    var message: String,
    var HttpCode: Int,
    var internalCode: String,
    var erros: List<FieldErros>?
)