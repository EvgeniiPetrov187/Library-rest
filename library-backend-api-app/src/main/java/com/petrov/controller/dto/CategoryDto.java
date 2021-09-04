package com.petrov.controller.dto;

import java.util.List;


public class CategoryDto {

    private Long id;

    private String title;

    private String description;

    private List<String> books;

    public CategoryDto (Long id, String title, String description, List books) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.books = books;
    }

    public CategoryDto () {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getBooks() {
        return books;
    }

    public void setBooks(List<String> books) {
        this.books = books;
    }
}
