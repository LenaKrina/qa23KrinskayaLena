package com.qa.trello.tests.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions(){
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
