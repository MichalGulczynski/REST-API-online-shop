package com.pracownia.spring.controllers;

import com.pracownia.spring.entities.Lokalizacja;
import com.pracownia.spring.entities.Sklep;
import com.pracownia.spring.services.LokalizacjaService;
import com.pracownia.spring.services.LokalizacjaServiceImpl;
import com.pracownia.spring.services.SklepService;
import org.apache.tomcat.jni.Local;
import org.joda.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.swing.text.StyledEditorKit;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.sql.Time;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class LokalizacjaController {


    @Autowired
    private LokalizacjaService lokalizacjaService;

    /**
     * List all products.
     *
     */
    @GetMapping(value = "/lokalizacja", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Lokalizacja> list(Model model) {
        return lokalizacjaService.listAllLokalizacja();
    }

    // Only for redirect!

    @ApiIgnore
    @RequestMapping(value = "/lokalizacja", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Lokalizacja> redirect(Model model) {
        return lokalizacjaService.listAllLokalizacja();
    }



    /**
     * View a specific product by its id.
     *
     * @return
     */
    @GetMapping(value = "/lokalizacja/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Lokalizacja getByPublicId(@RequestParam("id") Integer id) {
        return lokalizacjaService.getLokalizacjaById(id).orElseGet(null);
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


    /**
     * Save product to database.
     *
     */
    @PostMapping(value = "/lokalizacja")
    public ResponseEntity<Lokalizacja> create(@RequestBody @NonNull @Valid Lokalizacja lokalizacja) {
        //Random rand = new Random();
        // asortyment.setId(rand.nextInt());
        lokalizacjaService.saveLokalizacja(lokalizacja);
        return ResponseEntity.ok().body(lokalizacja);
    }


    /**
     * Edit product in database.
     *
     */
    @PutMapping(value = "/lokalizacja")
    public ResponseEntity<Void> edit(@RequestBody Lokalizacja lokalizacja) {
        if(!lokalizacjaService.checkIfLokalizacjaExist(lokalizacja.getIdLokalizacji()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            lokalizacjaService.saveLokalizacja(lokalizacja);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    /**
     * Delete product by its id.
     *
     */
    @DeleteMapping(value = "/lokalizacja/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        lokalizacjaService.deleteLokalizacja(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
/*
    @DeleteMapping(value = "/sklep/{id}")
    public ResponseEntity deleteBadRequest(@PathVariable Integer id) {
        return new ResponseEntity(HttpStatus.FORBIDDEN);
    }
*/

    @GetMapping(value = "/lokalizacja/{page}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Lokalizacja> list(@PathVariable("page") Integer pageNr,@RequestParam("size") Optional<Integer> howManyOnPage) {
        return lokalizacjaService.listAllLokalizacjaPaging(pageNr, howManyOnPage.orElse(2));
    }
    @Transactional
    @GetMapping(value = "/lokalizacja/ifopen/{id}")
    public Boolean checkIfOpen(@PathVariable Integer id){
        LocalTime now = new LocalTime();
        Date da = now.toDateTimeToday().toDate();
        return lokalizacjaService.checkIfOpen(da,id);
    }

}
