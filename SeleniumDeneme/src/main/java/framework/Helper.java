package framework;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;


public class Helper {
    WebDriver driver;
    WebDriverWait wait;

    static Duration duration = Duration.ofSeconds(10);

    public static void setDuration(Duration duration) {
        Helper.duration = duration;
    }

    public static Duration getDuration() {
        return duration.withSeconds(10);
    }

    public Helper(WebDriver driver)
    {
        this.driver=driver;
        this.wait=new WebDriverWait(driver,getDuration());
    }

    public WebElement findElement(By elementName)
    {
        wait.until(ExpectedConditions.elementToBeClickable(elementName));
        return driver.findElement(elementName);
    }

    public List<WebElement> findElements(By elementName)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementName));
        return driver.findElements(elementName);
    }

    public void click(By elementName)
    {
        findElement(elementName).click();
    }

    public void sendKey(By elementName, String text) {
        findElement(elementName).sendKeys(text);
    }

    public void checkElementVisible(By elementName) {
        wait.until(ExpectedConditions.visibilityOf(findElement(elementName)));
    }

    public String getText(By elementName) {
        return findElement(elementName).getText();
    }

    public WebElement presenceElement(By key) {
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(key)));
    }

    public void isAssertTrue(By actualValue, String exceptedValue)
    {
        String actualText= findElement(actualValue).getText();
        assertEquals(actualText,exceptedValue);

    }

    public void typeForInput(String kw, WebElement element){
        assertEquals(element.getTagName(),"input");
        element.sendKeys(kw);
    }

    public void clickForWebElement(WebElement element){
        element.click();
    }

    public void clickForWebElementWithWait(WebElement element, int timeout){
        this.wait=new WebDriverWait(driver,getDuration());
        element.click();
    }
}
