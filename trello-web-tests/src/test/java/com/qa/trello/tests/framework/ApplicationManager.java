package com.qa.trello.tests.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    BoardHelper board;
    TeamHelper team;
    SessionHelper session;
    String browser;
    ProfileHelper profile;
    Properties properties;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }


    public void init() throws InterruptedException, IOException {
        if(browser.equals(BrowserType.CHROME)){
            wd = new ChromeDriver();
        } if(browser.equals(BrowserType.FIREFOX)){
            wd = new FirefoxDriver();
        }


        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wd.manage().window().maximize();

        properties = new Properties();
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

        wd.navigate().to(properties.getProperty("web.baseURL"));

        session = new SessionHelper(wd);
        session.login(properties.getProperty("web.user"), properties.getProperty("web.password"));
        Thread.sleep(3000);

        board = new BoardHelper(wd);
        team = new TeamHelper(wd);
        profile = new ProfileHelper(wd);


    }

    public void stop() {
        wd.quit();
    }

    public boolean isOnBoardsPage() throws InterruptedException {
        Thread.sleep(4000);
        String url = wd.getCurrentUrl();
        return url.contains("boards");
    }

    public BoardHelper getBoard() {
        return board;
    }

    public TeamHelper getTeam() {
        return team;
    }

    public SessionHelper getSession() {
        return session;
    }

    public ProfileHelper getProfile() {
        return profile;
    }
}
