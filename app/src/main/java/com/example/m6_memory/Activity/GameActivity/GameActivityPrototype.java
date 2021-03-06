/*
   Class  : GameActivityPrototype
   Author : Sylvain Villoz TINFPT2
   Date   : Novembre 2020
 */
package com.example.m6_memory.Activity.GameActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.m6_memory.R;

import java.util.Arrays;
import java.util.Collections;

/**
 * Class that represents a game in prototype difficulty.
 */
public class GameActivityPrototype extends AppCompatActivity {

    Integer[] cardsArray = {101, 102, 201, 202};
    int animals101, animals201, animals102, animals202;
    int firstCard, secondCard, counter = 0;
    int clickedFirst, clickedSecond;
    int cardNumber = 1;
    private ImageView card1, card2, card3, card4;

    /**
     * Initialize the activity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_prototype);

        card1 = findViewById(R.id.activity_game_prototype_card1_imageView);
        card2 = findViewById(R.id.activity_game_prototype_card2_imageView);
        card3 = findViewById(R.id.activity_game_prototype_card3_imageView);
        card4 = findViewById(R.id.activity_game_prototype_card4_imageView);

        card1.setTag("0");
        card2.setTag("1");
        card3.setTag("2");
        card4.setTag("3");

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
    }

    /**
     * Initialize the front of the cards.
     */
    private void frontOfCards() {
        animals101 = R.drawable.animals_101;
        animals102 = R.drawable.animals_102;
        animals201 = R.drawable.animals_201;
        animals202 = R.drawable.animals_202;
    }

    /**
     * Display the front of the cards.
     */
    private void displayFaceUp(ImageView visible, int card) {
        if (cardsArray[card] == 101) {
            visible.setImageResource(animals101);
        } else if (cardsArray[card] == 102) {
            visible.setImageResource(animals102);
        } else if (cardsArray[card] == 201) {
            visible.setImageResource(animals201);
        } else if (cardsArray[card] == 202) {
            visible.setImageResource(animals202);
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

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Calculate();
                }
            }, 1000);
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
            }
        } else {
            card1.setImageResource(R.drawable.hiddencards);
            card2.setImageResource(R.drawable.hiddencards);
            card3.setImageResource(R.drawable.hiddencards);
            card4.setImageResource(R.drawable.hiddencards);
        }

        card1.setEnabled(true);
        card2.setEnabled(true);
        card3.setEnabled(true);
        card4.setEnabled(true);

        if (counter == 4) {
            startNextActivity();
            counter = 0;
        }
    }

    /**
     * Start the next activity.
     */
    public void startNextActivity() {
        Intent i = new Intent(GameActivityPrototype.this, com.example.m6_memory.Activity.EndGameActivity.class);
        startActivity(i);
    }
}