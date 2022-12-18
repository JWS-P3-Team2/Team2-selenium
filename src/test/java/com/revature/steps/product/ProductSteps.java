package com.revature.steps.product;

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
import org.testng.Assert;

import java.io.File;
import java.io.IOException;

public class ProductSteps extends SeleniumSteps {
    int productCounter;
    String savedName = "";
    String savedDescription = "";
    String savedUrl = "";
    String savedPrice = "";

    private void awaitHomePageProducts() {
        wait.until(driver -> {
            return (homePage.allProducts.size() != 0);
        });
    }

    private void awaitModalAnimationEnd() {
        wait.until(driver -> {
            String opacity = homePage.productModal.getCssValue("opacity");
            return opacity.equals("1");
        });
    }

    @When("User clicks on edit products")
    public void userClicksOnEditProducts() {
        awaitHomePageProducts();
        productCounter = homePage.allProducts.size();
        homePage.editProductLink.click();
    }

    @When("User clicks create new product on create product page")
    public void userClicksCreateNewProduct() {
        wait.until(ExpectedConditions.visibilityOf(adminProductPage.createNew));
        adminCreateProductPage.createNew.click();
    }
    

    @When("User clicks back to products")
    public void userClicksBackToProducts() {
        wait.until(ExpectedConditions.urlMatches("/admin/product/\\d+$"));
        adminProductPage.backToProduct.click();
    }

    @Then("An error message should appear")
    public void anErrorMessageShouldAppear() {
        wait.until(ExpectedConditions.alertIsPresent());
    }

    @Then("The new product should not appear as the latest product")
    public void theNewProductShouldNotAppearAsTheLatestProduct() {
        awaitHomePageProducts();
        int newProductSize = homePage.allProducts.size();
        Assert.assertEquals(newProductSize, productCounter);
    }

    @When("User clicks on an existing product")
    public void userClicksOnAnExistingProduct() {
        wait.until(ExpectedConditions.visibilityOf(adminCreateProductPage.products));
        adminCreateProductPage.products.click();

    }

    @When("User inputs {string} in product name")
    public void userInputsProductName(String arg1) {
        wait.until(ExpectedConditions.visibilityOf(adminProductPage.createNew));
        adminProductPage.productInputs.get(1).sendKeys(arg1);

    }
    @When("User inputs {string} in product description")
    public void userInputsProductDescription(String arg1) {
        adminProductPage.productInputs.get(2).sendKeys(arg1);

    }
    @When("User inputs {string} in product url")
    public void userInputsProductUrl(String arg1) {
        adminProductPage.productInputs.get(3).sendKeys(arg1);

    }
    @When("User inputs {string} in product price")
    public void userInputsProductPrice(String arg1) {
        adminProductPage.productInputs.get(4).sendKeys(arg1);
    }
    @When("User clicks update")
    public void userClicksUpdate() {
        wait.until(ExpectedConditions.visibilityOf(adminProductPage.updateProduct));
        adminProductPage.updateProduct.click();
    }

    @Then("The product should be updated {string} {string} {string} {string}")
    public void theProductShouldBeUpdated(String name, String description, String url, String price) {
        wait.until(ExpectedConditions.visibilityOf(adminCreateProductPage.products));
        savedName = adminCreateProductPage.productNames.get(0).getText();
        savedDescription = adminCreateProductPage.productDescriptions.get(0).getText();
        savedUrl = adminCreateProductPage.productImages.get(0).getAttribute("src");
        savedPrice = adminCreateProductPage.productPrices.get(0).getText();
        savedPrice = savedPrice.replace("$","");

        Assert.assertEquals(savedName,name);
        Assert.assertEquals(savedDescription,description);
        Assert.assertEquals(savedUrl,url);
        Assert.assertEquals(String.valueOf((int)Double.parseDouble(savedPrice)),price);

    }

