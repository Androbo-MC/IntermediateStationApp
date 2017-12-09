package com.intermediatestationapp.intermediatestationapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;
import com.intermediatestationapp.intermediatestationapp.application.MyApplication;
import com.intermediatestationapp.intermediatestationapp.models.StationDetailVO;
import com.intermediatestationapp.intermediatestationapp.models.StationDistanceVO;
import com.intermediatestationapp.intermediatestationapp.storage.StationDAO;
import com.intermediatestationapp.intermediatestationapp.utils.CalculateUtil;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 検索結果画面クラス
 */

public class SearchResult extends AppCompatActivity {

    private ArrayList<StationDetailVO> stationList;
    private StationDetailVO resultStation;
    private LatLng centerLatLng;
    private TextView searchResult;
    private TextView searchResultKana;
    // タスクを実行するタイマー
    private Timer timer;
    Handler handler;
    // 点滅状態を保持する
    private boolean isBlink = false;
    // 全アクティビティで使えるアプリケーションクラス
    private MyApplication ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_result);



        // 遷移前画面から入力駅情報リストを受け取る
        Intent intent = getIntent();
        stationList =
                (ArrayList<StationDetailVO>) intent.getSerializableExtra("result");
        // 計算用の緯度と経度のリスト
        ArrayList<Double> latList = new ArrayList<>();
        ArrayList<Double> lngList = new ArrayList<>();
        // 緯度経度を駅情報リストから計算用のリストに格納
        for (StationDetailVO vo : stationList) {

            latList.add(Double.parseDouble(vo.getLat()));
            lngList.add(Double.parseDouble(vo.getLng()));
        }
        // 中間地点座標の取得
        centerLatLng = CalculateUtil.calcCenterLatLng(latList, lngList);
        // 中間地点から近い座標にある駅を調べる
        ArrayList<StationDistanceVO> stationDistanceList
                = CalculateUtil.calcNearStationsList(centerLatLng, getApplicationContext());
        // DB接続のためDAOを生成
        StationDAO dao = new StationDAO(getApplicationContext());
        // 一番先頭にあるVOの駅情報を取得して返却
        resultStation = dao.selectStationByName(stationDistanceList.get(0).getName());
        // 駅名を表示
        searchResult = findViewById(R.id.search_result);
        searchResultKana = findViewById(R.id.search_result_kana);
        searchResult.setText(resultStation.getName());
        searchResultKana.setText(resultStation.getKana());
        // 駅名を点滅させるタイマーを設定する
        timer = new Timer();
        handler = new Handler();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                // 処理をUIスレッドに送る
                handler.post(new Runnable() {
                    public void run() {
                        // 点滅フラグがfalseなら点灯させる
                        if (!isBlink) {
                            searchResult.setTextColor(Color.MAGENTA);
                            searchResultKana.setTextColor(Color.MAGENTA);
                            isBlink = true;
                        } else {
                            searchResult.setTextColor(Color.WHITE);
                            searchResultKana.setTextColor(Color.WHITE);
                            isBlink = false;
                        }
                    }
                });
            }
            // 1000ミリ秒後に1000ミリ秒間隔でタスク実行
        }, 1000, 1000);
    }
}
