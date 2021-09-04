package com.petrov.service;

import com.petrov.controller.dto.BookDto;
import com.petrov.controller.dto.UserDto;

import java.util.List;
import java.util.Optional;


public interface UserService {
    Optional<UserDto> findById(Long id);

    void save(UserDto userDto);

    void deleteById(Long id);

    List<UserDto> findAll();

    void saveBook(UserDto userDto, BookDto bookDto);

    void deleteBook(UserDto userDto, BookDto bookDto);
}
