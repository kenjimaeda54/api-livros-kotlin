package com.example.mercadolivro.validation

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

//interessante do annotation que a validacao do email fica por nossa conta nao do banco de dados
@Constraint(validatedBy = [EmailAvaibleValidator::class])
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
annotation class EmailAvailable(
    //cuidado com as variáveis precisam ser iguais, groups, payload
    val message: String = "Email is already in use or empty",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)
