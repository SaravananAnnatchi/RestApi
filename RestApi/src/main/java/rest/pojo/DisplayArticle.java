
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
    "productNumber",
    "castorProductNumber",
    "castorArticleNumber",
    "articleCode",
    "name",
    "availableSizeInfo",
    "primaryImage",
    "webUrl",
    "availableSwatches",
    "trackingInfo",
    "additionalImages",
    "textualMarkers",
    "promoMarker",
    "priceInfo",
    "stockState",
    "assortmentState",
    "colourDescription",
    "activityArticleNumber",
    "sizes"
})
public class DisplayArticle {

    @JsonProperty("productNumber")
    private String productNumber;
    @JsonProperty("castorProductNumber")
    private String castorProductNumber;
    @JsonProperty("castorArticleNumber")
    private String castorArticleNumber;
    @JsonProperty("articleCode")
    private String articleCode;
    @JsonProperty("name")
    private String name;
    @JsonProperty("availableSizeInfo")
    private List<AvailableSizeInfo> availableSizeInfo = null;
    @JsonProperty("primaryImage")
    private PrimaryImage primaryImage;
    @JsonProperty("webUrl")
    private String webUrl;
    @JsonProperty("availableSwatches")
    private List<AvailableSwatch> availableSwatches = null;
    @JsonProperty("trackingInfo")
    private TrackingInfo trackingInfo;
    @JsonProperty("additionalImages")
    private List<Object> additionalImages = null;
    @JsonProperty("textualMarkers")
    private List<Object> textualMarkers = null;
    @JsonProperty("promoMarker")
    private PromoMarker promoMarker;
    @JsonProperty("priceInfo")
    private PriceInfo priceInfo;
    @JsonProperty("stockState")
    private String stockState;
    @JsonProperty("assortmentState")
    private String assortmentState;
    @JsonProperty("colourDescription")
    private String colourDescription;
    @JsonProperty("activityArticleNumber")
    private String activityArticleNumber;
    @JsonProperty("sizes")
    private List<Size> sizes = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("productNumber")
    public String getProductNumber() {
        return productNumber;
    }

    @JsonProperty("productNumber")
    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    @JsonProperty("castorProductNumber")
    public String getCastorProductNumber() {
        return castorProductNumber;
    }

    @JsonProperty("castorProductNumber")
    public void setCastorProductNumber(String castorProductNumber) {
        this.castorProductNumber = castorProductNumber;
    }

    @JsonProperty("castorArticleNumber")
    public String getCastorArticleNumber() {
        return castorArticleNumber;
    }

    @JsonProperty("castorArticleNumber")
    public void setCastorArticleNumber(String castorArticleNumber) {
        this.castorArticleNumber = castorArticleNumber;
    }

    @JsonProperty("articleCode")
    public String getArticleCode() {
        return articleCode;
    }

    @JsonProperty("articleCode")
    public void setArticleCode(String articleCode) {
        this.articleCode = articleCode;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("availableSizeInfo")
    public List<AvailableSizeInfo> getAvailableSizeInfo() {
        return availableSizeInfo;
    }

    @JsonProperty("availableSizeInfo")
    public void setAvailableSizeInfo(List<AvailableSizeInfo> availableSizeInfo) {
        this.availableSizeInfo = availableSizeInfo;
    }

    @JsonProperty("primaryImage")
    public PrimaryImage getPrimaryImage() {
        return primaryImage;
    }

    @JsonProperty("primaryImage")
    public void setPrimaryImage(PrimaryImage primaryImage) {
        this.primaryImage = primaryImage;
    }

    @JsonProperty("webUrl")
    public String getWebUrl() {
        return webUrl;
    }

    @JsonProperty("webUrl")
    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    @JsonProperty("availableSwatches")
    public List<AvailableSwatch> getAvailableSwatches() {
        return availableSwatches;
    }

    @JsonProperty("availableSwatches")
    public void setAvailableSwatches(List<AvailableSwatch> availableSwatches) {
        this.availableSwatches = availableSwatches;
    }

    @JsonProperty("trackingInfo")
    public TrackingInfo getTrackingInfo() {
        return trackingInfo;
    }

    @JsonProperty("trackingInfo")
    public void setTrackingInfo(TrackingInfo trackingInfo) {
        this.trackingInfo = trackingInfo;
    }

    @JsonProperty("additionalImages")
    public List<Object> getAdditionalImages() {
        return additionalImages;
    }

    @JsonProperty("additionalImages")
    public void setAdditionalImages(List<Object> additionalImages) {
        this.additionalImages = additionalImages;
    }

    @JsonProperty("textualMarkers")
    public List<Object> getTextualMarkers() {
        return textualMarkers;
    }

    @JsonProperty("textualMarkers")
    public void setTextualMarkers(List<Object> textualMarkers) {
        this.textualMarkers = textualMarkers;
    }

    @JsonProperty("promoMarker")
    public PromoMarker getPromoMarker() {
        return promoMarker;
    }

    @JsonProperty("promoMarker")
    public void setPromoMarker(PromoMarker promoMarker) {
        this.promoMarker = promoMarker;
    }

    @JsonProperty("priceInfo")
    public PriceInfo getPriceInfo() {
        return priceInfo;
    }

    @JsonProperty("priceInfo")
    public void setPriceInfo(PriceInfo priceInfo) {
        this.priceInfo = priceInfo;
    }

    @JsonProperty("stockState")
    public String getStockState() {
        return stockState;
    }

    @JsonProperty("stockState")
    public void setStockState(String stockState) {
        this.stockState = stockState;
    }

    @JsonProperty("assortmentState")
    public String getAssortmentState() {
        return assortmentState;
    }

    @JsonProperty("assortmentState")
    public void setAssortmentState(String assortmentState) {
        this.assortmentState = assortmentState;
    }

    @JsonProperty("colourDescription")
    public String getColourDescription() {
        return colourDescription;
    }

    @JsonProperty("colourDescription")
    public void setColourDescription(String colourDescription) {
        this.colourDescription = colourDescription;
    }

    @JsonProperty("activityArticleNumber")
    public String getActivityArticleNumber() {
        return activityArticleNumber;
    }

    @JsonProperty("activityArticleNumber")
    public void setActivityArticleNumber(String activityArticleNumber) {
        this.activityArticleNumber = activityArticleNumber;
    }

    @JsonProperty("sizes")
    public List<Size> getSizes() {
        return sizes;
    }

    @JsonProperty("sizes")
    public void setSizes(List<Size> sizes) {
        this.sizes = sizes;
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
