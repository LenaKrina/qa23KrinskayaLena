package com.qa.trello.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GroupCreationTests {

    WebDriver wd;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp(){
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wait = new WebDriverWait(wd, 20);
        wd.manage().window().maximize();
        wd.navigate().to("https://trello.com/");
    }

    @Test
    public void testGroupCreation() {

        initLogin();
        fillLoginForm("krinskaya@gmail.com", "Krina123");
        confirmLogin();
        initGroupCreation();
        fillGroupForm("new group Lena", "group description");
        confirmGroupForm();

    }

    public void fillGroupForm(String groupName, String groupDescription) {
        type(By.cssSelector("[class='_1CLyNodCAa-vQi']"), groupName);
        click(By.cssSelector("[id='teamTypeSelect']"));
        click(By.xpath("//ul//li[1])"));
        type(By.id("1587038052565-create-team-org-description"), groupDescription);
    }

    public void confirmGroupForm() {
        click(By.cssSelector("[type='submit']"));
    }

    public void initGroupCreation() {
        click(By.cssSelector("[class='_33CvMKqfH4Yf0j _3SBHBJq0AAxzqg']"));
    }

    public void confirmLogin() {
        click(By.cssSelector("#login"));
    }

    public void fillLoginForm(String userEmail, String password) {
        click(By.name("user"));
        type(By.cssSelector("#user"), userEmail);
        type(By.cssSelector("#password"), password);
    }

    public void initLogin() {
        click(By.cssSelector("[href='/login']"));
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator)).click();
    }

    //@AfterMethod
    public void tearDown(){
        wd.quit();
    }
}
