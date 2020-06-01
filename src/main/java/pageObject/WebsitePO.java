package pageObject;

import commons.AbstractPage;
import commons.AbstractTest;
import commons.Constants;
import commons.ReadDataCSV;
import org.openqa.selenium.WebDriver;
import pageUI.WebsiteUI;

public class WebsitePO extends AbstractPage {
    WebDriver driver;
    public String storeURL;
    AbstractTest abstractTest = new AbstractTest();
    ReadDataCSV readDataCSV = new ReadDataCSV();

    public WebsitePO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickToHeaderDynamic(String headerLink){
        waitToElementClickable(WebsiteUI.HEADER_LINKS_DYNAMIC, headerLink);
        clickToElement(WebsiteUI.HEADER_LINKS_DYNAMIC, headerLink);
    }

    public boolean isHomePageAccessed(){
        return isElementDisplayed(WebsiteUI.H4_TEXT_CONTENT, "Premium E-commerce solutions come together");
    }

    public boolean isShopifyAppsPageAccessed(){
        return isElementDisplayed(WebsiteUI.H4_TEXT_CONTENT, "Top Review App on Shopify");
    }

    public boolean isBlogPageAccessed(){
        sleepInSecond(2);
        return isElementDisplayed(WebsiteUI.BLOG_LATEST_ARTICLES_MENU);
    }

    public boolean isAffiliateTabAccessed(){
        switchToWindowsByTitle("Fireapps.io");
        return isElementDisplayed(WebsiteUI.AFFILIATE_JOIN_NOW_BUTTON);
    }

    public boolean isGetAppNowButtonWorkWell(){
        waitToElementVisible(WebsiteUI.H4_TEXT_CONTENT, "FireApps - Premium");
        return isElementDisplayed(WebsiteUI.H4_TEXT_CONTENT, "FireApps - Prenium");
    }

    public void clickToBodyGetAppNow(){
        waitToElementVisible(WebsiteUI.BODY_GET_APP_NOW_BUTTON);
        clickToElement(WebsiteUI.BODY_GET_APP_NOW_BUTTON);
    }

    public boolean isShopifyAppStoreFireAppsDisplayed(){
        waitToElementVisible(WebsiteUI.H2_TEXT_CONTENT, "FireApps - Premium Apps");
        return  isElementDisplayed(WebsiteUI.H2_TEXT_CONTENT, "FireApps - Premium Apps");
    }

    public void clickToSlideBarButtons(String numOder){
//        scrollToElement(WebsiteUI.SLIDE_BAR_BUTTONS, numOder);
        waitToElementClickable(WebsiteUI.SLIDE_BAR_BUTTONS, numOder);
        clickToElement(WebsiteUI.SLIDE_BAR_BUTTONS, numOder);
    }

    public boolean isLogoDisplayedAfterSelectSlidebar(String fileLogo){
        return isElementDisplayed(WebsiteUI.APPS_LOGO_IN_SLIDEBAR, fileLogo);
    }

    public void clickToGetAppButtonInSlidebar(String appHref){
        waitToElementVisible(WebsiteUI.GET_APP_BUTTONS_IN_SLIDEBAR, appHref);
        abstractTest.verifyTrue(isElementDisplayed(WebsiteUI.GET_APP_BUTTONS_IN_SLIDEBAR, appHref));
        clickToElement(WebsiteUI.GET_APP_BUTTONS_IN_SLIDEBAR, appHref);
    }

    public boolean isGetAppPageAccessed(String link){
        return getCurrentPageURL().equals(link);
    }

    public void clickToBlogPostInHomePage(String postTitle){
        waitToElementClickable(WebsiteUI.BLOG_POST_IN_HOME_PAGE, postTitle);
        scrollToElement(WebsiteUI.BLOG_POST_IN_HOME_PAGE, postTitle);
        clickToElementByJS(WebsiteUI.BLOG_POST_IN_HOME_PAGE, postTitle);
    }

    public boolean isTheBlogPostAccessed(String postTitle){
        waitToElementVisible(WebsiteUI.BLOG_POST_TITLE, postTitle);
        return isElementDisplayed(WebsiteUI.BLOG_POST_TITLE, postTitle);
    }

    public void clickToFooterMenus(String menuText){
        scrollToElement(WebsiteUI.FOOTER_MENUS, menuText);
        waitToElementClickable(WebsiteUI.FOOTER_MENUS, menuText);
        clickToElement(WebsiteUI.FOOTER_MENUS, menuText);
    }

    public boolean isWhatsNewPageAccessed(){
        return isElementDisplayed(WebsiteUI.WHATS_NEW_LOGO);
    }

    public boolean isContactUsPageAccessed(){
        return isElementDisplayed(WebsiteUI.EMAIL_TEXTBOX_CONTACT_US);
    }

    public boolean isAboutUsPageAccessed(){
        return isElementDisplayed(WebsiteUI.FOOTER_REDIRECT_PAGE_TITLE, "About Us");
    }

    public boolean isHelpCenterPageAccessed(){
        return getCurrentPageURL().equals(Constants.HELP_CENTER_URL);
    }

    public boolean isPrivacyPolicyPageAccessed(){
        return isElementDisplayed(WebsiteUI.FOOTER_REDIRECT_PAGE_TITLE, "Privacy Policy");
    }

    public boolean isTermsOfServicePageAccessed(){
        return isElementDisplayed(WebsiteUI.FOOTER_REDIRECT_PAGE_TITLE, "Terms Of Service");
    }

    public void clickToFooterSocialIcons(String socialNetwork){
        waitToElementClickable(WebsiteUI.FOOTER_SOCIAL_ICONS, socialNetwork);
        clickToElement(WebsiteUI.FOOTER_SOCIAL_ICONS, socialNetwork);
    }

    public boolean isFooterSocialAccessed(String tabTitle, String expectedURL){
        switchToWindowsByTitle(tabTitle);
        return getCurrentPageURL().equals(expectedURL);
    }
}
