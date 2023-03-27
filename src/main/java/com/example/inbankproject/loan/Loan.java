package com.example.inbankproject.loan;

public class Loan {

    private Integer loanAmount;
    private int loanPeriod;

    public Loan(Integer loanAmount, int loanPeriod) {
        this.loanAmount = loanAmount;
        this.loanPeriod = loanPeriod;
    }

    public Integer getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Integer loanAmount) {
        this.loanAmount = loanAmount;
    }

    public int getLoanPeriod() {
        return loanPeriod;
    }

    public void setLoanPeriod(int loanPeriod) {
        this.loanPeriod = loanPeriod;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "loanAmount=" + loanAmount +
                ", loanPeriod=" + loanPeriod +
                '}';
    }
}
