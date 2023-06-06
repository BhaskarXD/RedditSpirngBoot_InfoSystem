package com.springapiproj.redditinfosystem.runner;

import com.springapiproj.redditinfosystem.service.RedditAsyncService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AsyncRunner implements CommandLineRunner {
    @Value("${reddit.my.author.name}")
    private String author;
    RedditAsyncService redditAsyncService;

    public AsyncRunner(RedditAsyncService redditAsyncService) {
        this.redditAsyncService = redditAsyncService;
    }

    @Override
    public void run(String... args) throws Exception {
        redditAsyncService.updateUserPosts(author);
    }
}
