package com.qa.trello.tests.tests;

import org.testng.annotations.Test;

public class ProfileModificationTests extends TestBase {

    @Test
    public void testChangeProfileAvatar() throws InterruptedException {
        long beforeScreenshot = System.currentTimeMillis();
        app.getProfile().takeScreenshot(beforeScreenshot);
        app.getProfile().clickOnAvatar();
        app.getProfile().selectProfileAndVisibility();
        app.getProfile().initChangeProfilePhoto();
        app.getProfile().uploadPhoto();

        app.getProfile().refreshPage();

        long afterScreenshot = System.currentTimeMillis();
        app.getProfile().takeScreenshot(afterScreenshot);

        logger.info("screnshot before: screen-" + beforeScreenshot + ".png");
        logger.info("screnshot after: screen-" + afterScreenshot + ".png");

        app.getProfile().returnToHomePage();


    }


}
