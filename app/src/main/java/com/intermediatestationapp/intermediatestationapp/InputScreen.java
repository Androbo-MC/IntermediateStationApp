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
public class InputScreen extends AppCompatActivity {

    //カウンター
    private int counter = 0;
    //入力欄を格納するリスト
    private ArrayList<EditText> inputBoxList = new ArrayList<>();
    //入力値を格納するリスト
    private ArrayList<String> inputStationNameList = new ArrayList<>();
    // プログレスバー
    private ProgressDialog dialog = null;


    /**
     * 初期処理
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
        searchButton.setOnClickListener((View.OnClickListener) this);
    }

    /**
     * 検索ボタン押下時の処理
     * @param V
     */
    public void onClick(View V) {

        // 入力値をリストに格納
        for (EditText text : inputBoxList) {
            // 空の入力欄は含まない
            if (!text.getText().toString().isEmpty()) {
                inputStationNameList.add(text.getText().toString());
            }
        }

        // リクエストする
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
    private void getPlaceInfo(){

        // TODO : アニメーションを表示させる
        // プログレスバーを表示
        if (counter == 1){
            dialog = new ProgressDialog(InputScreen.this);
            dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            dialog.setMessage("検索中");
            dialog.setCancelable(false);
            dialog.show();
        }
    }

    /**
     * クリアボタン押下時の処理
     */
    @Override
     protected void onCreate (Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.id.activity_input_screen);
        final EditText inputBox = (EditText) findViewById(R.id.inputBox);

        Button clearButton = (Button) findViewById(R.id.clearButton);
        clearButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                inputBox.setText("");
            }
        });

    }

    /**
     * 設定ボタン押下後の処理
     */
    protected void onCreate (Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView((R.id.avtivity_input_screen));

        Button settingButton = (Button) findViewById(R.id.settingButton);
        settingButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                // TODO : 設定画面表示処理を記述する
            }
        });
    }
}

