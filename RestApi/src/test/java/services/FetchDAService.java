package services;


import io.restassured.response.Response;

public class FetchDAService{

    private static final String JPATH_TO_FIRST_DISPLAY_PRODUCTS = "$.displayArticles[0]";

    private static final String[] ELEMENTS_IN_DISPLAY_PRODUCTS = {"productNumber","articleCode","name","primaryImage","webUrl","availableSwatches","trackingInfo","priceInfo"};

    public boolean doDisplayProductFieldsExist(Response res) {
        return ElementHelper.getInstance(res).in(JPATH_TO_FIRST_DISPLAY_PRODUCTS).doElementsExist(ELEMENTS_IN_DISPLAY_PRODUCTS);
    }





}
