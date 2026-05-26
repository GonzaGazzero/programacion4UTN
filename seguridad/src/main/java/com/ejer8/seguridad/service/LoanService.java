package com.ejer8.seguridad.service;

import com.ejer8.seguridad.model.Loan;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class LoanService {

    private final Map<Long, Loan> loans = new ConcurrentHashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public List<Loan> findAll() {
        return new ArrayList<>(loans.values());
    }

    @PreAuthorize("hasRole('LECTOR') and #username == authentication.name")
    public List<Loan> findMyLoans(String username) {
        return loans.values().stream()
                .filter(loan -> loan.getUsername().equals(username))
                .collect(Collectors.toList());
    }

    public Loan requestLoan(Loan loan) {
        loan.setId(idCounter.getAndIncrement());
        loan.setApproved(false);
        loans.put(loan.getId(), loan);
        return loan;
    }

    @PreAuthorize("hasRole('BIBLIOTECARIO')")
    public Loan approveLoan(Long id) {
        Loan loan = loans.get(id);
        if (loan != null) {
            loan.setApproved(true);
        }
        return loan;
    }
}
