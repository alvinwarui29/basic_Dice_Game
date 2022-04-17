package com.example.onew;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnRoll = findViewById(R.id.btnrolldice);
        ImageView dice1 = findViewById(R.id.dice1);
        ImageView dice2 = findViewById(R.id.dice2);

        int[] dices = {
                (R.drawable.dice1),
                (R.drawable.dice2),
                (R.drawable.dice3),
                (R.drawable.dice4),
                (R.drawable.dice5),
                (R.drawable.dice6),
//                (R.drawable.dice1),

        };

        MediaPlayer mp = MediaPlayer.create(this,
                R.raw.dice_sound);

        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Random random = new Random();
                int rnNum = random.nextInt(6);
                int rnNum2 = random.nextInt(6);

                dice1.setImageResource(dices[rnNum]);
                dice2.setImageResource(dices[rnNum2]);

                YoYo.with(Techniques.BounceInDown)
                        .duration(700)
                        .repeat(0)
                        .playOn(dice1);
                YoYo.with(Techniques.BounceInDown)
                        .duration(700)
                        .repeat(0)
                        .playOn(dice2);

                mp.start();










            }
        });





    }
}