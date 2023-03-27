package com.example.inbankproject.user;

import com.example.inbankproject.loan.Loan;
import org.apache.catalina.LifecycleState;
import org.apache.catalina.Loader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class User {

    private String personalCode;
    private String firstName;
    private String lastName;
    private Integer segment;
    private Integer creditModifier;
    private boolean hasDebt;

    public User(String personalCode, String firstName, String lastName, int segment) {
        this.personalCode = personalCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.segment = segment;

        HashMap<Integer, Integer> creditModifiersMap = new HashMap<>(){{
            put(1, 100);
            put(2, 300);
            put(3, 1000);
        }};

        if (segment == 0) {
            this.hasDebt = true;
        }
        this.creditModifier = creditModifiersMap.get(segment);
    }

    public String getPersonalCode() {
        return personalCode;
    }

    public void setPersonalCode(String personalCode) {
        this.personalCode = personalCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSegment() {
        return segment;
    }

    public void setSegment(int segment) {
        this.segment = segment;
    }

    public int getCreditModifier() {
        return creditModifier;
    }

    public void setCreditModifier(int creditModifier) {
        this.creditModifier = creditModifier;
    }

    public boolean hasDebt() {return hasDebt;}

    public void setHasDebt(boolean hasDebt) {
        this.hasDebt = hasDebt;
    }


    @Override
    public String toString() {
        return "User{" +
                "personalCode='" + personalCode + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", segment=" + segment +
                ", creditModifier=" + creditModifier +
                ", hasDebt=" + hasDebt +
                '}';
    }
}
