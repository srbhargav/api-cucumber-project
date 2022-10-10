# API Automation Test BDD framework
API Automation Test is RestAssured based Cucumber framework to perform API testing. This project is useful as an example of API Testing with RestAssured and Java.

## Installation

Pre-requisite You need to have following softwares installed on your computer

1) Install JDK 1.8 and set path
2) Install Maven and set path
3) Eclipse
4) Eclipse Plugins: Maven and Cucumber

## Getting Started
```
1. git clone https://github.com/srbhargav/APICucumberFreamwork.git"
2. Navigate to api-cucumber-project
```

## Project structure

1) src/test/resources/feature - Cucumber features files
2) src/test/java/steps - Cucumber step defination class
3) src/test/java/runners - Cucumber test runner class

## Writing test cases
The cucumber features goes in the features library and should have the ".feature" extension.

You can start out by looking at src/test/resources/feature. You can extend this feature or make your own features using some of the predefined steps.

**In terminal from root project folder (RestasssuredCucumber), run below commands as required**

Run Tests
- To run all features `mvn clean test verify`

  
Report Path  
- Cucumber HTML Report: `{ROOT_PROJECT_FOLDER}/target/cucumber-html-reports/overview-features.html`


### Key Features
	- Detailed Cucumber Report
	- Reusable methods to perform GET, POST, PUT, DELETE operations
	
## Contributing
1) Create your feature branch: git checkout -b my-new-feature
2) Commit your changes: git commit -am 'Add some feature'
3) Push to the branch: git push origin my-new-feature
4) Submit a pull request
5) Please make sure to update tests as appropriate.


