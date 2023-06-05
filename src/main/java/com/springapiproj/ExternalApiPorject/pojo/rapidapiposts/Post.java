
package com.springapiproj.ExternalApiPorject.pojo.rapidapiposts; ;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
//import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.data.mongodb.core.mapping.Document;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "numComments",
    "created",
    "score",
    "distinguishType",
    "isLocked",
    "isStickied",
    "thumbnail",
    "title",
    "author",
    "authorId",
    "authorIsBlocked",
    "domain",
    "postId",
    "upvoteRatio",
    "numDuplicates",
    "discussionType",
    "viewCount",
    "goldCount",
    "isArchived",
    "contestMode",
    "gildings",
    "postCategories",
    "suggestedSort",
    "belongsTo",
    "flair",
    "hidden",
    "saved",
    "isGildable",
    "isMediaOnly",
    "isSponsored",
    "isNSFW",
    "isMeta",
    "isSpoiler",
    "isBlank",
    "sendReplies",
    "voteState",
    "permalink",
    "events",
    "eventsOnRender",
    "callToAction",
    "domainOverride",
    "impressionId",
    "isSurveyAd",
    "impressionIdStr",
    "isCreatedFromAdsUi",
    "adSupplementaryText",
    "adPromotedUserPostIds",
    "subcaption",
    "media",
    "preview",
    "crosspostRootId",
    "crosspostParentId",
    "numCrossposts",
    "isCrosspostable",
    "liveCommentsWebsocket",
    "source",
    "isOriginalContent",
    "contentCategories",
    "isScoreHidden",
    "removedByCategory"
})
//@Generated("jsonschema2pojo")
@Document("redditPosts")
public class Post {

    @JsonProperty("id")
    private String id;
    @JsonProperty("numComments")
    private Integer numComments;
    @JsonProperty("created")
    private Long created;
    @JsonProperty("score")
    private Integer score;
    @JsonProperty("distinguishType")
    private Object distinguishType;
    @JsonProperty("isLocked")
    private Boolean isLocked;
    @JsonProperty("isStickied")
    private Boolean isStickied;
    @JsonProperty("thumbnail")
    private Thumbnail thumbnail;
    @JsonProperty("title")
    private String title;
    @JsonProperty("author")
    private String author;
    @JsonProperty("authorId")
    private String authorId;
    @JsonProperty("authorIsBlocked")
    private Boolean authorIsBlocked;
    @JsonProperty("domain")
    private String domain;
    @JsonProperty("postId")
    private String postId;
    @JsonProperty("upvoteRatio")
    private Integer upvoteRatio;
    @JsonProperty("numDuplicates")
    private Object numDuplicates;
    @JsonProperty("discussionType")
    private Object discussionType;
    @JsonProperty("viewCount")
    private Integer viewCount;
    @JsonProperty("goldCount")
    private Integer goldCount;
    @JsonProperty("isArchived")
    private Boolean isArchived;
    @JsonProperty("contestMode")
    private Boolean contestMode;
    @JsonProperty("gildings")
    private Object gildings;
    @JsonProperty("postCategories")
    private Object postCategories;
    @JsonProperty("suggestedSort")
    private Object suggestedSort;
    @JsonProperty("belongsTo")
    private BelongsTo belongsTo;
    @JsonProperty("flair")
    private List<Flair> flair;
    @JsonProperty("hidden")
    private Boolean hidden;
    @JsonProperty("saved")
    private Boolean saved;
    @JsonProperty("isGildable")
    private Boolean isGildable;
    @JsonProperty("isMediaOnly")
    private Boolean isMediaOnly;
    @JsonProperty("isSponsored")
    private Boolean isSponsored;
    @JsonProperty("isNSFW")
    private Boolean isNSFW;
    @JsonProperty("isMeta")
    private Boolean isMeta;
    @JsonProperty("isSpoiler")
    private Boolean isSpoiler;
    @JsonProperty("isBlank")
    private Boolean isBlank;
    @JsonProperty("sendReplies")
    private Boolean sendReplies;
    @JsonProperty("voteState")
    private Integer voteState;
    @JsonProperty("permalink")
    private String permalink;
    @JsonProperty("events")
    private List<Object> events;
    @JsonProperty("eventsOnRender")
    private List<Object> eventsOnRender;
    @JsonProperty("callToAction")
    private Object callToAction;
    @JsonProperty("domainOverride")
    private Object domainOverride;
    @JsonProperty("impressionId")
    private Object impressionId;
    @JsonProperty("isSurveyAd")
    private Object isSurveyAd;
    @JsonProperty("impressionIdStr")
    private Object impressionIdStr;
    @JsonProperty("isCreatedFromAdsUi")
    private Boolean isCreatedFromAdsUi;
    @JsonProperty("adSupplementaryText")
    private Object adSupplementaryText;
    @JsonProperty("adPromotedUserPostIds")
    private List<Object> adPromotedUserPostIds;
    @JsonProperty("subcaption")
    private Object subcaption;
    @JsonProperty("media")
    private Media media;
    @JsonProperty("preview")
    private Preview preview;
    @JsonProperty("crosspostRootId")
    private Object crosspostRootId;
    @JsonProperty("crosspostParentId")
    private Object crosspostParentId;
    @JsonProperty("numCrossposts")
    private Integer numCrossposts;
    @JsonProperty("isCrosspostable")
    private Boolean isCrosspostable;
    @JsonProperty("liveCommentsWebsocket")
    private String liveCommentsWebsocket;
    @JsonProperty("source")
    private Source source;
    @JsonProperty("isOriginalContent")
    private Boolean isOriginalContent;
    @JsonProperty("contentCategories")
    private Object contentCategories;
    @JsonProperty("isScoreHidden")
    private Boolean isScoreHidden;
    @JsonProperty("removedByCategory")
    private String removedByCategory;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("numComments")
    public Integer getNumComments() {
        return numComments;
    }

