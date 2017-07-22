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


import com.sonikpalms.intern.R;
import com.sonikpalms.intern.Receiver;


public class FragmentButton extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_button,container, false);

        Button buttonSend = (Button) v.findViewById(R.id.sendButton);
        Button buttonClear = (Button) v.findViewById(R.id.clearButton);
        TextView TextView1 = (TextView) v.findViewById(R.id.editText);

       // Context context = getActivity().getApplicationContext();
        //LinearLayout layout = new LinearLayout(context);
       // layout.addView(buttonSend);
      //  layout.addView(buttonClear);
      //  layout.addView(textView);


        buttonSend.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Receiver.class));
            }
        });
        buttonClear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {



            }
        });

        return v;
    }
}