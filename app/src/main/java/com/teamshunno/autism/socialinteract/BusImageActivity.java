package com.teamshunno.autism.socialinteract;

import android.speech.tts.TextToSpeech;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.Locale;

public class BusImageActivity extends AppCompatActivity {

    public TextToSpeech textToSpeech;

    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private static final Integer[] IMAGES= {R.drawable.bus_card,R.drawable.bus_card,R.drawable.bus_card,R.drawable.bus_card};
    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_image);

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(new Locale("bn_BD"));
                }
            }
        });
        init();
    }
    private void init() {

        for(int i=0;i<IMAGES.length;i++){
            ImagesArray.add(IMAGES[i]);
        }

        mPager = (ViewPager) findViewById(R.id.pager);


        mPager.setAdapter(new SlideImageAdapter(BusImageActivity.this,ImagesArray));


        CirclePageIndicator indicator = (CirclePageIndicator) findViewById(R.id.indicator);

        indicator.setViewPager(mPager);

        final float density = getResources().getDisplayMetrics().density;

//Set circle indicator radius
        indicator.setRadius(5 * density);

        NUM_PAGES =IMAGES.length;

//         //Auto start of viewpager
//        final Handler handler = new Handler();
//        final Runnable Update = new Runnable() {
//            public void run() {
//                if (currentPage == NUM_PAGES) {
//                    currentPage = 0;
//                }
//                mPager.setCurrentItem(currentPage++, true);
//            }
//        };
//        Timer swipeTimer = new Timer();
//        swipeTimer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                handler.post(Update);
//            }
//        }, 5000, 5000);

        // Pager listener over indicator
        System.out.println(indicator.getVerticalScrollbarPosition());
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                currentPage = position;
                System.out.println(position+ " "+ currentPage);
                textToSpeech.speak(getString(R.string.text_dos), TextToSpeech.QUEUE_FLUSH, null);
            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });

    }
}
