package com.shopify.fireapps;

import commons.AbstractPage;
import commons.AbstractTest;
import commons.Constants;
import commons.PageGeneratorManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import pageObject.ShopifyPO;

public class createStore extends AbstractTest {
    private WebDriver driver;
    private AbstractPage abstractPage;
    private ShopifyPO shopifyPage;
    String email, storeName;


    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName){
        driver = getBrowserDriver(browserName);
        driver.get(Constants.URL);
        abstractPage = new AbstractPage(driver);
    }

    @Test
    public void TC01_CreateShopifyStore(){
        email = Constants.EMAIL + abstractPage.randomNumber() + "@mail.com";
        storeName = Constants.STORE_NAME + abstractPage.randomNumber();

        log.info("Step 01: Press on Start free trial button");
        shopifyPage = PageGeneratorManager.getShopifyPage(driver);
        shopifyPage.clickToStartFreeTrialBtn();

        log.info("Step 02: Fill info to register");
        shopifyPage.inputToRegisterTextBoxes("Email address", email);
        shopifyPage.inputToRegisterTextBoxes("Password", Constants.SHOPIFY_PASSWORD);
        shopifyPage.inputToRegisterTextBoxes("Your store name", storeName);

        log.info("Step 03: Press Create your store button");
        shopifyPage.clickToCreateYourStoreButton();

        log.info("Step 04: Verify the user can create the store");
        verifyTrue(shopifyPage.isCreateStoreSuccessfully());


    }
}
