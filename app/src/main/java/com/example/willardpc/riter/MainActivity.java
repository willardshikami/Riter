package com.example.willardpc.riter;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.CursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insertNote("New note");

        Cursor cursor = getContentResolver().query(NotesProvider.CONTENT_URI, DBOpenHelper.ALL_COLUMNS, null, null, null, null);

        String from = (DBOpenHelper.NOTE_TEXT);
        int[] to = {android.R.id.text1};
        CursorAdapter cursorAdapter


    }


    private void insertNote(String noteText) {
        ContentValues values = new ContentValues();
        values.put(DBOpenHelper.NOTE_TEXT, noteText);
        Uri noteUri = getContentResolver().insert(NotesProvider.CONTENT_URI, values);

        Log.d("MainActivity", "Inserted note" + noteUri.getLastPathSegment());
    }
}

