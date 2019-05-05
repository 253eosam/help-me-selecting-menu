package com.example.dhzm2.helperyourdiet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActiveQuestionnaireA extends Activity {

    Button nextButton , beforeButton;
    EditText questionEditText1, questionEditText2Hour ,questionEditText2Min;
    String q1,q2h,q2m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_questionnaire_a);

        nextButton = findViewById(R.id.nextButton);
        beforeButton = findViewById(R.id.beforeButton);
        questionEditText1 = findViewById(R.id.questionEditText1);
        questionEditText2Hour = findViewById(R.id.questionEditText2Hour);
        questionEditText2Min = findViewById(R.id.questionEditText2Min);


        final User user = (User)getIntent().getSerializableExtra("user");




        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q1 = questionEditText1.getText().toString();
                q2h = questionEditText2Hour.getText().toString();
                q2m = questionEditText2Min.getText().toString();

                if(q1.equals(null) || q1.length() <= 0){
                    q1 = "0";
                }
                if(q2h.equals(null) || q2h.length() <= 0){
                    q2h = "0";
                }
                if(q2m.equals(null) || q2m.length() <= 0){
                    q2m = "0";
                }

                Intent intent = new Intent(ActiveQuestionnaireA.this,ActiveQuestionnaireB.class );

                intent.putExtra("user",user);
                intent.putExtra("questionA1",q1);
                intent.putExtra("questionA2h",q2h);
                intent.putExtra("questionA2m",q2m);

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
