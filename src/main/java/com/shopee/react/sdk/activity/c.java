package com.shopee.react.sdk.activity;

import android.content.Context;
import android.view.View;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerHelper;

public class c extends ReactRootView {

    /* renamed from: a  reason: collision with root package name */
    private Runnable f30165a = new Runnable() {
        public void run() {
            ReactInstanceManager reactInstanceManager = c.this.getReactInstanceManager();
            if (reactInstanceManager != null) {
                final ReactContext currentReactContext = reactInstanceManager.getCurrentReactContext();
                if (currentReactContext != null) {
                    currentReactContext.runOnNativeModulesQueueThread(new GuardedRunnable(currentReactContext) {
                        public void runGuarded() {
                            UIManagerHelper.getUIManager(currentReactContext, c.this.getUIManagerType()).updateRootLayoutSpecs(c.this.getRootViewTag(), c.this.getWidthMeasureSpec(), c.this.getHeightMeasureSpec());
                        }
                    });
                }
            }
        }
    };

    public c(Context context) {
        super(context);
    }

    public void onViewAdded(View view) {
        super.onViewAdded(view);
        post(this.f30165a);
    }
}
