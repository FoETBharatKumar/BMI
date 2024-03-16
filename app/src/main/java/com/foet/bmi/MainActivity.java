package com.foet.bmi;



import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        EditText edtHeightFt , edtHeightInch, edtWeight;
        TextView result;
        LinearLayout layoutMain;



      Button    btnBmi = findViewById(R.id.buttonBmi);
        edtHeightFt = findViewById(R.id.edtHeight_ft);
        edtWeight = findViewById(R.id.edtWeight);
        edtHeightInch= findViewById(R.id.edtHeight_inch);
           result = findViewById(R.id.result);
           layoutMain= findViewById(R.id.main);


           btnBmi.setOnClickListener(new View.OnClickListener() {

               @Override
               public void onClick(View v) {

                   int heightFT = Integer.parseInt(edtHeightFt.getText().toString());
                   int heightInch = Integer.parseInt(edtHeightInch.getText().toString());
                   int weight = Integer.parseInt(edtWeight.getText().toString());



                   int HeightINch  = heightFT*12 + heightInch;

                   double HeightCm = HeightINch*2.54;

                   double HeightMtr = HeightCm/100;
                   
                   double bmi = weight/(HeightMtr*HeightMtr);

                   if(bmi>25){
                       result.setText("You are OverWeight");
                       layoutMain.setBackgroundColor(getResources().getColor(R.color.red));

                   } else if (bmi<18) {
                       result.setText("You are UnderWeight");
                       layoutMain.setBackgroundColor(getResources().getColor(R.color.yellow));

                   }else {
                       result.setText("you are Fit");
                       layoutMain.setBackgroundColor(getResources().getColor(R.color.green));
                   }


               }

           });








    }
}