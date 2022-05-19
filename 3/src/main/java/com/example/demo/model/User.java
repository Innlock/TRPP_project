package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

@Table(name = "users", schema = "public")
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long UniqueID;
    private String username;
    private String password;
    private Long telephone;
    private String email;
    private Boolean isAdmin;
}