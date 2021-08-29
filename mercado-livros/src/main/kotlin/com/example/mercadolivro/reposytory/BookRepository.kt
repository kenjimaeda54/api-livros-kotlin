package com.example.mercadolivro.reposytory

import com.example.mercadolivro.model.BooksModel
import org.springframework.data.repository.CrudRepository

interface BookRepository: CrudRepository<BooksModel,Int> {
}