package com.video360;

import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Pair;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.facebook.react.views.image.ImageResizeMode;
import com.facebook.react.views.image.ReactImageView;
import com.facebook.react.views.text.ReactTextView;

import javax.annotation.Nullable;

import com.google.vr.sdk.widgets.common.VrWidgetView;
import com.google.vr.sdk.widgets.video.VrVideoEventListener;
import com.google.vr.sdk.widgets.video.VrVideoView;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Video360Manager extends SimpleViewManager {
  private static final String CLASS_NAME = "Video360";
  private static final String TAG = Video360Module.class.getSimpleName();
  private VrVideoView view;
  private View view2;

  public Video360Manager(ReactApplicationContext context) { super(); }

  @Override
  public String getName() {
    return CLASS_NAME;
  }

  @Override
  protected View createViewInstance(ThemedReactContext context) {
    view = new VrVideoView(context.getCurrentActivity());
    view.setEventListener(new ActivityEventListener());
    // Log.d(TAG, "createViewInstance: test");

    //  view2 = View.inflate(context.getCurrentActivity(), R.layout.activity_video_player_360,null);

    return view;
  }

  @ReactProp(name = "displayMode")
  public void setDisplayMode(VrVideoView view, String mode) {
    switch(mode) {
      case "fullscreen":
        view.setDisplayMode(VrWidgetView.DisplayMode.FULLSCREEN_MONO);
        break;
      case "cardboard":
        view.setDisplayMode(VrWidgetView.DisplayMode.FULLSCREEN_STEREO);
        break;
      default:
        view.setDisplayMode(VrWidgetView.DisplayMode.EMBEDDED);
        break;
    }
  }

  @ReactProp(name = "volume")
  public void setVolume(VrVideoView view, float value) {
    view.setVolume(value);
  }

  @ReactProp(name = "enableFullscreenButton")
  public void setFullscreenButtonEnabled(VrVideoView view, Boolean enabled) {
    view.setFullscreenButtonEnabled(enabled);
  }

  @ReactProp(name = "enableCardboardButton")
  public void setCardboardButtonEnabled(VrVideoView view, Boolean enabled) {
    view.setStereoModeButtonEnabled(enabled);
  }

  @ReactProp(name = "enableTouchTracking")
  public void setTouchTrackingEnabled(VrVideoView view, Boolean enabled) {
    view.setTouchTrackingEnabled(enabled);
  }

  @ReactProp(name = "hidesTransitionView")
  public void setTransitionViewEnabled(VrVideoView view, Boolean enabled) {
    view.setTransitionViewEnabled(!enabled);
  }

  @ReactProp(name = "enableInfoButton")
  public void setInfoButtonEnabled(VrVideoView view, Boolean enabled) {
    view.setInfoButtonEnabled(enabled);
  }

  VideoLoaderTask videoLoaderTask;

  @ReactProp(name = "urlVideo")
  public void setVideo(VrVideoView view, String url) {
    // String type = config.getString("type");
    //   Uri uri = Uri.parse(config.getString("uri"));

    Uri uri = Uri.parse(url);


    VrVideoView.Options videoOptions = new VrVideoView.Options();
    videoOptions.inputFormat = VrVideoView.Options.FORMAT_DEFAULT;
//
//        switch(type) {
//            case "mono":
//                videoOptions.inputType = VrVideoView.Options.TYPE_MONO;
//                break;
//            case "stereo":
//                videoOptions.inputType = VrVideoView.Options.TYPE_STEREO_OVER_UNDER;
//                break;
//            default:
//                videoOptions.inputType = VrVideoView.Options.TYPE_MONO;
//                break;
//        }

    videoLoaderTask = new VideoLoaderTask(view);
    videoLoaderTask.loadVideo(uri, videoOptions);
  }

  private class ActivityEventListener extends VrVideoEventListener {
    @Override
    public void onLoadSuccess() {

      Log.i(TAG, "Successfully loaded video " + view.getDuration());
    }

    /**
     * Called by video widget on the UI thread on any asynchronous error.
     */
    @Override
    public void onLoadError(String errorMessage) {
      // An error here is normally due to being unable to decode the video format.
      Log.e(TAG, "Error loading video: " + errorMessage);
    }

    /**
     * Update the UI every frame.
     */
    @Override
    public void onNewFrame() {

    }

    /**
     * Make the video play in a loop. This method could also be used to move to the next video in
     * a playlist.
     */
    @Override
    public void onCompletion() {
      if(view != null) view.seekTo(0);
    }
  }

  public class VideoLoaderTask {

    private VrVideoView view;
    private ExecutorService executorService;

    public VideoLoaderTask(VrVideoView vrVideoView) {
      this.view = vrVideoView;
      this.executorService = Executors.newSingleThreadExecutor();
    }

    // Function to load video
    public void loadVideo(Uri uri, VrVideoView.Options options) {
      executorService.submit(() -> {
        try {
          view.loadVideo(uri, options); // Loading video in the background
        } catch (IOException e) {
          e.printStackTrace(); // Handle the exception
        }
      });
    }

    // Shutdown the executor service when done
    public void shutdown() {
      executorService.shutdown();
    }
  }

//  class VideoLoaderTask extends AsyncTask<Pair<Uri, VrVideoView.Options>, Void, Boolean> {
//    @SuppressWarnings("WrongThread")
//    protected Boolean doInBackground(Pair<Uri, VrVideoView.Options>... args) {
//      try {
//        view.loadVideo(args[0].first, args[0].second);
//      } catch (IOException e) {}
//
//      return true;
//    }
//  }
}
