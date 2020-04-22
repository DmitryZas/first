package pages;


import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RandomUserPage {
    private final static String URL = "https://randomuser.me/api/";
    public static String responseName;
    public static String responseLastName;

    public void makeRequest() {
        Response response = RestAssured.given().get(URL);
        responseName = response.jsonPath().getString("results[0].name.first");
        responseLastName = response.jsonPath().getString("results[0].name.last");
        System.out.println(responseName + " " + responseLastName);
    }
}
