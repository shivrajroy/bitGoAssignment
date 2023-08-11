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
        RequestSpecification request = RestAssured.given().relaxedHTTPSValidation();
        RequestSpecification request1 = RestAssured.given().relaxedHTTPSValidation();

        request.header("Content-Type", "application/json");
        request.header("accept","application/json");

        Response response;

        response = request.get("api/block-height/680000");

        ResponseBody body = response.getBody();

        String blockHash = body.asString();
        System.out.println(blockHash);

        APITestData data = new APITestData();
        data.setBlockHash(blockHash);
        System.out.println("Block hash is " + data.getBlockHash());

        Response response1;
        response1 = request1.get("/api/block/" + blockHash);

        request1.header("Content-Type", "application/json");
        request1.header("accept","application/json");
        ResponseBody body1 = response1.getBody();

        String s2 = body1.asString();
        System.out.println(s2);

        System.out.println(response1.getBody().jsonPath().get("tx_count").toString());
        String count = response1.getBody().jsonPath().get("tx_count").toString();

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
