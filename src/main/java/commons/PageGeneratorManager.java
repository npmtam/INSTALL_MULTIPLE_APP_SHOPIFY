package commons;

import org.openqa.selenium.WebDriver;
import pageObject.OriginalPO;
import pageObject.ShopifyPO;

public class PageGeneratorManager {
    public static ShopifyPO getShopifyPage(WebDriver driver) {
        return new ShopifyPO(driver);
    }

    public static OriginalPO getOriginalPage(WebDriver driver){
        return new OriginalPO(driver);
    }
}
