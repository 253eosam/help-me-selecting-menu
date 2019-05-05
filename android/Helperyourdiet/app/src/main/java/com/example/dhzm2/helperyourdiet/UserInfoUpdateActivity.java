package com.example.dhzm2.helperyourdiet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

public class UserInfoUpdateActivity extends AppCompatActivity {

    CheckBox tasteGrainCheckBox, tasteFruitsCheckBox, tasteRoastCheckBox, tasteSoupCheckBox, tasteKimchiCheckBox,   //5
            tasteHerbSeedCheckBox, tasteSugarsCheckBox, tasteDriedBeansNutCheckBox, tasteCottonDumplingCheckBox,    //4
            tastePicklesCheckBox, tasteInfluenceCheckBox, tasteSaltedFishCheckBox, tasteGroatsCheckBox,             //4
            tastePorridgeCheckBox, tasteRiceCheckBox, tasteRoastingCheckBox, tasteSnackBarCheckBox,                 //4
            tasteBreadCheckBox, tasteRawCheckBox, tasteFishCheckBox, tasteIceCheckBox, tasteDairyCheckBox,          //5
            tasteBeverageCheckBox, tasteStewCheckBox, tasteSteamCheckBox, tasteVegetablesCheckBox,                  //4
            tasteFriedCheckBox, tastePizzaCheckBox, tasteHamburgerCheckBox; //29개                                  //3

    String[] times = {"1시", "2시", "3시", "4시", "5시", "6시", "7시", "8시", "9시", "10시", "11시", "12시",
            "13시", "14시", "15시", "16시", "17시", "18시", "19시", "20시", "21시", "22시", "23시", "24시"};

