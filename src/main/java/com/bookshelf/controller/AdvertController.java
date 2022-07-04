package com.bookshelf.controller;

import com.bookshelf.model.Advert;
import com.bookshelf.model.Book;
import com.bookshelf.model.User;
import com.bookshelf.repository.AdvertRepository;
import com.bookshelf.repository.BookRepository;
import com.bookshelf.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * AdvertController - request handler for adverts
 */
@Controller
public class AdvertController {

    @Autowired
    private AdvertRepository advertRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;

    /**
     * Post request will extract all the info from json and create an entity class out of it.
     *
     * @param advert (json)
     * @return advert json (if it was successfully saved)
     */
    @PostMapping("/adverts")
    public Advert create(@RequestBody Advert advert) {
        if (advert.getDate() == null) {
            advert.setDate(new Date(System.currentTimeMillis()));
        }
        return advertRepository.save(advert);
    }

    @GetMapping("/create_ad")
    public String greeting(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if ((!(auth instanceof AnonymousAuthenticationToken)) && auth != null) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();

            if (userDetail != null) {
                model.addAttribute("username", userDetail.getUsername());
            } else {
                model.addAttribute("username", "");
            }
        }
        return "create_ad";
    }

    @RequestMapping(value = "/create_ad", method = RequestMethod.POST)
    public String create_ad(@RequestParam String book_name,
                            @RequestParam String book_author,
                            @RequestParam String book_desc,
                            @RequestParam String book_year,
                            @RequestParam String book_state,
                            @RequestParam String book_genre,
                            @RequestParam String book_cost,
                            Map<String, Object> model) {
        if (book_name == "" || book_author == "" || book_genre.isEmpty()) {
            model.put("message", "Не вся информация заполнена");
            return "create_ad";
        }
        if (book_desc.isEmpty()) {
            book_desc = "Описания нет";
        }
        if (book_state.isEmpty()) {
            book_state = "Не указано";
        }
        if (book_cost.isEmpty()) {
            book_cost = "0";
        }
        if (book_year.isEmpty()) {
            book_year = "0000";
        }
        Book book = new Book(book_name,
                book_author,
                book_genre,
                book_desc,
                book_state,
                Long.parseLong(book_year),
                Long.parseLong(book_cost)
        );

        Long book_id = bookRepository.save(book).getId();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetail = (UserDetails) auth.getPrincipal();
        Optional user = userRepository.findByUsername(userDetail.getUsername());
        if (user.isPresent()) {
            Long user_id = User.class.cast(user.get()).getId();
            Advert advert = new Advert(
                    user_id,
                    book_id,
                    "active",
                    new Date()
            );
            advertRepository.save(advert);
        }
        return "redirect:/";
    }

    /**
     * Get request will convert class entity to json and return it (of id is specified) or them.
     *
     * @param id id specified in the link
     * @return advert (with the specified id) or adverts (json)
     */
    @GetMapping(value = {"/adverts", "/adverts/{id}"})
    public String getAdvert(@PathVariable(required = false) Long id, Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if ((!(auth instanceof AnonymousAuthenticationToken)) && auth != null) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();

            if (userDetail != null) {
                model.addAttribute("username", userDetail.getUsername());
            } else {
                model.addAttribute("username", "");
            }
        }

        if (id != null) {
            List<Advert> adverts = new ArrayList<>();
            model.addAttribute("adverts", adverts);
            adverts.add(advertRepository.findById(id).orElse(null));
            return "advert";
        }
        return "adverts";
    }

    /**
     * Patch request will call the markAsSold(id) function that changes "state" of advert to "sold".
     *
     * @param id id specified in the link
     */
    @PatchMapping("/adverts/{id}:mark-as-sold")
    public void patchMethod(@PathVariable Long id) {
        advertRepository.markAsSold(id);
    }
}
