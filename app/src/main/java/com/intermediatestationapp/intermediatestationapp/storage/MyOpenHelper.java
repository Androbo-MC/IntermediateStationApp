package com.intermediatestationapp.intermediatestationapp.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.intermediatestationapp.intermediatestationapp.models.StationVO;

import java.util.ArrayList;

/**
 * DB管理用クラス
 */

public class MyOpenHelper extends SQLiteOpenHelper {

    MyOpenHelper(Context c){
        super(c, "station.db", null, 3);
    }

    // データベースがまだなければこれが呼ばれる
    public void onCreate(SQLiteDatabase db) {

        // 駅名テーブルの作成
        db.execSQL(
                "CREATE TABLE station ( _id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "name TEXT UNIQUE, kana TEXT, pref_cd TEXT, lat TEXT, lng TEXT, gnavi_id TEXT, jorudan_name TEXT);"
        );
        // DB作成時に駅データをまとめて取り込む(1都6県の全駅)
        ArrayList<StationVO> stationVOList = new ArrayList<>();
        stationVOList.add(new StationVO("相老","あいおい","10","36.410261","139.304178","0001780","相老（群馬）"));
        stationVOList.add(new StationVO("蕨","わらび","11","35.827959","139.690357","0002044","蕨"));

        // VOに取り込んだ駅データをテーブルにすべて挿入
        for (StationVO vo : stationVOList) {
            db.execSQL("INSERT INTO station(name, kana, pref_cd, lat, lng, gnavi_id, jorudan_name) " +
                    "VALUES('" + vo.getName() + "', '" + vo.getKana()
                    + "', '" + vo.getPrefCd() + "', '" + vo.getLat() + "', '" + vo.getLng()
                    + "', '" + vo.getGnaviId() + "', '" + vo.getJorudanName() + "');"
            );
        }
        // リストとDBを開放
        stationVOList.clear();
    }

    // バージョン情報(SQLいてOpenHelperの第4引数)が異なると呼ばれる
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE station;");
        onCreate(db);
    }
}
