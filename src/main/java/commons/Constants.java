package commons;

import org.openqa.selenium.WebDriver;

public class Constants {
    static String rootFolder = System.getProperty("user.dir");
    public static final String URL = "https://shopify.com/";
    public static final int RAMDOM_BOUND = 10;

    //REGISTER
    public static String EMAIL = "original_install_";
    public static final String SHOPIFY_PASSWORD = "Abc123";
    public static final String STORE_NAME = "Original Store Test";

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
    public static final String CSV_FILE_PATH = rootFolder + "/src/test/resources/storeData.csv";
    public static final String COMMA_DELIMITER = ",";
    public static final String NEW_LINE_SEPARATOR = "\n";
    public static final String FILE_HEADER = "URL, Email, Store Name, Store Type";

}
