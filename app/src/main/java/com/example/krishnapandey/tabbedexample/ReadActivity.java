package com.example.krishnapandey.tabbedexample;

import android.content.res.AssetManager;
import android.graphics.Typeface;
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
        Log.i("Ankit","0 "+title);

        getSupportActionBar().setTitle(title);
        Log.i("Ankit","1 "+title+".txt" );

        WebView webView = (WebView) findViewById(R.id.webView);

        WebSettings ws = webView.getSettings();
        ws.setJavaScriptEnabled(true);



/*
        try{
            String path = "file:///android_asset/" + title+ ".html";
            //webView.loadUrl("file:///android_asset/like.html");
            webView.loadDataWithBaseURL(path);
//            webView.loadDataWithBaseURL("file:///android_asset/","","","","");

        }catch (Exception e){
            Toast.makeText(this, "Document for this file is not available", Toast.LENGTH_SHORT).show();
        }
*/


        String pish = "<html><jfk><style type=\"text/css\">@font-face {font-family: OpenSans-Italic;src: url(\"file:///android_asset/fonts/OpenSans-Italic.ttf\")}body {font-family: OpenSans-Italic;font-size: medium;text-align: justify;}</style></head><body>";
        String pas = "</body></html>";
        String myHtmlString = pish + "hello ankit,hkfjhdsj dfjhdkjfhdkj  fkello dfhe fjdfkjsd dkjhdkjfhdkfhdkj" + pas;
        webView.loadDataWithBaseURL(null,myHtmlString, "text/html", "UTF-8", null);






//        webView.getSettings().setBuiltInZoomControls(true);

        /*ws.setUseWideViewPort(true);
        ws.setLoadWithOverviewMode(true);
*/


//        Typeface font = Typeface.createFromAsset(getAssets(), "OpenSans-ExtraBold.ttf");
//        Typeface face= Typeface.createFromAsset(getAssets(), "OpenSans-ExtraBold.ttf");
        //webView.setTypeface(face);
//        ws.setFixedFontFamily(String.valueOf(font));



    }

}
