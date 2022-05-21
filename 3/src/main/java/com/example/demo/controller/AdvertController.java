package com.example.demo.controller;

import com.example.demo.model.Advert;
import com.example.demo.repository.AdvertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class AdvertController {

    @Autowired
    private AdvertRepository advertRepository;


    @PostMapping("/adverts")
    public Advert create(@RequestBody Advert advert) {
        if (advert.getDate() == null) {
            advert.setDate( new Date(System. currentTimeMillis()) );
        }
        return advertRepository.save(advert);
    }


    @GetMapping(value = {"/adverts", "/adverts/{id}"})
    public List<Advert> getAdvert(@PathVariable(required = false) Long id){
        if (id != null) {
            List<Advert> adverts = new ArrayList<>();
            adverts.add(advertRepository.findById(id).orElse(null));
            return adverts;
        }
        return (List<Advert>) advertRepository.findAll();
    }

    @PatchMapping("/adverts/{id}:mark-as-sold")
    public void patchMethod(@PathVariable Long id){
        advertRepository.markAsSold(id);
    }
}
