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
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int PLACE_MOSQUE = 0;
    public static final int PLACE_BUS_STATION = 1;
    public static final int PLACE_HOTEL = 2;
    public static final int PLACE_PARK = 3;
    public static final int PLACE_PICNIC = 4;
    public static final int PLACE_DEMO = 5;

    Context mContext;

    ImageButton mosque, busStation, park, picnic, restaurant, dummy;

    TextToSpeech textToSpeech;

    boolean isBackPressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = MainActivity.this;

        mosque = (ImageButton) findViewById(R.id.mosque);
        busStation = (ImageButton) findViewById(R.id.busStation);
        park = (ImageButton) findViewById(R.id.park);
        picnic = (ImageButton) findViewById(R.id.picnic);
        restaurant = (ImageButton) findViewById(R.id.restaurant);
        dummy = (ImageButton) findViewById(R.id.dummy);

        mosque.setOnClickListener(this);
        busStation.setOnClickListener(this);
        park.setOnClickListener(this);
        picnic.setOnClickListener(this);
        restaurant.setOnClickListener(this);
        dummy.setOnClickListener(this);


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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.about:
                AlertDialog.Builder aboutDialog = new AlertDialog.Builder(mContext);

                aboutDialog.setIcon(R.drawable.ic_info_outline_black_24dp);
                aboutDialog.setTitle(getString(R.string.app_name));
                aboutDialog.setMessage("Version " + BuildConfig.VERSION_NAME +
                        "\n" + "\n" +
                        "This Project is developed by—" +
                        "\n" +
                        getString(R.string.team_shunno) +
                        "\n" + "\n" +
                        "This is an Open-Source Project under MPL 2.0" +
                        "\n" +
                        "Copyright ©  " + getString(R.string.team_shunno));
                aboutDialog.show();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (isBackPressed) {
            super.onBackPressed();
            return;
        }

        isBackPressed = true;

        Toast.makeText(MainActivity.this, "Press once again to exit", Toast.LENGTH_LONG)
                .show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                isBackPressed = false;
            }

        }, 2000);
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(new Locale("bn_BD"));
                }
            }
        });

        switch (v.getId()) {
            case R.id.mosque:
                intent.putExtra("place", PLACE_MOSQUE);
                startActivity(intent);
                break;

            case R.id.busStation:
                intent.putExtra("place", PLACE_BUS_STATION);
                startActivity(intent);
                break;

            case R.id.park:
                intent.putExtra("place", PLACE_PARK);
                startActivity(intent);
                break;

            case R.id.picnic:
                intent.putExtra("place", PLACE_PICNIC);
                startActivity(intent);
                break;

            case R.id.restaurant:
                intent.putExtra("place", PLACE_HOTEL);
                startActivity(intent);
                break;

            case R.id.dummy:
//                Intent intent1 = new Intent(this, ImageSliderActivity.class);
                intent.putExtra("place", PLACE_DEMO);
//
//                startActivity(intent1);

                textToSpeech.speak(getString(R.string.text_dos), TextToSpeech.QUEUE_FLUSH, null);
                break;
        }
    }
}
