package com.example.androidapp1;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button submitButton;
    Button baseButton;
    Button clearButton;
    DatabaseHelper databaseHelper;
    InputFragment inputFragment;
    OutputFragment outputFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);

        submitButton = findViewById(R.id.submit_button);
        baseButton = findViewById(R.id.base_button);
        clearButton = findViewById(R.id.clear_button);

        inputFragment = new InputFragment();
        loadFragment(inputFragment, "Input_Fragment");

        submitButton.setOnClickListener(view -> {
            if (inputFragment.getInputText() != null && !inputFragment.getInputText().isEmpty()) {
                databaseHelper.addItem(inputFragment.getInputText(),
                        selectInputType(inputFragment.Hidden()));
            }
            outputFragment = new OutputFragment(inputFragment.getInputText());
            loadFragment(outputFragment, "Output_Fragment");
            showSubmitButton(false);
        });

        baseButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, StorageActivity.class);
            startActivity(intent);
        });

        clearButton.setOnClickListener(view -> databaseHelper.deleteDatabase());
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

    Item.Type selectInputType(boolean visibility) {
        Item.Type type = visibility ? Item.Type.hidden_password : Item.Type.public_password;
        return type;
    }
}