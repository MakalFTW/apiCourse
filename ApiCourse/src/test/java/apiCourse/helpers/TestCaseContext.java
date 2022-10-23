package apiCourse.helpers;

import apiCourse.domain.Board;
import apiCourse.domain.Lists;
import io.cucumber.java.Scenario;

public class TestCaseContext {

    private static Board board;
    private static Lists lists;
    private static Scenario scenario;

    public static void init(){
        board = null;
        lists = null;
    }

    public static void setBoard(Board board){
        TestCaseContext.board = board;
    }

    public static Board getBoard(){
        return board;
    }

    public static void setLists(Lists lists) {
        TestCaseContext.lists = lists;
    }

    public static Lists getLists() {
        return lists;
    }

    public static void setScenario(Scenario scenario) {
        TestCaseContext.scenario = scenario;
    }

    public static Scenario getScenario() {
        return TestCaseContext.scenario;
    }
}
