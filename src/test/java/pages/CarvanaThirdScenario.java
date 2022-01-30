package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarvanaThirdScenario {
    public CarvanaThirdScenario (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//a[@role='menuitem'])[15]")
    public WebElement financing;

    @FindBy(xpath = "(//a[@role='menuitem'])[18]")
    public WebElement autoLoanCalculator;

    @FindBy(xpath = "//input[@name='vehiclePrice']")
    public WebElement costOfCar;

    @FindBy(xpath = "//select[@name='creditScoreIndex']")
    public WebElement creditScore;

    @FindBy(xpath = "//select[@name='loanTerm']")
    public WebElement loanTerm;

    @FindBy(xpath = "//input[@name='downPayment']")
    public WebElement downPayment;

    @FindBy(xpath = "//div[@class='loan-calculator-display-value']")
    public WebElement loanCalculator;
}
