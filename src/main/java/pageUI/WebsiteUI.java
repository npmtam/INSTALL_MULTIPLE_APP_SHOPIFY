package pageUI;

public class WebsiteUI {

    //Header
    public static final String HEADER_LINKS_DYNAMIC = "//ul[@class='navbar-nav']//a[contains(text(), '%s')]";
    public static final String H4_TEXT_CONTENT = "//h4[contains(text(), '%s')]";
    public static final String H2_TEXT_CONTENT = "//h2[contains(text(), '%s')]";

    public static final String BLOG_LATEST_ARTICLES_MENU = "//div[@class='border-top border-bottom d-none d-md-block']//a[@title='Latest Articles']";
    public static final String AFFILIATE_JOIN_NOW_BUTTON = "//div[@class='text-center']/a[@href='https://affiliate.fireapps.io/register']";

    public static final String BODY_GET_APP_NOW_BUTTON = "//h4/following-sibling::a[@class='a-btn a-btn-pink btn rounded-pill']";

    //Apps slide bar at Home Page
    public static final String SLIDE_BAR_BUTTONS = "//span[@aria-label='Go to slide %s']";
    public static final String APPS_LOGO_IN_SLIDEBAR = "//div[@class='a-logo']/img[@class='swiper-lazy swiper-lazy-loaded' and contains(@src, '%s')]";
    public static final String GET_APP_BUTTONS_IN_SLIDEBAR = "//a[@class='a-btn a-btn-pink btn rounded-pill' and contains(@href, '%s')]";

    //Blog articles at Home Page
    public static final String BLOG_POST_IN_HOME_PAGE = "//h3/a[contains(text(), '%s')]";
    public static final String BLOG_POST_TITLE = "//h1[contains(text(), '%s')]";

    //Footer
    public static final String FOOTER_MENUS = "//a[@class='nav-link' and contains(text(), '%s')]";
    public static final String FOOTER_SOCIAL_ICONS = "//i[@class='fab fa-%s']";


    public static final String WHATS_NEW_LOGO = "//div[@class=' group-logo ']//a[contains(text(), 'What')]";
    public static final String EMAIL_TEXTBOX_CONTACT_US = "//input[@name='your-email']";
    public static final String FOOTER_REDIRECT_PAGE_TITLE = "//h1[contains(text(), '%s')]";




}
