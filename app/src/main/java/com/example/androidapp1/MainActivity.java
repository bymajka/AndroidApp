package com.example.androidapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    RadioButton showRb, hideRb;
    Button submitButton;
    TextView output;
    TextInputLayout inputLayout;
    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showRb = findViewById(R.id.show_password_rb);
        hideRb = findViewById(R.id.hide_password_rb);
        submitButton = findViewById(R.id.submit_button);
        output = findViewById(R.id.output_text);
        inputLayout = findViewById(R.id.textInputLayout);
        input = inputLayout.getEditText();

        submitButton.setOnClickListener(view -> output.setText(input.getText()));

        showRb.setOnClickListener(view -> input.setTransformationMethod(null));

        hideRb.setOnClickListener(view -> input.setTransformationMethod(PasswordTransformationMethod.getInstance()));
    }
}