package com.example.brianyuchen.gcd_lcmapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    EditText eta;
    EditText etb;
    EditText etc;
    EditText etd;

    EditText gcd_ans1;
    EditText lcm_ans2;

    Button btn1;
    static int choice;

    private static int gcd(int a, int b) {
        while (b > 0) {
            int tmp = b;
            b = a % b; // b(divisor) >> b(r - remainder) >> b(divisor)
            a = tmp;
        }
        return a;
    }

    private static int gcd(int[] input) {
        int result = input[0];
        for (int i = 1; i < input.length; i++) {
            result = gcd(result, input[i]);
        }
        return result;
    }
    //==============

    private static int lcm(int a, int b) {
        int lcm;
        lcm = a * (b / gcd(a, b));
        return lcm;

    }

    private static int lcm(int[] input) {
        int result = input[0];
        for (int i = 1; i < input.length; i++) {
            result = lcm(result, input[i]);
        }
        return result;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eta = findViewById(R.id.eT1);
        etb = findViewById(R.id.eT2);
        etc = findViewById(R.id.eT3);
        etd = findViewById(R.id.eT4);


        gcd_ans1 = findViewById(R.id.ans1);
        lcm_ans2 = findViewById(R.id.ans2);

        btn1 = findViewById(R.id.btn1);

        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        final Integer[] numberItem = {2, 3, 4};
        ArrayAdapter<Integer> numberList = new ArrayAdapter<Integer>(MainActivity.this,
                android.R.layout.simple_spinner_dropdown_item,
                numberItem);
        spinner.setAdapter(numberList);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0: // 2
                        eta.setEnabled(true);
                        etb.setEnabled(true);
                        etc.setEnabled(false);
                        etd.setEnabled(false);
                        choice = 2;
                        break;
                    case 1: // 3
                        eta.setEnabled(true);
                        etb.setEnabled(true);
                        etc.setEnabled(true);
                        etd.setEnabled(false);
                        choice = 3;
                        break;
                    case 2: // 4
                        eta.setEnabled(true);
                        etb.setEnabled(true);
                        etc.setEnabled(true);
                        etd.setEnabled(true);
                        choice = 4;
                        break;
                    default:
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });


        btn1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {


//                if(choice == 1) {
//
//                } else if(choice == 2) {
//
//                } else if(choice == 3) {
//
//                } else if(choice == 4) {
//
//                }


                int a1 = Integer.parseInt(eta.getText().toString());
                int b1 = Integer.parseInt(etb.getText().toString());
                int c1 = Integer.parseInt(etc.getText().toString());
                int d1 = Integer.parseInt(etd.getText().toString());

                int[] number_arr = {a1, b1, c1, d1};
                int gcd_num = gcd(number_arr);
                int lcm_num = lcm(number_arr);

                gcd_ans1.setText(gcd_num + "");
                lcm_ans2.setText(lcm_num + "");

            }


        });
    }
}
