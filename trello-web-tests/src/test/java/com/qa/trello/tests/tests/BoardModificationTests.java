package com.qa.trello.tests.tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions(){
        if(app.isOnBoardsPage()){
            app.getBoard().click(By.cssSelector("[href$=boards]"));
        }
        if (app.getBoard().getBoardsCount() == 0){
            app.getBoard().createBoard();
        }
    }

    @Test
    public void testRenameBoard(){
        app.getBoard().openFirstPersonalBoard();
        app.getBoard().renameBoard();
        app.getBoard().returnToHomePage();

    }

}
