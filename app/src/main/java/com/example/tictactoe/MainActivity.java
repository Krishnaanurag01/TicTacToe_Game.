package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean gameActive = true;
    int[] state = {2,2,2,2,2,2,2,2,2};
    int[][] winPosition= {{0,1,2},{3,4,5},{6,7,8},
                      {0,3,6},{1,4,7},{2,5,8},
                      {2,4,6},{0,4,8}    };
    int activeplayer=0;

    public void onTap(View view){
        ImageView imageView = (ImageView) view;
        int tappedImage =Integer.parseInt(imageView.getTag().toString());
        TextView textStatus = (TextView)findViewById(R.id.status);
        if(!gameActive){
            gameReset(view);
        }
        if(state[tappedImage-1]==2){
            state[tappedImage-1]=activeplayer;
            imageView.setTranslationY(-1000f);
            if (activeplayer==0){
                imageView.setImageResource(R.drawable.o);
                textStatus.setText("Player 02 Turns!");
                activeplayer=1;
            }else{
                imageView.setImageResource(R.drawable.x);
                activeplayer=0;
                textStatus.setText("Player 01 Turns !");
            }
        imageView.animate().translationYBy(1000f).setDuration(100);
    }
        for (int[] winPos: winPosition) {
            if(state[winPos[0]] == state[winPos[1]] && state[winPos[1]] == state[winPos[2]] && state[winPos[1]]!=2){
                gameActive=false;
                if (state[winPos[0]]==0){
                    textStatus.setText("Player 01 Has Won The Game !");
                }else {
                    textStatus.setText("Player 02 Has Won The Game !");
                }
            }

        }
    }

    public void gameReset(View view){
        gameActive=true;
        activeplayer=0;
        for (int i = 0; i<state.length;i++ ){
            state[i]=2;
        }
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);

        TextView textStatus = (TextView)findViewById(R.id.status);
        textStatus.setText("Player 01 Turns !");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}