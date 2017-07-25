package com.sonikpalms.intern;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.sonikpalms.intern.com.sonikpalms.fragment.FragmentAccept;
import com.sonikpalms.intern.com.sonikpalms.fragment.FragmentButton;

import static android.app.PendingIntent.getActivity;
import static android.content.Intent.EXTRA_EMAIL;

public class Receiver extends AppCompatActivity implements View.OnClickListener {


    private TextView static_text;
    private Button acceptButton, rejectButton;


    public static Intent newIntent(Context packageContext, String email) {
        Intent i = new Intent(packageContext, Receiver.class);
        i.putExtra(EXTRA_EMAIL, email);
        return i;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        static_text = (TextView) findViewById(R.id.static_text);
        acceptButton = (Button) findViewById(R.id.accept_button);
        rejectButton = (Button) findViewById(R.id.reject_button);

        // Принимаем имя
        String txtName = getIntent().getStringExtra("name");
        static_text.setText(static_text.getText().toString() + " " + txtName);

        acceptButton.setOnClickListener(this);
        rejectButton.setOnClickListener(this);
    }
        @Override
        public void onClick(View view){
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


