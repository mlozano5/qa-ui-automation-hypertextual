Feature: Subscribe to the newsletter

  # Description of the functionality to be tested: As a user I want to be able to subscribe to the newsletter

  @SmokeTest
  Scenario Outline: Successfully subscribing to the newsletter
    Given The user opens the home page "<nav>"
    When I enter a valid email address in the newsletter subscription field
    Then I expect to see a confirmation message indicating that the subscription was successful

    Examples:
      | nav      |
      | chrome   |