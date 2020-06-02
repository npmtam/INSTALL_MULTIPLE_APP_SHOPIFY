package fireapps.io;

import commons.AbstractPage;
import commons.AbstractTest;
import commons.Constants;
import commons.PageGeneratorManager;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObject.WebsitePO;

public class functionBlogPage extends AbstractTest {
    private WebDriver driver;
    private AbstractPage abstractPage;
    private WebsitePO websitePage;
    String searchKeyword;

    @Parameters("browser")
    @BeforeClass
    public void beforeTest(String browserName) {
        driver = getBrowserDriver(browserName);
        abstractPage = new AbstractPage(driver);
        driver.get(Constants.WEBSITE_URL);
        websitePage = PageGeneratorManager.getWebsitePage(driver);
        log.info("Pre-condition: Access Blog Page");
        websitePage.clickToHeaderDynamic("Blog");
        verifyTrue(websitePage.isBlogPageAccessed());
        abstractPage.takeScreenshot("BlogPage.jpg");
    }

    @Test
    public void S1_BlogHome(){
        log.info("Blog Home 1: Check slide banner display");
        websitePage.isSlideBannerInBlogHomeDisplayed();

        log.info("Blog Home 2: Verify eCommerce Marketing category has 3 slide posts");
        verifyTrue(websitePage.isCategoryHave3SlidePosts(Constants.BLOG_ECOMMERCE));

        log.info("Blog Home 3: Verify Super Tools category has 3 slide posts");
        verifyTrue(websitePage.isCategoryHave3SlidePosts(Constants.BLOG_SUPERTOOLS));

        log.info("Blog Home 4: Verify Case Studies category has 3 slide posts");
        verifyTrue(websitePage.isCategoryHave3SlidePosts(Constants.BLOG_CASESTUDIES));

        log.info("Blog Home 5: Verify Extra Talk category has 3 slide posts");
        verifyTrue(websitePage.isCategoryHave3SlidePosts(Constants.BLOG_EXTRATALK));

        log.info("Blog Home 6: Access eCommerce Marketing category and verify");
        websitePage.clickToCategoryOnMenu(Constants.BLOG_ECOMMERCE);
        verifyTrue(websitePage.isCategoryTitleEquals(Constants.BLOG_ECOMMERCE));

        log.info("Blog Home 7: Access Super Tools category and verify");
        websitePage.clickToCategoryOnMenu(Constants.BLOG_SUPERTOOLS);
        verifyTrue(websitePage.isCategoryTitleEquals(Constants.BLOG_SUPERTOOLS));

        log.info("Blog Home 6: Access Case Studies category and verify");
        websitePage.clickToCategoryOnMenu(Constants.BLOG_CASESTUDIES);
        verifyTrue(websitePage.isCategoryTitleEquals(Constants.BLOG_CASESTUDIES));

        log.info("Blog Home 6: Access Extra Talk category and verify");
        websitePage.clickToCategoryOnMenu(Constants.BLOG_EXTRATALK);
        verifyTrue(websitePage.isCategoryTitleEquals(Constants.BLOG_EXTRATALK));
    }

    @Test
    public void S2_SearchFunction(){
        searchKeyword = "Shopify";
        log.info("Search Blog 1: Search for the result");
        websitePage.clickToSearchIcon();
        websitePage.inputToSearchTextBox(searchKeyword);
        websitePage.clickToCloseSearchTextBox();
        abstractPage.sleepInSecond(1);
        websitePage.clickToSearchIcon();
        websitePage.clickToSearchActionButton();

        log.info("Search Blog 2: Check the result");
        verifyTrue(websitePage.isTheSearchResultLabelContains(searchKeyword));
        verifyTrue(websitePage.isSearchResultURLContains(searchKeyword));
        abstractPage.takeScreenshot("SearchResult.jpg");


    }

    @AfterClass
    public void afterTest(){
        closeBrowserAndDriver(driver);
    }


}
