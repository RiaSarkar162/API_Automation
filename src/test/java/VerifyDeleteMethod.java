import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class VerifyDeleteMethod {
    String baseUrl= "https://reqres.in/";

    @Test
    public void verifyDeleteMethod() {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .pathParam("pageNumber", "2")
                .log().all()
                .when()
                .delete(baseUrl + "api/users/{pageNumber}");
        response.then().log().all()
                .assertThat()
                .statusCode(204);
    }

}
