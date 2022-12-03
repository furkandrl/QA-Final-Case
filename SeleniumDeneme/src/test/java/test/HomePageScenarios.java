package test;

import framework.ConfigReader;
import framework.DriverSetup;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import page.HomePage;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HomePageScenarios {
    HomePage homePage = new HomePage(DriverSetup.getDriver());
    static WebDriver driver;
    static Properties properties;

    @BeforeAll
    public static void setup(){
        properties = ConfigReader.initialize_Properties();
        driver = DriverSetup.initialize_Driver("Chrome");
    }

    @Test
    @Order(1)
    public void close_overlay(){
        homePage.close_overlay();
        System.out.println("Overlay closed");
    }

    @Test
    @Order(2)
    public void do_search(){
        homePage.search_value();
        System.out.println("Search done");
    }

    @Test
    @Order(3)
    public void click_last_product(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homePage.click_last_product();
        System.out.println("Last product int the list clicked");
    }

    @Test
    @Order(4)
    public void check_product(){
        String productCode = homePage.get_product_code();
        String targetProductCode ="Ürün Kodu : HIP-86766";
        assertEquals(productCode, targetProductCode);
    }

    @Test
    @Order(5)
    public void click_add_cart(){
        homePage.click_add_cart();
        System.out.println("Add cart button clicked");
    }

    @Test
    @Order(6)
    public void click_show_cart(){
        homePage.click_show_cart();
        System.out.println("Show cart button clicked");
    }

    @Test
    @Order(7)
    public void click_complete_shopping(){
        homePage.click_complete_shopping();
        System.out.println("Complete shopping clicked");
    }

    @Test
    @Order(8)
    public void check_if_login_page(){
        homePage.is_login_button_present();
        System.out.println("Login page is reached");
    }
}
