
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
    "colour",
    "fabricImageResource",
    "fabricUrl",
    "articleCode",
    "castorArticleId"
})
public class AvailableSwatch {

    @JsonProperty("colour")
    private String colour;
    @JsonProperty("fabricImageResource")
    private String fabricImageResource;
    @JsonProperty("fabricUrl")
    private String fabricUrl;
    @JsonProperty("articleCode")
    private String articleCode;
    @JsonProperty("castorArticleId")
    private String castorArticleId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("colour")
    public String getColour() {
        return colour;
    }

    @JsonProperty("colour")
    public void setColour(String colour) {
        this.colour = colour;
    }

    @JsonProperty("fabricImageResource")
    public String getFabricImageResource() {
        return fabricImageResource;
    }

    @JsonProperty("fabricImageResource")
    public void setFabricImageResource(String fabricImageResource) {
        this.fabricImageResource = fabricImageResource;
    }

    @JsonProperty("fabricUrl")
    public String getFabricUrl() {
        return fabricUrl;
    }

    @JsonProperty("fabricUrl")
    public void setFabricUrl(String fabricUrl) {
        this.fabricUrl = fabricUrl;
    }

    @JsonProperty("articleCode")
    public String getArticleCode() {
        return articleCode;
    }

    @JsonProperty("articleCode")
    public void setArticleCode(String articleCode) {
        this.articleCode = articleCode;
    }

    @JsonProperty("castorArticleId")
    public String getCastorArticleId() {
        return castorArticleId;
    }

    @JsonProperty("castorArticleId")
    public void setCastorArticleId(String castorArticleId) {
        this.castorArticleId = castorArticleId;
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
