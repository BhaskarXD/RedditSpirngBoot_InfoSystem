package com.springapiproj.redditinfosystem.service;

import com.springapiproj.redditinfosystem.pojo.redditposts.PostData;
import com.springapiproj.redditinfosystem.repository.RedditRepository;
import com.springapiproj.redditinfosystem.testutils.PostDataGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RedditMongodbServiceTest {
    private static final int sizeOfList = 10;
    @Mock
    private RedditRepository redditRepository;
    @InjectMocks
    private RedditMongodbService redditMongodbService;

    @Test
    void mongodbFinalAllPosts() {
        when(redditRepository.findAll()).thenReturn(PostDataGenerator.generateRandomPostDataList(sizeOfList));
        List<PostData> postData = PostDataGenerator.generateRandomPostDataList(sizeOfList);
        assertNotNull(redditMongodbService.mongodbFinalAllPosts());
    }

    @Test
    void mongodbFindPostsByKeyword() {
        String keyword=PostDataGenerator.generateRandomString();
        when(redditRepository.findByTitleContaining(Mockito.anyString())).thenReturn(PostDataGenerator.generateRandomPostDataListByTitleHavingKeyword(sizeOfList,keyword));
        List<PostData> postsByTitleKeyword=redditMongodbService.mongodbFindPostsByKeyword(keyword);
        assertNotNull(postsByTitleKeyword);
        for(PostData postData: postsByTitleKeyword){
            assertTrue(postData.getTitle().contains(keyword));
        }
    }

    @Test
    void mongodbFindPostsByUsername() {
        String author = PostDataGenerator.generateRandomString();
        when(redditRepository.findByAuthor(Mockito.anyString())).thenReturn(PostDataGenerator.generateRandomPostDataListByAuthorName(sizeOfList,author));
        List<PostData> postsByAuthor=redditMongodbService.mongodbFindPostsByUsername(author);
        assertNotNull(postsByAuthor);
        for(PostData postData: postsByAuthor){
            assertEquals(author,postData.getAuthor());
        }
    }

    @Test
    void mongodbDeletePostsByUsername() {
        String author = PostDataGenerator.generateRandomString();
        when(redditRepository.deleteByAuthor(Mockito.anyString())).thenReturn(PostDataGenerator.generateRandomPostDataListByAuthorName(sizeOfList,author));
        List<PostData> postsByAuthor=redditMongodbService.mongodbDeletePostsByUsername(author);
        assertNotNull(postsByAuthor);
        for(PostData postData: postsByAuthor){
            assertEquals(author,postData.getAuthor());
        }
    }
}