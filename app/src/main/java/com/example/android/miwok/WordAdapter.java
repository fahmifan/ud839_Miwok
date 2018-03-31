package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class WordAdapter extends ArrayAdapter<Word> {

    /* The context (activity class) that call this class */
    private  Context mContext;

    private  List<Word> wordList = new ArrayList<>();

    private int mColorResourceId;

    public WordAdapter(Context context, ArrayList<Word> items, int listColor) {

        /* we don't use resource here the super second argument, we can assign it anny number
         we assign it 0 here */
        super(context, 0, items);
        mContext = context;
        wordList = items;
        mColorResourceId = listColor;
    }

    /**
     * This will provide a single view of our component wich is a word of miwok & defaultLang
     * for an AdapterView (ListView, GridView, ...)
     * */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItem = convertView;

        if(listItem == null) {
            listItem = LayoutInflater.from(this.mContext).inflate(R.layout.list_item, parent, false);
        }

        Word currentWord = this.wordList.get(position);

        // Set the theme color for the item lists
        View textContainer = listItem.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the dictionary_list
        textContainer.setBackgroundColor(color);

        TextView defaultTranslation = (TextView) listItem.findViewById(R.id.default_text_view);
        defaultTranslation.setText(currentWord.getmDefaultTranslation());

        TextView miwokTranslation = (TextView) listItem.findViewById(R.id.miwok_text_view);
        miwokTranslation.setText(currentWord.getmMiwokTranslation());

        ImageView mImageSrc = (ImageView) listItem.findViewById(R.id.image_src);

        if(currentWord.hasImage()) {
            mImageSrc.setImageResource(currentWord.getmImageResourceId());
            mImageSrc.setVisibility(View.VISIBLE);
        } else {
            mImageSrc.setVisibility(View.GONE);
        }

        return  listItem;
    }
}