    @Then("The new product should appear as the latest product {string} {string} {string} {string}")
    public void theNewProductShouldAppearAsTheLatestProduct(String name, String description, String url, String price) {

        awaitHomePageProducts();
        int newProductSize = homePage.allProducts.size();
        savedName = adminCreateProductPage.productNames.get(newProductSize - 1).getText();
        savedDescription = adminCreateProductPage.productDescriptions.get(newProductSize - 1).getText();
        savedUrl = adminCreateProductPage.productImages.get(newProductSize - 1).getAttribute("src");
        savedPrice = adminCreateProductPage.productPrices.get(newProductSize - 1).getText();
        savedPrice = savedPrice.replace("$","");
        Assert.assertEquals(savedName,name);
        Assert.assertEquals(savedDescription,description);
        Assert.assertEquals(savedUrl,url);
        Assert.assertEquals(String.valueOf((int)Double.parseDouble(savedPrice)),price);
        Assert.assertTrue(newProductSize == productCounter + 1);
    }

    @When("User inputs {string} in product name on the update page")
    public void userInputsProductNameInProductNameOnTheUpdatePage(String arg1) {
        wait.until(ExpectedConditions.visibilityOf(adminProductPage.updateProduct));
        adminProductPage.productInputs.get(1).clear();
        adminProductPage.productInputs.get(1).sendKeys(arg1);
    }

    @When("User inputs {string} in product description on the update page")
    public void userInputsProductDescriptionInProductDescriptionOnTheUpdatePage(String arg1) {
        adminProductPage.productInputs.get(3).clear();
        adminProductPage.productInputs.get(3).sendKeys(arg1);
    }

    @When("User inputs {string} in product url on the update page")
    public void userInputsProductImageUrlInProductUrlOnTheUpdatePage(String arg1) {
        adminProductPage.productInputs.get(2).clear();
        adminProductPage.productInputs.get(2).sendKeys(arg1);
    }

    @When("User inputs {string} in product price on the update page")
    public void userInputsProductPriceInProductPriceOnTheUpdatePage(String arg1) {
        adminProductPage.productInputs.get(4).clear();

        adminProductPage.productInputs.get(4).sendKeys(arg1);
    }

    @Then("The product should not be updated {string} {string} {string} {string}")
    public void theProductShouldNotBeUpdated(String name, String description, String url, String price) {
        wait.until(ExpectedConditions.visibilityOf(adminCreateProductPage.products));
        savedName = adminCreateProductPage.productNames.get(0).getText();
        savedDescription = adminCreateProductPage.productDescriptions.get(0).getText();
        savedUrl = adminCreateProductPage.productImages.get(0).getAttribute("src");
        savedPrice = adminCreateProductPage.productPrices.get(0).getText();
        savedPrice = savedPrice.replace("$","");

        Assert.assertNotEquals(savedName,name);
        Assert.assertNotEquals(savedDescription,description);
        Assert.assertNotEquals(savedUrl,url);
        Assert.assertNotEquals(String.valueOf((int)Double.parseDouble(savedPrice)),price);
    }

    @Then("The user should see a list of available products")
    public void theUserShouldSeeAListOfAvailableProducts() {
        awaitHomePageProducts();
    }

    @Then("The user should review description of all products")
    public void theUserShouldReviewDescriptionOfAllProducts() throws IOException {
        Actions action = new Actions(driver);
        WebElement descButton;
        awaitHomePageProducts();
        int i = 1;
        for (WebElement elem : homePage.allProducts) {
            wait.until(ExpectedConditions.visibilityOf(elem));
            action.moveToElement(elem).perform();
            descButton = driver.findElement(By.xpath("//*[@id='root']/div[3]/div[" + i + "]/div/div[1]/div[2]/div"));
            descButton.click();
            awaitModalAnimationEnd();
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("target/screenshots/showProductDetails" + i + ".jpg"));
            homePage.productModalCloseButton.click();
            i++;
        }

    }

    @When("User clicks create new product on admin product page")
    public void userClicksCreateNewProductOnAdminProduct() {
        wait.until(ExpectedConditions.visibilityOf(adminProductPage.createNew));
        adminProductPage.createNew.click();
    }
}
