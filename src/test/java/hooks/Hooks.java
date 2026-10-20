package hooks;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {
    @Before
    public void setUp() {
        DriverFactory.initDriver();
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }

    @AfterStep
    public void takeScreenshotAfterEachStep(Scenario scenario) {
        if (DriverFactory.getDriver() != null) {
            captureScreenshot(scenario);
        }
    }

    public static void captureScreenshot(Scenario scenario) {

        WebDriver driver = DriverFactory.getDriver();

        byte[] screenshot = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);

        scenario.attach(
                screenshot,
                "image/png",
                scenario.getName()
        );
    }
}
