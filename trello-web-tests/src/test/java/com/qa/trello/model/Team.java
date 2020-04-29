package com.qa.trello.model;

public class Team {
    private String groupName;
    private String groupDescription;

    public Team withGroupName(String groupName) {
        this.groupName = groupName;
        return this;
    }

    public Team withGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
        return this;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getGroupDescription() {
        return groupDescription;
    }
}
