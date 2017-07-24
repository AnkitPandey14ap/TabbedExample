package com.example.krishnapandey.tabbedexample;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
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


        TextView textView = (TextView) findViewById(R.id.textView);

        String txt="";

        Log.i("Ankit","2 "+title+".txt" );

        try{
//            InputStream is = getAssets().open("hello.txt");
            Log.i("Ankit","3 "+title+".txt" );
            InputStream is = getAssets().open(title+".txt");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            txt = new String(buffer);



        }catch (IOException e){
            Toast.makeText(this,"Error: "+e, Toast.LENGTH_SHORT).show();
        }
        textView.setText(txt);

    }

}
