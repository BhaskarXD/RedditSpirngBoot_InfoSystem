package com.springapiproj.redditinfosystem.service;

import com.springapiproj.redditinfosystem.pojo.redditposts.Child;
import com.springapiproj.redditinfosystem.pojo.redditposts.PostData;
import com.springapiproj.redditinfosystem.pojo.redditposts.RedditJsonResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class PostDataFromJson {
    public List<PostData> getPostData(ResponseEntity<RedditJsonResponse> response){
        List<Child> jsonData= Objects.requireNonNull(response.getBody()).getData().getChildren();
        List<PostData> posts=new ArrayList<>();
        jsonData.forEach(doc->posts.add(doc.getData()));
        return posts;
    }
}
