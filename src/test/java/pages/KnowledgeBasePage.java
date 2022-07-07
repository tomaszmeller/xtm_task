package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KnowledgeBasePage {
    private final WebDriver driver;

    public KnowledgeBasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li[@id='menu-item-5037']")
    WebElement bttnDocumentation;

    public void openDocumentationPage() {
        bttnDocumentation.click();
    }


}
