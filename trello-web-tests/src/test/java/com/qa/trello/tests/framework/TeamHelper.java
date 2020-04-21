package com.qa.trello.tests.framework;

import com.qa.trello.tests.framework.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TeamHelper extends HelperBase {

    public TeamHelper(WebDriver wd) {
        super(wd);
    }

    public void fillGroupForm(String groupName, String groupDescription) throws InterruptedException {
        type(By.cssSelector("[class='_1CLyNodCAa-vQi']"), groupName);
        click(By.cssSelector("[id='teamTypeSelect']"));
        Thread.sleep(2000);
        click(By.cssSelector("[data-test-id^=header-create-team-type] li"));
        type(By.cssSelector("[id$='create-team-org-description']"), groupDescription);
    }

    public void inviteTeamLater() {
        if(wd.findElements(By.cssSelector("[data-test-id=show-later-button]")).size() != 0){
            click(By.cssSelector("[data-test-id=show-later-button]"));
        }
    }

    public void confirmGroupForm() {
        click(By.cssSelector("[type='submit']"));
    }

    public void initGroupCreation() {
        click(By.cssSelector(".icon-add.icon-sm"));
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
        click(By.className("quiet-button"));
        click(By.cssSelector("[type='submit']"));
    }

    public void openFirstGroup() {
        click(By.cssSelector("[data-test-id='home-team-tab-name']"));
    }

    public void clickSettingsButton() {
        click(By.xpath("//li[@class='pgEbaAFZBA0N5R']//li[4]//a[1]//span[2]"));
    }
}
