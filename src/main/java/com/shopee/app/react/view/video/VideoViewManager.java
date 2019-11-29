package com.shopee.app.react.view.video;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import java.util.Map;

public class VideoViewManager extends ViewGroupManager<a> {
    private static final int DESTROY = 3;
    private static final int PAUSE = 1;
    private static final int PLAY = 0;
    private static final int SEEK_TO = 2;
    private static final int SET_MUTED = 4;

    public String getName() {
        return "ReactVideoView";
    }

    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    /* access modifiers changed from: protected */
    public a createViewInstance(ThemedReactContext themedReactContext) {
        return new a(themedReactContext);
    }

    @ReactProp(name = "source")
    public void setSource(a aVar, String str) {
        aVar.setSource(str);
    }

    @ReactProp(name = "isMuted")
    public void setMuted(a aVar, boolean z) {
        aVar.setMuted(z);
    }

    public Map getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.builder().put("onVideoPlaying", MapBuilder.of("registrationName", "onVideoPlaying")).put("onVideoStateChanged", MapBuilder.of("registrationName", "onVideoStateChanged")).build();
    }

    public Map<String, Integer> getCommandsMap() {
        return MapBuilder.of("play", 0, "pause", 1, "seekTo", 2, "destroy", 3, "setMuted", 4);
    }

    public void receiveCommand(a aVar, int i, ReadableArray readableArray) {
        if (i == 0) {
            aVar.b();
        } else if (i == 1) {
            aVar.c();
        } else if (i == 2) {
            aVar.a(readableArray.getInt(0));
        } else if (i == 3) {
            aVar.d();
        } else if (i == 4) {
            aVar.setMuted(readableArray.getBoolean(0));
        }
    }
}
