package com.springapiproj.ExternalApiPorject.repository;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.springapiproj.ExternalApiPorject.pojo.rapidapiposts.Post;
import com.springapiproj.ExternalApiPorject.pojo.UserPosts.Child;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class CustomRedditRepository {

    @Autowired
    private MongoClient mongoClient;

    @Autowired
    private MongoConverter mongoConverter;

    public List<Post> postsByKeyword(String keyword) {
        List<Post> posts=new ArrayList<>();
//        System.out.println("inside the customer repo");

        MongoDatabase database = mongoClient.getDatabase("redditDb");
        MongoCollection<Document> collection = database.getCollection("redditPosts");

        AggregateIterable<Document> result=collection.aggregate(Arrays.asList(new Document("$search", 
                                        new Document("text", 
                                        new Document("query", keyword)
                                        .append("path", "title"))),
                                        new Document("$sort",
                                        new Document("numComments", -1L))));
        result.forEach(doc->posts.add(mongoConverter.read(Post.class,doc)));
//        System.out.println("inside the customer repo");
        return posts;
    }

//    public void updateUserPosts(List<Child> posts){
//        MongoDatabase database = mongoClient.getDatabase("redditDb");
//        MongoCollection<Document> collection = database.getCollection("myRedditPosts");
//        AggregateIterable<Document> result=collection.
//        result.forEach(doc->posts.add(mongoConverter.read(Post.class,doc)));
//        System.out.println("inside the customer repo");
//        return posts;
//    }
}
