Feature: Search from the home page

  # Description of the functionality to be tested: As a user, I want to search for articles about something specific and navigate
  # to one of the results to verify that the search was performed correctly.

  @SmokeTest
  Scenario Outline: Search for "Steve Jobs" and check the first article about "Reed Jobs"
    Given The user is on the home page "<nav>"
    When The user searches for "<VALUE1>"
    And The user scrolls to the first post about
    Then I expect the URL and some of the text on the page is correct "<VALUE2>"

    Examples:
      | VALUE1      | VALUE2      | nav      |
      | Steve Jobs  |  Reed Jobs  | chrome   |