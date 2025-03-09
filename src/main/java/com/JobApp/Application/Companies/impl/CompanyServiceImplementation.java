package com.JobApp.Application.Companies.impl;

import com.JobApp.Application.Companies.Companies;
import com.JobApp.Application.Companies.CompanyRepositry;
import com.JobApp.Application.Companies.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImplementation implements CompanyService {

    CompanyRepositry companyRepositry ;

    public CompanyServiceImplementation(CompanyRepositry companyRepositry) {
        this.companyRepositry = companyRepositry;
    }

    @Override
    public void createCompany(Companies company) {
        company.setId(null);
        this.companyRepositry.save(company);
    }

    @Override
    public List<Companies> findAll() {
        return this.companyRepositry.findAll();
    }

    @Override
    public Companies findById(Long id) {
        return companyRepositry.findById(id).orElse(null) ;
    }

    @Override
    public boolean UpdateCompany(Long id, Companies updatedCompany) {
        Optional<Companies> optionalCompany = companyRepositry.findById(id) ;
        if (optionalCompany.isPresent()){
            Companies com = optionalCompany.get() ;
            com.setDescription(updatedCompany.getDescription());
            com.setLocation(updatedCompany.getLocation());
            com.setName(updatedCompany.getName());
            companyRepositry.save(com) ;
            return true ;
        }
        return false ;
    }

    @Override
    public boolean DeleteCompany(Long id) {
        if (companyRepositry.existsById(id)){
            companyRepositry.deleteById(id);
            return true ;
        }
        return false ;
    }
}
