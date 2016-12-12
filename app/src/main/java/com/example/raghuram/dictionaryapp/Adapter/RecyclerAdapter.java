package com.example.raghuram.dictionaryapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

import com.example.raghuram.dictionaryapp.Model.Wordsclass;
import com.example.raghuram.dictionaryapp.R;
import com.example.raghuram.dictionaryapp.WordMeaning;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by raghuram on 11/18/16.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    ArrayList<Wordsclass> wordsclass = new ArrayList<>();
    Context context;

    public RecyclerAdapter(ArrayList<Wordsclass> word, Context context) {
        this.wordsclass= word;
        this.context = context;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view,context,wordsclass);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        Wordsclass words = wordsclass.get(position);
        holder.text_word.setText(words.getWords());
    }

    @Override
        public int getItemCount() {
            return wordsclass.size();
        }


    public static class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView text_word,tamilmeaning,englishmeaning;
        ArrayList<Wordsclass> wordsclasses ;
        Context context;

        public RecyclerViewHolder(View view, Context context, ArrayList<Wordsclass> words) {
            super(view);
            view.setOnClickListener(this);
            this.context = context;
            this.wordsclasses = words;
            text_word = (TextView) view.findViewById(R.id.words);

        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Wordsclass wordsclass = this.wordsclasses.get(position);
            Intent intent = new Intent(this.context, WordMeaning.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("text_words",wordsclass.getWords());
            intent.putExtra("text_tamilmeanings",wordsclass.getTamilmeaning());
            intent.putExtra("text_englishmeanings",wordsclass.getEnglishmeaning());
            this.context.startActivity(intent);
        }


    }

    public void setFilter(ArrayList<Wordsclass> newwords ){

        wordsclass.clear();
        wordsclass.addAll(newwords);
        notifyDataSetChanged();

    }
}
