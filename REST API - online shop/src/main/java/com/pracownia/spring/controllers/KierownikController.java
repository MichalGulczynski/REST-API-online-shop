package com.pracownia.spring.controllers;

import com.pracownia.spring.entities.Kierownik;
import com.pracownia.spring.entities.Wlasciciel;
import com.pracownia.spring.services.KierownikService;
import com.pracownia.spring.services.WlascicielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class KierownikController {
    @Autowired
    private KierownikService kierownikService;

    /**
     * List all products.
     *
     */
    @GetMapping(value = "/kierownik", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Kierownik> list(Model model) {
        return kierownikService.listAllKierownik();
    }

    // Only for redirect!

    @ApiIgnore
    @RequestMapping(value = "/kierownik", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Kierownik> redirect(Model model) {
        return kierownikService.listAllKierownik();
    }



    /**
     * View a specific product by its id.
     *
     * @return
     */
    @GetMapping(value = "/kierownik/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Kierownik getByPublicId(@RequestParam("id") Integer id) {
        return kierownikService.getKierownikById(id).orElseGet(null);
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
    @PostMapping(value = "/kierownik")
    public ResponseEntity<Kierownik> create(@RequestBody @NonNull @Valid Kierownik kierownik) {
        kierownikService.saveKierownik(kierownik);
        return ResponseEntity.ok().body(kierownik);
    }


    /**
     * Edit product in database.
     *
     */
    @PutMapping(value = "/kierownik")
    public ResponseEntity<Void> edit(@RequestBody Kierownik kierownik) {
        if(!kierownikService.checkIfKierownikExists(kierownik.getIdKierownika()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            kierownikService.saveKierownik(kierownik);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    /**
     * Delete product by its id.
     *
     */
    @DeleteMapping(value = "/kierownik/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        kierownikService.deleteKierownik(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping(value = "/kierownik/{page}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Kierownik> list(@PathVariable("page") Integer pageNr,@RequestParam("size") Optional<Integer> howManyOnPage) {
        return kierownikService.listAllKierownikPaging(pageNr, howManyOnPage.orElse(2));
    }
}
