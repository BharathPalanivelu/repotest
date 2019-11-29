package com.shopee.app.web.bridge.modules;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.garena.android.appkit.d.a;
import com.google.a.o;
import com.shopee.app.data.viewmodel.camera.PhotoFrameInfo;
import com.shopee.app.react.modules.ui.abtesting.AbTestingModule;
import com.shopee.app.ui.image.icimage.c;
import com.shopee.app.web.OpenICCameraMessage1;
import com.shopee.app.web.bridge.WebBridgeModule;
import com.shopee.app.web.bridge.WebPromise;
import java.io.ByteArrayOutputStream;

@Deprecated
public class ICImageModule1 extends WebBridgeModule implements c.a {
    private c mHandler;

    /* access modifiers changed from: protected */
    public String getBridgeName() {
        return "openICCamera";
    }

    ICImageModule1(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onInit() {
        this.mHandler = c.a((c.a) this);
    }

    /* access modifiers changed from: protected */
    public void onBridgeInvoked(Object obj) {
        Activity activity = getActivity();
        if (activity != null) {
            OpenICCameraMessage1 openICCameraMessage1 = (OpenICCameraMessage1) obj;
            this.mHandler.a(PhotoFrameInfo.Util.INSTANCE.from(openICCameraMessage1));
            this.mHandler.a(openICCameraMessage1.getPreferMinImageSize());
            this.mHandler.a(activity);
        }
    }

    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
        c cVar = this.mHandler;
        if (cVar != null) {
            cVar.a(activity, i, i2, intent);
        }
    }

    public void onResult(String str, int i) {
        imageToBase64(str, i);
    }

    /* access modifiers changed from: package-private */
    public void imageToBase64(String str, int i) {
        Context context = getContext();
        if (context == null || TextUtils.isEmpty(str)) {
            rejectPromise(2, "User Cancel");
            return;
        }
        try {
            Bitmap decodeStream = BitmapFactory.decodeStream(context.getContentResolver().openInputStream(Uri.parse(str)));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            decodeStream.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            resolvePromise("data:image/jpeg;base64," + Base64.encodeToString(byteArray, 2), i);
        } catch (Exception e2) {
            a.a(e2);
            rejectPromise(-1, e2.toString());
        }
    }

    /* access modifiers changed from: package-private */
    public void resolvePromise(String str, int i) {
        WebPromise promise = getPromise();
        if (promise != null) {
            o oVar = new o();
            oVar.a(AbTestingModule.KEY_RESULT, str);
            promise.resolve(oVar);
        }
    }

    /* access modifiers changed from: package-private */
    public void rejectPromise(int i, String str) {
        WebPromise promise = getPromise();
        if (promise != null) {
            o oVar = new o();
            oVar.a(AbTestingModule.KEY_RESULT, "");
            oVar.a("error", (Number) Integer.valueOf(i));
            oVar.a("errorMessage", str);
            promise.reject(oVar);
        }
    }
}
