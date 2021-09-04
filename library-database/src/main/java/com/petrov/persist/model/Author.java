package com.petrov.persist.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

// автор
@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "author_name")
    private String authorName;

    @Column(nullable = false, name = "birth_day")
    private String birthDay;

    @Column(nullable = false)
    private String biography;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> books;

    public Author() {
    }

    public Author(Long id, String authorName, String birthDay, String biography) {
        this.id = id;
        this.authorName = authorName;
        this.birthDay = birthDay;
        this.biography = biography;
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

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<String> getBooksTitles() {
        List<String> list = new ArrayList<>();
        for (Book book : this.books) {
            list.add(book.getTitle());
        }
        return list;
    }
}