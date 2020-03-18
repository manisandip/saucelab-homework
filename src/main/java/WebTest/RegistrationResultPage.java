package WebTest;

import org.openqa.selenium.By;

public class RegistrationResultPage extends Utils {
    private By _registerSuccessMessage = By.className("result");
    String expected = "Your registration completed";

    //method for asserting(verifying) registration message
    public void verifyUserSeeRegistrationSuccessMessage(){
        assertURL("registerresult");
        assertTextMessage("Your registration completed",_registerSuccessMessage);
    }
}
