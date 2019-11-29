package com.shopee.app.react.view.mediabrowserview;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.shopee.app.ui.image.MediaData;
import d.d.b.j;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class MediaBrowserViewManager extends SimpleViewManager<a> {
    public static final a Companion = new a((g) null);
    private static final int SAVE_CURRENT_IMAGE = 0;

    public String getName() {
        return "MediaBrowserView";
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    public a createViewInstance(ThemedReactContext themedReactContext) {
        j.b(themedReactContext, "reactContext");
        return new a(themedReactContext);
    }

    @ReactProp(name = "mediaSources")
    public final void setMediaSources(a aVar, ReadableArray readableArray) {
        j.b(aVar, "view");
        j.b(readableArray, "mediaSources");
        aVar.setMediaSources(readMediaSources(readableArray));
    }

    @ReactProp(defaultInt = 0, name = "startIndex")
    public final void setStartIndex(a aVar, int i) {
        j.b(aVar, "view");
        aVar.setStartIndex(i);
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        Map<String, Object> build = MapBuilder.builder().put("onEndReach", MapBuilder.of("registrationName", "onEndReach")).put("onImageClick", MapBuilder.of("registrationName", "onImageClick")).put("onImageLongClick", MapBuilder.of("registrationName", "onImageLongClick")).put("onImageChange", MapBuilder.of("registrationName", "onImageChange")).put("onSaveImageFailure", MapBuilder.of("registrationName", "onSaveImageFailure")).build();
        j.a((Object) build, "MapBuilder.builder<Strin…e\"))\n            .build()");
        return build;
    }

    public Map<String, Integer> getCommandsMap() {
        Map<String, Integer> of = MapBuilder.of("saveCurrentImage", 0);
        j.a((Object) of, "MapBuilder.of(\n         …E_CURRENT_IMAGE\n        )");
        return of;
    }

    public void receiveCommand(a aVar, int i, ReadableArray readableArray) {
        j.b(aVar, "root");
        if (i == 0) {
            aVar.a();
        }
    }

    private final List<MediaData> readMediaSources(ReadableArray readableArray) {
        List<MediaData> arrayList = new ArrayList<>();
        int size = readableArray.size();
        for (int i = 0; i < size; i++) {
            ReadableMap map = readableArray.getMap(i);
            if (map != null) {
                MediaData newMediaData = MediaData.newMediaData(map.getString("path"), map.getBoolean("isVideo"), map.hasKey("trackingData") ? map.getString("trackingData") : null);
                j.a((Object) newMediaData, "MediaData.newMediaData(\n…            trackingData)");
                arrayList.add(newMediaData);
            }
        }
        return arrayList;
    }
}
