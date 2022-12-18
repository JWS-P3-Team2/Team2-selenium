package com.revature.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features="src/test/resources/features",
        glue="com.revature.steps",
        tags = "@checkout"
)
public class CheckoutRunner extends AbstractTestNGCucumberTests {}
