
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
    "markerType",
    "markerImageUrl",
    "markerText",
    "markerDescription"
})
public class PromoMarker {

    @JsonProperty("markerType")
    private String markerType;
    @JsonProperty("markerImageUrl")
    private String markerImageUrl;
    @JsonProperty("markerText")
    private String markerText;
    @JsonProperty("markerDescription")
    private String markerDescription;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("markerType")
    public String getMarkerType() {
        return markerType;
    }

    @JsonProperty("markerType")
    public void setMarkerType(String markerType) {
        this.markerType = markerType;
    }

    @JsonProperty("markerImageUrl")
    public String getMarkerImageUrl() {
        return markerImageUrl;
    }

    @JsonProperty("markerImageUrl")
    public void setMarkerImageUrl(String markerImageUrl) {
        this.markerImageUrl = markerImageUrl;
    }

    @JsonProperty("markerText")
    public String getMarkerText() {
        return markerText;
    }

    @JsonProperty("markerText")
    public void setMarkerText(String markerText) {
        this.markerText = markerText;
    }

    @JsonProperty("markerDescription")
    public String getMarkerDescription() {
        return markerDescription;
    }

    @JsonProperty("markerDescription")
    public void setMarkerDescription(String markerDescription) {
        this.markerDescription = markerDescription;
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
