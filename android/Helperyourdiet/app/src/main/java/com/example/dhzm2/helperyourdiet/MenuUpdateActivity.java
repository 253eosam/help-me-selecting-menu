package com.example.dhzm2.helperyourdiet;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MenuUpdateActivity extends AppCompatActivity {

    LinearLayout breakfastLinearLayout, lunchLinearLayout, dinnerLinearLayout;
    TextView dateTextView;
    ImageView dateImageView;
    TextView breakfastText, lunchText, dinnerText;
    TextView breakfastViewEditText, lunchViewEditText, dinnerViewEditText;

    Button dialogCancelButton, dialogOkButton, addListButton;
    User member ;
    String getTime;
    String [] foodTypeStr = {"곡류","과일류", "구이류", "국 미 탕류", "김치류", "나물/숙채류" , "당류", "두부,견과류" , "면 및 만두류", "장아찌/절임류",
    "전/적 및 부침류", "젓갈류", "조림류", "죽 및 스프류" , "밥류", "볶음류", "분식", "빵 및 과자류", "생채/무침류", "수조어육류", " 아이스크림","유제품류 및 빙과류"
    , "음료", "찌개 및 전골류", "찜류", "채소,해조류", "튀김류", "피자", "햄버거"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_update);

        breakfastLinearLayout = findViewById(R.id.breakfastLinearLayout);
        lunchLinearLayout = findViewById(R.id.lunchLinearLayout);
        dinnerLinearLayout = findViewById(R.id.dinnerLinearLayout);

        breakfastViewEditText = findViewById(R.id.breakfastViewEditText);
        lunchViewEditText = findViewById(R.id.lunchViewEditText);
        dinnerViewEditText = findViewById(R.id.dinnerViewEditText);

        dateTextView = findViewById(R.id.dateTextView);
        dateImageView = findViewById(R.id.dateImageView);

        breakfastText = findViewById(R.id.breakfastText);
        lunchText = findViewById(R.id.lunchText);
        dinnerText = findViewById(R.id.dinnerText);

        member = User.getInstance();

        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        getTime = sdf.format(date);
        dateTextView.setText(getTime);

        try{
            CustomTask menuListTask = new CustomTask("MenuList.jsp");
            String f_menuListResult = menuListTask.execute("userID=" + member.getUserID() + "&date=" + getTime + "&meal=" + "첫끼").get();
            menuListTask.cancel(true);

            menuListTask = new CustomTask("MenuList.jsp");
            String s_menuListResult = menuListTask.execute("userID=" + member.getUserID() + "&date=" + getTime + "&meal=" + "두끼").get();
            menuListTask.cancel(true);

            menuListTask = new CustomTask("MenuList.jsp");
            String t_menuListResult = menuListTask.execute("userID=" + member.getUserID() + "&date=" + getTime + "&meal=" + "셋끼").get();
            menuListTask.cancel(true);

            String[] arr_f1 = f_menuListResult.split("`");
            String[] arr_s1 = s_menuListResult.split("`");
            String[] arr_t1 = t_menuListResult.split("`");

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            CustomTask foodTask;
            ArrayList<String> f_menuList = new ArrayList<String>();
            ArrayList<String> s_menuList = new ArrayList<String>();
            ArrayList<String> t_menuList = new ArrayList<String>();
            for(String num : arr_f1){
                foodTask = new CustomTask("foodList.jsp");
                String foodListResult = foodTask.execute( "findFoodNum=" + num ).get();
                foodTask.cancel(true);
                f_menuList.add(foodListResult);
            }
            for(String num : arr_s1){
                foodTask = new CustomTask("foodList.jsp");
                String foodListResult = foodTask.execute( "findFoodNum=" + num ).get();
                foodTask.cancel(true);
                s_menuList.add(foodListResult);
            }
            for(String num : arr_t1){
                foodTask = new CustomTask("foodList.jsp");
                String foodListResult = foodTask.execute( "findFoodNum=" + num ).get();
                foodTask.cancel(true);
                t_menuList.add(foodListResult);
            }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            CustomTask userFoodTask = new CustomTask("userFoodList.jsp");
            String f_userfoodListResult = userFoodTask.execute("userID=" + member.getUserID() + "&date=" + getTime + "&meal=" + "첫끼").get();
            userFoodTask.cancel(true);

            userFoodTask = new CustomTask("userFoodList.jsp");
            String s_userfoodListResult = userFoodTask.execute("userID=" + member.getUserID() + "&date=" + getTime + "&meal=" + "두끼").get();
            userFoodTask.cancel(true);

            userFoodTask = new CustomTask("userFoodList.jsp");
            String t_userfoodListResult = userFoodTask.execute("userID=" + member.getUserID() + "&date=" + getTime + "&meal=" + "셋끼").get();
            userFoodTask.cancel(true);


            String[] arr_f = f_userfoodListResult.split("`");
            if(!arr_f[0].equals("")) {
                String temp = "";
                for(String arr : arr_f){
                    String[] tArr = arr.split(",");
                    temp += tArr[0] + "," + tArr[1] + "\n";
                }
                breakfastViewEditText.setText(temp);
                breakfastText.setTextColor(Color.RED);
            }
            else{
                String temp_add = "";
                for(String temp : f_menuList){
                    temp_add += temp + "\n";
                }
                breakfastViewEditText.setText(temp_add);
            }

            String[] arr_s = s_userfoodListResult.split("`");
            if(!arr_s[0].equals("")) {
                String temp = "";
                for(String arr : arr_s){
                    String[] tArr = arr.split(",");
                    temp += tArr[0] + "," + tArr[1] + "\n";
                }
                lunchViewEditText.setText(temp);
                lunchText.setTextColor(Color.RED);
            }
            else{
                String temp_add = "";
                for(String temp : s_menuList){
                    temp_add += temp + "\n";
                }
                lunchViewEditText.setText(temp_add);
            }
            String[] arr_t = t_userfoodListResult.split("`");
            if(!arr_t[0].equals("")) {
                String temp = "";
                for(String arr : arr_t){
                    String[] tArr = arr.split(",");
                    temp += tArr[0] + "," + tArr[1] + "\n";
                }
                dinnerViewEditText.setText(temp);
                dinnerText.setTextColor(Color.RED);
            }
            else{
                String temp_add = "";
                for(String temp : t_menuList){
                    temp_add += temp + "\n";
                }
                dinnerViewEditText.setText(temp_add);
            }


        }catch (Exception e){
            Toast.makeText(MenuUpdateActivity.this, "서버 오류", Toast.LENGTH_SHORT).show();
        }

        dateImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuUpdateActivity.this, MainTabActivity.class );
                finish();
                startActivity(intent);
            }
        });

        breakfastLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowDialog(breakfastText.getText().toString());
            }
        });
        lunchLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowDialog(lunchText.getText().toString());
            }
        });
        dinnerLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowDialog(dinnerText.getText().toString());
            }
        });

    }

    private void ShowDialog(final String mealStr)
    {
        LayoutInflater inflate = LayoutInflater.from(this);
        final View dialogLayout = inflate.inflate(R.layout.custom_dialog, null);
        final Dialog myDialog = new Dialog(this,android.R.style.Theme_NoTitleBar_Fullscreen);
//
        myDialog.setContentView(dialogLayout);
        myDialog.show();

        dialogCancelButton = (Button)dialogLayout.findViewById(R.id.dialogCancelButton);
        dialogOkButton = (Button)dialogLayout.findViewById(R.id.dialogOkButton);
        addListButton = (Button)dialogLayout.findViewById(R.id.addListButton);

        final LinearLayout dialogLinearLayoutList1, dialogLinearLayoutList2 ,dialogLinearLayoutList3, dialogLinearLayoutList4, dialogLinearLayoutList5;
        dialogLinearLayoutList1 = dialogLayout.findViewById(R.id.dialogLinearLayoutList1);
        dialogLinearLayoutList2 = dialogLayout.findViewById(R.id.dialogLinearLayoutList2);
        dialogLinearLayoutList3 = dialogLayout.findViewById(R.id.dialogLinearLayoutList3);
        dialogLinearLayoutList4 = dialogLayout.findViewById(R.id.dialogLinearLayoutList4);
        dialogLinearLayoutList5 = dialogLayout.findViewById(R.id.dialogLinearLayoutList5);

        final EditText foodNameEditText1 , foodNameEditText2, foodNameEditText3, foodNameEditText4, foodNameEditText5;
        final EditText foodAmountEditText1 , foodAmountEditText2, foodAmountEditText3, foodAmountEditText4, foodAmountEditText5;
        final Spinner foodTypeSpinner1, foodTypeSpinner2,foodTypeSpinner3,foodTypeSpinner4,foodTypeSpinner5;
        final EditText foodKcalEditText1 , foodKcalEditText2, foodKcalEditText3, foodKcalEditText4, foodKcalEditText5;

        foodNameEditText1 = dialogLayout.findViewById(R.id.foodNameEditText);
        foodNameEditText2 = dialogLayout.findViewById(R.id.foodNameEditText2);
        foodNameEditText3 = dialogLayout.findViewById(R.id.foodNameEditText3);
        foodNameEditText4 = dialogLayout.findViewById(R.id.foodNameEditText4);
        foodNameEditText5 = dialogLayout.findViewById(R.id.foodNameEditText5);

        foodAmountEditText1 = dialogLayout.findViewById(R.id.foodAmountEditText);
        foodAmountEditText2 = dialogLayout.findViewById(R.id.foodAmountEditText2);
        foodAmountEditText3 = dialogLayout.findViewById(R.id.foodAmountEditText3);
        foodAmountEditText4 = dialogLayout.findViewById(R.id.foodAmountEditText4);
        foodAmountEditText5 = dialogLayout.findViewById(R.id.foodAmountEditText5);

        foodTypeSpinner1 = dialogLayout.findViewById(R.id.foodTypeSpinner);
        foodTypeSpinner2 = dialogLayout.findViewById(R.id.foodTypeSpinner2);
        foodTypeSpinner3 = dialogLayout.findViewById(R.id.foodTypeSpinner3);
        foodTypeSpinner4 = dialogLayout.findViewById(R.id.foodTypeSpinner4);
        foodTypeSpinner5 = dialogLayout.findViewById(R.id.foodTypeSpinner5);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, foodTypeStr);
        foodTypeSpinner1.setAdapter(adapter);
        foodTypeSpinner2.setAdapter(adapter);
        foodTypeSpinner3.setAdapter(adapter);
        foodTypeSpinner4.setAdapter(adapter);
        foodTypeSpinner5.setAdapter(adapter);

        foodKcalEditText1 = dialogLayout.findViewById(R.id.foodKcalEditText);
        foodKcalEditText2 = dialogLayout.findViewById(R.id.foodKcalEditText2);
        foodKcalEditText3 = dialogLayout.findViewById(R.id.foodKcalEditText3);
        foodKcalEditText4 = dialogLayout.findViewById(R.id.foodKcalEditText4);
        foodKcalEditText5 = dialogLayout.findViewById(R.id.foodKcalEditText5);

        addListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dialogLinearLayoutList2.getVisibility() == View.GONE){
                    dialogLinearLayoutList2.setVisibility(View.VISIBLE);
                }
                else if(dialogLinearLayoutList3.getVisibility() == View.GONE){
                    dialogLinearLayoutList3.setVisibility(View.VISIBLE);
                }
                else if(dialogLinearLayoutList4.getVisibility() == View.GONE){
                    dialogLinearLayoutList4.setVisibility(View.VISIBLE);
                }
                else if(dialogLinearLayoutList5.getVisibility() == View.GONE){
                    dialogLinearLayoutList5.setVisibility(View.VISIBLE);
                }
                if(dialogLinearLayoutList5.getVisibility() == View.VISIBLE){
                    addListButton.setVisibility(View.GONE);
                }

            }
        });

        dialogCancelButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                myDialog.cancel();
            }
        });

        dialogOkButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String foodNameET1 , foodNameET2, foodNameET3, foodNameET4, foodNameET5;
                String foodAmountET1 , foodAmountET2, foodAmountET3, foodAmountET4, foodAmountET5;
                String foodTypeSp1 , foodTypeSp2, foodTypeSp3, foodTypeSp4, foodTypeSp5;
                String foodKcalET1 , foodKcalET2, foodKcalET3, foodKcalET4, foodKcalET5;
                String menuName = "";

                foodNameET1 = foodNameEditText1.getText().toString();
                foodNameET2 = foodNameEditText2.getText().toString();
                foodNameET3 = foodNameEditText3.getText().toString();
                foodNameET4 = foodNameEditText4.getText().toString();
                foodNameET5 = foodNameEditText5.getText().toString();

                foodAmountET1 = foodAmountEditText1.getText().toString();
                foodAmountET2 = foodAmountEditText2.getText().toString();
                foodAmountET3 = foodAmountEditText3.getText().toString();
                foodAmountET4 = foodAmountEditText4.getText().toString();
                foodAmountET5 = foodAmountEditText5.getText().toString();

                foodTypeSp1 = foodTypeSpinner1.getSelectedItem().toString();
                foodTypeSp2 = foodTypeSpinner2.getSelectedItem().toString();
                foodTypeSp3 = foodTypeSpinner3.getSelectedItem().toString();
                foodTypeSp4 = foodTypeSpinner4.getSelectedItem().toString();
                foodTypeSp5 = foodTypeSpinner5.getSelectedItem().toString();

                foodKcalET1 = foodKcalEditText1.getText().toString();
                foodKcalET2 = foodKcalEditText2.getText().toString();
                foodKcalET3 = foodKcalEditText3.getText().toString();
                foodKcalET4 = foodKcalEditText4.getText().toString();
                foodKcalET5 = foodKcalEditText5.getText().toString();

                if((!foodNameET1.equals(null) || foodNameET1.length() > 0) && (!foodAmountET1.equals(null) || foodAmountET1.length() > 0 ) && (!foodTypeSp1.equals(null) || foodTypeSp1.length() > 0) && (!foodKcalET1.equals(null) || foodKcalET1.length() > 0)){
                    try{

                        CustomTask task = new CustomTask("registerUserMenu.jsp");
                        String result = task.execute( "userID="+ member.getUserID() + "&foodName=" + foodNameET1 +
                                "&foodAmount=" + foodAmountET1 + "&foodType=" + foodTypeSp1 + "&foodKcal=" + foodKcalET1 + "&date=" + getTime + "&meal=" + mealStr
                        ).get();
                        task.cancel(true);

                        Toast.makeText(MenuUpdateActivity.this, "성공 = " + result, Toast.LENGTH_SHORT).show();

                        menuName +=  foodNameET1 + " , " + foodKcalET1 + "(kcal)";

                    }catch (Exception e){
                        Log.d(this.getClass().getName()," 첫번째 식단 등록 실패 ");
                    }
                }
                else {
                    Toast.makeText(MenuUpdateActivity.this, "첫번째 식단 정보를 올바르게 입력하여 주세요", Toast.LENGTH_SHORT).show();
                }
                if((!foodNameET2.equals("") || foodNameET2.length() > 0) ){
                    if((!foodAmountET2.equals(null) && foodAmountET2.length() > 0 ) && (!foodTypeSp2.equals(null) && foodTypeSp2.length() > 0) && (!foodKcalET2.equals(null) && foodKcalET2.length() > 0)){
                        try{

                            CustomTask task = new CustomTask("registerUserMenu.jsp");
                            String result = task.execute( "userID="+ member.getUserID() + "&foodName=" + foodNameET2 +
                                    "&foodAmount=" + foodAmountET2 + "&foodType=" + foodTypeSp2 + "&foodKcal=" + foodKcalET2 + "&date=" + getTime + "&meal=" + mealStr
                            ).get();
                            task.cancel(true);

                            menuName += "\n" + foodNameET2 + " , " + foodKcalET2 + "(kcal)";
                        }catch (Exception e){
                            Log.d(this.getClass().getName()," 두번째 식단 등록 실패 ");
                        }
                  }
                  else{
                      Toast.makeText(MenuUpdateActivity.this, "두번째 식단 정보를 올바르게 입력하여 주세요", Toast.LENGTH_SHORT).show();
                  }
                }
                if((!foodNameET3.equals("") || foodNameET3.length() > 0) ){
                    if((!foodAmountET3.equals(null) && foodAmountET3.length() > 0 ) && (!foodTypeSp3.equals(null) && foodTypeSp3.length() > 0) && (!foodKcalET3.equals(null) && foodKcalET3.length() > 0)){
                        try{

                            CustomTask task = new CustomTask("registerUserMenu.jsp");
                            String result = task.execute( "userID="+ member.getUserID() + "&foodName=" + foodNameET3 +
                                    "&foodAmount=" + foodAmountET3 + "&foodType=" + foodTypeSp3 + "&foodKcal=" + foodKcalET3 + "&date=" + getTime + "&meal=" + mealStr
                            ).get();
                            task.cancel(true);

                            menuName += "\n" + foodNameET3 + " , " + foodKcalET3 + "(kcal)";
                        }catch (Exception e){
                            Log.d(this.getClass().getName()," 세번째 식단 등록 실패 ");
                        }
                    }
                    else{
                        Toast.makeText(MenuUpdateActivity.this, "세번째 식단 정보를 올바르게 입력하여 주세요", Toast.LENGTH_SHORT).show();
                    }
                }
                if((!foodNameET4.equals("") || foodNameET4.length() > 0) ){
                    if((!foodAmountET4.equals(null) && foodAmountET4.length() > 0 ) && (!foodTypeSp4.equals(null) && foodTypeSp4.length() > 0) && (!foodKcalET4.equals(null) && foodKcalET4.length() > 0)){
                        try{

                            CustomTask task = new CustomTask("registerUserMenu.jsp");
                            String result = task.execute( "userID="+ member.getUserID() + "&foodName=" + foodNameET4 +
                                    "&foodAmount=" + foodAmountET4 + "&foodType=" + foodTypeSp4 + "&foodKcal=" + foodKcalET4 + "&date=" + getTime + "&meal=" + mealStr
                            ).get();
                            task.cancel(true);
                            menuName += "\n" + foodNameET4 + " , " + foodKcalET4 + "(kcal)";

                        }catch (Exception e){
                            Log.d(this.getClass().getName()," 네번째 식단 등록 실패 ");
                        }
                    }
                    else{
                        Toast.makeText(MenuUpdateActivity.this, "네번째 식단 정보를 올바르게 입력하여 주세요", Toast.LENGTH_SHORT).show();
                    }
                }
                if((!foodNameET5.equals("") || foodNameET5.length() > 0) ){
                    if((!foodAmountET5.equals(null) && foodAmountET5.length() > 0 ) && (!foodTypeSp5.equals(null) && foodTypeSp5.length() > 0) && (!foodKcalET5.equals(null) && foodKcalET5.length() > 0)){
                        try{

                            CustomTask task = new CustomTask("registerUserMenu.jsp");
                            String result = task.execute( "userID="+ member.getUserID() + "&foodName=" + foodNameET5 +
                                    "&foodAmount=" + foodAmountET5 + "&foodType=" + foodTypeSp5 + "&foodKcal=" + foodKcalET5 + "&date=" + getTime + "&meal=" + mealStr
                            ).get();
                            task.cancel(true);
                            menuName += "\n" + foodNameET5 + " , " + foodKcalET5 + "(kcal)";

                        }catch (Exception e){
                            Log.d(this.getClass().getName()," 다섯번째 식단 등록 실패 ");
                        }
                    }
                    else{
                        Toast.makeText(MenuUpdateActivity.this, "다섯번째 식단 정보를 올바르게 입력하여 주세요", Toast.LENGTH_SHORT).show();
                    }
                }

                if(mealStr.equals("첫끼")){
                    breakfastViewEditText.setText(menuName + "추가되었습니다.");
                    breakfastText.setTextColor(Color.RED);
                    breakfastViewEditText.setTextSize(15);
                }

                else if(mealStr.equals("두끼")){
                    lunchViewEditText.setText(menuName + "추가되었습니다.");
                    lunchText.setTextColor(Color.RED);
                    lunchViewEditText.setTextSize(15);
                }

                else if(mealStr.equals("셋끼")){
                    dinnerViewEditText.setText(menuName + "추가되었습니다.");
                    dinnerText.setTextColor(Color.RED);
                    dinnerViewEditText.setTextSize(15);
                }

                myDialog.cancel();
            }

        });
    }

}
