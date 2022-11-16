package com.example.equation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private TextView tv_a;
    private TextView tv_b;
    private TextView tv_c;
    private TextView tv_dec;
    private TextView tv_otobr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.solve);
        tv_a = findViewById(R.id.coff_a);
        tv_b = findViewById(R.id.coff_b);
        tv_c = findViewById(R.id.coff_c);
        tv_dec = findViewById(R.id.dec);
        tv_otobr = findViewById(R.id.otobr);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double a = Double.parseDouble(tv_a.getText().toString());
                double b = Double.parseDouble(tv_b.getText().toString());
                double c = Double.parseDouble(tv_c.getText().toString());
                Log.d("qqqqq", Double.toString(a) + " " + Double.toString(b) + " " + Double.toString(c));
                double D = (b*b) - 4* a * c;
                Log.d("qqqqq", Double.toString(D));
                tv_otobr.setText(Double.toString(a) + "x^2" + (b > 0 ? " + " : " - ") + Double.toString(Math.abs(b)) + "x" + (c > 0 ? " + " : " - ") + Double.toString(Math.abs(c)) + " = 0");


                if (D == 0){
                    Log.d("qqqqq", (b > 0 ? "+" : "-"));
                    double x1 = ((-1)*b + Math.sqrt(D))/(2*a);
                    tv_dec.setText("Решение: x1=" + Double.toString(x1));
                }
                if (D > 0){
                    double x1 = ((-1)*b + Math.sqrt(D))/(2*a);
                    double x2 = ((-1)*b - Math.sqrt(D))/(2*a);
                    tv_dec.setText("Решение: x1=" + Double.toString(x1) + " x2=" + Double.toString(x2));
                }
                if (D < 0){
                    tv_dec.setText("Решений нет");
                }

            }
        });

    }
}