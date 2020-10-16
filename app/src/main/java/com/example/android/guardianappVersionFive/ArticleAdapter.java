/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.guardianappVersionFive;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;

/**
 * An {@link ArticleAdapter} knows how to create a list item layout for each earthquake
 * in the data source (a list of {@link Article} objects).
 * <p>
 * These list item layouts will be provided to an adapter view like ListView
 * to be displayed to the user.
 */
public class ArticleAdapter extends ArrayAdapter<Article> {

    /**
     * The part of the location string from the USGS service that we use to determine
     * whether or not there is a location offset present ("5km N of Cairo, Egypt").
     */
    private static final String LOCATION_SEPARATOR = " of ";

    /**
     * Constructs a new {@link ArticleAdapter}.
     *
     * @param context  of the app
     * @param articles is the list of articles, which is the data source of the adapter
     */
    public ArticleAdapter(Context context, List<Article> articles) {
        super(context, 0, articles);
    }

    /**
     * Returns a list item view that displays information about the earthquake at the given position
     * in the list of earthquakes.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.article_list_item, parent, false);
        }

        // Find the earthquake at the given position in the list of earthquakes
        Article currentArticle = getItem(position);

        // Get the original category string from the Article object,
        // which can be in the format of "5km N of Cairo, Egypt" or "Pacific-Antarctic Ridge".
        String section = currentArticle.getSectionId();

        // Find the TextView with view ID location
        TextView sectionView = (TextView) listItemView.findViewById(R.id.section);
        // Display the location of the current earthquake in that TextView
        sectionView.setText(section);

        // Get the original title string from the Article object,
        String title = currentArticle.getWebTitle();

        // Find the TextView with view ID location offset
        TextView titleView = (TextView) listItemView.findViewById(R.id.title);
        // Display the location offset of the current earthquake in that TextView
        titleView.setText(title);

        // Find the TextView with view ID date
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        // Display the date in a formatted way
        dateView.setText(formattedDate(currentArticle.getWebPublicationDate()));

        //Get the string for the author's name
        String author = currentArticle.getNewsAuthor();

        // Find the TextView for the Author's name
        TextView authorView = (TextView) listItemView.findViewById(R.id.author);
        authorView.setText(author);

        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }


    //Helper method for formatting the date
    private String formattedDate(String utcTime) {
        Date date = null;
        @SuppressLint("SimpleDateFormat") SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        try {
            date = format.parse(utcTime.replaceAll("Z$", "+0000"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        assert date != null;
        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        @SuppressLint("SimpleDateFormat") SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return dateFormat.format(date) + ", " + timeFormat.format(date);
    }

}
