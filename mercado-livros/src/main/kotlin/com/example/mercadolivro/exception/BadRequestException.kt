package com.example.mercadolivro.exception

class BadRequestException(override var message: String, var errorInternal: String) : Exception() {
}