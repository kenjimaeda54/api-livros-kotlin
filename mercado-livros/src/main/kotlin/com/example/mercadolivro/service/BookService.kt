package com.example.mercadolivro.service

import com.example.mercadolivro.controler.customerResponse.CustomerResponse
import com.example.mercadolivro.enum.EnumBooks
import com.example.mercadolivro.exception.NotFoundException
import com.example.mercadolivro.model.BooksModel
import com.example.mercadolivro.reposytory.BookRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class BookService(val repository: BookRepository) {

    fun save(customer: BooksModel) {
        repository.save(customer)
    }

    fun findAll(pageable: Pageable): MutableIterable<BooksModel> = repository.findAll(pageable)

    fun findActive(pageable: Pageable): Page<BooksModel> {
        return repository.findByStatus(EnumBooks.Ativo, pageable)
    }

    fun getId(id: Int): BooksModel {
        //erro interno ML-0001 e para controle interno,por exemplo se eu documentar isto e possivel rastrear este erro
        return repository.findById(id).orElseThrow { NotFoundException("Don't exist book [$id]", "Ml-0001") }
    }

    fun delete(id: Int) {
        val book = getId(id)
        book.status = EnumBooks.CANCELADO

        repository.save(book)

    }

    fun update(books: BooksModel) {
        repository.save(books)
    }

    fun deleteByCustomer(customer: CustomerResponse) {
        val books = repository.findByCustomer(customer)
        books.forEach {
            it.status = EnumBooks.DELETADO
        }
        repository.saveAll(books)
    }


}