package pages;

import config.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Betting {
    private WebDriver driver;

    //Common object has all commons methods that using in more then one page object.
    protected Common common;

    private int timeOut = 10;

    //Get the HTML tag for each field using id or name if it is unique or Xpath
    private By football = By.id("nav-football");
    private By competitions = By.id("nav-football-competitions");
    private By matchesMarket =  By.xpath("//div[@class='event']//div[@class='btmarket__actions']/div[@class='btmarket__selection']");
    private By premierLeague = By.xpath("//li[@data-id='Popular-Competitions-OB_TY295']");
    private By betSlip = By.xpath("//div[contains(@class,'can-combine')]//div[contains(@class,'betslip-selection__content')]//div[contains(@class,'betslip-selection__stake-container')]/span/input");
    private By placeBet = By.xpath("//input[@class='o-btn o-btn--primary js-place-bet-button']");
    private By totalReturn = By.id("total-to-return-price");
    private By returnEstimated = By.xpath("//span[contains(@id,'estimated-returns')]/span");


    //Betting construction method.
    public Betting(WebDriver driver) {
        this.driver = driver;
    }

    public void goToFootballByMenu(){
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement menuFootballElement = driver.findElement(football);
        common.toBeClickable(menuFootballElement, wait);
        common.clickInTheElement(menuFootballElement);
    }

    public void goToCompatitions(){
        WebElement menuCompatitionsElement = driver.findElement(competitions);
        common.clickInTheElement(menuCompatitionsElement);
    }

    public void makeBetPremierLeague(int indexOfBetMkSelection, String betValue){
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        String premierLeagueExpanded = "";
        
        //Looking for the html code we could see that the dropdown is closed on the class has -expanded.
        String tagType = "class";
        WebElement premierLeagueElement = driver.findElement(premierLeague);
        List<WebElement> matchMarketELements = driver.findElements(matchesMarket);
        WebElement betSlipElement = driver.findElement(betSlip);

        premierLeagueExpanded = common.getClassValues(premierLeagueElement, tagType);

        //Checking if the dropdown is closed using the class for check it.
        if (!premierLeagueExpanded.contains("-expanded")){
            common.clickInTheElement(premierLeagueElement);
        }
        matchMarketELements.get(indexOfBetMkSelection);
        common.toBeSelected(betSlipElement, wait);
        common.clearField(betSlipElement);
        betSlipElement.sendKeys(betValue);

    }

    public void clickOnPlaceBet(){
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement placeBetElement = driver.findElement(placeBet);
        common.toBeClickable(placeBetElement, wait);
        common.clickInTheElement(placeBetElement);
    }

    public String totalReturnValue(){
        WebElement totalELement = driver.findElement(totalReturn);
        return totalELement.getText();
    }

    public String estimatedReturnValue(){
        WebElement estimatedElement = driver.findElement(returnEstimated);
        return estimatedElement.getText();
    }
}
