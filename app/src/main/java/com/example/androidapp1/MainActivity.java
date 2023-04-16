package com.example.androidapp1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    Button submitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submitButton = findViewById(R.id.submit_button);
        InputFragment inputFragment = new InputFragment();
        OutputFragment outputFragment = new OutputFragment();
        loadFragment(inputFragment);
        submitButton.setOnClickListener(view -> {
            sendPassword(inputFragment.getInputLayout().getEditText().getText().toString(), outputFragment);
            loadFragment(outputFragment);
            submitButton.setVisibility(View.INVISIBLE);
        });
    }

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//frame_container is your layout name in xml file
        transaction.replace(R.id.placeHolder, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void sendPassword(String password, OutputFragment outputFragment){
        outputFragment.setPassword(password);
    }
}