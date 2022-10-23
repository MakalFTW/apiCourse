package apiCourse.stepdefinitions;

import apiCourse.domain.Board;
import apiCourse.domain.Lists;
import apiCourse.helpers.TestCaseContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;

import static apiCourse.clients.TrelloClient.*;
import static apiCourse.constants.ProjectConstants.BOARD_ID;
import static apiCourse.constants.ProjectConstants.BOARD_NAME;

public class TrelloSteps {

    @Given("The board exists and contains the correct information")
    public void getBoardAndCheckInfo(){
        Response response = getBoardInfo(BOARD_ID);
        Board board = response.as(Board.class);
        TestCaseContext.setBoard(board);

        Assertions.assertThat(board.getId())
                .as("We asset that board id is correct")
                .isEqualTo(BOARD_ID);

        Assertions.assertThat(board.getName())
                .as("We assert that board name is correct")
                .isEqualTo(BOARD_NAME);


    }

    @When("I change the board title to {string}")
    public void changeBoardTitle(String title){
        Response response = changeBoardName(title, TestCaseContext.getBoard().getId());
        Board board = response.as(Board.class);
        TestCaseContext.setBoard(board);
    }

    @And("I check that the board title was updated to {string}")
    public void checkBoardTitle(String title){
        Assertions.assertThat(TestCaseContext.getBoard().getName())
                .as("We are checking that name has changed to: " + title)
                .isEqualTo(title);
    }

    @Then("I add a list with title {string} to the board")
    public void addAList(String title){
        Response response = createNewList(title, TestCaseContext.getBoard().getId());
        Lists lists = response.as(Lists.class);
        TestCaseContext.setLists(lists);

        Assertions.assertThat(lists.getName())
                .as("Checking the list name is equal to: " + title)
                .isEqualTo(title);

        TestCaseContext.getScenario().log("The list id is " + lists.getId());
    }

}
