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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookid", insertable = false, updatable = false)
    @JsonIgnore
    private Book book;

    private Advert() {

    }
    public Advert(Long userid, Long bookid, String state, Date date) {
        this.userid = userid;
        this.bookid = bookid;
        this.state = state;
        this.date = date;
    }




}
