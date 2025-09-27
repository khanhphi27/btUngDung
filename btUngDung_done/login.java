package com.example.btlogin;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class login extends AppCompatActivity {
    EditText loginid;
    TextView txt;
    Button btnlogin, btnDK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        loginid = findViewById(R.id.loginid);
        txt = findViewById(R.id.txt);
        btnlogin = findViewById(R.id.btnlogin);
        btnDK = findViewById(R.id.btnDK1);

        // mở màn hình đăng ký
        btnDK.setOnClickListener(v ->
                startActivity(new Intent(login.this, DK.class))
        );

        // xử lý đăng nhập
        btnlogin.setOnClickListener(v -> {
            String id = loginid.getText().toString().trim();

            // Ở đây mình ví dụ: id phải là "admin" thì mới hợp lệ
            if (id.equals("admin")) {
                Toast.makeText(login.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                // TODO: có thể chuyển sang màn hình chính
            } else {
                Toast.makeText(login.this, "Đăng nhập không hợp lệ", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
