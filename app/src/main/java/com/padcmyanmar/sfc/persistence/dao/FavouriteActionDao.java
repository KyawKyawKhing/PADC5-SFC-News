package com.padcmyanmar.sfc.persistence.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.padcmyanmar.sfc.data.vo.ActedUserVO;
import com.padcmyanmar.sfc.data.vo.FavouriteActionVO;

import java.util.List;

/**
 * Created by kkk on 6/7/2018.
 */

@Dao
public interface FavouriteActionDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insertFavourite(FavouriteActionVO favouriteActionVO);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long[] insertFavourites(List<FavouriteActionVO> favouriteActionVOS);

    @Query("SELECT * FROM favourites")
    List<FavouriteActionVO> getAllFavourites();

    @Query("DELETE FROM favourites")
    void deleteAll();
}
