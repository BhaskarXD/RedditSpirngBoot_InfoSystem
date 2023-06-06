package com.springapiproj.redditinfosystem.service;

import com.springapiproj.redditinfosystem.pojo.redditposts.PostData;
import com.springapiproj.redditinfosystem.repository.RedditRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class RedditMongodbService {
    private final RedditRepository redditRepository;
    private final RedditApiService redditApiService;

    public RedditMongodbService(RedditRepository redditRepository, RedditApiService redditApiService) {
        this.redditRepository = redditRepository;
        this.redditApiService = redditApiService;
    }

    //--------------------- methods to interact with mongodb --------------------------------------

    public List<PostData> mongodbFinalAllPosts(){
        return redditRepository.findAll();
    }

    public List<PostData> mongodbSavePostsByUsername(String username) {
        return redditRepository.saveAll(Objects.requireNonNull(redditApiService.apiFindPostByUsername(username).getBody()));
    }

    public List<PostData> mongodbSaveTopPostsBySubreddit(String subreddit) {
        return redditRepository.saveAll(Objects.requireNonNull(redditApiService.apiFindTopPostsBySubreddit(subreddit).getBody()));
    }

    public List<PostData> mongodbFindPostsByKeyword(String keyword) {
        return redditRepository.findByTitleContaining(keyword);
    }

    public List<PostData> mongodbFindPostsByUsername(String username){
        return redditRepository.findByAuthor(username);
    }

    public List<PostData> mongodbPostsSortedByTimestamp() {
        return redditRepository.findAllByOrderByCreatedAsc();
    }

    public List<PostData> mongodbDeletePostsByUsername(String username){
        return redditRepository.deleteByAuthor(username);
    }
}
