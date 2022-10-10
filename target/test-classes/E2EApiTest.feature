#A Feature File is an entry point to the Cucumber tests. 
#This is a file where you will describe your tests in Descriptive language (Like English). 
#It is an essential part of Cucumber, as it serves as an automation test script as well as live documents. 
#A feature file can contain a scenario or can contain many scenarios in a single feature file but it usually contains a list of scenarios.
#Cucumber proposes to write scenario in the Given/When/Then format

Feature: End to End Tests for Book Store 

Background: User generates token for Authorisation
Given I am an authorized user

Scenario: the Authorized user can Add and Remove a book.
Given A list of books are available
When I add a book to my reading list
Then the book is added
And I update the book from my reading list
And the book is updated
When I remove a book from my reading list
Then the book is removed