package com.example.android.navigationsample;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;

public class MatchDirections {
  private MatchDirections() {
  }

  @NonNull
  public static NavDirections actionMatchToInGame() {
    return new ActionOnlyNavDirections(R.id.action_match_to_inGame);
  }

  @NonNull
  public static NavDirections actionMatchToNavAuth() {
    return new ActionOnlyNavDirections(R.id.action_match_to_nav_auth);
  }
}
