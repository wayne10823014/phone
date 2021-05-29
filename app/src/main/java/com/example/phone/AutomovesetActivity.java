package com.example.phone;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class AutomovesetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_automoveset);
        VideoView videoView = findViewById(R.id.video_view);
        videoView.setVideoPath("https://1251316161.vod2.myqcloud.com/007a649dvodcq1251316161/624d728a5285890807706381611/IkYAiI8Tc8kA.mp4");
        videoView.start();
        MediaController mediaController = new MediaController(this);
//        videoView.setMediaController(mediaController);
        mediaController.setMediaPlayer(videoView);
        videoView.setMediaController(null);
    }
    public void stop(View v){
        VideoView videoView = findViewById(R.id.video_view);
        videoView.pause();
        dialog();
    }
    private void dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("訊息");  //設置標題
        builder.setIcon(R.mipmap.ic_launcher_round); //標題前面那個小圖示
        builder.setMessage("確定要跟隨此目標嗎?"); //提示訊息

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