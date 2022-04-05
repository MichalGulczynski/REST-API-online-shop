package com.pracownia.spring.controllers;


import com.pracownia.spring.entities.Sklep;

import com.pracownia.spring.services.SklepService;
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
public class SklepController {


    @Autowired
    private SklepService sklepService;

    /**
     * List all products.
     *
     */
    @GetMapping(value = "/sklep", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Sklep> list(Model model) {
        return sklepService.listAllSkleps();
    }

    // Only for redirect!

    @ApiIgnore
    @RequestMapping(value = "/sklep", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Sklep> redirect(Model model) {
        return sklepService.listAllSkleps();
    }



    /**
     * View a specific product by its id.
     *
     * @return
     */
    @GetMapping(value = "/sklep/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Sklep getByPublicId(@RequestParam("id") Integer id) {
        return sklepService.getSklepById(id).orElseGet(null);
    }

    /**
     * View a specific product by its id.
     *
     * @return
     */

    /*
    @GetMapping(value = "/sklep", produces = MediaType.APPLICATION_JSON_VALUE)
    public Sklep getByParamPublicId(@RequestParam("id") Integer publicId) {
        return sklepService.getSklepById(publicId).orElseGet(null);
    }
    */

    @Transactional
    @GetMapping(value = "/sklep/howmany/{id}")
    public Integer howManyProducts(@PathVariable Integer id) {
        return sklepService.howManyProducts(id);
    }

    /**
     * Save product to database.
     *
     */
    @PostMapping(value = "/sklep")
    public ResponseEntity<Sklep> create(@RequestBody @NonNull @Valid Sklep sklep) {
        //Random rand = new Random();
        // asortyment.setId(rand.nextInt());
        sklepService.saveSklep(sklep);
        return ResponseEntity.ok().body(sklep);
    }


    /**
     * Edit product in database.
     *
     */
    @PutMapping(value = "/sklep")
    public ResponseEntity<Void> edit(@RequestBody Sklep sklep) {
        if(!sklepService.checkIfSklepExist(sklep.getId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            sklepService.saveSklep(sklep);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    /**
     * Delete product by its id.
     *
     */
    @DeleteMapping(value = "/sklep/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        sklepService.deleteSklep(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
/*
    @DeleteMapping(value = "/sklep/{id}")
    public ResponseEntity deleteBadRequest(@PathVariable Integer id) {
        return new ResponseEntity(HttpStatus.FORBIDDEN);
    }
*/

    @GetMapping(value = "/sklep/{page}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Sklep> list(@PathVariable("page") Integer pageNr,@RequestParam("size") Optional<Integer> howManyOnPage) {
        return sklepService.listAllSklepsPaging(pageNr, howManyOnPage.orElse(2));
    }
}
