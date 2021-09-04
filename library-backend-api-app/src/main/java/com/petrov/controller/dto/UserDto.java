package com.petrov.controller.dto;

import java.util.List;

public class UserDto {

    private Long id;

    private String username;

    private Integer age;

    private String password;

    private List<String> books;

    public UserDto(Long id, String username, Integer age, List<String> books) {
        this.id = id;
        this.username = username;
        this.age = age;
        this.books = books;
    }

    public UserDto(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getBooks() {
        return books;
    }

    public void setBooks(List<String> books) {
        this.books = books;
    }
}

