
@feature5
Feature: As a data consumer, I want UI and DB book information are match.
  @db @ui
  Scenario: verify book information with DB Given I am in the homepage of library app

    When I navigate to "Books" page
    And I open a book called "Djoan Rowling"
    When Establish the database connections
    And I execute query to get the book information from books table
    Then verify book DB and UI information must match
      #| name         | author        | year |
      #| Harry Potter | Djoan Rowling | 2000 |