package com.example.android.navigationsample;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;

public class RegisterDirections {
  private RegisterDirections() {
  }

  @NonNull
  public static NavDirections actionRegisterToMatch() {
    return new ActionOnlyNavDirections(R.id.action_register_to_match);
  }
}
