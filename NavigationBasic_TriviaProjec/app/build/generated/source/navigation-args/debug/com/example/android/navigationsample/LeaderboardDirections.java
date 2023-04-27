package com.example.android.navigationsample;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class LeaderboardDirections {
  private LeaderboardDirections() {
  }

  @NonNull
  public static ActionLeaderboardToUserProfile actionLeaderboardToUserProfile() {
    return new ActionLeaderboardToUserProfile();
  }

  public static class ActionLeaderboardToUserProfile implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionLeaderboardToUserProfile() {
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionLeaderboardToUserProfile setUserName(@NonNull String userName) {
      if (userName == null) {
        throw new IllegalArgumentException("Argument \"userName\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("userName", userName);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("userName")) {
        String userName = (String) arguments.get("userName");
        __result.putString("userName", userName);
      } else {
        __result.putString("userName", "name");
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_leaderboard_to_userProfile;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getUserName() {
      return (String) arguments.get("userName");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionLeaderboardToUserProfile that = (ActionLeaderboardToUserProfile) object;
      if (arguments.containsKey("userName") != that.arguments.containsKey("userName")) {
        return false;
      }
      if (getUserName() != null ? !getUserName().equals(that.getUserName()) : that.getUserName() != null) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + (getUserName() != null ? getUserName().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionLeaderboardToUserProfile(actionId=" + getActionId() + "){"
          + "userName=" + getUserName()
          + "}";
    }
  }
}
