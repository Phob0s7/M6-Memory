/*
   Class  : GameActivityHard
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
 * Class that represents a game in hard difficulty.
 */
public class GameActivityHard extends AppCompatActivity {

    Integer[] cardsArray = {101, 102, 103, 104, 105, 106, 201, 202, 203, 204, 205, 206};

    int animals101, animals201, animals102, animals202, animals103, animals203, animals104, animals204, animals105, animals205, animals106, animals206;
    int firstCard, secondCard, counter = 0;
    int clickedFirst, clickedSecond;
    int cardNumber = 1;
    boolean chronometer;
    private SharedPreferences settings;
    private ImageView card1, card2, card3, card4, card5, card6, card7, card8, card9, card10, card11, card12, clock;
    private Chronometer time;

    /**
     * Initialize the activity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_game_hard);

        getSharedPrefs();
        displayChronometer();
        initializeCards();
        frontOfCards();
        shuffleImages();
        setCardOnClick();
    }

    /**
     * Initialize the front of the cards.
     */
    private void frontOfCards() {
        animals101 = R.drawable.animals_101;
        animals102 = R.drawable.animals_102;
        animals103 = R.drawable.animals_103;
        animals104 = R.drawable.animals_104;
        animals105 = R.drawable.animals_105;
        animals106 = R.drawable.animals_106;
        animals201 = R.drawable.animals_201;
        animals202 = R.drawable.animals_202;
        animals203 = R.drawable.animals_203;
        animals204 = R.drawable.animals_204;
        animals205 = R.drawable.animals_205;
        animals206 = R.drawable.animals_206;
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
        } else if (cardsArray[card] == 105) {
            visible.setImageResource(animals105);
        } else if (cardsArray[card] == 106) {
            visible.setImageResource(animals106);
        } else if (cardsArray[card] == 205) {
            visible.setImageResource(animals205);
        } else if (cardsArray[card] == 206) {
            visible.setImageResource(animals206);
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
            displayChronometer();


            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Calculate();
                }
            }, 600);
        }
    }

    private void diableCards() {
        card1.setEnabled(false);
        card2.setEnabled(false);
        card3.setEnabled(false);
        card4.setEnabled(false);
        card5.setEnabled(false);
        card6.setEnabled(false);
        card7.setEnabled(false);
        card8.setEnabled(false);
        card9.setEnabled(false);
        card10.setEnabled(false);
        card11.setEnabled(false);
        card12.setEnabled(false);
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
            } else if (clickedFirst == 8) {
                card9.setVisibility((View.INVISIBLE));
                counter++;
            } else if (clickedFirst == 9) {
                card10.setVisibility((View.INVISIBLE));
                counter++;
            } else if (clickedFirst == 10) {
                card11.setVisibility((View.INVISIBLE));
                counter++;
            } else if (clickedFirst == 11) {
                card12.setVisibility((View.INVISIBLE));
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
            } else if (clickedSecond == 8) {
                card9.setVisibility((View.INVISIBLE));
                counter++;
            } else if (clickedSecond == 9) {
                card10.setVisibility((View.INVISIBLE));
                counter++;
            } else if (clickedSecond == 10) {
                card11.setVisibility((View.INVISIBLE));
                counter++;
            } else if (clickedSecond == 11) {
                card12.setVisibility((View.INVISIBLE));
                counter++;
            }

        } else {
            setCardsHidden();

        }

        enableCards();


        if (counter == 12) {
            startNextActivity();
            counter = 0;
        }
    }

    private void displayChronometer() {
        clock = findViewById(R.id.activity_game_hard_timer_imageView);
        time = findViewById(R.id.activity_game_hard_chronometer);

        if (chronometer) {
            SettingsActivity.chronometer = findViewById(R.id.activity_game_hard_chronometer);
            SettingsActivity.chronometer.setBase(SystemClock.elapsedRealtime());
            SettingsActivity.chronometer.start();
            time.setVisibility(View.VISIBLE);
            clock.setVisibility(View.VISIBLE);

        } else {
            clock.setVisibility(View.INVISIBLE);
            time.setVisibility(View.INVISIBLE);
        }
    }

    private void getSharedPrefs() {
        settings = getSharedPreferences("save", MODE_PRIVATE);

        chronometer = settings.getBoolean("value", false);
    }

    private void initializeCards() {
        card1 = findViewById(R.id.activity_game_hard_card1_imageView);
        card2 = findViewById(R.id.activity_game_hard_card2_imageView);
        card3 = findViewById(R.id.activity_game_hard_card3_imageView);
        card4 = findViewById(R.id.activity_game_hard_card4_imageView);
        card5 = findViewById(R.id.activity_game_hard_card5_imageView);
        card6 = findViewById(R.id.activity_game_hard_card6_imageView);
        card7 = findViewById(R.id.activity_game_hard_card7_imageView);
        card8 = findViewById(R.id.activity_game_hard_card8_imageView);
        card9 = findViewById(R.id.activity_game_hard_card9_imageView);
        card10 = findViewById(R.id.activity_game_hard_card10_imageView);
        card11 = findViewById(R.id.activity_game_hard_card11_imageView);
        card12 = findViewById(R.id.activity_game_hard_card12_imageView);

        card1.setTag("0");
        card2.setTag("1");
        card3.setTag("2");
        card4.setTag("3");
        card5.setTag("4");
        card6.setTag("5");
        card7.setTag("6");
        card8.setTag("7");
        card9.setTag("8");
        card10.setTag("9");
        card11.setTag("10");
        card12.setTag("11");
    }

    private void shuffleImages() {
        Collections.shuffle((Arrays.asList(cardsArray)));
    }

    private void setCardOnClick() {

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
        card9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                displayFaceUp(card9, theCard);
            }
        });

        card10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                displayFaceUp(card10, theCard);
            }
        });

        card11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                displayFaceUp(card11, theCard);
            }
        });

        card12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                displayFaceUp(card12, theCard);
            }
        });
    }

    private void setCardsHidden() {
        card1.setImageResource(R.drawable.hiddencards);
        card2.setImageResource(R.drawable.hiddencards);
        card3.setImageResource(R.drawable.hiddencards);
        card4.setImageResource(R.drawable.hiddencards);
        card5.setImageResource(R.drawable.hiddencards);
        card6.setImageResource(R.drawable.hiddencards);
        card7.setImageResource(R.drawable.hiddencards);
        card8.setImageResource(R.drawable.hiddencards);
        card9.setImageResource(R.drawable.hiddencards);
        card10.setImageResource(R.drawable.hiddencards);
        card11.setImageResource(R.drawable.hiddencards);
        card12.setImageResource(R.drawable.hiddencards);
    }

    private void enableCards() {
        card1.setEnabled(true);
        card2.setEnabled(true);
        card3.setEnabled(true);
        card4.setEnabled(true);
        card5.setEnabled(true);
        card6.setEnabled(true);
        card7.setEnabled(true);
        card8.setEnabled(true);
        card9.setEnabled(true);
        card10.setEnabled(true);
        card11.setEnabled(true);
        card12.setEnabled(true);
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

        Intent intent = new Intent(GameActivityHard.this, EndGameActivity.class);
        startActivity(intent);
        finish();
    }
}