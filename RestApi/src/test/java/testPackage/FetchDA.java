package testPackage;

import Utilities.Constants;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidatorSettings;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.FetchDAService;
import rest.verification.YAMLUtilsConfigDefault;
import rest.verification.YAMLUtilsResult;
import rest.verification.YAMLUtilsVerifierDefault;
import testPackage.BaseClass;
import testPackage.Endpoints;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;
import static io.restassured.config.DecoderConfig.decoderConfig;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class FetchDA extends BaseClass {
    RequestSpecification reqSpec;
    ResponseSpecification resSpec;
    Map<String, String> parameter;
    YAMLUtilsResult result;
    String productNumber;
    JsonSchemaValidatorSettings JsonSchemaValidator;
    JsonPath jsonPath;
    Response res;
    FetchDAService fetchDAService = new FetchDAService();

    private static final String JSON_PATH_DISPLAY_ARTICLES = "displayArticles";
    private static final String JSON_PATH_DISPLAY_ARTICLES_ARRAY = "displayArticles[{number}]";

    @BeforeMethod
    public void setUp() {
        parameter = new HashMap<String, String>();
        RestAssured.config = config().decoderConfig(decoderConfig().useNoWrapForInflateDecoding(true));
        reqSpec = getRequestSpecification();
        reqSpec.basePath(Path.BASE_PATH);
        reqSpec.queryParam("productNumbers", "54690");
        resSpec = getResponseSpecification();
      //  JsonSchemaValidator = jsonSchemaSettings();
    }

    //@AfterMethod
    public void tearDown() {
        resetSchemaSettings();
    }

    @Test
    public void getFetchDA() {
        parameter.put("deviceType", "desktop");
        parameter.put("includeCategory", "false");
        given()
                .config(config)
                .spec(createQueryParam(reqSpec, parameter))
                .header("content-type", "application/json")
                .when()
                .get(Endpoints.FETCHDA_API)
                .then()
                .log().all()
                .spec(resSpec)
                .body("displayArticles[8].productNumber", equalTo("92405"));
    }
    @Test
    public void getFetchDASchemaValidation() {
        parameter.put("deviceType", "desktop");
        parameter.put("includeCategory", "false");
        given()
                .config(config)
                .spec(createQueryParam(reqSpec, parameter))
                .header("content-type", "application/json")
                .when()
                .get(Endpoints.FETCHDA_API)
                .then()
                .log().all()
                .spec(resSpec)
                .assertThat()
                .body(matchesJsonSchemaInClasspath("FetchDA.json"));
    }


    @Test
    public void getFetchDA1() {
        parameter.put("deviceType", "desktop");
        parameter.put("includeCategory", "false");
        setEndPoint(Endpoints.FETCHDA_API);
        res = getResponse(createQueryParam(reqSpec, parameter), "get");
        jsonPath = getJsonPath(res);
        String product = jsonPath.get("displayArticles[0].productNumber");
        String test = jsonPath.getString("displayArticles[10].productNumber");
    //    jsonPath.get();
        System.out.println("---------this is list of articles---- "+test);
        Assert.assertEquals(product, "92405");
    }


    @Test
    public void getFetchDA2() throws JsonProcessingException {
        parameter.put("deviceType", "desktop");
        parameter.put("includeCategory", "false");
        setEndPoint(Endpoints.FETCHDA_API);
        res = getResponse(createQueryParam(reqSpec, parameter), "get");
        jsonPath = getJsonPath(res);
        String response = res.asString();
        jsonPath.setRoot("displayArticles[0]");
        String product = jsonPath.get("productNumber");
        List test = jsonPath.getList("sizes.stockSize");
        String product1 =jsonPath.and().getString("productNumber");
        boolean product2 =jsonPath.getBoolean("priceInfo.onSale");
        double product3 =jsonPath.getDouble("priceInfo.price");
        //System.out.println(jsonPath.getJsonObject("displayArticles[0]"));
        //    jsonPath.get();
        System.out.println("---------this is list of articles---- "+product3);
       // Assert.assertEquals(test,hasItem(050));
        boolean present = fetchDAService.doDisplayProductFieldsExist(response);
        Assert.assertTrue(present);
        boolean present1 = fetchDAService.doDisplayProductFieldsExist1(response);
        Assert.assertTrue(present1);
        boolean present2 = fetchDAService.doAvailableSizeInfoExist(response);
        Assert.assertTrue(present2);
    }

    @Test
    public void getFetchDA3() {
        parameter.put("deviceType", "desktop");
        parameter.put("includeCategory", "false");
        setEndPoint(Endpoints.FETCHDA_API);
        res = getResponse(createQueryParam(reqSpec, parameter), "get");
        jsonPath = getJsonPath(res);
        String displayArticles = jsonPath.get("displayArticles").toString();
        String[] splitedDisplayArticles = displayArticles.split("availableSwatches");
        int totalDisplayArticles = splitedDisplayArticles.length;
        for(int i=0;i<totalDisplayArticles-1;i++) {
            jsonPath.setRoot(JSON_PATH_DISPLAY_ARTICLES_ARRAY.replace("{number}", Integer.toString(i)));
            String product = jsonPath.get("productNumber");
            Assert.assertEquals(product, "54690");
      /*      List test = jsonPath.getList("sizes.stockSize");
            String product1 = jsonPath.and().getString("productNumber");
            boolean product2 = jsonPath.getBoolean("priceInfo.onSale");
            double product3 = jsonPath.getDouble("priceInfo.price");*/
        }
    }

    @Test
    public void getFetchDASchemaValidation1() {
        parameter.put("deviceType", "desktop");
        parameter.put("includeCategory", "false");
        setEndPoint(Endpoints.FETCHDA_API);
        res = getResponse(createQueryParam(reqSpec, parameter), "get");
        String json = res.body().prettyPrint();
        assertThat(json, matchesJsonSchemaInClasspath("FetchDA.json"));
    }

    @Test
    public void getFetchDASchemaValidationUsingYAML() throws Throwable{
        parameter.put("deviceType", "desktop");
        parameter.put("includeCategory", "false");
        setEndPoint(Endpoints.FETCHDA_API);
        Response res = getResponse(createQueryParam(reqSpec, parameter), "get");
        String json = res.body().prettyPrint();
        YAMLUtilsConfigDefault config = new YAMLUtilsConfigDefault(Constants.FETCH_DA_YAML);
        config.setMap("productNumber", productNumber);
        result = new YAMLUtilsVerifierDefault().verifyYaml(config, getJSONObject(res));
        Assert.assertTrue(result.getResult(), result.getMessage());
    }

}
