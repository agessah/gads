package com.apocatech.leaderboard;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class SubmitActivity extends AppCompatActivity {

    private Context context = SubmitActivity.this;
    private AppCompatActivity activity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);

        Toolbar toolbar = findViewById(R.id.toolbar);
        //toolbar.setTitle("");
        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity.class);
                context.startActivity(intent);
                activity.finish();
            }
        });

    }



}
