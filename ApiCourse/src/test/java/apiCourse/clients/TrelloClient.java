package apiCourse.clients;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static apiCourse.constants.ProjectConstants.API_KEY;
import static apiCourse.constants.ProjectConstants.API_TOKEN;

public class TrelloClient {

    public static Response getBoardInfo(String boardId){
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .queryParam("key", API_KEY)
                .queryParam("token", API_TOKEN)
                .when()
                .get("https://api.trello.com/1/boards/" + boardId)
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }

}
