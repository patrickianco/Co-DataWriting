package com.co.co_datawriting;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Results extends AppCompatActivity {

    TextView display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        display = (TextView) findViewById(R.id.displayMessage);
    }

    public void loadInternalCache(View view){
        String filename = "sampleInternalCache.txt";
        File dir = getCacheDir();

        loadData(filename, dir);
    }

    public void loadExternalCache(View view){
        String filename = "sampleExternalCache.txt";
        File dir = getExternalCacheDir();
        loadData(filename, dir);
    }

    public void loadExternalStorage(View view){
        String filename = "sampleExternalStorage.txt";
        File dir = getExternalFilesDir("temp");
        loadData(filename, dir);
    }

    public void loadExternalPublic(View view){
        String filename = "sampleExternalPublic.txt";
        File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        loadData(filename, dir);
    }

    public void loadData(String filename, File dir){
        StringBuffer buffer = new StringBuffer();
        int read = 0;
        try{
            FileInputStream fis = new FileInputStream(new File(dir, filename));
            while((read = fis.read()) != -1){
                buffer.append((char) read);
            }
            display.setText(buffer.toString());
            fis.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void goBack(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
