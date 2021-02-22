package com.example.dataapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExternalStorage extends AppCompatActivity {
    // After API 23 the permission request for accessing external storage is changed
    // Before API 23 permission request is asked by the user during installation of app
    // After API 23 permission request is asked at runtime
    private int EXTERNAL_STORAGE_PERMISSION_CODE = 23;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_storage);

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                EXTERNAL_STORAGE_PERMISSION_CODE);
        // findViewById return a view, we need to cast it to EditText View
        editText = (EditText) findViewById(R.id.editText_data);
    }

    public void savePublicly(View view) {
        // Requesting Permission to access External Storage

        String editTextData = editText.getText().toString();

        // getExternalStoragePublicDirectory() represents root of external storage, we are using DOWNLOADS
        // We can use following directories: MUSIC, PODCASTS, ALARMS, RINGTONES, NOTIFICATIONS, PICTURES, MOVIES
        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);

        // Storing the data in file with name as vasad.txt
        File file = new File(folder, "vasad.txt");
        writeTextData(file, editTextData);
        editText.setText("");
    }

    public void savePrivately(View view) {
        String editTextData = editText.getText().toString();

        // Creating folder with name vasad
        File folder = getExternalFilesDir("vasad");

        // Creating file with name svit.txt
        File file = new File(folder, "svit.txt");
        writeTextData(file, editTextData);
        editText.setText("");
    }

    public void viewInformation(View view) {
        // Creating an intent to start a new activity
        Intent intent = new Intent(ExternalStorage.this, ViewInformationActivity.class);
        startActivity(intent);
    }

    // writeTextData() method save the data into the file in byte format
    // It also toast a message "Done/filepath_where_the_file_is_saved"
    private void writeTextData(File file, String data) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(data.getBytes());
            Toast.makeText(this, "Done" + file.getAbsolutePath(), Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}