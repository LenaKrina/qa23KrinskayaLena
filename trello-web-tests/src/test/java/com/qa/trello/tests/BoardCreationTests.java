package com.qa.trello.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {

    @Test
    public void testBoardCreation() {
        int before = getBoardsCount();
        initBoardCreation();
        fillBoardForm("new board Lena");
        confirmBoardForm();
        returnToHomePage();
        int after = getBoardsCount();
        Assert.assertEquals(after, before-1);
    }

}
