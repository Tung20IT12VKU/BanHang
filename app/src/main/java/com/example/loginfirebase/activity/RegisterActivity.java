package com.example.loginfirebase.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.loginfirebase.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    EditText editemail, editpass, editrepass;
    Button buttonregister;
    FirebaseAuth gAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        gAuth = FirebaseAuth.getInstance();
        AnhXa();

        buttonregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Register();
            }
        });

    }

    private void Register() {
        String email = editemail.getText().toString();
        String pass = editpass.getText().toString();
        String repass = editrepass.getText().toString();
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Vui lòng nhập Email", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(pass)){
            Toast.makeText(this, "Vui lòng nhập Password", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(repass)){
            Toast.makeText(this, "Vui lòng nhập lại Password", Toast.LENGTH_SHORT).show();
            return;
        }
        if(pass.equals(repass)){
            gAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(RegisterActivity.this, "Tạo tài khoản thành công", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(i);
                    }
                    else
                    {
                        Toast.makeText(RegisterActivity.this, "Tạo tài khoản không thành công", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        else
        {
            Toast.makeText(this, "Mật khẩu không khớp", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    private void AnhXa() {
        editemail = (EditText) findViewById(R.id.editemail);
        editpass = (EditText)  findViewById(R.id.editpassword);
        editrepass = (EditText)  findViewById(R.id.editrepassword);
        buttonregister = (Button) findViewById(R.id.buttonregister);
    }
}