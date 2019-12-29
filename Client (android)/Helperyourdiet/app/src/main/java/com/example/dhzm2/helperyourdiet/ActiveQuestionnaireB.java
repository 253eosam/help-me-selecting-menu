package com.example.dhzm2.helperyourdiet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActiveQuestionnaireB extends AppCompatActivity {

    Button nextButton , beforeButton;
    EditText questionEditText3, questionEditText4Hour, questionEditText4Min;
    String q3,q4h,q4m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_questionnaire_b);


        nextButton = findViewById(R.id.nextButton);
        beforeButton = findViewById(R.id.beforeButton);
        questionEditText3 = findViewById(R.id.questionEditText3);
        questionEditText4Hour = findViewById(R.id.questionEditText4Hour);
        questionEditText4Min = findViewById(R.id.questionEditText4Min);

        Intent intent = getIntent();
        final User user = (User)intent.getSerializableExtra("user");
        final String q1 = intent.getExtras().getString("questionA1");
        final String q2h = intent.getExtras().getString("questionA2h");
        final String q2m = intent.getExtras().getString("questionA2m");





        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q3 = questionEditText3.getText().toString();
                q4h = questionEditText4Hour.getText().toString();
                q4m = questionEditText4Min.getText().toString();

                if(q3.equals(null) || q3.length() <= 0){
                    q3 = "0";
                }
                if(q4h.equals(null) || q4h.length() <= 0){
                    q4h = "0";
                }
                if(q4m.equals(null) || q4m.length() <= 0){
                    q4m = "0";
                }
                Intent intent = new Intent(ActiveQuestionnaireB.this,ActiveQuestionnaireC.class );
                intent.putExtra("user",user);
                intent.putExtra("questionA1",q1);
                intent.putExtra("questionA2h",q2h);
                intent.putExtra("questionA2m",q2m);
                intent.putExtra("questionA3",q3);
                intent.putExtra("questionA4h",q4h);
                intent.putExtra("questionA4m",q4m);

                startActivity(intent);
                overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_left);
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
