package testPackage;

import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.module.jsv.JsonSchemaValidatorSettings;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.github.fge.jsonschema.SchemaVersion.DRAFTV4;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidatorSettings.settings;
import static org.hamcrest.Matchers.lessThan;

public class BaseClass {

    public static String ENDPOINT;
    public static RequestSpecBuilder REQUEST_BUILDER;
    public static RequestSpecification REQUEST_SPEC;
    public static ResponseSpecBuilder RESPONSE_BUILDER;
    public static ResponseSpecification RESPONSE_SPEC;


    public static void setEndPoint(String epoint) {
        ENDPOINT = epoint;
    }

    public JsonSchemaValidatorSettings jsonSchemaSettings(){
        JsonSchemaFactory jsonSchemaFactory1 = JsonSchemaFactory.newBuilder().setValidationConfiguration(ValidationConfiguration.newBuilder().setDefaultVersion(DRAFTV4).freeze()).freeze();
        JsonSchemaValidator.settings = settings().with().jsonSchemaFactory(jsonSchemaFactory1).and().with().checkedValidation(true);
        return JsonSchemaValidator.settings;
    }

    public void resetSchemaSettings(){
        JsonSchemaValidator.reset();
    }

    public RequestSpecification getRequestSpecification(){
        REQUEST_BUILDER = new RequestSpecBuilder();
        REQUEST_BUILDER.setBaseUri(Path.BASE_URI);
        REQUEST_SPEC = REQUEST_BUILDER.build();
        return REQUEST_SPEC;
    }

    public ResponseSpecification getResponseSpecification(){
        RESPONSE_BUILDER = new ResponseSpecBuilder();
        RESPONSE_BUILDER.expectStatusCode(200);
        RESPONSE_SPEC = RESPONSE_BUILDER.build();
        RESPONSE_BUILDER.expectResponseTime(lessThan(30L), TimeUnit.SECONDS);
        return RESPONSE_SPEC;
    }

    public static RequestSpecification createQueryParam(RequestSpecification rspec,
                                                        String param, String value) {
        return rspec.queryParam(param, value);
    }

    public static RequestSpecification createQueryParam(RequestSpecification rspec,
                                                        Map<String, String> queryMap) {
        return rspec.queryParams(queryMap);
    }

    public static RequestSpecification createPathParam(RequestSpecification rspec,
                                                       String param, String value) {
        return rspec.pathParam(param, value);
    }

    public static Response getResponse() {
        return given().get(ENDPOINT);
    }

    public static Response getResponse(RequestSpecification reqSpec, String type) {
        REQUEST_SPEC.spec(reqSpec);
        Response response = null;
        if (type.equalsIgnoreCase("get")) {
            response = given().spec(REQUEST_SPEC).get(ENDPOINT);
        } else if (type.equalsIgnoreCase("post")) {
            response = given().spec(REQUEST_SPEC).post(ENDPOINT);
        } else if (type.equalsIgnoreCase("put")) {
            response = given().spec(REQUEST_SPEC).put(ENDPOINT);
        } else if (type.equalsIgnoreCase("delete")) {
            response = given().spec(REQUEST_SPEC).delete(ENDPOINT);
        } else {
            System.out.println("Type is not supported");
        }
        response.then().log().ifError();
        response.then().spec(RESPONSE_SPEC).extract().response();
        System.out.println(response);
        return response;
    }

    public static void extractResponse(){
   //     given().then().
    }

    public static JsonPath getJsonPath(Response res) {
        String path = res.asString();
        return new JsonPath(path);
    }

    public static JsonPath getJsonPathString(String res) {
        return new JsonPath(res);
    }

    public static XmlPath getXmlPath(Response res) {
        String path = res.asString();
        return new XmlPath(path);
    }

    public static void resetBathPath() {
        RestAssured.basePath = null;
    }

    public static void setContentType(ContentType type) {
        given().contentType(type);
    }

    public Object getJSONObject(Response res) {
        String json = res.prettyPrint();
        return com.jayway.jsonpath.JsonPath.read(json, "$");
    }


}
