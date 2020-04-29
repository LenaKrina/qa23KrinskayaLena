package com.qa.trello.model;

public class Board {
    private String name;
    private String team;


    public Board withName(String name) {
        this.name = name;
        return this;
    }

    public Board withTeam(String team) {
        this.team = team;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }
}
