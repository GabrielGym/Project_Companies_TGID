package br.com.gabriel.companies.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CompanyDto {
    @NotNull(message = "name is required")
    @Size(max = 120, min = 3, message = "name must have a minimum of 3 and a maximum of 120 characters")
    private String name;

    @Size(max = 14, min = 14, message = "cnpj must have a minimum of 14 and a maximum of 14 characters")
    @NotNull(message = "cnpj is required")
    private String cnpj;

    @NotNull(message = "email is required")
    @Email(message = "Email format invalid")
    @Size(max = 120, min = 3, message = "email must have a minimum of 3 and a maximum of 120 characters")
    @NotNull(message = "email is required")
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
