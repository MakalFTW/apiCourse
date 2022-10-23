package apiCourse.helpers;

import apiCourse.domain.Board;

public class TestCaseContext {

    private static Board board;

    public static void init(){
        board = null;
    }

    public static void setBoard(Board board){
        TestCaseContext.board = board;
    }

    public static Board getBoard(){
        return board;
    }

}
