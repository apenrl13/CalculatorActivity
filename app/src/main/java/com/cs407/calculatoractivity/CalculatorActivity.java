package com.cs407.calculatoractivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity {

    public void calculate(View view) {
        EditText firstNumberField = (EditText) findViewById(R.id.firstNumberField);
        EditText secondNumberField = (EditText) findViewById(R.id.secondNumberField);
        int firstNumber = Integer.parseInt(firstNumberField.getText().toString());
        int secondNumber = Integer.parseInt(secondNumberField.getText().toString());

        Button b = (Button) view;
        String operation = b.getText().toString();
        int result = 0;

        if (operation.equals("+")) {
            result = firstNumber + secondNumber;
        } else if (operation.equals("-")) {
            result = firstNumber - secondNumber;
        } else if (operation.equals("×")) {
            result = firstNumber * secondNumber;
        } else {
            if (secondNumber == 0) {
                Toast.makeText(CalculatorActivity.this, "Please try again.", Toast.LENGTH_LONG).show();
                return;
            } else {
                result = firstNumber / secondNumber;
            }
        }

        goToActivity2(Integer.toString(result));
    }

    public void goToActivity2(String s) {
        Intent intent = new Intent(this, CalculatorActivity2.class);
        intent.putExtra("result", s);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_activity);
    }
}