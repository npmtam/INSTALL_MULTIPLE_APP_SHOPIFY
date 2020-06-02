package commons;

import org.openqa.selenium.WebDriver;

public class Constants {
    static String rootFolder = System.getProperty("user.dir");
    public static final String URL = "https://shopify.com/";
    public static final String ORIGINAL_URL = "https://origin-dev.fireapps.io/install";
    public static final int RAMDOM_BOUND = 10;

    //REGISTER
    public static String EMAIL = "firegroup_original";
    public static final String SHOPIFY_PASSWORD = "Abc123";
    public static final String STORE_NAME = "Fire Original";

    //TELLING US A LITTLE ABOUT YOURSELF
    public static final String ALREADY_SELLING = "I’m just playing around";
    public static final String CURRENT_REVENUE = "₫0 VND (I'm just getting started)";
    public static final String INDUSTRY = "Beauty";

    //ADDRESS INFO
    public static final String FIRST_NAME = "Store";
    public static final String LAST_NAME = "Original Test";
    public static final String ADDRESS = "02 Quang Trung";
    public static final String CITY = "Da Nang";
    public static final String ZIPCODE = "55000";
    public static String PHONE_NUMBER = "098877678";

    //WRITE DATA
    public static final String WRITE_CSV_FILE_PATH = rootFolder + "/src/test/resources/storeData.csv";
    public static final String COMMA_DELIMITER = ",";
    public static final String NEW_LINE_SEPARATOR = "\n";
    public static final String FILE_HEADER = "URL, Email, Store Name, Store Type";

    //READ DATA
    public static final String READ_CSV_FILE_PATH = rootFolder + "/src/test/resources/readStoreData.csv";
    public static String STORE_URL_CSV = null;
    public static String STORE_EMAIL_CSV = null;
    public static String STORE_NAME_CSV = null;
    public static String STORE_TYPE_CSV = null;

    //PLAN TYPES
    public static final String PREMIUM_PAN = "Premium";
    public static final String ESSENTIAL_PLAN = "Essential";
    public static final String STARTER_PLAN = "Starter";
    public static final String NO_PLAN = "No-plan";

    //DELETE APP
    public static final String DELETE_SUCCESS_MESSAGE = "You successfully deleted origin-app-dev.";


    //WEBSITE CHECK FUNCTIONS
    public static final String WEBSITE_URL = "https://beta.fireapps.io";
    public static final String WEBSITE_HOME_BUTTON = "Home";
    public static final String WEBSITE_ALI_REVIEW_URL = "https://beta.fireapps.io/shopify-apps/ali-reviews/";
    public static final String WEBSITE_ALI_ORDERS_URL = "https://beta.fireapps.io/shopify-apps/ali-orders/";
    public static final String WEBSITE_SALES_BOX_URL = "https://beta.fireapps.io/shopify-apps/sales-box/";
    public static final String WEBSITE_ALI_HUNTER_URL = "https://beta.fireapps.io/shopify-apps/ali-hunter/";
    public static final String HELP_CENTER_URL = "https://help.fireapps.io/en/";
    public static final String BLOG_POST_TITLE1 = "10 Best Shopify apps that you must know before starting an e-commerce";
    public static final String BLOG_POST_TITLE2 = "What are Shopify Apps? Pro tips to choose best apps for your store";
    public static final String BLOG_POST_TITLE3 = "Shopify apps are the best way to promote customer experience for your";

    //SOCIAL LINKS
    public static final String FOOTER_FACEBOOK_URL = "https://www.facebook.com/fireapps.io/";
    public static final String FOOTER_INSTAGRAM_URL = "https://www.instagram.com/accounts/login/?next=/fireapps.shopify/";
    public static final String FOOTER_TWITTER_URL = "https://twitter.com/Fireapps_io";
    public static final String FOOTER_YOUTUBE_URL = "https://www.youtube.com/channel/UCTLlWKPKBlHnJA8CYrIEWGg";
    public static final String FACEBOOK_TITLE = "FireApps - Premium Apps for Shopify Stores - Home";
    public static final String INSTAGRAM_TITLE = "Fireapps.io (@fireapps.shopify) • Instagram photos and videos";
    public static final String TWITTER_TITLE = "FireApps (@Fireapps_io) / Twitter";
    public static final String YOUTUBE_TITLE = "FireApps - Premium Apps for Shopify Stores - YouTube";

    //BLOG CATEGORIES
    public static final String BLOG_ECOMMERCE = "eCommerce Marketing";
    public static final String BLOG_SUPERTOOLS = "Super Tools";
    public static final String BLOG_CASESTUDIES = "Case Studies";
    public static final String BLOG_EXTRATALK = "Extra Talk";







}
