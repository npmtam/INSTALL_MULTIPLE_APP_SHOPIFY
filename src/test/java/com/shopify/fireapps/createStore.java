package com.shopify.fireapps;

import commons.AbstractPage;
import commons.AbstractTest;
import commons.Constants;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObject.ShopifyPO;
import pageUI.ShopifyPageUI;

import java.util.Random;

public class createStore extends AbstractTest {
    private WebDriver driver;
    private AbstractPage abstractPage;
    private ShopifyPO shopifyPage;
    String email, storeName, storeNameBackup, phoneNumber;
    boolean isStoreNameExisted;
    public int randomNumber;


    @Parameters("browser")
    @BeforeTest
    public void beforeTest(String browserName) {
        driver = getBrowserDriver(browserName);
        abstractPage = new AbstractPage(driver);
    }

    @Test(invocationCount = 2)
    public void TC01_CreateShopifyStore() {
        //Init data
        Random random = new Random();
        randomNumber = random.nextInt(999);

        email = Constants.EMAIL + randomNumber + "@mail.com";
        storeName = Constants.STORE_NAME + " " + randomNumber;
        storeNameBackup = Constants.STORE_NAME + " " + abstractPage.randomNumber(Constants.RAMDOM_BOUND);
        phoneNumber = Constants.PHONE_NUMBER + abstractPage.randomNumber(Constants.RAMDOM_BOUND);

        //Create store test
        log.info("Pre-condition: Access Shopify");
        driver.get(Constants.URL);

        log.info("Step 01: Press on Start free trial button");
        shopifyPage = PageGeneratorManager.getShopifyPage(driver);
        shopifyPage.clickToStartFreeTrialBtn();

        log.info("Step 02: Fill info to register");
        shopifyPage.inputToRegisterTextBoxes("Email address", email);
        shopifyPage.inputToRegisterTextBoxes("Password", Constants.SHOPIFY_PASSWORD);
        shopifyPage.inputToRegisterTextBoxes("Your store name", storeName);

        log.info("Step 03: Press Create your store button");
        isStoreNameExisted = abstractPage.isElementPresentInDOM(ShopifyPageUI.ERR_NAME_EXISTS);
        if (isStoreNameExisted) {
            shopifyPage.inputToRegisterTextBoxes("Your store name", storeNameBackup);
        } else {
            shopifyPage.clickToCreateYourStoreButton();
        }

        log.info("Step 04: Verify the user can create the store");
        verifyTrue(shopifyPage.isRegisterInfoAcceptable());

        log.info("Step 05: Fill info at About yourself");
        boolean isDropdownStepChanged = abstractPage.isElementPresentInDOM(ShopifyPageUI.DROPDOWN_SEEDING_QUESTION);
        if (isDropdownStepChanged) {
            shopifyPage.selectAlreadySellingDropdown(Constants.ALREADY_SELLING);
            shopifyPage.selectCurrentRevenueDropdown(Constants.CURRENT_REVENUE);
            shopifyPage.selectIndustryDropdown(Constants.INDUSTRY);
        } else {
            shopifyPage.selectDescribesDropdown(1);
        }
        shopifyPage.clickToNextButton();

        log.info("Step 06: Fill address");
        shopifyPage.inputAddressTextboxes("firstName", Constants.FIRST_NAME);
        shopifyPage.inputAddressTextboxes("lastName", Constants.LAST_NAME);
        shopifyPage.inputAddressTextboxes("address1", Constants.ADDRESS);
        shopifyPage.inputAddressTextboxes("city", Constants.CITY);
        shopifyPage.inputAddressTextboxes("zip", Constants.ZIPCODE);
        shopifyPage.inputAddressTextboxes("phone", phoneNumber);
        shopifyPage.clickToEnterMyStoreButton();

        log.info("Step 07: Verify the store has been created");
        verifyTrue(shopifyPage.isTheStoreCreated());
        shopifyPage.printStoreURL();
        System.out.println("Email: " + email);
        System.out.println("Store Name: " + storeName);

        log.info("Step 08: Write data to the csv");
        shopifyPage.writeDataToCsv(Constants.CSV_FILE_PATH, email, storeName);
        System.out.println("Written Data");
    }

    @AfterClass
    public void quitBrowser(){
        closeBrowserAndDriver(driver);
    }
}
