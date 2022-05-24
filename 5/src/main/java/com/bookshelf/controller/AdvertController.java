package com.bookshelf.controller;

import com.bookshelf.model.Advert;
import com.bookshelf.model.Book;
import com.bookshelf.repository.AdvertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * AdvertController - request handler for adverts
 */
@Controller
public class AdvertController {

    @Autowired
    private AdvertRepository advertRepository;

    /**
     * Post request will extract all the info from json and create an entity class out of it.
     * @param advert (json)
     * @return advert json (if it was successfully saved)
     */
    @PostMapping("/adverts")
    public Advert create(@RequestBody Advert advert) {
        if (advert.getDate() == null) {
            advert.setDate( new Date(System. currentTimeMillis()) );
        }
        return advertRepository.save(advert);
    }

    /**
     * Get request will convert class entity to json and return it (of id is specified) or them.
     * @param id id specified in the link
     * @return advert (with the specified id) or adverts (json)
     */
    @GetMapping(value = {"/adverts", "/adverts/{id}"})
    public String getAdvert(@PathVariable(required = false) Long id, Model model){
        if (id != null) {
            List<Advert> adverts = new ArrayList<>();
            adverts.add(advertRepository.findById(id).orElse(null));
            return "advert";
        }
        //return (List<Advert>) advertRepository.findAll();
        Iterable<Advert> adverts = advertRepository.findAll();
        model.addAttribute("adverts", adverts);
        return "adverts";
    }

    /**
     * Patch request will call the markAsSold(id) function that changes "state" of advert to "sold".
     * @param id id specified in the link
     */
    @PatchMapping("/adverts/{id}:mark-as-sold")
    public void patchMethod(@PathVariable Long id){
        advertRepository.markAsSold(id);
    }
}
