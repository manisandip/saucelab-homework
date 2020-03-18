package WebTest;

import org.junit.After;
import org.junit.Before;

public class BaseTest extends Utils {

    BrowserSelector browserSelector = new BrowserSelector();

    @Before

    //method to open browser
    public void OpenBrowser()
    {
        browserSelector.openBrowser();
    }
    //method to close browser
    @After
    public void CloseBrowser()
    {
        browserSelector.CloseBrowser();
    }
}
