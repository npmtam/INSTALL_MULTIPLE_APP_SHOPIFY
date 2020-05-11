package pageUI;

public class ShopifyPageUI {
    //Register
    public static final String START_FREE_TRIAL_BUTTON = "//ul[@class='marketing-nav__items marketing-nav__user display--expanded-nav']//input[@value='Start free trial']";
    public static final String REGISTER_TEXT_BOXES = "//input[@placeholder='%s']";
    public static final String CREATE_YOUR_STORE_BUTTON = "//button[text()='Create your store']";

    //Error Msg
    public static final String ERR_NAME_EXISTS = "//span[contains(text(), 'A store with that name already exists')]";

    //Tell us a little about yourself
    public static final String TITLE_MORE_INFO = "//h1[text()='Tell us a little about yourself']";
    public static final String DROPDOWN_SEEDING_QUESTION = "//select[@id='QuestionnaireSelect-background']";
    public static final String DROPDOWN_BUSINESS_REVENUE = "//select[@id='QuestionnaireSelect-business_revenue']";
    public static final String DROPDOWN_STORE_INDUSTRY = "//select[@id='QuestionnaireSelect-store_industry']";
    public static final String DROPDOWN_DESCRIBES = "//select[@id='QuestionnaireSelect-which_best_describes_you']";
    public static final String NEXT_BUTTON = "//button[@aria-label='Next']";

    //Address info
    public static final String ADDRESS_INFO_TEXTBOXES = "//input[@name='account_setup[%s]']";
    public static final String ENTER_MY_STORE_BUTTON = "//button[@aria-label='Enter my store']";

    //Admin Page
    public static final String SELECT_PLAN_MSG = "//p[text()='Your trial just started']";

}
