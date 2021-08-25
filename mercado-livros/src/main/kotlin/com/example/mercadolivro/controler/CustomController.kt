package com.example.mercadolivro.controler

import com.example.mercadolivro.model.CustomerModel
import com.example.mercadolivro.request.PostCustomerRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
//as rotas boa pratica e sempre plural
@RequestMapping("customers")
class CustomController {

    val customers =  mutableListOf<CustomerModel>()

    @GetMapping
    fun customers(): MutableList<CustomerModel> {
        return customers
    }

    @PostMapping
    //alterei o http para o 201. Porque o http que retornava e o 200(generico). 201 especifico para criacao
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody customer: PostCustomerRequest) {
        //no koltin a variavel consegue assumir o valor do if
      val id = if(customers.isEmpty()){
             1
      }else{
          //primeiro preciso verificar se estava vazio. Last()  pega o valor anterior adicionado,mas caso for vazio retorna exception.
          //Então trato se esta vazio e depois somo
          customers.last().id.toInt() + 1
      }.toString()
        customers.add(CustomerModel(id,customer.email,customer.name))
    }

}