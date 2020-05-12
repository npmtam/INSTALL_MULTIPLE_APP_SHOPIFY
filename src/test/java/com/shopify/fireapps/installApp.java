package com.shopify.fireapps;

import commons.AbstractPage;
import commons.AbstractTest;
import commons.Constants;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.OriginalPO;
import pageObject.ShopifyPO;

public class installApp extends AbstractTest {
    private WebDriver driver;
    private AbstractPage abstractPage;
    private OriginalPO originalPO;
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
        log.info("Step 01: Open Origin Website");
        originalPO = PageGeneratorManager.getOriginalPage(driver);
        originalPO.readDataCsv();
    }

//    @AfterTest
    public void afterTest(){
        closeBrowserAndDriver(driver);
    }
}
