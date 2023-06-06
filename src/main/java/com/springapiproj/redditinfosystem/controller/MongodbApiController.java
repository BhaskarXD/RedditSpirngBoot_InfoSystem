package com.springapiproj.redditinfosystem.controller;

import com.springapiproj.redditinfosystem.pojo.rapidapiposts.Post;
import com.springapiproj.redditinfosystem.service.RedditService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spring")
public class MongodbApiController {
    private final RedditService redditService;

    public MongodbApiController(RedditService redditService) {
        this.redditService = redditService;
    }
    //---------------------------- methods that interact with mongodb --------------------------------------------------

    @GetMapping("/mongodb/posts")
    public List<Post> getAllPosts(){
        return redditService.mongodbFinalAllPosts();
    }
    @GetMapping("/mongodb/posts/keyword/{keyword}")
    public List<Post> getPostsByKeyword(@PathVariable String keyword){
        return redditService.mongodbFindPostsByKeyword(keyword);
    }

    @GetMapping("/mongodb/posts/username/{username}")
    public List<Post> getPostsByUsername(@PathVariable String username){
        return redditService.mongodbFindPostsByUsername(username);
    }

    @GetMapping("/mongodb/posts/sorted/timestamp")
    public List<Post> getPostsSortedByTimestamp(){
        return redditService.mongodbPostsSortedByTimestamp();
    }

    @DeleteMapping("/mongodb/posts/delete/username/{username}")
    public List<Post> deletePostsByUsername(@PathVariable String username){
        return redditService.mongodbDeletePostsByUsername(username);
    }
}
