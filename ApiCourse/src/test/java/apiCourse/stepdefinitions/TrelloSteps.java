package apiCourse.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TrelloSteps {

    @Given("The board exists and contains the correct information")
    public void getBoardAndCheckInfo(){
        System.out.println("First step is being executed");
    }

    @When("I change the board title to {string}")
    public void changeBoardTitle(String title){
        System.out.println("The title was changed to: " + title);
    }

    @And("I check that the board title was updated to {string}")
    public void checkBoardTitle(String title){
        System.out.println("The board title was changed to: " + title);
    }

    @Then("I add a list with title {string} to the board")
    public void addAList(String title){
        System.out.println("I have added a new list: " + title);
    }

}
