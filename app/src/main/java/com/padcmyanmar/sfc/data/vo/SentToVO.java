package com.padcmyanmar.sfc.data.vo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aung on 12/3/17.
 */

@Entity(tableName = "senttos", foreignKeys = {
        @ForeignKey(entity = ActedUserVO.class, parentColumns = "userId", childColumns = "sender_id", deferred = true),
        @ForeignKey(entity = ActedUserVO.class, parentColumns = "userId", childColumns = "receiver_id", deferred = true)
})
public class SentToVO {

    @PrimaryKey
    @NonNull
    @SerializedName("send-to-id")
    private String sendToId;

    @SerializedName("sent-date")
    private String sentDate;

    @Ignore
    @SerializedName("acted-user")
    private ActedUserVO sender;

    @ColumnInfo(name = "sender_id")
    private String senderId;

    @Ignore
    @SerializedName("received-user")
    private ActedUserVO receiver;

    @ColumnInfo(name = "receiver_id")
    private String receiverId;

    public String getSenderId() {
        if (sender != null)
            return sender.getUserId();
        return null;
    }

    public String getReceiverId() {
        if (receiver != null)
            return receiver.getUserId();
        return null;
    }

    public String getSendToId() {
        return sendToId;
    }

    public void setSendToId(String sendToId) {
        this.sendToId = sendToId;
    }

    public String getSentDate() {
        return sentDate;
    }

    public void setSentDate(String sentDate) {
        this.sentDate = sentDate;
    }

    public ActedUserVO getSender() {
        return sender;
    }

    public void setSender(ActedUserVO sender) {
        this.sender = sender;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public ActedUserVO getReceiver() {
        return receiver;
    }

    public void setReceiver(ActedUserVO receiver) {
        this.receiver = receiver;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }
}
