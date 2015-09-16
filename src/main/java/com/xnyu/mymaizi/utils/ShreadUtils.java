package com.xnyu.mymaizi.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by xnyu on 15.
 */
public class ShreadUtils {

    public static final String FILE_NAME = "dian";
    public static final String WELCOME_NAME = "welcome";

    public static boolean getWelcomBoolean(Context context){
        return context.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE).getBoolean(WELCOME_NAME,true);
    }

    public static void setWelcomeBoolean(Context context,boolean isFirst){
       SharedPreferences.Editor editor= context.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE).edit();
        editor.putBoolean(WELCOME_NAME,isFirst);
        editor.commit();
    }
}
