package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.CarvanaFirstScenario;
import pages.CarvanaSecondScenario;
import pages.CarvanaThirdScenario;
import utilities.Driver;
import utilities.Waiter;

public class Carvana {

    public WebDriver driver;
    public CarvanaFirstScenario carvanaFirstScenario;
    public CarvanaSecondScenario carvanaSecondScenario;
    public CarvanaThirdScenario carvanaThirdScenario;
    public Actions actions;
    public Select select;

    @Before
    public void setUp(){
        driver = Driver.getDriver();
        carvanaFirstScenario = new CarvanaFirstScenario(driver);
        carvanaSecondScenario = new CarvanaSecondScenario(driver);
        carvanaThirdScenario = new CarvanaThirdScenario(driver);
        actions = new Actions(driver);

    }

    @Given("user is on {string}")
    public void userIsOn(String url) {
        driver.get(url);
    }

    @When("user clicks on {string} menu item")
    public void userClicksOnMenuItem(String link) {

        WebElement element = driver.findElement(By.partialLinkText(link));
        if (element.getText().contains(carvanaFirstScenario.carFinder.getText())) {
            element.click();
        } else if (element.getText().contains(carvanaSecondScenario.sellAndTrade.getText())) {
            element.click();
        } else if (element.getText().contains(carvanaThirdScenario.autoLoanCalculator.getText().substring(0, carvanaThirdScenario.autoLoanCalculator.getText().length()-2))){
            element.click();
        } else {
            throw new NotFoundException();
        }
    }

    @Then("user should be navigated to {string}")
    public void userShouldBeNavigatedTo(String newUrl) {

        switch (newUrl){
            case "https://www.carvana.com/help-me-search/":
                Assert.assertEquals(newUrl, driver.getCurrentUrl());
                break;
            case "https://www.carvana.com/help-me-search/qa":
                Assert.assertEquals(newUrl, driver.getCurrentUrl());
                break;
            case "https://www.carvana.com/sell-my-car":
                Assert.assertEquals(newUrl, driver.getCurrentUrl());
                break;
            default:
                throw new NotFoundException(newUrl + " not found");
        }
    }

    @And("user should see {string} text")
    public void userShouldSeeText(String expectedText) {
        switch (expectedText){
            case "WHAT CAR SHOULD I GET?":
                Assert.assertTrue(carvanaFirstScenario.heading1.isDisplayed());
                break;
            case "Car Finder can help! Answer a few quick questions to find the right car for you.":
                Assert.assertTrue(carvanaFirstScenario.heading3.isDisplayed());
                break;
            case "What is most important to you in your next car?":
                Assert.assertTrue(carvanaFirstScenario.questionText.isDisplayed());
                break;
            case "Select up to 4 in order of importance":
                Assert.assertTrue(carvanaFirstScenario.underQuestionText.isDisplayed());
                break;
            case "GET A REAL OFFER IN 2 MINUTES":
                Assert.assertTrue(carvanaSecondScenario.heading1.isDisplayed());
                break;
            case "We pick up your car. You get paid on the spot.":
                Assert.assertTrue(carvanaSecondScenario.subHeading.isDisplayed());
                break;
            case "We couldn’t find that VIN. Please check your entry and try again.":
                Assert.assertTrue(carvanaSecondScenario.errorMessage.isDisplayed());
                break;
            default:
                throw new NotFoundException(expectedText + " not found");
        }

    }

    @And("user should see {string} link")
    public void userShouldSeeLink(String expectedText) {
        Assert.assertTrue(carvanaFirstScenario.tryCarFinder.isDisplayed());
    }

    @When("user clicks on {string} link")
    public void userClicksOnLink(String str) {
        driver.findElement(By.partialLinkText(str)).click();
    }

    @When("user clicks on {string} button")
    public void userClicksOnButton(String button) {
        switch (button){
            case "VIN":
                carvanaSecondScenario.vinButton.click();
                break;
            case "GET MY OFFER":
                carvanaSecondScenario.getMyOfferButton.click();
                break;
        }

    }

    @And("user enters vin number as {string}")
    public void userEntersVinNumberAs(String number) {
        carvanaSecondScenario.vinInput.sendKeys(number);
    }

    @When("user hovers over on {string} menu item")
    public void userHoversOverOnMenuItem(String arg0) {
        actions.moveToElement(carvanaThirdScenario.financing).perform();

    }

    @When("user enters {string} as {string}")
    public void userEntersAs(String arg0, String number) {
        switch (number){
            case "10,000":
                carvanaThirdScenario.costOfCar.clear();
                carvanaThirdScenario.costOfCar.sendKeys(number);
                break;
            case "1,500":
                carvanaThirdScenario.downPayment.clear();
                carvanaThirdScenario.downPayment.sendKeys(number);
                break;
        }

    }

    @And("user selects {string} as {string}")
    public void userSelectsAs(String arg0, String value) {
        switch (value){
            case "Excellent: 780":
                select = new Select(carvanaThirdScenario.creditScore);
                select.selectByVisibleText(value);
                select = null;
                break;
            case "60 Months":
                select = new Select(carvanaThirdScenario.loanTerm);
                select.selectByVisibleText(value);
                break;
            default:
                throw new NotFoundException();
        }

    }

    @Then("user should see the monthly payment as {string}")
    public void userShouldSeeTheMonthlyPaymentAs(String number) {
        Assert.assertEquals(carvanaThirdScenario.loanCalculator.getText(), number);

    }
}