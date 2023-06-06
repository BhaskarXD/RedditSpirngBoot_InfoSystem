
package com.springapiproj.redditinfosystem.pojo.redditposts;

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
    "after",
    "dist",
    "modhash",
    "geo_filter",
    "children",
    "before"
})
//@Generated("jsonschema2pojo")
public class Data {

    @JsonProperty("after")
    private Object after;
    @JsonProperty("dist")
    private Integer dist;
    @JsonProperty("modhash")
    private Object modhash;
    @JsonProperty("geo_filter")
    private String geoFilter;
    @JsonProperty("children")
    private List<Child> children;
    @JsonProperty("before")
    private Object before;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("after")
    public Object getAfter() {
        return after;
    }

    @JsonProperty("after")
    public void setAfter(Object after) {
        this.after = after;
    }

    @JsonProperty("dist")
    public Integer getDist() {
        return dist;
    }

    @JsonProperty("dist")
    public void setDist(Integer dist) {
        this.dist = dist;
    }

    @JsonProperty("modhash")
    public Object getModhash() {
        return modhash;
    }

    @JsonProperty("modhash")
    public void setModhash(Object modhash) {
        this.modhash = modhash;
    }

    @JsonProperty("geo_filter")
    public String getGeoFilter() {
        return geoFilter;
    }

    @JsonProperty("geo_filter")
    public void setGeoFilter(String geoFilter) {
        this.geoFilter = geoFilter;
    }

    @JsonProperty("children")
    public List<Child> getChildren() {
        return children;
    }

    @JsonProperty("children")
    public void setChildren(List<Child> children) {
        this.children = children;
    }

    @JsonProperty("before")
    public Object getBefore() {
        return before;
    }

    @JsonProperty("before")
    public void setBefore(Object before) {
        this.before = before;
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
