# Cucumber-Selenium Tests for Congo
This repository contains the selenium-cucumber
BDD tests for the e-commerce application Congo.
The frontend and backend code for Congo may be
found in the following repositories:

- [e-commerce-react-capstone](https://github.com/JWS-P3-Team2/e-commerce-react-capstone)
- [e-commerce-spring-capstone](https://github.com/JWS-P3-Team2/e-commerce-spring-capstone)

Please consult the documentation in each repository
to setup a testing environment before
running the Selenium-Cucumber tests.

## Running Tests
All tests are run using the MainRunner.class, navigating to the
MainRunner within an IDE and clicking the run button is sufficient
to run all tests. The tests may also be run via shell by calling:

```shell
mvn test -D test=MainRunner
```

To run a suite of tests; please utilize
a custom [Cucumber tag expression](https://cucumber.io/docs/cucumber/api/?lang=java#tags).
The tag expression should be placed in the CucumberOptions
annotation on the MainRunner class. The following Cucumber
tags are supported:
- @checkout
- @login
- @notification
- @orders
- @product-reviews
- @product
- @register
- @search
- @user-profile
