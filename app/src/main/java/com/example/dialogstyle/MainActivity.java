package com.example.dialogstyle;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

/**
 * 7种形式的Android Dialog应用举例
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btn_01,btn_02,btn_03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        btn_01=(Button)this.findViewById(R.id.btn_one);
        btn_02=(Button)this.findViewById(R.id.btn_two);
        btn_03=(Button)this.findViewById(R.id.btn_three);

        btn_01.setOnClickListener(this);
        btn_02.setOnClickListener(this);
        btn_03.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_one:
                startActivity(new Intent(this,DialogOneStyleActivity.class));
                break;
            case R.id.btn_two:
                startActivity(new Intent(this, DialogTwoStyleActivity.class));
                break;
            case R.id.btn_three:
                new CustomPromptDialog(this).showPromptDialog(this);
                break;
            default:
                break;
        }
    }

}
