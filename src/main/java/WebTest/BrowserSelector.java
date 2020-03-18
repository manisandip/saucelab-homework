package WebTest;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BrowserSelector extends Utils {
    //creating object of loadprop class
    public static LoadProp loadProp = new LoadProp();
    //reading SauceLab username
    public static final String USERNAME = loadProp.getProperty("SAUCE_USERNAME");
    //reading sauceLab accesskey
    public static final String ACCESS_KEY = loadProp.getProperty("SAUCE_ACCESS_KEY");
    //opening sauceLab url--->driver creation link
    public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.eu-central-1.saucelabs.com:443/wd/hub";
    //reading sauce status-->true/false from configuration (edit configuration)----->Dsauce=true/false
    public static final boolean SAUCE_LAB = Boolean.parseBoolean(System.getProperty("Sauce"));
    //reading browser value from configuration(edit configuration)--->dbrowser=chrome/firefox/ie etc
    public static final String browser = loadProp.getProperty("browser");


    public void openBrowser() {
        //object of load prop class
        LoadProp loadProp = new LoadProp();
        //To print browser name
        System.out.println("We are using... " + browser + "browser");
        System.out.println(USERNAME);
        System.out.println(ACCESS_KEY);
        // if sauce lab is true ....
        if (SAUCE_LAB) {
            System.out.println("Running is SauceLab....with browser " + browser);

            // To open browser in chrome
            if (browser.equalsIgnoreCase("chrome")) {
                DesiredCapabilities caps = DesiredCapabilities.chrome();
                caps.setCapability("platform", "windows 8");
                caps.setCapability("version", "78.0");

                try {
                    driver = new RemoteWebDriver(new URL(URL), caps);
                    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                    driver.get(loadProp.getProperty("url"));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                loadProp.getProperty("url");
                System.out.println(URL);

                //To open browser in ie
            } else if (browser.equalsIgnoreCase("IE")) {
                DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
                caps.setCapability("platform", "Windows 10");
                caps.setCapability("version", "11");

                try {
                    driver = new RemoteWebDriver(new URL(URL), caps);
                    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                    driver.get(loadProp.getProperty("url"));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }

                // To open browser in firefox
            } else if (browser.equalsIgnoreCase("FireFox")) {
                DesiredCapabilities caps = DesiredCapabilities.firefox();
                caps.setCapability("platform", "Windows 7");
                caps.setCapability("version", "56");
                caps.setCapability("name", "Testing on Firefox 56");

                try {
                    driver = new RemoteWebDriver(new URL(URL), caps);
                    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                    driver.get(loadProp.getProperty("url"));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }

                //To open browser in safari

            } else if (browser.equalsIgnoreCase("Safari")) {
                DesiredCapabilities caps = DesiredCapabilities.safari();
                caps.setCapability("platform", "OS X 10.10");
                caps.setCapability("version", "8.0");

                try {
                    driver = new RemoteWebDriver(new URL(URL), caps);
                    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                    driver.get(loadProp.getProperty("url"));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }

                //to open browser in edge
            } else if (browser.equalsIgnoreCase("edge")) {
                DesiredCapabilities caps = DesiredCapabilities.edge();
                caps.setCapability("platform", "Windows 10");
                caps.setCapability("version", "16.16299");

                try {
                    driver = new RemoteWebDriver(new URL(URL), caps);
                    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                    driver.get(loadProp.getProperty("url"));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }

            } else {
                System.out.println("Wrong browser name or empty: " + browser);

            }

        }
        // if sauce lab is false
        else {
            if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "src/test/Resources/BrowserDriver/chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().window().fullscreen();
                driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
                driver.get("https://demo.nopcommerce.com/");
                //  user select firefox browser
            } else if (browser.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", "src/test/Resources/BrowserDriver/geckodriver.exe");

                driver = new FirefoxDriver();
                driver.manage().window().fullscreen();
                driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
                driver.get("https://demo.nopcommerce.com/");
                // user select Internet Explorer browser
            } else if (browser.equalsIgnoreCase("ie")) {
                System.setProperty("webdriver.ie.driver", "src/test/Resources/BrowserDriver/IEDriverServer.exe");
                driver = new InternetExplorerDriver();
                driver.manage().window().fullscreen();
                driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
                driver.get("https://demo.nopcommerce.com/");
                //it means browser is not present in the config file
            } else {
                System.out.println("Browser is not correct" + browser);
            }

        }

    }
    public void CloseBrowser()
    {
        driver.quit();
    }
}







