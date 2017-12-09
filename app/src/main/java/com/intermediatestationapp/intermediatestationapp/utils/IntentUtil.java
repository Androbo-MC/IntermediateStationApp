package com.intermediatestationapp.intermediatestationapp.utils;

import android.content.Context;
import android.content.Intent;

import com.intermediatestationapp.intermediatestationapp.AreaInformation;
import com.intermediatestationapp.intermediatestationapp.Input;
import com.intermediatestationapp.intermediatestationapp.SearchResult;
import com.intermediatestationapp.intermediatestationapp.models.StationVO;

import java.util.ArrayList;

/**
 * 画面遷移準備共通クラス
 */

public class IntentUtil {

    /**
     * 入力画面への遷移準備
     *
     * @param context コンテキスト(実行中ActivityのthisでOK)
     * @return Intent 画面遷移に必要な情報を保持したIntent
     */
    public static Intent prepareForInputScreen(Context context) {

        // メイン画面には何も送らないでそのまま返却
        return new Intent(context, Input.class);
    }

    /**
     * 検索結果画面への遷移準備
     *
     * @param context コンテキスト(実行中のActivityのthisでOK)
     * @param stationList 入力されていた駅情報のリスト
     * @return Intent 画面遷移に必要な情報を保持したIntent
     */
    public static Intent prepareForSearchResult(Context context, ArrayList<StationVO> stationList) {

        // 入力されていた駅情報のリストを次の画面に送る準備
        Intent intent = new Intent(context, SearchResult.class)
                .putExtra("result", stationList);
        return intent;
    }

    /**
     * 周辺情報画面への遷移準備
     *
     * @param context コンテキスト(実行中ActivityのthisでOK)
     * @param stationList 入力されていた駅情報のリスト
     * @param resultVO 検索結果として選ばれた候補の駅
     * @return Intent 画面遷移に必要な情報を保持したIntent
     */
    public static Intent prepareForAreaInformation(Context context, ArrayList<StationVO> stationList, StationVO resultVO) {

        // 入力されていた駅情報のリストと候補駅を次の画面に送る準備
        Intent intent = new Intent(context, AreaInformation.class)
                .putExtra("stationList", stationList)
                .putExtra("resultStation", resultVO);
        return intent;
    }
}
