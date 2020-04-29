package com.qa.trello.tests.tests;

import com.qa.trello.model.Board;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if (!app.isOnBoardsPage()) {
            app.getBoard().goToBoardsPageURL("lena01228137");
        }
    }

    @Test
    public void testBoardCreation() {
        int before = app.getBoard().getBoardsCount();
        app.getBoard().initBoardCreation();
        app.getBoard().fillBoardForm(new Board().withName("new board").withTeam("No team"));
        app.getBoard().confirmBoardForm();
        app.getBoard().returnToHomePage();
        int after = app.getBoard().getBoardsCount();

        System.out.println("was: " + before + " now: " + after);
        Assert.assertEquals(after, before+1);
    }

}
