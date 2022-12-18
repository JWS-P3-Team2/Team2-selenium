package com.revature.steps.product;

import com.revature.Urls;
import com.revature.pages.EditProductPage;
import com.revature.pages.EditProductsPage;
import com.revature.pages.CreateProductPage;
import com.revature.steps.SeleniumSteps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
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

    private void awaitModalAnimationEnd() {
        wait.until(driver -> {
            String opacity = homePage.productModal.getCssValue("opacity");
            return opacity.equals("1");
        });
    }

    private Integer countEditableProducts() {
        return wait.until(driver -> {
            Integer size = editProductsPage.products.size();
            if (size != 0) return size;
            else return null;
        });
    }

    @When("User clicks on edit products")
    public void userClicksOnEditProducts() {
        // sometimes edit product takes awhile to load
        wait.until(
            ExpectedConditions.elementToBeClickable(
                    homePage.editProductLink
            )
        ).click();
        wait.until(ExpectedConditions.urlMatches(Urls.editProducts + "/?"));
        editProductsPage = new EditProductsPage(driver);
        productCounter = countEditableProducts();
    }

    @When("User clicks create new product on create product page")
    public void userClicksCreateNewProduct() {
        createProductPage.createNew.click();
        ExpectedConditions.urlMatches(Urls.editProductBase + "/\\d+");
        editProductPage = PageFactory.initElements(driver, EditProductPage.class);
        // sometime the modal takes awhile to load
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        editProductPage.backToProduct
                )
        );
    }
    

    @When("User clicks back to products")
    public void userClicksBackToProducts() {
        editProductPage.backToProduct.click();
        wait.until(ExpectedConditions.urlMatches(Urls.editProducts + "/?"));
        editProductsPage = new EditProductsPage(driver);
    }

    @Then("An error message should appear")
    public void anErrorMessageShouldAppear() {
        wait.until(ExpectedConditions.alertIsPresent());
    }

    @Then("The new product should not appear as the latest product")
    public void theNewProductShouldNotAppearAsTheLatestProduct() {
        int newProductSize = countEditableProducts();
        Assert.assertEquals(newProductSize, productCounter);
    }

    @When("User clicks on an existing product")
    public void userClicksOnAnExistingProduct() {
        editProductsPage.products.get(0).click();
        wait.until(
                ExpectedConditions.urlMatches(
                        Urls.editProductBase + "/\\d+"
                )
        );
        editProductPage = PageFactory.initElements(
                driver,
                EditProductPage.class
        );
        // sometime the modal takes awhile to load
        wait.until(
            ExpectedConditions.elementToBeClickable(
                editProductPage.backToProduct
            )
        );
    }

    @When("User inputs {string} in product name")
    public void userInputsProductName(String arg1) {
        createProductPage.productInputs.get(1).sendKeys(arg1);
    }
    @When("User inputs {string} in product description")
    public void userInputsProductDescription(String arg1) {
        createProductPage.productInputs.get(2).sendKeys(arg1);

    }
    @When("User inputs {string} in product url")
    public void userInputsProductUrl(String arg1) {
        createProductPage.productInputs.get(3).sendKeys(arg1);
    }
    @When("User inputs {string} in product price")
    public void userInputsProductPrice(String arg1) {
        createProductPage.productInputs.get(4).sendKeys(arg1);
    }
    @When("User clicks update")
    public void userClicksUpdate() {
        editProductPage.updateProduct.click();
    }

    @Then("The product should be updated {string} {string} {string} {string}")
    public void theProductShouldBeUpdated(String name, String description, String url, String price) {
        wait.until(ExpectedConditions.visibilityOf(editProductsPage.products.get(0)));
        savedName = editProductsPage.productNames.get(0).getText();
        savedDescription = editProductsPage.productDescriptions.get(0).getText();
        savedUrl = editProductsPage.productImages.get(0).getAttribute("src");
        savedPrice = editProductsPage.productPrices.get(0).getText();
        savedPrice = savedPrice.replace("$","");

        Assert.assertEquals(savedName,name);
        Assert.assertEquals(savedDescription,description);
        Assert.assertEquals(savedUrl,url);
        Assert.assertEquals(String.valueOf((int)Double.parseDouble(savedPrice)),price);
    }

    @Then("The new product should appear as the latest product {string} {string} {string} {string}")
    public void theNewProductShouldAppearAsTheLatestProduct(String name, String description, String url, String price) {
        int newProductSize = countEditableProducts();
        savedName = editProductsPage.productNames.get(newProductSize - 1).getText();
        savedDescription = editProductsPage.productDescriptions.get(newProductSize - 1).getText();
        savedUrl = editProductsPage.productImages.get(newProductSize - 1).getAttribute("src");
        savedPrice = editProductsPage.productPrices.get(newProductSize - 1).getText();
        savedPrice = savedPrice.replace("$","");
        Assert.assertEquals(savedName,name);
        Assert.assertEquals(savedDescription,description);
        Assert.assertEquals(savedUrl,url);
        Assert.assertEquals(String.valueOf((int)Double.parseDouble(savedPrice)),price);
        Assert.assertTrue(newProductSize == productCounter + 1);
    }

    @When("User inputs {string} in product name on the update page")
    public void userInputsProductNameInProductNameOnTheUpdatePage(String arg1) {
        editProductPage.productInputs.get(1).clear();
        editProductPage.productInputs.get(1).sendKeys(arg1);
    }

    @When("User inputs {string} in product description on the update page")
    public void userInputsProductDescriptionInProductDescriptionOnTheUpdatePage(String arg1) {
        editProductPage.productInputs.get(3).clear();
        editProductPage.productInputs.get(3).sendKeys(arg1);
    }

    @When("User inputs {string} in product url on the update page")
    public void userInputsProductImageUrlInProductUrlOnTheUpdatePage(String arg1) {
        editProductPage.productInputs.get(2).clear();
        editProductPage.productInputs.get(2).sendKeys(arg1);
    }

    @When("User inputs {string} in product price on the update page")
    public void userInputsProductPriceInProductPriceOnTheUpdatePage(String arg1) {
        editProductPage.productInputs.get(4).clear();
        editProductPage.productInputs.get(4).sendKeys(arg1);
    }

    @Then("The product should not be updated {string} {string} {string} {string}")
    public void theProductShouldNotBeUpdated(String name, String description, String url, String price) {
        wait.until(ExpectedConditions.visibilityOf(editProductsPage.products.get(0)));
        savedName = editProductsPage.productNames.get(0).getText();
        savedDescription = editProductsPage.productDescriptions.get(0).getText();
        savedUrl = editProductsPage.productImages.get(0).getAttribute("src");
        savedPrice = editProductsPage.productPrices.get(0).getText();
        savedPrice = savedPrice.replace("$","");

        Assert.assertNotEquals(savedName,name);
        Assert.assertNotEquals(savedDescription,description);
        Assert.assertNotEquals(savedUrl,url);
        Assert.assertNotEquals(String.valueOf((int)Double.parseDouble(savedPrice)),price);
    }

    @Then("The user should see a list of available products")
    public void theUserShouldSeeAListOfAvailableProducts() {
        Assert.assertTrue(homePage.allProducts.size() != 0);
    }

    @Then("The user should review description of all products")
    public void theUserShouldReviewDescriptionOfAllProducts() throws IOException {
        Actions action = new Actions(driver);
        WebElement descButton;
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
        editProductsPage.createNew.click();
        wait.until(ExpectedConditions.urlMatches(Urls.createProduct));
        createProductPage = new CreateProductPage(driver);
    }
}
