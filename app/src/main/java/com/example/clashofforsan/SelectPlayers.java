package com.example.clashofforsan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class SelectPlayers extends AppCompatActivity {

     private EditText mPlayerOneEditText, mPlayerTwoEditText;
     private Button mStart;
     private RadioButton mPlayerOneRB, mPlayerTwoRB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_players);
        mPlayerOneEditText = findViewById(R.id.et_player_oen);
        mPlayerTwoEditText = findViewById(R.id.et_player_two);
        mStart = findViewById(R.id.button_start);
        mPlayerOneRB = findViewById(R.id.rb_player_one);
        mPlayerTwoRB = findViewById(R.id.rb_player_two);


        mStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String playerOneName = mPlayerOneEditText.getText().toString();
                String playerTwoName=  mPlayerTwoEditText.getText().toString();
                int startPlayer =0;
                if(mPlayerOneRB.isChecked())
                    startPlayer=1;
                else if (mPlayerTwoRB.isChecked())
                    startPlayer=2;

                Intent intent = new Intent(getApplication(),MainActivity.class);
                        intent.putExtra( getString( R.string.player_one_key), playerOneName);
                intent.putExtra( getString( R.string.player_two_key), playerTwoName);
                intent.putExtra( getString( R.string.player_to_start_key), String.valueOf( startPlayer));

                startActivity(intent);
            }
        });
    }
}
