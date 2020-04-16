package com.qa.trello.tests;

import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {

    @Test
    public void testBoardCreation() {

        initBoardCreation();
        fillBoardForm("new board Lena");
        confirmBoardForm();
        returnToHomePage();
    }

}
