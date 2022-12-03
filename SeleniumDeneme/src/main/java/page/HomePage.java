package page;

import framework.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;


public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    Helper elementHelper;

    By overlay = By.xpath("//div/div/img[@class='ins-close-button-c2703']");
    By searchBar = By.xpath(("//div/div/input[@id='txtSearchBox']"));
    By lastProduct = By.xpath("//div/div/div/ul/li/a[@href='/arilac-sutlu-pirincli-kasik-mamasi-200-g-p-ari-6179']");
    By addCartButton = By.xpath("//div[@class='col-xl-5half']//button[@id='addToCartBtn']");
    By showCartButton = By.xpath("//a[@id='btnShowCart']");
    By completeShopping = By.xpath("//button[@id='btnGoToShippingAddress']");
    By loginButton = By.xpath("//button[@id='btnSubmitLogin']");

    public HomePage(WebDriver driver){
        this.driver = driver;
        this. wait = new WebDriverWait(driver, Helper.getDuration());
        this.elementHelper = new Helper(driver);
    }

    public void close_overlay(){
        elementHelper.click(overlay);
    }

    public void search_value(){
        elementHelper.sendKey(searchBar, "kaşık maması");
    }

    public void click_last_product(){
        var lastProd = elementHelper.findElement(lastProduct);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
                ,lastProd);
        lastProd.click();
    }

    public String get_product_code(){
        return driver.findElement(By.xpath("//div[@class='col-xl-5half']//p/span"))
                .getText();
    }

    public void click_add_cart(){
        elementHelper.click(addCartButton);
    }

    public void click_show_cart(){
        elementHelper.click(showCartButton);
    }

    public void click_complete_shopping(){
        elementHelper.click(completeShopping);
    }

    public void is_login_button_present(){
        elementHelper.presenceElement(loginButton);
    }

}
