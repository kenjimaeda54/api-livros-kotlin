package com.example.mercadolivro.service

import com.example.mercadolivro.model.BooksModel
import com.example.mercadolivro.reposytory.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(val repository: BookRepository) {

    fun create(books: BooksModel) {
        repository.save(books)
    }

}