/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.navigationsample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.util.Objects;


/**
 * Shows a register form (that does nothing, for simplicity)
 */
public class Register extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        EditText usernameEt = view.findViewById(R.id.username_text);
        EditText passEt = view.findViewById(R.id.password_text);
        EditText emailEt = view.findViewById(R.id.email_text);
        UserManager userManager = new UserManager(Objects.requireNonNull(getContext()));

        view.findViewById(R.id.signup_btn).setOnClickListener(v -> {
            userManager.saveUserInfo(usernameEt.getText().toString(),
                    passEt.getText().toString(), emailEt.getText().toString());
            NavHostFragment.findNavController(Register.this)
                    .navigate(R.id.action_register_to_match);
        });

        return view;
    }
}