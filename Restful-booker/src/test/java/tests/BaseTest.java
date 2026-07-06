package tests;

import com.rajcic.builder.RequestBuilder;
import com.rajcic.classes.request.Credentials;
import com.rajcic.config.ConfigReader;
import constants.BaseTestConstants;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.testng.annotations.BeforeSuite;


public class BaseTest {

    protected static String token;

    @BeforeSuite
    public void restAssuredSetUp(){
        RestAssured.baseURI = ConfigReader.get("base_uri");
        token = getToken();
    }



    private String getToken() {

        Credentials c = new Credentials(ConfigReader.get("username"), ConfigReader.get("password"));
        Response r = RequestBuilder.auth(BaseTestConstants.AUTH_PATH, c);

        return r.jsonPath().getString("token");
    }
}
