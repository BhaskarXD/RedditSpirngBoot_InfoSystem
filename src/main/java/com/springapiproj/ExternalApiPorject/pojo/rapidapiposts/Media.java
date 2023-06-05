
package com.springapiproj.ExternalApiPorject.pojo.rapidapiposts; ;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
//import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "obfuscated",
    "content",
    "type",
    "width",
    "height",
    "resolutions",
    "richtextContent",
    "rteMode",
    "mediaMetadata"
})
//@Generated("jsonschema2pojo")
public class Media {

    @JsonProperty("obfuscated")
    private Object obfuscated;
    @JsonProperty("content")
    private String content;
    @JsonProperty("type")
    private String type;
    @JsonProperty("width")
    private Integer width;
    @JsonProperty("height")
    private Integer height;
    @JsonProperty("resolutions")
    private List<Resolution> resolutions;
    @JsonProperty("richtextContent")
    private RichtextContent richtextContent;
    @JsonProperty("rteMode")
    private String rteMode;
    @JsonProperty("mediaMetadata")
    private Object mediaMetadata;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("obfuscated")
    public Object getObfuscated() {
        return obfuscated;
    }

    @JsonProperty("obfuscated")
    public void setObfuscated(Object obfuscated) {
        this.obfuscated = obfuscated;
    }

    @JsonProperty("content")
    public String getContent() {
        return content;
    }

    @JsonProperty("content")
    public void setContent(String content) {
        this.content = content;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("width")
    public Integer getWidth() {
        return width;
    }

    @JsonProperty("width")
    public void setWidth(Integer width) {
        this.width = width;
    }

    @JsonProperty("height")
    public Integer getHeight() {
        return height;
    }

    @JsonProperty("height")
    public void setHeight(Integer height) {
        this.height = height;
    }

    @JsonProperty("resolutions")
    public List<Resolution> getResolutions() {
        return resolutions;
    }

    @JsonProperty("resolutions")
    public void setResolutions(List<Resolution> resolutions) {
        this.resolutions = resolutions;
    }

    @JsonProperty("richtextContent")
    public RichtextContent getRichtextContent() {
        return richtextContent;
    }

    @JsonProperty("richtextContent")
    public void setRichtextContent(RichtextContent richtextContent) {
        this.richtextContent = richtextContent;
    }

    @JsonProperty("rteMode")
    public String getRteMode() {
        return rteMode;
    }

    @JsonProperty("rteMode")
    public void setRteMode(String rteMode) {
        this.rteMode = rteMode;
    }

    @JsonProperty("mediaMetadata")
    public Object getMediaMetadata() {
        return mediaMetadata;
    }

    @JsonProperty("mediaMetadata")
    public void setMediaMetadata(Object mediaMetadata) {
        this.mediaMetadata = mediaMetadata;
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
