package com.revature;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features="src/test/resources/features",
        glue="com.revature.steps.bookended",
        tags="@user-profile and @test"
)
public class BookendRunner extends AbstractTestNGCucumberTests {}
