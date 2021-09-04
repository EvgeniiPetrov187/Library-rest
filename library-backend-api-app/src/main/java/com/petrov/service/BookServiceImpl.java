package com.petrov.service;


import com.petrov.controller.NotFoundException;
import com.petrov.controller.dto.BookDto;
import com.petrov.persist.AuthorRepository;
import com.petrov.persist.BookRepository;
import com.petrov.persist.CategoryRepository;
import com.petrov.persist.model.Author;
import com.petrov.persist.model.Book;
import com.petrov.persist.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;
    private final AuthorRepository authorRepository;


    @Autowired
    public BookServiceImpl(BookRepository bookRepository, CategoryRepository categoryRepository,
                           AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public Optional<BookDto> findById(Long id) {
        return bookRepository.findById(id)
                .map(book -> new BookDto(book.getId(),
                        book.getTitle(),
                        book.getYear(),
                        book.getCategory().getTitle(),
                        book.getAuthor().getAuthorName(),
                        book.getUsersNames()));
    }

    @Override
    @Transactional
    public void save(BookDto bookDto) {
        Book book = (bookDto.getId() != null) ? bookRepository.findById(bookDto.getId())
                .orElseThrow(() -> new NotFoundException("")) : new Book();
        Category category = categoryRepository.findCategoryByTitle(bookDto.getCategory())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        Author author = authorRepository.findAuthorByAuthorName(bookDto.getAuthor())
                .orElseThrow(() -> new RuntimeException("Author not found"));

        book.setTitle(bookDto.getTitle());
        book.setYear(bookDto.getYear());
        book.setCategory(category);
        book.setAuthor(author);

        bookRepository.save(book);
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<BookDto> findAll() {
        return bookRepository.findAll().stream()
                .map(book -> new BookDto(book.getId(),
                        book.getTitle(),
                        book.getYear(),
                        book.getCategory().getTitle(),
                        book.getAuthor().getAuthorName(),
                        book.getUsersNames()
                        ))
                .collect(Collectors.toList());
    }

}


