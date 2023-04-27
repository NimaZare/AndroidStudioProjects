package com.example.android.navigationsample;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;

public class InGameDirections {
  private InGameDirections() {
  }

  @NonNull
  public static NavDirections actionInGameToResultsWinner() {
    return new ActionOnlyNavDirections(R.id.action_inGame_to_resultsWinner);
  }

  @NonNull
  public static NavDirections actionInGameToGameOver() {
    return new ActionOnlyNavDirections(R.id.action_inGame_to_gameOver);
  }
}
