package com.example.android.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import com.example.android.notes.adapters.NotesRecyclerAdapter;
import com.example.android.notes.models.Note;
import com.example.android.notes.util.VerticalSpacingItemDecorator;

import java.util.ArrayList;

public class NotesListActivity extends AppCompatActivity {

    private static final String TAG = "NotesListActivity";

    private RecyclerView mRecyclerView;

    private ArrayList<Note> mNotes = new ArrayList<>();
    private NotesRecyclerAdapter mNotesRecyclerAdapter ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        mRecyclerView = findViewById(R.id.recyclerView);

        initRecyclerView();
        insertFakeNoteS();

        setSupportActionBar((Toolbar)findViewById(R.id.notes_toolbar));
        setTitle("Notes");

    }

    private void insertFakeNoteS(){
        for(int i=0 ; i <1000 ; i++){
            Note note = new Note();
            note.setTitle("Title #" +i);
            note.setContent("Content #" + i);
            note.setTimeStamp("April 2019");
            mNotes.add(note);
        }
        mNotesRecyclerAdapter.notifyDataSetChanged();
    }


    private void initRecyclerView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        VerticalSpacingItemDecorator itemDecorator = new VerticalSpacingItemDecorator(10);
        mRecyclerView.addItemDecoration(itemDecorator);
        mNotesRecyclerAdapter = new NotesRecyclerAdapter(mNotes);
        mRecyclerView.setAdapter(mNotesRecyclerAdapter);

    }
}
