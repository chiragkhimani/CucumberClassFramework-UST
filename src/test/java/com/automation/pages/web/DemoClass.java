package com.automation.pages.web;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DemoClass {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.redbus.in/bus-tickets/pune-to-goa?fromCityName=Pune&fromCityId=130&srcCountry=IND&toCityName=Goa&toCityId=210&destCountry=IND&onward=5-Sep-2024&opId=0&busType=Any");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        Thread.sleep(10000);
        // Find the canvas element
        WebElement canvas = driver.findElement(By.xpath("//canvas[@data-type='lower']"));

        var canvas_dimensions = canvas.getSize();
        var canvas_center_x = canvas_dimensions.getWidth() / 2;
        var canvas_center_y = canvas_dimensions.getHeight() / 2;

        //Click button on the canvas
        int x = 10, y = 10;
        while (x < canvas_center_x && y < canvas_center_y && !isPresent(driver, "//span[@class='bpdp-point' and @data-value='bp']")) {
            clickOnBus(driver, canvas, x, y);
            x = x + 10;
            y = y + 10;
        }

    }

    public static boolean isPresent(WebDriver driver, String xpath) {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
            driver.findElement(By.xpath(xpath));
            return true;
        } catch (Exception e) {
            return false;
        }finally {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        }
    }

    public static void clickOnBus(WebDriver driver, WebElement canvas, int x, int y) {
        new Actions(driver)
                .moveToElement(canvas, x, y)
                .click().pause(1000).build()
                .perform();
    }
}
