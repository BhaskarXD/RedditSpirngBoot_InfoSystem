package com.springapiproj.redditinfosystem.testutils;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.springapiproj.redditinfosystem.pojo.redditposts.PostData;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PostDataGenerator {
    private static final Random random = new Random();

    public static PostData generateRandomPostData() {
        PostData postData = new PostData();
        postData.setSubreddit(generateRandomString());
        postData.setSelftext(generateRandomString());
        postData.setAuthorFullname(generateRandomString());
        postData.setSaved(random.nextBoolean());
        postData.setModReasonTitle(generateRandomObject());
        postData.setTitle(generateRandomString());
        postData.setSubredditNamePrefixed(generateRandomString());
        postData.setName(generateRandomString());
        postData.setSubredditType(generateRandomString());
        postData.setTotalAwardsReceived(random.nextInt(10));
        postData.setOriginalContent(random.nextBoolean());
        postData.setCategory(generateRandomObject());
        postData.setCreated(random.nextDouble());
        postData.setSelftextHtml(generateRandomString());
        postData.setLikes(random.nextBoolean());
        postData.setViewCount(generateRandomObject());
        postData.setSubredditId(generateRandomString());
        postData.setId(generateRandomString());
        postData.setAuthor(generateRandomString());
        postData.setNumComments(random.nextInt(100));
        postData.setUrl(generateRandomString());

        return postData;
    }

    public static String generateRandomString() {
        // Generate a random string of length 10
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }

    public static Object generateRandomObject() {
        // Generate a random object (null or a random integer)
        if (random.nextBoolean()) {
            return null;
        } else {
            return random.nextInt();
        }
    }

    public static List<PostData> generateRandomPostDataList(int count) {
        List<PostData> postDataList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            PostData randomPostData = generateRandomPostData();
            postDataList.add(randomPostData);
        }
        return postDataList;
    }

    public static List<PostData> generateRandomPostDataListByAuthorName(int count,String author) {
        List<PostData> postDataList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            PostData randomPostData = generateRandomPostData();
            randomPostData.setAuthor(author);
            postDataList.add(randomPostData);
        }
        return postDataList;
    }

    public static List<PostData> generateRandomPostDataListBySubredditName(int count,String subreddit) {
        List<PostData> postDataList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            PostData randomPostData = generateRandomPostData();
            randomPostData.setSubreddit(subreddit);
            postDataList.add(randomPostData);
        }
        return postDataList;
    }

    public static List<PostData> generateRandomPostDataListByTitleHavingKeyword(int count,String keyword) {
        List<PostData> postDataList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            PostData randomPostData = generateRandomPostData();
            randomPostData.setTitle(randomPostData.getTitle()+" "+keyword);
            postDataList.add(randomPostData);
        }
        return postDataList;
    }


}
