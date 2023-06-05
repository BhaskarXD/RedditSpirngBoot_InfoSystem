package com.springapiproj.ExternalApiPorject.controller;

import com.springapiproj.ExternalApiPorject.pojo.redditposts.Data__1;
import com.springapiproj.ExternalApiPorject.service.RedditAsyncService;
import com.springapiproj.ExternalApiPorject.service.RedditService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/spring")
public class RedditApiController{
    private final RedditAsyncService redditAsyncService;
    private final RedditService redditService;

    public RedditApiController(RedditAsyncService redditAsyncService, RedditService redditService) {
        this.redditAsyncService = redditAsyncService;
        this.redditService = redditService;
    }

    //--------------------- Testing actual reddit api call ----------------------------------------------------
    @GetMapping("/reddit")
    public ResponseEntity<String> getReddit(){
        return redditService.getReddit();
    }

    @GetMapping("/reddit/myposts")
    public List<Data__1> getMyPosts(){
        return redditAsyncService.getMyPosts();
    }
}