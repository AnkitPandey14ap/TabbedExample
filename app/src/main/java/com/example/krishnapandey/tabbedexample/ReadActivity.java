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

    private WebView webView;
    Toolbar mActionBarToolbar;
    private String title;
    private String tContents="";

    private String textStyle="OpenSans-Bold";
    private String textSize="16px";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_read);


        //to change title of actionbar
        title = getIntent().getExtras().getString("TITLE");

        getSupportActionBar().setTitle(title);
        webView = (WebView) findViewById(R.id.webView);
        WebSettings ws = webView.getSettings();
        ws.setJavaScriptEnabled(true);

        Log.i("Ankit", tContents);

        setContent();

    }

    private void setContent() {
        
        try {
            InputStream stream = getAssets().open(title+".txt");

            int size = stream.available();
            byte[] buffer = new byte[size];
            stream.read(buffer);
            stream.close();
            tContents = new String(buffer);
            Log.i("Ankit", tContents);
        } catch (IOException e) {
            Toast.makeText(this, e+" File missing", Toast.LENGTH_SHORT).show();
        }
        
//        String pish = "<html><jfk><style type=\"text/css\">@font-face {font-family: OpenSans-Italic;src: url(\"file:///android_asset/fonts/OpenSans-Italic.ttf\")}body {font-family: OpenSans-Italic;font-size: 18px;text-align: justify;}</style></head><body>";


        String pish = "<html>" +
                "<jfk>" +
                "<style type=\"text/css\">" +
                "@font-face {" +
                "font-family: " +
                textStyle+
                ";" +
                "src: url(\"file:///android_asset/fonts/" +
                textStyle +
                ".ttf\")}" +
                "body {" +
                "font-family: " +
                textStyle +
                ";" +
                "font-size: " +
                textSize +
                ";" +
                "text-align: justify;" +
                "}" +
                "</style>" +
                "</head>" +
                "<body>";

        String pas = "</body></html>";

        String myHtmlString = pish + tContents+ pas;
        webView.loadDataWithBaseURL(null,myHtmlString, "text/html", "UTF-8", null);






//        webView.getSettings().setBuiltInZoomControls(true);

        /*ws.setUseWideViewPort(true);
        ws.setLoadWithOverviewMode(true);
*/


    }

}
