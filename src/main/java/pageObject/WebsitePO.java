package pageObject;

import commons.AbstractPage;
import commons.AbstractTest;
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
        return isElementDisplayed(WebsiteUI.H2_TEXT_CONTENT, "Premium E-commerce solutions come together");
    }

    public boolean isShopifyAppsPageAccessed(){
        return isElementDisplayed(WebsiteUI.H2_TEXT_CONTENT, "Top Review App on Shopify");
    }

    public boolean isBlogPageAccessed(){
        return isElementDisplayed(WebsiteUI.BLOG_LATEST_ARTICLES_MENU);
    }

    public boolean isAffiliateTabAccessed(){
        switchToWindowsByTitle("Fireapps.io");
        return isElementDisplayed(WebsiteUI.AFFILIATE_JOIN_NOW_BUTTON);
    }

    public boolean isGetAppNowButtonWorkWell(){
        waitToElementVisible(WebsiteUI.H2_TEXT_CONTENT, "FireApps - Premium");
        return isElementDisplayed(WebsiteUI.H2_TEXT_CONTENT, "FireApps - Prenium");
    }

    public void clickToBodyGetAppNow(){
        waitToElementVisible(WebsiteUI.BODY_GET_APP_NOW_BUTTON);
        clickToElement(WebsiteUI.BODY_GET_APP_NOW_BUTTON);
    }

    public boolean isShopifyAppStoreFireAppsDisplayed(){
        waitToElementVisible(WebsiteUI.H2_TEXT_CONTENT, "FireApps - Premium Apps");
        return  isElementDisplayed(WebsiteUI.H2_TEXT_CONTENT, "FireApps - Premium Apps");
    }

    public void clickToSlideBarButtons(String stt){
        waitToElementClickable(WebsiteUI.SLIDE_BAR_BUTTONS, stt);
        clickToElement(WebsiteUI.SLIDE_BAR_BUTTONS, stt);
    }
}
