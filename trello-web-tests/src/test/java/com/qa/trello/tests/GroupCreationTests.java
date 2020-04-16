package com.qa.trello.tests;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase{

    @Test
    public void testGroupCreation() {

        initGroupCreation();
        fillGroupForm("new group Lena", "group description");
        confirmGroupForm();

    }



}
