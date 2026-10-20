package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;
import java.util.Locale;

public final class DriverFactory {

    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    public static void initDriver() {
        String browser = ConfigReader.get("browser");
        boolean headless = ConfigReader.getBoolean("headless", false);

        WebDriver driver;

        switch (browser) {
            case "chrome" -> {
                ChromeOptions options = new ChromeOptions();

                if (headless) {
                    options.addArguments("--headless=new");
                }

                options.addArguments("--window-size=1440,1000");
                driver = new ChromeDriver(options);
            }

            case "firefox" -> {
                FirefoxOptions options = new FirefoxOptions();

                if (headless) {
                    options.addArguments("-headless");
                }

                driver = new FirefoxDriver(options);
            }
            default -> throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ZERO);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        DRIVER.set(driver);
    }

    public static WebDriver getDriver() {
        WebDriver driver = DRIVER.get();

        if (driver == null) {
            throw new IllegalStateException("WebDriver is not initialized. Check hooks.Hooks.");
        }
        return driver;
    }

    public static void quitDriver() {
        WebDriver driver = DRIVER.get();

        try {
            if (driver != null) {
                driver.quit();
            }
        } finally {
            DRIVER.remove();
        }
    }
}
