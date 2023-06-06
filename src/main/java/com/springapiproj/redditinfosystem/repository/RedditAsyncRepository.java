package com.springapiproj.redditinfosystem.repository;

import com.springapiproj.redditinfosystem.pojo.redditposts.Data__1;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RedditAsyncRepository extends MongoRepository<Data__1, ObjectId> {
    public List<Data__1> findAllByOrderByCreatedDesc();
}