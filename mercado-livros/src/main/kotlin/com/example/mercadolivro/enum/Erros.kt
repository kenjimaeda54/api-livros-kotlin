package com.example.mercadolivro.enum

enum class Erros(val message: String, val code: String) {
    //quando for usar o enum, possui recurso interessante que e format(variável) consigo passar para o %s,valor dinamico
    //centralizar os erros facilita a manutenção
    //sfith F6 eu renomeio todos os variáveis com o valor
    ML_0001("Invalid Request", "ML-0001"),
    ML_1001("Book [%s] don't  exists", "ML-1001"),
    ML_1002("Cannot update book with status [%s]", "ML-1001"),
    ML_2000("Customer [%s] don't exists", "ML-1002")
}