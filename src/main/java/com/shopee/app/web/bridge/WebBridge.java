package com.shopee.app.web.bridge;

import android.app.Activity;
import android.content.Intent;
import com.shopee.app.ui.webview.g;
import java.util.ArrayList;
import java.util.List;

public class WebBridge {
    private List<WebBridgeModule> mModuleList;

    private WebBridge(Builder builder) {
        this.mModuleList = builder.mModuleList;
    }

    public void attachView(g gVar) {
        if (!(gVar.getContentDescription() != null && "disableWebBridge".equals(gVar.getContentDescription().toString()))) {
            for (WebBridgeModule onAttachView : this.mModuleList) {
                onAttachView.onAttachView(gVar);
            }
        }
    }

    public void startListening() {
        for (WebBridgeModule startListening : this.mModuleList) {
            startListening.startListening();
        }
    }

    public void stopListening() {
        for (WebBridgeModule stopListening : this.mModuleList) {
            stopListening.stopListening();
        }
    }

    public void onDestroy() {
        for (WebBridgeModule onDestroy : this.mModuleList) {
            onDestroy.onDestroy();
        }
    }

    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
        for (WebBridgeModule onActivityResult : this.mModuleList) {
            onActivityResult.onActivityResult(activity, i, i2, intent);
        }
    }

    public void onNewIntent(Intent intent) {
        for (WebBridgeModule onNewIntent : this.mModuleList) {
            onNewIntent.onNewIntent(intent);
        }
    }

    public WebBridgeModule getModule(String str) {
        for (WebBridgeModule next : this.mModuleList) {
            if (str.equals(next.getBridgeName())) {
                return next;
            }
        }
        return null;
    }

    public void onRequestPermissionsResult(Activity activity, int i, String[] strArr, int[] iArr) {
        for (WebBridgeModule onRequestPermissionsResult : this.mModuleList) {
            onRequestPermissionsResult.onRequestPermissionsResult(activity, i, strArr, iArr);
        }
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public List<WebBridgeModule> mModuleList = new ArrayList();

        public Builder addModule(WebBridgeModule webBridgeModule) {
            this.mModuleList.add(webBridgeModule);
            return this;
        }

        public WebBridge build() {
            return new WebBridge(this);
        }
    }
}
