package com.shopee.feeds.feedlibrary.rn;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.shopee.react.sdk.bridge.modules.app.post.FeedPostingStatusModule;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class a implements ReactPackage {
    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new FeedPostingStatusModule(reactApplicationContext, new b()));
        arrayList.add(new SupportPostingStatus(reactApplicationContext));
        return arrayList;
    }

    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Collections.emptyList();
    }
}
