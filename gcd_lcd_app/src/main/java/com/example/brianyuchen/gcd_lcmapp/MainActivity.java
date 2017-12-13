package com.example.brianyuchen.gcd_lcmapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText eta;
    EditText etb;

    EditText gcd_ans1;
    EditText lcm_ans2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eta = (EditText) findViewById(R.id.eT1);
        etb = (EditText) findViewById(R.id.eT2);

        gcd_ans1 = (EditText) findViewById(R.id.ans1);
        lcm_ans2 = (EditText) findViewById(R.id.ans2);
    }
}
