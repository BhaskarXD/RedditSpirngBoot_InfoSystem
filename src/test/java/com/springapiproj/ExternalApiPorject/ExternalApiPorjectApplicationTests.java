package com.springapiproj.ExternalApiPorject;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.springapiproj.ExternalApiPorject.service.RedditService;
//import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//@SpringBootTest
//class ExternalApiPorjectApplicationTests {
//
//	@Test
//	public void testingDataFetchedOrNot(){
//		RedditService redditService=new RedditService();
//		assertTrue(redditService.mongodbFinalAllPosts().size()>0);
//	}
//	@Test
//	public void testingFindByUsername(){
//		RedditService redditService=new RedditService();
//		System.out.println("Number of records of the user with username : NOTdPRO = "+redditService.mongodbFindPostsByUsername("NOTdPRO").size());
//		assertEquals("NOTdPRO",redditService.mongodbFindPostsByUsername("NOTdPRO").get(0).getAuthor());
//
//	}
//}
