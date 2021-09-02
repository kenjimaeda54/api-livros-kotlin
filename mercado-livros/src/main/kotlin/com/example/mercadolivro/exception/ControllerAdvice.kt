package com.example.mercadolivro.exception

import com.example.mercadolivro.enum.Erros
import com.example.mercadolivro.response.ErrorResponse
import com.example.mercadolivro.response.FieldErros
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class ControllerAdvice {
    //a ‘interface’ exception esta sendo subscrita mela classe NotFound, então por isso tem os construtores message e errorInternal
    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoundException(ex: NotFoundException, request: WebRequest): ResponseEntity<ErrorResponse> {
        val error = ErrorResponse(
            ex.message,
            HttpStatus.NOT_FOUND.value(),
            ex.errorInternal,
            null
        )
        return ResponseEntity(error, HttpStatus.NOT_FOUND)

    }

    @ExceptionHandler(BadRequestException::class)
    fun handleBadRequestException(ex: BadRequestException, request: WebRequest): ResponseEntity<ErrorResponse> {
        val error = ErrorResponse(
            ex.message,
            HttpStatus.BAD_REQUEST.value(),
            ex.errorInternal,
            null,

            )
        return ResponseEntity(error, HttpStatus.BAD_REQUEST)
    }

    //usamos uma classe pronta do java, nao criamos a nossa,porque o erro e gerado pelo sistema, nao por nos
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(
        ex: MethodArgumentNotValidException,
        request: WebRequest
    ): ResponseEntity<ErrorResponse> {
        val error = ErrorResponse(
            //usamos direto o enum,porque erro e lançado pelo sistema, então nao possuímos,  a nossa classe para  o nosso erro
            //exemplo anterior foi usado o ex.message,porque o erro foi lançado por nos.
            Erros.ML_0001.message,
            HttpStatus.UNPROCESSABLE_ENTITY.value(),
            Erros.ML_0001.code,
            ex.bindingResult.fieldErrors.map { FieldErros(it.defaultMessage ?: "invalid", it.field) }
        )
        return ResponseEntity(error, HttpStatus.UNPROCESSABLE_ENTITY)
    }

}