package com.sonikpalms.intern;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.ListView;

import com.sonikpalms.intern.adapters.MyAdapter;
import com.sonikpalms.intern.com.sonikpalms.fragment.FragmentAccept;
import com.sonikpalms.intern.com.sonikpalms.fragment.FragmentButton;
import com.sonikpalms.intern.com.sonikpalms.fragment.FragmentReject;
import com.sonikpalms.intern.modelclass.MyItems;

import java.util.ArrayList;

import static com.sonikpalms.intern.MainActivity.MyFragmets.BUTTONS_FRAGMENTS;
import static com.sonikpalms.intern.MainActivity.MyFragmets.FRAGMENTS_REJECT;
import static com.sonikpalms.intern.MainActivity.MyFragmets.FRAGMENT_ACCEPT;



public class MainActivity extends AppCompatActivity {

    public enum MyFragmets {FRAGMENT_ACCEPT, FRAGMENTS_REJECT, BUTTONS_FRAGMENTS}

   // private ListView tasksListView;
   // private MyAdapter adapter;
   // private ArrayList<MyItems> items;






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


        if (data != null) {
            if (resultCode == MainActivity.RESULT_CANCELED) {
                Smena(FRAGMENTS_REJECT);

            } else if (resultCode == MainActivity.RESULT_OK)
                Smena(FRAGMENT_ACCEPT);
            else
                Smena(BUTTONS_FRAGMENTS);


        }
    }

    public void Smena(MyFragmets smenaFrag) {

        FragmentManager fragmentManager = getSupportFragmentManager();


        switch (smenaFrag) {
            case BUTTONS_FRAGMENTS:
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, fragmentbut)
                        .commit();
                break;
            case FRAGMENT_ACCEPT:
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, fragmentacc)
                        .commit();
                break;
            case FRAGMENTS_REJECT:
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, fragmentrej)
                        .commit();
                break;
        }


    }


}
