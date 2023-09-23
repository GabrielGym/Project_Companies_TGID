package br.com.gabriel.companies.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.gabriel.companies.dto.CompanyDto;
import br.com.gabriel.companies.model.Company;
import br.com.gabriel.companies.service.CompanyService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService){
        this.companyService = companyService;
    }

    @PostMapping
    public ResponseEntity<Company> createCompany(@Valid @RequestBody final CompanyDto companyData) {
        final Company createCompany = companyService.createCompany(companyData);

        return new ResponseEntity<Company>(createCompany, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Company>> getCompanies() {
        final List<Company> allCompany = companyService.getCompanies();

        return new ResponseEntity<List<Company>>(allCompany, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> retrieveCompany(@PathVariable final String id) throws Exception {

        final Company company = companyService.retrieveCompany(Long.parseLong(id));

        return new ResponseEntity<Company>(company, HttpStatus.OK);

    }
}
