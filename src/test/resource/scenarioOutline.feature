Feature: Scenario Outline Test

  @tagForScenarioOutline
  Scenario Outline: My Scenario Outline Test
    Given I navigate to the <link> page
    Then I should be on the <value> page

    # And I close scenario outline browser
    Examples: 
      | link              | value        |
      | index.html        | Home         |
      | another_page.html | Another Page |
