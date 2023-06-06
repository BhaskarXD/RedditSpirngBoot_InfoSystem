package com.springapiproj.redditinfosystem.repository;

import com.springapiproj.redditinfosystem.pojo.redditposts.PostData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RedditAsyncRepository extends MongoRepository<PostData,String> {
    public List<PostData> findByAuthorOrderByCreatedDesc(String author);
}
