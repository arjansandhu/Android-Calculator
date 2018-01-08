package com.ubclaunchpad.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;
import android.content.Intent;

/**
 * Created by arjan on 2018-01-07.
 */

public class AnswerActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        TextView answerField = (TextView)findViewById(R.id.Answer);
        Intent intent = getIntent();
        Double answerResult = intent.getDoubleExtra("ANSWER", 0);
        String answerResultString = String.format("%.9f", answerResult);
        answerResultString = answerResultString.indexOf(".") < 0 ? answerResultString : answerResultString.replaceAll("0*$", "").replaceAll("\\.$", "");
        answerField.setText(answerResultString);
    }

}