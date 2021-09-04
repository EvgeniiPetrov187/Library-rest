package com.petrov.controller;

import com.petrov.controller.dto.AuthorDto;
import com.petrov.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorResource {
    private final AuthorService authorService;

    public AuthorResource(AuthorService authorService) {
        this.authorService = authorService;
    }

    // отображение всех авторов
    @GetMapping(path = "/all", produces = "application/json")
    public List<AuthorDto> findAll() {
        return authorService.findAll();
    }


    // отображение автора по ID
    @GetMapping(path = "/{id}", produces = "application/json")
    public AuthorDto findById(@PathVariable("id") Long id) {
        return authorService.findById(id)
                .orElseThrow(()-> new NotFoundException("User not found"));
    }

    // создание автора
    @PostMapping(produces = "application/json")
    public AuthorDto create(@RequestBody AuthorDto authorDto) throws BadRequestException {
        if(authorDto.getId() != null){
            throw new BadRequestException("Request false");
        }
        authorService.save(authorDto);
        return authorDto;
    }

    // обновление автора
    @PutMapping(produces = "application/json")
    public void update(@RequestBody AuthorDto authorDto) throws BadRequestException {
        if(authorDto.getId() == null){
            throw new BadRequestException("Request false");
        }
        authorService.save(authorDto);
    }

    // удаление автора
    @DeleteMapping(path = "/{id}", produces = "application/json")
    public void delete(@PathVariable("id") Long id) {
        authorService.deleteById(id);
    }
}
