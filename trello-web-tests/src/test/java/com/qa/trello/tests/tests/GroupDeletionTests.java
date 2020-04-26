package com.qa.trello.tests.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if (!app.isOnBoardsPage()) {
            app.getBoard().goToBoardsPageURL("lena01228137");
        }
        if (app.getTeam().getGroupsCount() == 0){
            app.getTeam().createGroup();
        }
    }

    @Test
    public void testGroupDeletion() {
        int before = app.getTeam().getGroupsCount();
        app.getTeam().openFirstGroup();
        app.getTeam().clickSettingsButton();
        app.getTeam().permanentlyDeleteGroup();
        app.getTeam().returnToHomePage();
        int after = app.getTeam().getGroupsCount();
        System.out.println("was: " + before + " now: " + after);

        Assert.assertEquals(after, before - 1);

    }

}
