package com.teamshunno.autism.socialinteract;

import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Locale;

public class ParkActivity extends AppCompatActivity {
    boolean click = false;
    ImageView imageView;
    TextView descText, doText, dontText;
    FloatingActionButton fabplay;
    public TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_park);
        fabplay = (FloatingActionButton)findViewById(R.id.fabplay);
        descText = (TextView)findViewById(R.id.descText);
        doText = (TextView)findViewById(R.id.doText);
        dontText = (TextView)findViewById(R.id.dontText);
        imageView = (ImageView)findViewById(R.id.imageView);
        Picasso.get()
                .load(R.drawable.park_card)
                .into(imageView);

        String descriptionText = getResources().getString(R.string.mosque_des);
        descText.setText(Html.fromHtml(descriptionText));

        String descriptionDo = getResources().getString(R.string.mosque_do);
        doText.setText(Html.fromHtml(descriptionDo));

        String descriptionDont = getResources().getString(R.string.mosque_dont);
        dontText.setText(Html.fromHtml(descriptionDont));

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(new Locale("bn_BD"));
                }
            }
        });
        fabplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!click) {
                    fabplay.setImageResource(R.drawable.ic_stop_black_24dp);
                    textToSpeech.speak(descText.getText().toString() + doText.getText().toString() + dontText.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
                    click=true;
                }
                else {
                    textToSpeech.stop();
                    fabplay.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                    click = false;
                }
            }
        });
    }
    @Override
    protected void onPause() {
        textToSpeech.stop();
        super.onPause();
    }
}
