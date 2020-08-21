package com.example.m6_memory;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import java.util.Arrays;
import java.util.Collections;

public class GameActivity extends AppCompatActivity {

    private ImageView hidden0, hidden1, hidden2, hidden3;

    Integer[] cardsArray = {0, 1, 2, 3};

    int image0, image1, image2, image3;

    int firstCard, secondCard;
    int clickedFirst, clickedSecond;
    int cardNumber = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        hidden0 = (ImageView) findViewById(R.id.activity_game_hidden0_imageView);
        hidden1 = (ImageView) findViewById(R.id.activity_game_hidden1_imageView);
        hidden2 = (ImageView) findViewById(R.id.activity_game_hidden2_imageView);
        hidden3 = (ImageView) findViewById(R.id.activity_game_hidden3_imageView);

        hidden0.setTag("0");
        hidden1.setTag("1");
        hidden2.setTag("2");
        hidden3.setTag("3");

        frontOfCardsResources();

        Collections.shuffle((Arrays.asList(cardsArray)));

        hidden0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                displayFaceUp(hidden0, theCard);
            }
        });

        hidden1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                displayFaceUp(hidden1, theCard);
            }
        });

        hidden2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                displayFaceUp(hidden2, theCard);
            }
        });

        hidden3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                displayFaceUp(hidden3, theCard);
            }
        });
    }

    private void displayFaceUp(ImageView visible, int card) {
        if (cardsArray[card] == 0) {
            visible.setImageResource(image0);
        } else if (cardsArray[card] == 1) {
            visible.setImageResource(image1);
        } else if (cardsArray[card] == 2) {
            visible.setImageResource(image2);
        } else if (cardsArray[card] == 3) {
            visible.setImageResource(image3);
        }

        if (cardNumber == 1) {
            firstCard = cardsArray[card];

            cardNumber = 2;
            clickedFirst = card;

            visible.setEnabled(false);
        } else if (cardNumber == 2) {
            secondCard = cardsArray[card];

            cardNumber = 1;
            clickedSecond = card;

            hidden0.setEnabled(false);
            hidden1.setEnabled(false);
            hidden2.setEnabled(false);
            hidden3.setEnabled(false);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Calculate();
                }
            }, 1000);
        }
    }

    private void Calculate() {
        if (firstCard == secondCard) {
            if (clickedFirst == 0) {
                hidden0.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 1) {
                hidden1.setVisibility((View.INVISIBLE));
            } else if (clickedFirst == 2) {
                hidden2.setVisibility((View.INVISIBLE));
            } else if (clickedFirst == 3) {
                hidden3.setVisibility((View.INVISIBLE));
            }

            if (clickedSecond == 0) {
                hidden0.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 1) {
                hidden1.setVisibility((View.INVISIBLE));
            } else if (clickedSecond == 2) {
                hidden2.setVisibility((View.INVISIBLE));
            } else if (clickedSecond == 3) {
                hidden3.setVisibility((View.INVISIBLE));
            }
        }
        else {
            hidden0.setImageResource(R.drawable.hiddencard);
            hidden1.setImageResource(R.drawable.hiddencard);
            hidden2.setImageResource(R.drawable.hiddencard);
            hidden3.setImageResource(R.drawable.hiddencard);
        }
    }

    private void frontOfCardsResources() {
        image0 =  R.drawable.animals_0;
        image1 =  R.drawable.animals_1;
        image2 =  R.drawable.animals_2;
        image3 =  R.drawable.animals_3;
    }
}