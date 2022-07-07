package testSet;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import pages.DocumentationPage;
import pages.HomePage;
import pages.KnowledgeBasePage;

import java.io.File;
import java.time.Duration;

public class DownloadManualTest {
    private HomePage homePage;
    private KnowledgeBasePage knowledgeBasePage;
    private DocumentationPage documentationPage;
    private FluentWait<WebDriver> wait;
    private File manualPdf;
    private static WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver3.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://xtm.cloud/");
    }

    @Test
    public void downloadingManual() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.dealWithCookies();
        homePage.openKnowledgeBase();
        knowledgeBasePage = new KnowledgeBasePage(driver);
        knowledgeBasePage.openDocumentationPage();
        documentationPage = new DocumentationPage(driver);
        documentationPage.downloadManual();
        manualPdf = new File("C:\\Users\\t_mel\\Downloads\\xtm-editor.x43872.pdf");
        wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(500));
        wait.until(x -> manualPdf.exists());
        Assert.assertTrue(manualPdf.exists());
        manualPdf.delete();
    }

    @After
    public void clenUp() {
        driver.quit();
    }
}
