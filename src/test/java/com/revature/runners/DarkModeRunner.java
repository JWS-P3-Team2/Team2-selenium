package com.revature.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features="src/test/resources/features",
        glue="com.revature.steps",
        tags = "@dark-mode"
)
public class DarkModeRunner extends AbstractTestNGCucumberTests {}
