package com.qa.trello.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase{

    @Test
    public void testGroupCreation() throws InterruptedException {

        initGroupCreation();
        fillGroupForm("new group Lena1", "group description");
        confirmGroupForm();
        inviteTeamLater();
        returnToHomePage();

    }


}
