package com.intermediatestationapp.intermediatestationapp;

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
public class InputScreen extends AppCompatActivity {

    //入力欄をArrayListに格納
    private ArrayList<EditText> inputBoxList = new ArrayList<>();
    //カウンター
    private int counter = 0;
    //入力値をArrayListに格納
    private ArrayList<String> inputStationNameList = new ArrayList<>();

    /**
     * 初期状態でactivityを作成
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_screen);

        //入力されたテキストボックスの値を取得し、配列リストに設定
        //inputBoxList.add((EditText) findViewById(R.id.inputBox1));
        //カウンターを初期化
        counter = 0;
        //検索ボタンを取得
        Button searchButton = (Button)findViewById(R.id.searchButton);
        searchButton.setOnClickListener((View.OnClickListener) this);
    }

    /**
     * 検索ボタン押下時の処理
     * @param V
     */
    public void onClick(View V) {

        //入力欄の値を取得する
        for (EditText inputBox : inputBoxList) { //入力値をinputBoxListに格納
            if (!inputBox.getText().toString().isEmpty()); //空のテキストボックスではないとき

                inputStationNameList.add(inputBox.getText().toString()); //inputStationNameListに
        }

        //
        for (String inputBox : inputStationNameList) {
            if (null != inputBox && !inputBox.isEmpty()) {
                counter++;

            }
        }

    }
}
