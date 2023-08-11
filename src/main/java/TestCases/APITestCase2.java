package TestCases;

import TestData.APITestData;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import java.util.ArrayList;

public class APITestCase2 {

    public void SendRequest() {

        System.out.println("Test case 2");

        RestAssured.baseURI = "https://blockstream.info/";

        RequestSpecification request = RestAssured.given().relaxedHTTPSValidation();
        RequestSpecification request1 = RestAssured.given().relaxedHTTPSValidation();
        RequestSpecification request2 = RestAssured.given().relaxedHTTPSValidation();
        RequestSpecification request3 = RestAssured.given().relaxedHTTPSValidation();
        RequestSpecification request4 = RestAssured.given().relaxedHTTPSValidation();

        APITestData data = new APITestData();

        request.header("Content-Type", "application/json");
        request.header("accept","application/json");

        request1.header("Content-Type", "application/json");
        request1.header("accept","application/json");

        request2.header("Content-Type", "application/json");
        request2.header("accept","application/json");

        request3.header("Content-Type", "application/json");
        request3.header("accept","application/json");

        request4.header("Content-Type", "application/json");
        request4.header("accept","application/json");

        Response response;
        Response response1;
        Response response2;
        Response response3;
        Response response4;

        response = request.get("api/block-height/680000");


        ResponseBody body = response.getBody();

        String blockHash = body.asString();
        System.out.println("block hash is" + blockHash);

        response1= request1.get("/api/block/" + blockHash + "/txid/100");
        System.out.println("response for 100 is");

        ResponseBody body1 = response1.getBody();

        String s2 = body1.asString();
        System.out.println(s2);

        response1= request1.get("/api/block/" + blockHash + "/txid/200");
        body1 = response1.getBody();

        String s3 = body1.asString();
        System.out.println(s3);

        response1= request1.get("/api/block/" + blockHash + "/txid/300");
        body1 = response1.getBody();

        String s4 = body1.asString();
        System.out.println(s4);

        response2 = request2.get("api/tx/" + s2);
        System.out.println(response2.getBody().asString());

        response3 = request2.get("api/tx/" + s3);
        response4 = request2.get("api/tx/" + s4);


        ArrayList<String> countVinfor100 = response2.getBody().jsonPath().get("vin");
        ArrayList<String> countVoutfor100 = response2.getBody().jsonPath().get("vout");

        ArrayList<String> countVinfor200 = response3.getBody().jsonPath().get("vin");
        ArrayList<String> countVoutfor200 = response3.getBody().jsonPath().get("vout");

        ArrayList<String> countVinfor300 = response4.getBody().jsonPath().get("vin");
        ArrayList<String> countVoutfor300 = response4.getBody().jsonPath().get("vout");

        int totalvoutcount1 = countVoutfor100.size() + countVoutfor200.size() + countVoutfor300.size();

        int totalIncount= countVinfor100.size() + countVinfor200.size() + countVinfor300.size();

        System.out.println(totalIncount);
        System.out.println(totalvoutcount1);

        if (totalvoutcount1==4 && totalIncount==5)
        {
            System.out.println("TestCase2 Passed");
        }
        else
        {
            System.out.println("TestCase2 Failed");
        }

       // for ()





    }
}
