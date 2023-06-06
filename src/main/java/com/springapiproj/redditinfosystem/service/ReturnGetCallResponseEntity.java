package com.springapiproj.redditinfosystem.service;

import com.springapiproj.redditinfosystem.pojo.redditposts.PostData;
import com.springapiproj.redditinfosystem.pojo.redditposts.RedditJsonResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ReturnGetCallResponseEntity {
    private final RestTemplate restTemplate;
    private final PostDataFromJson postDataFromJson;

    public ReturnGetCallResponseEntity(RestTemplate restTemplate, PostDataFromJson postDataFromJson) {
        this.restTemplate = restTemplate;
        this.postDataFromJson = postDataFromJson;
    }

    public ResponseEntity<List<PostData>> getResponseEntity(String url){
        HttpHeaders headers=new HttpHeaders();
        ResponseEntity<RedditJsonResponse> response=restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), RedditJsonResponse.class);
        List<PostData> posts=postDataFromJson.getPostData(response);
        return new ResponseEntity<>(posts,response.getStatusCode());
    }
}
