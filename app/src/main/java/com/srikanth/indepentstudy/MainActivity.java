package com.srikanth.indepentstudy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private Button asyncTask;
    private Button loader;
    private Button rxJava;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        asyncTask = (Button) findViewById(R.id.asynctask);
        loader = (Button) findViewById(R.id.loader);
        rxJava = (Button) findViewById(R.id.rxjava);
        asyncTask.setOnClickListener(this);
        loader.setOnClickListener(this);
        rxJava.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent intent = null;
        if (v.getId() == R.id.asynctask) {
            intent = new Intent(this, AsyncTaskExample.class);
        } else if (v.getId() == R.id.loader) {
            intent = new Intent(this, LoaderExample.class);
        } else if (v.getId() == R.id.rxjava) {
            intent = new Intent(this, RxJavaExample.class);
        }
        startActivity(intent);
    }

}
