package pages;

import config.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
    protected WebDriver driver;
    protected  Common common;

    private By accountBtn = By.id("accountTabButton");
    private By userName = By.id("loginUsernameInput");
    private By password = By.id("loginPasswordInput");
    private By loginBtn = By.id("loginButton");
    private int timeOut = 10;

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    //The main method of login.
    public void doLogin(){
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement accontElement = driver.findElement(accountBtn);

        common.toBeClickable(accontElement, wait);
        common.clickInTheElement(accontElement);
        this.setName();
        this.setPassword();
        this.clickOnLogin();
    }

    //Method that write the login.
    public void setName(){
        WebElement userNameElement = driver.findElement(userName);
        userNameElement.sendKeys(getName());
    }

    public String getName(){
        String name = common.getUserNameAndPassword().get(0);
        return name;
    }

    //Method that write the password.
    public void setPassword(){
        WebElement passwordELement = driver.findElement(password);
        passwordELement.sendKeys(getPassword());
    }

    public String getPassword(){
        String password = common.getUserNameAndPassword().get(1);
        return password;
    }

    public void clickOnLogin(){
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement loginElement = driver.findElement(loginBtn);
        common.toBeClickable(loginElement, wait);
        common.clickInTheElement(loginElement);
    }
}