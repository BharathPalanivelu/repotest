package com.shopee.app.react.view.modiface;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.facebook.react.uimanager.ThemedReactContext;
import com.modiface.mfemakeupkit.MFEMakeupEngine;
import com.modiface.mfemakeupkit.data.MFETrackingData;
import d.d.b.j;

@SuppressLint({"ViewConstructor"})
public final class c extends b implements MFEMakeupEngine.MFEMakeupEngineImageProcessedCallback {

    /* renamed from: a  reason: collision with root package name */
    private String f19065a;

    public void onMFEMakeupFinishedProcessingImage(MFETrackingData mFETrackingData) {
        j.b(mFETrackingData, "trackingData");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(Context context, ThemedReactContext themedReactContext, AttributeSet attributeSet, int i) {
        super(context, themedReactContext, attributeSet, i);
        j.b(context, "context");
        j.b(themedReactContext, "reactContext");
        this.f19065a = "";
        addView(getMakeupView(), new FrameLayout.LayoutParams(-1, -1));
        a(this, this);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(Context context, ThemedReactContext themedReactContext, AttributeSet attributeSet, int i, int i2, g gVar) {
        this(context, themedReactContext, (i2 & 4) != 0 ? null : attributeSet, (i2 & 8) != 0 ? 0 : i);
    }

    public final String getUriPath() {
        return this.f19065a;
    }

    public final void setUriPath(String str) {
        j.b(str, "<set-?>");
        this.f19065a = str;
    }

    public void a() {
        super.a();
        if (this.f19065a.length() > 0) {
            Context context = getContext();
            j.a((Object) context, "context");
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(context.getContentResolver(), Uri.parse(this.f19065a));
            MFEMakeupEngine makeupEngine = getMakeupEngine();
            if (makeupEngine != null) {
                makeupEngine.startRunningWithPhoto(bitmap, false, (MFEMakeupEngine.MFEMakeupEngineDetectionCallback) null, (MFEMakeupEngine.MFEMakeupEngineImageProcessedCallback) null);
            }
        }
    }
}
