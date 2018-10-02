package com.example.andriginting.rockscissors;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button rock;
    private Button paper;
    private Button scissor;

    private ImageView userBoard;
    private ImageView enemyBoard;

    private Random randomNumber;

    private String userChoice, enemyChoice, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rock = findViewById(R.id.rock_button);
        paper = findViewById(R.id.paper_button);
        scissor = findViewById(R.id.scissor_button);
        userBoard = findViewById(R.id.user_side);
        enemyBoard = findViewById(R.id.enemy_side);

        //init random func
        randomNumber = new Random();

        rock.setOnClickListener(this);
        paper.setOnClickListener(this);
        scissor.setOnClickListener(this);
    }

    private void calculateScore() {
        int tempNumber = randomNumber.nextInt(3); //karena ada 3 pilihan

        if (tempNumber == 0 ){
            enemyChoice = "Rock";
            enemyBoard.setImageResource(R.drawable.rock);
        }else if (tempNumber == 1){
            enemyChoice = "Paper";
            enemyBoard.setImageResource(R.drawable.paper);
        }else{
            enemyChoice = "Scissor";
            enemyBoard.setImageResource(R.drawable.scissors);
        }


        //to get those result
        if (enemyChoice.equals("Rock") && userChoice.equals("Rock")){
            result = "Draw";
        }else if (enemyChoice.equals("Paper") && userChoice.equals("Rock")){
            result = "You Lose";
        }else if (enemyChoice.equals("Scissor") && userChoice.equals("Rock")){
            result = "You Win";
        }else if (enemyChoice.equals("Scissor") && userChoice.equals("Paper")){
            result = "You Lose";
        }else{
            result = "Draw";
        }

        Toast.makeText(this,result,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rock_button:
                userChoice = "Rock";
                userBoard.setImageResource(R.drawable.rock);
                calculateScore();

                break;

            case R.id.paper_button:
                userChoice = "Paper";
                userBoard.setImageResource(R.drawable.paper);
                calculateScore();
                break;

            case R.id.scissor_button:
                userChoice = "Scissor";
                userBoard.setImageResource(R.drawable.scissors);
                calculateScore();
                break;
        }
    }
}
