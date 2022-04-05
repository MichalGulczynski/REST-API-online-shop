package com.pracownia.spring.controllers;

import com.pracownia.spring.entities.Asortyment;
import com.pracownia.spring.services.AsortymentService;
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
import java.util.Random;
import java.util.UUID;

/**
 * Product controller.
 */
@RestController
@RequestMapping("/api")
public class AsortymentController {

    @Autowired
    private AsortymentService asortymentService;

    /**
     * List all products.
     *
     */
    @GetMapping(value = "/asortyment", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Asortyment> list(Model model) {
        return asortymentService.listAllAsortyments();
    }

    // Only for redirect!
    @ApiIgnore
    @RequestMapping(value = "/asortyment", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Asortyment> redirect(Model model) {
        return asortymentService.listAllAsortyments();
    }

    /**
     * View a specific product by its id.
     *
     * @return
     */
    @GetMapping(value = "/asortyment/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Asortyment getByPublicId(@PathVariable("id") Integer publicId) {
        return asortymentService.getAsortymentById(publicId).orElseGet(null);
    }

    /**
     * View a specific product by its id.
     *
     * @return
     */
    /*
    @ApiIgnore
    @GetMapping(value = "/asortyment", produces = MediaType.APPLICATION_JSON_VALUE)
    public Asortyment getByParamPublicId(@RequestParam("id") Integer publicId) {
        return asortymentService.getAsortymentById(publicId).orElseGet(null);
    }
     */
    @Transactional
    @GetMapping(value = "/asortyment/ifexist/{id}")
    public boolean checkIfExist(@RequestParam("id") Integer publicId) {
        return asortymentService.checkIfExist(publicId);
    }
    /**
     * Save product to database.
     *
     */
    @PostMapping(value = "/asortyment")
    public ResponseEntity<Asortyment> create(@RequestBody @NonNull @Valid Asortyment asortyment) {
        //Random rand = new Random();
       // asortyment.setId(rand.nextInt());
        asortymentService.saveAsortyment(asortyment);
        return ResponseEntity.ok().body(asortyment);
    }


    /**
     * Edit product in database.
     *
     */
    @PutMapping(value = "/asortyment")
    public ResponseEntity<Void> edit(@RequestBody Asortyment asortyment) {
        if(!asortymentService.checkIfExist(asortyment.getId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            asortymentService.saveAsortyment(asortyment);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    /**
     * Delete product by its id.
     *
     */
    @DeleteMapping(value = "/asortyment/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        asortymentService.deleteAsortyment(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    /*
    @DeleteMapping(value = "/asortyment/{id}")
    public ResponseEntity deleteBadRequest(@PathVariable Integer id) {
        return new ResponseEntity(HttpStatus.FORBIDDEN);
    }
    */

    @GetMapping(value = "/asortyment/{page}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Asortyment> list(@PathVariable("page") Integer pageNr,@RequestParam("size") Optional<Integer> howManyOnPage) {
        return asortymentService.listAllAsortymentsPaging(pageNr, howManyOnPage.orElse(2));
    }

    @Transactional
    @GetMapping(value = "/asortyment/asortymentbyshopid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Asortyment> listAsortymentByShopIdPaging(@PathVariable("id") Integer id, @RequestParam("page") Integer pageNr,@RequestParam("size") Optional<Integer> howManyOnPage) {
        return asortymentService.listAsortymentByShopIdPaging(id,pageNr, howManyOnPage.orElse(2));
    }

    @Transactional
    @GetMapping(value = "/asortyment/selectmostexpensive", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Asortyment> selectMostExpensiveAsortyment(){
        return asortymentService.selectMostExpensiveAsortyment();
    }
}
