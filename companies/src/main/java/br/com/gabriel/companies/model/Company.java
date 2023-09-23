package br.com.gabriel.companies.model;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;

@Entity
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 120, nullable = false)
    private String name;

    @Column(length = 120, nullable = false, unique = true)
    private String email;

    @Column(length = 14, nullable = false, unique = true)
    private String cnpj;

    @Column(columnDefinition = "DECIMAL DEFAULT 0.0")
    private Float balance;

    @CreationTimestamp
    @Column(updatable = false)
    private Date startDate;


    public Company() {
    }

    public Company(String name, String email, String cnpj) {
        this.name = name;
        this.cnpj = cnpj;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCpf(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
