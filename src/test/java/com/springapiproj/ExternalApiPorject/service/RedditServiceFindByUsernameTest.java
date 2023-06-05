package com.springapiproj.ExternalApiPorject.service;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class RedditServiceFindByUsernameTest {
//    @Test
    public void testingFindByUsername(){
        RedditService redditService=new RedditService();
        System.out.println("Number of records of the user with username : NOTdPRO = "+redditService.mongodbFindPostsByUsername("NOTdPRO").size());
        assertEquals("NOTdPRO",redditService.mongodbFindPostsByUsername("NOTdPRO").get(0).getAuthor());

    }

}