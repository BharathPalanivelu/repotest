package com.shopee.app.react.view.modiface;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.core.content.b;
import com.facebook.react.uimanager.ThemedReactContext;
import com.garena.android.appkit.d.a;
import com.modiface.mfemakeupkit.MFEMakeupEngine;
import d.d.b.j;

@SuppressLint({"ViewConstructor"})
public final class d extends b {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(Context context, ThemedReactContext themedReactContext, AttributeSet attributeSet, int i, int i2, g gVar) {
        this(context, themedReactContext, (i2 & 4) != 0 ? null : attributeSet, (i2 & 8) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(Context context, ThemedReactContext themedReactContext, AttributeSet attributeSet, int i) {
        super(context, themedReactContext, attributeSet, i);
        j.b(context, "context");
        j.b(themedReactContext, "reactContext");
        addView(getMakeupView(), new FrameLayout.LayoutParams(-1, -1));
        a(this, this);
    }

    public void a() {
        super.a();
        if (getMakeupEngine() != null) {
            a.e("modiface : run render", new Object[0]);
            if (b.b(getContext(), "android.permission.CAMERA") == 0) {
                MFEMakeupEngine makeupEngine = getMakeupEngine();
                if (makeupEngine != null) {
                    makeupEngine.startRunningWithCamera(getContext());
                    return;
                }
                return;
            }
            getEventDispatcher().dispatchEvent(new com.shopee.app.react.view.modiface.a.a(getId(), 12));
        }
    }

    public void onHostDestroy() {
        super.onHostDestroy();
        removeAllViews();
    }
}
