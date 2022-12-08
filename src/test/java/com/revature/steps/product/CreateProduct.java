package com.revature.steps.product;

import com.revature.MainRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class CreateProduct {
    int productCounter;
    String savedName = "";
    String savedDescription = "";
    String savedUrl = "";
    String savedPrice = "";

    private void awaitHomePageProducts() {
        MainRunner.wait.until(driver -> {
            return (MainRunner.homePage.allProducts.size() != 0);
        });
    }

    @When("User clicks on edit products")
    public void userClicksOnEditProducts() {
        awaitHomePageProducts();
        productCounter = MainRunner.homePage.allProducts.size();
        MainRunner.homePage.editProductLink.click();
    }

    @When("User clicks create new product")
    public void userClicksCreateNewProduct() {
        MainRunner.wait.until(ExpectedConditions.visibilityOf(MainRunner.adminProduct.createNew));
        MainRunner.adminProduct.createNew.click();
    }
    

    @When("User clicks back to products")
    public void userClicksBackToProducts() {
        MainRunner.wait.until(ExpectedConditions.elementToBeClickable(MainRunner.adminProduct.backToProduct));
        MainRunner.adminProduct.backToProduct.click();
    }

    @Then("An error message should appear")
    public void anErrorMessageShouldAppear() {
        MainRunner.wait.until(ExpectedConditions.alertIsPresent());
    }

    @Then("The new product should not appear as the latest product")
    public void theNewProductShouldNotAppearAsTheLatestProduct() {
        awaitHomePageProducts();
        int newProductSize = MainRunner.homePage.allProducts.size();
        Assert.assertEquals(newProductSize, productCounter);
    }

    @When("User clicks on an existing product")
    public void userClicksOnAnExistingProduct() {
        MainRunner.wait.until(ExpectedConditions.visibilityOf(MainRunner.adminProduct.products));
        MainRunner.adminProduct.products.click();

    }

    @When("User inputs {string} in product name")
    public void userInputsProductName(String arg1) {
        MainRunner.wait.until(ExpectedConditions.visibilityOf(MainRunner.adminProduct.createNew));

        MainRunner.adminProduct.productInputs.get(1).sendKeys(arg1);

    }
    @When("User inputs {string} in product description")
    public void userInputsProductDescription(String arg1) {
        MainRunner.adminProduct.productInputs.get(2).sendKeys(arg1);

    }
    @When("User inputs {string} in product url")
    public void userInputsProductUrl(String arg1) {
        MainRunner.adminProduct.productInputs.get(3).sendKeys(arg1);

    }
    @When("User inputs {string} in product price")
    public void userInputsProductPrice(String arg1) {
        MainRunner.adminProduct.productInputs.get(4).sendKeys(arg1);
    }
    @When("User clicks update")
    public void userClicksUpdate() {
        MainRunner.wait.until(ExpectedConditions.visibilityOf(MainRunner.adminProduct.updateProduct));
        MainRunner.adminProduct.updateProduct.click();
    }

    @Then("The product should be updated {string} {string} {string} {string}")
    public void theProductShouldBeUpdated(String name, String description, String url, String price) {
        MainRunner.wait.until(ExpectedConditions.visibilityOf(MainRunner.adminProduct.products));
        savedName = MainRunner.adminProduct.productNames.get(0).getText();
        savedDescription = MainRunner.adminProduct.productDescriptions.get(0).getText();
        savedUrl = MainRunner.adminProduct.productImages.get(0).getAttribute("src");
        savedPrice = MainRunner.adminProduct.productPrices.get(0).getText();
        savedPrice = savedPrice.replace("$","");

        Assert.assertEquals(savedName,name);
        Assert.assertEquals(savedDescription,description);
        Assert.assertEquals(savedUrl,url);
        Assert.assertEquals(String.valueOf((int)Double.parseDouble(savedPrice)),price);

    }

    @Then("The new product should appear as the latest product {string} {string} {string} {string}")
    public void theNewProductShouldAppearAsTheLatestProduct(String name, String description, String url, String price) {

        awaitHomePageProducts();
        int newProductSize = MainRunner.homePage.allProducts.size();
        savedName = MainRunner.adminProduct.productNames.get(newProductSize - 1).getText();
        savedDescription = MainRunner.adminProduct.productDescriptions.get(newProductSize - 1).getText();
        savedUrl = MainRunner.adminProduct.productImages.get(newProductSize - 1).getAttribute("src");
        savedPrice = MainRunner.adminProduct.productPrices.get(newProductSize - 1).getText();
        savedPrice = savedPrice.replace("$","");
        Assert.assertEquals(savedName,name);
        Assert.assertEquals(savedDescription,description);
        Assert.assertEquals(savedUrl,url);
        Assert.assertEquals(String.valueOf((int)Double.parseDouble(savedPrice)),price);
        Assert.assertTrue(newProductSize == productCounter + 1);
    }

    @When("User inputs {string} in product name on the update page")
    public void userInputsProductNameInProductNameOnTheUpdatePage(String arg1) {
        MainRunner.wait.until(ExpectedConditions.visibilityOf(MainRunner.adminProduct.updateProduct));

        MainRunner.adminProduct.productInputs.get(1).clear();
        MainRunner.adminProduct.productInputs.get(1).sendKeys(arg1);
    }

    @When("User inputs {string} in product description on the update page")
    public void userInputsProductDescriptionInProductDescriptionOnTheUpdatePage(String arg1) {
        MainRunner.adminProduct.productInputs.get(3).clear();

        MainRunner.adminProduct.productInputs.get(3).sendKeys(arg1);

    }

    @When("User inputs {string} in product url on the update page")
    public void userInputsProductImageUrlInProductUrlOnTheUpdatePage(String arg1) {
        MainRunner.adminProduct.productInputs.get(2).clear();

        MainRunner.adminProduct.productInputs.get(2).sendKeys(arg1);

    }

    @When("User inputs {string} in product price on the update page")
    public void userInputsProductPriceInProductPriceOnTheUpdatePage(String arg1) {
        MainRunner.adminProduct.productInputs.get(4).clear();

        MainRunner.adminProduct.productInputs.get(4).sendKeys(arg1);
    }

    @Then("The product should not be updated {string} {string} {string} {string}")
    public void theProductShouldNotBeUpdated(String name, String description, String url, String price) {
        MainRunner.wait.until(ExpectedConditions.visibilityOf(MainRunner.adminProduct.products));
        savedName = MainRunner.adminProduct.productNames.get(0).getText();
        savedDescription = MainRunner.adminProduct.productDescriptions.get(0).getText();
        savedUrl = MainRunner.adminProduct.productImages.get(0).getAttribute("src");
        savedPrice = MainRunner.adminProduct.productPrices.get(0).getText();
        savedPrice = savedPrice.replace("$","");

        Assert.assertNotEquals(savedName,name);
        Assert.assertNotEquals(savedDescription,description);
        Assert.assertNotEquals(savedUrl,url);
        Assert.assertNotEquals(String.valueOf((int)Double.parseDouble(savedPrice)),price);
    }
}
