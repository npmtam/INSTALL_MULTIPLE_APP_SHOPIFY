package fireapps.io;

import commons.AbstractPage;
import commons.AbstractTest;
import commons.PageGeneratorManager;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.OriginalPO;
import pageObject.WebsitePO;

public class checkWebsiteFunctions extends AbstractTest {
    private WebDriver driver;
    private AbstractPage abstractPage;
    private WebsitePO websitePage;

    @Parameters("browser")
    @BeforeTest
    public void beforeTest(String browserName){
        driver = getBrowserDriver(browserName);
        abstractPage = new AbstractPage(driver);
        driver.get("https://beta.fireapps.io");
    }

    @Test
    public void checkHeaderLinks(){
        log.info("Header 1: Home button");
        websitePage = PageGeneratorManager.getWebsitePage(driver);
        websitePage.clickToHeaderDynamic("Home");
        verifyTrue(websitePage.isHomePageAccessed());

        log.info("Header 2: Shopify apps button");
        websitePage.clickToHeaderDynamic("SHOPIFY APPS");
        verifyTrue(websitePage.isShopifyAppsPageAccessed());

        log.info("Header 3: Blog button");
        websitePage.clickToHeaderDynamic("Blog");
        verifyTrue(websitePage.isBlogPageAccessed());

        log.info("Header 4: Affiliate button");
        websitePage.clickToHeaderDynamic("Affiliate");
        verifyTrue(websitePage.isAffiliateTabAccessed());
        abstractPage.switchToWindowsByTitle("Blog - Fireapps");
        verifyTrue(websitePage.isBlogPageAccessed());

        log.info("Header 5: Get App Now button");
        websitePage.clickToHeaderDynamic("Get App Now");
        abstractPage.switchToWindowsByTitle("Apps by FireApps - Premium Apps on the Shopify App Store");
        verifyTrue(websitePage.isShopifyAppStoreFireAppsDisplayed());
        abstractPage.switchToWindowsByTitle("Blog - Fireapps");
        websitePage.clickToHeaderDynamic("Home");
        verifyTrue(websitePage.isHomePageAccessed());
    }

    @Test
    public void checkBodyFunctions(){
        log.info("Body 1: Get App Now button");
        websitePage = PageGeneratorManager.getWebsitePage(driver);
        websitePage.clickToBodyGetAppNow();
        verifyTrue(websitePage.isShopifyAppsPageAccessed());
        websitePage.clickToHeaderDynamic("Home");
        verifyTrue(websitePage.isHomePageAccessed());

        log.info("Body 2: Ali Review in slide bar");
        websitePage.
    }

    @AfterTest
    public void closeBowserAdDeleteBDatta(){
        closeBrowserAndDriver(driver);
    }
}
