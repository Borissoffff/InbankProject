package com.example.inbankproject.loan;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LoanDecisionEngineTest {

    @Test
    void calculatePossibleLoanTerm__creditModifierEquals300() {
        //String userCode = "49002010998"; // 1000
        String userCode = "49002010987"; // credit modifier = 300

        LoanDecisionEngine engine = new LoanDecisionEngine(userCode, 4000, 15);
        boolean loanIsApproved = engine.loanIsApproved();
        Loan newLoan = engine.calculatePossibleLoan();

        assertTrue(loanIsApproved);
        assertEquals(4500, newLoan.getLoanAmount());
        assertEquals(15, newLoan.getLoanPeriod());

        engine = new LoanDecisionEngine(userCode, 7000, 12);
        loanIsApproved = engine.loanIsApproved();
        newLoan = engine.calculatePossibleLoan();

        assertFalse(loanIsApproved);
        assertEquals(3600, newLoan.getLoanAmount());
        assertEquals(12, newLoan.getLoanPeriod());
    }

    @Test
    void calculatePossibleLoanTerm__creditModifierEquals100() {
        String userCode = "49002010976"; // credit modifier = 100

        LoanDecisionEngine engine = new LoanDecisionEngine(userCode, 3000, 12);
        boolean loanIsApproved = engine.loanIsApproved();
        Loan newLoan = engine.calculatePossibleLoan();

        assertFalse(loanIsApproved);
        assertEquals(3000, newLoan.getLoanAmount());
        assertEquals(30, newLoan.getLoanPeriod());

        engine = new LoanDecisionEngine(userCode, 2000, 45);
        loanIsApproved = engine.loanIsApproved();
        newLoan = engine.calculatePossibleLoan();

        assertTrue(loanIsApproved);
        assertEquals(4500, newLoan.getLoanAmount());
        assertEquals(45, newLoan.getLoanPeriod());
    }

    @Test
    void calculatePossibleLoanTerm__creditModifierEquals1000() {
        String userCode = "49002010998"; // credit modifier = 1000

        LoanDecisionEngine engine = new LoanDecisionEngine(userCode, 7000, 12);
        boolean loanIsApproved = engine.loanIsApproved();
        Loan newLoan = engine.calculatePossibleLoan();

        assertTrue(loanIsApproved);
        assertEquals(10000, newLoan.getLoanAmount());
        assertEquals(12, newLoan.getLoanPeriod());

        engine = new LoanDecisionEngine(userCode, 2000, 12);
        loanIsApproved = engine.loanIsApproved();
        newLoan = engine.calculatePossibleLoan();

        assertTrue(loanIsApproved);
        assertEquals(10000, newLoan.getLoanAmount());
        assertEquals(12, newLoan.getLoanPeriod());
    }
}