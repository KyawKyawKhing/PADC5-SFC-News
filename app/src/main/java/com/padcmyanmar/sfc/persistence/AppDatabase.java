/*
 * Copyright 2017, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.padcmyanmar.sfc.persistence;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.padcmyanmar.sfc.data.vo.ActedUserVO;
import com.padcmyanmar.sfc.data.vo.CommentActionVO;
import com.padcmyanmar.sfc.data.vo.FavouriteActionVO;
import com.padcmyanmar.sfc.data.vo.NewsVO;
import com.padcmyanmar.sfc.data.vo.PublicationVO;
import com.padcmyanmar.sfc.data.vo.SentToVO;
import com.padcmyanmar.sfc.persistence.dao.ActedUserDao;
import com.padcmyanmar.sfc.persistence.dao.CommentActionDao;
import com.padcmyanmar.sfc.persistence.dao.FavouriteActionDao;
import com.padcmyanmar.sfc.persistence.dao.NewsDao;
import com.padcmyanmar.sfc.persistence.dao.PublicationDao;
import com.padcmyanmar.sfc.persistence.dao.SentToDao;

@Database(entities = {NewsVO.class, PublicationVO.class, ActedUserVO.class, FavouriteActionVO.class, CommentActionVO.class, SentToVO.class}, version = 8)
public abstract class AppDatabase extends RoomDatabase {

    private static final String DB_NAME = "PADC-SFC.DB";

    private static AppDatabase INSTANCE;

    public abstract NewsDao newsDao();

    public abstract CommentActionDao commentActionDao();

    public abstract FavouriteActionDao favouriteActionDao();

    public abstract SentToDao sentToDao();

    public abstract PublicationDao publicationDao();

    public abstract ActedUserDao actedUserDao();

    public static AppDatabase getNewsDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DB_NAME)
                            .build();//inmemorybasedatabase
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}