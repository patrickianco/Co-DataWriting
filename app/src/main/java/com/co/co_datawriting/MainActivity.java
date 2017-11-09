package com.co.co_datawriting;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Externalizable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data = (EditText) findViewById(R.id.username);
    }

    public void saveInternalCache(View view){
        File folder = getCacheDir();
        File file = new File(folder, "sampleInternalCache.txt");
        String message = data.getText().toString();
        FileOutputStream fos = null;

        try{
            fos = new FileOutputStream(file);
            fos.write(message.getBytes());

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Toast.makeText(this, "Saved in Internal Cache!", Toast.LENGTH_LONG).show();
    }

    public void saveExternalCache(View view){
        File folder = getExternalCacheDir();
        File file = new File(folder, "sampleExternalCache.txt");
        String message = data.getText().toString();
        FileOutputStream fos = null;

        try{
            fos = new FileOutputStream(file);
            fos.write(message.getBytes());

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Toast.makeText(this, "Saved in External Cache!", Toast.LENGTH_LONG).show();
    }

    public void saveExternalStorage(View view){
        File folder = getExternalFilesDir("temp");
        File file = new File(folder, "sampleExternalStorage.txt");
        String message = data.getText().toString();
        writeData(file, message);
        Toast.makeText(this, "Saved in External Storage!", Toast.LENGTH_LONG).show();
    }

    public void saveExternalPublic(View view){
        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File file = new File(folder, "sampleExternalPublic.txt");
        String message = data.getText().toString();
        writeData(file, message);
        Toast.makeText(this, "Saved in Downloads Folder!", Toast.LENGTH_LONG).show();
    }

    public void nextActivity(View view){
        Intent intent = new Intent(this, Results.class);
        startActivity(intent);
    }

    public void writeData(File file, String message){
        FileOutputStream fos = null;

        try{
            fos = new FileOutputStream(file);
            fos.write(message.getBytes());

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
