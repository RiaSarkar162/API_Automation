import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class VerifyPostMethod {
    String baseUrl= "https://reqres.in/";
    JSONObject jsonobject = new JSONObject();

    @Test
    public void verifyPostRequest(){
        jsonobject.put("name","Ria");
        jsonobject.put("job","SQA");
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(jsonobject.toString())
                .log().all()
                .when()
                .post(baseUrl + "api/users");
        response.then().log().all()
                .assertThat()
                .statusCode(201)
                .body("createdAt", Matchers.notNullValue());


    }
}
