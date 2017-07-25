package com.sonikpalms.intern.com.sonikpalms.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.sonikpalms.intern.R;
import com.sonikpalms.intern.Receiver;
import com.sonikpalms.intern.MainActivity;


public class FragmentButton extends Fragment {


    private TextView TextView1;
    private Button buttonSend, buttonClear;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_button, container, false);

        Button buttonSend = (Button) v.findViewById(R.id.sendButton);
        Button buttonClear = (Button) v.findViewById(R.id.clearButton);
        final TextView TextView1 = (TextView) v.findViewById(R.id.editText);


        buttonSend.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (TextView1.getText().toString().equals("")) {

                    Toast toastEmptyText = Toast.makeText(getActivity().getApplicationContext(),
                            "Please Enter text!", Toast.LENGTH_SHORT);
                    toastEmptyText.show();

                } else {

                    Intent intent = new Intent(v.getContext(), Receiver.class);
                    intent.putExtra("name", TextView1.getText().toString());
                    startActivityForResult(intent, 1);
                }
            }
        });


        buttonClear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (TextView1.getText().toString().equals("")) {


                    Toast toastEmptyText = Toast.makeText(getActivity().getApplicationContext(),
                            "TextView is Empty!", Toast.LENGTH_SHORT);
                    toastEmptyText.show();


                } else {


                    TextView1.setText("");

                }

            }
        });

        return v;
    }
}