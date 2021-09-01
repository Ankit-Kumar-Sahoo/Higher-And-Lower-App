package com.ankitkumarsahoo.higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int rand;

    public void MakeToast(String str) {

        TextView result = findViewById(R.id.result);

        result.setText(str);

        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    public void GuessFunction(View v) {

        EditText inputNum = findViewById(R.id.inputNum);
        int num = Integer.parseInt(inputNum.getText().toString());

        if (num == rand) {

            MakeToast("CORRECT! Press to play again!");
            rand = (int)(Math.random() * (20) + 1);
        }
        else {
            if (num < rand) {
                MakeToast("Go Higher!");
                inputNum.setText("");
            }
            if (num > rand) {
                MakeToast("Go Lower!");
                inputNum.setText("");
            }
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        int max = 20;
        int min = 1;
        rand = (int)(Math.random() * (max - min + 1) + min);
        // Random is defined here so that the random number will not change with every click
        // If we define Random in GuessFunction() then it will change with every click and the user will not able to guess the number

    }
}