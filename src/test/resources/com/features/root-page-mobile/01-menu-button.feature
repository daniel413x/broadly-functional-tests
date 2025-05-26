@root-page-mobile
Feature: Menu Button

  Scenario: Clicking the menu button reveals the mobile sidebar
    Given I am on the root page
    When I click the menu button
    Then I should see the mobile sidebar
