Feature: Bank account

  Scenario: Make a deposit
    Given I am a client having a bank account of 1000
    When I make a deposit of 100
    Then My account should have 1100

  Scenario: Make a deposit with amount 0
    Given I am a client having a bank account of 1000
    When I make a deposit of 0
    Then Impossible operation should raise

  Scenario: Make a deposit with amount -100
    Given I am a client having a bank account of 1000
    When I make a deposit of -100
    Then Impossible operation should raise

  Scenario: Make a withdrawal
    Given I am a client having a bank account of 1000
    When I make a withdrawal of 100
    Then My account should have 900

  Scenario: Make a withdrawal with amount 0
    Given I am a client having a bank account of 1000
    When I make a withdrawal of 0
    Then Impossible operation should raise

  Scenario: Make a withdrawal with amount -100
    Given I am a client having a bank account of 1000
    When I make a withdrawal of -100
    Then Impossible operation should raise

  Scenario: Make a withdrawal with amount 1100
    Given I am a client having a bank account of 1000
    When I make a withdrawal of 1100
    Then Impossible operation should raise

  Scenario: Check account operation history
    Given I am a client having a bank account of 1000
    When I make a deposit of 100
    And I make a withdrawal of 300
    Then My account should have 800
    When I want see my account operation history
    Then The account operation history should be print as follows
