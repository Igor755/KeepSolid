package com.sonikpalms.intern;
import android.app.ProgressDialog;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;


//import static com.sonikpalms.intern.modelclass.MyItems.Category.Family;


public class Receiver extends AppCompatActivity implements View.OnClickListener {


    //private TextView userName, category_item, email_item;
    private Button acceptButton, rejectButton;
    // private RadioButton isOnline;
    private WebView webView;
    private SwipeRefreshLayout reload;
    private int mCycle = 0;
    private ProgressBar progressBar;
    private ProgressDialog Indicator;
    private final int totalProgressTime = 20;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_receiver);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        Intent intent = getIntent();
        webView.loadUrl(intent.getStringExtra("newsURL"));
        webView.setWebViewClient(new MyWebViewClient());




        acceptButton = (Button) findViewById(R.id.accept_button);
        rejectButton = (Button) findViewById(R.id.reject_button);
        acceptButton.setOnClickListener(this);
        rejectButton.setOnClickListener(this);


        //progressBar = (ProgressBar) findViewById(R.id.progressBar);







        Indicator = new ProgressDialog(this);
        //Настраиваем для ProgressDialog название его окна:
        Indicator.setMessage(getResources().getString(R.string.load));
        //Настраиваем стиль отображаемого окна:
        Indicator.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        //Выставляем прогресс задачи на 0 позицию:
        Indicator.setProgress(0);
        //Устанавливаем максимально возможное значение в работе цикла:
        Indicator.setMax(totalProgressTime );
        Indicator.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        //Отображаем ProgressDialog:
        Indicator.show();

        //Создаем параллельный поток с выполнением цикла, который будет
        //работать, пока не достигнет значения в 20 (totalProgressTime):
        new Thread(new Runnable() {
            @Override
            public void run(){
                int counter = 0;
                while(counter < totalProgressTime ){
                    try {
                        //Устанавливаем время задержки между итерациями
                        //цикла (между действиями цикла):
                        Thread.sleep(300);
                        counter ++;
                        //Обновляем индикатор прогресса до значения counter:
                        Indicator.setProgress(counter);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }


                //При завершении работы цикла закрываем наш ProgressDialog:
                Indicator.dismiss();
            }
        }).start();
    }
    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }


    }



    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }



    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.accept_button:
                setResult(RESULT_OK, intent);
                finish();
                break;
            case R.id.reject_button:
                setResult(RESULT_CANCELED, intent);
                finish();
                break;
        }
    }
}


