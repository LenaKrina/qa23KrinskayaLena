package com.qa.trello.tests.tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if (!app.isOnBoardsPage()) {
            app.getBoard().goToBoardsPageURL("lena01228137");
        }
    }


    @Test
    public void testGroupCreation() throws InterruptedException {

        app.getTeam().initGroupCreation();
        app.getTeam().fillGroupForm("new group Lena1", "group description");
        app.getTeam().confirmGroupForm();
        app.getTeam().inviteTeamLater();
        app.getTeam().returnToHomePage();

    }


}
