package WebTest;

import org.openqa.selenium.By;

public class HomePage extends Utils {

    private By _registerLink = By.xpath("//a[contains(., 'Register')]");

    // verify that user click on register button
    public void clickOnRegisterButton(){clickOnElement(_registerLink);}
}

