package com.padcmyanmar.sfc.persistence.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.padcmyanmar.sfc.data.vo.ActedUserVO;
import com.padcmyanmar.sfc.data.vo.CommentActionVO;

import java.util.List;

/**
 * Created by kkk on 6/7/2018.
 */

@Dao
public interface CommentActionDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insertCommentAction(CommentActionVO commentActionVO);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long[] insertCommentActions(List<CommentActionVO> commentActionVO);

    @Query("SELECT * FROM comments")
    List<CommentActionVO> getAllComments();


    @Query("DELETE FROM comments")
    void deleteAll();
}
