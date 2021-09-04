package com.petrov.controller;

import com.petrov.controller.dto.BookDto;
import com.petrov.controller.dto.UserDto;
import com.petrov.service.UserService;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    // отображение всех пользователей
    @GetMapping(path = "/all", produces = "application/json")
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    // отображение пользователя по ID
    @GetMapping(path = "/{id}", produces = "application/json")
    public UserDto findById(@PathVariable("id") Long id) {
        return userService.findById(id)
                .orElseThrow(()-> new NotFoundException("User not found"));
    }

    // создание пользователя
    @PostMapping(produces = "application/json")
    public UserDto create(@RequestBody UserDto userDto) throws BadRequestException {
        if(userDto.getId() != null){
            throw new BadRequestException("Request false");
        }
        userService.save(userDto);
        return userDto;
    }

    // обновление пользователя
    @PutMapping(produces = "application/json")
    public void update(@RequestBody UserDto userDto) throws BadRequestException {
        if(userDto.getId() == null){
            throw new BadRequestException("Request false");
        }
        userService.save(userDto);
    }

    // добавление книги в коллекцию пользователя
    @PutMapping(path = "/book/{id}", produces = "application/json")
    public void updateBooks(@PathVariable("id") Long id, @RequestBody BookDto bookDto) throws BadRequestException {
        if(bookDto.getId() == null){
            throw new BadRequestException("Request false");
        }
        userService.saveBook(userService.findById(id).get(), bookDto);
    }

    // удаление книги из коллекции пользователя
    @PutMapping(path = "/delete_book/{id}", produces = "application/json")
    public void deleteBooks(@PathVariable("id") Long id, @RequestBody BookDto bookDto) throws BadRequestException {
        if(bookDto.getId() == null){
            throw new BadRequestException("Request false");
        }
        userService.deleteBook(userService.findById(id).get(), bookDto);
    }

    // удаление пользователя
    @DeleteMapping(path = "/{id}", produces = "application/json")
    public void delete(@PathVariable("id") Long id) {
        userService.deleteById(id);
    }
}
