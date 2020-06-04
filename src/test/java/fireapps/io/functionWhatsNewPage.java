package fireapps.io;

import commons.AbstractPage;
import commons.AbstractTest;
import commons.Constants;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.WebsitePO;

public class functionWhatsNewPage extends AbstractTest {

    private WebDriver driver;
    private AbstractPage abstractPage;
    private WebsitePO websitePage;

    @Parameters("browser")
    @BeforeClass
    public void beforeTest(String browserName) {
        driver = getBrowserDriver(browserName);
        abstractPage = new AbstractPage(driver);
        driver.get(Constants.WEBSITE_URL);
        websitePage = PageGeneratorManager.getWebsitePage(driver);
        log.info("What's New - Pre-condition: Access What's New page");
        websitePage.clickToFooterMenus("What");
        verifyTrue(websitePage.isWhatsNewPageAccessed());
    }

    @Test
    public void WhatsNew1_CheckLazyLoad(){
        log.info("What's New1: Lazy load - Check if there are more than 4 post then scroll down");
        verifyTrue(websitePage.isThereLoadingWheel());
        abstractPage.takeScreenshot("WhatsNew_Lazyload.jpg");
    }

    @Test
    public void WhatsNew2_CheckFilterByAppCheckbox(){
        log.info("What's New 2: Check the posts filtered by Ali Reviews");
//        driver.get(Constants.WHATSNEW_URL);
        websitePage.selectAppFilter(Constants.WHATSNEW_ALIREVIEWS);
        verifyTrue(websitePage.isOnlyAliReviewsPostsFiltered());
        abstractPage.takeScreenshot("WhatsNew_AliReviewFilter.jpg");
        websitePage.clickToBackToAllChanges();

        log.info("What's New 2: Check the posts filtered by Ali Orders");
//        driver.get(Constants.WHATSNEW_URL);
        websitePage.selectAppFilter(Constants.WHATSNEW_ALIORDERS);
        verifyTrue(websitePage.isOnlyAliOrdersPostsFiltered());
        abstractPage.takeScreenshot("WhatsNew_AliOrdersFilter.jpg");
        websitePage.clickToBackToAllChanges();

        log.info("What's New 2: Check the posts filtered by Sales Box");
//        driver.get(Constants.WHATSNEW_URL);
        websitePage.selectAppFilter(Constants.WHATSNEW_SALESBOX);
        verifyTrue(websitePage.isOnlySalesBoxPostsFiltered());
        abstractPage.takeScreenshot("WhatsNew_SalesBoxFilter.jpg");
        websitePage.clickToBackToAllChanges();

        log.info("What's New 2: Check the posts filtered by Ali Hunter");
//        driver.get(Constants.WHATSNEW_URL);
        websitePage.selectAppFilter(Constants.WHATSNEW_ALIHUNTER);
        verifyTrue(websitePage.isOnlyAliHunterPostsFiltered());
        abstractPage.takeScreenshot("WhatsNew_AliHunterFilter.jpg");
        websitePage.clickToBackToAllChanges();
    }

    @Test
    public void WhatsNew3_CheckSearchFunction(){
        log.info("What's New 3: Check the search function with keyword");
        websitePage.inputToWhatsNewSearch("review");
        websitePage.clickToWhatsNewSearchAction();
        verifyTrue(websitePage.isWhatsNewSearchResultContains("review"));

        log.info("What's New 3: Check the search function with no result");
        websitePage.inputToWhatsNewSearch("!@#");
        websitePage.clickToWhatsNewSearchAction();
        verifyTrue(websitePage.isWhatsNewNoResult());
        abstractPage.takeScreenshot("WhatsNew_NoResult.jpg");
        websitePage.clickToBackToAllChanges();
    }

    @Test
    public void WhatsNew4_CheckPostReaction(){

    }
}
