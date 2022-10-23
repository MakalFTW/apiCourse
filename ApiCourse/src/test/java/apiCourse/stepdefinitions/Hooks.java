package apiCourse.stepdefinitions;

import apiCourse.helpers.TestCaseContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import static apiCourse.clients.TrelloClient.changeBoardName;
import static apiCourse.clients.TrelloClient.deleteTheList;
import static apiCourse.constants.ProjectConstants.BOARD_NAME;

public class Hooks {

    @Before
    public void beforeHook(Scenario scenario){
        TestCaseContext.init();
        TestCaseContext.setScenario(scenario);
        System.out.println("The scenario has started");
    }

    @After
    public void afterHook(){
        changeBoardName(BOARD_NAME, TestCaseContext.getBoard().getId());
        deleteTheList(TestCaseContext.getLists().getId());
        System.out.println("The scenario has ended");
    }

}
