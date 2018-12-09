package com.example.admin.loginandenterysample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class SignIn extends AppCompatActivity implements View.OnClickListener {

    public static ArrayList<String> Logins = new ArrayList<String>();
    public static ArrayList<String> Passwords = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(this);

        Logins.add("root");
        Passwords.add("1234");
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (resultCode) {
            case RESULT_OK:
                Logins.add(data.getStringExtra("log"));
                Passwords.add(data.getStringExtra("password"));
                break;
        }
    }


    @Override
    public void onClick(View v) {

        EditText editText = findViewById(R.id.editText);
        EditText editText2 = findViewById(R.id.editText2);
        TextView textView = findViewById(R.id.textView);
        if (!( editText.getText().toString().equals("")) && !( editText2.getText().toString().equals(""))) {
            if ((Logins.contains(editText.getText().toString())) && (Passwords.contains(editText2.getText().toString()))) {
                textView.setText("Верно");
            } else {
                textView.setText("Не Верно");
                Intent intent = new Intent(SignIn.this, SignUp.class);
                startActivityForResult(intent, 1);
            }
        }else {
            textView.setText("Введите логин и пароль");
        }
    }
}
