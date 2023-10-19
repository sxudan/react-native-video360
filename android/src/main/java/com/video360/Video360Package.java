package com.video360;

import androidx.annotation.NonNull;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import com.facebook.react.uimanager.ViewManager;

public class Video360Package implements ReactPackage {
  @NonNull
  @Override
  public List<NativeModule> createNativeModules(@NonNull ReactApplicationContext reactContext) {
    // List<NativeModule> modules = new ArrayList<>();
    // modules.add(new Video360Module(reactContext));
    // return modules;
    return Collections.emptyList();
  }

  @NonNull
  @Override
  public List<ViewManager> createViewManagers(@NonNull ReactApplicationContext reactContext) {
    return Arrays.<ViewManager>asList(
      new Video360Manager(reactContext)
    );
  }
}
