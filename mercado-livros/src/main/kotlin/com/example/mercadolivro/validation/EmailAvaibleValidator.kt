package com.example.mercadolivro.validation

import com.example.mercadolivro.service.CustomerService
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

//ao lado e o tipo do campo que pretendo validar por isso <EmailAvailable,String>
class EmailAvaibleValidator(var customerService: CustomerService) : ConstraintValidator<EmailAvailable, String> {

    override fun isValid(value: String, context: ConstraintValidatorContext?): Boolean {
        if (value.isEmpty()) {
            return false
        }
        return customerService.validateEmail(value)
    }

}
