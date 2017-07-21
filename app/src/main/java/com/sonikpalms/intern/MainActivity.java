package com.sonikpalms.intern;

import android.app.usage.UsageEvents;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;



import static android.R.attr.data;
import static android.R.attr.name;

public class MainActivity extends AppCompatActivity {


    private TextView textView;
    private Button sendButton, clearButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       /* textView = (TextView) findViewById(R.id.editText);
        sendButton = (Button) findViewById(R.id.sendButton);
        clearButton = (Button) findViewById(R.id.clearButton);


        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (textView.getText().toString().equals("")) {

                    Toast toastEmptyText = Toast.makeText(getApplicationContext(),
                            "Please Enter text!", Toast.LENGTH_SHORT);
                    toastEmptyText.show();

                } else {
                    Intent intent = new Intent(view.getContext(), Receiver.class);
                    intent.putExtra("name", textView.getText().toString());
                    startActivityForResult(intent, 1);
                }
            }

        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textView.getText().toString().equals("")) {


                    Toast toastEmptyText = Toast.makeText(getApplicationContext(),
                            "TextView is Empty!", Toast.LENGTH_SHORT);
                    toastEmptyText.show();


                } else {
                    textView.setText("");

                }


            }

        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null) {
            return;
        }
        String name = data.getStringExtra("name");
        textView.setText(name);*/
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
