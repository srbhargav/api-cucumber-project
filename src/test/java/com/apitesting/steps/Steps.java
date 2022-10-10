package com.apitesting.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import java.util.List;
import java.util.Map;


import io.restassured.path.json.JsonPath;

public class Steps {
	
	private static final String USER_ID = "9b5f49ab-eea9-45f4-9d66-bcf56a531b85";
	private static final String USERNAME = "TOOLSQA-Test";
	private static final String PASSWORD = "Test@@123";
	private static final String BASE_URL = "https://bookstore.toolsqa.com";
	private static final String ISBN ="9781449325865";
    private static String token;
    private static Response response;
    private static String jsonString;
    private static String bookId;

	@Given("I am an authorized user")
	public void i_am_an_authorized_user() {
		//Creating a request point to the sevice endpoint
		RestAssured.baseURI = BASE_URL;
		RequestSpecification request = RestAssured.given();
        //Add a header stating the Request body is a JSON 
		request.header("Content-Type", "application/json");
		//Calling the POST API with the request body
		response = request.body("{ \"userName\":\"" + USERNAME + "\", \"password\":\"" + PASSWORD + "\"}")
				.post("/Account/v1/GenerateToken");
        //converting the response to string 
		String jsonString = response.asString();
		 //We will deserialize the Response body into Token Response
		token = JsonPath.from(jsonString).get("token");
	}

	//Fetching bulk record
	@Given("A list of books are available")
	public void a_list_of_books_are_available() {
		RestAssured.baseURI = BASE_URL;
		RequestSpecification request = RestAssured.given();
		//Calling the GET API with request body
		response = request.get("/BookStore/v1/Books");

		jsonString = response.asString();
		List<Map<String, String>> books = JsonPath.from(jsonString).get("books");
		Assert.assertTrue(books.size() > 0);

		bookId = books.get(0).get("isbn");	
	}

	//Adding a New record
	@When("I add a book to my reading list")
	public void i_add_a_book_to_my_reading_list() {
		RestAssured.baseURI = BASE_URL;
		RequestSpecification request = RestAssured.given();
		request.header("Authorization", "Bearer " + token)
		.header("Content-Type", "application/json");
		//Calling the POST API with request body
		response = request.body("{ \"userId\": \"" + USER_ID + "\", " +
				"\"collectionOfIsbns\": [ { \"isbn\": \"" + bookId + "\" } ]}")
				.post("/BookStore/v1/Books");
	}

	//  //Fetching the response code from the request and validating the same
	@Then("the book is added")
	public void the_book_is_added() {
		Assert.assertEquals(201, response.getStatusCode());
	}

	
	//Deleting a record
	@When("I remove a book from my reading list")
	public void i_remove_a_book_from_my_reading_list() {
		RestAssured.baseURI = BASE_URL;
		RequestSpecification request = RestAssured.given();

		request.header("Authorization", "Bearer " + token)
		.header("Content-Type", "application/json");
		//Calling the delete API with request body
		response = request.body("{ \"isbn\": \"" + bookId + "\", \"userId\": \"" + USER_ID + "\"}")
				.delete("/BookStore/v1/Book");
	}
	
	// Updating the record
	@Then("I update the book from my reading list")
	public void i_update_the_book_from_my_reading_list() {
		RestAssured.baseURI = BASE_URL;
		RequestSpecification request = RestAssured.given();
				request.header("Authorization", "Bearer " + token)
	            .header("Content-Type", "application/json");

	     //Calling the PUT API with request body
		response = request.body("{ \"isbn\": \"" + ISBN + "\", \"userId\": \"" + USER_ID + "\"}").put("/BookStore/v1/Book/9781449325862");


	}

	  //Fetching the response code from the request and validating the same
	@Then("the book is updated")
	public void the_book_is_updated() {
		Assert.assertEquals(response.getStatusCode(),200);
	}

	
	//Fetching a book by book id
	@Then("the book is removed")
	public void the_book_is_removed() {
		Assert.assertEquals(204, response.getStatusCode());

		RestAssured.baseURI = BASE_URL;
		RequestSpecification request = RestAssured.given();

		request.header("Authorization", "Bearer " + token)
		.header("Content-Type", "application/json");
		//Calling the GET API with request body 
		response = request.get("/Account/v1/User/" + USER_ID);
		Assert.assertEquals(200, response.getStatusCode());
        //making sure the book is removed 
		jsonString = response.asString();
		List<Map<String, String>> booksOfUser = JsonPath.from(jsonString).get("books");
		Assert.assertEquals(0, booksOfUser.size());
	}
}
