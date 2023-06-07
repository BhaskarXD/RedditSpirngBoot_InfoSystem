package com.springapiproj.redditinfosystem.service;

import com.springapiproj.redditinfosystem.pojo.redditposts.*;
import com.springapiproj.redditinfosystem.repository.RedditAsyncRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class RedditAsyncService {
    @Value("${reddit.posts.by.username.url}")
    private String byUsernameUrl;
    @Value("${reddit.response.url.suffix.json}")
    private String jsonResponseUrlSuffix;

    private final RestTemplate restTemplate;
    private final RedditAsyncRepository redditAsyncRepository;

    public RedditAsyncService(RestTemplate restTemplate, RedditAsyncRepository redditAsyncRepository) {
        this.restTemplate = restTemplate;
        this.redditAsyncRepository = redditAsyncRepository;
    }

    @Async("MultiThreadingBean")
    public void updateUserPosts(String username){
        String userPostUrl=byUsernameUrl;
        String url=userPostUrl+username+jsonResponseUrlSuffix;
        ResponseEntity<RedditJsonResponse> response;
        List<Child> jsonData;
        List<PostData> posts= new ArrayList<>();
        while(true){
            try{
                response = restTemplate.exchange(url, HttpMethod.GET,null, RedditJsonResponse.class);
                jsonData = Objects.requireNonNull(response.getBody()).getData().getChildren();
                posts.removeAll(posts);
                jsonData.forEach(doc->posts.add(doc.getData()));
                redditAsyncRepository.saveAll(posts);
                Thread.sleep(5000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public List<PostData> getMyPosts(String author){
        return redditAsyncRepository.findByAuthorOrderByCreatedDesc(author);
    }
}
