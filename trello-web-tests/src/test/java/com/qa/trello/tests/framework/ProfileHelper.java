package com.qa.trello.tests.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.io.File;

public class ProfileHelper extends HelperBase {
    public ProfileHelper(WebDriver wd) {
        super(wd);
    }

    public void clickOnAvatar() {
        click(By.cssSelector("[data-test-id=header-member-menu-button]"));
    }

    public void selectProfileAndVisibility() {
        click(By.cssSelector("[data-test-id=header-member-menu-profile]"));
    }

    public void initChangeProfilePhoto() {
        WebElement avatar = wd.findElement((By.cssSelector("[class='rsiNque2CCqtPE']")));
        new Actions(wd).moveToElement(avatar).perform();
        click(By.xpath("//button[@class='_2e97X7K2YRLv4Q']"));

    }

    public void attachFile(By locator, File file){
        wd.findElement(locator).sendKeys(file.getAbsolutePath());
    }

    public void uploadPhoto() throws InterruptedException {
        attachFile(By.cssSelector("[name=file]"), new File("C:\\Users\\Elena\\Documents\\GitHub\\qa23KrinskayaLena\\trello-web-tests\\src\\test\\resources\\HZ-iuRMf.png"));
        Thread.sleep(4000);

    }

}
