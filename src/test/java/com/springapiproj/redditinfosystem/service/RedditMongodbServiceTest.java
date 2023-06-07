package com.springapiproj.redditinfosystem.service;

import com.springapiproj.redditinfosystem.repository.RedditRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class RedditMongodbServiceTest {
    @Mock
    private RedditRepository redditRepository;
    @InjectMocks
    private RedditMongodbService redditMongodbService;

    @Test
    void mongodbFinalAllPosts() {
    }

    @Test
    void mongodbSavePostsByUsername() {
    }

    @Test
    void mongodbSaveTopPostsBySubreddit() {
    }

    @Test
    void mongodbFindPostsByKeyword() {
    }

    @Test
    void mongodbFindPostsByUsername() {
    }

    @Test
    void mongodbPostsSortedByTimestamp() {
    }

    @Test
    void mongodbDeletePostsByUsername() {
    }
}