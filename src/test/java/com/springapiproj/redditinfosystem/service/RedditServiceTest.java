package com.springapiproj.redditinfosystem.service;

import static org.junit.jupiter.api.Assertions.*;

class RedditServiceTest {
//    @Test
    public void testingDataFetchedOrNot(){
        RedditService redditService=new RedditService();
        assertTrue(redditService.mongodbFinalAllPosts().size()>0);
    }

}