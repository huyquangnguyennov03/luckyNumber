package com.qhcomppany.androidb1.luckynumber;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class SencondActivity extends AppCompatActivity {
    TextView welcom_txt, luckyNumber_txt;
    Button btnShare;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sencond);

        welcom_txt = findViewById(R.id.txt2);
        luckyNumber_txt = findViewById(R.id.txt3);
        btnShare = findViewById(R.id.btnShare);
        //Receiving the data from mainActivity
        //Phương thức này cho phép lấy các giá trị khóa trong putExtra
        Intent i = getIntent();
        String userName = i.getStringExtra("name");
        // Generating Random Numbers
        int random_num = generateRandomNumber();
        luckyNumber_txt.setText("" + random_num);

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareData(userName, random_num);
            }
        });
    }
    public int generateRandomNumber(){
        Random rd = new Random();
        int uppet_limit = 1000;
        int ramdomNumberGenerated = rd.nextInt(uppet_limit);
        return ramdomNumberGenerated;
    }
    public void shareData(String userName, int random_num){

        //Implicit intent
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");

        //Additional info
        i.putExtra(Intent.EXTRA_SUBJECT, userName+ "got to lucky day");
        i.putExtra(Intent.EXTRA_TEXT, "Lucky number is: "+random_num);
        startActivity(Intent.createChooser(i, "Choose a Platform"));
    }
}