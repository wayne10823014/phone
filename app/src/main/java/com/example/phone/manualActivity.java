package com.example.phone;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kongqw.rockerlibrary.view.RockerView;

public class manualActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manuallayout);
        Button button = findViewById(R.id.endbt);
        button.setOnClickListener(new View.OnClickListener() { //點擊後執行跳頁的指令
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(manualActivity.this, intent.class);
                startActivity(intent);
            }
        });

        RockerView roc = (RockerView) findViewById(R.id.rockerView);
        TextView text = findViewById(R.id.text);
        if (roc != null) {
            roc.setCallBackMode(RockerView.CallBackMode.CALL_BACK_MODE_STATE_CHANGE);
            roc.setOnShakeListener(RockerView.DirectionMode.DIRECTION_8, new RockerView.OnShakeListener() {
                @Override
                public void onStart() {
                    text.setText(null);
                }

                @Override
                public void direction(RockerView.Direction direction) {
                    text.setText("方向 :" + direction);
                }

                @Override
                public void onFinish() {
                    text.setText(null);
                }
            });
        }
    }

    public void callsos(View v) {
        dialogcallsos();
    }
    private void dialogcallsos() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("訊息");  //設置標題
        builder.setIcon(R.mipmap.ic_launcher_round); //標題前面那個小圖示
        builder.setMessage("真的要求救嗎?"); //提示訊息

        //確定 取消 一般 這三種按鈕就看你怎麼發揮你想置入的功能囉
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

}