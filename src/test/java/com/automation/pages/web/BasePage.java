package com.automation.pages.web;

import com.automation.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    WebDriver driver;

    public BasePage(){
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);

    }

    public boolean isDisplay(WebElement element){
        try {
            return element.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

}
