package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table(name = "advert", schema = "public")
@Data
@Entity
public class Advert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userid;
    private Long bookid;
    private String state;
    private Date date;
}
