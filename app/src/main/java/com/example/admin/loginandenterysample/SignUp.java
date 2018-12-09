package com.example.admin.loginandenterysample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignUp extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Button btn1 = findViewById(R.id.button2);
        btn1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        EditText editText = findViewById(R.id.editText3);
        EditText editText2 = findViewById(R.id.editText4);
        TextView textView = findViewById(R.id.textView2);
        if (!( editText.getText().toString().equals("")) && !( editText2.getText().toString().equals(""))){
            Intent intent = new Intent();
            intent.putExtra("log", editText.getText().toString());
            intent.putExtra("password", editText2.getText().toString());
            setResult(RESULT_OK, intent);
            finish();
        }else {
            textView.setText("Введите логин и пароль");
        }
    }
}
