package com.intermediatestationapp.intermediatestationapp;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * 入力画面
 */
public class InputScreen extends AppCompatActivity implements View.OnClickListener{

    //カウンター
    private int counter = 0;
    //入力欄を格納するリスト
    private ArrayList<EditText> inputBoxList = new ArrayList<>();
    //入力値を格納するリスト
    private ArrayList<String> inputStationNameList = new ArrayList<>();
    // プログレスバー
//    private ProgressDialog dialog = null;


    /**
     * コンストラクタ
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_screen);

        // 入力欄をリストに格納
        inputBoxList.add((EditText) findViewById(R.id.inputBox1));
        inputBoxList.add((EditText) findViewById(R.id.inputBox2));
        inputBoxList.add((EditText) findViewById(R.id.inputBox3));
        inputBoxList.add((EditText) findViewById(R.id.inputBox4));
        inputBoxList.add((EditText) findViewById(R.id.inputBox5));

        // カウンターを初期化
        counter = 0;

        // 検索ボタンを取得
        Button searchButton = (Button)findViewById(R.id.searchButton);
        searchButton.setOnClickListener(this);

        // 設定ボタンを取得
        Button settingButton = (Button)findViewById(R.id.settingButton);
        settingButton.setOnClickListener(this);

        // クリアボタンを取得
        Button clearButton = (Button)findViewById(R.id.clearButton);
        clearButton.setOnClickListener(this);
    }

    /**
     * 検索ボタン押下時の処理
     * @param V
     */
//    public void SearchButtonOnClick(View V) {
//
//        // 入力値をリストに格納
//        for (EditText text : inputBoxList) {
//            // 空の入力欄は含まない
//            if (!text.getText().toString().isEmpty()) {
//                inputStationNameList.add(text.getText().toString());
//            }
//        }
//
//        // 位置情報取得メソッドに入力値を渡す。
//        for (String text : inputStationNameList){
//            if (null != text && !text.isEmpty()){
//                counter++;
//                getPlaceInfo(text);
//            }
//        }
//    }

    /**
     * 位置情報を取得
     */
    private void getPlaceInfo(String text){

        // TODO : プログレスバーは仮。アニメーションを表示するよう変更する。
        // プログレスバーを表示
//        if (counter == 1){
//            dialog = new ProgressDialog(InputScreen.this);
//            dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
//            dialog.setMessage("検索中");
//            dialog.setCancelable(false);
//            dialog.show();
//        }
    }

    /**
     * クリアボタン押下時の処理
     */
    private void ClearButtonOnClick(View V){

        // 入力欄1をクリアする。
        EditText inputBox1 = new EditText(this);
        inputBox1.getEditableText().clear();

        // 入力欄2をクリアする。
        EditText inputBox2 = new EditText(this);
        inputBox2.getEditableText().clear();

        // 入力欄3をクリアする。
        EditText inputBox3 = new EditText(this);
        inputBox3.getEditableText().clear();

        // 入力欄4をクリアする。
        EditText inputBox4 = new EditText(this);
        inputBox4.getEditableText().clear();

        // 入力欄5をクリアする。
        EditText inputBox5 = new EditText(this);
        inputBox5.getEditableText().clear();

    }


    /**
     * 設定ボタン押下後の処理
     */
    private void SettingButtonOnClick(View V){
        // TODO:設定画面を表示する処理を記述する。
    }

    @Override
    public void onClick(View view) {
        // 入力値をリストに格納
        for (EditText text : inputBoxList) {
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
}

