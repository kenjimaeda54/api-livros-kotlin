package com.example.mercadolivro.controler

import com.example.mercadolivro.controler.customerResponse.CustomerResponse
import com.example.mercadolivro.extension.toCustomModel
import com.example.mercadolivro.extension.toResponse
import com.example.mercadolivro.request.PostCustomerRequest
import com.example.mercadolivro.request.PutCustomerRequest
import com.example.mercadolivro.service.BookService
import com.example.mercadolivro.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
//as rotas boa pratica do Rest e sempre plural
@RequestMapping("customers")
class CustomController(
    val customerService: CustomerService,
    val booksService: BookService
) {

    //camada controller apenas executa os controller,quem fica com a logica e a camada service

    @GetMapping
    //para pegar o request por parametro(?name=Beatriz), uso RequestParam
    fun customers(@RequestParam name: String?): List<CustomerResponse> {
        return customerService.customers(name).map { it.toResponse() }
    }

    @PostMapping
    //alterei o http para o 201. Porque o http que retornava e o 200(generico). 201 especifico para criacao
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody @Valid customer: PostCustomerRequest) {
        customerService.create(customer.toCustomModel())
    }

    //para pegar um valor dinâmico utilizo o uso do {‘id’}
    @GetMapping("/{id}")
    fun getId(@PathVariable id: Int): CustomerResponse {
        return customerService.getId(id).toResponse()
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody @Valid customer: PutCustomerRequest) {
        val customerService = getId(id)
        this.customerService.update(customer.toCustomModel(customerService))

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) {
        val customer = getId(id)
        booksService.deleteByCustomer(customer)
        customerService.delete(id)
    }

}