package com.sonikpalms.intern.com.sonikpalms.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.sonikpalms.intern.MainActivity;
import com.sonikpalms.intern.R;

import static com.sonikpalms.intern.MainActivity.MyFragmets.BUTTONS_FRAGMENTS;


public class FragmentReject extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_reject, container, false);

        Button buttonReject = (Button) v.findViewById(R.id.buttonReject);
        buttonReject.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (getActivity() instanceof MainActivity) {
                    ((MainActivity) getActivity()).Smena(BUTTONS_FRAGMENTS);
                }
            }
        });

        return v;
    }
}