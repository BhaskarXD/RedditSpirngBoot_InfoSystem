package com.springapiproj.redditinfosystem.pojo.myredditposts;

import com.springapiproj.redditinfosystem.pojo.redditposts.PostData;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("myPosts")
public class MyPosts extends PostData {
}
