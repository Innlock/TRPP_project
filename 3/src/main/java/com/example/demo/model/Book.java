package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

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
    private String state_book;
    private Long year;
    private Long cost;
}
