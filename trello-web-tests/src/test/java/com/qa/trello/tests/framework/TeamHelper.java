package com.qa.trello.tests.framework;

import com.qa.trello.tests.framework.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TeamHelper extends HelperBase {

    public TeamHelper(WebDriver wd) {
        super(wd);
    }

    public void fillGroupForm(String groupName, String groupDescription) throws InterruptedException {
        type(By.cssSelector("[data-test-id=header-create-team-name-input]"), groupName);
        waitForElementLocatedAndclick(By.cssSelector("[id='teamTypeSelect']"), 20);
        Thread.sleep(2000);
        waitForElementLocatedAndclick(By.cssSelector("[data-test-id^=header-create-team-type] li"), 20);
        type(By.cssSelector("[id$='create-team-org-description']"), groupDescription);
    }

    public void inviteTeamLater() {
        if(wd.findElements(By.cssSelector("[data-test-id=show-later-button]")).size() != 0){
            waitForElementLocatedAndclick(By.cssSelector("[data-test-id=show-later-button]"), 20);
        }
    }

    public void confirmGroupForm() {
        waitForElementLocatedAndclick(By.cssSelector("[type='submit']"), 20);
    }

    public void initGroupCreation() {
        waitForElementLocatedAndclick(By.cssSelector(".icon-add.icon-sm"), 20);
    }

    public void createGroup(){
        openFirstGroup();
        clickSettingsButton();
        permanentlyDeleteGroup();
        returnToHomePage();
    }

    public int getGroupsCount() {
        return wd.findElements(By.cssSelector("[data-test-id='home-team-tab-name']")).size()-1;
    }

    public void permanentlyDeleteGroup() {
        waitForElementLocatedAndclick(By.className("quiet-button"), 20);
        waitForElementLocatedAndclick(By.cssSelector("[type='submit']"), 20);
    }

    public void openFirstGroup() {
        waitForElementLocatedAndclick(By.cssSelector("[data-test-id='home-team-tab-name']"), 20);
    }

    public void clickSettingsButton() {
        waitForElementLocatedAndclick(By.xpath("//li[@class='pgEbaAFZBA0N5R']//li[4]//a[1]//span[2]"), 20);
    }


}
