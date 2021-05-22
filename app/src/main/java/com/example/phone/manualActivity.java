package com.example.phone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.kongqw.rockerlibrary.view.RockerView;

public class manualActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manuallayout);
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
}