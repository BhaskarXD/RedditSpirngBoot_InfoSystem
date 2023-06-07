
package com.springapiproj.redditinfosystem.pojo.redditposts;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.data.mongodb.core.mapping.Document;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "approved_at_utc",
    "subreddit",
    "selftext",
    "author_fullname",
    "saved",
    "mod_reason_title",
    "gilded",
    "clicked",
    "title",
    "link_flair_richtext",
    "subreddit_name_prefixed",
    "hidden",
    "pwls",
    "link_flair_css_class",
    "downs",
    "thumbnail_height",
    "top_awarded_type",
    "hide_score",
    "name",
    "quarantine",
    "link_flair_text_color",
    "upvote_ratio",
    "author_flair_background_color",
    "subreddit_type",
    "ups",
    "total_awards_received",
    "media_embed",
    "thumbnail_width",
    "author_flair_template_id",
    "is_original_content",
    "user_reports",
    "secure_media",
    "is_reddit_media_domain",
    "is_meta",
    "category",
    "secure_media_embed",
    "link_flair_text",
    "can_mod_post",
    "score",
    "approved_by",
    "is_created_from_ads_ui",
    "author_premium",
    "thumbnail",
    "edited",
    "author_flair_css_class",
    "author_flair_richtext",
    "gildings",
    "content_categories",
    "is_self",
    "mod_note",
    "created",
    "link_flair_type",
    "wls",
    "removed_by_category",
    "banned_by",
    "author_flair_type",
    "domain",
    "allow_live_comments",
    "selftext_html",
    "likes",
    "suggested_sort",
    "banned_at_utc",
    "view_count",
    "archived",
    "no_follow",
    "is_crosspostable",
    "pinned",
    "over_18",
    "all_awardings",
    "awarders",
    "media_only",
    "can_gild",
    "spoiler",
    "locked",
    "author_flair_text",
    "treatment_tags",
    "rte_mode",
    "visited",
    "removed_by",
    "num_reports",
    "distinguished",
    "subreddit_id",
    "author_is_blocked",
    "mod_reason_by",
    "removal_reason",
    "link_flair_background_color",
    "id",
    "is_robot_indexable",
    "report_reasons",
    "author",
    "discussion_type",
    "num_comments",
    "send_replies",
    "whitelist_status",
    "contest_mode",
    "mod_reports",
    "author_patreon_flair",
    "author_flair_text_color",
    "permalink",
    "parent_whitelist_status",
    "stickied",
    "url",
    "subreddit_subscribers",
    "created_utc",
    "num_crossposts",
    "media",
    "is_video"
})

@JsonFilter("SimplePostDataFilter")
@Document("myPosts")
public class PostData {

    @JsonProperty("subreddit")
    private String subreddit;
    @JsonProperty("selftext")
    private String selftext;
    @JsonProperty("author_fullname")
    private String authorFullname;
    @JsonProperty("saved")
    private Boolean saved;
    @JsonProperty("mod_reason_title")
    private Object modReasonTitle;
    @JsonProperty("title")
    private String title;
    @JsonProperty("subreddit_name_prefixed")
    private String subredditNamePrefixed;


    @JsonProperty("name")
    private String name;
    @JsonProperty("subreddit_type")
    private String subredditType;
    @JsonProperty("total_awards_received")
    private Integer totalAwardsReceived;
    @JsonProperty("is_original_content")
    private Boolean isOriginalContent;
    @JsonProperty("category")
    private Object category;
    @JsonProperty("created")
    private Double created;

    @JsonProperty("selftext_html")
    private String selftextHtml;
    @JsonProperty("likes")
    private Boolean likes;
    @JsonProperty("view_count")
    private Object viewCount;

    @JsonProperty("subreddit_id")
    private String subredditId;

    @JsonProperty("id")
    private String id;
    @JsonProperty("author")
    private String author;
    @JsonProperty("num_comments")
    private Integer numComments;
    @JsonProperty("url")
    private String url;

    public String getSubreddit() {
        return subreddit;
    }

    public void setSubreddit(String subreddit) {
        this.subreddit = subreddit;
    }

    public String getSelftext() {
        return selftext;
    }

    public void setSelftext(String selftext) {
        this.selftext = selftext;
    }

    public String getAuthorFullname() {
        return authorFullname;
    }

    public void setAuthorFullname(String authorFullname) {
        this.authorFullname = authorFullname;
    }

    public Boolean getSaved() {
        return saved;
    }

    public void setSaved(Boolean saved) {
        this.saved = saved;
    }

    public Object getModReasonTitle() {
        return modReasonTitle;
    }

    public void setModReasonTitle(Object modReasonTitle) {
        this.modReasonTitle = modReasonTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubredditNamePrefixed() {
        return subredditNamePrefixed;
    }

    public void setSubredditNamePrefixed(String subredditNamePrefixed) {
        this.subredditNamePrefixed = subredditNamePrefixed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubredditType() {
        return subredditType;
    }

    public void setSubredditType(String subredditType) {
        this.subredditType = subredditType;
    }

    public Integer getTotalAwardsReceived() {
        return totalAwardsReceived;
    }

    public void setTotalAwardsReceived(Integer totalAwardsReceived) {
        this.totalAwardsReceived = totalAwardsReceived;
    }

    public Boolean getOriginalContent() {
        return isOriginalContent;
    }

    public void setOriginalContent(Boolean originalContent) {
        isOriginalContent = originalContent;
    }

    public Object getCategory() {
        return category;
    }

    public void setCategory(Object category) {
        this.category = category;
    }

    public Double getCreated() {
        return created;
    }

    public void setCreated(Double created) {
        this.created = created;
    }

    public String getSelftextHtml() {
        return selftextHtml;
    }

    public void setSelftextHtml(String selftextHtml) {
        this.selftextHtml = selftextHtml;
    }

    public Boolean getLikes() {
        return likes;
    }

    public void setLikes(Boolean likes) {
        this.likes = likes;
    }

    public Object getViewCount() {
        return viewCount;
    }

    public void setViewCount(Object viewCount) {
        this.viewCount = viewCount;
    }

    public String getSubredditId() {
        return subredditId;
    }

    public void setSubredditId(String subredditId) {
        this.subredditId = subredditId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getNumComments() {
        return numComments;
    }

    public void setNumComments(Integer numComments) {
        this.numComments = numComments;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}