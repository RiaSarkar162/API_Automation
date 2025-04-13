import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class VerifyPutMethod {

    String baseUrl= "https://reqres.in/";
    JSONObject jsonobject = new JSONObject();

    @Test
    public void verifyPutRequest(){
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("name","Ritu");
        jsonobject.put("job","Jr.SQA");
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .pathParam("pageNumber", "2")
                .body(jsonobject.toString())
                .log().all()
                .when()
                .put(baseUrl+ "api/users/{pageNumber}");
        response.then().log().all()
                .assertThat()
                .statusCode(200)
                .body("name", Matchers.equalTo("Ritu"), "job",
                        Matchers.equalTo("Jr.SQA"),
                        "updatedAt",Matchers.notNullValue());




    }



}
