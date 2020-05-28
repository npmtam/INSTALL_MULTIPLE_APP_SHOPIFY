package pageObject;

import commons.*;
import org.openqa.selenium.WebDriver;
import pageUI.ShopifyPageUI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShopifyPO extends AbstractPage {
    WebDriver driver;
    public String storeURL;
    AbstractTest abstractTest = new AbstractTest();
    ReadDataCSV readDataCSV = new ReadDataCSV();

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

    public void selectDescribesDropdown(int index) {
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
        if (isTheStoreCreated()) {
            String urlContains = driver.getCurrentUrl();
            storeURL = urlContains.substring(0, urlContains.length() - 6);
            System.out.println("Store URL: " + storeURL);
        }
    }

    public void clickToLoginButton() {
        waitToElementClickable(ShopifyPageUI.LOGIN_BUTTON);
        clickToElement(ShopifyPageUI.LOGIN_BUTTON);
    }

    public void clickLoginToAnotherAccount() {
        waitToElementClickable(ShopifyPageUI.LOGIN_TO_ANOTHER_ACCOUNT);
        clickToElement(ShopifyPageUI.LOGIN_TO_ANOTHER_ACCOUNT);
    }

    public void inputToStoreURLTextBox(String url) {
        waitToElementVisible(ShopifyPageUI.STORE_URL_TEXTBOX);
        sendKeyToElement(ShopifyPageUI.STORE_URL_TEXTBOX, url);
    }

    public void inputToEmailPasswordTextBoxes(String attributeValue, String textValue) {
        waitToElementVisible(ShopifyPageUI.EMAIL_PASSWORD_TEXTBOXES, attributeValue);
        sendKeyToElement(ShopifyPageUI.EMAIL_PASSWORD_TEXTBOXES, textValue, attributeValue);
    }

    public void clickToDynamicButton(String attributeValue) {
        waitToElementClickable(ShopifyPageUI.DYNAMIC_BUTTON, attributeValue);
        clickToElement(ShopifyPageUI.DYNAMIC_BUTTON, attributeValue);
    }

    public boolean isStoreNameLabelDisplayed(String storeName) {
        waitToElementClickable(ShopifyPageUI.STORE_NAME_LABEL, storeName);
        return isElementDisplayed(ShopifyPageUI.STORE_NAME_LABEL, storeName);
    }

    public void clickToAppsMenu() {
        waitToElementClickable(ShopifyPageUI.APPS_MENU);
        clickToElement(ShopifyPageUI.APPS_MENU);
    }

    public void clickToDeleteOriginalApp() {
        waitToElementClickable(ShopifyPageUI.DELETE_ORIGINAL);
        clickToElement(ShopifyPageUI.DELETE_ORIGINAL);
    }

    public void clickToConfirmDeleteOriginal() {
        sleepInSecond(1);
        waitToElementClickable(ShopifyPageUI.CONFIRM_DELETE_ORIGINAL);
        waitToElementVisible(ShopifyPageUI.DELETE_APP_CONFIRMATION_TEXT);
        clickToElement(ShopifyPageUI.CONFIRM_DELETE_ORIGINAL);
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

    public void uninstallApps(List<String> store) {
        String stt = store.get(0);
        Constants.STORE_URL_CSV = store.get(1);
        Constants.STORE_EMAIL_CSV = store.get(2);
        Constants.STORE_NAME_CSV = store.get(3);
        Constants.STORE_TYPE_CSV = store.get(4);

        driver.get(Constants.URL);
        clickToLoginButton();
        if (isElementPresentInDOM(ShopifyPageUI.LOGIN_TO_ANOTHER_ACCOUNT)) {
            clickLoginToAnotherAccount();
        }
        inputToStoreURLTextBox(Constants.STORE_URL_CSV);
        clickToDynamicButton("Next");
        inputToEmailPasswordTextBoxes("email", Constants.STORE_EMAIL_CSV);
        clickToDynamicButton("Next");
        inputToEmailPasswordTextBoxes("password", Constants.SHOPIFY_PASSWORD);
        clickToDynamicButton("Log in");
        //Verify login successfully
        abstractTest.verifyTrue(isStoreNameLabelDisplayed(Constants.STORE_NAME_CSV));
        clickToAppsMenu();
        if (isElementPresentInDOM(ShopifyPageUI.DELETE_ORIGINAL)) {
            clickToDeleteOriginalApp();
            clickToConfirmDeleteOriginal();
            String deleteSuccess = getTextElement(ShopifyPageUI.DELETE_SUCCESS_MESSAGE);
            abstractTest.verifyTrue(deleteSuccess.equals(Constants.DELETE_SUCCESS_MESSAGE));
            System.out.println("THE STORE " + Constants.STORE_NAME_CSV + " HAS BEEN REMOVED THE ORIGINAL APP");
            System.out.println("Ordinal Numbers: " + stt);
        } else {
            System.out.println("THIS STORE ALREADY DELETED THE ORIGINAL APP");
            System.out.println("Ordinal Numbers: " + stt);
        }

    }

    public void readDataAndDeleteApp() {
        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader(Constants.READ_CSV_FILE_PATH));

            //Read file in java line by line
            while ((line = br.readLine()) != null) {
                while ((line = br.readLine()) != null) {
                    while ((line = br.readLine()) != null) {
                        uninstallApps(readDataCSV.parseCsvLine(line));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }
    }

}
