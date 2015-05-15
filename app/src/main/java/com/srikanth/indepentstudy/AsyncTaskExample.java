package com.srikanth.indepentstudy;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by srikanth on 5/14/15.
 */
public class AsyncTaskExample extends ActionBarActivity implements View.OnClickListener {

    private ProgressBar progressBar;
    private Button startDownload;
    private TextView status;
    private int progressStatus = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);
        status = (TextView) findViewById(R.id.status);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);
        startDownload = (Button) findViewById(R.id.start_download);
        startDownload.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.start_download) {
            new DownloaderAsyncTask().execute();
        }
    }

    private class DownloaderAsyncTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressStatus = 0;
            status.setText("Status : Hit button to start download");
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            status.setText("Status : Download finished");
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
            status.setText("Status : Download in progress");
        }

        @Override
        protected Void doInBackground(Void... params) {
            startThread();
            return null;
        }

        private void startThread() {
            publishProgress();
            while (progressStatus < 100) {
                progressStatus++;
                progressBar.setProgress(progressStatus);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
