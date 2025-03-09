package com.JobApp.Application.Companies;

import java.util.List;

public interface CompanyService {
    void createCompany (Companies company);
    List<Companies> findAll () ;
    Companies findById (Long id);
    boolean UpdateCompany (Long id , Companies company) ;
    boolean DeleteCompany (Long id) ;
}
