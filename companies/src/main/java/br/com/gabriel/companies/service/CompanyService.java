package br.com.gabriel.companies.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.gabriel.companies.dto.CompanyDto;
import br.com.gabriel.companies.exception.AppException;
import br.com.gabriel.companies.model.Company;
import br.com.gabriel.companies.repository.CompanyRepository;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    };

    public Company createCompany(final CompanyDto companyData) {
        final Company newCompany = new Company(companyData.getName(), companyData.getEmail(), companyData.getCnpj());

        return companyRepository.save(newCompany);
    };

    public List<Company> getCompanies() {
        return companyRepository.findAll();
    };

    public Company retrieveCompany(final long id) throws Exception {
        final Company company = companyRepository.findById(id).orElseThrow(() -> new AppException("Company not found", HttpStatus.NOT_FOUND));

        return company;
    };
}
