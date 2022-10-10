package com.apitesting.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/*As Cucumber uses Junit we need to have a Test Runner class. 
This class will use the Junit annotation @RunWith(), which tells JUnit what is the test runner class. 
It more like a starting point for Junit to start executing your tests
This class acts as an interlink between cucumber feature files and step definition classes*/

@RunWith(Cucumber.class)
@CucumberOptions(glue = { "com.apitesting.steps" }, features = "src/test/resources", plugin = { "pretty",
		"html:target/site/cucumber-pretty", "json:target/cucumber.json" })
public class RunCucumberTests {

}
