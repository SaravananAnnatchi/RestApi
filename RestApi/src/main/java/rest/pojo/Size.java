
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
    "stockSize",
    "sizeName",
    "stockState",
    "sizeRowId",
    "sdsSizeCode"
})
public class Size {

    @JsonProperty("stockSize")
    private String stockSize;
    @JsonProperty("sizeName")
    private String sizeName;
    @JsonProperty("stockState")
    private String stockState;
    @JsonProperty("sizeRowId")
    private String sizeRowId;
    @JsonProperty("sdsSizeCode")
    private String sdsSizeCode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("stockSize")
    public String getStockSize() {
        return stockSize;
    }

    @JsonProperty("stockSize")
    public void setStockSize(String stockSize) {
        this.stockSize = stockSize;
    }

    @JsonProperty("sizeName")
    public String getSizeName() {
        return sizeName;
    }

    @JsonProperty("sizeName")
    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    @JsonProperty("stockState")
    public String getStockState() {
        return stockState;
    }

    @JsonProperty("stockState")
    public void setStockState(String stockState) {
        this.stockState = stockState;
    }

    @JsonProperty("sizeRowId")
    public String getSizeRowId() {
        return sizeRowId;
    }

    @JsonProperty("sizeRowId")
    public void setSizeRowId(String sizeRowId) {
        this.sizeRowId = sizeRowId;
    }

    @JsonProperty("sdsSizeCode")
    public String getSdsSizeCode() {
        return sdsSizeCode;
    }

    @JsonProperty("sdsSizeCode")
    public void setSdsSizeCode(String sdsSizeCode) {
        this.sdsSizeCode = sdsSizeCode;
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
