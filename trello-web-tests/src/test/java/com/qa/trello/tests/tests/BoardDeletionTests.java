package com.qa.trello.tests.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if(!app.isOnBoardsPage()){
            app.getBoard().goToBoardsPageURL("lena01228137");
        }
        if (app.getBoard().getBoardsCount() == 0){
            app.getBoard().createBoard();
        }
    }

    @Test
    public void testBoardDeletion(){
        int before = app.getBoard().getBoardsCount();
        app.getBoard().openFirstPersonalBoard();
        app.getBoard().clickMoreButton();
        app.getBoard().initOnCloseBoardInMoreMenu();
        app.getBoard().permanentlyDeleteBoard();
        app.getBoard().returnToHomePage();
        int after = app.getBoard().getBoardsCount();
        System.out.println("was: " + before + " now: " + after);

        Assert.assertEquals(after, before-1);
    }


}
