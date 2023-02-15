package com.purushottam.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionsActivity extends AppCompatActivity {

    TextView tv;
    Button submitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
            "Q1.The Paithan (Jayakwadi) Hydro-electric project, completed with the help of Japan, is on the river ?",
            "Q2.India's largest city population ?",
            "Q3.Which state has the highest literacy rate ?",
            "Q4.Which is India's artifical satellite ?",
            "Q5.Which state in India share only one border with Indian state ?",
            "Q6.How many parvas in the Mahabharat book ?",
            "Q7.Which one is the longest river in South India ?",
            "Q8.Where is the headquarters of Indian Railways is located ?",
            "Q9.'Bharata Natyam'is a classical dance from the state ?",
            "Q10.Maha Kumbh Mela can be held on same place after every ?"
    };
    String answers[] = {"Godavari","Mumbai","Kerala","Aryabhata","Sikkim","18","Godavari","Delhi","Tamil Nadu","12 Years"};
    String opt[] = {
            "Ganga","Cauvery","Narmada","Godavari",
            "Delhi","Mumbai","Chennai","Pune",
            "Goa","Kerala","Mizoram","Manipur",
            "INSAT","Aryabhata","Bhaskara","Rohini",
            "Goa","Punjab","Nagaland","Sikkim",
            "20","32","16","18",
            "Kaveri","Krishna","Vaigai","Godavari",
            "Delhi","Kolkata","Pune","Mumbai",
            "Tamil Nadu","Karnataka","kerala","Andhra Pradesh",
            "3 Years","5 Years","6 Years","12 Years"
    };
    int flag=0;
    public static int marks=0,correct=0,wrong=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        submitbutton=(Button)findViewById(R.id.button3);

        tv=(TextView) findViewById(R.id.tvque);

        radio_g=(RadioGroup)findViewById(R.id.answersgrp);
        rb1=(RadioButton)findViewById(R.id.radioButton);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        rb3=(RadioButton)findViewById(R.id.radioButton3);
        rb4=(RadioButton)findViewById(R.id.radioButton4);
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);

        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int color = mBackgroundColor.getColor();
                //mLayout.setBackgroundColor(color);

                if(radio_g.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
                //Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
                if(ansText.equals(answers[flag])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                }
                else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                }

                flag++;



                if(flag<questions.length)
                {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag*4]);
                    rb2.setText(opt[flag*4 +1]);
                    rb3.setText(opt[flag*4 +2]);
                    rb4.setText(opt[flag*4 +3]);
                }
                else
                {
                    marks=correct;
                    Intent in = new Intent(getApplicationContext(),ResultActivity.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });
    }
}