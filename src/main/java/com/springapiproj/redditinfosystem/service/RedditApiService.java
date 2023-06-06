package com.springapiproj.redditinfosystem.service;

import com.springapiproj.redditinfosystem.pojo.redditposts.PostData;
import com.springapiproj.redditinfosystem.pojo.redditposts.RedditJsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;


@Service
public class RedditApiService {
    @Value("${reddit.rising.posts.url}")
    private String risingPopularPostsUrl;
    @Value("${reddit.posts.by.username.url}")
    private String byUsernameUrl;
    @Value("${reddit.top.posts.by.subreddit.url}")
    private String topPostsBySubreddit;
    @Value("${reddit.response.url.suffix.json}")
    private String jsonResponseUrlSuffix;
    @Value("${reddit.response.url.suffix.top}")
    private String topResponseUrlSuffix;
    @Value("${reddit.access.token}")
    private String redditAccessToken;
    @Value("${reddit.user.agent}")
    private String redditUserAgent;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private PostDataFromJson postDataFromJson;


    //-------------------------- methods to interact with reddit api --------------------------------------

    public ResponseEntity<List<PostData>> apiFindRisingPosts(){

        try {
            HttpHeaders headers=new HttpHeaders();
            ResponseEntity<RedditJsonResponse> response=restTemplate.exchange(risingPopularPostsUrl, HttpMethod.GET, new HttpEntity<>(headers), RedditJsonResponse.class);
            List<PostData> posts=postDataFromJson.getPostData(response);
            return new ResponseEntity<>(posts,response.getStatusCode());
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    public ResponseEntity<List<PostData>> apiFindPostByUsername(String username){
        try{
            String userPostsUrl=byUsernameUrl+username+jsonResponseUrlSuffix;
            HttpHeaders headers=new HttpHeaders();
            ResponseEntity<RedditJsonResponse> response=restTemplate.exchange(userPostsUrl, HttpMethod.GET, new HttpEntity<>(headers), RedditJsonResponse.class);
            List<PostData> posts=postDataFromJson.getPostData(response);
            return new ResponseEntity<>(posts,response.getStatusCode());
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<PostData>> apiFindTopPostsBySubreddit(String subreddit){
        try{
            String topPostSubreddit=topPostsBySubreddit+subreddit+topResponseUrlSuffix+jsonResponseUrlSuffix;
            HttpHeaders headers=new HttpHeaders();
            ResponseEntity<RedditJsonResponse> response=restTemplate.exchange(topPostSubreddit, HttpMethod.GET, new HttpEntity<>(headers), RedditJsonResponse.class);
            List<PostData> posts=postDataFromJson.getPostData(response);
            return new ResponseEntity<>(posts,response.getStatusCode());
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
