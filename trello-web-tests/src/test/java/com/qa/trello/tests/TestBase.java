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
        init();

    }

    public void init() {
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

    public void fillGroupForm(String groupName, String groupDescription) throws InterruptedException {
        type(By.cssSelector("[class='_1CLyNodCAa-vQi']"), groupName);
        click(By.cssSelector("[id='teamTypeSelect']"));
        Thread.sleep(2000);
        click(By.cssSelector("[data-test-id^=header-create-team-type] li"));
        type(By.cssSelector("[id$='create-team-org-description']"), groupDescription);
    }

    public void inviteTeamLater() {
        if(wd.findElements(By.cssSelector("[data-test-id=show-later-button]")).size() != 0){
            click(By.cssSelector("[data-test-id=show-later-button]"));
        }
    }

    public  boolean isElementPresent(By locator){
        return wd.findElements(locator).size()>0;
    }


    public void confirmGroupForm() {
        click(By.cssSelector("[type='submit']"));
    }

    public void initGroupCreation() {
        click(By.cssSelector(".icon-add.icon-sm"));
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

    public void returnToHomePage() {
        click(By.cssSelector("[name='house']"));
    }

    public void confirmBoardForm() {
        click(By.cssSelector("[type='button']"));
    }

    public void fillBoardForm(String boardName) {
        type(By.className("_23NUW98LaZfBpQ"), boardName);
        click(By.cssSelector("button.W6rMLOx8U0MrPx"));
        click(By.xpath("//li[1]/button[@class='_2jR0BZMM5cBReR']"));
    }

    public void initBoardCreation() {
        click(By.name("add"));
        click(By.className("_2DBw9GxD3tha0R"));
    }

    public void permanentlyDeleteBoard() {
        click(By.cssSelector(".js-delete"));
        confirm();
    }

    public void initOnCloseBoardInMoreMenu() {
        clickCloseBoardFromMoreMenu();
        confirm();
    }

    public void confirm() {
        click(By.cssSelector(".js-confirm"));
    }

    public void clickCloseBoardFromMoreMenu() {
        click(By.cssSelector(".js-close-board"));
    }

    public void clickMoreButton() {
        click(By.cssSelector(".js-open-more"));
    }

    public void openFirstPersonalBoard() {
        click(By.xpath("//*[@class='icon-lg icon-member']/../../..//li"));
    }

    public void createBoard(){
        initBoardCreation();
        fillBoardForm("new board Lena");
        confirmBoardForm();
        returnToHomePage();
    }

    public void createGroup(){
        openFirstGroup();
        clickSettingsButton();
        permanentlyDeleteGroup();
        returnToHomePage();
    }

    public int getBoardsCount() {
        return wd.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size()-1;

    }

    @AfterMethod
    public void tearDown(){
        stop();
    }

    public void stop() {
        wd.quit();
    }


    public int getGroupsCount() {
        return wd.findElements(By.cssSelector("[data-test-id='home-team-tab-name']")).size()-1;
    }

    public void permanentlyDeleteGroup() {
        click(By.className("quiet-button"));
        click(By.cssSelector("[type='submit']"));
    }

    public void openFirstGroup() {
        click(By.cssSelector("[data-test-id='home-team-tab-name']"));
    }

    public void clickSettingsButton() {
        click(By.xpath("//li[@class='pgEbaAFZBA0N5R']//li[4]//a[1]//span[2]"));
    }

    public void renameBoard() {
        type(By.cssSelector("[class='js-board-editing-target board-header-btn-text']"), "Lena's Board");
    }

    public boolean isOnBoardsPage() {
        String url = wd.getCurrentUrl();
        return url.contains("boards");
    }
}
