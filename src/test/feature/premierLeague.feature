Feature: Bet Premier League

  Scenario: I want the ability to place a bet on an English Premier League event

    Given Open the Chrome and go to WilliamHill website

    When Enter the Username and Password

    And Go to a Football by menu

    And Go to compatitions

    Then Select event and place a £0.05 bet for the home team to ‘Win’

    And Click on Place bet button

    Then Assert the odds and returns offered