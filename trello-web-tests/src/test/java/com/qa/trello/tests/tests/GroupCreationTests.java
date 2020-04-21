package com.qa.trello.tests.tests;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws InterruptedException {

        app.getTeam().initGroupCreation();
        app.getTeam().fillGroupForm("new group Lena1", "group description");
        app.getTeam().confirmGroupForm();
        app.getTeam().inviteTeamLater();
        app.getTeam().returnToHomePage();

    }


}
