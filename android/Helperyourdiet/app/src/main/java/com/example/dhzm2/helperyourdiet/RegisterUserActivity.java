package com.example.dhzm2.helperyourdiet;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RegisterUserActivity extends AppCompatActivity {

    EditText userIDEditText, userPasswordEditText, userNameEditText, userAgeEditText, userHeightEditText, userWeightEditText;
    RadioGroup sexRadioGroup;
    Button nextButton, cancelButton;
    String id, pwd, name, age, h, w, s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        userIDEditText = findViewById(R.id.userIDEditText);
        userPasswordEditText = findViewById(R.id.userPasswordEditText);
        userNameEditText = findViewById(R.id.userNameEditText);
        userAgeEditText = findViewById(R.id.userAgeEditText);
        userHeightEditText = findViewById(R.id.userHeightEditText);
        userWeightEditText = findViewById(R.id.userWeightEditText);

        sexRadioGroup = findViewById(R.id.sexRadioGroup); s="";

        nextButton = findViewById(R.id.nextButton);
        cancelButton = findViewById(R.id.cancelButton);


        sexRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.sexManRadioButton:
                        s = "man";
                        break;
                    case R.id.sexWomanRadioButton:
                        s = "woman";
                        break;
                }
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = userIDEditText.getText().toString();
                pwd = userPasswordEditText.getText().toString();
                name = userNameEditText.getText().toString();
                age = userAgeEditText.getText().toString();
                h = userHeightEditText.getText().toString();
                w = userWeightEditText.getText().toString();
                if (id.equals(null) || pwd.equals(null) || name.equals(null) || age.equals(null) || h.equals(null) || w.equals(null) || s.equals(null) ||
                        id.length() <= 0 || pwd.length() <= 0 || name.length() <= 0 || age.length() <= 0 || h.length() <= 0 || w.length() <= 0 || s.length() <= 0) {
                    Toast.makeText(RegisterUserActivity.this, "위 입력란에 값을 입력해 주세요", Toast.LENGTH_LONG).show();

                } else {
                    User user = new User(id, pwd, name, age, h, w, s);

                    Intent intent = new Intent(RegisterUserActivity.this, ActiveQuestionnaireA.class);
                    intent.putExtra("user", user);

                    startActivity(intent);
                    overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_left);

                }
            }
        });


        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }



}
