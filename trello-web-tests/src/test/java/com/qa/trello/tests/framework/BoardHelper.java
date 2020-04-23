package com.qa.trello.tests.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class BoardHelper extends HelperBase {

    public BoardHelper(WebDriver wd) {
        super(wd);
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

    public int getBoardsCount() {
        return wd.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size()-1;

    }

    public void renameBoard() {
        wd.findElement(By.cssSelector(".js-rename-board")).click();
        wd.findElement(By.cssSelector("input.js-board-name-input")).sendKeys("Lena's Board" + Keys.ENTER);
    }
}
