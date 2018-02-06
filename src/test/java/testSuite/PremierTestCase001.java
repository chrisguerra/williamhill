package testSuite;

import config.ConfBase;
import cucumber.api.CucumberOptions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.Betting;
import pages.Login;

@CucumberOptions(features = {"src/test/feature/"}, glue = "testSuite")
public class PremierTestCase001 extends AbstractTestNGCucumberTests {
    protected WebDriver driver;
    private ConfBase confBase;
    private Login login = new Login(driver);
    private Betting bet = new Betting(driver);
    int matchLineAndColumn = 0;
    String betValue = "0.05";

    @Given("^Open the Chrome and go to WilliamHill website$")
    public void openTheChromeAndGoToWilliamHillWebsite() throws Throwable {
        this.driver = confBase.getDriver();
        bet.makeBetPremierLeague(matchLineAndColumn, betValue);
    }

    @When("^Enter the Username and Password$")
    public void enterTheUsernameAndPassword() throws Throwable {
        login.doLogin();
    }

    @And("^Go to a Football by menu$")
    public void goToAFootballByMenu() throws Throwable {
        bet.goToFootballByMenu();
    }

    @And("^Go to compatitions")
    public void goToCompatitions() throws Throwable {
        bet.goToCompatitions();
    }


    @Then("^Select event and place a £0.05 bet for the home team to ‘Win’$")
    public void selectOptionHomeWin(){
        bet.makeBetPremierLeague(matchLineAndColumn, betValue);
    }

    @And("^Click on Place bet button$")
    public void clickOnPlaceBet(){
        bet.clickOnPlaceBet();
    }


    @Then("^Assert the odds and returns offered$")
    public void assertOddsAndReturns(){
        String total =  bet.totalReturnValue();
        String estimated = bet.estimatedReturnValue();
        Assert.assertEquals(total,estimated);
    }



}
