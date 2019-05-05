package com.example.dhzm2.helperyourdiet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

public class ActiveQuestionnaireEnd extends AppCompatActivity {

    Button nextButton , beforeButton;
    EditText targetWeightEditText, breakfastAmountEditText, lunchAmountEditText ,dinnerAmountEditText;
    String[] times = {"1시", "2시", "3시", "4시", "5시", "6시", "7시", "8시", "9시", "10시", "11시", "12시",
            "13시", "14시", "15시", "16시", "17시", "18시", "19시", "20시", "21시", "22시", "23시", "24시"};
    Spinner breakfastTimeSpinner, lunchTimeSpinner, dinnerTimeSpinner;
    CheckBox breakfastCheckBox, lunchCheckBox, dinnerCheckBox;
    LinearLayout breakfastLinearLayout, lunchLinearLayout, dinnerLinearLayout;
    String target, breakAmount, breakTime, lunchAmount, lunchTime, dinnerAmount, dinnerTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_questionnaire_end);

        nextButton = findViewById(R.id.nextButton);
        beforeButton = findViewById(R.id.beforeButton);

        breakfastTimeSpinner = findViewById(R.id.breakfastTimeSpinner);
        lunchTimeSpinner = findViewById(R.id.lunchTimeSpinner);
        dinnerTimeSpinner = findViewById(R.id.dinnerTimeSpinner);

        breakfastCheckBox = findViewById(R.id.breakfastCheckBox);
        lunchCheckBox = findViewById(R.id.lunchCheckBox);
        dinnerCheckBox = findViewById(R.id.dinnerCheckBox);

        breakfastLinearLayout = findViewById(R.id.breakfastLinearLayout);
        lunchLinearLayout = findViewById(R.id.lunchLinearLayout);
        dinnerLinearLayout = findViewById(R.id.dinnerLinearLayout);

        targetWeightEditText = findViewById(R.id.targetWeightEditText);
        breakfastAmountEditText = findViewById(R.id.breakfastAmountEditText);
        lunchAmountEditText = findViewById(R.id.lunchAmountEditText);
        dinnerAmountEditText = findViewById(R.id.dinnerAmountEditText);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, times);

        breakfastTimeSpinner.setPrompt("--");
        breakfastTimeSpinner.setAdapter(adapter);
        lunchTimeSpinner.setPrompt("--");
        lunchTimeSpinner.setAdapter(adapter);
        dinnerTimeSpinner.setPrompt("--");
        dinnerTimeSpinner.setAdapter(adapter);


        breakfastCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    breakfastLinearLayout.setVisibility(View.VISIBLE);
                    breakfastTimeSpinner.setVisibility(View.VISIBLE);
                }
                else if(!isChecked){
                    breakfastLinearLayout.setVisibility(View.INVISIBLE);
                    breakfastTimeSpinner.setVisibility(View.INVISIBLE);
                }
            }
        });
        lunchCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    lunchLinearLayout.setVisibility(View.VISIBLE);
                    lunchTimeSpinner.setVisibility(View.VISIBLE);
                }
                else if(!isChecked){
                    lunchLinearLayout.setVisibility(View.INVISIBLE);
                    lunchTimeSpinner.setVisibility(View.INVISIBLE);
                }
            }
        });
        dinnerCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    dinnerLinearLayout.setVisibility(View.VISIBLE);
                    dinnerTimeSpinner.setVisibility(View.VISIBLE);
                }
                else if(!isChecked){
                    dinnerLinearLayout.setVisibility(View.INVISIBLE);
                    dinnerTimeSpinner.setVisibility(View.INVISIBLE);
                }
            }
        });
        breakfastTimeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Intent intent = getIntent();
        final User user = (User)intent.getSerializableExtra("user");
        final String q1 = intent.getExtras().getString("questionA1");
        final String q2h = intent.getExtras().getString("questionA2h");
        final String q2m = intent.getExtras().getString("questionA2m");
        final String q3 = intent.getExtras().getString("questionA3");
        final String q4h = intent.getExtras().getString("questionA4h");
        final String q4m = intent.getExtras().getString("questionA4m");
        final String q5 = intent.getExtras().getString("questionA5");
        final String q6h = intent.getExtras().getString("questionA6h");
        final String q6m = intent.getExtras().getString("questionA6m");
        final String q7h = intent.getExtras().getString("questionA7h");
        final String q7m = intent.getExtras().getString("questionA7m");


        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                target = targetWeightEditText.getText().toString();
                breakAmount = breakfastAmountEditText.getText().toString();
                lunchAmount = lunchAmountEditText.getText().toString();
                dinnerAmount = dinnerAmountEditText.getText().toString();
                breakTime = breakfastTimeSpinner.getSelectedItem().toString();
                lunchTime = lunchTimeSpinner.getSelectedItem().toString();
                dinnerTime = dinnerTimeSpinner.getSelectedItem().toString();

                if(breakAmount.equals(null) || breakAmount.length() <= 0){
                    breakAmount = "0";
                }
                if(lunchAmount.equals(null) || lunchAmount.length() <= 0){
                    lunchAmount = "0";
                }
                if(dinnerAmount.equals(null) || dinnerAmount.length() <= 0){
                    dinnerAmount = "0";
                }
                if(breakTime.equals(null) || breakTime.length() <= 0){
                    breakTime = "0";
                }
                if(lunchTime.equals(null) || lunchTime.length() <= 0){
                    lunchTime = "0";
                }
                if(dinnerTime.equals(null) || dinnerTime.length() <= 0){
                    dinnerTime = "0";
                }


                String userTime = breakTime + "-" + lunchTime + "-" + dinnerTime;
                String userAmount = breakAmount + "-" + lunchAmount + "-" + dinnerAmount;

                if(target.equals(null) || target.length() <= 0){
                    Toast.makeText(ActiveQuestionnaireEnd.this, "목표 체중 값을 입력해 주세요", Toast.LENGTH_LONG).show();
                }
                else{
                    user.setUserMealTime(userTime);
                    user.setUserMealAmount(userAmount);
                    user.setUserTargetWeight(target);

                    Intent intent = new Intent(ActiveQuestionnaireEnd.this,ActiveQuestionnaireEnd2.class );
                    intent.putExtra("user",user);
                    intent.putExtra("questionA1",q1);
                    intent.putExtra("questionA2h",q2h);
                    intent.putExtra("questionA2m",q2m);
                    intent.putExtra("questionA3",q3);
                    intent.putExtra("questionA4h",q4h);
                    intent.putExtra("questionA4m",q4m);
                    intent.putExtra("questionA5",q5);
                    intent.putExtra("questionA6h",q6h);
                    intent.putExtra("questionA6m",q6m);
                    intent.putExtra("questionA7h",q7h);
                    intent.putExtra("questionA7m",q7m);
                    startActivity(intent);
                    overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_left);
                }
            }
        });


        beforeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_right);
            }
        });
    }
}
