package com.springapiproj.redditinfosystem.controller;

import com.springapiproj.redditinfosystem.pojo.redditposts.PostData;
import com.springapiproj.redditinfosystem.service.RedditApiService;
import com.springapiproj.redditinfosystem.service.RedditMongodbService;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public List<EntityModel<PostData>> apiGetPostsByUsername(@PathVariable String username){
        List<PostData> postData=redditApiService.apiFindPostByUsername(username).getBody();
        assert postData != null;
        WebMvcLinkBuilder link=WebMvcLinkBuilder.linkTo( WebMvcLinkBuilder.methodOn(this.getClass()).apiGetRisingPosts());
        List<EntityModel<PostData>> entityModelList= new ArrayList<>();
        for(PostData post: postData) {
            EntityModel<PostData> entityModel = EntityModel.of(post);
            entityModel.add(link.withRel("Reddit-Rising-Posts"));
            entityModelList.add(entityModel);
        }
        return entityModelList;
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


