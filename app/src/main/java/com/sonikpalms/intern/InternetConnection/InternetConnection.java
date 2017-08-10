package com.sonikpalms.intern.InternetConnection;

import android.content.Context;
import android.net.ConnectivityManager;
import android.support.annotation.NonNull;

/**
 * Created by Sonikpalms on 10.08.2017.
 */

public class InternetConnection {

    public static boolean checkConnection(@NonNull Context context){
        return ((ConnectivityManager) context.getSystemService
                (Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo() != null;
    }
}
