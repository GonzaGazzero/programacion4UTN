package com.ejer8.seguridad.controller;

import com.ejer8.seguridad.model.Loan;
import com.ejer8.seguridad.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prestamos")
@RequiredArgsConstructor
public class LoanController {

    private final LoanService loanService;

    @GetMapping
    public ResponseEntity<List<Loan>> getAllLoans() {
        return ResponseEntity.ok(loanService.findAll());
    }

    @GetMapping("/mis-prestamos")
    public ResponseEntity<List<Loan>> getMyLoans(Authentication authentication) {
        return ResponseEntity.ok(loanService.findMyLoans(authentication.getName()));
    }

    @PostMapping
    public ResponseEntity<Loan> requestLoan(@RequestBody Loan loan, Authentication authentication) {
        loan.setUsername(authentication.getName());
        return new ResponseEntity<>(loanService.requestLoan(loan), HttpStatus.CREATED);
    }

    @PutMapping("/{id}/aprobar")
    public ResponseEntity<Loan> approveLoan(@PathVariable Long id) {
        Loan approvedLoan = loanService.approveLoan(id);
        if (approvedLoan == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(approvedLoan);
    }
}
