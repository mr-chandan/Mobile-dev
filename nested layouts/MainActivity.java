package com.example.nestedlayouts;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container = findViewById(R.id.container);

        Button btnHorizontal = findViewById(R.id.btnHorizontal);
        Button btnVertical = findViewById(R.id.btnVertical);

        btnHorizontal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showHorizontalLayout();
            }
        });

        btnVertical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showVerticalLayout();
            }
        });
    }

    private void showHorizontalLayout() {
        container.removeAllViews();

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.HORIZONTAL);

        Button b1 = new Button(this);
        b1.setText("Button 1");
        layout.addView(b1);

        Button b2 = new Button(this);
        b2.setText("Button 2");
        layout.addView(b2);

        Button b3 = new Button(this);
        b3.setText("Button 3");
        layout.addView(b3);

        container.addView(layout);
    }

    private void showVerticalLayout() {
        container.removeAllViews();

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        Button b1 = new Button(this);
        b1.setText("Button A");
        layout.addView(b1);

        Button b2 = new Button(this);
        b2.setText("Button B");
        layout.addView(b2);

        Button b3 = new Button(this);
        b3.setText("Button C");
        layout.addView(b3);

        container.addView(layout);
    }
}
