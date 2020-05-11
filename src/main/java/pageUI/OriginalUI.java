package pageUI;

public class OriginalUI {

    public static final String STORE_NAME_TEXTBOX = "//input[@placeholder='Store name']";
    public static final String LOGIN_BUTTON = "//button[@type='submit']";
    public static final String LOGIN_TEXTBOXES = "//input[@name='account[%s]']";  //email/password
    public static final String DYNAMIC_BUTTONS = "//button[text()='%s']";
    public static final String INSTALL_LABEL = "//h2[text()='You are about to install origin-app-dev']";

    //SELECT PLAN
    public static final String SELECT_PLAN_BUTTONS = "//span[contains(text(),'%s')]/parent::div";
    public static final String START_TRIAL_PLAN_BUTTON = "//span[text()='Start 7 - day for trial']/parent::button";
    public static final String START_FREE_TRIAL_BUTTON = "//button[@id='approve-charges-button']";

    //ORIGINAL APP
    public static final String LOGO = "//div[@class='a-logo-text']";
}
