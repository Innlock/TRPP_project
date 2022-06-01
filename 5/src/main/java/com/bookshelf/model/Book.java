package com.bookshelf.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

/**
 * class Book - an entity that stores the information from eponymous table.
 * All the values are converted to json entities.
 */
@Table(name = "book", schema = "public")
@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String author;
    private String genre;
    private String description;

    @Column(name="state_book")
    private String state;

    private Long year;
    private Long cost;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "book")
    private Advert advert;

    public Book(){

    }

    public Book(String name, String author, String genre, String description, Long year, Long cost) {
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.description = description;
        this.year = year;
        this.cost = cost;
    }
}
