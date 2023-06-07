package com.springapiproj.redditinfosystem.service;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.springapiproj.redditinfosystem.pojo.redditposts.PostData;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomMappingJacksonValue {
    public MappingJacksonValue getCustomMappedObjects(List<PostData> postData){
        MappingJacksonValue mappingJacksonValue= new MappingJacksonValue(postData);
        PropertyFilter filter= SimpleBeanPropertyFilter.filterOutAllExcept("subreddit","selftext","title","created","author");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SimplePostDataFilter",filter);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }
}