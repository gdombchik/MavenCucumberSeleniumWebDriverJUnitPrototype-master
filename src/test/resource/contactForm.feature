Feature: Contact Form Test

  @ContactForm
  Scenario: My First Test
    Given I navigate to the cucumber website
    When I fill out the form
      | Field | Value                    |
      | name  | Gregory Dombchik         |
      | email | greg@gregorydombchik.com |
    Then I should be on the welcome page for contact form
    And I close browser
