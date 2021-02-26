Feature: Adding a new book to the library

  Scenario Outline: Adding a new book

    Given an empty library

    When a librarian adds a book with "<title>", "<author>", <edition>, "<year>" and "<isbn>"
    And a librarian adds a book with "<title2>", "<author2>", <edition2>, "<year>" and "<isbn>"
    
    Then the booklist contains a book with "<title>", "<author>", "<year>", <edition> and "<isbn>"
    And the library contains <nr> copies of the book with "<isbn>"

    Examples:

      | isbn       | author          | title    | edition | year | author2         | edition2 | title2   | nr     |
      | 0552131075 | Terry Pratchett | Sourcery | 1       | 1989 |                 | 1        |          | 1      |
      | 0552131075 | Terry Pratchett | Sourcery | 1       | 1989 | Terry Pratchett | 1        | Sourcery | 2      |
      | 0552131075 | Terry Pratchett | Sourcery | 1       | 1989 | Jerry Pratchett | 1        | Sourcery | 1      |
      | 0552131075 | Terry Pratchett | Sourcery | 1       | 1989 | Terry Pratchett | 1        | Mastery  | 1      |
      | 0552131075 | Terry Pratchett | Sourcery | 1       | 1989 | Terry Pratchett | 2        | Sourcery | 1      |