    Button restoreButton, saveButton;
    Spinner breakfastTimeSpinner, lunchTimeSpinner, dinnerTimeSpinner;
    CheckBox breakfastCheckBox, lunchCheckBox, dinnerCheckBox;
    LinearLayout breakfastLinearLayout, lunchLinearLayout, dinnerLinearLayout;
    EditText targetWeightEditText, breakfastAmountEditText, lunchAmountEditText ,dinnerAmountEditText;
    User member = User.getInstance();
    String Amount[] = member.getUserMealAmount().split("-");
    String Time[] = member.getUserMealTime().replace("시","").split("-");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info_update);

        tasteGrainCheckBox = findViewById(R.id.tasteGrainCheckBox);                     tasteFruitsCheckBox = findViewById(R.id.tasteFruitsCheckBox);
        tasteRoastCheckBox = findViewById(R.id.tasteRoastCheckBox);                     tasteSoupCheckBox = findViewById(R.id.tasteSoupCheckBox);
        tasteKimchiCheckBox = findViewById(R.id.tasteKimchiCheckBox);                   tasteHerbSeedCheckBox = findViewById(R.id.tasteHerbSeedCheckBox);
        tasteSugarsCheckBox = findViewById(R.id.tasteSugarsCheckBox);                   tasteDriedBeansNutCheckBox = findViewById(R.id.tasteDriedBeansNutCheckBox);
        tasteCottonDumplingCheckBox = findViewById(R.id.tasteCottonDumplingCheckBox);   tastePicklesCheckBox = findViewById(R.id.tastePicklesCheckBox);
        tasteInfluenceCheckBox = findViewById(R.id.tasteInfluenceCheckBox);             tasteSaltedFishCheckBox = findViewById(R.id.tasteSaltedFishCheckBox);
        tasteGroatsCheckBox = findViewById(R.id.tasteGroatsCheckBox);                   tastePorridgeCheckBox = findViewById(R.id.tastePorridgeCheckBox);
        tasteRiceCheckBox = findViewById(R.id.tasteRiceCheckBox);                       tasteRoastingCheckBox = findViewById(R.id.tasteRoastingCheckBox);
        tasteSnackBarCheckBox = findViewById(R.id.tasteSnackBarCheckBox);               tasteBreadCheckBox = findViewById(R.id.tasteBreadCheckBox);
        tasteRawCheckBox = findViewById(R.id.tasteRawCheckBox);                         tasteIceCheckBox = findViewById(R.id.tasteIceCheckBox);
        tasteBeverageCheckBox = findViewById(R.id.tasteBeverageCheckBox);               tasteFishCheckBox = findViewById(R.id.tasteFishCheckBox);
        tasteDairyCheckBox = findViewById(R.id.tasteDairyCheckBox);                     tasteStewCheckBox = findViewById(R.id.tasteStewCheckBox);
        tasteSteamCheckBox = findViewById(R.id.tasteSteamCheckBox);                     tasteVegetablesCheckBox = findViewById(R.id.tasteVegetablesCheckBox);
        tasteFriedCheckBox = findViewById(R.id.tasteFriedCheckBox);                     tastePizzaCheckBox = findViewById(R.id.tastePizzaCheckBox);
        tasteHamburgerCheckBox = findViewById(R.id.tasteHamburgerCheckBox);

        breakfastCheckBox = findViewById(R.id.breakfastCheckBox);
        lunchCheckBox = findViewById(R.id.lunchCheckBox);
        dinnerCheckBox = findViewById(R.id.dinnerCheckBox);

        breakfastTimeSpinner = findViewById(R.id.breakfastTimeSpinner);
        lunchTimeSpinner = findViewById(R.id.lunchTimeSpinner);
        dinnerTimeSpinner = findViewById(R.id.dinnerTimeSpinner);

        breakfastLinearLayout = findViewById(R.id.breakfastLinearLayout);
        lunchLinearLayout = findViewById(R.id.lunchLinearLayout);
        dinnerLinearLayout = findViewById(R.id.dinnerLinearLayout);

        targetWeightEditText = findViewById(R.id.targetWeightEditText);
        breakfastAmountEditText = findViewById(R.id.breakfastAmountEditText);
        lunchAmountEditText = findViewById(R.id.lunchAmountEditText);
        dinnerAmountEditText = findViewById(R.id.dinnerAmountEditText);

        restoreButton = findViewById(R.id.restoreButton);
        saveButton = findViewById(R.id.saveButton);

        targetWeightEditText.setText(member.getUserTargetWeight());

        breakfastAmountEditText.setText(Amount[0]);
        lunchAmountEditText.setText(Amount[1]);
        dinnerAmountEditText.setText(Amount[2]);

        restoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                targetWeightEditText.setText(member.getUserTargetWeight());

                breakfastAmountEditText.setText(Amount[0]);
                lunchAmountEditText.setText(Amount[1]);
                dinnerAmountEditText.setText(Amount[2]);

                breakfastTimeSpinner.setSelection(Integer.parseInt(Time[0]));
                lunchTimeSpinner.setSelection(Integer.parseInt(Time[1]));
                dinnerTimeSpinner.setSelection(Integer.parseInt(Time[2]));
            }
        });
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*member.setUserTargetWeight(targetWeightEditText.getText().toString());
                member.setUserMealTime(breakfastTimeSpinner.getSelectedItem().toString()+"-"+lunchTimeSpinner.getSelectedItem().toString()+"-"+
                        dinnerTimeSpinner.getSelectedItem().toString());
                member.setUserMealAmount(breakfastAmountEditText.getText().toString()+"-"+lunchAmountEditText.getText().toString()+"-"+
                        dinnerAmountEditText.getText().toString());

                try{
                    CustomTask task = new CustomTask("?");
                    String result = task.execute("&userTargetWeight="+member.getUserTargetWeight() + "&amountMeal="+member.getUserMealAmount()
                    + "&timeMeal="+member.getUserMealTime()).get();
                    task.cancel(true);

                    //  Log.i("통신 결과", "성공" + result);
                } catch (Exception e) {}*/
            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, times);

        breakfastTimeSpinner.setPrompt("--");
        breakfastTimeSpinner.setAdapter(adapter);
        lunchTimeSpinner.setPrompt("--");
        lunchTimeSpinner.setAdapter(adapter);
        dinnerTimeSpinner.setPrompt("--");
        dinnerTimeSpinner.setAdapter(adapter);

        if(Integer.parseInt(Time[0])>0){
            breakfastCheckBox.setChecked(true);
            breakfastLinearLayout.setVisibility(View.VISIBLE);
            breakfastTimeSpinner.setVisibility(View.VISIBLE);
            breakfastTimeSpinner.setSelection(Integer.parseInt(Time[0]));
        }
        if(Integer.parseInt(Amount[0])>0){
            lunchCheckBox.setChecked(true);
            lunchLinearLayout.setVisibility(View.VISIBLE);
            lunchTimeSpinner.setVisibility(View.VISIBLE);
            lunchTimeSpinner.setSelection(Integer.parseInt(Time[1]));
        }
        if(Integer.parseInt(Time[2])>0){
            dinnerCheckBox.setChecked(true);
            dinnerLinearLayout.setVisibility(View.VISIBLE);
            dinnerTimeSpinner.setVisibility(View.VISIBLE);
            dinnerTimeSpinner.setSelection(Integer.parseInt(Time[2]));
        }

        breakfastCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    breakfastLinearLayout.setVisibility(View.VISIBLE);
                    breakfastTimeSpinner.setVisibility(View.VISIBLE);
                }
                else if(!isChecked){
                    breakfastLinearLayout.setVisibility(View.GONE);
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
                    lunchLinearLayout.setVisibility(View.GONE);
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
                    dinnerLinearLayout.setVisibility(View.GONE);
                    dinnerTimeSpinner.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
}