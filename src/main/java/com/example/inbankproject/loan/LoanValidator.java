package com.example.inbankproject.loan;

import java.util.ArrayList;
import java.util.List;

public class LoanValidator {

    private final Loan loan;

    public LoanValidator(Loan loan) {
      this.loan = loan;
    }

    // loan sum must be between 2000 and 10000 euro
    // loan period must be between 12 and 60 months
    public List<String> getValidationErrors() {
        List<String> errors = new ArrayList<>();

        if (loan.getLoanAmount() < 2000 || loan.getLoanAmount() > 10000) {
            errors.add("Loan amount must be between 2000 and 10000 euros.");
        }
        if (loan.getLoanPeriod() < 12 || loan.getLoanPeriod() > 60) {
            errors.add("Loan period must be between 12 and 60 months.");
        }
        return errors;
    }
}