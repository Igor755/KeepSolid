package com.sonikpalms.intern.Link;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.sonikpalms.intern.R;
import com.sonikpalms.intern.adapters.MyAdapter;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.sql.Statement;
import java.util.prefs.Preferences;

import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import okhttp3.CertificatePinner;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



/**
 * Created by Sonikpalms on 10.08.2017.
 *
 * 1)javax.net.ssl.SSLHandshakeException: java.security.cert.CertPathValidatorException: Trust anchor for certification path not found.
 * Decided by https://stackoverflow.com/questions/27716001/how-to-post-https-request-using-retrofit
 * create getUnsafeOkHttpClient and add
 * .client(getUnsafeOkHttpClient()) in retrofit
 */

public class RetroClient {

    private static final String URL = "https://newsapi.org/";
    //private String keyStore = "f95725ad56c04956b0f37a5a4e1d36b1";
    private static Gson gson = new GsonBuilder().create();





    private static Retrofit getRetrofitInstance() {

        return new Retrofit.Builder()


                //.setLogLevel(MyAdapter.LogLevel.FULL)
                .baseUrl(URL)
                .client(getUnsafeOkHttpClient())
                //.setClient(new OkClient(StartingActivity.trustTestClient))
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }


    // private Link inter = retrofit.create(Link.class);

    public static Link getApiService() {
        return getRetrofitInstance().create(Link.class);
    }
    public static OkHttpClient getUnsafeOkHttpClient() {

        try {
            // Create a trust manager that does not validate certificate chains
            final TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
                @Override
                public void checkClientTrusted(
                        java.security.cert.X509Certificate[] chain,
                        String authType) throws CertificateException {
                }

                @Override
                public void checkServerTrusted(
                        java.security.cert.X509Certificate[] chain,
                        String authType) throws CertificateException {
                }

                @Override
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return new java.security.cert.X509Certificate[0];
                }
            } };

            // Install the all-trusting trust manager
            final SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustAllCerts,
                    new java.security.SecureRandom());
            // Create an ssl socket factory with our all-trusting manager
            final SSLSocketFactory sslSocketFactory = sslContext
                    .getSocketFactory();

            OkHttpClient okHttpClient = new OkHttpClient();
            okHttpClient = okHttpClient.newBuilder()
                    .sslSocketFactory(sslSocketFactory)
                    .hostnameVerifier(org.apache.http.conn.ssl.SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER).build();

            return okHttpClient;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


}
