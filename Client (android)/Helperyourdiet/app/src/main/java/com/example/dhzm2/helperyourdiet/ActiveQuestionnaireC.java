package com.example.dhzm2.helperyourdiet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActiveQuestionnaireC extends AppCompatActivity {

    Button nextButton , beforeButton;
    EditText questionEditText5, questionEditText6Hour, questionEditText6Min;
    String q5,q6h,q6m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_questionnaire_c);

        nextButton = findViewById(R.id.nextButton);
        beforeButton = findViewById(R.id.beforeButton);
        questionEditText5 = findViewById(R.id.questionEditText5);
        questionEditText6Hour = findViewById(R.id.questionEditText6Hour);
        questionEditText6Min = findViewById(R.id.questionEditText6Min);

        Intent intent = getIntent();
        final User user = (User)intent.getSerializableExtra("user");
        final String q1 = intent.getExtras().getString("questionA1");
        final String q2h = intent.getExtras().getString("questionA2h");
        final String q2m = intent.getExtras().getString("questionA2m");
        final String q3 = intent.getExtras().getString("questionA3");
        final String q4h = intent.getExtras().getString("questionA4h");
        final String q4m = intent.getExtras().getString("questionA4m");


        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q5 = questionEditText5.getText().toString();
                q6h = questionEditText6Hour.getText().toString();
                q6m = questionEditText6Min.getText().toString();

                if(q5.equals(null) || q5.length() <= 0){
                    q5 = "0";
                }
                if(q6h.equals(null) || q6h.length() <= 0){
                    q6h = "0";
                }
                if(q6m.equals(null) || q6m.length() <= 0){
                    q6m = "0";
                }
                Intent intent = new Intent(ActiveQuestionnaireC.this,ActiveQuestionnaireC2.class );
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
