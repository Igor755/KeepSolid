package com.sonikpalms.intern;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.sonikpalms.intern.com.sonikpalms.fragment.FragmentAccept;
import com.sonikpalms.intern.com.sonikpalms.fragment.FragmentButton;
import com.sonikpalms.intern.com.sonikpalms.fragment.FragmentReject;

import static com.sonikpalms.intern.MyFragments.FRAGMENT_ACCEPT;
import static com.sonikpalms.intern.MyFragments.FRAGMENT_REJECT;


enum MyFragments { MAIN_FRAGMENT, FRAGMENT_ACCEPT, FRAGMENT_REJECT}

//import static android.R.attr.id;

//import static com.sonikpalms.intern.R.*;

public class MainActivity extends AppCompatActivity {


    public Fragment fragmentbut, fragmentacc, fragmentrej;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



         fragmentbut = new FragmentButton();
         fragmentacc = new FragmentAccept();
         fragmentrej = new FragmentReject();

        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction()
             .add(R.id.fragment_container, fragmentbut)
             .commit();

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


        System.out.println("232323223333333333333333333333333333333333333333333333333333333333333333333333");

        if (data != null) {
            if (resultCode == MainActivity.RESULT_OK) {
                Smena(FRAGMENT_ACCEPT);
            } else {
                Smena(FRAGMENT_REJECT);

            }
        }

    }
    public void Smena(MyFragments smenaFrag) {

        FragmentManager fm = getSupportFragmentManager();
        System.out.println("23232322222222222222222222222222222222222222222222222222222");

        switch (smenaFrag){
            case MAIN_FRAGMENT:
                fm.beginTransaction()
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .replace(R.id.fragment_container, fragmentbut)
                        .commit();
                break;
            case FRAGMENT_ACCEPT:
                fm.beginTransaction()
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .replace(R.id.fragment_container, fragmentacc)
                        .commit();
                break;
            case FRAGMENT_REJECT:
                fm.beginTransaction()
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .replace(R.id.fragment_container, fragmentacc)
                        .commit();
                break;
        }



        }


    }
