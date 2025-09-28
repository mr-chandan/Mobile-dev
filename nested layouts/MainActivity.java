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

        findViewById(R.id.btnHorizontal).setOnClickListener(v -> showLayout(true));
        findViewById(R.id.btnVertical).setOnClickListener(v -> showLayout(false));
    }

    private void showLayout(boolean horizontal) {
        container.removeAllViews();

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(horizontal ? LinearLayout.HORIZONTAL : LinearLayout.VERTICAL);

        for (int i = 1; i <= 3; i++) {
            Button btn = new Button(this);
            btn.setText(horizontal ? "Button " + i : "Button " + (char)('A' + i - 1));
            layout.addView(btn);
        }

        container.addView(layout);
    }
}
