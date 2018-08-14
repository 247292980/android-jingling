package com.example.administrator.jinglinglgp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.administrator.jinglinglgp.Utils.ToastUtil;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etName;
    private EditText etPassword;

    private Button btnLogin;
    private Button btnLogout;

    private String name, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initUI();
    }

    private void initUI() {
        etName = (EditText) findViewById(R.id.et_name);
        etPassword = (EditText) findViewById(R.id.et_password);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnLogout = (Button) findViewById(R.id.btn_logout);

        btnLogin.setOnClickListener(this);
        btnLogout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                login();
                break;
            case R.id.btn_logout:
                logout();
                break;
        }
    }

    public void login() {
        name = etName.getText().toString().trim();
        password = etPassword.getText().toString().trim();

        if (name.trim().length() < 0 || password.trim().length() < 0) {
            ToastUtil.toastShort(getApplicationContext(), "用户名和密码不得为空");
            return;
        } else if (name.length() < 5) {
            ToastUtil.toastShort(getApplicationContext(), "用户名长度应大于5");
            return;
        } else if (password.length() < 3) {
            ToastUtil.toastShort(getApplicationContext(), "密码长度应大于3");
            return;
        } else if ("admin".equals(name) && "123".equals(password)) {
            Intent intent = new Intent();
            intent.setClass(getApplicationContext(), HomeActivity.class);
            startActivity(intent);
            finish();
        } else {
            ToastUtil.toastShort(getApplicationContext(), "用户名长度应大于5");
            return;
        }
    }

    public void logout() {
        ToastUtil.toastShort(getApplicationContext(), "登出");
        finish();
    }

}
