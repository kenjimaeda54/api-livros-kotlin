package com.example.mercadolivro.controler


import com.example.mercadolivro.extension.toCustomBookModel
import com.example.mercadolivro.request.PostBookRequest
import com.example.mercadolivro.service.BookService
import com.example.mercadolivro.service.CustomService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("books")
class BookController(
    var bookService: BookService,
    var customerService: CustomService

) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: PostBookRequest) {
        val customer = customerService.getId(request.customerId)
        bookService.create(request.toCustomBookModel(customer))

    }

}