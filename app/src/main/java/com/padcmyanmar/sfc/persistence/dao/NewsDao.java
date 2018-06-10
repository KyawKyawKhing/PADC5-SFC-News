package com.padcmyanmar.sfc.persistence.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.padcmyanmar.sfc.data.vo.ActedUserVO;
import com.padcmyanmar.sfc.data.vo.NewsVO;

import java.util.List;

/**
 * Created by kkk on 6/7/2018.
 */

@Dao
public interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insertNews(NewsVO newsVO);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long[] insertNewss(List<NewsVO> newsVOS);

    @Query("SELECT * FROM news")
    List<NewsVO> getAllNews();

    @Query("DELETE FROM news")
    void deleteAll();
}
