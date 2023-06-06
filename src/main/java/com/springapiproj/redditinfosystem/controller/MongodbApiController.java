package com.springapiproj.redditinfosystem.controller;

import com.springapiproj.redditinfosystem.pojo.redditposts.PostData;
import com.springapiproj.redditinfosystem.service.RedditMongodbService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spring/mongodb/posts")
public class MongodbApiController {
    private final RedditMongodbService redditMongodbService;

    public MongodbApiController(RedditMongodbService redditMongodbService) {
        this.redditMongodbService = redditMongodbService;
    }

    //---------------------------- methods that interact with mongodb --------------------------------------------------

    @GetMapping()
    public List<PostData> getAllPosts(){
        return redditMongodbService.mongodbFinalAllPosts();
    }
    @GetMapping("/keyword/{keyword}")
    public List<PostData> getPostsByKeyword(@PathVariable String keyword){
        return redditMongodbService.mongodbFindPostsByKeyword(keyword);
    }
    @GetMapping("/username/{username}")
    public List<PostData> getPostsByUsername(@PathVariable String username){
        return redditMongodbService.mongodbFindPostsByUsername(username);
    }
    @GetMapping("/sorted/timestamp")
    public List<PostData> getPostsSortedByTimestamp(){
        return redditMongodbService.mongodbPostsSortedByTimestamp();
    }
    @DeleteMapping("/delete/username/{username}")
    public List<PostData> deletePostsByUsername(@PathVariable String username){
        return redditMongodbService.mongodbDeletePostsByUsername(username);
    }
}
