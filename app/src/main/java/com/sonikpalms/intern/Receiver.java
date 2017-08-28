package com.sonikpalms.intern;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.sonikpalms.intern.Animation.TinglingSquaresView;
import com.sonikpalms.intern.modelclass.MyItems;

//import static com.sonikpalms.intern.modelclass.MyItems.Category.Family;


public class Receiver extends AppCompatActivity implements View.OnClickListener {


    //private TextView userName, category_item, email_item;
    private Button acceptButton, rejectButton;
    // private RadioButton isOnline;
    private WebView webView;
    private SwipeRefreshLayout reload;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_receiver);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        acceptButton = (Button) findViewById(R.id.accept_button);
        rejectButton = (Button) findViewById(R.id.reject_button);
        acceptButton.setOnClickListener(this);
        rejectButton.setOnClickListener(this);

        final TinglingSquaresView tsv = (TinglingSquaresView) findViewById(R.id.tinglingSquaresView);
        tsv.runAnimation(9);





                webView = (WebView) findViewById(R.id.webView);
                //webView.loadUrl("http://www.example.com");

                webView.getSettings().setJavaScriptEnabled(true);
                Intent intent = getIntent();
                webView.loadUrl(intent.getStringExtra("newsURL"));


                webView.setWebViewClient(new MyWebViewClient());



    }
    @Override
    public void onBackPressed() {
        if(webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
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


