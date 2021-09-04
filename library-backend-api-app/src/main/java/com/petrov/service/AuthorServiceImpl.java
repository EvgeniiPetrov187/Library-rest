package com.petrov.service;

import com.petrov.controller.dto.AuthorDto;
import com.petrov.persist.AuthorRepository;
import com.petrov.persist.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    public Optional<AuthorDto> findById(Long id) {
        return authorRepository.findById(id)
                .map(author -> new AuthorDto(author.getId(),
                        author.getAuthorName(),
                        author.getBirthDay(),
                        author.getBiography(),
                        author.getBooksTitles()));
    }

    @Override
    public void save(AuthorDto authorDto) {
        Author author = new Author(
                authorDto.getId(),
                authorDto.getAuthorName(),
                authorDto.getBirthDay(),
                authorDto.getBiography());
        authorRepository.save(author);
    }

    @Override
    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public List<AuthorDto> findAll() {
        return authorRepository.findAll().stream()
                .map(author -> new AuthorDto(author.getId(),
                        author.getAuthorName(),
                        author.getBirthDay(),
                        author.getBiography(),
                        author.getBooksTitles()))
                .collect(Collectors.toList());
    }
}

