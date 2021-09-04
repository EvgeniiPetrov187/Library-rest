package com.petrov.service;

import com.petrov.controller.dto.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Optional<BookDto> findById(Long id);

    void save(BookDto bookDto);

    void deleteById(Long id);

   List<BookDto> findAll();

}
