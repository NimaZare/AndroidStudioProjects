package com.example.android.navigationsample;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class UserProfileArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private UserProfileArgs() {
  }

  @SuppressWarnings("unchecked")
  private UserProfileArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static UserProfileArgs fromBundle(@NonNull Bundle bundle) {
    UserProfileArgs __result = new UserProfileArgs();
    bundle.setClassLoader(UserProfileArgs.class.getClassLoader());
    if (bundle.containsKey("userName")) {
      String userName;
      userName = bundle.getString("userName");
      if (userName == null) {
        throw new IllegalArgumentException("Argument \"userName\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("userName", userName);
    } else {
      __result.arguments.put("userName", "name");
    }
    return __result;
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static UserProfileArgs fromSavedStateHandle(@NonNull SavedStateHandle savedStateHandle) {
    UserProfileArgs __result = new UserProfileArgs();
    if (savedStateHandle.contains("userName")) {
      String userName;
      userName = savedStateHandle.get("userName");
      if (userName == null) {
        throw new IllegalArgumentException("Argument \"userName\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("userName", userName);
    } else {
      __result.arguments.put("userName", "name");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public String getUserName() {
    return (String) arguments.get("userName");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("userName")) {
      String userName = (String) arguments.get("userName");
      __result.putString("userName", userName);
    } else {
      __result.putString("userName", "name");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public SavedStateHandle toSavedStateHandle() {
    SavedStateHandle __result = new SavedStateHandle();
    if (arguments.containsKey("userName")) {
      String userName = (String) arguments.get("userName");
      __result.set("userName", userName);
    } else {
      __result.set("userName", "name");
    }
    return __result;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    UserProfileArgs that = (UserProfileArgs) object;
    if (arguments.containsKey("userName") != that.arguments.containsKey("userName")) {
      return false;
    }
    if (getUserName() != null ? !getUserName().equals(that.getUserName()) : that.getUserName() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getUserName() != null ? getUserName().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "UserProfileArgs{"
        + "userName=" + getUserName()
        + "}";
  }

  public static final class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(@NonNull UserProfileArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder() {
    }

    @NonNull
    public UserProfileArgs build() {
      UserProfileArgs result = new UserProfileArgs(arguments);
      return result;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setUserName(@NonNull String userName) {
      if (userName == null) {
        throw new IllegalArgumentException("Argument \"userName\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("userName", userName);
      return this;
    }

    @SuppressWarnings({"unchecked","GetterOnBuilder"})
    @NonNull
    public String getUserName() {
      return (String) arguments.get("userName");
    }
  }
}
