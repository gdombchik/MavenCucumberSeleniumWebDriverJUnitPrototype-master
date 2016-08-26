Feature: Parameter Handling Test

@parameterHandling
  Scenario: My Parameter Handling Test
    Given I navigate to the "index.html" on the cucumber website
    When I say "hello"
    When I say "goodbye"
    When I say "peace"
    Then I close parameter handling browser
