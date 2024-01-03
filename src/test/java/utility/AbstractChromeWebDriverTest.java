package utility;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


@CucumberOptions(
        features = "src/test/java/cucumber",
        glue = {"utility","stepDefinitions"},
        plugin = {"pretty", "html:target/cucumber-reports"}
)

public class AbstractChromeWebDriverTest extends AbstractTestNGCucumberTests {

    public static EdgeDriver driver;
    @BeforeTest
    public void beforeTest() throws InterruptedException {
        // Create an instance of your web driver using WebDriverManager
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.get("https://www.topky.sk/");
        Thread.sleep(2000);
    }

    @AfterTest
    public void afterTest() {
        // Close the driver instance
        driver.close();
    }
}
