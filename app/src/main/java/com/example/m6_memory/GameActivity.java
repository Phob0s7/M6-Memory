package com.example.m6_memory;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import java.util.Arrays;
import java.util.Collections;

public class GameActivity extends AppCompatActivity {

    private ImageView card1, card2, card3, card4;

    int animals_pig, animals_duck;

    Drawable pig, duck;
    Drawable imageWhenClick;
    Drawable firstCard, secondCard;

    int clickedFirst, clickedSecond;
    int cardNumber = 1;

    Integer[] cardsArray = {0, 1, 2, 3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        card1 = findViewById(R.id.activity_game_card1_imageView);
        card2 = findViewById(R.id.activity_game_card2_imageView);
        card3 = findViewById(R.id.activity_game_card3_imageView);
        card4 = findViewById(R.id.activity_game_card4_imageView);

        card1.setTag("0");
        card2.setTag("1");
        card3.setTag("2");
        card4.setTag("3");

        loadingImageView();

        Collections.shuffle((Arrays.asList(cardsArray)));

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int CardTag = Integer.parseInt((String) v.getTag());
                displayFaceUp(card1, CardTag);
            }
        });

        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int CardTag = Integer.parseInt((String) v.getTag());
                displayFaceUp(card2, CardTag);
            }
        });

        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int CardTag = Integer.parseInt((String) v.getTag());
                displayFaceUp(card3, CardTag);
            }
        });

        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int CardTag = Integer.parseInt((String) v.getTag());
                displayFaceUp(card4, CardTag);
            }
        });
    }

    private void loadingImageView() {
        animals_duck =  R.drawable.animals_duck;
        animals_pig =  R.drawable.animals_pig;
    }

    private void displayFaceUp(ImageView card, int cardTag) {
        if (cardsArray[cardTag] == 0 || cardsArray[cardTag] == 1 ) {
            card.setImageResource(animals_duck);
            duck = getDrawable(R.drawable.animals_duck);
        }
        else if (cardsArray[cardTag] == 2 || cardsArray[cardTag] == 3) {
            card.setImageResource(animals_pig);
            pig = getDrawable(R.drawable.animals_pig);
        }


        if (cardNumber == 1) {
            if (cardsArray[cardTag] == 0 || cardsArray[cardTag] == 1) {
                    firstCard = duck;
            }
            else if (cardsArray[cardTag] == 2 || cardsArray[cardTag] == 3) {
                firstCard = getDrawable(R.drawable.animals_duck);
            }

            cardNumber = 2;
            clickedFirst = cardTag;

            card.setEnabled(false);
        } else if (cardNumber == 2) {
            if (cardsArray[cardTag] == 0 || cardsArray[cardTag] == 1) {
                secondCard = getDrawable(R.drawable.animals_pig);
            }
            else if (cardsArray[cardTag] == 2 || cardsArray[cardTag] == 3) {
                firstCard = getDrawable(R.drawable.animals_duck);
            }

            cardNumber = 1;
            clickedSecond = cardTag;

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

    private void Calculate() {
        if (firstCard == secondCard) {
            if (clickedFirst == 0) {
                card1.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 1) {
                card2.setVisibility((View.INVISIBLE));
            } else if (clickedFirst == 2) {
                card3.setVisibility((View.INVISIBLE));
            } else if (clickedFirst == 3) {
                card4.setVisibility((View.INVISIBLE));
            }

            if (clickedSecond == 0) {
                card1.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 1) {
                card2.setVisibility((View.INVISIBLE));
            } else if (clickedSecond == 2) {
                card3.setVisibility((View.INVISIBLE));
            } else if (clickedSecond == 3) {
                card4.setVisibility((View.INVISIBLE));
            }
        }
        else {
            card1.setImageResource(R.drawable.hiddencard);
            card2.setImageResource(R.drawable.hiddencard);
            card3.setImageResource(R.drawable.hiddencard);
            card4.setImageResource(R.drawable.hiddencard);
        }

        card1.setEnabled(true);
        card2.setEnabled(true);
        card3.setEnabled(true);
        card4.setEnabled(true);
    }
}