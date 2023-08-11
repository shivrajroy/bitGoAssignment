package TestCases;

import TestData.APITestData;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import java.util.ArrayList;

public class APITestCase2 {

    public void SendRequest() {

        System.out.println();
        System.out.println("Test case 2");

        RestAssured.baseURI = "https://blockstream.info/";

        RequestSpecification getBlockHashRequest = RestAssured.given().relaxedHTTPSValidation();
        RequestSpecification getIndividualIdRequest = RestAssured.given().relaxedHTTPSValidation();
        RequestSpecification ReuestFor100_200_300 = RestAssured.given().relaxedHTTPSValidation();

        getBlockHashRequest.header("Content-Type", "application/json");
        getBlockHashRequest.header("accept","application/json");

        getIndividualIdRequest.header("Content-Type", "application/json");
        getIndividualIdRequest.header("accept","application/json");

        ReuestFor100_200_300.header("Content-Type", "application/json");
        ReuestFor100_200_300.header("accept","application/json");

        Response getBlockHashResponse;
        Response getIndividualIdResponse;
        Response responseFor100;
        Response responseFor200;
        Response responseFor300;

        getBlockHashResponse = getBlockHashRequest.get("api/block-height/680000");


        ResponseBody body = getBlockHashResponse.getBody();

        String blockHash = body.asString();

        getIndividualIdResponse= getIndividualIdRequest.get("/api/block/" + blockHash + "/txid/100");

        ResponseBody body1 = getIndividualIdResponse.getBody();

        String idFor100 = body1.asString();

        getIndividualIdResponse= getIndividualIdRequest.get("/api/block/" + blockHash + "/txid/200");
        body1 = getIndividualIdResponse.getBody();

        String idFor200 = body1.asString();

        getIndividualIdResponse= getIndividualIdRequest.get("/api/block/" + blockHash + "/txid/300");
        body1 = getIndividualIdResponse.getBody();

        String idFor300 = body1.asString();

        responseFor100 = ReuestFor100_200_300.get("api/tx/" + idFor100);
        responseFor200 = ReuestFor100_200_300.get("api/tx/" + idFor200);
        responseFor300 = ReuestFor100_200_300.get("api/tx/" + idFor300);


        ArrayList<String> countVinfor100 = responseFor100.getBody().jsonPath().get("vin");
        ArrayList<String> countVoutfor100 = responseFor100.getBody().jsonPath().get("vout");

        ArrayList<String> countVinfor200 = responseFor200.getBody().jsonPath().get("vin");
        ArrayList<String> countVoutfor200 = responseFor200.getBody().jsonPath().get("vout");

        ArrayList<String> countVinfor300 = responseFor300.getBody().jsonPath().get("vin");
        ArrayList<String> countVoutfor300 = responseFor300.getBody().jsonPath().get("vout");

        int totalVinCount= countVinfor100.size() + countVinfor200.size() + countVinfor300.size();
        int totalVoutCount = countVoutfor100.size() + countVoutfor200.size() + countVoutfor300.size();

        System.out.println("Total input Count is " + totalVinCount);
        System.out.println("Total output Count is " + totalVoutCount);

        if (totalVoutCount==4 && totalVinCount==5)
        {
            System.out.println("Test Case 2 Passed");
        }
        else
        {
            System.out.println("Test Case 2 Failed");
        }

    }
}
