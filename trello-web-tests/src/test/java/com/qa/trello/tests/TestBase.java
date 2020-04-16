package com.qa.trello.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {

    WebDriver wd;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp(){
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wait = new WebDriverWait(wd, 20);
        wd.manage().window().maximize();
        wd.navigate().to("https://trello.com/");
        login("krinskaya@gmail.com", "Krina123");

    }

    public void login(String email, String password) {
        initLogin();
        fillLoginForm(email, password);
        confirmLogin();
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

    @AfterMethod
    public void tearDown(){
        wd.quit();
    }

    public void returnToHomePage() {
        click(By.cssSelector("[name='house']"));
    }

    public void confirmBoardForm() {
        click(By.cssSelector("[type='button']"));
    }

    public void fillBoardForm(String boardName) {
        type(By.className("_23NUW98LaZfBpQ"), boardName);
    }

    public void initBoardCreation() {
        click(By.name("add"));
        click(By.className("_2DBw9GxD3tha0R"));
    }
}
