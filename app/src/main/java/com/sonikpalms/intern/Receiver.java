package com.sonikpalms.intern;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.sonikpalms.intern.modelclass.MyItems;

import static com.sonikpalms.intern.modelclass.MyItems.Category.Family;


public class Receiver extends AppCompatActivity implements View.OnClickListener {


    private TextView userName, category_item, email_item;
    private Button acceptButton, rejectButton;
    private RadioButton isOnline;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_receiver);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        isOnline = (RadioButton) findViewById(R.id.isOnline);
        userName = (TextView) findViewById(R.id.userName);
        category_item = (TextView) findViewById(R.id.category_item);
        email_item = (TextView) findViewById(R.id.email_item);


        acceptButton = (Button) findViewById(R.id.accept_button);
        rejectButton = (Button) findViewById(R.id.reject_button);

        System.out.println("3333333333333333333333333333333333333333333333333333333333333333333333");


        Intent intent = getIntent();
        userName.setText(intent.getStringExtra("Username"));



        if (intent.getBooleanExtra("UserStatus", true)) {
            isOnline.setChecked(intent.getBooleanExtra("isOnline",true));
        } else {
            isOnline.setChecked(intent.getBooleanExtra("isOnline",false));
        }


        if (intent.getSerializableExtra("UserCategory").equals(MyItems.Category.Family))
        {
            category_item.setText("Family");
        } else if (intent.getSerializableExtra("UserCategory").equals(MyItems.Category.Another)){
            category_item.setText("Another");
        } else if (intent.getSerializableExtra("UserCategory").equals(MyItems.Category.Friend)) {
            category_item.setText("Friend");
        } else {
            category_item.setText("Work");
        }
        email_item.setText(intent.getStringExtra("UserAddress"));



        acceptButton.setOnClickListener(this);
        rejectButton.setOnClickListener(this);
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


