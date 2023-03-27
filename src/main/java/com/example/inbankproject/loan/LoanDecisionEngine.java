package com.example.inbankproject.loan;

import com.example.inbankproject.user.User;
import com.example.inbankproject.user.UserStorage;

public class LoanDecisionEngine {

    private final Integer loanAmount;
    private final int loanPeriod;

    private final User user;

    public LoanDecisionEngine(String personalCode, Integer loanAmount, int loanPeriod) {
        this.loanAmount = loanAmount;
        this.loanPeriod = loanPeriod;

        user = new UserStorage().getUserByPersonalCode(personalCode);
    }

    public boolean loanIsApproved() {
        return calculateCreditScore(loanAmount, loanPeriod) >= 1;
    }

    public Loan calculatePossibleLoan() {
        float creditScore = calculateCreditScore(loanAmount, loanPeriod);

        Integer maxSum;
        int maxPeriod = loanPeriod;

        // if user credit score is more or equal to 1, increase loan sum
        if (creditScore >= 1) {
            maxSum = calculateMaxLoanSum(Math.round(loanAmount), 10000);
        }
        // if user credit score is less than 1, decrease loan sum
        else {
            maxSum = calculateMaxLoanSum(2000, Math.round(loanAmount));
        }
        //If a suitable loan amount is not found within the selected period, try to find a new suitable period
        if (maxSum == null) {
            maxPeriod = calculateOptimalLoanPeriod();
            maxSum = loanAmount;
        }
        return new Loan(maxSum, maxPeriod);
    }

    private Integer calculateMaxLoanSum(int minLoanSum, int maxLoanSum) {
        Integer maxSum = null;
        for (int possibleLoanAmount = minLoanSum; possibleLoanAmount <= maxLoanSum; possibleLoanAmount++) {
            if (calculateCreditScore(possibleLoanAmount, loanPeriod) >= 1) {
                maxSum = possibleLoanAmount;
            }
        }
        return maxSum;
    }

    private int calculateOptimalLoanPeriod() {
        int maxPeriod = loanPeriod;
        for (int months = loanPeriod; months < 61; months++) {
            if (calculateCreditScore(loanAmount, months) >= 1) {
                maxPeriod = months;
                break;
            }
        }
        return maxPeriod;
    }

    private float calculateCreditScore(float loanAmount, int loanPeriod) {
        return (user.getCreditModifier() / loanAmount) * loanPeriod;
    }
}
