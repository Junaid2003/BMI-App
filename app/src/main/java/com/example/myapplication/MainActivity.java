package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtWeight, edtHeightFt, edtHeightIn;
        TextView txtRes;
        Button btn_cal;
        LinearLayout llMain;

        edtWeight=findViewById(R.id.edtWeight);
        edtHeightFt=findViewById(R.id.edtHeightFt);
        edtHeightIn=findViewById(R.id.edtHeightIn);
        btn_cal=findViewById(R.id.btn_cal);
        txtRes=findViewById(R.id.txtRes);
        llMain=findViewById(R.id.llMain);

        btn_cal.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                int wt=Integer.parseInt(edtWeight.getText().toString());
                int ft=Integer.parseInt(edtHeightFt.getText().toString());
                int in=Integer.parseInt(edtHeightIn.getText().toString());
            int totalIn=ft*12+in;
            double totalCm=totalIn*2.53;
            double totalM=totalCm/100;
            double bmi=wt/(totalM*totalM);
            if(bmi>25){
                txtRes.setText("You are Overweight");
                llMain.setBackgroundColor(getResources().getColor(R.color.colorOV));
            }else if(bmi<18){
                txtRes.setText("Your are Underweight");
                llMain.setBackgroundColor(getResources().getColor(R.color.colorUW));
                }
            else{
                txtRes.setText("You are Healthy");
                llMain.setBackgroundColor(getResources().getColor(R.color.colorH));
                }
            }
        });
    }
}