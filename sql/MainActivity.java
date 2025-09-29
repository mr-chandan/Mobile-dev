package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AlertDialog;

public class MainActivity extends AppCompatActivity {
    EditText name, contact, dob;
    Button insert, update, delete, view;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        contact = findViewById(R.id.contact);
        dob = findViewById(R.id.dob);
        insert = findViewById(R.id.insert);
        update = findViewById(R.id.update);
        delete = findViewById(R.id.delete);
        view = findViewById(R.id.view);

        db = new DBHelper(this);

        insert.setOnClickListener(v -> {
            boolean inserted = db.insertData(name.getText().toString(),
                    contact.getText().toString(),
                    dob.getText().toString());
            Toast.makeText(this, inserted ? "Inserted" : "Failed", Toast.LENGTH_SHORT).show();
        });

        update.setOnClickListener(v -> {
            boolean updated = db.updateData(name.getText().toString(),
                    contact.getText().toString(),
                    dob.getText().toString());
            Toast.makeText(this, updated ? "Updated" : "Failed", Toast.LENGTH_SHORT).show();
        });

        delete.setOnClickListener(v -> {
            boolean deleted = db.deleteData(name.getText().toString());
            Toast.makeText(this, deleted ? "Deleted" : "Not Found", Toast.LENGTH_SHORT).show();
        });

        view.setOnClickListener(v -> {
            Cursor c = db.getData();
            if (c.getCount() == 0) {
                Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
                return;
            }
            StringBuilder sb = new StringBuilder();
            while (c.moveToNext()) {
                sb.append("Name: ").append(c.getString(0)).append("\n")
                  .append("Contact: ").append(c.getString(1)).append("\n")
                  .append("DOB: ").append(c.getString(2)).append("\n\n");
            }
            new AlertDialog.Builder(this)
                    .setTitle("User Data")
                    .setMessage(sb.toString())
                    .setCancelable(true)
                    .show();
        });
    }
}
