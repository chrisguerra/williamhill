
package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class ConfBase {
    private static WebDriver driver;
    protected static String driverPath = "./drivers";

    public static WebDriver getDriver(){
        return driver;
    }

    public void setDriver(String browserType, String appUrl){
        if (browserType == "chrome"){
            driver = initChromeDriver(appUrl);
        } else if (browserType == "firefox"){
            driver = initFirefoxDriver(appUrl);
        } else {
            System.out.println("Please, verify the testng.xml file on browserType XML tag.");
        }
    }

    private WebDriver initChromeDriver(String appUrl) {
        System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(appUrl);
        return driver;
    }

    private WebDriver initFirefoxDriver(String appUrl) {
        System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(appUrl);
        return driver;
    }

    @Parameters({"browserType","appUrl"})
    @BeforeSuite
    public void startConfig(String browserType, String appUrl){
        try{
            setDriver(browserType, appUrl);
            driver = this.getDriver();
        }catch (Exception e){
            System.out.println("Error to start the driver is: " + e.getStackTrace());
        }
    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }
}