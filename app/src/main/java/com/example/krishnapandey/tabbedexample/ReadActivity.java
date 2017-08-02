package com.example.krishnapandey.tabbedexample;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ReadActivity extends AppCompatActivity {

    Toolbar mActionBarToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_read);


        String title = getIntent().getExtras().getString("TITLE");
        //to change title of actionbar
        Log.i("Ankit","0 "+title+".txt" );

        getSupportActionBar().setTitle(title);
        Log.i("Ankit","1 "+title+".txt" );

        WebView webView = (WebView) findViewById(R.id.webView);

        WebSettings ws = webView.getSettings();
        ws.setJavaScriptEnabled(true);

        String temp = "like";
        String path = "file:///android_asset/" + temp + ".html";
        webView.loadUrl("file:///android_asset/like.html");
        webView.loadUrl(path);




    }

}
