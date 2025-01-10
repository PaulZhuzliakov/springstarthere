package org.example.demo666.controller;

import org.example.demo666.model.Country;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {

    @GetMapping("/france")
    public ResponseEntity<Country> getFrance() {
        Country france = Country.of("France", 67);
        return ResponseEntity
                .status(HttpStatus.I_AM_A_TEAPOT)
                .header("continent", "Europe")
                .header("capital", "Paris")
                .body(france);
    }

    @GetMapping("/all")
    public List<Country> getAll() {
        return List.of(
                Country.of("France", 67),
                Country.of("Germany", 62)
        );
    }

}
