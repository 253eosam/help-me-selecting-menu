package com.example.dhzm2.helperyourdiet;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import java.util.ArrayList;

public class ActiveQuestionnaireEnd2 extends AppCompatActivity {

    Button finishButton , beforeButton;
    CheckBox tasteGrainCheckBox, tasteFruitsCheckBox, tasteRoastCheckBox, tasteSoupCheckBox, tasteKimchiCheckBox,   //5
            tasteHerbSeedCheckBox, tasteSugarsCheckBox, tasteDriedBeansNutCheckBox, tasteCottonDumplingCheckBox,    //4
            tastePicklesCheckBox, tasteInfluenceCheckBox, tasteSaltedFishCheckBox, tasteGroatsCheckBox,             //4
            tastePorridgeCheckBox, tasteRiceCheckBox, tasteRoastingCheckBox, tasteSnackBarCheckBox,                 //4
            tasteBreadCheckBox, tasteRawCheckBox, tasteFishCheckBox, tasteIceCheckBox, tasteDairyCheckBox,          //5
            tasteBeverageCheckBox, tasteStewCheckBox, tasteSteamCheckBox, tasteVegetablesCheckBox,                  //4
            tasteFriedCheckBox, tastePizzaCheckBox, tasteHamburgerCheckBox; //29개                                  //3
    ArrayList<String> userTaste = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_questionnaire_end2);

        finishButton = findViewById(R.id.finishButton);                                   beforeButton = findViewById(R.id.beforeButton);

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



        CheckBox.OnCheckedChangeListener onCheckedChangeListener = new CheckBox.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                switch (buttonView.getId()){
                    case R.id.tasteGrainCheckBox :
                        if(tasteGrainCheckBox.isChecked()){
                            userTaste.add(tasteGrainCheckBox.getText().toString());
                        }
                        else if(!tasteGrainCheckBox.isChecked()){
                            userTaste.remove(tasteGrainCheckBox.getText().toString());
                        }
                        break;
                    case R.id.tasteRoastCheckBox :
                        if(tasteRoastCheckBox.isChecked()){
                            userTaste.add(tasteRoastCheckBox.getText().toString());
                        }
                        else if(!tasteRoastCheckBox.isChecked()){
                            userTaste.remove(tasteRoastCheckBox.getText().toString());
                        }
                        break;
                    case R.id.tasteKimchiCheckBox :
                        if(tasteKimchiCheckBox.isChecked()){
                            userTaste.add(tasteKimchiCheckBox.getText().toString());
                        }
                        else if(!tasteKimchiCheckBox.isChecked()){
                            userTaste.remove(tasteKimchiCheckBox.getText().toString());
                        }
                        break;
                    case R.id.tasteSugarsCheckBox :
                        if(tasteSugarsCheckBox.isChecked()){
                            userTaste.add(tasteSugarsCheckBox.getText().toString());
                        }
                        else if(!tasteSugarsCheckBox.isChecked()){
                            userTaste.remove(tasteSugarsCheckBox.getText().toString());
                        }
                        break;
                    case R.id.tasteCottonDumplingCheckBox :
                        if(tasteCottonDumplingCheckBox.isChecked()){
                            userTaste.add(tasteCottonDumplingCheckBox.getText().toString());
                        }
                        else if(!tasteCottonDumplingCheckBox.isChecked()){
                            userTaste.remove(tasteCottonDumplingCheckBox.getText().toString());
                        }
                        break;
                    case R.id.tasteInfluenceCheckBox :
                        if(tasteInfluenceCheckBox.isChecked()){
                            userTaste.add(tasteInfluenceCheckBox.getText().toString());
                        }
                        else if(!tasteInfluenceCheckBox.isChecked()){
                            userTaste.remove(tasteInfluenceCheckBox.getText().toString());
                        }
                        break;
                    case R.id.tasteGroatsCheckBox :
                        if(tasteGroatsCheckBox.isChecked()){
                            userTaste.add(tasteGroatsCheckBox.getText().toString());
                        }
                        else if(!tasteGroatsCheckBox.isChecked()){
                            userTaste.remove(tasteGroatsCheckBox.getText().toString());
                        }
                        break;
                    case R.id.tasteRiceCheckBox :
                        if(tasteRiceCheckBox.isChecked()){
                            userTaste.add(tasteRiceCheckBox.getText().toString());
                        }
                        else if(!tasteRiceCheckBox.isChecked()){
                            userTaste.remove(tasteRiceCheckBox.getText().toString());
                        }
                        break;
                    case R.id.tasteSnackBarCheckBox :
                        if(tasteSnackBarCheckBox.isChecked()){
                            userTaste.add(tasteSnackBarCheckBox.getText().toString());
                        }
                        else if(!tasteSnackBarCheckBox.isChecked()){
                            userTaste.remove(tasteSnackBarCheckBox.getText().toString());
                        }
                        break;
                    case R.id.tasteRawCheckBox :
                        if(tasteRawCheckBox.isChecked()){
                            userTaste.add(tasteRawCheckBox.getText().toString());
                        }
                        else if(!tasteRawCheckBox.isChecked()){
                            userTaste.remove(tasteRawCheckBox.getText().toString());
                        }
                        break;
                    case R.id.tasteBeverageCheckBox :
                        if(tasteBeverageCheckBox.isChecked()){
                            userTaste.add(tasteBeverageCheckBox.getText().toString());
                        }
                        else if(!tasteBeverageCheckBox.isChecked()){
                            userTaste.remove(tasteBeverageCheckBox.getText().toString());
                        }
                        break;
                    case R.id.tasteDairyCheckBox :
                        if(tasteDairyCheckBox.isChecked()){
                            userTaste.add(tasteDairyCheckBox.getText().toString());
                        }
                        else if(!tasteDairyCheckBox.isChecked()){
                            userTaste.remove(tasteDairyCheckBox.getText().toString());
                        }
                        break;
                    case R.id.tasteSteamCheckBox :
                        if(tasteSteamCheckBox.isChecked()){
                            userTaste.add(tasteSteamCheckBox.getText().toString());
                        }
                        else if(!tasteSteamCheckBox.isChecked()){
                            userTaste.remove(tasteSteamCheckBox.getText().toString());
                        }
                        break;
                    case R.id.tasteFriedCheckBox :
                        if(tasteFriedCheckBox.isChecked()){
                            userTaste.add(tasteFriedCheckBox.getText().toString());
                        }
                        else if(!tasteFriedCheckBox.isChecked()){
                            userTaste.remove(tasteFriedCheckBox.getText().toString());
                        }
                        break;
                    case R.id.tasteHamburgerCheckBox :
                        if(tasteHamburgerCheckBox.isChecked()){
                            userTaste.add(tasteHamburgerCheckBox.getText().toString());
                        }
                        else if(!tasteHamburgerCheckBox.isChecked()){
                            userTaste.remove(tasteHamburgerCheckBox.getText().toString());
                        }
                        break;
                    ////--------------------------------------------------------------------------------
                    case R.id.tasteFruitsCheckBox :
                        if(tasteFruitsCheckBox.isChecked()){
                            userTaste.add(tasteFruitsCheckBox.getText().toString());
                        }
                        else if(!tasteFruitsCheckBox.isChecked()){
                            userTaste.remove(tasteFruitsCheckBox.getText().toString());
                        }
                        break;
                    case R.id.tasteSoupCheckBox :
                        if(tasteSoupCheckBox.isChecked()){
                            userTaste.add(tasteSoupCheckBox.getText().toString());
                        }
                        else if(!tasteSoupCheckBox.isChecked()){
                            userTaste.remove(tasteSoupCheckBox.getText().toString());
                        }
                        break;
                    case R.id.tasteHerbSeedCheckBox :
                        if(tasteHerbSeedCheckBox.isChecked()){
                            userTaste.add(tasteHerbSeedCheckBox.getText().toString());
                        }
                        else if(!tasteHerbSeedCheckBox.isChecked()){
                            userTaste.remove(tasteHerbSeedCheckBox.getText().toString());
                        }
                        break;
                    case R.id.tasteDriedBeansNutCheckBox :
                        if(tasteDriedBeansNutCheckBox.isChecked()){
                            userTaste.add(tasteDriedBeansNutCheckBox.getText().toString());
                        }
                        else if(!tasteDriedBeansNutCheckBox.isChecked()){
                            userTaste.remove(tasteDriedBeansNutCheckBox.getText().toString());
                        }
                        break;
                    case R.id.tastePicklesCheckBox :
                        if(tastePicklesCheckBox.isChecked()){
                            userTaste.add(tastePicklesCheckBox.getText().toString());
                        }
                        else if(!tastePicklesCheckBox.isChecked()){
                            userTaste.remove(tastePicklesCheckBox.getText().toString());
                        }
                        break;
                    case R.id.tasteSaltedFishCheckBox :
                        if(tasteSaltedFishCheckBox.isChecked()){
                            userTaste.add(tasteSaltedFishCheckBox.getText().toString());
                        }
                        else if(!tasteSaltedFishCheckBox.isChecked()){
                            userTaste.remove(tasteSaltedFishCheckBox.getText().toString());
                        }
                        break;
                    case R.id.tastePorridgeCheckBox :
                        if(tastePorridgeCheckBox.isChecked()){
                            userTaste.add(tastePorridgeCheckBox.getText().toString());
                        }
                        else if(!tastePorridgeCheckBox.isChecked()){
                            userTaste.remove(tastePorridgeCheckBox.getText().toString());
                        }
                        break;
                    case R.id.tasteRoastingCheckBox :
                        if(tasteRoastingCheckBox.isChecked()){
                            userTaste.add(tasteRoastingCheckBox.getText().toString());
                        }
                        else if(!tasteRoastingCheckBox.isChecked()){
                            userTaste.remove(tasteRoastingCheckBox.getText().toString());
                        }
                        break;
                    case R.id.tasteBreadCheckBox :
                        if(tasteBreadCheckBox.isChecked()){
                            userTaste.add(tasteBreadCheckBox.getText().toString());
                        }
                        else if(!tasteBreadCheckBox.isChecked()){
                            userTaste.remove(tasteBreadCheckBox.getText().toString());
                        }
                        break;
                    case R.id.tasteIceCheckBox :
                        if(tasteIceCheckBox.isChecked()){
                            userTaste.add(tasteIceCheckBox.getText().toString());
                        }
                        else if(!tasteIceCheckBox.isChecked()){
                            userTaste.remove(tasteIceCheckBox.getText().toString());
                        }
                        break;
                    case R.id.tasteFishCheckBox :
                        if(tasteFishCheckBox.isChecked()){
                            userTaste.add(tasteFishCheckBox.getText().toString());
                        }
                        else if(!tasteFishCheckBox.isChecked()){
                            userTaste.remove(tasteFishCheckBox.getText().toString());
                        }
                        break;
                    case R.id.tasteStewCheckBox :
                        if(tasteStewCheckBox.isChecked()){
                            userTaste.add(tasteStewCheckBox.getText().toString());
                        }
                        else if(!tasteStewCheckBox.isChecked()){
                            userTaste.remove(tasteStewCheckBox.getText().toString());
                        }
                        break;
                    case R.id.tasteVegetablesCheckBox :
                        if(tasteVegetablesCheckBox.isChecked()){
                            userTaste.add(tasteVegetablesCheckBox.getText().toString());
                        }
                        else if(!tasteVegetablesCheckBox.isChecked()){
                            userTaste.remove(tasteVegetablesCheckBox.getText().toString());
                        }
                        break;
                    case R.id.tastePizzaCheckBox :
                        if(tastePizzaCheckBox.isChecked()){
                            userTaste.add(tastePizzaCheckBox.getText().toString());
                        }
                        else if(!tastePizzaCheckBox.isChecked()){
                            userTaste.remove(tastePizzaCheckBox.getText().toString());
                        }
                        break;

                }
            }
        };

        tasteGrainCheckBox.setOnCheckedChangeListener(onCheckedChangeListener);
        tasteRoastCheckBox.setOnCheckedChangeListener(onCheckedChangeListener);              tasteFruitsCheckBox.setOnCheckedChangeListener(onCheckedChangeListener);
        tasteKimchiCheckBox.setOnCheckedChangeListener(onCheckedChangeListener);             tasteSoupCheckBox.setOnCheckedChangeListener(onCheckedChangeListener);
        tasteSugarsCheckBox.setOnCheckedChangeListener(onCheckedChangeListener);             tasteHerbSeedCheckBox.setOnCheckedChangeListener(onCheckedChangeListener);
        tasteCottonDumplingCheckBox.setOnCheckedChangeListener(onCheckedChangeListener);     tasteDriedBeansNutCheckBox.setOnCheckedChangeListener(onCheckedChangeListener);
        tasteInfluenceCheckBox.setOnCheckedChangeListener(onCheckedChangeListener);          tastePicklesCheckBox.setOnCheckedChangeListener(onCheckedChangeListener);
        tasteGroatsCheckBox.setOnCheckedChangeListener(onCheckedChangeListener);             tasteSaltedFishCheckBox.setOnCheckedChangeListener(onCheckedChangeListener);
        tasteRiceCheckBox.setOnCheckedChangeListener(onCheckedChangeListener);               tastePorridgeCheckBox.setOnCheckedChangeListener(onCheckedChangeListener);
        tasteSnackBarCheckBox.setOnCheckedChangeListener(onCheckedChangeListener);           tasteRoastingCheckBox.setOnCheckedChangeListener(onCheckedChangeListener);
        tasteRawCheckBox.setOnCheckedChangeListener(onCheckedChangeListener);                tasteBreadCheckBox.setOnCheckedChangeListener(onCheckedChangeListener);
        tasteBeverageCheckBox.setOnCheckedChangeListener(onCheckedChangeListener);           tasteIceCheckBox.setOnCheckedChangeListener(onCheckedChangeListener);
        tasteDairyCheckBox.setOnCheckedChangeListener(onCheckedChangeListener);              tasteFishCheckBox.setOnCheckedChangeListener(onCheckedChangeListener);
        tasteSteamCheckBox.setOnCheckedChangeListener(onCheckedChangeListener);              tasteStewCheckBox.setOnCheckedChangeListener(onCheckedChangeListener);
        tasteFriedCheckBox.setOnCheckedChangeListener(onCheckedChangeListener);              tasteVegetablesCheckBox.setOnCheckedChangeListener(onCheckedChangeListener);
        tasteHamburgerCheckBox.setOnCheckedChangeListener(onCheckedChangeListener);          tastePizzaCheckBox.setOnCheckedChangeListener(onCheckedChangeListener);


        Intent intent = getIntent();
        final User user = (User)intent.getSerializableExtra("user");
        final double q1 = Double.parseDouble(intent.getExtras().getString("questionA1"));
        final double q2h = Double.parseDouble(intent.getExtras().getString("questionA2h"));
        final double q2m = Double.parseDouble(intent.getExtras().getString("questionA2m"));
        final double q3 = Double.parseDouble(intent.getExtras().getString("questionA3"));
        final double q4h = Double.parseDouble(intent.getExtras().getString("questionA4h"));
        final double q4m = Double.parseDouble(intent.getExtras().getString("questionA4m"));
        final double q5 = Double.parseDouble(intent.getExtras().getString("questionA5"));
        final double q6h = Double.parseDouble(intent.getExtras().getString("questionA6h"));
        final double q6m = Double.parseDouble(intent.getExtras().getString("questionA6m"));
        final double q7h = Double.parseDouble(intent.getExtras().getString("questionA7h"));
        final double q7m = Double.parseDouble(intent.getExtras().getString("questionA7m"));

        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alertdialogBuilder = new AlertDialog.Builder(ActiveQuestionnaireEnd2.this);
                alertdialogBuilder.setMessage("회원가입을 하시겠습니까?").setCancelable(false)
                        .setNegativeButton("아니요",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(
                                            DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                })
                        .setPositiveButton("예",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(
                                            DialogInterface dialog, int id) {

                                        double MET_minutes = (q1 * (q2h * 60 + q2m) * 8 ) + (q3 * (q4h * 60 + q4m) * 4) + (q5 * (q6h * 60 + q6m) * 3.3) + ( q7h* 60 + q7m );
                                        double MET_A = q1 * (q2h * 60 + q2m) * 8 ;

                                        if(( q1 >= 3 && MET_A >= 1500 ) || MET_minutes >= 3000 ){
                                            user.setUserActive("A");
                                        }
                                        else if((q1 >= 3 && (q2h * 60 + q2m) >= 20) || (q3 >= 5 && (q4h * 60 + q4m) >= 30) || (q1 + q3 + q5 >= 5 && MET_minutes >= 600 )){
                                            user.setUserActive("B");
                                        }
                                        else {
                                            user.setUserActive("C");
                                        }

                                        user.setUserFoodTaste(userTaste);

                                        double userStandardWeight = (Double.parseDouble(user.getUserHeight()) - 100 ) * 0.9 ;
                                        String userAtctive = user.getUserActive();
                                        if(userAtctive.equals("A")){
                                            double temp = userStandardWeight * 40;
                                            user.setUserRDA(Double.toString(temp));
                                        }
                                        else if(userAtctive.equals("B")){
                                            double temp = userStandardWeight * 32.5;
                                            user.setUserRDA(Double.toString(temp));
                                        }
                                        else if(userAtctive.equals("C")){
                                            double temp = userStandardWeight * 25;
                                            user.setUserRDA(Double.toString(temp));
                                        }

                                        boolean registerUserIs = false;
                                        try{

                                            CustomTask task = new CustomTask("insertUser.jsp");
                                            String result = task.execute( "userID=" + user.getUserID() +
                                                    "&userPassword=" + user.getUserPassword() + "&userName=" + user.getUserName() +
                                                    "&userAge=" + user.getUserAge() + "&userSex=" + user.getUserSex() +
                                                    "&userHeight=" + user.getUserHeight() + "&userWeight=" + user.getUserWeight() +
                                                    "&userTargetWeight=" + user.getUserTargetWeight() + "&userActivity=" + user.getUserActive() +
                                                    "&amountMeal=" + user.getUserMealAmount() + "&timeMeal=" + user.getUserMealTime()
                                                    + "&RDA=" + user.getUserRDA()
                                            ).get();
                                            task.cancel(true);
                                            Log.d(this.getClass().getName(),"test 반환 값 = "+result);
                                            registerUserIs = true;

                                            String[] amount_meal = user.getUserMealAmount().split("-");

                                            CustomTask task2 = new CustomTask("insertUserExpectKcal.jsp");
                                            String result2 = task2.execute("userID=" + user.getUserID() + "&fristMeal=" + amount_meal[0] + "&secondMeal=" + amount_meal[1] + "&thirdMeal=" + amount_meal[2]).get();
                                            task2.cancel(true);
                                            Log.d(this.getClass().getName(),"test2 반환 값 = "+result2);

                                        }catch (Exception e){
                                            Toast.makeText(ActiveQuestionnaireEnd2.this, "회원가입 실패", Toast.LENGTH_SHORT).show();
                                        }finally {
                                            if(registerUserIs){
                                                try{
                                                    for(String t : user.getUserFoodTaste()){
                                                        Log.d(this.getClass().getName(), "test taste = " + t);
                                                        CustomTask ct = new CustomTask("insertUserTaste.jsp");
                                                        String tasteResult = ct.execute("userID=" + user.getUserID() + "&userTasteMeal=" + t).get();
                                                        ct.cancel(true);
                                                        Log.d(this.getClass().getName(), "test taste = " + t + " -> " + tasteResult);
                                                    }
                                                }catch(Exception e){
                                                    Log.d(this.getClass().getName(), "test taste = 실패" );
                                                }
                                            }
                                        }

                                        Intent nextIntent = new Intent(ActiveQuestionnaireEnd2.this,LoginActivity.class);
                                        nextIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                        startActivity(nextIntent);
                                        finish();
                                    }
                                }).show();






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
