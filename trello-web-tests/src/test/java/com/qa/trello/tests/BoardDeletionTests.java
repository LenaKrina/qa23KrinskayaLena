package com.qa.trello.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class BoardDeletionTests extends TestBase {
    @Test
    public void testBoardDeletion(){
        openFirstPersonalBoard();
        clickMoreButton();
        initOnCloseBoardInMoreMenu();
        permanentlyDeleteBoard();
        returnToHomePage();
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


}
