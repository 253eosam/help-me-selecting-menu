package com.example.dhzm2.helperyourdiet;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    TextView registerUserTextView;
    Button loginButton;
    EditText loginIDEditText, loginPasswordEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginIDEditText = findViewById(R.id.loginIDEditText);
        loginPasswordEditText = findViewById(R.id.loginPasswordEditText);

        registerUserTextView = findViewById(R.id.registerUserButton);
        registerUserTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginActivity.this ,RegisterUserActivity.class);
                startActivity(intent);
            }
        });
        loginButton = (Button)findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = loginIDEditText.getText().toString();
                String pwd = loginPasswordEditText.getText().toString();
                if(id.equals(null) || id.length() <= 0){
                    id = "";
                }
                if(pwd.equals(null) || pwd.length() <= 0){
                    pwd = "";
                }
                String result = "";
                try{
                    CustomTask task = new CustomTask("login.jsp");
                    result = task.execute( "id=" + id + "&pwd=" + pwd).get();
                    task.cancel(true);

                    //  Log.i("통신 결과", "성공" + result);
                } catch (Exception e) {}

                String[] splitResult = result.split("&");
                Log.d(this.getClass().getName(),"test " + splitResult.length);
                if(splitResult[0].equals("success") && splitResult.length == 13){

                    User member = User.getInstance();
                    member.setUserID(splitResult[1]);
                    member.setUserPassword(splitResult[2]);
                    member.setUserName(splitResult[3]);
                    member.setUserAge(splitResult[4]);
                    member.setUserSex(splitResult[5]);
                    member.setUserHeight(splitResult[6]);
                    member.setUserWeight(splitResult[7]);
                    member.setUserTargetWeight(splitResult[8]);
                    member.setUserActive(splitResult[9]);
                    member.setUserMealAmount(splitResult[10]);
                    member.setUserMealTime(splitResult[11]);
                    member.setUserRDA(splitResult[12]);


                    Intent intent = new Intent(LoginActivity.this, MainTabActivity.class );
                    startActivity(intent);
                }
                else{

                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(LoginActivity.this);

                    alertDialogBuilder.setTitle("로그인 실패");

                    alertDialogBuilder
                            .setMessage("아이디 및 패스워드가 올바르지 않습니다.")
                            .setCancelable(false)
                            .setPositiveButton("다시시도",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(
                                                DialogInterface dialog, int id) {
                                            // 프로그램을 종료한다
                                            dialog.cancel();
                                        }
                                    }).show();

                }

            }
        });
    }
}