    @JsonProperty("numComments")
    public void setNumComments(Integer numComments) {
        this.numComments = numComments;
    }

    @JsonProperty("created")
    public Long getCreated() {
        return created;
    }

    @JsonProperty("created")
    public void setCreated(Long created) {
        this.created = created;
    }

    @JsonProperty("score")
    public Integer getScore() {
        return score;
    }

    @JsonProperty("score")
    public void setScore(Integer score) {
        this.score = score;
    }

    @JsonProperty("distinguishType")
    public Object getDistinguishType() {
        return distinguishType;
    }

    @JsonProperty("distinguishType")
    public void setDistinguishType(Object distinguishType) {
        this.distinguishType = distinguishType;
    }

    @JsonProperty("isLocked")
    public Boolean getIsLocked() {
        return isLocked;
    }

    @JsonProperty("isLocked")
    public void setIsLocked(Boolean isLocked) {
        this.isLocked = isLocked;
    }

    @JsonProperty("isStickied")
    public Boolean getIsStickied() {
        return isStickied;
    }

    @JsonProperty("isStickied")
    public void setIsStickied(Boolean isStickied) {
        this.isStickied = isStickied;
    }

    @JsonProperty("thumbnail")
    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    @JsonProperty("thumbnail")
    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("author")
    public String getAuthor() {
        return author;
    }

    @JsonProperty("author")
    public void setAuthor(String author) {
        this.author = author;
    }

    @JsonProperty("authorId")
    public String getAuthorId() {
        return authorId;
    }

    @JsonProperty("authorId")
    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    @JsonProperty("authorIsBlocked")
    public Boolean getAuthorIsBlocked() {
        return authorIsBlocked;
    }

    @JsonProperty("authorIsBlocked")
    public void setAuthorIsBlocked(Boolean authorIsBlocked) {
        this.authorIsBlocked = authorIsBlocked;
    }

    @JsonProperty("domain")
    public String getDomain() {
        return domain;
    }

