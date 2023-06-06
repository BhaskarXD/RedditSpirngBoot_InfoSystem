package com.springapiproj.redditinfosystem.controller;

import com.springapiproj.redditinfosystem.pojo.redditposts.PostData;
import com.springapiproj.redditinfosystem.service.RedditAsyncService;
import org.springframework.beans.factory.annotation.Value;
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

    public RedditAsyncController(RedditAsyncService redditAsyncService) {
        this.redditAsyncService = redditAsyncService;
    }

    //---------------- method to get up-to-date user posts save by multithreaded service -------------------------------

    @GetMapping("/my/posts")
    public List<PostData> getMyPosts(){
        return redditAsyncService.getMyPosts(author);
    }
}