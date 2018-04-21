/**
 * Bismillahir Rahmanir Rahim
 * <p>
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.teamshunno.autism.socialinteract;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Locale;

public class DetailsActivity extends AppCompatActivity {

    Context mContext;

    boolean click = false;
    public ImageButton imageButtonDo, imageButtonDont;
    ImageView imageView;
    TextView descText, doText, dontText;
    FloatingActionButton fabplay;
    public TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        mContext = DetailsActivity.this;

        /**
         * Set Toolbar
         */
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        fabplay = (FloatingActionButton) findViewById(R.id.fabplay);
        descText = (TextView) findViewById(R.id.descText);
//        doText = (TextView) findViewById(R.id.doText);
//        dontText = (TextView) findViewById(R.id.dontText);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageButtonDo = (ImageButton)findViewById(R.id.doImage);
        imageButtonDont = (ImageButton)findViewById(R.id.dontImage);

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(new Locale("bn_BD"));
                }
            }
        });



        /**
         * Receive Data
         */
        int place = getIntent().getIntExtra("place", 0);

        setUI(place);

        fabplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!click) {
                    fabplay.setImageResource(R.drawable.ic_stop_black_24dp);
                    textToSpeech.speak(descText.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
                    click = true;
                } else {
                    textToSpeech.stop();
                    fabplay.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                    click = false;
                }
            }
        });
    }

    void setUI(int place) {
        switch (place) {
            case MainActivity.PLACE_MOSQUE:

                setTitle("মসজিদ");

                Picasso.get()
                        .load(R.drawable.mosque_card)
                        .into(imageView);

                Picasso.get()
                        .load(R.drawable.doi)
                        .into(imageButtonDo);

                Picasso.get()
                        .load(R.drawable.dont)
                        .into(imageButtonDont);

                descText.setText(getString(R.string.mosque_des));

                imageButtonDo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, ImageSliderActivity.class);
                        startActivity(intent);
                    }
                });

                //doText.setText(getString(R.string.mosque_do));

                //dontText.setText(getString(R.string.mosque_dont));

                break;


            case MainActivity.PLACE_BUS_STATION:

                setTitle("বাস স্টেশন");

                Picasso.get()
                        .load(R.drawable.bus_card)
                        .into(imageView);

                Picasso.get()
                        .load(R.drawable.doi)
                        .into(imageButtonDo);

                Picasso.get()
                        .load(R.drawable.dont)
                        .into(imageButtonDont);

                descText.setText(getString(R.string.mosque_des));

                imageButtonDo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, BusImageActivity.class);
                        startActivity(intent);
                    }
                });
//
//                doText.setText(getString(R.string.mosque_do));
//
//                dontText.setText(getString(R.string.mosque_dont));

                break;


            case MainActivity.PLACE_HOTEL:

                setTitle("হোটেল");

                Picasso.get()
                        .load(R.drawable.resturant_card)
                        .into(imageView);

                Picasso.get()
                        .load(R.drawable.doi)
                        .into(imageButtonDo);

                Picasso.get()
                        .load(R.drawable.dont)
                        .into(imageButtonDont);

                descText.setText(getString(R.string.mosque_des));

                imageButtonDo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, ResturantImageActivity.class);
                        startActivity(intent);
                    }
                });
//
//                doText.setText(getString(R.string.mosque_do));
//
//                dontText.setText(getString(R.string.mosque_dont));

                break;


            case MainActivity.PLACE_PARK:

                setTitle("পার্ক");

                Picasso.get()
                        .load(R.drawable.park_card)
                        .into(imageView);


                Picasso.get()
                        .load(R.drawable.doi)
                        .into(imageButtonDo);

                Picasso.get()
                        .load(R.drawable.dont)
                        .into(imageButtonDont);

                descText.setText(getString(R.string.mosque_des));

                imageButtonDo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, ParkImageActivity.class);
                        startActivity(intent);
                    }
                });

//
//                doText.setText(getString(R.string.mosque_do));
//
//                dontText.setText(getString(R.string.mosque_dont));

                break;


            case MainActivity.PLACE_PICNIC:

                setTitle("পিকনিক");

                Picasso.get()
                        .load(R.drawable.picnic_card)
                        .into(imageView);

                Picasso.get()
                        .load(R.drawable.doi)
                        .into(imageButtonDo);

                Picasso.get()
                        .load(R.drawable.dont)
                        .into(imageButtonDont);

                descText.setText(getString(R.string.mosque_des));

                imageButtonDo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, PicnicImageActivity.class);
                        startActivity(intent);
                    }
                });

//                doText.setText(getString(R.string.mosque_do));
//
//                dontText.setText(getString(R.string.mosque_dont));

                break;


            case MainActivity.PLACE_DEMO:

                setTitle("ডেমো");

                Picasso.get()
                        .load(R.drawable.mosque_card)
                        .into(imageView);
                Picasso.get()
                        .load(R.drawable.doi)
                        .into(imageButtonDo);

                Picasso.get()
                        .load(R.drawable.dont)
                        .into(imageButtonDont);

                descText.setText(getString(R.string.mosque_des));

                imageButtonDo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, ImageSliderActivity.class);
                        startActivity(intent);
                    }
                });

//                doText.setText(getString(R.string.mosque_do));
//
//                dontText.setText(getString(R.string.mosque_dont));

                break;

        }


    }

    @Override
    protected void onPause() {
        textToSpeech.stop();
        super.onPause();
    }
}
