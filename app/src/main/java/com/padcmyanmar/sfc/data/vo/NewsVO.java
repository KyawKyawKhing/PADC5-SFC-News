package com.padcmyanmar.sfc.data.vo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;
import com.padcmyanmar.sfc.persistence.typeconverters.CommentTypeConverter;
import com.padcmyanmar.sfc.persistence.typeconverters.FavouriteTypeConverter;
import com.padcmyanmar.sfc.persistence.typeconverters.ImageTypeConverter;
import com.padcmyanmar.sfc.persistence.typeconverters.PublicationTypeConverter;
import com.padcmyanmar.sfc.persistence.typeconverters.SentToTypeConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aung on 12/2/17.
 */
@Entity(tableName = "news", foreignKeys = {
        @ForeignKey(entity = PublicationVO.class, parentColumns = "publicationId", childColumns = "publication_id", deferred = true)
})
@TypeConverters(ImageTypeConverter.class)
public class NewsVO {

    @PrimaryKey
    @NonNull
    @SerializedName("news-id")
    private String newsId;

    @SerializedName("brief")
    private String brief;

    @SerializedName("details")
    private String details;

    @SerializedName("images")
    private List<String> images;

    @SerializedName("posted-date")
    private String postedDate;

    @Ignore
    @SerializedName("publication")
    private PublicationVO publication;

    @ColumnInfo(name = "publication_id")
    private String publicationId;

    public String getPublicationId() {
        if (publication != null)
            return publication.getPublicationId();
        return null;
    }

    @Ignore
    @SerializedName("favorites")
    private List<FavouriteActionVO> favoriteActions;


    @Ignore
    @SerializedName("comments")
    private List<CommentActionVO> commentActions;

    @Ignore
    @SerializedName("sent-tos")
    private List<SentToVO> sentToActions;


    public List<String> getImages() {
        if (images == null)
            return new ArrayList<>();

        return images;
    }

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(String postedDate) {
        this.postedDate = postedDate;
    }

    public PublicationVO getPublication() {
        if (publication == null)
            publication = new PublicationVO();
        return publication;
    }

    public void setPublication(PublicationVO publication) {
        this.publication = publication;
    }

    public void setPublicationId(String publicationId) {
        this.publicationId = publicationId;
    }

    public List<FavouriteActionVO> getFavoriteActions() {
        if (favoriteActions == null)
            favoriteActions = new ArrayList<>();
        return favoriteActions;
    }

    public void setFavoriteActions(List<FavouriteActionVO> favoriteActions) {
        this.favoriteActions = favoriteActions;
    }

    public List<CommentActionVO> getCommentActions() {
        if (commentActions == null)
            commentActions = new ArrayList<>();
        return commentActions;
    }

    public void setCommentActions(List<CommentActionVO> commentActions) {
        this.commentActions = commentActions;
    }

    public List<SentToVO> getSentToActions() {
        if (sentToActions == null)
            sentToActions = new ArrayList<>();
        return sentToActions;
    }

    public void setSentToActions(List<SentToVO> sentToActions) {
        this.sentToActions = sentToActions;
    }
}
