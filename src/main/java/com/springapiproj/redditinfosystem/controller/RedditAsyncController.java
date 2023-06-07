package com.springapiproj.redditinfosystem.controller;

import com.springapiproj.redditinfosystem.pojo.redditposts.PostData;
import com.springapiproj.redditinfosystem.service.CustomMappingJacksonValue;
import com.springapiproj.redditinfosystem.service.RedditAsyncService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/spring/reddit")
public class RedditAsyncController {
    @Value("${reddit.my.author.name}")
    private String author;
    private final RedditAsyncService redditAsyncService;
    private final CustomMappingJacksonValue customMappingJacksonValue;

    public RedditAsyncController(RedditAsyncService redditAsyncService, CustomMappingJacksonValue customMappingJacksonValue) {
        this.redditAsyncService = redditAsyncService;
        this.customMappingJacksonValue = customMappingJacksonValue;
    }

    //---------------- method to get up-to-date user posts saved by multithreaded service ------------------------------

    @GetMapping("/my/posts")
    public MappingJacksonValue getMyPosts(){
        return customMappingJacksonValue.getCustomMappedObjects(redditAsyncService.getMyPosts(author));
    }
}

