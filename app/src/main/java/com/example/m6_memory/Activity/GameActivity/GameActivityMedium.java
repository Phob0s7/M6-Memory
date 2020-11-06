/*
   Class  : GameActivityMedium
   Author : Sylvain Villoz TINFPT2
   Date   : Novembre 2020
 */
package com.example.m6_memory.Activity.GameActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.view.WindowManager;
import android.widget.Chronometer;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.m6_memory.Activity.EndGameActivity;
import com.example.m6_memory.Activity.SettingsActivity;
import com.example.m6_memory.R;

import java.util.Arrays;
import java.util.Collections;

/**
 * Class that represents a game in medium difficulty.
 */
public class GameActivityMedium extends AppCompatActivity {

    Integer[] cardsArray = {101, 102, 103, 104, 201, 202, 203, 204};

    int animals101, animals201, animals102, animals202, animals103, animals203, animals104, animals204;
    int firstCard, secondCard, counter = 0;
    int clickedFirst, clickedSecond;
    int cardNumber = 1;
    boolean chronometer;
    private SharedPreferences settings;
    private SharedPreferences.Editor editor;
    private ImageView card1, card2, card3, card4, card5, card6, card7, card8, clock;
    private Chronometer time;

    /**
     * Initialize the activity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_game_medium);

        clock = findViewById(R.id.activity_game_medium_timer_imageView);
        time = findViewById(R.id.activity_game_medium_chronometer);
        settings = getSharedPreferences("save", MODE_PRIVATE);
        editor = settings.edit();

        chronometer = settings.getBoolean("value", false);

        if (chronometer) {
            SettingsActivity.chronometer = findViewById(R.id.activity_game_medium_chronometer);
            SettingsActivity.chronometer.setBase(SystemClock.elapsedRealtime());
            SettingsActivity.chronometer.start();
            time.setVisibility(View.VISIBLE);
            clock.setVisibility(View.VISIBLE);

        } else {
            clock.setVisibility(View.INVISIBLE);
            time.setVisibility(View.INVISIBLE);
        }

        card1 = findViewById(R.id.activity_game_medium_card1_imageView);
        card2 = findViewById(R.id.activity_game_medium_card2_imageView);
        card3 = findViewById(R.id.activity_game_medium_card3_imageView);
        card4 = findViewById(R.id.activity_game_medium_card4_imageView);
        card5 = findViewById(R.id.activity_game_medium_card5_imageView);
        card6 = findViewById(R.id.activity_game_medium_card6_imageView);
        card7 = findViewById(R.id.activity_game_medium_card7_imageView);
        card8 = findViewById(R.id.activity_game_medium_card8_imageView);

        card1.setTag("0");
        card2.setTag("1");
        card3.setTag("2");
        card4.setTag("3");
        card5.setTag("4");
        card6.setTag("5");
        card7.setTag("6");
        card8.setTag("7");

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

        card7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                displayFaceUp(card7, theCard);
            }
        });

        card8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                displayFaceUp(card8, theCard);
            }
        });
    }

    /**
     * Initialize the front of the cards.
     */
    private void frontOfCards() {
        animals101 = R.drawable.animals_101;
        animals102 = R.drawable.animals_102;
        animals103 = R.drawable.animals_103;
        animals104 = R.drawable.animals_104;
        animals201 = R.drawable.animals_201;
        animals202 = R.drawable.animals_202;
        animals203 = R.drawable.animals_203;
        animals204 = R.drawable.animals_204;
    }

    /**
     * Display the front of the cards.
     */
    private void displayFaceUp(ImageView visible, int card) {
        if (cardsArray[card] == 101) {
            visible.setImageResource(animals101);
        } else if (cardsArray[card] == 102) {
            visible.setImageResource(animals102);
        } else if (cardsArray[card] == 103) {
            visible.setImageResource(animals103);

        } else if (cardsArray[card] == 104) {
            visible.setImageResource(animals104);

        } else if (cardsArray[card] == 201) {
            visible.setImageResource(animals201);
        } else if (cardsArray[card] == 202) {
            visible.setImageResource(animals202);
        } else if (cardsArray[card] == 203) {
            visible.setImageResource(animals203);
        } else if (cardsArray[card] == 204) {
            visible.setImageResource(animals204);
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
            card7.setEnabled(false);
            card8.setEnabled(false);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Calculate();
                }
            }, 600);
        }
    }

    /**
     * Check if the cards are same.
     */
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
            } else if (clickedFirst == 6) {
                card7.setVisibility((View.INVISIBLE));
                counter++;
            } else if (clickedFirst == 7) {
                card8.setVisibility((View.INVISIBLE));
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
            } else if (clickedSecond == 6) {
                card7.setVisibility((View.INVISIBLE));
                counter++;
            } else if (clickedSecond == 7) {
                card8.setVisibility((View.INVISIBLE));
                counter++;
            }

        } else {
            card1.setImageResource(R.drawable.hiddencards);
            card2.setImageResource(R.drawable.hiddencards);
            card3.setImageResource(R.drawable.hiddencards);
            card4.setImageResource(R.drawable.hiddencards);
            card5.setImageResource(R.drawable.hiddencards);
            card6.setImageResource(R.drawable.hiddencards);
            card7.setImageResource(R.drawable.hiddencards);
            card8.setImageResource(R.drawable.hiddencards);
        }

        card1.setEnabled(true);
        card2.setEnabled(true);
        card3.setEnabled(true);
        card4.setEnabled(true);
        card5.setEnabled(true);
        card6.setEnabled(true);
        card7.setEnabled(true);
        card8.setEnabled(true);


        if (counter == 8) {
            startNextActivity();
            counter = 0;
        }
    }

    /**
     * Start the next activity.
     */
    public void startNextActivity() {
        if (chronometer) {
            SettingsActivity.getChronometer().stop();
            int value = ((int) (SystemClock.elapsedRealtime() - SettingsActivity.getChronometer().getBase())) / 1000;
            SharedPreferences sharedPref = getSharedPreferences("myKey", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt("lastTime", value);
            editor.apply();
        }

        Intent intent = new Intent(GameActivityMedium.this, EndGameActivity.class);
        startActivity(intent);
        finish();
    }
}