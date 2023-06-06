package com.springapiproj.redditinfosystem.repository;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.springapiproj.redditinfosystem.pojo.redditposts.PostData;
import org.bson.Document;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class CustomRedditRepository {
    private final MongoClient mongoClient;
    private final MongoConverter mongoConverter;

    public CustomRedditRepository(MongoClient mongoClient, MongoConverter mongoConverter) {
        this.mongoClient = mongoClient;
        this.mongoConverter = mongoConverter;
    }

    public List<PostData> postsByKeyword(String keyword) {
        List<PostData> posts=new ArrayList<>();

        MongoDatabase database = mongoClient.getDatabase("redditDb");
        MongoCollection<Document> collection = database.getCollection("redditPosts");

        AggregateIterable<Document> result=collection.aggregate(Arrays.asList(new Document("$search", 
                                        new Document("text", 
                                        new Document("query", keyword)
                                        .append("path", "title"))),
                                        new Document("$sort",
                                        new Document("numComments", -1L))));
        result.forEach(doc->posts.add(mongoConverter.read(PostData.class,doc)));
        return posts;
    }

}
