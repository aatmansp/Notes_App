package com.example.android.notes.adapters;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.notes.R;
import com.example.android.notes.models.Note;
import com.example.android.notes.util.Utility;

import java.util.ArrayList;

public class NotesRecyclerAdapter extends RecyclerView.Adapter<NotesRecyclerAdapter.ViewHolder>{

    private static final String TAG = "NotesRecyclerAdapter";
    public NotesRecyclerAdapter(ArrayList<Note> notes , OnNoteListener onNoteListener){

        this.mNotes = notes;
        this.mOnNoteListener = onNoteListener;

    }

    private ArrayList<Note> mNotes = new ArrayList<>();
    private OnNoteListener mOnNoteListener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_note_list_item, viewGroup , false);
        return new ViewHolder(view , mOnNoteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        try{
            String month = mNotes.get(i).getTimeStamp().substring(0 , 2);
            month= Utility.getMonthFromNumber(month);
            String year = mNotes.get(i).getTimeStamp().substring(3);
            String timeStamp = month+" "+year;
            viewHolder.timestamp.setText(timeStamp);
            viewHolder.title.setText((mNotes.get(i).getTitle()));
        }
        catch (NullPointerException e){
            Log.e(TAG, "onBindViewHolder: NullPointerException " + e.getMessage());
        }


    }

    @Override
    public int getItemCount() {

        return mNotes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView title , timestamp;
        OnNoteListener onNoteListener ;


        public ViewHolder(@NonNull View itemView, OnNoteListener onNoteListener) {
            super(itemView);
            title = itemView.findViewById(R.id.note_title);
            timestamp = itemView.findViewById(R.id.note_timestamp);
            this.onNoteListener = onNoteListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mOnNoteListener.onNoteClick(getAdapterPosition());
        }
    }

    public interface OnNoteListener{
       void onNoteClick(int position);
    }

}
