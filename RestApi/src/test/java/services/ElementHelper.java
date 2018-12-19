package services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import testPackage.BaseClass;

public class ElementHelper {
    BaseClass baseClass = new BaseClass();
    JsonPath jsonPath;
    String response;

    public ElementHelper(Response res) {
        response = res.toString();
        jsonPath = baseClass.getJsonPath(res);
    }

    public static ElementHelper getInstance(Response res){
        return new ElementHelper(res);
    }

    public ElementHelper in(String jpath){
        Object o = jsonPath.getJsonObject(jpath);
        Gson gson = new GsonBuilder().serializeNulls().create();
        String json = gson.toJson(o);
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
