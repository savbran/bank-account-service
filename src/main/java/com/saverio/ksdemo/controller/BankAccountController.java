package com.saverio.ksdemo.controller;

import com.saverio.ksdemo.model.BankAccountModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
public class BankAccountController {

    @GetMapping("/accounts/{accountNumber}")
    public ResponseEntity<?> getAccountBalance(@PathVariable String accountNumber) {

        if (accountNumber.equals("123456789")) {
            // This simulates amount data recovered from the account number
            BankAccountModel account = new BankAccountModel(accountNumber, 1000.00);
            return ResponseEntity.ok(account);

        } else {
            // This simulates a non non-existing account number
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("error", "Account not found"));
        }
    }
}
