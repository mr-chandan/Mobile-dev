package com.example.texteffect;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    boolean isBig=false, isRed=false, isCustomFont=false, isBold=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        Button sizeButton = findViewById(R.id.sizeButton);
        Button colorButton = findViewById(R.id.colorButton);
        Button fontButton = findViewById(R.id.fontButton);
        Button styleButton = findViewById(R.id.styleButton);

        sizeButton.setOnClickListener(v -> {
            textView.setTextSize(isBig ? 24 : 40);
            isBig = !isBig;
        });

        colorButton.setOnClickListener(v -> {
            textView.setTextColor(isRed ? Color.BLACK : Color.RED);
            isRed = !isRed;
        });

        fontButton.setOnClickListener(v -> {
            textView.setTypeface(isCustomFont ? Typeface.DEFAULT : Typeface.SERIF);
            isCustomFont = !isCustomFont;
        });

        styleButton.setOnClickListener(v -> {
            textView.setTypeface(null, isBold ? Typeface.ITALIC : Typeface.BOLD);
            isBold = !isBold;
        });
    }
}
