package com.qa.trello.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions(){
        if (app.getGroupsCount() == 0){
            app.createGroup();
        }
    }

    @Test
    public void testGroupDeletion() {
        int before = app.getGroupsCount();
        app.openFirstGroup();
        app.clickSettingsButton();
        app.permanentlyDeleteGroup();
        app.returnToHomePage();
        int after = app.getGroupsCount();
        System.out.println("was: " + before + " now: " + after);

        Assert.assertEquals(after, before - 1);

    }

}
