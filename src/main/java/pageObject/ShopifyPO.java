package pageObject;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUI.ShopifyPageUI;

public class ShopifyPO extends AbstractPage {
    WebDriver driver;

    public ShopifyPO(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void clickToStartFreeTrialBtn(){
        waitToElementClickable(ShopifyPageUI.START_FREE_TRIAL_BUTTON);
        clickToElement(ShopifyPageUI.START_FREE_TRIAL_BUTTON);
    }

    public void inputToRegisterTextBoxes(String placeHolder, String value){
        waitToElementVisible(ShopifyPageUI.REGISTER_TEXT_BOXES, placeHolder);
        sendKeyToElement(ShopifyPageUI.REGISTER_TEXT_BOXES, placeHolder, value);
    }

    public void clickToCreateYourStoreButton(){
        waitToElementClickable(ShopifyPageUI.CREATE_YOUR_STORE_BUTTON);
        clickToElement(ShopifyPageUI.CREATE_YOUR_STORE_BUTTON);
    }

    public boolean isCreateStoreSuccessfully(){
        waitToElementVisible(ShopifyPageUI.TITLE_MORE_INFO);
        return isElementPresentInDOM(ShopifyPageUI.TITLE_MORE_INFO);
    }
}
