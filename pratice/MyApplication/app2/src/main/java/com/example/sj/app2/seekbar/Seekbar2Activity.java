package com.example.sj.app2.seekbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sj.app2.R;

public class Seekbar2Activity extends AppCompatActivity {
    private SJSeekbar sjSeekbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seekbar2);
        sjSeekbar = (SJSeekbar) findViewById(R.id.sj_seekbar);
//        sjSeekbar.setMax(500);
    }
}
