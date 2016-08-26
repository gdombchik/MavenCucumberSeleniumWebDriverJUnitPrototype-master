Feature: Test check boxes, drop downs, and radio buttons of a form

Background:
	Given I navigate to the "form.php" page

@formTest
  Scenario: Test Form
    Then I populate the from
    And I close form handling browser
