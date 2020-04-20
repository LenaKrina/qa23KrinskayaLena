package com.qa.trello.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {

    @Test
    public void testBoardCreation() {
        int before = app.getBoardsCount();
        app.initBoardCreation();
        app.fillBoardForm("new board Lena");
        app.confirmBoardForm();
        app.returnToHomePage();
        int after = app.getBoardsCount();

        System.out.println("was: " + before + " now: " + after);
        Assert.assertEquals(after, before+1);
    }

}
