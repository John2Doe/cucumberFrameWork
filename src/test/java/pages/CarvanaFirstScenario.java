package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarvanaFirstScenario {

    public CarvanaFirstScenario(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//a[@data-qa='menu-button-wrapper'])[19]")
    public WebElement carFinder;

    @FindBy(tagName = "h1")
    public WebElement heading1;

    @FindBy(tagName = "h3")
    public WebElement heading3;

    @FindBy(xpath = "//a[@data-qa='router-link']")
    public WebElement tryCarFinder;

    @FindBy(xpath = "//div[@data-qa='headline']")
    public WebElement questionText;

    @FindBy(xpath = "//div[@data-qa='sub-heading']")
    public WebElement underQuestionText;

}
