package com.example.android.navigationsample;

import android.content.Context;
import android.content.SharedPreferences;

public class UserManager {
    private SharedPreferences sharedPreferences;

    public UserManager(Context context) {
        this.sharedPreferences = context.getSharedPreferences("auth", Context.MODE_PRIVATE);
    }

    public void saveUserInfo(String username, String pass, String email) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", username);
        editor.putString("pass", pass);
        editor.putString("email", email);
        editor.apply();
    }

    public String getUsername() {
        return sharedPreferences.getString("username", "");
    }

    public String getPassword() {
        return sharedPreferences.getString("pass", "");
    }

    public String getEmail() {
        return sharedPreferences.getString("email", "");
    }
}
