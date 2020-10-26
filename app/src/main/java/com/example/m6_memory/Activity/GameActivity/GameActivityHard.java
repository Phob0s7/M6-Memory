package com.example.m6_memory.Activity.GameActivity;

import androidx.appcompat.app.AppCompatActivity;

import com.example.m6_memory.Activity.EndGameActivity;
import com.example.m6_memory.Activity.SettingsActivity;
import com.example.m6_memory.R;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.view.WindowManager;
import android.widget.Chronometer;
import android.widget.ImageView;

import java.util.Arrays;
import java.util.Collections;

public class GameActivityHard extends AppCompatActivity {

    Integer[] cardsArray = {101, 102, 103, 201, 202, 203};

    int animals101, animals201, animals102, animals202, animals103, animals203;
    int firstCard, secondCard, counter = 0;
    int clickedFirst, clickedSecond;
    int cardNumber = 1;
    boolean chronometer;

    private SharedPreferences settings;
    private SharedPreferences.Editor editor;

    private ImageView card1, card2, card3, card4, card5, card6, clock, clockEnd;

    private Chronometer time;

    //public static final String EXTRA_MESSAGE = "com.timer.Memory.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_game_easy);

        clock = findViewById(R.id.activity_game_easy_timer_imageView);
        time = findViewById(R.id.activity_game_easy_chronometer);

        settings = getSharedPreferences("save", MODE_PRIVATE);
        editor = settings.edit();

        chronometer = settings.getBoolean("value", false);


        if (chronometer) {
            SettingsActivity.chronometer = findViewById(R.id.activity_game_easy_chronometer);
            SettingsActivity.chronometer.setBase(SystemClock.elapsedRealtime());
            SettingsActivity.chronometer.start();
            time.setVisibility(View.VISIBLE);
            clock.setVisibility(View.VISIBLE);

        }
        else {
            clock.setVisibility(View.INVISIBLE);
            time.setVisibility(View.INVISIBLE);

        }



        card1 = findViewById(R.id.activity_game_easy_card1_imageView);
        card2 = findViewById(R.id.activity_game_easy_card2_imageView);
        card3 = findViewById(R.id.activity_game_easy_card3_imageView);
        card4 = findViewById(R.id.activity_game_easy_card4_imageView);
        card5 = findViewById(R.id.activity_game_easy_card5_imageView);
        card6 = findViewById(R.id.activity_game_easy_card8_imageView);

        card1.setTag("0");
        card2.setTag("1");
        card3.setTag("2");
        card4.setTag("3");
        card5.setTag("4");
        card6.setTag("5");

        frontOfCards();

        Collections.shuffle((Arrays.asList(cardsArray)));

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                displayFaceUp(card1, theCard);
            }
        });

        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                displayFaceUp(card2, theCard);
            }
        });

        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                displayFaceUp(card3, theCard);
            }
        });

        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                displayFaceUp(card4, theCard);
            }
        });

        card5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                displayFaceUp(card5, theCard);
            }
        });

        card6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                displayFaceUp(card6, theCard);
            }
        });
    }

    private void frontOfCards() {
        animals101 = R.drawable.animals_101;
        animals102 = R.drawable.animals_102;
        animals103 = R.drawable.animals_103;
        animals201 = R.drawable.animals_201;
        animals202 = R.drawable.animals_202;
        animals203 = R.drawable.animals_203;
    }

    private void displayFaceUp(ImageView visible, int card) {
        if (cardsArray[card] == 101) {
            visible.setImageResource(animals101);
        } else if (cardsArray[card] == 102) {
            visible.setImageResource(animals102);
        } else if (cardsArray[card] == 103) {
            visible.setImageResource(animals103);
        } else if (cardsArray[card] == 201) {
            visible.setImageResource(animals201);
        } else if (cardsArray[card] == 202) {
            visible.setImageResource(animals202);
        } else if (cardsArray[card] == 203) {
            visible.setImageResource(animals203);
        }
        if (cardNumber == 1) {
            firstCard = cardsArray[card];

            if (firstCard > 200) {
                firstCard = firstCard - 100;
            }
            cardNumber = 2;
            clickedFirst = card;

            visible.setEnabled(false);

        } else if (cardNumber == 2) {
            secondCard = cardsArray[card];

            if (secondCard > 200) {
                secondCard = secondCard - 100;
            }
            cardNumber = 1;
            clickedSecond = card;

            card1.setEnabled(false);
            card2.setEnabled(false);
            card3.setEnabled(false);
            card4.setEnabled(false);
            card5.setEnabled(false);
            card6.setEnabled(false);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Calculate();
                }
            }, 600);
        }
    }

    private void Calculate() {
        if (firstCard == secondCard) {
            if (clickedFirst == 0) {
                card1.setVisibility(View.INVISIBLE);
                counter++;
            } else if (clickedFirst == 1) {
                card2.setVisibility((View.INVISIBLE));
                counter++;
            } else if (clickedFirst == 2) {
                card3.setVisibility((View.INVISIBLE));
                counter++;
            } else if (clickedFirst == 3) {
                card4.setVisibility((View.INVISIBLE));
                counter++;
            } else if (clickedFirst == 4) {
                card5.setVisibility((View.INVISIBLE));
                counter++;
            } else if (clickedFirst == 5) {
                card6.setVisibility((View.INVISIBLE));
                counter++;
            }

            if (clickedSecond == 0) {
                card1.setVisibility(View.INVISIBLE);
                counter++;
            } else if (clickedSecond == 1) {
                card2.setVisibility((View.INVISIBLE));
                counter++;
            } else if (clickedSecond == 2) {
                card3.setVisibility((View.INVISIBLE));
                counter++;
            } else if (clickedSecond == 3) {
                card4.setVisibility((View.INVISIBLE));
                counter++;
            } else if (clickedSecond == 4) {
                card5.setVisibility((View.INVISIBLE));
                counter++;
            } else if (clickedSecond == 5) {
                card6.setVisibility((View.INVISIBLE));
                counter++;
            }


        } else {
            card1.setImageResource(R.drawable.hiddencards);
            card2.setImageResource(R.drawable.hiddencards);
            card3.setImageResource(R.drawable.hiddencards);
            card4.setImageResource(R.drawable.hiddencards);
            card5.setImageResource(R.drawable.hiddencards);
            card6.setImageResource(R.drawable.hiddencards);
        }

        card1.setEnabled(true);
        card2.setEnabled(true);
        card3.setEnabled(true);
        card4.setEnabled(true);
        card5.setEnabled(true);
        card6.setEnabled(true);


        if (counter == 6) {
            run();
            counter = 0;
        }
    }

    public void run() {
        if (chronometer) {
            SettingsActivity.getChronometer().stop();
            int value = ((int) (SystemClock.elapsedRealtime() - SettingsActivity.getChronometer().getBase())) / 1000;
            SharedPreferences sharedPref = getSharedPreferences("myKey", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt("lastTime", value);
            editor.apply();
        }

            /*
        } else {
           //Intent intent = new Intent(GameActivityEasy.this, EndGameWithoutChronoActivity.class);
            //startActivity(intent);
        }

             */
        //Intent intent = new Intent(GameActivityEasy.this, EndGameActivity.class);
        //startActivity(intent);
        finish();
    }
}