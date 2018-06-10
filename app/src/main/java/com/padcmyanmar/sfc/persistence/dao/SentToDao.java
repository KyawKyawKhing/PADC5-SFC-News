package com.padcmyanmar.sfc.persistence.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.padcmyanmar.sfc.data.vo.ActedUserVO;
import com.padcmyanmar.sfc.data.vo.SentToVO;

import java.util.List;

/**
 * Created by kkk on 6/7/2018.
 */

@Dao
public interface SentToDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insertSentTo(SentToVO sentToVO);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long[] insertSentTos(List<SentToVO> sentToVOS);

    @Query("SELECT * FROM senttos")
    List<SentToVO> getAllSentTos();

    @Query("DELETE FROM senttos")
    void deleteAll();
}
