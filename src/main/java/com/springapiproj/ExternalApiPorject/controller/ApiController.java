package com.springapiproj.ExternalApiPorject.controller;

import com.springapiproj.ExternalApiPorject.pojo.rapidapiposts.Post;
import com.springapiproj.ExternalApiPorject.pojo.redditposts.Data__1;
import com.springapiproj.ExternalApiPorject.service.RedditAsyncService;
import com.springapiproj.ExternalApiPorject.service.RedditService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spring")
public class ApiController {

    final RedditService redditService;
    final RedditAsyncService redditAsyncService;

    public ApiController(RedditService redditService, RedditAsyncService redditAsyncService) {
        this.redditService = redditService;
        this.redditAsyncService = redditAsyncService;
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
