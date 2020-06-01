package fireapps.io;

import commons.AbstractPage;
import commons.AbstractTest;
import commons.Constants;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
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
        driver.get(Constants.WEBSITE_URL);
    }

    @Test
    public void S1_checkHeaderLinks(){
        log.info("Header 1: Home button");
        websitePage = PageGeneratorManager.getWebsitePage(driver);
        websitePage.clickToHeaderDynamic(Constants.WEBSITE_HOME_BUTTON);
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
        websitePage.clickToHeaderDynamic(Constants.WEBSITE_HOME_BUTTON);
        abstractPage.switchToWindowsByTitle("Home Page - Fireapps");
        verifyTrue(websitePage.isHomePageAccessed());
    }

    @Test
    public void S2_checkBodyFunctions(){
        log.info("Body 1: Get App Now button");
        websitePage = PageGeneratorManager.getWebsitePage(driver);
        websitePage.clickToBodyGetAppNow();
        verifyTrue(websitePage.isShopifyAppsPageAccessed());
        websitePage.clickToHeaderDynamic(Constants.WEBSITE_HOME_BUTTON);
        verifyTrue(websitePage.isHomePageAccessed());

        log.info("Body 2: Ali Review in slide bar - Get App button");
        websitePage.clickToSlideBarButtons("1");
        verifyTrue(websitePage.isLogoDisplayedAfterSelectSlidebar("ar-logo.svg"));
        websitePage.clickToGetAppButtonInSlidebar(Constants.WEBSITE_ALI_REVIEW_URL);
        verifyTrue(websitePage.isGetAppPageAccessed(Constants.WEBSITE_ALI_REVIEW_URL));
        driver.get(Constants.WEBSITE_URL);

        log.info("Body 3: Ali Orders in slide bar - Get App button");
        abstractPage.sleepInSecond(1);
        websitePage.clickToSlideBarButtons("2");
        websitePage.clickToSlideBarButtons("2");
        verifyTrue(websitePage.isLogoDisplayedAfterSelectSlidebar("ao-logo.svg"));
        websitePage.clickToGetAppButtonInSlidebar(Constants.WEBSITE_ALI_ORDERS_URL);
        verifyTrue(websitePage.isGetAppPageAccessed(Constants.WEBSITE_ALI_ORDERS_URL));
        driver.get(Constants.WEBSITE_URL);

        log.info("Body 4: Sales Box in slide bar - Get App button");
        abstractPage.sleepInSecond(1);
        websitePage.clickToSlideBarButtons("3");
        websitePage.clickToSlideBarButtons("3");
        verifyTrue(websitePage.isLogoDisplayedAfterSelectSlidebar("sb-logo.svg"));
        websitePage.clickToGetAppButtonInSlidebar(Constants.WEBSITE_SALES_BOX_URL);
        verifyTrue(websitePage.isGetAppPageAccessed(Constants.WEBSITE_SALES_BOX_URL));
        driver.get(Constants.WEBSITE_URL);

        log.info("Body 5: Ali Hunter in slide bar - Get App button");
        abstractPage.sleepInSecond(1);
        websitePage.clickToSlideBarButtons("4");
        websitePage.clickToSlideBarButtons("4");
        verifyTrue(websitePage.isLogoDisplayedAfterSelectSlidebar("ah-logo.svg"));
        websitePage.clickToGetAppButtonInSlidebar(Constants.WEBSITE_ALI_HUNTER_URL);
        verifyTrue(websitePage.isGetAppPageAccessed(Constants.WEBSITE_ALI_HUNTER_URL));
        driver.get(Constants.WEBSITE_URL);

        log.info("Body 6: Access 1st Blog post in Home Page");
        websitePage.clickToBlogPostInHomePage(Constants.BLOG_POST_TITLE1);
        verifyTrue(websitePage.isTheBlogPostAccessed(Constants.BLOG_POST_TITLE1));
        websitePage.clickToHeaderDynamic(Constants.WEBSITE_HOME_BUTTON);
        verifyTrue(websitePage.isHomePageAccessed());

        log.info("Body 7: Access 2nd Blog post in Home Page");
        websitePage.clickToBlogPostInHomePage(Constants.BLOG_POST_TITLE2);
        verifyTrue(websitePage.isTheBlogPostAccessed(Constants.BLOG_POST_TITLE2));
        websitePage.clickToHeaderDynamic(Constants.WEBSITE_HOME_BUTTON);
        verifyTrue(websitePage.isHomePageAccessed());

        log.info("Body 8: Access 3nd Blog post in Home Page");
        websitePage.clickToBlogPostInHomePage(Constants.BLOG_POST_TITLE3);
        verifyTrue(websitePage.isTheBlogPostAccessed(Constants.BLOG_POST_TITLE3));
        websitePage.clickToHeaderDynamic(Constants.WEBSITE_HOME_BUTTON);
        verifyTrue(websitePage.isHomePageAccessed());
    }

    @Test
    public void S3_CheckFooterFunctions(){
        log.info("Footer 1: Shopify Apps link");
        websitePage = PageGeneratorManager.getWebsitePage(driver);
        websitePage.clickToFooterMenus("Shopify Apps");
        verifyTrue(websitePage.isShopifyAppsPageAccessed());

        log.info("Footer 2: What's New link");
        websitePage.clickToFooterMenus("What");
        verifyTrue(websitePage.isWhatsNewPageAccessed());

        log.info("Footer 3: Contact Us link");
        websitePage.clickToFooterMenus("Contact Us");
        verifyTrue(websitePage.isContactUsPageAccessed());

        log.info("Footer 4: About Us link");
        websitePage.clickToFooterMenus("About Us");
        verifyTrue(websitePage.isAboutUsPageAccessed());

        log.info("Footer 5: Help Center link");
        websitePage.clickToFooterMenus("Help Center");
        verifyTrue(websitePage.isHelpCenterPageAccessed());
        driver.get(Constants.WEBSITE_URL);

        log.info("Footer 6: Privacy Policy link");
        websitePage.clickToFooterMenus("Privacy Policy");
        verifyTrue(websitePage.isPrivacyPolicyPageAccessed());

        log.info("Footer 7: Terms Of Service link");
        websitePage.clickToFooterMenus("Terms of Service");
        verifyTrue(websitePage.isTermsOfServicePageAccessed());
        abstractPage.sleepInSecond(1);

        log.info("Footer 8: Facebook icon");
        websitePage.clickToFooterSocialIcons("facebook-square");
        verifyTrue(websitePage.isFooterSocialAccessed(Constants.FACEBOOK_TITLE, Constants.FOOTER_FACEBOOK_URL));
        abstractPage.switchToWindowsByTitle("Terms Of Service - Fireapps");

        log.info("Footer 9: Instagram icon");
        websitePage.clickToFooterSocialIcons("instagram");
        verifyTrue(websitePage.isFooterSocialAccessed(Constants.INSTAGRAM_TITLE, Constants.FOOTER_INSTAGRAM_URL));
        abstractPage.switchToWindowsByTitle("Terms Of Service - Fireapps");

        log.info("Footer 10: Twitter icon");
        websitePage.clickToFooterSocialIcons("twitter-square");
        verifyTrue(websitePage.isFooterSocialAccessed(Constants.TWITTER_TITLE, Constants.FOOTER_TWITTER_URL));
        abstractPage.switchToWindowsByTitle("Terms Of Service - Fireapps");

        log.info("Footer 10: Youtube icon");
        websitePage.clickToFooterSocialIcons("youtube");
        verifyTrue(websitePage.isFooterSocialAccessed(Constants.YOUTUBE_TITLE, Constants.FOOTER_YOUTUBE_URL));
        abstractPage.switchToWindowsByTitle("Terms Of Service - Fireapps");
    }

    @AfterTest
    public void closeBowserAdDeleteBDatta(){
        closeBrowserAndDriver(driver);
    }
}
