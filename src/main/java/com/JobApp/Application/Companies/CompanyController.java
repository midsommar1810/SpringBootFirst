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

    @GetMapping("/companies/{id}")
    public ResponseEntity<Companies> getById (@PathVariable Long id){
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK) ;
    }

    @PutMapping("/companies/{id}")
    public ResponseEntity<String> updateCompany (@PathVariable Long id , @RequestBody Companies updatedCompany){
        if (service.UpdateCompany(id,updatedCompany)){
            return new ResponseEntity<>("Updated Succesfully",HttpStatus.OK);
        } else {
            return new ResponseEntity<>("company with this id not found",HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/companies/{id}")
    public ResponseEntity<String> deleteCompany (@PathVariable Long id ){
        if (service.DeleteCompany(id)){
            return new ResponseEntity<>("Deleted Succesfully",HttpStatus.OK);
        } else {
            return new ResponseEntity<>("company with this id not found",HttpStatus.NOT_FOUND);
        }
    }
}
