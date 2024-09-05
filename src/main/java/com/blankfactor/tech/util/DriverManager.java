package com.blankfactor.tech.util;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

@Getter
public class DriverManager {

    private static WebDriver driver;

    private DriverManager() {
        // private constructor to prevent instantiation
    }

    public static WebDriver getDriver(String browserName) {
        if (driver == null) {
            switch (browserName.toLowerCase()) {
                case "edge":
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("--disable-gpu", "start-maximized", "--disable-notifications", "--disable-extensions");
                    driver = new EdgeDriver(edgeOptions);
                    break;

                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--disable-gpu", "start-maximized", "--disable-translate", "--disable-notifications", "--disable-dev-shm-usage");
                    driver = new ChromeDriver(chromeOptions);
                    driver.manage().deleteAllCookies();
                    break;

                case "safari":
                    SafariOptions safariOptions = new SafariOptions();
                    driver = new SafariDriver(safariOptions);
                    break;

                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    driver = new FirefoxDriver(firefoxOptions);
                    break;

                default:
                    throw new IllegalArgumentException("Invalid browser name: " + browserName);
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null; // Reset the driver reference to allow reinitialization
        }
    }
}
