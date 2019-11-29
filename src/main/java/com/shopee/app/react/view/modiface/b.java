package com.shopee.app.react.view.modiface;

import android.content.Context;
import android.content.res.Configuration;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.modiface.mfemakeupkit.MFEMakeupEngine;
import com.modiface.mfemakeupkit.camera.MFEAndroidCameraErrorCallback;
import com.modiface.mfemakeupkit.camera.MFEAndroidCameraParameters;
import com.modiface.mfemakeupkit.camera.MFEAndroidCameraParametersCallback;
import com.modiface.mfemakeupkit.data.MFEMakeupRenderingParameters;
import com.modiface.mfemakeupkit.effects.MFEMakeupLook;
import com.modiface.mfemakeupkit.widgets.MFEBeforeAfterMakeupView;
import d.d.b.j;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class b extends FrameLayout implements LifecycleEventListener, MFEMakeupEngine.MFEMakeupEngineErrorCallback, MFEAndroidCameraErrorCallback, MFEAndroidCameraParametersCallback {

    /* renamed from: a  reason: collision with root package name */
    private MFEBeforeAfterMakeupView f19058a;

    /* renamed from: b  reason: collision with root package name */
    private MFEMakeupEngine f19059b;

    /* renamed from: c  reason: collision with root package name */
    private MFEMakeupLook f19060c = new MFEMakeupLook();

    /* renamed from: d  reason: collision with root package name */
    private final EventDispatcher f19061d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f19062e;

    /* renamed from: f  reason: collision with root package name */
    private final ThemedReactContext f19063f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Context context, ThemedReactContext themedReactContext, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        j.b(context, "context");
        j.b(themedReactContext, "reactContext");
        this.f19063f = themedReactContext;
        NativeModule nativeModule = this.f19063f.getNativeModule(UIManagerModule.class);
        j.a((Object) nativeModule, "reactContext\n           …anagerModule::class.java)");
        this.f19061d = ((UIManagerModule) nativeModule).getEventDispatcher();
        this.f19058a = new MFEBeforeAfterMakeupView(context);
    }

    public final ThemedReactContext getReactContext() {
        return this.f19063f;
    }

    /* access modifiers changed from: protected */
    public final MFEBeforeAfterMakeupView getMakeupView() {
        return this.f19058a;
    }

    /* access modifiers changed from: protected */
    public final void setMakeupView(MFEBeforeAfterMakeupView mFEBeforeAfterMakeupView) {
        this.f19058a = mFEBeforeAfterMakeupView;
    }

    /* access modifiers changed from: protected */
    public final MFEMakeupEngine getMakeupEngine() {
        return this.f19059b;
    }

    /* access modifiers changed from: protected */
    public final void setMakeupEngine(MFEMakeupEngine mFEMakeupEngine) {
        this.f19059b = mFEMakeupEngine;
    }

    /* access modifiers changed from: protected */
    public final EventDispatcher getEventDispatcher() {
        return this.f19061d;
    }

    /* access modifiers changed from: protected */
    public final void a(MFEMakeupEngine.MFEMakeupEngineErrorCallback mFEMakeupEngineErrorCallback, MFEAndroidCameraErrorCallback mFEAndroidCameraErrorCallback) {
        j.b(mFEMakeupEngineErrorCallback, "engineErrorCallback");
        j.b(mFEAndroidCameraErrorCallback, "cameraErrorCallback");
        com.garena.android.appkit.d.a.e("modiface : initialView", new Object[0]);
        MFEMakeupEngine mFEMakeupEngine = new MFEMakeupEngine(getContext(), MFEMakeupEngine.Region.US, mFEMakeupEngineErrorCallback);
        mFEMakeupEngine.loadResources(getContext(), (MFEMakeupEngine.MFEMakeupEngineLoadResourcesCallback) a.f19064a);
        mFEMakeupEngine.setCameraErrorCallback(mFEAndroidCameraErrorCallback);
        mFEMakeupEngine.setCameraParametersCallback(this);
        this.f19059b = mFEMakeupEngine;
        MFEBeforeAfterMakeupView mFEBeforeAfterMakeupView = this.f19058a;
        if (mFEBeforeAfterMakeupView != null) {
            mFEBeforeAfterMakeupView.setup(this.f19059b);
            mFEBeforeAfterMakeupView.setBeforeViewVisible(false);
        }
        MFEAndroidCameraParameters mFEAndroidCameraParameters = new MFEAndroidCameraParameters();
        mFEAndroidCameraParameters.isFrontCamera = true;
        mFEAndroidCameraParameters.isContinuousAutoFocusOn = true;
        MFEMakeupEngine mFEMakeupEngine2 = this.f19059b;
        if (mFEMakeupEngine2 != null) {
            mFEMakeupEngine2.setMakeupRenderingParameters(new MFEMakeupRenderingParameters(false));
            mFEMakeupEngine2.setMakeupLook(this.f19060c);
            mFEMakeupEngine2.setCameraParameters(getContext(), mFEAndroidCameraParameters);
            mFEMakeupEngine2.enableFaceTracking();
        }
    }

    static final class a implements MFEMakeupEngine.MFEMakeupEngineLoadResourcesCallback {

        /* renamed from: a  reason: collision with root package name */
        public static final a f19064a = new a();

        a() {
        }

        public final void onMFEMakeupFinishedLoadResources() {
            com.garena.android.appkit.d.a.e("modiface : Makeup engine finished loading resources", new Object[0]);
        }
    }

    public void onMakeupEngineError(ArrayList<Throwable> arrayList) {
        j.b(arrayList, "errors");
        this.f19061d.dispatchEvent(new com.shopee.app.react.view.modiface.a.a(getId(), 10));
        Iterator<Throwable> it = arrayList.iterator();
        while (it.hasNext()) {
            com.garena.android.appkit.d.a.a(it.next());
        }
        com.garena.android.appkit.d.a.e("modiface : onMakeupEngineError", new Object[0]);
    }

    public void onCameraFailedToStart(String str, Throwable th) {
        this.f19061d.dispatchEvent(new com.shopee.app.react.view.modiface.a.a(getId(), 11));
        if (str == null) {
            str = "modiface : onCameraFailedToStart UNKNOWN CAUSE";
        }
        com.garena.android.appkit.d.a.e(str, new Object[0]);
        if (th == null) {
            th = new Throwable("modiface : onCameraFailedToStart UNKNOWN CAUSE");
        }
        com.garena.android.appkit.d.a.a(th);
    }

    public void onCameraSetParameters(Camera.Parameters parameters, MFEAndroidCameraParameters mFEAndroidCameraParameters) {
        com.garena.android.appkit.d.a.e("modiface.onCameraSetParameters:%s", String.valueOf(parameters));
    }

    public final void setLook(MFEMakeupLook mFEMakeupLook) {
        j.b(mFEMakeupLook, "mfeMakeupLook");
        this.f19060c = mFEMakeupLook;
        MFEMakeupEngine mFEMakeupEngine = this.f19059b;
        if (mFEMakeupEngine != null) {
            com.garena.android.appkit.d.a.e("modiface : set look and runRender", new Object[0]);
            mFEMakeupEngine.setMakeupLook(this.f19060c);
            if (!this.f19062e) {
                a();
            }
        }
    }

    public void a() {
        if (this.f19059b == null) {
            a(this, this);
        }
        this.f19062e = true;
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        MFEMakeupEngine mFEMakeupEngine = this.f19059b;
        if (mFEMakeupEngine != null) {
            mFEMakeupEngine.onConfigurationChanged(getContext());
        }
    }

    public void onHostResume() {
        MFEMakeupEngine mFEMakeupEngine = this.f19059b;
        if (mFEMakeupEngine != null) {
            mFEMakeupEngine.onResume(getContext());
        }
        MFEMakeupEngine mFEMakeupEngine2 = this.f19059b;
        if (mFEMakeupEngine2 != null) {
            mFEMakeupEngine2.enableFaceTracking();
        }
    }

    public void onHostPause() {
        MFEMakeupEngine mFEMakeupEngine = this.f19059b;
        if (mFEMakeupEngine != null) {
            mFEMakeupEngine.onPause();
        }
    }

    public void onHostDestroy() {
        MFEMakeupEngine mFEMakeupEngine = this.f19059b;
        if (mFEMakeupEngine != null) {
            mFEMakeupEngine.disableFaceTracking();
        }
        this.f19059b = null;
        this.f19058a = null;
    }
}
