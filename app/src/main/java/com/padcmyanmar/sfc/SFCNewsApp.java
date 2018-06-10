package com.padcmyanmar.sfc;

import android.app.Application;

import com.padcmyanmar.sfc.data.models.NewsModel;
import com.padcmyanmar.sfc.persistence.AppDatabase;

/**
 * Created by aung on 11/4/17.
 */

public class SFCNewsApp extends Application {

    public static final String LOG_TAG = "SFCNewsApp";
    NewsModel newsModel;

    @Override
    public void onCreate() {
        super.onCreate();
        newsModel = NewsModel.getInstance();
        newsModel.initDatabase(this);
        newsModel.startLoadingMMNews();
//        AppDatabase.getNewsDatabase(getApplicationContext());
    }
}
