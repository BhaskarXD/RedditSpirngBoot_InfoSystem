package com.springapiproj.redditinfosystem.repository;

import com.mongodb.client.*;
import com.springapiproj.redditinfosystem.pojo.redditposts.PostData;
import org.bson.Document;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomRedditAsyncRepository {
    private final MongoClient mongoClient;
    private final MongoConverter mongoConverter;

    public CustomRedditAsyncRepository(MongoClient mongoClient, MongoConverter mongoConverter) {
        this.mongoClient = mongoClient;
        this.mongoConverter = mongoConverter;
    }

    public void saveMyPosts(List<PostData> posts) {
        MongoDatabase database = mongoClient.getDatabase("redditDb");
        MongoCollection<Document> collection = database.getCollection("myPosts");
        List<Document> postsDocument=new ArrayList<>();
        posts.forEach(doc->postsDocument.add((Document) mongoConverter.convertToMongoType(doc)));
        collection.insertMany(postsDocument);
    }
    public List<PostData> getMyPosts() {
        List<PostData> posts=new ArrayList<>();
        MongoDatabase database = mongoClient.getDatabase("redditDb");
        MongoCollection<Document> collection = database.getCollection("myPosts");
        FindIterable<Document> result=collection.find();
        result.forEach(doc->posts.add(mongoConverter.read(PostData.class,doc)));
        return posts;
    }

}
