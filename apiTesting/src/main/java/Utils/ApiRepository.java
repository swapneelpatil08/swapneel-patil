package Utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.RestAssured;
import io.restassured.config.ConnectionConfig;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;

import java.util.concurrent.TimeUnit;

public class ApiRepository {
    @Getter
    public Response response;
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private String getJsonBody(Object body) {
        return gson.toJson(body);
    }

    private RequestSpecification request() {
        RestAssured.baseURI = "http://localhost:8080/api/v3/";
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.defaultParser = Parser.JSON;
        RestAssured.config =
                RestAssured.config().connectionConfig(ConnectionConfig.connectionConfig().closeIdleConnectionsAfterEachResponseAfter(30, TimeUnit.SECONDS));

        return RestAssured.given()
                .contentType(ContentType.JSON);
    }

    public void Get(String restURI) {
        response = request().log().ifValidationFails().when().get(restURI).then().extract().response();
    }

    public void Get(String restResources, String queryKey, String queryValue) {
        response =
                request()
                        .queryParam(queryKey, queryValue)
                        .log()
                        .ifValidationFails()
                        .when()
                        .get(restResources)
                        .then()
                        .extract()
                        .response();
    }

    public void Post(Object requestBody, String restURI) {
        String body = getJsonBody(requestBody);
        response = request().body(body).log().ifValidationFails().when().post(restURI).then().extract().response();
    }

    public void Put(Object requestBody, String restURI) {
        String body = getJsonBody(requestBody);
        response = request().body(body).log().ifValidationFails().when().put(restURI).then().extract().response();
    }

    public void Delete(String restURI) {
        response = request().log().ifValidationFails().when().delete(restURI).then().extract().response();
    }
}
