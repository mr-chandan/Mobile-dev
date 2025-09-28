package com.example.registration;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etName, etEmail, etPassword;
    RadioGroup rgGender;
    RadioButton rbMale, rbFemale;
    CheckBox cbAgree;
    Button btnRegister;
    ImageView profileImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        rgGender = findViewById(R.id.rgGender);
        rbMale = findViewById(R.id.rbMale);
        rbFemale = findViewById(R.id.rbFemale);
        cbAgree = findViewById(R.id.cbAgree);
        btnRegister = findViewById(R.id.btnRegister);
        profileImage = findViewById(R.id.profileImage);

        btnRegister.setOnClickListener(v -> {
            String name = etName.getText().toString();
            String email = etEmail.getText().toString();
            String password = etPassword.getText().toString();

            String gender = "";
            int selectedId = rgGender.getCheckedRadioButtonId();
            if (selectedId == rbMale.getId()) gender = "Male";
            else if (selectedId == rbFemale.getId()) gender = "Female";

            if(name.isEmpty() || email.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            } else if (!cbAgree.isChecked()){
                Toast.makeText(this, "You must agree to T&C", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Registered!\nName: "+name+"\nEmail: "+email+"\nGender: "+gender, Toast.LENGTH_LONG).show();
            }
        });
    }
}
