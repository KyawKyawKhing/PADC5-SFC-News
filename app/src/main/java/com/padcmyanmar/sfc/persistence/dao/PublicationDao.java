package com.padcmyanmar.sfc.persistence.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.padcmyanmar.sfc.data.vo.PublicationVO;

import java.util.List;

/**
 * Created by kkk on 6/7/2018.
 */

@Dao
public interface PublicationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertPublication(PublicationVO publicationVO);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertPublications(List<PublicationVO> publicationVOS);

    @Query("SELECT * FROM publications")
    List<PublicationVO> getAllPublications();

    @Query("DELETE FROM publications")
    void deleteAll();
}
