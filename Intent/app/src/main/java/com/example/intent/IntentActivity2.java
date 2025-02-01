package com.example.intent;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class IntentActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_intent2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button btn2 = findViewById(R.id.bnt2);
        Button btn3 = findViewById(R.id.bnt3);

        btn2.setOnClickListener(v ->{
            Intent intent = getIntent();
           int number =  Integer.parseInt(intent.getStringExtra("number"));
            int Factorial = getFactorial(number);
//            Toast.makeText(this, String.valueOf(Factorial), Toast.LENGTH_SHORT).show();
            Intent intent1 = new Intent();
            intent1.putExtra("result",String.valueOf(Factorial));
            setResult(0,intent1);
            finish();
        });

        btn3.setOnClickListener(v ->{
            String error = "there is an error";
            Intent intent2 = new Intent();
            intent2.putExtra("result",error);
            setResult(0,intent2);
            finish();
        });
    }
    Integer getFactorial(int number){
        if(number > 1){
            return 1;
        }
        return number * getFactorial(number -1);
    }
}