    @JsonProperty("domain")
    public void setDomain(String domain) {
        this.domain = domain;
    }

    @JsonProperty("postId")
    public String getPostId() {
        return postId;
    }

    @JsonProperty("postId")
    public void setPostId(String postId) {
        this.postId = postId;
    }

    @JsonProperty("upvoteRatio")
    public Integer getUpvoteRatio() {
        return upvoteRatio;
    }

    @JsonProperty("upvoteRatio")
    public void setUpvoteRatio(Integer upvoteRatio) {
        this.upvoteRatio = upvoteRatio;
    }

    @JsonProperty("numDuplicates")
    public Object getNumDuplicates() {
        return numDuplicates;
    }

    @JsonProperty("numDuplicates")
    public void setNumDuplicates(Object numDuplicates) {
        this.numDuplicates = numDuplicates;
    }

    @JsonProperty("discussionType")
    public Object getDiscussionType() {
        return discussionType;
    }

    @JsonProperty("discussionType")
    public void setDiscussionType(Object discussionType) {
        this.discussionType = discussionType;
    }

    @JsonProperty("viewCount")
    public Integer getViewCount() {
        return viewCount;
    }

    @JsonProperty("viewCount")
    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    @JsonProperty("goldCount")
    public Integer getGoldCount() {
        return goldCount;
    }

    @JsonProperty("goldCount")
    public void setGoldCount(Integer goldCount) {
        this.goldCount = goldCount;
    }

    @JsonProperty("isArchived")
    public Boolean getIsArchived() {
        return isArchived;
    }

    @JsonProperty("isArchived")
    public void setIsArchived(Boolean isArchived) {
        this.isArchived = isArchived;
    }

    @JsonProperty("contestMode")
    public Boolean getContestMode() {
        return contestMode;
    }

    @JsonProperty("contestMode")
    public void setContestMode(Boolean contestMode) {
        this.contestMode = contestMode;
    }

    @JsonProperty("gildings")
    public Object getGildings() {
        return gildings;
    }

    @JsonProperty("gildings")
    public void setGildings(Object gildings) {
        this.gildings = gildings;
    }

    @JsonProperty("postCategories")
    public Object getPostCategories() {
        return postCategories;
    }

    @JsonProperty("postCategories")
    public void setPostCategories(Object postCategories) {
        this.postCategories = postCategories;
    }

    @JsonProperty("suggestedSort")
    public Object getSuggestedSort() {
        return suggestedSort;
    }

    @JsonProperty("suggestedSort")
    public void setSuggestedSort(Object suggestedSort) {
        this.suggestedSort = suggestedSort;
    }

    @JsonProperty("belongsTo")
    public BelongsTo getBelongsTo() {
        return belongsTo;
    }

    @JsonProperty("belongsTo")
    public void setBelongsTo(BelongsTo belongsTo) {
        this.belongsTo = belongsTo;
    }

    @JsonProperty("flair")
    public List<Flair> getFlair() {
        return flair;
    }

    @JsonProperty("flair")
    public void setFlair(List<Flair> flair) {
        this.flair = flair;
    }

    @JsonProperty("hidden")
    public Boolean getHidden() {
        return hidden;
    }

    @JsonProperty("hidden")
    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    @JsonProperty("saved")
    public Boolean getSaved() {
        return saved;
    }

    @JsonProperty("saved")
    public void setSaved(Boolean saved) {
        this.saved = saved;
    }

    @JsonProperty("isGildable")
    public Boolean getIsGildable() {
        return isGildable;
    }

    @JsonProperty("isGildable")
    public void setIsGildable(Boolean isGildable) {
        this.isGildable = isGildable;
    }

    @JsonProperty("isMediaOnly")
    public Boolean getIsMediaOnly() {
        return isMediaOnly;
    }

    @JsonProperty("isMediaOnly")
    public void setIsMediaOnly(Boolean isMediaOnly) {
        this.isMediaOnly = isMediaOnly;
    }

    @JsonProperty("isSponsored")
    public Boolean getIsSponsored() {
        return isSponsored;
    }

