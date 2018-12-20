package services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.path.json.JsonPath;
import testPackage.BaseClass;

import java.util.List;

public class ElementHelper {
    BaseClass baseClass = new BaseClass();
    JsonPath jsonPath;
    String response;

    public ElementHelper(String res) {
        response = res;
    }

    public static ElementHelper getInstance(String res){
        return new ElementHelper(res);
    }

    public ElementHelper inGson(String jpath){
        jsonPath = baseClass.getJsonPathString(response);
        Object o = jsonPath.getJsonObject(jpath);
        Gson gson = new GsonBuilder().serializeNulls().create();
        String json = gson.toJson(o);
        return new ElementHelper(json);
    }
    public ElementHelper inJackson(String jpath) throws JsonProcessingException {
        jsonPath = baseClass.getJsonPathString(response);
        Object o = jsonPath.getJsonObject(jpath);
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(o);
        return new ElementHelper(json);
    }



    public boolean doElementExist(String phrase) {
        return response.contains("\""+phrase+"\"");
    }


    public boolean doElementsExist(String... elements){
        for (String element : elements) {
            if(!doElementExist(element)){
                return false;
            }
        }
        return true;
    }
}
