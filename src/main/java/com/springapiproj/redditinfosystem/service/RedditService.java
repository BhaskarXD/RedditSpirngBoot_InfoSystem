package com.springapiproj.redditinfosystem.service;

import com.springapiproj.redditinfosystem.pojo.rapidapiposts.JsonResponse;
import com.springapiproj.redditinfosystem.pojo.rapidapiposts.Post;
import com.springapiproj.redditinfosystem.repository.CustomRedditRepository;
import com.springapiproj.redditinfosystem.repository.RedditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Value("${reddit.access.token}")
    private String redditAccessToken;
    @Value("${reddit.user.agent}")
    private String redditUserAgent;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private RedditRepository redditRepository;
    @Autowired
    private CustomRedditRepository customRedditRepository;
    
//    private String getAuthToken(){
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.setBasicAuth("Ljxr62Lv73T32g", "d-avWGrN_BTGCW_rCU5rU_gJBf4");
//        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//        headers.put("User-Agent",
//                Collections.singletonList("tomcat:com.e4developer.e4reddit-test:v1.0 (by /u/bartoszjd)"));
//        String body = "grant_type=client_credentials";
//        HttpEntity<String> request
//                = new HttpEntity<>(body, headers);
//        String authUrl = "https://www.reddit.com/api/v1/access_token";
//        ResponseEntity<String> response = restTemplate.postForEntity(
//                authUrl, request, String.class);
//        ObjectMapper mapper = new ObjectMapper();
//        Map<String, Object> map = new HashMap<>();
//        try {
//            map.putAll(mapper
//                    .readValue(response.getBody(), new TypeReference<Map<String,Object>>(){}));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println(response.getBody());
//        return String.valueOf(map.get("access_token"));
//    }


    //-------------------------- methods to interact with rapidapi --------------------------------------

    public ResponseEntity<List<Post>> apiFindTopPosts(){

        try {
            HttpHeaders headers=new HttpHeaders();
            headers.set("X-RapidAPI-Key", xRapidApiKey);
            headers.set("X-RapidAPI-Host", xRapidApiHost);
            ResponseEntity<JsonResponse> response=restTemplate.exchange(risingPopularPostsUrl, HttpMethod.GET, new HttpEntity<>(headers),JsonResponse.class);
            return new ResponseEntity<>(Objects.requireNonNull(response.getBody()).getData().getPosts(),response.getStatusCode());

        }catch (Exception e){
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    public ResponseEntity<List<Post>> apiFindPostByUsername(String username){
        try{
            String urlSortedByNew=byUsernameUrl+username+"&sort=new";
            HttpHeaders headers=new HttpHeaders();
            headers.set("X-RapidAPI-Key", xRapidApiKey);
            headers.set("X-RapidAPI-Host", xRapidApiHost);
            ResponseEntity<JsonResponse> response=restTemplate.exchange(urlSortedByNew, HttpMethod.GET, new HttpEntity<>(headers), JsonResponse.class);
            return new ResponseEntity<>(Objects.requireNonNull(response.getBody()).getData().getPosts(),response.getStatusCode());

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
            return new ResponseEntity<>(Objects.requireNonNull(response.getBody()).getData().getPosts(),response.getStatusCode());

        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //---------------------- method to interact with the actual reddit api ----------------------------------

    public ResponseEntity<String> getReddit(){
        try{
            String url="https://oauth.reddit.com/api/v1/me";
            HttpHeaders headers=new HttpHeaders();
            headers.set("User-Agent",redditUserAgent);
            headers.set("Authorization",redditAccessToken);
            return restTemplate.exchange(url,HttpMethod.GET,new HttpEntity<>(headers),String.class);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //--------------------- methods to interact with mongodb --------------------------------------

    public List<Post> mongodbFinalAllPosts(){
        return redditRepository.findAll();
    }

    public List<Post> mongodbSavePostsByUsername(String username) {
        return redditRepository.saveAll(Objects.requireNonNull(apiFindPostByUsername(username).getBody()));
    }

    public List<Post> mongodbSaveTopPostsBySubreddit(String subreddit) {
        return redditRepository.saveAll(Objects.requireNonNull(apiFindTopPostsBySubreddit(subreddit).getBody()));
    }

    public List<Post> mongodbFindPostsByKeyword(String keyword) {
        return customRedditRepository.postsByKeyword(keyword);
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
