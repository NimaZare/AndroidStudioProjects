package com.example.android.navigationsample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import java.util.Objects;

/**
 * Shows a warning-up screen.
 */
public class Match extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_match, container, false);

        view.findViewById(R.id.play_btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_match_to_inGame);
            }
        });
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        UserManager userManager = new UserManager(Objects.requireNonNull(getContext()));
        if (userManager.getUsername().length() == 0) {
            Navigation.findNavController(Objects.requireNonNull(getView())).navigate(R.id.action_match_to_nav_auth);
        }
    }
}