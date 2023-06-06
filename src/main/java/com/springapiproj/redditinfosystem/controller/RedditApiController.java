package com.springapiproj.redditinfosystem.controller;

import com.springapiproj.redditinfosystem.pojo.redditposts.PostData;
import com.springapiproj.redditinfosystem.service.RedditApiService;
import com.springapiproj.redditinfosystem.service.RedditMongodbService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spring/api")
public class RedditApiController {

    private final RedditApiService redditApiService;
    private final RedditMongodbService redditMongodbService;

    public RedditApiController(RedditApiService redditApiService, RedditMongodbService redditMongodbService) {
        this.redditApiService = redditApiService;
        this.redditMongodbService = redditMongodbService;
    }

    //-------------------------- methods that interact with the api ----------------------------------------------------

    @GetMapping("/posts/rising")
    public ResponseEntity<List<PostData>> apiGetRisingPosts(){
        return redditApiService.apiFindRisingPosts();

    }
    @GetMapping("/posts/username/{username}")
    public ResponseEntity<List<PostData>> apiGetPostsByUsername(@PathVariable String username){
        return redditApiService.apiFindPostByUsername(username);
    }
    @GetMapping("/posts/subreddit/{subreddit}")
    public ResponseEntity<List<PostData>> apiGetTopPostsBySubreddit(@PathVariable String subreddit){
        return redditApiService.apiFindTopPostsBySubreddit(subreddit);
    }

    @PostMapping("/posts/username")
    public List<PostData> savePostsByUsername(@RequestBody String username){
        return redditMongodbService.mongodbSavePostsByUsername(username);
    }

    @PostMapping("/posts/subreddit")
    public List<PostData> saveTopPostsBySubreddit(@RequestBody String subreddit){
        return redditMongodbService.mongodbSaveTopPostsBySubreddit(subreddit);
    }

}


