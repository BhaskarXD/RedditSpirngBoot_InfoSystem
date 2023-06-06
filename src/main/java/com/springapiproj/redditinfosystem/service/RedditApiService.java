package com.springapiproj.redditinfosystem.service;

import com.springapiproj.redditinfosystem.pojo.redditposts.PostData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

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
    private final ReturnGetCallResponseEntity returnGetCallResponseEntity;

    public RedditApiService(ReturnGetCallResponseEntity returnGetCallResponseEntity) {
        this.returnGetCallResponseEntity = returnGetCallResponseEntity;
    }

    //-------------------------- methods to interact with reddit api --------------------------------------

    public ResponseEntity<List<PostData>> apiFindRisingPosts(){

        try {
            return returnGetCallResponseEntity.getResponseEntity(risingPopularPostsUrl);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<PostData>> apiFindPostByUsername(String username){
        try{
            String userPostsUrl=byUsernameUrl+username+jsonResponseUrlSuffix;
            return returnGetCallResponseEntity.getResponseEntity(userPostsUrl);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<PostData>> apiFindTopPostsBySubreddit(String subreddit){
        try{
            String topPostSubreddit=topPostsBySubreddit+subreddit+topResponseUrlSuffix+jsonResponseUrlSuffix;
            return returnGetCallResponseEntity.getResponseEntity(topPostSubreddit);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
