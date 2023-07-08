package com.example.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.tictactoe.databinding.ActivityAddPlayerBinding;

import androidx.appcompat.app.AppCompatActivity;

public class AddPlayerActivity extends AppCompatActivity {

    ActivityAddPlayerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddPlayerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.startGameButton.setOnClickListener(v -> {
            String playerOneName = binding.playerOne.getText().toString();
            String playerTwoName = binding.playerTwo.getText().toString();

            if (playerOneName.isEmpty()) {
                Toast.makeText(AddPlayerActivity.this, getString(R.string.please_enter_player_one_name), Toast.LENGTH_LONG)
                        .show();
            } else if (playerTwoName.isEmpty()) {
                Toast.makeText(AddPlayerActivity.this, getString(R.string.please_enter_player_two_name), Toast.LENGTH_LONG)
                        .show();
            } else {
                Intent intent = new Intent(AddPlayerActivity.this, MainActivity.class);
                intent.putExtra("playerOne", playerOneName);
                intent.putExtra("playerTwo", playerTwoName);
                startActivity(intent);

            }
        });

    }
}