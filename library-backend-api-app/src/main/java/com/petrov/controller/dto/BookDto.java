package com.petrov.controller.dto;

import java.util.List;

public class BookDto {

    private Long id;

    private String title;

    private Integer year;

    private String category;

    private String author;

    private List users;

    public BookDto(Long id, String title, Integer year, String category, String author, List users) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.category = category;
        this.author = author;
        this.users = users;
    }

    public BookDto() {
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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<String> getUsers() {
        return users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }
}



