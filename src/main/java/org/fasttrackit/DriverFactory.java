package org.fasttrackit;

import org.fasttrackit.AppConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {
    private static WebDriver driver;

    public static WebDriver initDriver(String browser){

        switch (browser.toLowerCase()){

            default:
                System.out.println("Creating default driver from Chrome...");
            case "chrome":
                System.setProperty("webdriver.chrome.driver", AppConfig.getChromeDriverPath());
                System.out.println(System.getProperty("webdriver.chrome.driver"));
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver",
                        AppConfig.getGeckoDriverPath());
                System.out.println(System.getProperty("webdriver.gecko.driver"));
                driver = new FirefoxDriver();
                break;
            case "ie":
                System.setProperty("webdriver.ie.driver",
                        AppConfig.getIeDriverPath());
                System.out.println(System.getProperty("webdriver.ie.driver"));
                driver = new InternetExplorerDriver();
                break;

        }

        return driver;
    }

    public static WebDriver getDriver() {
        return driver; }
}
