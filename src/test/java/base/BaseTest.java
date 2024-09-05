package base;

import com.blankfactor.tech.pages.HomePage;
import com.blankfactor.tech.pages.NewsletterPage;
import com.blankfactor.tech.util.DriverManager;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

@Getter
public class BaseTest {

    protected static WebDriver driver;
    protected static HomePage homePage;
    protected static NewsletterPage newsletterPage;

    @BeforeTest(alwaysRun = true)
    public void beforeTest(String browserName) {
        driver = DriverManager.getDriver(browserName); // Get the singleton instance
        homePage = new HomePage(driver);
        newsletterPage = new NewsletterPage(driver);
    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
        DriverManager.quitDriver(); // Ensure that WebDriver is closed
    }
}