    @JsonProperty("isSponsored")
    public void setIsSponsored(Boolean isSponsored) {
        this.isSponsored = isSponsored;
    }

    @JsonProperty("isNSFW")
    public Boolean getIsNSFW() {
        return isNSFW;
    }

    @JsonProperty("isNSFW")
    public void setIsNSFW(Boolean isNSFW) {
        this.isNSFW = isNSFW;
    }

    @JsonProperty("isMeta")
    public Boolean getIsMeta() {
        return isMeta;
    }

    @JsonProperty("isMeta")
    public void setIsMeta(Boolean isMeta) {
        this.isMeta = isMeta;
    }

    @JsonProperty("isSpoiler")
    public Boolean getIsSpoiler() {
        return isSpoiler;
    }

    @JsonProperty("isSpoiler")
    public void setIsSpoiler(Boolean isSpoiler) {
        this.isSpoiler = isSpoiler;
    }

    @JsonProperty("isBlank")
    public Boolean getIsBlank() {
        return isBlank;
    }

    @JsonProperty("isBlank")
    public void setIsBlank(Boolean isBlank) {
        this.isBlank = isBlank;
    }

    @JsonProperty("sendReplies")
    public Boolean getSendReplies() {
        return sendReplies;
    }

    @JsonProperty("sendReplies")
    public void setSendReplies(Boolean sendReplies) {
        this.sendReplies = sendReplies;
    }

    @JsonProperty("voteState")
    public Integer getVoteState() {
        return voteState;
    }

    @JsonProperty("voteState")
    public void setVoteState(Integer voteState) {
        this.voteState = voteState;
    }

    @JsonProperty("permalink")
    public String getPermalink() {
        return permalink;
    }

    @JsonProperty("permalink")
    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    @JsonProperty("events")
    public List<Object> getEvents() {
        return events;
    }

    @JsonProperty("events")
    public void setEvents(List<Object> events) {
        this.events = events;
    }

    @JsonProperty("eventsOnRender")
    public List<Object> getEventsOnRender() {
        return eventsOnRender;
    }

    @JsonProperty("eventsOnRender")
    public void setEventsOnRender(List<Object> eventsOnRender) {
        this.eventsOnRender = eventsOnRender;
    }

    @JsonProperty("callToAction")
    public Object getCallToAction() {
        return callToAction;
    }

    @JsonProperty("callToAction")
    public void setCallToAction(Object callToAction) {
        this.callToAction = callToAction;
    }

    @JsonProperty("domainOverride")
    public Object getDomainOverride() {
        return domainOverride;
    }

    @JsonProperty("domainOverride")
    public void setDomainOverride(Object domainOverride) {
        this.domainOverride = domainOverride;
    }

    @JsonProperty("impressionId")
    public Object getImpressionId() {
        return impressionId;
    }

    @JsonProperty("impressionId")
    public void setImpressionId(Object impressionId) {
        this.impressionId = impressionId;
    }

    @JsonProperty("isSurveyAd")
    public Object getIsSurveyAd() {
        return isSurveyAd;
    }

    @JsonProperty("isSurveyAd")
    public void setIsSurveyAd(Object isSurveyAd) {
        this.isSurveyAd = isSurveyAd;
    }

    @JsonProperty("impressionIdStr")
    public Object getImpressionIdStr() {
        return impressionIdStr;
    }

    @JsonProperty("impressionIdStr")
    public void setImpressionIdStr(Object impressionIdStr) {
        this.impressionIdStr = impressionIdStr;
    }

    @JsonProperty("isCreatedFromAdsUi")
    public Boolean getIsCreatedFromAdsUi() {
        return isCreatedFromAdsUi;
    }

    @JsonProperty("isCreatedFromAdsUi")
    public void setIsCreatedFromAdsUi(Boolean isCreatedFromAdsUi) {
        this.isCreatedFromAdsUi = isCreatedFromAdsUi;
    }

