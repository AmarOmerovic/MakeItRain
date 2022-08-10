package com.amaromerovic.makeitrain;

import android.graphics.Color;
import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.snackbar.Snackbar;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView moneyValue;
    private TextView motivationalText;
    private double moneyCounter = 0.0;
    private final DecimalFormat dFormat = new DecimalFormat("####,###,###.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moneyValue = findViewById(R.id.moneyValue);
        motivationalText = findViewById(R.id.motivationalText);

    }

    public void showMoney(View view) {
        Log.d("MainActivity", "onCreate: Make it rain from method!");

        Random randomNumber = new Random();
        int limit = 5000;
        moneyCounter += randomNumber.nextDouble() + randomNumber.nextInt(limit);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("$").append(dFormat.format(moneyCounter));

        if (moneyCounter > 100000000) {
            moneyValue.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.custom_red));
            motivationalText.setText(R.string.motivationalTextStage5);
        } else if (moneyCounter > 10000000) {
            moneyValue.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.custom_orange));
            motivationalText.setText(R.string.motivationalTextStage4);
        } else if (moneyCounter > 1000000) {
            moneyValue.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.custom_green));
            motivationalText.setText(R.string.motivationalTextStage3);
        } else if (moneyCounter > 500000) {
            moneyValue.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.purple_700));
            motivationalText.setText(R.string.motivationalTextStage2);
        } else if (moneyCounter > 100000) {
            moneyValue.setTextColor(Color.MAGENTA);
            motivationalText.setText(R.string.motivationalTextStage1);
        }

        moneyValue.setText(stringBuilder);

    }

    public void showInfo(View view) {
        Snackbar.make(moneyValue, R.string.app_info, Snackbar.LENGTH_SHORT).setAction("More", view1 -> {
            Log.d("SnackBar:", "showInfo: SnackBar pressed");
        }).show();

    }

}