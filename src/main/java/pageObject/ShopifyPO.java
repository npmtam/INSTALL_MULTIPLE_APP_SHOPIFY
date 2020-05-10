package pageObject;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import commons.AbstractPage;
import commons.Constants;
import commons.StoresLink;
import org.openqa.selenium.WebDriver;
import pageUI.ShopifyPageUI;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShopifyPO extends AbstractPage {
    WebDriver driver;
    public String storeURL;

    public ShopifyPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickToStartFreeTrialBtn() {
        waitToElementClickable(ShopifyPageUI.START_FREE_TRIAL_BUTTON);
        clickToElement(ShopifyPageUI.START_FREE_TRIAL_BUTTON);
    }

    public void inputToRegisterTextBoxes(String placeHolder, String value) {
        waitToElementVisible(ShopifyPageUI.REGISTER_TEXT_BOXES, placeHolder);
        sendKeyToElement(ShopifyPageUI.REGISTER_TEXT_BOXES, value, placeHolder);
    }

    public void clickToCreateYourStoreButton() {
            waitToElementClickable(ShopifyPageUI.CREATE_YOUR_STORE_BUTTON);
            clickToElement(ShopifyPageUI.CREATE_YOUR_STORE_BUTTON);
            clickToElement(ShopifyPageUI.CREATE_YOUR_STORE_BUTTON);
    }

    public boolean isRegisterInfoAcceptable() {
        waitToElementVisible(ShopifyPageUI.TITLE_MORE_INFO);
        return isElementPresentInDOM(ShopifyPageUI.TITLE_MORE_INFO);
    }

    public void selectAlreadySellingDropdown(String item) {
        waitToElementVisible(ShopifyPageUI.DROPDOWN_SEEDING_QUESTION);
        selectItemInDropdown(ShopifyPageUI.DROPDOWN_SEEDING_QUESTION, item);
    }

    public void selectCurrentRevenueDropdown(String item) {
        waitToElementVisible(ShopifyPageUI.DROPDOWN_BUSINESS_REVENUE);
        selectItemInDropdown(ShopifyPageUI.DROPDOWN_BUSINESS_REVENUE, item);
    }

    public void selectIndustryDropdown(String item) {
        waitToElementVisible(ShopifyPageUI.DROPDOWN_STORE_INDUSTRY);
        selectItemInDropdown(ShopifyPageUI.DROPDOWN_STORE_INDUSTRY, item);
    }

    public void selectDescribesDropdown(int index){
        waitToElementVisible(ShopifyPageUI.DROPDOWN_DESCRIBES);
        selectItemInDropdownByIndex(ShopifyPageUI.DROPDOWN_DESCRIBES, index);
    }

    public void clickToNextButton() {
        waitToElementClickable(ShopifyPageUI.NEXT_BUTTON);
        clickToElement(ShopifyPageUI.NEXT_BUTTON);
    }

    public void inputAddressTextboxes(String nameValue, String textValue) {
        waitToElementVisible(ShopifyPageUI.ADDRESS_INFO_TEXTBOXES, nameValue);
        sendKeyToElement(ShopifyPageUI.ADDRESS_INFO_TEXTBOXES, textValue, nameValue);
    }

    public void clickToEnterMyStoreButton() {
        sleepInSecond(1);
        waitToElementClickable(ShopifyPageUI.ENTER_MY_STORE_BUTTON);
        clickToElement(ShopifyPageUI.ENTER_MY_STORE_BUTTON);
    }

    public boolean isTheStoreCreated() {
        return isElementDisplayed(ShopifyPageUI.SELECT_PLAN_MSG);
    }

    public void printStoreURL() {
        if(isTheStoreCreated()) {
            String urlContains = driver.getCurrentUrl();
            storeURL = urlContains.substring(0, urlContains.length() - 6);
            System.out.println("Store URL: " + storeURL);
        }
    }

    public void writeDataToCsv(String fileName, String email, String storeName) {
        //Create new data object
        StoresLink data = new StoresLink(storeURL, email, storeName, "");

        List<StoresLink> storeData = new ArrayList<>();
        storeData.add(data);

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName, true);
            //Write the CSV file Header
//            fileWriter.append(Constants.FILE_HEADER);
            //Add a new line separator after the header
//            fileWriter.append(Constants.NEW_LINE_SEPARATOR);

            //Write new data objects list to the CSV file
            for (StoresLink storeValues : storeData) {
                fileWriter.append(storeValues.getUrl());
                fileWriter.append(Constants.COMMA_DELIMITER);
                fileWriter.append(storeValues.getEmail());
                fileWriter.append(Constants.COMMA_DELIMITER);
                fileWriter.append(storeValues.getStoreName());
                fileWriter.append(Constants.COMMA_DELIMITER);
                fileWriter.append(storeValues.getStore_type());
            }

            fileWriter.append(Constants.NEW_LINE_SEPARATOR);

            System.out.println("CSV file was created successfully !!");
        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!");
                e.printStackTrace();
            }
        }
    }
}
