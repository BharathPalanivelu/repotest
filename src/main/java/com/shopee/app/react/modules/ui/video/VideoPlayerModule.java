package com.shopee.app.react.modules.ui.video;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.module.annotations.ReactModule;
import com.shopee.app.react.c;
import com.shopee.app.react.modules.base.ReactBaseLifecycleModule;

@ReactModule(name = "GAVideoPlayer")
public class VideoPlayerModule extends ReactBaseLifecycleModule<a> {
    protected static final String NAME = "GAVideoPlayer";

    public String getName() {
        return NAME;
    }

    public VideoPlayerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public a initHelper(c cVar) {
        return new a(cVar);
    }

    @ReactMethod
    public void openYoutubeVideo(final int i, final String str, final Promise promise) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                if (VideoPlayerModule.this.isMatchingReactTag(i)) {
                    ((a) VideoPlayerModule.this.getHelper()).a(VideoPlayerModule.this.getCurrentActivity(), str, promise);
                }
            }
        });
    }
}
