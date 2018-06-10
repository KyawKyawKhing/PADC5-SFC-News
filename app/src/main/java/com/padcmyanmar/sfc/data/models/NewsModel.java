package com.padcmyanmar.sfc.data.models;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.padcmyanmar.sfc.data.vo.ActedUserVO;
import com.padcmyanmar.sfc.data.vo.CommentActionVO;
import com.padcmyanmar.sfc.data.vo.FavouriteActionVO;
import com.padcmyanmar.sfc.data.vo.NewsVO;
import com.padcmyanmar.sfc.data.vo.PublicationVO;
import com.padcmyanmar.sfc.data.vo.SentToVO;
import com.padcmyanmar.sfc.events.RestApiEvents;
import com.padcmyanmar.sfc.network.MMNewsDataAgent;
import com.padcmyanmar.sfc.network.MMNewsDataAgentImpl;
import com.padcmyanmar.sfc.persistence.AppDatabase;
import com.padcmyanmar.sfc.utils.AppConstants;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aung on 12/3/17.
 */

public class NewsModel {

    AppDatabase mAppDatabase;
    MMNewsDataAgent mmNewsDataAgent;
    private static NewsModel objInstance;

    private List<NewsVO> newsVOS;
    private List<FavouriteActionVO> favouriteActionVOS;
    private List<CommentActionVO> commentActionVOS;
    private List<SentToVO> sentToVOS;
    private List<PublicationVO> publicationVOS;
    private List<ActedUserVO> actedUserVOS;

    private int mmNewsPageIndex = 1;

    private NewsModel() {
        EventBus.getDefault().register(this);
        newsVOS = new ArrayList<>();
        favouriteActionVOS = new ArrayList<>();
        commentActionVOS = new ArrayList<>();
        sentToVOS = new ArrayList<>();
        publicationVOS = new ArrayList<>();
        actedUserVOS = new ArrayList<>();
        mmNewsDataAgent = MMNewsDataAgentImpl.getInstance();
    }

    public static NewsModel getInstance() {
        if (objInstance == null) {
            objInstance = new NewsModel();
        }
        return objInstance;
    }

    public void initDatabase(Context context) {
        mAppDatabase = AppDatabase.getNewsDatabase(context);
    }

    public void startLoadingMMNews() {
        mmNewsDataAgent.loadMMNews(AppConstants.ACCESS_TOKEN, mmNewsPageIndex);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onNewsDataLoaded(RestApiEvents.NewsDataLoadedEvent event) {
        newsVOS.addAll(event.getLoadNews());
        for (NewsVO newsVO : event.getLoadNews()) {
            if (newsVO.getPublication() != null) {
                publicationVOS.add(newsVO.getPublication());
            }

            if (newsVO.getFavoriteActions().size() > 0) {
                for (FavouriteActionVO favouriteActionVO : newsVO.getFavoriteActions()) {
                    actedUserVOS.add(favouriteActionVO.getActedUser());
                    favouriteActionVOS.add(favouriteActionVO);
                }
            }
            if (newsVO.getCommentActions().size() > 0) {
                for (CommentActionVO commentActionVO : newsVO.getCommentActions()) {
                    actedUserVOS.add(commentActionVO.getActedUser());
                    commentActionVOS.add(commentActionVO);
                }
            }
            if (newsVO.getSentToActions().size() > 0) {
                for (SentToVO sentToVO : newsVO.getSentToActions()) {
                    actedUserVOS.add(sentToVO.getSender());
                    actedUserVOS.add(sentToVO.getReceiver());
                    sentToVOS.add(sentToVO);
                }
            }
            newsVOS.add(newsVO);
        }
        mAppDatabase.publicationDao().insertPublications(publicationVOS);
        mAppDatabase.actedUserDao().insertActedUsers(actedUserVOS);
        mAppDatabase.favouriteActionDao().insertFavourites(favouriteActionVOS);
        mAppDatabase.commentActionDao().insertCommentActions(commentActionVOS);
        mAppDatabase.sentToDao().insertSentTos(sentToVOS);
        mAppDatabase.newsDao().insertNewss(newsVOS);

        Log.e("publication data size", mAppDatabase.publicationDao().getAllPublications().size() + "");
        Log.e("acted user data size", mAppDatabase.actedUserDao().getAllActedUser().size() + "");
        Log.e("favourite data size", mAppDatabase.favouriteActionDao().getAllFavourites().size() + "");
        Log.e("comment data size", mAppDatabase.commentActionDao().getAllComments().size() + "");
        Log.e("sent to data size", mAppDatabase.sentToDao().getAllSentTos().size() + "");
        Log.e("news data size", mAppDatabase.newsDao().getAllNews().size() + "");

        mmNewsPageIndex = event.getLoadedPageIndex() + 1;
        Gson gson = new Gson();
        Log.e("all data", gson.toJson(mAppDatabase.newsDao().getAllNews()));
//        RestApiEvents.NewsDataLoadedEvent allDataLoadedEvent = new RestApiEvents.NewsDataLoadedEvent(event.getLoadedPageIndex() + 1, mAppDatabase.newsDao().getAllNews());
//        EventBus.getDefault().post(allDataLoadedEvent);
    }
}
