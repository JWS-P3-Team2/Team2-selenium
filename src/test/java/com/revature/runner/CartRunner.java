package com.revature.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features="src/test/resources/features",
        glue="com.revature.steps",
        tags = "@cart"
)
public class CartRunner extends AbstractTestNGCucumberTests {}
