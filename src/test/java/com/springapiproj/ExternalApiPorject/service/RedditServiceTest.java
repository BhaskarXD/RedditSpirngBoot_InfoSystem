package com.springapiproj.ExternalApiPorject.service;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class RedditServiceTest {
//    @Test
    public void testingDataFetchedOrNot(){
        RedditService redditService=new RedditService();
        assertTrue(redditService.mongodbFinalAllPosts().size()>0);
    }

}