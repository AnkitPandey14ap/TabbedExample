package com.example.krishnapandey.tabbedexample;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
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
    private String textSize="";
    private int result=50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_read);

        //to change title of actionbar
        title = getIntent().getExtras().getString("TITLE");

        textSize=String.valueOf(16);

        getSupportActionBar().setTitle(title);
        webView = (WebView) findViewById(R.id.webView);
        WebSettings ws = webView.getSettings();
        ws.setJavaScriptEnabled(true);

        //Log.i("Ankit", tContents);

        setContent(textSize);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_read_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(ReadActivity.this,Setting.class);
            i.putExtra("SIZE", textSize);
            startActivityForResult(i, result);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private void setContent(String textSize) {
        if(textSize=="0") {
            textSize = "16";
        }
        try {
            InputStream stream = getAssets().open(title+".txt");

            int size = stream.available();
            byte[] buffer = new byte[size];
            stream.read(buffer);
            stream.close();
            tContents = new String(buffer);

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
                "px;" +
                "text-align: justify;" +
                "}" +
                "</style>" +
                "</head>" +
                "<body>";

        Log.i("Ankit", textSize+" hrllo");
        String pas = "</body></html>";

        String myHtmlString = pish + tContents+ pas;
        webView.loadDataWithBaseURL(null,myHtmlString, "text/html", "UTF-8", null);






//        webView.getSettings().setBuiltInZoomControls(true);

        /*ws.setUseWideViewPort(true);
        ws.setLoadWithOverviewMode(true);
*/


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==50)
        {
            Log.i("Ankit", textSize+" result");

            String message=data.getStringExtra("SIZE");
            textSize = message;
            setContent(textSize);

        }
    }

}
