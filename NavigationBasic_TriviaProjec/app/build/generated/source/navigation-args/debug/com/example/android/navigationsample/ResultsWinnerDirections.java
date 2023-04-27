package com.example.android.navigationsample;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;

public class ResultsWinnerDirections {
  private ResultsWinnerDirections() {
  }

  @NonNull
  public static NavDirections actionResultsWinnerToMatch() {
    return new ActionOnlyNavDirections(R.id.action_resultsWinner_to_match);
  }

  @NonNull
  public static NavDirections actionResultsWinnerToLeaderboard() {
    return new ActionOnlyNavDirections(R.id.action_resultsWinner_to_leaderboard);
  }
}
