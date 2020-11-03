Feature: Cards

	Background: Log in to Trello, create a board and a list
		Given I have Trello valid credentials
		And I create a board
		And I create a list

  Scenario: Create a new card successfully
    When I create a card
    Then Trello should return that the card was created successfully
    And I should have a card with creation data

  Scenario: Update a card successfully
  	Given I create a card
    When I update the card
    Then Trello should return that the card was updated successfully
    And I should have a card with update data

	Scenario: Update a card with an invalid id
		Given I create a card
    When I update the card with an invalid id
    Then Trello should return that the card has not been updated

  Scenario: Submit request with invalid credentials
  	Given I create a card
    When I submit a request to get the card with invalid credentials
    Then Trello should return that the credentials are invalid