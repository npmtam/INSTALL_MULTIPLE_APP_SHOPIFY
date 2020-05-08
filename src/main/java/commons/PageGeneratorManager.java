package commons;

import org.openqa.selenium.WebDriver;
import pageObject.ShopifyPO;

public class PageGeneratorManager {
    public static ShopifyPO getShopifyPage(WebDriver driver) {
        return new ShopifyPO(driver);
    }
}
