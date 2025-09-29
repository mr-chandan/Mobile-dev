package com.example.texteffect;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    boolean isBig = false;
    boolean isRed = false;
    boolean isCustomFont = false;
    boolean isBold = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        Button sizeButton = findViewById(R.id.sizeButton);
        Button colorButton = findViewById(R.id.colorButton);
        Button fontButton = findViewById(R.id.fontButton);
        Button styleButton = findViewById(R.id.styleButton);

        // 🔸 Size button toggle
        sizeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBig) {
                    textView.setTextSize(24); // Normal size
                    isBig = false;
                } else {
                    textView.setTextSize(40); // Big size
                    isBig = true;
                }
            }
        });

        // 🔸 Color button toggle
        colorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isRed) {
                    textView.setTextColor(Color.BLACK);
                    isRed = false;
                } else {
                    textView.setTextColor(Color.RED);
                    isRed = true;
                }
            }
        });

        // 🔸 Font button toggle
        fontButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isCustomFont) {
                    textView.setTypeface(Typeface.DEFAULT);
                    isCustomFont = false;
                } else {
                    textView.setTypeface(Typeface.SERIF);
                    isCustomFont = true;
                }
            }
        });

        // 🔸 Style button toggle (Bold / Italic)
        styleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBold) {
                    textView.setTypeface(null, Typeface.ITALIC);
                    isBold = false;
                } else {
                    textView.setTypeface(null, Typeface.BOLD);
                    isBold = true;
                }
            }
        });
    }
}
