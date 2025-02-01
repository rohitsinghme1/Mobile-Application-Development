package com.example.practice;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        EditText op1 = findViewById(R.id.ed1);
        Spinner opr = findViewById(R.id.sp1);
        EditText op2 = findViewById(R.id.ed2);
        Button equals = findViewById(R.id.btn1);
        TextView result = findViewById(R.id.tv1);

        List<String> operators = Arrays.asList("+","-","*","/");
        opr.setAdapter(new ArrayAdapter<String>(this, R.layout.drop_item,R.id.item,operators));

        equals.setOnClickListener(v ->{
            //step1: get operands
            try {
                float opr1 = Integer.parseInt(op1.getText().toString());
                float opr2 = Integer.parseInt(op2.getText().toString());



                //step2: get operator

                String opra = opr.getSelectedItem().toString();

                //step3: Calculate result
                float result1;
                switch (opra) {
                    case "+":
                        result1 = opr1 + opr2;
                        break;

                    case "-":
                        result1 = opr1 - opr2;
                        break;

                    case "*":
                        result1 = opr1 * opr2;
                        break;

                    case "/":
                        result1 = opr1 / opr2;
                        break;

                    default:
                        result1 = 0;
                }
                result.setText(String.valueOf(result1));
            }
            catch (NumberFormatException e){
                //Toast.makeText(this, "Enter the Number", Toast.LENGTH_SHORT).show();
                op1.setError("Enter a number");

            }
        });
    }
}