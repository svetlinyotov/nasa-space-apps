package com.snsdevelop.nasa.disaster.Utils;


import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class StoredData {

    public static final String DISASTER = "DISASTER";

    public static void saveInt(Context context, String key, Integer value) {
        SharedPreferences.Editor edit = getSP(context).edit();
        edit.putInt(key, value);
        edit.commit();
    }

    public static void saveString(Context context, String key, String value) {
        SharedPreferences.Editor edit = getSP(context).edit();
        edit.putString(key, value);
        edit.apply();
    }

    public static void saveLong(Context context, String key, Long value) {
        SharedPreferences.Editor edit = getSP(context).edit();
        edit.putLong(key, value);
        edit.apply();
    }

    private static SharedPreferences.Editor getEditor(Context context) {
        return getSP(context).edit();
    }

    private static SharedPreferences.Editor getEditor(SharedPreferences sp) {
        return sp.edit();
    }

    public static SharedPreferences getSP(Context context) {
        return context.getSharedPreferences("Logged_User_Data", MODE_PRIVATE);
    }

    public static String getString(Context context, String value) {
        return getSP(context).getString(value, null);
    }

    public static int getInt(Context context, String value) {
        return getSP(context).getInt(value, 0);
    }

    public static long getLong(Context context, String value) {
        return getSP(context).getLong(value, 0L);
    }

}
