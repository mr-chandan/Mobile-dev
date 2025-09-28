package com.example.myapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etNum1, etNum2;
    TextView tvResult;
    Button btnAdd, btnSub, btnMul, btnDiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);
        tvResult = findViewById(R.id.tvResult);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = etNum1.getText().toString();
                String s2 = etNum2.getText().toString();

                if (s1.isEmpty() || s2.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Enter both numbers", Toast.LENGTH_SHORT).show();
                    return;
                }

                double n1 = Double.parseDouble(s1);
                double n2 = Double.parseDouble(s2);
                double result = 0;

                switch (v.getId()) {
                    case R.id.btnAdd:
                        result = n1 + n2;
                        break;
                    case R.id.btnSub:
                        result = n1 - n2;
                        break;
                    case R.id.btnMul:
                        result = n1 * n2;
                        break;
                    case R.id.btnDiv:
                        if (n2 == 0) {
                            Toast.makeText(MainActivity.this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        result = n1 / n2;
                        break;
                }

                tvResult.setText("Result: " + result);
            }
        };

        btnAdd.setOnClickListener(listener);
        btnSub.setOnClickListener(listener);
        btnMul.setOnClickListener(listener);
        btnDiv.setOnClickListener(listener);
    }
}
