package com.telran.qa.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginJira {
WebDriver wd;

    @BeforeClass
    public void setUp() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.get("http://jira.tel-ran.net/");
    }

    @Test
    public void testLoginJiraNegative() throws InterruptedException {
        Type(By.id("login-form-username"), "krinskaya");
        Type(By.id("login-form-password"), "jhgjhg");
        wd.findElement(By.id("login")).click();

        Assert.assertTrue(isElementPresent(By.id("usernameerror")));

        String errorMessage = wd.findElement(By.id("usernameerror")).getText();

        Assert.assertEquals(errorMessage, "Sorry, your username and password are incorrect - please try again.");


        Thread.sleep(3000);

    }
    @Test
    public void testLoginJira() throws InterruptedException {
        Type(By.id("login-form-username"), "krinskaya");
        Type(By.id("login-form-password"), "3043872");
        wd.findElement(By.id("login")).click();

        Assert.assertTrue(isElementPresent(By.id("usernameerror")));

        Thread.sleep(3000);

    }

    public void Type(By locator, String text) {
        wd.findElement(locator).click();
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public boolean isElementPresent(By locator){
        return wd.findElements(locator).size()>0;
    }


    @AfterClass
    public void tearDown(){
        wd.quit();
    }
}
