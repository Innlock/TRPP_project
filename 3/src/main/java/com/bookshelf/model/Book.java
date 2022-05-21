package com.bookshelf.model;

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
}
