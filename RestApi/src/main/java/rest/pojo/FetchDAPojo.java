
package rest.pojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "totalNrOfHits",
    "displayArticles"
})
public class FetchDAPojo {

    @JsonProperty("totalNrOfHits")
    private Integer totalNrOfHits;
    @JsonProperty("displayArticles")
    private List<DisplayArticle> displayArticles = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("totalNrOfHits")
    public Integer getTotalNrOfHits() {
        return totalNrOfHits;
    }

    @JsonProperty("totalNrOfHits")
    public void setTotalNrOfHits(Integer totalNrOfHits) {
        this.totalNrOfHits = totalNrOfHits;
    }

    @JsonProperty("displayArticles")
    public List<DisplayArticle> getDisplayArticles() {
        return displayArticles;
    }

    @JsonProperty("displayArticles")
    public void setDisplayArticles(List<DisplayArticle> displayArticles) {
        this.displayArticles = displayArticles;
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
