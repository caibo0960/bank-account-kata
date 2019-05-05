package com.bo;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.runtime.java.StepDefAnnotation;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class Stepdefs {

    @Given("^I am a client having a bank account of (-?\\d+)$")
    public void createNewBankAccount(BigDecimal balance) {

    }

    @When("^I make a deposit of (-?\\d+)$")
    public void makeDeposit(BigDecimal amount) {

    }

    @When("^I make a withdrawal of (-?\\d+)$")
    public void makeWithdrawal(BigDecimal amount) {

    }

    @Then("^My account should have (-?\\d+)$")
    public void checkAccount(BigDecimal amount) {

    }

    @Then("^Impossible operation should raise$")
    public void checkError() {

    }

    @When("^I want see my account operation history$")
    public void checkOperationHistory() {

    }

    @Then("^The account operation history should be print as follows$")
    public void checkOperationHistoryResult() {

    }
}
