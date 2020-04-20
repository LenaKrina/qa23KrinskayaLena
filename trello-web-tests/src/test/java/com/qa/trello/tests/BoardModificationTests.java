package com.qa.trello.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class BoardModificationTests extends TestBase {

    @Test
    public void testRenameBoard(){
        openFirstPersonalBoard();
        renameBoard();
        returnToHomePage();

    }

}
