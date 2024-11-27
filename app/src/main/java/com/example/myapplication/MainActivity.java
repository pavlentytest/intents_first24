package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editTextA;
    private EditText editTextB;
    private EditText editTextC;
    private Button btn;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextA = findViewById(R.id.editA);
        editTextB = findViewById(R.id.editB);
        editTextC = findViewById(R.id.editC);
        btn = findViewById(R.id.button);
        tv = findViewById(R.id.textView);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMainActivity2();
            }
        });
    }
    public void goToMainActivity2() {
        // явное намерение (implicit intent)
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("result",doSolve());
        startActivity(intent);
    }
    public String doSolve() {
        String str_a = editTextA.getText().toString(); // "1"
        String str_b = editTextB.getText().toString();
        String str_c = editTextC.getText().toString();
        double a = Double.parseDouble(str_a);
        double b = Double.parseDouble(str_b);
        double c = Double.parseDouble(str_c);
        double d = b*b - 4*a*c;
        if(d == 0) {
            double x = -b/(2*a);
            return String.format(getString(R.string.x_2f),x);
        } else if(d>0) {
            double x1 = (-b + Math.sqrt(d))/(2*a);
            double x2 = (-b - Math.sqrt(d))/(2*a);
            return String.format(getString(R.string.x1_2f_x2_2f),x1,x2);
        } else {
            return getString(R.string.not_solve);
        }
    }

}