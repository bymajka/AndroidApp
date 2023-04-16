package com.example.androidapp1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class OutputFragment extends Fragment {

    private TextView outputText;

    public static OutputFragment newInstance() {
        return new OutputFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View outputView = inflater.inflate(R.layout.fragment_output, container, false);
        outputText = outputView.findViewById(R.id.output);

        return outputView;
    }

    public void setPassword(String password){
        outputText.setText(password);
    }
}