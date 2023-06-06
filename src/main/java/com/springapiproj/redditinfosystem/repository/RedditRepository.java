package com.springapiproj.redditinfosystem.repository;

import com.springapiproj.redditinfosystem.pojo.redditposts.PostData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RedditRepository extends MongoRepository<PostData,String> {

    List<PostData> findByAuthor(String username);
    List<PostData> findAllByOrderByCreatedAsc();
    List<PostData> findByTitleContaining(String keyword);
    List<PostData> deleteByAuthor(String username);
}
