package com.revature.steps.display;

import com.revature.MainRunner;
import io.cucumber.java.en.Then;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.io.IOException;

import static com.revature.MainRunner.driver;

public class DisplayProducts {

    @Then("The user should review description of all products")
    public void theUserShouldReviewDescriptionOfAllProducts() throws InterruptedException, IOException {
        Actions action = new Actions(driver);
        WebElement descButton;
        System.out.println("It runs!");
        int i = 1;
        MainRunner.wait.until(ExpectedConditions.visibilityOf(MainRunner.homePage.firstProduct));
        for (WebElement elem : MainRunner.homePage.allProducts) {
            System.out.println("It iterates!");
            MainRunner.wait.until(ExpectedConditions.visibilityOf(elem));
            action.moveToElement(elem).perform();
            descButton = driver.findElement(By.xpath("//*[@id='root']/div[3]/div[" + i + "]/div/div[1]/div[2]/div"));
            descButton.click();
            MainRunner.wait.until(ExpectedConditions.visibilityOf(MainRunner.homePage.productModalCloseButton));
            Thread.sleep(100);
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("src/test/java/screenshots/showProductDetails" + i + ".jpg"));
            MainRunner.homePage.productModalCloseButton.click();
            i++;
        }

    }
}
