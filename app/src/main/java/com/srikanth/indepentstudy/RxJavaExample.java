package com.srikanth.indepentstudy;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by srikanth on 5/14/15.
 */
public class RxJavaExample extends ActionBarActivity {

    Integer[] numbers = new Integer[100];
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);
        for (int i = 0; i < 100; i++) {
            numbers[i] = i;
        }
        progressBar = (ProgressBar) findViewById(R.id.progressbar);
        ((TextView) findViewById(R.id.title)).setText("RxJava Demo");
        ((Button) findViewById(R.id.start_download)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // myObservable.subscribe(mySubscriber);
                numberObservable.subscribe(mySubscriber);
            }
        });
    }


    Observable numberObservable = Observable.from(numbers);

    /* Observable<Integer> myObservable = Observable.create(
             new Observable.OnSubscribe<Integer>() {
                 @Override
                 public void call(Subscriber<? super Integer> sub) {
                         sub.onNext(numbers);
                 }
             }
     ); */
    Subscriber<Integer> mySubscriber = new Subscriber<Integer>() {
        @Override
        public void onCompleted() {
            Log.v("Testing", "observer called completed");
        }


        @Override
        public void onError(Throwable e) {
            Toast.makeText(RxJavaExample.this, "Error occurred", Toast.LENGTH_SHORT).show();
        }


        @Override
        public void onNext(Integer s) {
            Log.v("Testing", "The data is " + s);
            progressBar.setProgress(s);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Toast.makeText(RxJavaExample.this, "It works", Toast.LENGTH_SHORT).show();
        }
    };

}
