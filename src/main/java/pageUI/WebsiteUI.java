package pageUI;

public class WebsiteUI {

    public static final String HEADER_LINKS_DYNAMIC = "//ul[@class='navbar-nav']//a[contains(text(), '%s')]";
    public static final String H2_TEXT_CONTENT = "//h2[contains(text(), '%s')]";

    public static final String BLOG_LATEST_ARTICLES_MENU = "//a[@title='Latest Articles']";
    public static final String AFFILIATE_JOIN_NOW_BUTTON = "//div[@class='text-center']/a[@href='https://affiliate.fireapps.io/register']";

    public static final String BODY_GET_APP_NOW_BUTTON = "//h2/following-sibling::a[@class='a-btn a-btn-pink btn rounded-pill']";

    //APPS SLIDE BAR AT HOME PAGE
    public static final String SLIDE_BAR_BUTTONS = "//span[@aria-label='Go to slide %s']";


}
