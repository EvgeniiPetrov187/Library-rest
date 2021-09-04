package com.petrov.controller.dto;

import java.util.List;

public class AuthorDto {

    private Long id;

    private String authorName;

    private String birthDay;

    private String biography;

    private List<String> books;

    public AuthorDto(Long id, String authorName, String birthDay, String biography, List<String> books) {
        this.id = id;
        this.authorName = authorName;
        this.birthDay = birthDay;
        this.biography = biography;
        this.books = books;
    }

    public AuthorDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public List<String> getBooks() {
        return books;
    }

    public void setBooks(List<String> books) {
        this.books = books;
    }
}

