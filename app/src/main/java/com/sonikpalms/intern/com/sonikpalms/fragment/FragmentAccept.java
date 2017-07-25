package com.sonikpalms.intern.com.sonikpalms.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.sonikpalms.intern.MainActivity;
import com.sonikpalms.intern.R;

import static android.app.Activity.RESULT_OK;

//enum CurrentSelectedFragment {
  //  MAIN_FRAGMENT,
   // TWO_FRAGMENT,
   // THREE_FRAGMENT

public class FragmentAccept extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_accept,container, false);

        Button button = (Button) v.findViewById(R.id.buttonAccept);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               // (RESULT_OK);
                //finish();

            }
        });

        return v;
    }
}