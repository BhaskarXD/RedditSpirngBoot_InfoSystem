package com.springapiproj.ExternalApiPorject.service;

import com.springapiproj.ExternalApiPorject.pojo.redditposts.*;
import com.springapiproj.ExternalApiPorject.repository.RedditAsyncRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
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
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private RedditAsyncRepository redditAsyncRepository;
    @Async("MultiThreadingBean")
    public void updateUserPosts(String username){
        for(int i=0; i<800; i++){
            try{
                String userPostUrl="https://oauth.reddit.com/user/";
                String url=userPostUrl+username;
                HttpHeaders headers=new HttpHeaders();
                headers.set("User-Agent","ChangeMeClient/0.1 by YourUsername");
                headers.set("Authorization","bearer eyJhbGciOiJSUzI1NiIsImtpZCI6IlNIQTI1NjpzS3dsMnlsV0VtMjVmcXhwTU40cWY4MXE2OWFFdWFyMnpLMUdhVGxjdWNZIiwidHlwIjoiSldUIn0.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNjg1OTY3NjMwLjg0OTg0OCwiaWF0IjoxNjg1ODgxMjMwLjg0OTg0OCwianRpIjoiT3A5WU9yZk1iSHp1RUZjN3ZKY0tqdExZdF9lMnpRIiwiY2lkIjoiMWxRaXphdGlSYng5dHR5T1AxT2dIQSIsImxpZCI6InQyX2NsMWJoNmZjaCIsImFpZCI6InQyX2NsMWJoNmZjaCIsImxjYSI6MTY4NTcyMzM3OTAwMCwic2NwIjoiZUp5S1Z0SlNpZ1VFQUFEX193TnpBU2MiLCJmbG8iOjl9.WM0m5Z5z_pCMbZsdGKTSvfFxH0VxhOzgNlQSOFL-Qbyzl3TGG0rcXx8nGG9uvvNFewxj_JyV5Bd3YP8zDtQ6vPVrPOqdZ88uNHSrZvc3KIJjNAsdxxDtACneumg25ojv2dObS3hrheKsIcz1_pDpnD6ZWTy-WLabY2Shr9YJcW_LiyHkzdoEYk8zyNR2msJSuboHcIcRePzd0opps6uC9Od6abI0SlmUpgJKi05_i6s3ZsAeAFLDLl4r6Sr63TnXl4WijxUAzqfwaUJHpupAnRVo8M0h3rqC2FmahXD5ov-bPrEQkXObPtpVAF21p7CP1ukx4JrJCEuQlDjsCK852w");
                ResponseEntity<Example> response=restTemplate.exchange(url, HttpMethod.GET,new HttpEntity<>(headers),Example.class);
                List<Child> jsonData= Objects.requireNonNull(response.getBody()).getData().getChildren();
                List<Data__1> posts=new ArrayList<>();
                jsonData.forEach(doc->posts.add(doc.getData()));
                redditAsyncRepository.saveAll(posts);
                Thread.sleep(3000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public List<Data__1> getMyPosts(){
        return redditAsyncRepository.findAllByOrderByCreatedDesc();
    }
}
