package com.example.mac.week1daily5_nafiscalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.function.DoubleToIntFunction;

public class MainActivity extends AppCompatActivity {

    TextView display_userInput, display_result;
    double result = 0, userInput = 0;
    String lastFunc = "+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display_userInput = findViewById(R.id.display_userInputId);
        display_result = findViewById(R.id.display_resultId);

    }

    public void onClick(View view) {

        switch (view.getId()){

            case R.id.btn_Dot :
                display_userInput.setText(display_userInput.getText() + ".");
                break;

            case R.id.btn_One :
                userInput = (userInput*10) + 1;
                display_userInput.setText(display_userInput.getText() + "1");
                funcExecuting();
                break;

            case R.id.btn_Two :
                userInput = (userInput*10) + 2;
                display_userInput.setText(display_userInput.getText() + "2");
                funcExecuting();
                break;

            case R.id.btn_Three :
                userInput = (userInput*10) + 3;
                display_userInput.setText(display_userInput.getText() + "3");
                funcExecuting();
                break;

            case R.id.btn_Four :
                userInput = (userInput*10) + 4;
                display_userInput.setText(display_userInput.getText() + "4");
                funcExecuting();
                break;

            case R.id.btn_Five :
                userInput = (userInput*10) + 5;
                display_userInput.setText(display_userInput.getText() + "5");
                funcExecuting();
                break;

            case R.id.btn_Six :
                userInput = (userInput*10) + 6;
                display_userInput.setText(display_userInput.getText() + "6");
                funcExecuting();
                break;

            case R.id.btn_Seven :
                userInput = (userInput*10) + 7;
                display_userInput.setText(display_userInput.getText() + "7");
                funcExecuting();
                break;

            case R.id.btn_Eight :
                userInput = (userInput*10) + 8;
                display_userInput.setText(display_userInput.getText() + "8");
                funcExecuting();
                break;

            case R.id.btn_Nine :
                userInput = (userInput*10) + 9;
                display_userInput.setText(display_userInput.getText() + "9");
                funcExecuting();
                break;

            case R.id.btn_Zero :
                userInput = (userInput*10) + 0;
                display_userInput.setText(display_userInput.getText() + "0");
                funcExecuting();
                break;

            case R.id.btn_DoubleZero :
                userInput = (userInput*100) + 0;
                display_userInput.setText(display_userInput.getText() + "00");
                funcExecuting();
                break;

        }

    }

    public void funcClick(View view) {

        switch (view.getId()) {
            case R.id.btn_Clear:
                lastFunc = "+";
                result = 0;
                userInput = 0;
                display_userInput.setText("");
                display_result.setText("");
                break;

            case R.id.btn_Percentage:
                userInput = 0;
                display_userInput.setText(display_userInput.getText() + "%");
                displayResult(Utilities.percentage(getResult()));
                break;

            case R.id.btn_Divide:
                userInput = 0;
                display_userInput.setText(display_userInput.getText() + "/");
                lastFunc = "/";
                break;

            case R.id.btn_Multiply:
                userInput = 0;
                display_userInput.setText(display_userInput.getText() + "*");
                lastFunc = "*";
                break;

            case R.id.btn_Subtraction:
                userInput = 0;
                display_userInput.setText(display_userInput.getText() + "-");
//                displayResult(Utilities.sub(getResult(), userInput));
                result = Utilities.sub(getResult(), userInput);
                lastFunc = "-";
                break;

            case R.id.btn_Plus:
                userInput = 0;
                display_userInput.setText(display_userInput.getText() + "+");
//                displayResult(Utilities.add(getResult(), userInput));
                result = Utilities.add(getResult(), userInput);
                lastFunc = "+";
                break;

            case R.id.btn_Equals:
                break;
        }
    }

    public void funcExecuting() {

        switch (lastFunc){
            case "+" : displayResult(Utilities.add(getResult(), userInput));
                break;
            case "-" : displayResult(Utilities.sub(getResult(), userInput));
                break;
            case "*" : displayResult(Utilities.multiply(Double.valueOf(display_result.getText().toString()), userInput));
                break;
            case "/" : displayResult(Utilities.divide(Double.valueOf(display_result.getText().toString()), userInput));
                break;
//            case "=" : displayResult(result);
//                break;
        }

    }


        public double getResult(){

            String resultString = display_result.getText().toString();
            if(!resultString.isEmpty() && userInput == 0)
                result = Double.valueOf(resultString);
            return result;

        }

        public void displayResult(double result){

            display_result.setText("" + result);

        }
}
