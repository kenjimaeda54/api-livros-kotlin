package com.example.mercadolivro.controler

import com.example.mercadolivro.extension.toCustomModel
import com.example.mercadolivro.model.CustomerModel
import com.example.mercadolivro.request.PostCustomerRequest
import com.example.mercadolivro.request.PutCustomerRequest
import com.example.mercadolivro.service.CustomService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
//as rotas boa pratica do Rest e sempre plural
@RequestMapping("customers")
class CustomController(
    val customService: CustomService
) {

    //camada controller apenas executa os controller,quem fica com a logica e a camada service

    @GetMapping
    //para pegar o request por parametro(?name=Beatriz), uso RequestParam
    fun customers(@RequestParam name: String?): List<CustomerModel> {
        return customService.customers(name)
    }

    @PostMapping
    //alterei o http para o 201. Porque o http que retornava e o 200(generico). 201 especifico para criacao
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody customer: PostCustomerRequest) {
        customService.create(customer.toCustomModel())
    }

    //para pegar um valor dinâmico utilizo o uso do {‘id’}
    @GetMapping("/{id}")
    fun getId(@PathVariable id: Int): CustomerModel {
        return customService.getId(id)
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody customer: PutCustomerRequest) {
        customService.update(customer.toCustomModel(id))

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) {
        customService.delete(id)
    }

}