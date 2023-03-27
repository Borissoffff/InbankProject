package com.example.inbankproject.loan;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoanValidatorTest {

    @Test
    void getValidationErrors() {

        Loan loan = new Loan(2000, 12);
        LoanValidator validator = new LoanValidator(loan);
        assertEquals(0, validator.getValidationErrors().size());

        loan = new Loan(10000, 60);
        validator = new LoanValidator(loan);
        assertEquals(0, validator.getValidationErrors().size());

        loan = new Loan(1999, 30);
        validator = new LoanValidator(loan);
        assertEquals(1, validator.getValidationErrors().size());

        loan = new Loan(10001, 30);
        validator = new LoanValidator(loan);
        assertEquals(1, validator.getValidationErrors().size());

        loan = new Loan(100001, 61);
        validator = new LoanValidator(loan);
        assertEquals(2, validator.getValidationErrors().size());

        loan = new Loan(1999, 11);
        validator = new LoanValidator(loan);
        assertEquals(2, validator.getValidationErrors().size());
    }
}