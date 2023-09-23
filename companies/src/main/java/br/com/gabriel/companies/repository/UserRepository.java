package br.com.gabriel.companies.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gabriel.companies.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
