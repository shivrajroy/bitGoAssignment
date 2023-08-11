package TestCases;
import TestData.APITestData;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;


public class APITestCase1 {

    public void SendRequest() {

        System.out.println("Test case 1");

        RestAssured.baseURI = "https://blockstream.info/";
        RequestSpecification getBlockHashRequest = RestAssured.given().relaxedHTTPSValidation();
        RequestSpecification transactionDetailsRequest = RestAssured.given().relaxedHTTPSValidation();

        getBlockHashRequest.header("Content-Type", "application/json");
        getBlockHashRequest.header("accept","application/json");

        Response getBlockHashResponse;

        getBlockHashResponse = getBlockHashRequest.get("api/block-height/680000");

        ResponseBody body = getBlockHashResponse.getBody();

        String blockHash = body.asString();

        APITestData data = new APITestData();
        data.setBlockHash(blockHash);

        Response transactionDetailsResponse;
        transactionDetailsResponse = transactionDetailsRequest.get("/api/block/" + blockHash);

        transactionDetailsRequest.header("Content-Type", "application/json");
        transactionDetailsRequest.header("accept","application/json");
        ResponseBody body1 = transactionDetailsResponse.getBody();

        System.out.println("Count is " + transactionDetailsResponse.getBody().jsonPath().get("tx_count").toString());
        String count = transactionDetailsResponse.getBody().jsonPath().get("tx_count").toString();

        if(count.equalsIgnoreCase("2875"))
        {
            System.out.println("Test Case 1 Passed");
        }
        else if(count.equalsIgnoreCase("2874"))
        {
            System.out.println("Test Case 1 Failed");
        }



    }


}
