package pageObject;

import commons.AbstractPage;
import commons.AbstractTest;
import commons.Constants;
import commons.ReadDataCSV;
import org.openqa.selenium.WebDriver;
import pageUI.OriginalUI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class OriginalPO extends AbstractPage {
    WebDriver driver;
    ReadDataCSV readDataCSV = new ReadDataCSV();
    AbstractTest abstractTest = new AbstractTest();
    boolean isInstalledApp;

    public OriginalPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void inputStoreURL(String textValue) {
        waitToElementVisible(OriginalUI.STORE_NAME_TEXTBOX);
        sendKeyToElement(OriginalUI.STORE_NAME_TEXTBOX, textValue);
    }

    public void clickToLoginButton() {
        waitToElementClickable(OriginalUI.LOGIN_BUTTON);
        clickToElement(OriginalUI.LOGIN_BUTTON);
    }

    public void clickToLoginToAnotherAccount() {
        waitToElementClickable(OriginalUI.LOGIN_TO_ANOTHER_ACCOUNT);
        clickToElement(OriginalUI.LOGIN_TO_ANOTHER_ACCOUNT);
    }

    public void inputToLoginTextboxes(String attributeValue, String textValue) {
        waitToElementVisible(OriginalUI.LOGIN_TEXTBOXES, attributeValue);
        sendKeyToElement(OriginalUI.LOGIN_TEXTBOXES, textValue, attributeValue);
    }

    public void clickToDynamicButtons(String buttonText) {
        waitToElementClickable(OriginalUI.DYNAMIC_BUTTONS, buttonText);
        clickToElement(OriginalUI.DYNAMIC_BUTTONS, buttonText);
    }

    public boolean isDataAcceptableToInstall() {
        waitToElementVisible(OriginalUI.INSTALL_LABEL);
        return isElementDisplayed(OriginalUI.INSTALL_LABEL);
    }

    public void selectPlan(String planName) {
        waitToElementClickable(OriginalUI.SELECT_PLAN_BUTTONS, planName);
        clickToElement(OriginalUI.SELECT_PLAN_BUTTONS, planName);
    }

    public void clickToStart7DaysTrialButton() {
        waitToElementClickable(OriginalUI.START_TRIAL_7_DAYS_BUTTON);
        clickToElement(OriginalUI.START_TRIAL_7_DAYS_BUTTON);
    }

    public void clickToStartFreeTrialButton() {
        waitToElementClickable(OriginalUI.START_FREE_TRIAL_BUTTON);
        clickToElement(OriginalUI.START_FREE_TRIAL_BUTTON);
    }

    public boolean isOriginalLogoDisplayed() {
        waitToElementVisible(OriginalUI.LOGO);
        return isElementDisplayed(OriginalUI.LOGO);
    }

    public void installApp() {
        inputStoreURL(Constants.STORE_URL_CSV);
        clickToLoginButton();
        if (isLoginToAnotherAccountPresentInDOM(OriginalUI.LOGIN_TO_ANOTHER_ACCOUNT)) {
            scrollToElement(OriginalUI.LOGIN_TO_ANOTHER_ACCOUNT);
            clickToLoginToAnotherAccount();
        }
        inputToLoginTextboxes("email", Constants.STORE_EMAIL_CSV);
        clickToDynamicButtons("Next");
        inputToLoginTextboxes("password", Constants.SHOPIFY_PASSWORD);
        clickToDynamicButtons("Log in");
        if (isElementPresentInDOM(OriginalUI.DYNAMIC_BUTTONS, "Install unlisted app")) {
            scrollToElement(OriginalUI.DYNAMIC_BUTTONS, "Install unlisted app");
            clickToDynamicButtons("Install unlisted app");
        }
        else if (driver.getCurrentUrl().equals("https://origin-dev.fireapps.io/")) {
            System.out.println("THIS ACCOUNT " + Constants.STORE_URL_CSV + " HAS BEEN SELECTED THE PLAN BEFORE");
            isInstalledApp = true;
        }
    }

    public void initStoreData(List<String> store) {
        String stt = store.get(0);
        String url = store.get(1);
        String urlSplit1 = url.substring(8);
        Constants.STORE_URL_CSV = urlSplit1.substring(0, urlSplit1.length() - 14);
        Constants.STORE_EMAIL_CSV = store.get(2);
        Constants.STORE_NAME_CSV = store.get(3);
        Constants.STORE_TYPE_CSV = store.get(4);

        if (Constants.STORE_TYPE_CSV.equals(Constants.PREMIUM_PAN)) {
            driver.get(Constants.ORIGINAL_URL);
            installApp();
            if (isElementPresentInDOM(OriginalUI.SELECT_PLAN_BUTTONS, "PREMIUM")) {
                selectPlan("PREMIUM");
                clickToStart7DaysTrialButton();
                clickToStartFreeTrialButton();
                abstractTest.verifyTrue(isElementDisplayed(OriginalUI.LOGO));
                System.out.println(Constants.STORE_NAME_CSV + " has been installed the Original App");
            }
        } else if (Constants.STORE_TYPE_CSV.equals(Constants.ESSENTIAL_PLAN)) {
            driver.get(Constants.ORIGINAL_URL);
            installApp();
            if (isElementPresentInDOM(OriginalUI.SELECT_PLAN_BUTTONS, "ESSENTIAL")) {
                selectPlan("ESSENTIAL");
                clickToStart7DaysTrialButton();
                clickToStartFreeTrialButton();
                abstractTest.verifyTrue(isElementDisplayed(OriginalUI.LOGO));
                System.out.println(Constants.STORE_NAME_CSV + " has been installed the Original App");
            }
        } else if (Constants.STORE_TYPE_CSV.equals(Constants.STARTER_PLAN)) {
            driver.get(Constants.ORIGINAL_URL);
            installApp();
            if (isElementPresentInDOM(OriginalUI.SELECT_PLAN_BUTTONS, "STARTER")) {
                selectPlan("STARTER");
                clickToStart7DaysTrialButton();
                clickToStartFreeTrialButton();
                abstractTest.verifyTrue(isElementDisplayed(OriginalUI.LOGO));
                System.out.println(Constants.STORE_NAME_CSV + " has been installed the Original App");
            }
        } else {
            driver.get(Constants.ORIGINAL_URL);
            installApp();
            if (isInstalledApp == false) {
                abstractTest.verifyTrue(isElementDisplayed(OriginalUI.LOGO));
                System.out.println(Constants.STORE_NAME_CSV + " has been installed the Original App");
            }
        }
    }

    public void readDataCsv() {
        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader(Constants.READ_CSV_FILE_PATH));

            //Read file in java line by line
            while ((line = br.readLine()) != null) {
                while ((line = br.readLine()) != null) {
                    while ((line = br.readLine()) != null) {
                        initStoreData(readDataCSV.parseCsvLine(line));
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
