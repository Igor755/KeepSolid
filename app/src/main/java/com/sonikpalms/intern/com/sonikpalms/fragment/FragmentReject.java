package com.sonikpalms.intern.com.sonikpalms.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.sonikpalms.intern.R;



public class FragmentReject extends Fragment {

   public final static String TAG = "FRAGMENT_REJECT";



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_reject,container, false);

        Button buttonReject = (Button) v.findViewById(R.id.buttonReject);


        buttonReject.setOnClickListener((View.OnClickListener) getActivity());


        return v;
    }
}