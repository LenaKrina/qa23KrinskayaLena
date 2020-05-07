package com.qa.trello.tests.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileModificationTests extends TestBase {

    @Test
    public void testChangeProfileAvatar() throws InterruptedException {
        app.getProfile().clickOnAvatar();
        app.getProfile().selectProfileAndVisibility();
        app.getProfile().initChangeProfilePhoto();
        app.getProfile().uploadPhoto();
        app.getProfile().returnToHomePage();
       // Assert.assertTrue(app.getProfile().avatarAdded());

    }


}
