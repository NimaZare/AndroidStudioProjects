package com.example.android.navigationsample;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;

public class GameOverDirections {
  private GameOverDirections() {
  }

  @NonNull
  public static NavDirections actionGameOverToMatch() {
    return new ActionOnlyNavDirections(R.id.action_gameOver_to_match);
  }
}
