package com.example.brianyuchen.gcd_lcmapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText eta;
    EditText etb;

    EditText gcd_ans1;
    EditText lcm_ans2;

    Button btn1;

    private static int gcd(int a, int b)
    {
        while(b>0)
        {
            int tmp = b;
            b = a % b; // b(divisor) >> b(r - remainder) >> b(divisor)
            a = tmp;
        }
        return a;
    }

    private static int lcm(int a, int b)
    {
        int lcm;
        lcm = a * (b/gcd(a, b));
        return lcm;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eta = (EditText) findViewById(R.id.eT1);
        etb = (EditText) findViewById(R.id.eT2);


        gcd_ans1 = (EditText) findViewById(R.id.ans1);
        lcm_ans2 = (EditText) findViewById(R.id.ans2);

        btn1 = (Button) findViewById(R.id.btn1);

        btn1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                int a1 = Integer.parseInt(eta.getText().toString());
                int b1 = Integer.parseInt(etb.getText().toString());

                int gcd_num = gcd(a1, b1);
                int lcm_num = lcm(a1, b1);

                gcd_ans1.setText(gcd_num + "");
                lcm_ans2.setText(lcm_num + "");

            }


        });
    }
}
