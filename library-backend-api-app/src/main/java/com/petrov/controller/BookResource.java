package com.petrov.controller;

import com.petrov.controller.dto.BookDto;
import com.petrov.service.BookService;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/books")
public class BookResource {

    private final BookService bookService;

    public BookResource(BookService bookService) {
        this.bookService = bookService;
    }

    // отображенеие всех книг
    @GetMapping(path = "/all", produces = "application/json")
    public List<BookDto> findAll() {
       return bookService.findAll();
    }

    // отображенеие книги по ID
    @GetMapping(path = "/{id}", produces = "application/json")
    public BookDto findById(@PathVariable("id") Long id) {
        return bookService.findById(id)
                .orElseThrow(()-> new NotFoundException("Book not found"));
    }


    // создание книги
    @PostMapping(produces = "application/json")
    public BookDto create(@RequestBody BookDto book) throws BadRequestException {
        if(book.getId() != null){
            throw new BadRequestException("Request false");
        }
        bookService.save(book);
        return book;
    }

    // обновление книги
    @PutMapping(produces = "application/json")
    public void update(@RequestBody BookDto book) throws BadRequestException {
        if(book.getId() == null){
            throw new BadRequestException("Request false");
        }
        bookService.save(book);
    }

    // удаление книги
    @DeleteMapping(path = "/{id}", produces = "application/json")
    public void delete(@PathVariable("id") Long id) {
        bookService.deleteById(id);
    }
}
