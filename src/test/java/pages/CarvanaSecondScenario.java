package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarvanaSecondScenario {
    public CarvanaSecondScenario(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//a[@href='/sell-my-car'])[1]")
    public WebElement sellAndTrade;
    @FindBy(xpath = "//div[@role='heading']")
    public WebElement heading1;

    @FindBy(xpath = "(//div/div/div/div[3])[4]")
    public WebElement subHeading;

    @FindBy(xpath = "//button[@data-cv-test='VINToggle']")
    public WebElement vinButton;

    @FindBy(xpath = "//input[@aria-labelledby='VIN']")
    public WebElement vinInput;

    @FindBy(xpath = "//button[@data-cv-test='heroGetMyOfferButton']")
    public WebElement getMyOfferButton;

    @FindBy(xpath = "//div[@class='ErrorMessageContainer-oo6j68-8 bEWysd']")
    public WebElement errorMessage;
}
