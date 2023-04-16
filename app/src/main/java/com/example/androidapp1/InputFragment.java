package com.example.androidapp1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.google.android.material.textfield.TextInputLayout;

public class InputFragment extends Fragment {
    public TextInputLayout getInputLayout() {
        return inputLayout;
    }

    public void setInputLayout(TextInputLayout inputLayout) {
        this.inputLayout = inputLayout;
    }

    private TextInputLayout inputLayout;
    private RadioButton showButton;
    private RadioButton hideButton;

    public static InputFragment newInstance() {
        return new InputFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View inputView = inflater.inflate(R.layout.fragment_input, container, false);
        inputLayout = inputView.findViewById(R.id.textInputLayout);
        showButton = inputView.findViewById(R.id.showButton);
        hideButton = inputView.findViewById(R.id.hideButton);

        showButton.setOnClickListener(view -> inputLayout.
                getEditText().setTransformationMethod(null));
        hideButton.setOnClickListener(view -> inputLayout.
                getEditText().setTransformationMethod(new PasswordTransformationMethod()));
        return inputView;
    }
}