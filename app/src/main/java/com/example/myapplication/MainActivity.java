package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button15;
    Button button18;
    Button button20;

    TextView tipTextView;
    TextView totalTextView;

    EditText billAmountEditText;
    Double tipPercentage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tipPercentage = 0.0;

        button15 = findViewById(R.id.button15);
        button18 = findViewById(R.id.button18);
        button20 = findViewById(R.id.button20);

        tipTextView = findViewById(R.id.tipTextView);
        totalTextView = findViewById(R.id.totalTextView);

        billAmountEditText = findViewById(R.id.userInputEditText);

        //button15.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View v){
        //        System.out.println("15% Button Clicked.....");
        //    }
        //});

        billAmountEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                updateTip();
                //System.out.println("CharSequence: " + charSequence);
                //Double tip = tipPercentage * Double.parseDouble(charSequence.toString());
                //System.out.println("Tip: " + tip);
                //tipTextView.setText("$" + String.format("%.2f" , tip));
                //Double total = tip + Double.parseDouble(charSequence.toString());
                //totalTextView.setText("$" + String.format("%.2f",total));
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public void updateTip(){
        if(!TextUtils.isEmpty(billAmountEditText.getText().toString())){
            Double tip = tipPercentage * Double.parseDouble(billAmountEditText.getText().toString());
            System.out.println("Tip: " + tip);
            tipTextView.setText("$" + String.format("%.2f" , tip));
            Double total = tip + Double.parseDouble(billAmountEditText.getText().toString());
            totalTextView.setText("$" + String.format("%.2f",total));
        }
        else{
            tipTextView.setText("$0.00");
            totalTextView.setText("$0.00");
        }
    }

    @SuppressLint("UseCompatLoadingForColorStateLists")
    public void buttonClick(View v){
        if(v == button15){
            System.out.println("15% Button Clicked.....");
            tipPercentage = 0.15;
            button15.setBackgroundTintList(getResources().getColorStateList(R.color.button_selected));
            button18.setBackgroundTintList(getResources().getColorStateList(R.color.purple_200));
            button20.setBackgroundTintList(getResources().getColorStateList(R.color.purple_200));

        }
        else if(v == button18){
            System.out.println("18% Button Clicked.....");
            tipPercentage = 0.18;
            button18.setBackgroundTintList(getResources().getColorStateList(R.color.button_selected));
            button15.setBackgroundTintList(getResources().getColorStateList(R.color.purple_200));
            button20.setBackgroundTintList(getResources().getColorStateList(R.color.purple_200));
        }
        else if(v == button20){
            System.out.println("20% Button Clicked.....");
            tipPercentage = 0.20;
            button20.setBackgroundTintList(getResources().getColorStateList(R.color.button_selected));
            button18.setBackgroundTintList(getResources().getColorStateList(R.color.purple_200));
            button15.setBackgroundTintList(getResources().getColorStateList(R.color.purple_200));
        }
        updateTip();
    }
}