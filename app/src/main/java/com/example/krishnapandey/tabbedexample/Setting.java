package com.example.krishnapandey.tabbedexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Setting extends AppCompatActivity {

    private SeekBar seekBar;
    private TextView textViewSize;
    List<String> list = new ArrayList<>();
    private int position=0;

    private Spinner dropdown;

    String title;
    String size;
    private String style;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        size =  getIntent().getExtras().getString("SIZE");
        style =  getIntent().getExtras().getString("STYLE");

        textViewSize = (TextView) findViewById(R.id.textViewSize);
        seekBar = (SeekBar) findViewById(R.id.seekbar);
        seekBar.setMax(10);

        int temp1 = Integer.parseInt(size)/4;
//        seekBar.setProgress(Integer.parseInt(size)/4);

        seekBar.setProgress(temp1);
        textViewSize.setText(String.valueOf(temp1));
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textViewSize.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        setSpinner();

        Button okButton = (Button) findViewById(R.id.okButton);
        Button writeToDevAction = (Button) findViewById(R.id.writeToDevAction);

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int value=seekBar.getProgress();
                String size = String.valueOf(seekBar.getProgress()*4);
                Intent intent = new Intent();
                intent.putExtra("SIZE",size);
                intent.putExtra("STYLE",dropdown.getSelectedItem().toString());
                setResult(RESULT_OK,intent);
                Log.i("Ankit","Exiting Second Activity");
                finish();

            }
        });
        writeToDevAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"ankit.pandey14ap@gmail.com"});
//        i.putExtra(Intent.EXTRA_EMAIL  , arrayList);
                i.putExtra(Intent.EXTRA_SUBJECT, "Banaao Electronics");
//            i.putExtra(Intent.EXTRA_TEXT   , feedbackEditText.getText().toString());
                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(Setting.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    void setSpinner() {
        list.add("OpenSans-Bold");
        list.add("OpenSans-BoldItalic");
        list.add("OpenSans-ExtraBold");
        list.add("OpenSans-ExtraBoldItalic");
        list.add("OpenSans-Italic");
        list.add("OpenSans-Light");
        list.add("OpenSans-LightItalic");
        list.add("OpenSans-Regular");
        list.add("OpenSans-Semibold");
        list.add("OpenSans-SemiboldItalic");

        list.add("microsoft sans serif");
//ubuntu font style
        list.add("Ubuntu-B");
        list.add("Ubuntu-BI");
        list.add("Ubuntu-C");
        list.add("Ubuntu-L");
        list.add("Ubuntu-LI");
        list.add("Ubuntu-M");
        list.add("Ubuntu-MI");
        list.add("Ubuntu-R");
        list.add("Ubuntu-RI");
        list.add("UbuntuMono-B");
        list.add("UbuntuMono-BI");
        list.add("UbuntuMono-R");
        list.add("UbuntuMono-RI");

        String previous = "mayank";
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(style)) {
                position = i;
            }
        }


        dropdown = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown.setAdapter(adapter);

        dropdown.setSelection(position);
        dropdown.getSelectedItem().toString();
        Log.i("Ankit", "Item : "+dropdown.getSelectedItem().toString());

    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        Toast.makeText(this, "Press DONE button to Exit", Toast.LENGTH_SHORT).show();
    }
}

