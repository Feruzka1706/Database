
@feature6
Feature: As a data consumer, I want UI and DB book information are match.

  @db @ui
  Scenario: verify book categories with DB

    Given I am in the homepage of library app
    When I navigate to "Books" page
    And I open a book called "Djoan Rowling"
    When Establish the database connections
    And I execute query to get book categories
    Then verify book categories must match book_categories table from db