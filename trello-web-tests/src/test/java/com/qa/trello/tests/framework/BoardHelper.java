package com.qa.trello.tests.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class BoardHelper extends HelperBase {

    public BoardHelper(WebDriver wd) {
        super(wd);
    }

    public void confirmBoardForm() {
        waitForElementLocatedAndclick(By.cssSelector("[type='button']"), 20);
    }

    public void fillBoardForm(String boardName) {
        type(By.className("_23NUW98LaZfBpQ"), boardName);
        waitForElementLocatedAndclick(By.cssSelector("button.W6rMLOx8U0MrPx"), 20);
        waitForElementLocatedAndclick(By.xpath("//li[1]/button[@class='_2jR0BZMM5cBReR']"), 20);

    }

    public void initBoardCreation() {
        waitForElementLocatedAndclick(By.name("add"), 20);
        waitForElementLocatedAndclick(By.className("_2DBw9GxD3tha0R"), 20);
    }

    public void permanentlyDeleteBoard() {
        waitForElementLocatedAndclick(By.cssSelector(".js-delete"), 20);
        confirm();
    }

    public void initOnCloseBoardInMoreMenu() {
        clickCloseBoardFromMoreMenu();
        confirm();
    }

    public void initClickCloseBoardFromMoreMenu() {
        clickCloseBoardFromMoreMenu();
        confirm();
    }

    public void clickCloseBoardFromMoreMenu() {
        waitForElementLocatedAndclick(By.cssSelector(".js-close-board"), 20);
    }


    public void clickMoreButton() {
        waitForElementLocatedAndclick(By.cssSelector(".js-open-more"), 20);
    }

    public void openFirstPersonalBoard() {
        waitForElementLocatedAndclick(By.xpath("//*[@class='icon-lg icon-member']/../../..//li"), 20);
    }

    public void createBoard(){
        initBoardCreation();
        fillBoardForm("new board Lena");
        confirmBoardForm();
        returnToHomePage();
    }

    public int getBoardsCount() {
        return wd.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size()-1;

    }

    public void renameBoard() {
        wd.findElement(By.cssSelector(".js-rename-board")).click();
        wd.findElement(By.cssSelector("input.js-board-name-input")).sendKeys("Lena's Board" + Keys.ENTER);
    }

    public void goToBoardsPageURL(String username){
        wd.navigate().to("https://trello.com/" + username + "/boards");
    }
}
