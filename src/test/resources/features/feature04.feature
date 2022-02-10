
@feature4
Feature: As a librarian, I want to know all the students who brewed books.

  @db
  Scenario: verify who borrowed which books
    Given Establish the database connections
    When I execute query to inner join users and book_borrow on user_id
    Then verify "Test Student 344" the user who reads the most
