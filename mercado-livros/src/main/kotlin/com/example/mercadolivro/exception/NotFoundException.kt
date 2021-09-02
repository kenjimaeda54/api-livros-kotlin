package com.example.mercadolivro.exception

//ja existe no Exception mensagem, por isso subscreveu valor
class NotFoundException(override var message: String , var errorInternal: String) : Exception() {
}