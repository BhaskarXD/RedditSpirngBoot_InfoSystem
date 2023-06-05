package com.springapiproj.ExternalApiPorject.runner;

import com.springapiproj.ExternalApiPorject.service.RedditAsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AsyncRunner implements CommandLineRunner {
    @Autowired
    RedditAsyncService redditAsyncService;
    @Override
    public void run(String... args) throws Exception {
        redditAsyncService.updateUserPosts("Java17Enjoyer");

    }
}
