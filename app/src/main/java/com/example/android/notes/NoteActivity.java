package com.example.android.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.android.notes.models.Note;

public class NoteActivity extends AppCompatActivity {

    private static final String TAG = "NoteActivity";

    private LinedEditText mLinedEditText;
    private EditText mEditText;
    private TextView mViewTitle;

    private boolean mIsNewNote;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        mLinedEditText = findViewById(R.id.note_text);
        mEditText = findViewById(R.id.note_edit_title);
        mViewTitle = findViewById(R.id.note_text_title);


        if(getIncomingIntent()){
            //Edit mode
        }
        else{
            //View mode
        }



    }

    private boolean getIncomingIntent(){
        if(getIntent().hasExtra("selected_note")){
            Note incomingNote= getIntent().getParcelableExtra("selected_note");
            mIsNewNote = false;
            return false;

        }
        mIsNewNote = true;
        return true;
    }
}
