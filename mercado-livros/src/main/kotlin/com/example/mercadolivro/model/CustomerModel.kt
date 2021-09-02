package com.example.mercadolivro.model

import com.example.mercadolivro.enum.EnumCustomer
import javax.persistence.*

//mesmo nome da tabela
@Entity(name="customer")
data class CustomerModel(
    @Id
    //se houver outra tabela nao vai possuir relacao com esta, ou seja, e possível ter outra tabela
    //com mesmo id dessa
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column
    var email: String,

    //ja que a minha tabela tem mesmo campo que a minha variável nao preciso especificar
    @Column
    var name: String,

    @Column
    @Enumerated(EnumType.STRING)
    var  status: EnumCustomer
)