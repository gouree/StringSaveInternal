package com.example.gouree.stringsaveinternal;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    //Edit text and button
    EditText e;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting values
        e=(EditText)findViewById(R.id.stringval);
        b=(Button)findViewById(R.id.button);

        //on click of button
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //create file name goureefile
                String FILENAME = "goureefile";

                //fetch value from edit text to string
                String string = e.getText().toString();

                //file output stream
                FileOutputStream fos = null;
                try {
                    //open file
                    fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
                try {

                    //write the string in file
                    fos.write(string.getBytes());
                    Toast.makeText(MainActivity.this, "File saved in internal memory", Toast.LENGTH_SHORT).show();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                try {

                    //closing the file
                    fos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

    }


}
