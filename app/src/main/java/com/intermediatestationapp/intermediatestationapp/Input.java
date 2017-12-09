package com.intermediatestationapp.intermediatestationapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;

import java.util.ArrayList;

/**
 * 入力画面
 */
public class Input extends AppCompatActivity {

    //カウンター
    private int counter = 0;
    //入力欄を格納するリスト
    private ArrayList<AutoCompleteTextView> inputBoxList = new ArrayList<>();
    //入力値を格納するリスト
    private ArrayList<String> inputStationNameList = new ArrayList<>();
    // プログレスバー
//    private ProgressDialog dialog = null;


    /**
     *
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input);

        // 入力欄をリストに格納
        inputBoxList.add((AutoCompleteTextView) findViewById(R.id.inputBox1));
        inputBoxList.add((AutoCompleteTextView) findViewById(R.id.inputBox2));
        inputBoxList.add((AutoCompleteTextView) findViewById(R.id.inputBox3));
        inputBoxList.add((AutoCompleteTextView) findViewById(R.id.inputBox4));
        inputBoxList.add((AutoCompleteTextView) findViewById(R.id.inputBox5));

    }

    /**
     * 検索ボタン押下時の処理
     * @param
     */
//    @Override
    public void searchButtonOnClick(View view) {
        // 入力値をリストに格納
        for (AutoCompleteTextView text : inputBoxList) {
            // 空の入力欄は含まない
            if (!text.getText().toString().isEmpty()) {
                inputStationNameList.add(text.getText().toString());
            }
        }

        // 位置情報取得メソッドに入力値を渡す。
        for (String text : inputStationNameList){
            if (null != text && !text.isEmpty()){
                counter++;
                getPlaceInfo(text);
            }
        }

    }

    /**
     * 位置情報を取得
     */
    private void getPlaceInfo(String text){

        // TODO : DBから値を取得。

    }

    /**
     * クリアボタン押下時の処理
     */
    public void clearButtonOnClick(View view){

        // 全ての入力欄に空文字を設定する。
        for (AutoCompleteTextView inputBox : inputBoxList){
            inputBox.setText("");
        }

    }


    /**
     * 設定ボタン押下後の処理
     */
    public void settingButtonOnClick(View view){
        // TODO:設定画面を表示する処理を記述する。
    }


}

