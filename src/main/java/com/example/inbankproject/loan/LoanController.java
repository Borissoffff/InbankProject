package com.example.inbankproject.loan;

import com.example.inbankproject.user.User;
import com.example.inbankproject.user.UserStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RequestMapping("/loans")
@Controller
public class LoanController {

    UserStorage userStorage = new UserStorage();

    @GetMapping("/calculateLoan/{userCode}")
    public String displayAddLoanPage(
            @PathVariable("userCode") String userCode,
            Model model
    ) {
        User user = userStorage.getUserByPersonalCode(userCode);
        if (user.hasDebt()) {
            throw new IllegalArgumentException("Users with debt cannot take another loans");
        }

        model.addAttribute("user", user);

        return "add-loan-page.html";
    }

    @PostMapping("/calculateLoan/{userCode}")
    public String calculateLoan(
            @PathVariable("userCode") String userCode,
            @ModelAttribute Loan loan,
            Model model
    ) {
        User user = userStorage.getUserByPersonalCode(userCode);
        model.addAttribute("user", user);

        //validate user input
        LoanValidator validator = new LoanValidator(loan);
        List<String> errors = validator.getValidationErrors();
        if (errors.size() != 0) {

            model.addAttribute("errors", errors);

        } else {

            LoanDecisionEngine engine = new LoanDecisionEngine(
                    userCode, loan.getLoanAmount(), loan.getLoanPeriod());

            Loan newLoan = engine.calculatePossibleLoan();
            boolean loanIsApproved = engine.loanIsApproved();

            model.addAttribute("loanIsApproved", loanIsApproved);
            model.addAttribute("newLoan", newLoan);
            model.addAttribute("oldLoan", loan);
        }
        return "add-loan-page.html";
    }
}
