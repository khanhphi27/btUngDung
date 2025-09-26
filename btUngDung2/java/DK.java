package com.example.btlogin;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DK extends AppCompatActivity {
    EditText bdate, sdt, ten, pass;
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

        // ánh xạ view
        bdate = findViewById(R.id.bdate);
        pass = findViewById(R.id.pass);
        sdt = findViewById(R.id.sdt);
        ten = findViewById(R.id.ten);
        btnDK1 = findViewById(R.id.btnDK1);

        // xử lý nút đăng ký
        btnDK1.setOnClickListener(v -> {
            String phone = sdt.getText().toString().trim();
            String birth = bdate.getText().toString().trim();
            String name = ten.getText().toString().trim();
            String password = pass.getText().toString().trim();

            boolean isValid = true;

            // kiểm tra số điện thoại (10 chữ số)
            if (phone.length() != 10 || !phone.matches("\\d{10}")) {
                isValid = false;
            }

            // kiểm tra ngày sinh dd/MM/yyyy
            if (birth.matches("\\d{2}/\\d{2}/\\d{4}")) {
                try {
                    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
                    sdf.setLenient(false);
                    sdf.parse(birth); // nếu sai sẽ throw Exception
                } catch (Exception e) {
                    isValid = false;
                }
            } else {
                isValid = false;
            }

            if (isValid) {
                Toast.makeText(DK.this, "Đăng ký hợp lệ", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(DK.this, "Đăng ký không hợp lệ", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
