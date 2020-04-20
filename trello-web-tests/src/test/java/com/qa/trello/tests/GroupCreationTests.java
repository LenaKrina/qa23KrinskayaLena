package com.qa.trello.tests;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase{

    @Test
    public void testGroupCreation() throws InterruptedException {

        app.initGroupCreation();
        app.fillGroupForm("new group Lena1", "group description");
        app.confirmGroupForm();
        app.inviteTeamLater();
        app.returnToHomePage();

    }


}
