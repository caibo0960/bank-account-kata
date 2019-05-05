package com.bo;

import com.bo.model.Account;
import com.bo.model.Operation;
import com.bo.model.Transaction;
import com.bo.service.BankService;
import com.bo.service.ImpossibleOperation;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.runtime.java.StepDefAnnotation;
import org.junit.Assert;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class Stepdefs {

    private Account account = null;
    private boolean lastOperationFailed = false;
    private List<Transaction> operationHistory = null;

    @Given("^I am a client having a bank account of (-?\\d+)$")
    public void createNewBankAccount(BigDecimal balance) {
        account = BankService.createAccount(null, balance);
    }

    @When("^I make a deposit of (-?\\d+)$")
    public void makeDeposit(BigDecimal amount) {
        try {
            lastOperationFailed = false;
            BankService.deposit(account, amount);
        } catch (ImpossibleOperation impossibleOperation) {
            lastOperationFailed = true;
        }
    }

    @When("^I make a withdrawal of (-?\\d+)$")
    public void makeWithdrawal(BigDecimal amount) {
        try {
            lastOperationFailed = false;
            BankService.withdrawal(account, amount);
        } catch (ImpossibleOperation impossibleOperation) {
            lastOperationFailed = true;
        }
    }

    @Then("^My account should have (-?\\d+)$")
    public void checkAccount(BigDecimal amount) {
        if (lastOperationFailed) {
            fail("Last operation failed");
        }
        Assert.assertTrue(amount.compareTo(account.getBalance()) == 0);
    }

    @Then("^Impossible operation should raise$")
    public void checkError() {
        if (!lastOperationFailed) {
            fail("No error raised");
        }
    }

    @When("^I check my account operation history$")
    public void checkOperationHistory() {
        operationHistory = BankService.getOperationHistory(account);
    }

    @Then("^The account operation history should be print as follows$")
    public void checkOperationHistoryResult(DataTable dataTable) {
        dataTable.diff(operationHistory);
    }
}
