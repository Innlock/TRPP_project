package com.bookshelf.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;


/**
 * class Advert - an entity that stores the information from eponymous table.
 * All the values are converted to json entities.
 */
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

    /**
     * All the adverts of the same user will be added to that user thanks to this link between the classes.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid", insertable = false, updatable = false)
    @JsonIgnore
    private User user;
}
