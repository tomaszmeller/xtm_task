package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='https://xtm.cloud/pricing/']")
    WebElement bttnPricing;
    @FindBy(xpath = "//a[@href='https://xtm.cloud/pricing/#calculator']")
    WebElement bttnCalculator;
    @FindBy(xpath = "//*[@id='hs-eu-confirmation-button']")
    WebElement bttnAcceptCookies;
    @FindBy(xpath = "//*[text()='Academy']")
    WebElement bttnAcademy;
    @FindBy(xpath = "//*[text()='Knowledge Base']")
    WebElement bttnKnowledgeBase;

    public void dealWithCookies() {
        bttnAcceptCookies.click();
    }

    public void openCalculator() {
        Actions action = new Actions(driver);
        action.moveToElement(bttnPricing).perform();
        action.moveToElement(bttnCalculator).perform();
        bttnCalculator.click();
    }

    public void openKnowledgeBase() {
        Actions action = new Actions(driver);
        action.moveToElement(bttnAcademy).perform();
        action.moveToElement(bttnKnowledgeBase).perform();
        bttnKnowledgeBase.click();
    }

}
