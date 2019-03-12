package com.example.clashofforsan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EndOFGame extends AppCompatActivity {

        TextView mWinnerTextView;
        Button mNewGameButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_ofgame);
        mNewGameButton = findViewById(R.id.button_new_game_EndOfGame);
        mWinnerTextView = findViewById(R.id.tv_winner);
        mWinnerTextView.setText(getIntent().getStringExtra(getString(R.string.winner_key)));

        mNewGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              startActivity(  new Intent(getApplication(),SelectPlayers.class));
            }
        });

    }
}
