package com.padcmyanmar.sfc.persistence.typeconverters;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.padcmyanmar.sfc.data.vo.ActedUserVO;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by kkk on 6/7/2018.
 */

public class ActedUserTypeConverter {
    private static Gson gson = new Gson();


    @TypeConverter
    public static ActedUserVO stringToActedUserData(String json) {
        return gson.fromJson(json, ActedUserVO.class);
    }

    @TypeConverter
    public static String ActedUserDataToString(ActedUserVO actedUserVO) {
        return gson.toJson(actedUserVO);
    }


}
