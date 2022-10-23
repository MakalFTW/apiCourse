package apiCourse.stepdefinitions;

import apiCourse.helpers.TestCaseContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void beforeHook(){
        TestCaseContext.init();
        System.out.println("The scenario has started");
    }

    @After
    public void afterHook(){
        System.out.println("The scenario has ended");
    }

}
