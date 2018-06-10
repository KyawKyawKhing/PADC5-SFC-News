package com.padcmyanmar.sfc.data.vo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;
import com.padcmyanmar.sfc.persistence.typeconverters.ActedUserTypeConverter;
import com.padcmyanmar.sfc.persistence.typeconverters.FavouriteTypeConverter;

/**
 * Created by aung on 12/3/17.
 */
@Entity(tableName = "favourites", foreignKeys = {
        @ForeignKey(entity = ActedUserVO.class, parentColumns = "userId", childColumns = "acted_user_id", deferred = true)
})

public class FavouriteActionVO {

    @PrimaryKey
    @NonNull
    @SerializedName("favorite-id")
    private String favoriteId;

    @SerializedName("favorite-date")
    private String favoriteDate;

    @Ignore
    @SerializedName("acted-user")
    private ActedUserVO actedUser;

    @ColumnInfo(name = "acted_user_id")
    private String actedUserId;

    public String getActedUserId() {
        if (actedUser != null)
            return actedUser.getUserId();
        return null;
    }

    public String getFavoriteId() {
        return favoriteId;
    }

    public void setFavoriteId(String favoriteId) {
        this.favoriteId = favoriteId;
    }

    public String getFavoriteDate() {
        return favoriteDate;
    }

    public void setFavoriteDate(String favoriteDate) {
        this.favoriteDate = favoriteDate;
    }

    public ActedUserVO getActedUser() {
        return actedUser;
    }

    public void setActedUser(ActedUserVO actedUser) {
        this.actedUser = actedUser;
    }

    public void setActedUserId(String actedUserId) {
        this.actedUserId = actedUserId;
    }
}
