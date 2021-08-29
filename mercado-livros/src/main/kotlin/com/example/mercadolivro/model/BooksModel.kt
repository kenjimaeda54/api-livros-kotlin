package com.example.mercadolivro.model

import com.example.mercadolivro.enum.EnumBooks
import java.math.BigDecimal
import javax.persistence.*

@Entity(name = "book")
data class BooksModel (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column
    var name: String,

    @Column
    var price: BigDecimal,

    @Column
    @Enumerated(EnumType.STRING)
    var status: EnumBooks? = null,

    @ManyToOne
    @JoinColumn(name="customer_id")
    var customer: CustomerModel? = null

)

