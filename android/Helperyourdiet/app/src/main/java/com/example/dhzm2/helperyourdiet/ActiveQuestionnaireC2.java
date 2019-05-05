package com.example.dhzm2.helperyourdiet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActiveQuestionnaireC2 extends AppCompatActivity {

    Button nextButton , beforeButton;
    EditText questionEditText7Hour, questionEditText7Min;
    String q7h,q7m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_questionnaire_c2);

        nextButton = findViewById(R.id.nextButton);
        beforeButton = findViewById(R.id.beforeButton);
        questionEditText7Hour = findViewById(R.id.questionEditText7Hour);
        questionEditText7Min = findViewById(R.id.questionEditText7Min);

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


        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q7h = questionEditText7Hour.getText().toString();
                q7m = questionEditText7Min.getText().toString();

                if(q7h.equals(null) || q7h.length() <= 0){
                    q7h = "0";
                }
                if(q7m.equals(null) || q7m.length() <= 0){
                    q7m = "0";
                }

                Intent intent = new Intent(ActiveQuestionnaireC2.this,ActiveQuestionnaireEnd.class );
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
