package com.revature;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features="src/test/resources/features",
        glue="com.revature.steps",
        tags="@user-profile-smoke"
)
public class ExperimentalRunner extends AbstractTestNGCucumberTests {}
