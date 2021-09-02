package com.example.mercadolivro.reposytory

import com.example.mercadolivro.controler.customerResponse.CustomerResponse
import com.example.mercadolivro.enum.EnumBooks
import com.example.mercadolivro.model.BooksModel
import com.example.mercadolivro.model.CustomerModel
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

interface BookRepository: JpaRepository<BooksModel,Int> {
    fun findByStatus(ativo: EnumBooks, pageable: Pageable): Page<BooksModel>
    fun findByCustomer(customer: CustomerResponse): List<BooksModel>
}