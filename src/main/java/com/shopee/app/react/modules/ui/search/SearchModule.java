package com.shopee.app.react.modules.ui.search;

import android.content.Intent;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.share.internal.ShareConstants;
import com.google.a.o;
import com.shopee.app.react.c;
import com.shopee.app.react.modules.base.ReactBaseActivityResultModule;

@ReactModule(name = "GASearch")
public class SearchModule extends ReactBaseActivityResultModule<a> {
    public static final int RESULT_START_IMAGE_SEARCH = 2;

    public String getName() {
        return "GASearch";
    }

    public void onNewIntent(Intent intent) {
    }

    public SearchModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public a initHelper(c cVar) {
        return new a();
    }

    @ReactMethod
    public void startSearch(final int i, final String str, final Promise promise) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                if (SearchModule.this.isMatchingReactTag(i)) {
                    ((a) SearchModule.this.getHelper()).a(SearchModule.this.getCurrentActivity(), str, promise);
                    return;
                }
                o oVar = new o();
                oVar.a("status", (Number) 0);
                promise.resolve(oVar.toString());
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i != 10029) {
            return;
        }
        if (i2 == -1) {
            String stringExtra = intent.getStringExtra("keyword");
            int intExtra = intent.getIntExtra("type", 0);
            int intExtra2 = intent.getIntExtra("defaultSuggestionsIndex", -1);
            int intExtra3 = intent.getIntExtra("scopeListIndex", -1);
            int intExtra4 = intent.getIntExtra("cateId", 0);
            String stringExtra2 = intent.getStringExtra("cateName");
            ((a) getHelper()).a(stringExtra, intExtra, intExtra2, intExtra3, intent.getStringExtra(ShareConstants.FEED_SOURCE_PARAM), intExtra4, stringExtra2, intent.getStringExtra("tracking"));
        } else if (i2 == 2) {
            ((a) getHelper()).a(getCurrentActivity());
        } else {
            ((a) getHelper()).a();
        }
    }
}
