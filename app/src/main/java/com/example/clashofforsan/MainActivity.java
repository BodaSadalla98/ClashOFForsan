package com.example.clashofforsan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        String playerOneName;
        String playerTwoName;
        String playerServe;
        int start;
        int playerWithServe;
        int playerOneScore, playerTwoScore;

        TextView mPlayerOneName, mPlayerTwoName,mPlayerOneScore, mPlayerTwoScore, mPlayerServe;
        Button mAddPlayerOne,mAddPlayerTwo,mSubtractPlayerOne,mSubtractPlayerTwo, mNewGameButton,mRestartGameButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playerOneScore=0;
        playerTwoScore=0;
        start=0;
        mPlayerOneName=findViewById(R.id.tv_player_one_name);
        mPlayerTwoName= findViewById(R.id.tv_player_two_name);
        mPlayerOneScore= findViewById(R.id.tv_player_one_score);
        mPlayerTwoScore= findViewById(R.id.tv_player_two_score);
        mPlayerServe = findViewById(R.id.tv_player_with_serve);
        mAddPlayerOne = findViewById(R.id.button_add_player_one);
        mAddPlayerTwo=findViewById(R.id.button_add_player_two);
        mSubtractPlayerOne= findViewById(R.id.button_subtract_player_one);
        mSubtractPlayerTwo= findViewById(R.id.button_subtract_player_two);
        mNewGameButton = findViewById(R.id.button_new_game);
        mRestartGameButton= findViewById(R.id.button_restart_game);

        playerOneName = getIntent().getStringExtra(getString(R.string.player_one_key));
        playerTwoName = getIntent().getStringExtra(getString(R.string.player_two_key));
        start =Integer.parseInt( getIntent().getStringExtra(getString(R.string.player_to_start_key)));

            if(start==1)playerServe=playerOneName;
            else
                playerServe=playerTwoName;





                initialize(playerOneName,playerTwoName,playerServe,playerOneScore,playerTwoScore);
                playerWithServe=start;




        mAddPlayerTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateScore(1,2);
            }
        });
        mAddPlayerOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateScore(1,1);
            }
        });
        mSubtractPlayerTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateScore(-1,2);
            }
        });
        mSubtractPlayerOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateScore(-1,1);
            }
        });
        mNewGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(  new Intent(getApplication(),SelectPlayers.class));
            }
        });
        mRestartGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlayerTwoScore.setText(String.valueOf(0));
                mPlayerOneScore.setText(String.valueOf(0));
                playerOneScore=0;
                playerTwoScore=0;
                mPlayerServe.setText(playerServe);

            }
        });





    }

    private void initialize(String playerone,String playertwo, String serve, int scoreone, int scoretwo) {
            mPlayerOneName.setText(playerone);
            mPlayerTwoName.setText(playertwo);
            mPlayerServe.setText(serve);
            mPlayerTwoScore.setText(String.valueOf(scoretwo));
            mPlayerOneScore.setText(String.valueOf(scoreone));





    }


    private  void updateScore(int value, int player){






        if(player==1){
            playerOneScore+=value;
                mPlayerOneScore.setText( String.valueOf( playerOneScore));
        }

        else
        {
            playerTwoScore+=value;
            mPlayerTwoScore.setText(String.valueOf( playerTwoScore));
        }


        if((playerTwoScore)==21){
            win(2);
        }
        else if(playerOneScore ==21)
            win(1);

        if( ((playerOneScore+ playerTwoScore ) %5 ) ==  0){

            if(playerWithServe==1){
                mPlayerServe.setText(playerTwoName);
                playerWithServe=2;

            }
            else
            {
                mPlayerServe.setText(playerOneName);
                playerWithServe=1;

            }


        }

    }

    private void win(int winner) {

        Intent intent = new Intent(this,EndOFGame.class);
        if(winner==1)
        intent.putExtra(getString(R.string.winner_key),playerOneName);
        else
            intent.putExtra(getString(R.string.winner_key),playerTwoName);

        startActivity(intent);
    }

}



