package com.example.tran_vincent_chapter1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button tenPercent;
    Button fivePercent;
    Button twentyPercent;
    Button fifteenPercent;
    EditText subText;
    EditText partiText;
    TextView tipPerView;
    TextView totalCostPerView;
    Spinner taxSpinner;


    Double money;
    Double people;
    Double tip;
    Double perPersonTotal;
    Double perPersonTip;
    Double taxValue;

    double[] items_value = new double[]{ .09, .07, .08};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.findView();
        ArrayAdapter<String> adapter = new ArrayAdapter <String>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.states));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        taxSpinner.setAdapter(adapter);
        this.setter();
    }
    public void onClick(View view){
        money=Double.parseDouble(subText.getText().toString());
        if(money<=0)
        {
            subText.setError("Field cannot be 0 or less.");
        }
        people= Double.parseDouble(partiText.getText().toString());
        if(people <=0){
            partiText.setError("Field cannot be 0 or less.");
        }
        taxValue=items_value[taxSpinner.getSelectedItemPosition()];
        if (view.getId() == fivePercent.getId()){
            tip = .05;
        }
        if (view.getId() == tenPercent.getId()){
            tip = .10;
        }
        if (view.getId() ==fifteenPercent.getId()){
            tip = .15;
        }
        if (view.getId() == twentyPercent.getId()){
            tip= .20;
           /* perPersonTip= Math.round((tip/people)*100.0)/100.0;
            tipPerView.setText(("$" + perPersonTip));
            totalWithTip= tip+money;
            perPersonTotal = Math.round((totalWithTip/people)*100.0)/100.0;
            totalCostPerView.setText("$" + perPersonTotal);*/
        }
        TipCalculator tipObj =new TipCalculator(people,money,taxValue,tip);
        perPersonTip=tipObj.returnPersonTip();
        tipPerView.setText(("$" + perPersonTip));
        perPersonTotal=tipObj.returnPersonTotal();
        totalCostPerView.setText("$" + perPersonTotal);
    }
    public void findView(){
        fivePercent =(Button) findViewById(R.id.five);
        tenPercent = (Button) findViewById(R.id.ten);
        fifteenPercent = (Button) findViewById(R.id.fifteen);
        twentyPercent =(Button) findViewById(R.id.twenty);
        subText =(EditText) findViewById(R.id.subtotalBox);
        partiText =(EditText) findViewById(R.id.participantBox);
        tipPerView = (TextView) findViewById(R.id.tip);
        totalCostPerView = (TextView) findViewById(R.id.total);
        taxSpinner= findViewById(R.id.stateTaxSpinner);
    }
    public void setter(){
        tenPercent.setOnClickListener(this);
        fifteenPercent.setOnClickListener(this);
        twentyPercent.setOnClickListener(this);
        fivePercent.setOnClickListener(this);
    }
}
