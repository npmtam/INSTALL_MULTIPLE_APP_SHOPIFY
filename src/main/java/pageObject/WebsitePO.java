package pageObject;

import commons.AbstractPage;
import commons.AbstractTest;
import commons.Constants;
import commons.ReadDataCSV;
import org.openqa.selenium.JavascriptExecutor;
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
        scrollToElement(WebsiteUI.APPS_LOGO_IN_SLIDEBAR, fileLogo);
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

    public void clickToBackToTopButton(){
        scrollToElement(WebsiteUI.FOOTER_MENUS, "Terms of Service");
        waitToElementClickable(WebsiteUI.BACK_TO_TOP_BUTTON);
        clickToElement(WebsiteUI.BACK_TO_TOP_BUTTON);
    }

    public boolean isPageBackToTop(){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        sleepInSecond(1);
        Long value = (Long) jsExecutor.executeScript("return window.pageYOffset;");
        return value==0;
    }

    public boolean isSlideBannerInBlogHomeDisplayed(){
        return isElementDisplayed(WebsiteUI.BLOG_HOME_SLIDE_BANNER);
    }

    public boolean isCategoryHave3SlidePosts(String category){
        int slidePostsNum = countElements(WebsiteUI.BLOG_3POST_EACH_CATEGORY, category);
        return slidePostsNum==3;
    }

    public boolean isTopBannerBlogDisplayed(){
        return isElementDisplayed(WebsiteUI.BLOG_TOP_BANNER_AT_CATEGORY);
    }

    public void clickToCategoryOnMenu(String category){
        waitToElementClickable(WebsiteUI.BLOG_CATEGORIES_MENU, category);
        clickToElement(WebsiteUI.BLOG_CATEGORIES_MENU, category);
    }

    public boolean isCategoryTitleEquals(String categoryName){
        String categoryTitle = getTextElement(WebsiteUI.BLOG_CATEGORY_TITLE);
        return categoryName.equals(categoryTitle);
    }

    public void clickToSearchIcon(){
        waitToElementClickable(WebsiteUI.BLOG_SEARCH_BUTTON);
        clickToElement(WebsiteUI.BLOG_SEARCH_BUTTON);
    }

    public void inputToSearchTextBox(String searchKeyword){
        waitToElementVisible(WebsiteUI.BLOG_SEARCH_TEXTBOX);
        sendKeyToElement(WebsiteUI.BLOG_SEARCH_TEXTBOX, searchKeyword);
    }

    public void clickToCloseSearchTextBox(){
        waitToElementClickable(WebsiteUI.BLOG_CLOSE_SEARCH_BUTTON);
        clickToElement(WebsiteUI.BLOG_CLOSE_SEARCH_BUTTON);
    }

    public void clickToSearchActionButton(){
        waitToElementClickable(WebsiteUI.BLOG_SEARCH_ACTION_BUTTON);
        clickToElement(WebsiteUI.BLOG_SEARCH_ACTION_BUTTON);
    }

    public boolean isTheSearchResultLabelContains(String keyword){
        String searchResultLabel = getTextElement(WebsiteUI.BLOG_SEARCH_RESULT_LABEL);
        return searchResultLabel.contains(keyword);
    }

    public boolean isSearchResultURLContains(String keyword){
        String resultURL = getCurrentPageURL();
        return resultURL.contains(keyword);
    }

}
