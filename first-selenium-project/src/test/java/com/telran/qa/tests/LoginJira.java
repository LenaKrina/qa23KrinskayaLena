package com.telran.qa.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginJira {
WebDriver wd;
}
    @BeforeClass
    public void setUp() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.get("http://jira.tel-ran.net/");
    }

    @Test
    public void testLoginJira() throws InterruptedException {
    wd.findElement(By.id("login-form-username")).click();
    wd.findElement(By.id("login-form-username")).clear();
    wd.findElement(By.id("login-form-username")).sendKeys("krinskaya");
    wd.findElement(By.id("login-form-password")).sendKeys("3043872");
    wd.findElement(By.id("login")).click();



        Thread.sleep(3000);

    }


    @AfterClass
    public void tearDown(){
        wd.quit();
    }
}
