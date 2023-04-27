package com.example.android.navigationsample;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;

public class TitleScreenDirections {
  private TitleScreenDirections() {
  }

  @NonNull
  public static NavDirections actionTitleScreenToLeaderboard() {
    return new ActionOnlyNavDirections(R.id.action_titleScreen_to_leaderboard);
  }

  @NonNull
  public static NavDirections actionTitleScreenToRegister() {
    return new ActionOnlyNavDirections(R.id.action_titleScreen_to_register);
  }
}
