package com.springapiproj.ExternalApiPorject.controller;

import com.springapiproj.ExternalApiPorject.pojo.rapidapiposts.Post;
import com.springapiproj.ExternalApiPorject.service.RedditService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spring")
public class ApiController {

    private final RedditService redditService;

    public ApiController(RedditService redditService) {
        this.redditService = redditService;
    }

    //-------------------------- methods that interact with the api ----------------------------------------------------
    @GetMapping("api/posts/top")
    public ResponseEntity<?> apiGetTopPosts(){
        return ResponseEntity.ok(redditService.apiFindTopPosts());

    }
    @GetMapping("api/posts/username/{username}")
    public ResponseEntity<List<Post>> apiGetPostsByUsername(@PathVariable String username){

        return redditService.apiFindPostByUsername(username);
    }
    @GetMapping("api/posts/subreddit/{subreddit}")
    public ResponseEntity<List<Post>> apiGetTopPostsBySubreddit(@PathVariable String subreddit){
        return redditService.apiFindTopPostsBySubreddit(subreddit);
    }

    @PostMapping("api/posts/username")
    public List<Post> savePostsByUsername(@RequestBody String username){
        return redditService.mongodbSavePostsByUsername(username);
    }

    @PostMapping("api/posts/subreddit")
    public List<Post> saveTopPostsBySubreddit(@RequestBody String username){
        return redditService.mongodbSaveTopPostsBySubreddit(username);
    }

}


