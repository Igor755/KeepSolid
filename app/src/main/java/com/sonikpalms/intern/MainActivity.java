package com.sonikpalms.intern;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;


import com.sonikpalms.intern.com.sonikpalms.fragment.FragmentAccept;
import com.sonikpalms.intern.com.sonikpalms.fragment.FragmentButton;
import com.sonikpalms.intern.com.sonikpalms.fragment.FragmentReject;

public class MainActivity extends AppCompatActivity {

    FragmentButton fragmentButton;
    FragmentAccept fragmentAccept;
    FragmentReject fragmentReject;


    FrameLayout container;

    final static String TAG_1 = "FRAGMENT_BUTTONS";
    final static String TAG_2 = "FRAGMENT_ACCEPT";
    final static String TAG_3 = "FRAGMENT_REJECT";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        container = (FrameLayout) findViewById(R.id.fragment_container);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, new FragmentButton())

                    .commit();


        }
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


       // if (data == null) {
           // return;

     //   } else {

            if (resultCode == RESULT_CANCELED) {
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, fragmentReject);


            } else if (resultCode == RESULT_OK) {
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, fragmentAccept);



            }
            getSupportFragmentManager().beginTransaction().commit();
        }



    }


