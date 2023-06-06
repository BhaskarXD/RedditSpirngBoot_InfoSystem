package com.springapiproj.redditinfosystem.service;

import com.springapiproj.redditinfosystem.pojo.redditposts.*;
import com.springapiproj.redditinfosystem.repository.RedditAsyncRepository;
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
    private final RestTemplate restTemplate;
    private final RedditAsyncRepository redditAsyncRepository;

    public RedditAsyncService(RestTemplate restTemplate, RedditAsyncRepository redditAsyncRepository) {
        this.restTemplate = restTemplate;
        this.redditAsyncRepository = redditAsyncRepository;
    }

    @Async("MultiThreadingBean")
    public void updateUserPosts(String username){
        while(true){
            try{
                String userPostUrl="https://www.reddit.com/user/";
                String url=userPostUrl+username+"/.json";
//                HttpHeaders headers=new HttpHeaders();
                ResponseEntity<RedditJsonResponse> response=restTemplate.exchange(url, HttpMethod.GET,null, RedditJsonResponse.class);
                List<Child> jsonData= Objects.requireNonNull(response.getBody()).getData().getChildren();
                List<PostData> posts=new ArrayList<>();
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
