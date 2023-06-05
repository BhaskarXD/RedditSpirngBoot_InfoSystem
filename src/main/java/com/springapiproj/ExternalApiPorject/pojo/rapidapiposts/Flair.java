
package com.springapiproj.ExternalApiPorject.pojo.rapidapiposts; ;

import java.util.LinkedHashMap;
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
    "text",
    "type",
    "textColor",
    "backgroundColor",
    "templateId"
})
//@Generated("jsonschema2pojo")
public class Flair {

    @JsonProperty("text")
    private String text;
    @JsonProperty("type")
    private String type;
    @JsonProperty("textColor")
    private String textColor;
    @JsonProperty("backgroundColor")
    private String backgroundColor;
    @JsonProperty("templateId")
    private String templateId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("textColor")
    public String getTextColor() {
        return textColor;
    }

    @JsonProperty("textColor")
    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    @JsonProperty("backgroundColor")
    public String getBackgroundColor() {
        return backgroundColor;
    }

    @JsonProperty("backgroundColor")
    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    @JsonProperty("templateId")
    public String getTemplateId() {
        return templateId;
    }

    @JsonProperty("templateId")
    public void setTemplateId(String templateId) {
        this.templateId = templateId;
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
