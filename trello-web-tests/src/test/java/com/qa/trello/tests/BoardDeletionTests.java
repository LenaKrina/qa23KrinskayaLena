package com.qa.trello.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions(){
        if(isOnBoardsPage()){
            click(By.cssSelector("[href$=boards]"));
        }
        if (getBoardsCount() == 0){
            createBoard();
        }
    }

    @Test
    public void testBoardDeletion(){
        int before = getBoardsCount();
        openFirstPersonalBoard();
        clickMoreButton();
        initOnCloseBoardInMoreMenu();
        permanentlyDeleteBoard();
        returnToHomePage();
        int after = getBoardsCount();
        System.out.println("was: " + before + " now: " + after);

        Assert.assertEquals(after, before-1);
    }


}
