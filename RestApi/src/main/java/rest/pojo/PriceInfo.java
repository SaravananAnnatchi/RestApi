
package rest.pojo;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "formattedPrice",
    "formattedOldPrice",
    "onSale",
    "price",
    "currencyIso",
    "currencySymbol",
    "prefixCurrencySymbol",
    "suffixCurrencySymbol"
})
public class PriceInfo {

    @JsonProperty("formattedPrice")
    private String formattedPrice;
    @JsonProperty("formattedOldPrice")
    private String formattedOldPrice;
    @JsonProperty("onSale")
    private Boolean onSale;
    @JsonProperty("price")
    private Double price;
    @JsonProperty("currencyIso")
    private String currencyIso;
    @JsonProperty("currencySymbol")
    private String currencySymbol;
    @JsonProperty("prefixCurrencySymbol")
    private String prefixCurrencySymbol;
    @JsonProperty("suffixCurrencySymbol")
    private String suffixCurrencySymbol;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("formattedPrice")
    public String getFormattedPrice() {
        return formattedPrice;
    }

    @JsonProperty("formattedPrice")
    public void setFormattedPrice(String formattedPrice) {
        this.formattedPrice = formattedPrice;
    }

    @JsonProperty("formattedOldPrice")
    public String getFormattedOldPrice() {
        return formattedOldPrice;
    }

    @JsonProperty("formattedOldPrice")
    public void setFormattedOldPrice(String formattedOldPrice) {
        this.formattedOldPrice = formattedOldPrice;
    }

    @JsonProperty("onSale")
    public Boolean getOnSale() {
        return onSale;
    }

    @JsonProperty("onSale")
    public void setOnSale(Boolean onSale) {
        this.onSale = onSale;
    }

    @JsonProperty("price")
    public Double getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(Double price) {
        this.price = price;
    }

    @JsonProperty("currencyIso")
    public String getCurrencyIso() {
        return currencyIso;
    }

    @JsonProperty("currencyIso")
    public void setCurrencyIso(String currencyIso) {
        this.currencyIso = currencyIso;
    }

    @JsonProperty("currencySymbol")
    public String getCurrencySymbol() {
        return currencySymbol;
    }

    @JsonProperty("currencySymbol")
    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    @JsonProperty("prefixCurrencySymbol")
    public String getPrefixCurrencySymbol() {
        return prefixCurrencySymbol;
    }

    @JsonProperty("prefixCurrencySymbol")
    public void setPrefixCurrencySymbol(String prefixCurrencySymbol) {
        this.prefixCurrencySymbol = prefixCurrencySymbol;
    }

    @JsonProperty("suffixCurrencySymbol")
    public String getSuffixCurrencySymbol() {
        return suffixCurrencySymbol;
    }

    @JsonProperty("suffixCurrencySymbol")
    public void setSuffixCurrencySymbol(String suffixCurrencySymbol) {
        this.suffixCurrencySymbol = suffixCurrencySymbol;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
