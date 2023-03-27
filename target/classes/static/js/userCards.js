
const addLoanButtons = document.querySelectorAll(".button");
for (const addLoanButton of addLoanButtons) {
    if (addLoanButton.getAttribute("value") === "0") {
        addLoanButton.disabled = true;
        addLoanButton.style.backgroundColor = "red";
    }
}