package com.example.menuapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_home)
            textView.setText("Home selected");
        else if (id == R.id.menu_profile)
            textView.setText("Profile selected");
        else if (id == R.id.menu_display)
            textView.setText("Display Settings");
        else if (id == R.id.menu_sound)
            textView.setText("Sound Settings");
        else if (id == R.id.menu_network)
            textView.setText("Network Settings");

        return super.onOptionsItemSelected(item);
    }
}
