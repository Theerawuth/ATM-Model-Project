package com.augmentis.ayp.atm_model_project;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button loginButton, cancelButton;
    EditText passwordLoginEditText;
    TextView wrongText;
    String admin;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        declareValue();
        setOnClick();
    }

    private void initView() {
        passwordLoginEditText = (EditText) findViewById(R.id.password_text);
        loginButton = (Button) findViewById(R.id.login_button);
        cancelButton = (Button) findViewById(R.id.cancel_button);
        wrongText = (TextView) findViewById(R.id.wrong_text);
        wrongText.setVisibility(View.GONE);
    }

    private void declareValue() {
        admin = "12345";
        count = 3;
    }

    private void setOnClick() {
        loginButton.setOnClickListener(this);
//        cancelButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_button:
                if (passwordLoginEditText.getText().toString().equals(admin)) {
                    Toast.makeText(getApplicationContext(), "Redirecting...", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, WithDrawAndDepositActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();
                    wrongText.setVisibility(View.VISIBLE);
                    wrongText.setBackgroundColor(Color.RED);
                    count--;
                    wrongText.setText(Integer.toString(count));
                    if (count == 0) {
                        loginButton.setEnabled(false);
                    }
                }
                break;
            case R.id.cancel_button:
                finish();
        }
    }
}
