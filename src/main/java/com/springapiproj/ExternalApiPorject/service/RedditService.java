package com.springapiproj.ExternalApiPorject.service;

import com.springapiproj.ExternalApiPorject.pojo.rapidapiposts.JsonResponse;
import com.springapiproj.ExternalApiPorject.pojo.rapidapiposts.Post;
import com.springapiproj.ExternalApiPorject.repository.CustomRedditRepository;
import com.springapiproj.ExternalApiPorject.repository.RedditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class RedditService {
    @Value("${rapidapi.reddit.risingpopularpost.url}")
    private String risingPopularPostsUrl;
    @Value("${rapidapi.reddit.postsbyusername.url}")
    private String byUsernameUrl;
    @Value("${rapidapi.reddit.toppostsbysubreddit.url}")
    private String topPostsBySubreddit;
    @Value("${rapidapi.key.value}")
    private String xRapidApiKey;
    @Value("${rapidapi.host.name}")
    private String xRapidApiHost;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private RedditRepository redditRepository;
    @Autowired
    private CustomRedditRepository customRedditRepository;
    public ResponseEntity<List<Post>> apiFindTopPosts(){

        try {
            HttpHeaders headers=new HttpHeaders();
            headers.set("X-RapidAPI-Key", xRapidApiKey);
            headers.set("X-RapidAPI-Host", xRapidApiHost);
            ResponseEntity<JsonResponse> response=restTemplate.exchange(risingPopularPostsUrl, HttpMethod.GET, new HttpEntity<>(headers),JsonResponse.class);
            ResponseEntity<List<Post>> listOfPosts= new ResponseEntity<List<Post>>(response.getBody().getData().getPosts(),response.getStatusCode());

            return listOfPosts;

        }catch (Exception e){
            return new ResponseEntity<List<Post>>(new ArrayList<Post>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    public ResponseEntity<List<Post>> apiFindPostByUsername(String username){
        try{
            String urlSortedByNew=byUsernameUrl+username+"&sort=new";
            HttpHeaders headers=new HttpHeaders();
            headers.set("X-RapidAPI-Key", xRapidApiKey);
            headers.set("X-RapidAPI-Host", xRapidApiHost);
            ResponseEntity<JsonResponse> response=restTemplate.exchange(urlSortedByNew, HttpMethod.GET, new HttpEntity<>(headers), JsonResponse.class);
            ResponseEntity<List<Post>> listOfPosts= new ResponseEntity<List<Post>>(response.getBody().getData().getPosts(),response.getStatusCode());

            return listOfPosts;

        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public ResponseEntity<List<Post>> apiFindTopPostsBySubreddit(String subreddit){
        try{
            String topPostSubreddit=topPostsBySubreddit+subreddit+"&time=year";
            HttpHeaders headers=new HttpHeaders();
            headers.set("X-RapidAPI-Key", xRapidApiKey);
            headers.set("X-RapidAPI-Host", xRapidApiHost);
            ResponseEntity<JsonResponse> response=restTemplate.exchange(topPostSubreddit, HttpMethod.GET, new HttpEntity<>(headers), JsonResponse.class);
            ResponseEntity<List<Post>> listOfPosts= new ResponseEntity<List<Post>>(response.getBody().getData().getPosts(),response.getStatusCode());

            return listOfPosts;

        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public ResponseEntity<String> getReddit(){
        try{
            String url="https://oauth.reddit.com/api/v1/me";
            HttpHeaders headers=new HttpHeaders();
            headers.set("User-Agent","ChangeMeClient/0.1 by YourUsername");
            headers.set("Authorization","bearer eyJhbGciOiJSUzI1NiIsImtpZCI6IlNIQTI1NjpzS3dsMnlsV0VtMjVmcXhwTU40cWY4MXE2OWFFdWFyMnpLMUdhVGxjdWNZIiwidHlwIjoiSldUIn0.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNjg1OTY3NjMwLjg0OTg0OCwiaWF0IjoxNjg1ODgxMjMwLjg0OTg0OCwianRpIjoiT3A5WU9yZk1iSHp1RUZjN3ZKY0tqdExZdF9lMnpRIiwiY2lkIjoiMWxRaXphdGlSYng5dHR5T1AxT2dIQSIsImxpZCI6InQyX2NsMWJoNmZjaCIsImFpZCI6InQyX2NsMWJoNmZjaCIsImxjYSI6MTY4NTcyMzM3OTAwMCwic2NwIjoiZUp5S1Z0SlNpZ1VFQUFEX193TnpBU2MiLCJmbG8iOjl9.WM0m5Z5z_pCMbZsdGKTSvfFxH0VxhOzgNlQSOFL-Qbyzl3TGG0rcXx8nGG9uvvNFewxj_JyV5Bd3YP8zDtQ6vPVrPOqdZ88uNHSrZvc3KIJjNAsdxxDtACneumg25ojv2dObS3hrheKsIcz1_pDpnD6ZWTy-WLabY2Shr9YJcW_LiyHkzdoEYk8zyNR2msJSuboHcIcRePzd0opps6uC9Od6abI0SlmUpgJKi05_i6s3ZsAeAFLDLl4r6Sr63TnXl4WijxUAzqfwaUJHpupAnRVo8M0h3rqC2FmahXD5ov-bPrEQkXObPtpVAF21p7CP1ukx4JrJCEuQlDjsCK852w");
            ResponseEntity<String> response=restTemplate.exchange(url,HttpMethod.GET,new HttpEntity<>(headers),String.class);
            return response;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }



    public List<Post> mongodbFinalAllPosts(){
        return redditRepository.findAll();
    }
    public List<Post> mongodbSavePostsByUsername(String username){
        return redditRepository.saveAll(apiFindPostByUsername(username).getBody());
    }

    public List<Post> mongodbSaveTopPostsBySubreddit(String subreddit) {
        return redditRepository.saveAll(apiFindTopPostsBySubreddit(subreddit).getBody());
    }

    public List<Post> mongodbFindPostsByKeyword(String keyword) {
        return customRedditRepository.postsByKeyword(keyword);
//        return redditRepository.findByTitleContains(keyword);
    }

    public List<Post> mongodbFindPostsByUsername(String username){
        return redditRepository.findByAuthor(username);
    }

    public List<Post> mongodbPostsSortedByTimestamp() {
        return redditRepository.findAllByOrderByCreatedAsc();
    }

    public List<Post> mongodbDeletePostsByUsername(String username){
        return redditRepository.deleteByAuthor(username);
    }
}
