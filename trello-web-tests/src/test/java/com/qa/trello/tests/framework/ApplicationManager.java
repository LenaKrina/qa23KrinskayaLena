package com.qa.trello.tests.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    BoardHelper board;
    TeamHelper team;
    SessionHelper session;
    String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }


    public void init() throws InterruptedException {
        if(browser.equals(BrowserType.CHROME)){
            wd = new ChromeDriver();
        } if(browser.equals(BrowserType.FIREFOX)){
            wd = new FirefoxDriver();
        }


        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        wd.navigate().to("https://trello.com/");

        session = new SessionHelper(wd);
        session.login("krinskaya@gmail.com", "Krina123");
        Thread.sleep(3000);

        board = new BoardHelper(wd);
        team = new TeamHelper(wd);


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
}
