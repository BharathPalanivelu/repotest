package com.garena.rnrecyclerview.library;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.garena.rnrecyclerview.library.parallax.ReactCoordinatorLayoutManager;
import com.garena.rnrecyclerview.library.recycler.ReactRecyclerViewManager;
import com.garena.rnrecyclerview.library.sticky.StickyHeaderContainerManager;
import com.garena.rnrecyclerview.library.sticky.StickyRecyclerViewManager;
import com.garena.rnrecyclerview.library.sticky2.ReactStickyRecyclerLayoutManager;
import com.garena.rnrecyclerview.library.sticky2.StickyRecyclerViewManager2;
import com.garena.rnrecyclerview.library.view.ReactRecyclerItemViewManager;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class b implements ReactPackage {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f8541a = false;

    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        return Collections.singletonList(new ReactRecyclerViewModule(reactApplicationContext));
    }

    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Arrays.asList(new ViewManager[]{new ReactRecyclerItemViewManager(), new ReactRecyclerViewManager(), new StickyRecyclerViewManager(), new StickyRecyclerViewManager2(), new StickyHeaderContainerManager(), new ReactCoordinatorLayoutManager(), new ReactStickyRecyclerLayoutManager()});
    }
}
