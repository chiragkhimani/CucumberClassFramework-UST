package com.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverManager {

    static WebDriver driver;

    public static void createDriver() {
        ChromeOptions options = new ChromeOptions();
        if (isCiOrHeadless()) {
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--window-size=1920,1080");
        }
        driver = new ChromeDriver(options);
        if (!isCiOrHeadless()) {
            driver.manage().window().maximize();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    private static boolean isCiOrHeadless() {
        return "true".equalsIgnoreCase(System.getenv("CI"))
                || "true".equalsIgnoreCase(System.getenv("HEADLESS"));
    }

    public static WebDriver getDriver() {
        return driver;
    }

}
