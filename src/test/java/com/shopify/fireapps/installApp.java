package com.shopify.fireapps;

import commons.AbstractPage;
import commons.AbstractTest;
import commons.Constants;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.ShopifyPO;

public class installApp extends AbstractTest {
    private WebDriver driver;
    private AbstractPage abstractPage;
    private ShopifyPO shopifyPage;

    @Parameters("browser")
    @BeforeTest
    public void beforeTest(String browserName) {
        driver = getBrowserDriver(browserName);
        abstractPage = new AbstractPage(driver);

    }

    @Test
    public void installOriginalApp(){
        //Login
        log.info("Step 01: Open Shopify");
        driver.get(Constants.URL);

    }
}
