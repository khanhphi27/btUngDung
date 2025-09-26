package com.example.btlogin;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;

public class DK extends AppCompatActivity {
    EditText bdate,sdt,ten,pass;
    Button btnDK1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dk);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        bdate = findViewById(R.id.bdate);
        pass = findViewById(R.id.pass);
        sdt = findViewById(R.id.sdt);
        ten = findViewById(R.id.ten);
        btnDK1 = findViewById(R.id.btnDK1);
    }
}