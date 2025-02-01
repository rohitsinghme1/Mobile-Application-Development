package com.example.intent;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ActivityResultContract<Intent, String> ARC = new ActivityResultContract<Intent, String>() {
        @NonNull
        @Override
        public Intent createIntent(@NonNull Context context, Intent intent) {
            return intent;
        }

        @Override
        public String parseResult(int i, @Nullable Intent intent) {
            return intent.getStringExtra("result");
        }
    };

    ActivityResultCallback<String> arcb = new ActivityResultCallback<String>() {
        @Override
        public void onActivityResult(String o) {
            Toast.makeText(MainActivity.this, o, Toast.LENGTH_SHORT).show();
        }
    };

    ActivityResultLauncher<Intent> launcher = registerForActivityResult(ARC,arcb);



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
        EditText text1 = findViewById(R.id.et1);
        Button btn1 = findViewById(R.id.btn);

        btn1.setOnClickListener(v ->{
            Intent intent = new Intent(this, IntentActivity2.class);
            intent.putExtra("number", text1.getText().toString());
            launcher.launch(intent);
        });
    }
}