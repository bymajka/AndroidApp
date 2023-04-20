package com.example.androidapp1;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button submitButton;
    InputFragment inputFragment;
    OutputFragment outputFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submitButton = findViewById(R.id.submit_button);
        inputFragment = new InputFragment();
        loadFragment(inputFragment, "Input_Fragment");
        submitButton.setOnClickListener(view -> {
            outputFragment = new OutputFragment(inputFragment.getInputText());
            loadFragment(outputFragment, "Output_Fragment");
            showSubmitButton(false);
        });
    }

    private void loadFragment(Fragment fragment, String tag) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.placeHolder, fragment, tag);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void showSubmitButton(boolean show) {
        submitButton.setVisibility(show ? View.VISIBLE : View.INVISIBLE);
    }

    @Override
    public void onBackPressed() {
        OutputFragment f = (OutputFragment) getSupportFragmentManager().findFragmentByTag("Output_Fragment");
        showSubmitButton(f != null);
        super.onBackPressed();
    }
}