package com.example.mercadolivro.controler


import com.example.mercadolivro.controler.booksReponse.BookResponse
import com.example.mercadolivro.extension.toCustomBookModel
import com.example.mercadolivro.extension.toCustomUpdate
import com.example.mercadolivro.extension.toResponse
import com.example.mercadolivro.request.PostBookRequest
import com.example.mercadolivro.request.PutBookRequest
import com.example.mercadolivro.service.BookService
import com.example.mercadolivro.service.CustomerService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("books")
class BookController(
    var bookService: BookService,
    var customerService: CustomerService

) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: PostBookRequest) {
        val customer = customerService.getId(request.customerId)
        bookService.save(request.toCustomBookModel(customer))
    }

    @GetMapping
    fun getAll(@PageableDefault(page = 0,size = 10)pageable: Pageable) = bookService.findAll(pageable)

    @GetMapping("/active")
    fun findActive(@PageableDefault(page=0,size = 10)pageable:Pageable): Page<BookResponse> {
        return bookService.findActive(pageable).map { it.toResponse() }
    }

    @GetMapping("/{id}")
    fun getId(@PathVariable id: Int): BookResponse {
        return bookService.getId(id).toResponse()
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) {
        bookService.delete(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody book: PutBookRequest) {
        val bookSelect = bookService.getId(id)
        bookService.update(book.toCustomUpdate(bookSelect))
    }

}