    @JsonProperty("adSupplementaryText")
    public Object getAdSupplementaryText() {
        return adSupplementaryText;
    }

    @JsonProperty("adSupplementaryText")
    public void setAdSupplementaryText(Object adSupplementaryText) {
        this.adSupplementaryText = adSupplementaryText;
    }

    @JsonProperty("adPromotedUserPostIds")
    public List<Object> getAdPromotedUserPostIds() {
        return adPromotedUserPostIds;
    }

    @JsonProperty("adPromotedUserPostIds")
    public void setAdPromotedUserPostIds(List<Object> adPromotedUserPostIds) {
        this.adPromotedUserPostIds = adPromotedUserPostIds;
    }

    @JsonProperty("subcaption")
    public Object getSubcaption() {
        return subcaption;
    }

    @JsonProperty("subcaption")
    public void setSubcaption(Object subcaption) {
        this.subcaption = subcaption;
    }

    @JsonProperty("media")
    public Media getMedia() {
        return media;
    }

    @JsonProperty("media")
    public void setMedia(Media media) {
        this.media = media;
    }

    @JsonProperty("preview")
    public Preview getPreview() {
        return preview;
    }

    @JsonProperty("preview")
    public void setPreview(Preview preview) {
        this.preview = preview;
    }

    @JsonProperty("crosspostRootId")
    public Object getCrosspostRootId() {
        return crosspostRootId;
    }

    @JsonProperty("crosspostRootId")
    public void setCrosspostRootId(Object crosspostRootId) {
        this.crosspostRootId = crosspostRootId;
    }

    @JsonProperty("crosspostParentId")
    public Object getCrosspostParentId() {
        return crosspostParentId;
    }

    @JsonProperty("crosspostParentId")
    public void setCrosspostParentId(Object crosspostParentId) {
        this.crosspostParentId = crosspostParentId;
    }

    @JsonProperty("numCrossposts")
    public Integer getNumCrossposts() {
        return numCrossposts;
    }

    @JsonProperty("numCrossposts")
    public void setNumCrossposts(Integer numCrossposts) {
        this.numCrossposts = numCrossposts;
    }

    @JsonProperty("isCrosspostable")
    public Boolean getIsCrosspostable() {
        return isCrosspostable;
    }

    @JsonProperty("isCrosspostable")
    public void setIsCrosspostable(Boolean isCrosspostable) {
        this.isCrosspostable = isCrosspostable;
    }

    @JsonProperty("liveCommentsWebsocket")
    public String getLiveCommentsWebsocket() {
        return liveCommentsWebsocket;
    }

    @JsonProperty("liveCommentsWebsocket")
    public void setLiveCommentsWebsocket(String liveCommentsWebsocket) {
        this.liveCommentsWebsocket = liveCommentsWebsocket;
    }

    @JsonProperty("source")
    public Source getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(Source source) {
        this.source = source;
    }

    @JsonProperty("isOriginalContent")
    public Boolean getIsOriginalContent() {
        return isOriginalContent;
    }

    @JsonProperty("isOriginalContent")
    public void setIsOriginalContent(Boolean isOriginalContent) {
        this.isOriginalContent = isOriginalContent;
    }

    @JsonProperty("contentCategories")
    public Object getContentCategories() {
        return contentCategories;
    }

    @JsonProperty("contentCategories")
    public void setContentCategories(Object contentCategories) {
        this.contentCategories = contentCategories;
    }

    @JsonProperty("isScoreHidden")
    public Boolean getIsScoreHidden() {
        return isScoreHidden;
    }

    @JsonProperty("isScoreHidden")
    public void setIsScoreHidden(Boolean isScoreHidden) {
        this.isScoreHidden = isScoreHidden;
    }

    @JsonProperty("removedByCategory")
    public String getRemovedByCategory() {
        return removedByCategory;
    }

    @JsonProperty("removedByCategory")
    public void setRemovedByCategory(String removedByCategory) {
        this.removedByCategory = removedByCategory;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
