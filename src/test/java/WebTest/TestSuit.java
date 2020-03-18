package WebTest;

import org.junit.Test;

public class TestSuit extends BaseTest
{

    //creating object of homepage class
    HomePage homePage = new HomePage();
    //creating object of registration page class
    RegistrationPage registrationPage = new RegistrationPage();
    //creating object of registration result page
    RegistrationResultPage registrationResultPage = new RegistrationResultPage();

    @Test
    public void userShouldBeAbleToRegisterSuccessfully(){
        //click on register button
        homePage.clickOnRegisterButton();
        //fill up registration details
        //registrationPage.verifyUserIsOnRegisterPage();
        registrationPage.userEntersRegistrationDetails();
        //verify registrations success message
        registrationResultPage.verifyUserSeeRegistrationSuccessMessage();
    }

}

