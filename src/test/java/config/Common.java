package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Common {
    protected WebDriver driver;

    //Common construction
    public Common(WebDriver driver){
        this.driver = driver;
    }

    public void toBeSelected(WebElement element, WebDriverWait wait){
        wait.until(ExpectedConditions.elementToBeSelected(element));
    }

    public void toBeClickable(WebElement element, WebDriverWait wait){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickInTheElement(WebElement element){
        element.click();
    }

    public void clearField(WebElement element){
        element.clear();
    }

    public String getClassValues(WebElement element, String tagType){
        return element.getAttribute(tagType);
    }

    /**
     * Using a file separeted to protected the user and password and return a list of two Strings
     * the first one is the user name
     * the second one is the password
     */
    public List<String> getUserNameAndPassword() {
        List<String> name = new ArrayList<String>();
        try {
            FileInputStream fstream = new FileInputStream("./bettingCfg.txt");
            BufferedReader breader = new BufferedReader(new InputStreamReader(fstream));
            while((breader.readLine())!= null){
                name.add(breader.readLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return name;
    }
}
