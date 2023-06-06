package com.springapiproj.redditinfosystem.repository;

import com.springapiproj.redditinfosystem.pojo.rapidapiposts.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RedditRepository extends MongoRepository<Post,String> {

    List<Post> findByAuthor(String username);
    List<Post> findAllByOrderByCreatedAsc();
    @Query(value="{{$search:'?0'}}")
    List<Post> findByTitleContains(String keyword);

    List<Post> deleteByAuthor(String username);
}
