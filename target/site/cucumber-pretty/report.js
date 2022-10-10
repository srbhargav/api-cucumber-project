$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/E2EApiTest.feature");
formatter.feature({
  "name": "End to End Tests for Book Store",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "User generates token for Authorisation",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "I am an authorized user",
  "keyword": "Given "
});
formatter.match({
  "location": "com.apitesting.steps.Steps.i_am_an_authorized_user() in file:/C:/api-cucumber-project/target/test-classes/"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "the Authorized user can Add and Remove a book.",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "A list of books are available",
  "keyword": "Given "
});
formatter.match({
  "location": "com.apitesting.steps.Steps.a_list_of_books_are_available() in file:/C:/api-cucumber-project/target/test-classes/"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I add a book to my reading list",
  "keyword": "When "
});
formatter.match({
  "location": "com.apitesting.steps.Steps.i_add_a_book_to_my_reading_list() in file:/C:/api-cucumber-project/target/test-classes/"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the book is added",
  "keyword": "Then "
});
formatter.match({
  "location": "com.apitesting.steps.Steps.the_book_is_added() in file:/C:/api-cucumber-project/target/test-classes/"
});
formatter.result({
  "error_message": "java.lang.AssertionError: expected:\u003c201\u003e but was:\u003c401\u003e\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat org.junit.Assert.failNotEquals(Assert.java:834)\r\n\tat org.junit.Assert.assertEquals(Assert.java:645)\r\n\tat org.junit.Assert.assertEquals(Assert.java:631)\r\n\tat com.apitesting.steps.Steps.the_book_is_added(Steps.java:75)\r\n\tat ✽.the book is added(///C:/api-cucumber-project/src/test/resources/E2EApiTest.feature:15)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "I update the book from my reading list",
  "keyword": "And "
});
formatter.match({
  "location": "com.apitesting.steps.Steps.i_update_the_book_from_my_reading_list() in file:/C:/api-cucumber-project/target/test-classes/"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "the book is updated",
  "keyword": "And "
});
formatter.match({
  "location": "com.apitesting.steps.Steps.the_book_is_updated() in file:/C:/api-cucumber-project/target/test-classes/"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I remove a book from my reading list",
  "keyword": "When "
});
formatter.match({
  "location": "com.apitesting.steps.Steps.i_remove_a_book_from_my_reading_list() in file:/C:/api-cucumber-project/target/test-classes/"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "the book is removed",
  "keyword": "Then "
});
formatter.match({
  "location": "com.apitesting.steps.Steps.the_book_is_removed() in file:/C:/api-cucumber-project/target/test-classes/"
});
formatter.result({
  "status": "skipped"
});
});