package com.sonikpalms.intern;

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

public class Receiver extends AppCompatActivity {


    private TextView static_text;
    private Button acceptButton, rejectButton;


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


        acceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {








                Intent intent = new Intent(view.getContext(), MainActivity.class);

                startActivity(intent);

                Toast toastAccept = Toast.makeText(getApplicationContext(),
                        "Accept!", Toast.LENGTH_SHORT);


                toastAccept.show();


            }

        });
        rejectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent();
                intent.putExtra("name", static_text.getText().toString());
                setResult(RESULT_OK, intent);



                finish();
                Toast toastReject = Toast.makeText(getApplicationContext(),
                        "Reject!", Toast.LENGTH_SHORT);
                toastReject.show();



            }
        });


    }

}
