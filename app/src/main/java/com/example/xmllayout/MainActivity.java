package com.example.xmllayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg;
    EditText txtCost;
    double tipPercentage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg= findViewById(R.id.radioGroup);
        txtCost = findViewById(R.id.editTextCostofService);
        Button btn = findViewById(R.id.btnCalculate);
        RadioButton rbOkay = findViewById(R.id.rdOkay);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double costOfService;
                double tipAmount;

                if(txtCost.getText().toString().equals("")){
                    txtCost.setError("Enter cost of service");
                    return;
                }
                int checkedId= rg.getCheckedRadioButtonId();
                if(checkedId<0){
                    rbOkay.setError("Select services type");
                    return;
                }
                try {
                    costOfService= Double.valueOf(txtCost.getText().toString());
                }catch (Exception ex)
                {
                    txtCost.setError("Invalid Character");
                    return;
                }
                switch (checkedId){
                    case R.id.rdAmazing:
                        tipPercentage= 0.20;
                        break;
                    case R.id.rdGood:
                        tipPercentage= 0.18;
                        break;
                    case R.id.rdOkay:
                        tipPercentage= 0.15;
                }

                tipAmount= costOfService * tipPercentage ;
                tvTipAmount.setText(Double.toString(tipAmount));

            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rdAmazing:
                        Toast.makeText(MainActivity.this, "Amazing clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rdGood:
                        Toast.makeText(MainActivity.this, "Good clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rdOkay:
                        Toast.makeText(MainActivity.this, "Ok clicked", Toast.LENGTH_SHORT).show();
                        break;

                }
            }
        });
    }
}