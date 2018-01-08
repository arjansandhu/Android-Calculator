package com.ubclaunchpad.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener{
    private final static String TAG = CalculatorActivity.class.getSimpleName();

    EditText firstInput;
    EditText secondInput;
    double answerResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        firstInput = (EditText)findViewById(R.id.firstInput);
        secondInput = (EditText)findViewById(R.id.secondInput);

        Button add = (Button) findViewById(R.id.operation_add);
        add.setOnClickListener(this); // calling onClick() method
        Button sub = (Button) findViewById(R.id.operation_sub);
        sub.setOnClickListener(this);
        Button multi = (Button) findViewById(R.id.operation_multi);
        multi.setOnClickListener(this);
        Button div = (Button) findViewById(R.id.operation_div);
        div.setOnClickListener(this);
    }

    /**
     * This implementation of the click listener is for the view found in res/layout/activity_calculator
     * The functions in general should grab the appropriate inputs, and if they are valid, computes the answer.
     * The answer should be displayed in a second activity labelled "AnswerActivity"
     * @param v
     */
    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.operation_add:
            {
                answerResult = Double.parseDouble(firstInput.getText().toString()) + Double.parseDouble(secondInput.getText().toString());
                Intent answer = new Intent(this,AnswerActivity.class);
                answer.putExtra("ANSWER", answerResult);
                startActivity(answer);
                break;
            }
            case R.id.operation_sub:
            {
                answerResult = Double.parseDouble(firstInput.getText().toString()) - Double.parseDouble(secondInput.getText().toString());
                Intent answer = new Intent(this,AnswerActivity.class);
                answer.putExtra("ANSWER", answerResult);
                startActivity(answer);
                break;
            }
            case R.id.operation_multi:
            {
                answerResult = Double.parseDouble(firstInput.getText().toString()) * Double.parseDouble(secondInput.getText().toString());
                Intent answer = new Intent(this,AnswerActivity.class);
                answer.putExtra("ANSWER", answerResult);
                startActivity(answer);
                break;
            }
            case R.id.operation_div:
            {
                answerResult = Double.parseDouble(firstInput.getText().toString()) / Double.parseDouble(secondInput.getText().toString());
                Intent answer = new Intent(this,AnswerActivity.class);
                answer.putExtra("ANSWER", answerResult);
                startActivity(answer);
                break;
            }
            //TODO any extra implmentations (optional)
            default:
            {
                Toast.makeText(this, "Click not implmented yet", Toast.LENGTH_LONG).show();
                Log.e(TAG, "View id: " + v.getId() + " click not implemented yet");
                break;
            }
        }
    }
}
