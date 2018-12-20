package services;


import com.fasterxml.jackson.core.JsonProcessingException;
import testPackage.BaseClass;

public class FetchDAService extends BaseClass {

    private static final String JPATH_TO_FIRST_DISPLAY_PRODUCTS = "displayArticles[0]";
    private static final String JPATH_TO_AVAILABLESIZEINFO = "displayArticles[0].availableSizeInfo";

    private static final String[] ELEMENTS_IN_DISPLAY_PRODUCTS = {"productNumber","articleCode","name","primaryImage","webUrl","availableSwatches","trackingInfo","priceInfo"};
    private static final String[] ELEMENTS_IN_AVAILABLESIZEINFO = {"stockSize","sizeName"};

    public boolean doDisplayProductFieldsExist(String res) {
        return ElementHelper.getInstance(res).inGson(JPATH_TO_FIRST_DISPLAY_PRODUCTS).doElementsExist(ELEMENTS_IN_DISPLAY_PRODUCTS);
    }

    public boolean doDisplayProductFieldsExist1(String res) throws JsonProcessingException {
        return ElementHelper.getInstance(res).inJackson(JPATH_TO_FIRST_DISPLAY_PRODUCTS).doElementsExist(ELEMENTS_IN_DISPLAY_PRODUCTS);
    }

    public boolean doAvailableSizeInfoExist(String res) {
        return ElementHelper.getInstance(res).doElementsExist(ELEMENTS_IN_AVAILABLESIZEINFO);
    }





}
