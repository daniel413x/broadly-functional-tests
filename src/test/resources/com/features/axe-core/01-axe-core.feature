@axe-core
Feature: axe-core results for any page

  Scenario: Axecore generates results
    Given I am on the route "<route>"
    When I assess the axe-core violations labeled "<route>" in Extent reports
    Then there should be no violations

    Examples:
      | route          |
      | /          |
      | /about          |
