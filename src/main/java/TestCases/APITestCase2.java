package TestCases;

import TestData.APITestData;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class APITestCase2 {

    public void SendRequest() {

        System.out.println("Test case 2");

        RestAssured.baseURI = "https://blockstream.info/";

        RequestSpecification request = RestAssured.given().relaxedHTTPSValidation();
        RequestSpecification request1 = RestAssured.given().relaxedHTTPSValidation();
        RequestSpecification request2 = RestAssured.given().relaxedHTTPSValidation();
        RequestSpecification request3 = RestAssured.given().relaxedHTTPSValidation();

        APITestData data = new APITestData();

        request.header("Content-Type", "application/json");
        request.header("accept","application/json");

        request1.header("Content-Type", "application/json");
        request1.header("accept","application/json");

        request2.header("Content-Type", "application/json");
        request2.header("accept","application/json");

        Response response;
        Response response1;
        Response response2;
        Response response3;

        response = request.get("api/block-height/680000");


        ResponseBody body = response.getBody();

        String blockHash = body.asString();
        System.out.println("block hash is" + blockHash);

        response1= request1.get("/api/block/" + blockHash + "/txid/100");
        System.out.println("response for 100 is");

        ResponseBody body1 = response1.getBody();

        String s2 = body1.asString();
        System.out.println(s2);

        response2 = request2.get("api/tx/" + s2);
        System.out.println(response2.getBody().asString());
        response2.

       // for ()





    }
}
