package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocumentationPage {
    private final WebDriver driver;

    public DocumentationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()='XTM Editor - User Manual']")
    WebElement bttnDownloadManual;

    public void downloadManual() {
        bttnDownloadManual.click();
    }

}
