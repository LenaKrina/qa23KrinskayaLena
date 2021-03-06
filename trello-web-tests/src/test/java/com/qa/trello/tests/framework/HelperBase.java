package com.qa.trello.tests.framework;

import com.google.common.io.Files;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public  boolean isElementPresent(By locator){
        return wd.findElements(locator).size()>0;
    }

    public void type(By locator, String text) {
        if(text != null) {
            waitForElementLocatedAndclick(locator, 30);
            wd.findElement(locator).clear();
            wd.findElement(locator).sendKeys(text);
        }
    }
    public void click(By locator){
        wd.findElement(locator).click();
    }

    public void waitForElementLocatedAndclick(By locator, int timeOut) {
        new WebDriverWait(wd, timeOut).until(ExpectedConditions.presenceOfElementLocated(locator)).click();
    }

    public void waitForElementClickableAndclick(By locator, int timeOut) {
        new WebDriverWait(wd, timeOut).until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void confirm() {
        waitForElementLocatedAndclick(By.cssSelector(".js-confirm"), 20);
    }

    public void returnToHomePage() {
        waitForElementClickableAndclick(By.cssSelector("[name='house']"), 20);
    }

    public void takeScreenshot(long timeMillis) {
        File tmp = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
        File screenshot = new File("screenshots/screen-" + timeMillis + ".png");

        try {
            Files.copy(tmp, screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void refreshPage() {
        wd.navigate().refresh();
    }
}
