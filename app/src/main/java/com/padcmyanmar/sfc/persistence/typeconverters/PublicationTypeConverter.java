package com.padcmyanmar.sfc.persistence.typeconverters;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.padcmyanmar.sfc.data.vo.ActedUserVO;
import com.padcmyanmar.sfc.data.vo.PublicationVO;

/**
 * Created by kkk on 6/7/2018.
 */

public class PublicationTypeConverter {
    private static Gson gson = new Gson();


    @TypeConverter
    public static PublicationVO stringToPublicationData(String json) {
        return gson.fromJson(json, PublicationVO.class);
    }

    @TypeConverter
    public static String PublicationDataToString(PublicationVO vo) {
        return gson.toJson(vo);
    }


}
