package WebTest;

import org.openqa.selenium.By;

public class RegistrationPage extends Utils {
    private By _firstName = By.id("FirstName");
    private By _lastName = By.id("LastName");
    private By _email = By.id("Email");
    private By _password = By.id("Password");
    private By _confirmPassword = By.id("ConfirmPassword");
    private By _registerButton = By.id("register-button");
    private String firstname = "mani12";
    private String lastname = "shah";
    private static String timestamp = createTimeStamp();

    public void verifyUserIsOnRegisterPage(){
        assertURL("register");
    }

    //method for entering registration details
    public void userEntersRegistrationDetails(){
        try {
            Thread.sleep(2000); // System will go on sleep mode to allow loading the homepage(very Slow)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //enters first name
        sendText(_firstName, firstname);
        //enters last name
        sendText(_lastName, lastname);
        //enters email address
        sendText(_email, "xyz"+timestamp+"@gmail.com");
        // enters password
        sendText(_password, "testtest");
        //enters confirm password
        sendText(_confirmPassword, "testtest");
        //clicks on register button
        clickOnElement(_registerButton);
    }
}
