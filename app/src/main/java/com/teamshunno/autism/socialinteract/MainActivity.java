package com.teamshunno.autism.socialinteract;

import android.content.Intent;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.squareup.picasso.Picasso;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    ImageButton mosque, busStation, park, picnic, restaurant, dummy;

    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mosque = (ImageButton)findViewById(R.id.mosque);
        busStation = (ImageButton)findViewById(R.id.busStation);
        park = (ImageButton)findViewById(R.id.park);
        picnic = (ImageButton)findViewById(R.id.picnic);
        restaurant = (ImageButton)findViewById(R.id.restaurant);
        dummy = (ImageButton)findViewById(R.id.dummy);
        Picasso.get()
                .load(R.drawable.mosque_card)
                .into(mosque);
        Picasso.get()
                .load(R.drawable.bus_card)
                .into(busStation);
        Picasso.get()
                .load(R.drawable.resturant_card)
                .into(restaurant);
        Picasso.get()
                .load(R.drawable.park_card)
                .into(park);
        Picasso.get()
                .load(R.drawable.picnic_card)
                .into(picnic);
        Picasso.get()
                .load(R.drawable.bus_card)
                .into(dummy);
        mosque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MosqueActivity.class);
                startActivity(intent);
            }
        });

        busStation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BusStationActivity.class);
                startActivity(intent);
            }
        });

        park.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ParkActivity.class);
                startActivity(intent);
            }
        });

        picnic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PicnicActivity.class);
                startActivity(intent);
            }
        });

        restaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ResaurentActivity.class);
                startActivity(intent);
            }
        });

        dummy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if (status != TextToSpeech.ERROR) {
                            textToSpeech.setLanguage(new Locale("bn_BD"));
                        }
                        textToSpeech.speak("এটা ডামি", TextToSpeech.QUEUE_FLUSH, null);
                    }
                });
            }
        });
    }
}
