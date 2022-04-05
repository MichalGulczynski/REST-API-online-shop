package com.pracownia.spring.controllers;

import com.pracownia.spring.entities.Sklep;
import com.pracownia.spring.entities.Wlasciciel;
import com.pracownia.spring.services.SklepService;
import com.pracownia.spring.services.WlascicielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class WlascicielController {
    @Autowired
    private WlascicielService wlascicielService;

    /**
     * List all products.
     *
     */
    @GetMapping(value = "/wlasciciel", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Wlasciciel> list(Model model) {
        return wlascicielService.listAllWlasciciels();
    }

    // Only for redirect!

    @ApiIgnore
    @RequestMapping(value = "/wlasciciel", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Wlasciciel> redirect(Model model) {
        return wlascicielService.listAllWlasciciels();
    }



    /**
     * View a specific product by its id.
     *
     * @return
     */
    @GetMapping(value = "/wlasciciel/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Wlasciciel getByPublicId(@RequestParam("id") Integer id) {
        return wlascicielService.getWlascicielById(id).orElseGet(null);
    }

    /**
     * View a specific product by its id.
     *
     * @return
     */


    /**
     * Save product to database.
     *
     */
    @PostMapping(value = "/wlasciciel")
    public ResponseEntity<Wlasciciel> create(@RequestBody @NonNull @Valid Wlasciciel wlasciciel) {
        wlascicielService.saveWlasciciel(wlasciciel);
        return ResponseEntity.ok().body(wlasciciel);
    }


    /**
     * Edit product in database.
     *
     */
    @PutMapping(value = "/wlasciciel")
    public ResponseEntity<Void> edit(@RequestBody Wlasciciel wlasciciel) {
        if(!wlascicielService.checkIfWlascicielExists(wlasciciel.getIdWlasciciela()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            wlascicielService.saveWlasciciel(wlasciciel);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    /**
     * Delete product by its id.
     *
     */
    @DeleteMapping(value = "/wlasciciel/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        wlascicielService.deleteWlasciciel(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping(value = "/wlasciciel/{page}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Wlasciciel> list(@PathVariable("page") Integer pageNr,@RequestParam("size") Optional<Integer> howManyOnPage) {
        return wlascicielService.listAllWlascicielsPaging(pageNr, howManyOnPage.orElse(2));
    }
}
