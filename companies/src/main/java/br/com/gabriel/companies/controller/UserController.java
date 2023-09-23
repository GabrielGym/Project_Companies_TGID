package br.com.gabriel.companies.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.gabriel.companies.dto.CreateDepositDto;
import br.com.gabriel.companies.dto.CreateLootDto;
import br.com.gabriel.companies.dto.UserDto;
import br.com.gabriel.companies.model.User;
import br.com.gabriel.companies.service.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/clients")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody final UserDto userData) {
        final User createUser = userService.createUser(userData);

        return new ResponseEntity<User>(createUser, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        final List<User> allUser = userService.getUsers();

        return new ResponseEntity<List<User>>(allUser, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> retrieveUser(@PathVariable final String id) {

        final User user = userService.retrieveUser(Long.parseLong(id));

        return new ResponseEntity<User>(user, HttpStatus.OK);

    }

    @PostMapping("/{id}/deposit")
    public ResponseEntity<User> updateUser(@Valid @RequestBody final CreateDepositDto depositData,
            @PathVariable final String id) {

        final User depositedUser = userService.createDeposit(depositData, Long.parseLong(id));

        return new ResponseEntity<User>(depositedUser, HttpStatus.CREATED);

    }

    @PostMapping("/{id}/loot")
    public ResponseEntity<User> updateUser(@Valid @RequestBody final CreateLootDto lootData, @PathVariable final String id) {

        final User depositedUser = userService.createLoot(lootData, Long.parseLong(id));

        return new ResponseEntity<User>(depositedUser, HttpStatus.CREATED);

    }
}
