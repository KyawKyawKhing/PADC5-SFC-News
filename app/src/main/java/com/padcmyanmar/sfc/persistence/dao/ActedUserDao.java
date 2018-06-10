package com.padcmyanmar.sfc.persistence.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.padcmyanmar.sfc.data.vo.ActedUserVO;

import java.util.List;

/**
 * Created by kkk on 6/7/2018.
 */

@Dao
public interface ActedUserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insertActedUser(ActedUserVO actedUserVO);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long[] insertActedUsers(List<ActedUserVO> actedUserVOS);

    @Query("SELECT * FROM actedusers")
    List<ActedUserVO> getAllActedUser();

    @Query("DELETE FROM actedusers")
    void deleteAll();
}
