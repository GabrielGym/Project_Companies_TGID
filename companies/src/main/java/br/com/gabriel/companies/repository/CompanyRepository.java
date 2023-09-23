package br.com.gabriel.companies.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gabriel.companies.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    
}
