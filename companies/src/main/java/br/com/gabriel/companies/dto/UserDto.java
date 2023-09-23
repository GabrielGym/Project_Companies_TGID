package br.com.gabriel.companies.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserDto {

    @NotNull(message = "name is required")
    @Size(max = 120, min = 3, message = "name must have a minimum of 3 and a maximum of 120 characters")
    private String name;

    @NotNull(message = "cpf is required")
    @Size(max = 11, min = 11, message = "name must have a minimum of 11 and a maximum of 11 characters")
    private String cpf;

    @NotNull(message = "email is required")
    @Email(message = "Email format invalid")
    @Size(max = 120, min = 3, message = "email must have a minimum of 3 and a maximum of 120 characters")
    private String email;

    @NotNull(message = "password is required")
    @Size(min = 4, message = "password must have a minimum of 4 characters")
    private String password;

    @NotNull(message = "company_id is required")
    private long company_id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getCompany_id() {
        return company_id;
    }

    public void setCompany_id(long company_id) {
        this.company_id = company_id;
    }
}
