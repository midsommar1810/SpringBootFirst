package com.JobApp.Application.Companies;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {
    CompanyService service ;

    public CompanyController(CompanyService service) {
        this.service = service;
    }

    @GetMapping("/companies")
    public ResponseEntity<List<Companies>> getAll (){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK) ;
    }

    @PostMapping("/companies")
    public ResponseEntity<String> create(@RequestBody Companies com) {
        service.createCompany(com);
        return new ResponseEntity<>("Added a new company",HttpStatus.OK) ;
    }
}
