package com.qa.trello.tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions(){
        if(app.isOnBoardsPage()){
            app.click(By.cssSelector("[href$=boards]"));
        }
        if (app.getBoardsCount() == 0){
            app.createBoard();
        }
    }

    @Test
    public void testRenameBoard(){
        app.openFirstPersonalBoard();
        app.renameBoard();
        app.returnToHomePage();

    }

}
