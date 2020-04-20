package com.qa.trello.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions(){
        if (getGroupsCount() == 0){
            createGroup();
        }
    }

    @Test
    public void testGroupDeletion() {
        int before = getGroupsCount();
        openFirstGroup();
        clickSettingsButton();
        permanentlyDeleteGroup();
        returnToHomePage();
        int after = getGroupsCount();
        System.out.println("was: " + before + " now: " + after);

        Assert.assertEquals(after, before - 1);

    }

}
