package com.example.mercadolivro.exception

import com.example.mercadolivro.response.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class ControllerAdvice {
    //a ‘interface’ exception esta sendo subscrita mela classe NotFound, então por isso tem os construtores message e errorInternal
    @ExceptionHandler(NotFoundException::class)
    fun handleException(ex: NotFoundException, request: WebRequest): ResponseEntity<ErrorResponse> {
        val error = ErrorResponse(
            ex.message,
            HttpStatus.NOT_FOUND.value(),
            ex.errorInternal,
            null
        )
        return ResponseEntity(error, HttpStatus.NOT_FOUND)

    }

}