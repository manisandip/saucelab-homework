package WebTest;

import org.junit.Assert;
import org.openqa.selenium.By;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils extends  BasePage

{
    //method for clicking on element
    public void clickOnElement(By by)
    {
        driver.findElement(by).click();
    }

    public static String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    public void EnterText(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }
    public static void sendText(By by, String text)
    {
        driver.findElement(by).sendKeys(text);
    }
    public static void assertTextMessage(String expected, By by)
    {
        String actual = getTextFromElement(by);
        Assert.assertEquals("pass", expected, actual);
    }
    public static void assertURL(String text)
    {
        Assert.assertTrue(driver.getCurrentUrl().contains(text));
    }

    public static String createTimeStamp()
    {
        return new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    }

}
