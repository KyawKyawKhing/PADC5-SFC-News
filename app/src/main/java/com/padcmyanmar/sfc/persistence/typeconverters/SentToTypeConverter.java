package com.padcmyanmar.sfc.persistence.typeconverters;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.padcmyanmar.sfc.data.vo.SentToVO;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by kkk on 6/7/2018.
 */

public class SentToTypeConverter {
    private static Gson gson = new Gson();
    private static Type type = new TypeToken<List<SentToVO>>() {
    }.getType();


    @TypeConverter
    public static List<SentToVO> stringToSentToData(String json) {
        return gson.fromJson(json, type);
    }

    @TypeConverter
    public static String sentToDataToString(List<SentToVO> list) {
        return gson.toJson(list, type);
    }


}
