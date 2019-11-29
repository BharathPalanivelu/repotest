package com.garena.rnrecyclerview.library.sticky2;

import android.view.View;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import java.util.Map;

public class ReactStickyRecyclerLayoutManager extends ViewGroupManager<b> {
    public String getName() {
        return "StickyRecyclerLayout";
    }

    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    public void addView(b bVar, View view, int i) {
        if (i == 1) {
            bVar.a(view);
        } else {
            bVar.b(view);
        }
    }

    /* access modifiers changed from: protected */
    public b createViewInstance(ThemedReactContext themedReactContext) {
        return new b(themedReactContext);
    }

    public Map getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.builder().put("onStickyHeaderChanged", MapBuilder.of("registrationName", "onStickyHeaderChanged")).build();
    }
}
