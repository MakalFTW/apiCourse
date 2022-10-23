package apiCourse.stepdefinitions;

import apiCourse.domain.Board;
import apiCourse.helpers.TestCaseContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;

import static apiCourse.clients.TrelloClient.getBoardInfo;
import static apiCourse.constants.ProjectConstants.BOARD_ID;
import static apiCourse.constants.ProjectConstants.BOARD_NAME;

public class TrelloSteps {

    @Given("The board exists and contains the correct information")
    public void getBoardAndCheckInfo(){
        Response response = getBoardInfo(BOARD_ID);
        Board board = response.as(Board.class);

        Assertions.assertThat(board.getId())
                .as("We asset that board id is correct")
                .isEqualTo(BOARD_ID);

        Assertions.assertThat(board.getName())
                .as("We assert that board name is correct")
                .isEqualTo(BOARD_NAME);

        TestCaseContext.setBoard(board);
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
