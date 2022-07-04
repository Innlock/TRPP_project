package com.bookshelf.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * class User - an entity that stores the information from eponymous table.
 * All the values are converted to json entities.
 */
@Table(name = "users", schema = "public")
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private Long telephone;
    private String email;
    private Boolean isAdmin;

    /**
     * All the adverts of the same user will be added to that user thanks to this link between the classes.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Advert> adverts = new ArrayList<>();


    public User(String username, String password, String email, Long telephone) {
        this.username = username;
        this.password = password;
        this.telephone = telephone;
        this.email = email;
        this.isAdmin = false;
    }

    public User() {

    }
}