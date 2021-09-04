package com.petrov.service;


import com.petrov.controller.dto.AuthorDto;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    Optional<AuthorDto> findById(Long id);

    void save(AuthorDto authorDto);

    void deleteById(Long id);

    List<AuthorDto> findAll();

}
