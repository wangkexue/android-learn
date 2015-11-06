package com.example.wangkexue.myfirstapp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends ActionBarActivity {
    private static final int RANDOM_RANGE = 100;

    private int score;
    private int number1;
    private int number2;
    private final Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        score = 0;
        generateNumbers();
        setButtonText();
    }

    private void setButtonText() {
        Button b1 = (Button) findViewById(R.id.number1);
        Button b2 = (Button) findViewById(R.id.number2);
        b1.setText(number1 + "");
        b2.setText(number2 + "");
    }

    private void generateNumbers() {
        number1 = rand.nextInt(RANDOM_RANGE);
        number2 = rand.nextInt(RANDOM_RANGE);
        while (number2 == number1)
            number2 = rand.nextInt(RANDOM_RANGE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void button1_click(View view) {
        buttonClickHandler(view);
    }

    public void button2_click(View view) {
        buttonClickHandler(view);
    }

    private void buttonClickHandler(View view) {
        Button b = (Button) view;
        int num = Integer.parseInt(b.getText().toString());
        System.out.println(num);
        String message;
        if (num == Math.max(number1, number2)) {
            score++;
            message = "correct";
        } else {
            score--;
            message = "incorrect";
        }
        TextView scoreView = (TextView) findViewById(R.id.score);
        scoreView.setText("Points: " + score);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        generateNumbers();
        setButtonText();
    }
}
