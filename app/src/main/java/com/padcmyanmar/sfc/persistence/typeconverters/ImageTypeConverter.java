package com.padcmyanmar.sfc.persistence.typeconverters;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by kkk on 6/7/2018.
 */

public class ImageTypeConverter {
    private static Gson gson = new Gson();
    private static Type type = new TypeToken<List<String>>(){}.getType();

    @TypeConverter
    public static List<String> stringToList(String json) {
        return gson.fromJson(json, type);
    }

    @TypeConverter
    public static String listToString(List<String> list) {
        return gson.toJson(list, type);
    }
}
