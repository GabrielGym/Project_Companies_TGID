package br.com.gabriel.companies.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.gabriel.companies.dto.CreateDepositDto;
import br.com.gabriel.companies.dto.CreateLootDto;
import br.com.gabriel.companies.dto.UserDto;
import br.com.gabriel.companies.exception.AppException;
import br.com.gabriel.companies.model.Company;
import br.com.gabriel.companies.model.User;
import br.com.gabriel.companies.repository.UserRepository;
import br.com.gabriel.companies.repository.CompanyRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;

    public UserService(UserRepository userRepository, CompanyRepository companyRepository) {
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
    };

    public User createUser(final UserDto userData) {
        final Company company = companyRepository.findById(userData.getCompany_id())
                .orElseThrow(() -> new AppException("Company not found", HttpStatus.NOT_FOUND));
        final User newUser = new User(userData.getName(), userData.getEmail(), userData.getCpf(),
                userData.getPassword(), company);

        return userRepository.save(newUser);
    };

    public List<User> getUsers() {
        return userRepository.findAll();
    };

    public User retrieveUser(final long id) {
        final User user = userRepository.findById(id)
                .orElseThrow(() -> new AppException("User not found", HttpStatus.NOT_FOUND));

        return user;
    };

    public User createDeposit(final CreateDepositDto depositData, final long id) {
        final User foundUser = userRepository.findById(id)
                .orElseThrow(() -> new AppException("User not found", HttpStatus.NOT_FOUND));
        final float currentBalance = foundUser.getBalance();

        final float discountedPrice = (float) (depositData.getValue() - (depositData.getValue() * 0.03));

        foundUser.setBalance(currentBalance + discountedPrice);

        final Company company = foundUser.getCompany();
        final float currentBalanceCompany = company.getBalance();
        company.setBalance(currentBalanceCompany + depositData.getValue());

        companyRepository.save(company);
        return userRepository.save(foundUser);
    };

    public User createLoot(final CreateLootDto lootData, final long id) {
        final User foundUser = userRepository.findById(id)
                .orElseThrow(() -> new AppException("User not found", HttpStatus.NOT_FOUND));
        final float currentBalance = foundUser.getBalance();

        final float discountedPrice = (float) (lootData.getValue() + (lootData.getValue() * 0.05));

        if (currentBalance < discountedPrice) {
            new AppException("Balance unavailable, currently your balance is: R$" + currentBalance,
                    HttpStatus.CONFLICT);
        }

        foundUser.setBalance(currentBalance - discountedPrice);

        final Company company = foundUser.getCompany();
        final float currentBalanceCompany = company.getBalance();
        company.setBalance(currentBalanceCompany - lootData.getValue());

        companyRepository.save(company);

        return userRepository.save(foundUser);
    };

}
