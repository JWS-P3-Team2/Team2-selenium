package com.revature.steps.orders;

import com.revature.MainRunner;
import com.revature.steps.SeleniumSteps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.io.IOException;

public class ViewOrders extends SeleniumSteps {

    @When("User will click on Orders")
    public void userWillClickOnOrders() {
        wait.until(ExpectedConditions
                .visibilityOf(homePage.ordersLink)).click();
    }

    @Then("User will see all orders purchased and view details")
    public void userWillSeeAllOrdersPurchasedAndViewDetails() throws InterruptedException, IOException {
        Actions action = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOf(ordersPage.firstOrder));
        int orderLength = ordersPage.previousOrders.size();
        System.out.println("The size of previousOrders is " + orderLength);
        for (int i=0;i<= orderLength-1; i++) {
            System.out.println("The iteration of i is " + i);
            wait.until(ExpectedConditions.
                        visibilityOf(ordersPage.previousOrders.get(i)))
                        .click();
            Thread.sleep(100);
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("target/screenshots/showProductOrders" + i + ".jpg"));
            driver.navigate().back();
            wait.until(ExpectedConditions.visibilityOf(ordersPage.firstOrder));
        }
    }
}
