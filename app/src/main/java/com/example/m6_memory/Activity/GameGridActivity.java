package com.example.m6_memory.Activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Chronometer;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.m6_memory.Activity.GameActivity.GameActivityEasy;
import com.example.m6_memory.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GameGridActivity extends Activity {

    static String easyLevel, mediumLevel, hardLevel, choiceUser;
    private static ImageView hiddenCard;
    private SharedPreferences sharedPreferencesChoiceLevelDifficulty;
    private ImageView card1, card2, card3, card4, card5, card6, card7, card8, card9, card10, card11, card12;
    public static List<Integer> mThumbIds;
    public static int nombreDeCartes;
    private ImageView clock;


    Integer[] cardsArray = {101, 102, 103, 201, 202, 203};

    int animals101, animals201, animals102, animals202, animals103, animals203;
    int firstCard, secondCard, counter = 0;
    int clickedFirst, clickedSecond;
    int cardNumber = 1;
    boolean chronometer;

    private SharedPreferences settings;
    private SharedPreferences.Editor editor;

    private Chronometer time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_grid);

        clock = findViewById(R.id.activity_game_grid_clock_iV);
        time = findViewById(R.id.activity_game_grid_chronometer);

        settings = getSharedPreferences("save", MODE_PRIVATE);
        editor = settings.edit();

        chronometer = settings.getBoolean("value", false);

        sharedPreferencesChoiceLevelDifficulty = getSharedPreferences("levelDifficulty", 0);
        choiceUser = sharedPreferencesChoiceLevelDifficulty.getString("levelDifficulty", "");

        GridView gridView = findViewById(R.id.gridView);
        gridView.setAdapter(new GridViewAdapter(this));


        if (choiceUser == "easy") {
            nombreDeCartes = 6;
            mThumbIds = displayCards(nombreDeCartes);
            //playGame();
        } else if (choiceUser == "medium") {
            nombreDeCartes = 8;
            mThumbIds = displayCards(nombreDeCartes);
            //playGame();
        } else if (choiceUser == "hard") {
            nombreDeCartes = 12;
            mThumbIds = displayCards(nombreDeCartes);
            //playGame();
        }

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }

    public static List<Integer> displayCards(int nombreDeCartes) {
        List<Integer> mThumbsIds = new ArrayList<>();

        for (int i = 0; i < nombreDeCartes; i++) {
            mThumbsIds.add(R.drawable.hiddencards);
        }

        return mThumbsIds;
    }

    public void playGame() {

        if (chronometer) {
            SettingsActivity.chronometer = findViewById(R.id.activity_game_grid_chronometer);
            SettingsActivity.chronometer.setBase(SystemClock.elapsedRealtime());
            SettingsActivity.chronometer.start();
            time.setVisibility(View.VISIBLE);
            clock.setVisibility(View.VISIBLE);
        } else {
            clock.setVisibility(View.INVISIBLE);
            time.setVisibility(View.INVISIBLE);
        }

        hiddenCard = findViewById(R.id.activity_game_grid_card2_iV);
        card1 = findViewById(R.id.activity_game_grid_card2_iV);
        card2 = findViewById(R.id.activity_game_grid_card2_iV);
        card3 = findViewById(R.id.activity_game_grid_card3_iV);
        card4 = findViewById(R.id.activity_game_grid_card4_iV);
        card5 = findViewById(R.id.activity_game_grid_card5_iV);
        card6 = findViewById(R.id.activity_game_grid_card6_iV);
        card7 = findViewById(R.id.activity_game_grid_card2_iV);
        card8 = findViewById(R.id.activity_game_grid_card2_iV);
        card9 = findViewById(R.id.activity_game_grid_card3_iV);
        card10 = findViewById(R.id.activity_game_grid_card4_iV);
        card11= findViewById(R.id.activity_game_grid_card5_iV);
        card12 = findViewById(R.id.activity_game_grid_card6_iV);



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

        if (choiceUser == "medium") {
            card7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int theCard = Integer.parseInt((String) v.getTag());
                    displayFaceUp(card6, theCard);
                }
            });

            card8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int theCard = Integer.parseInt((String) v.getTag());
                    displayFaceUp(card6, theCard);
                }
            });
        }
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
        // startActivity(intent);
        //finish();


    }

}









