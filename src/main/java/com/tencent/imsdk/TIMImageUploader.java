package com.tencent.imsdk;

import android.text.TextUtils;
import com.tencent.imcore.IImageUploadCallback;
import com.tencent.imcore.IMCoreUser;
import com.tencent.imcore.ImageElem;
import com.tencent.imsdk.log.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class TIMImageUploader {
    static String defaultId = "";
    static ConcurrentHashMap<String, TIMImageUploader> mutiMap = new ConcurrentHashMap<>();
    static final String tag = "TIMImageUploader";
    /* access modifiers changed from: private */
    public String identifier = "";

    class aa extends IImageUploadCallback {

        /* renamed from: a  reason: collision with root package name */
        private TIMValueCallBack<TIMImageElem> f30675a;

        aa(TIMValueCallBack<TIMImageElem> tIMValueCallBack) {
            this.f30675a = tIMValueCallBack;
            swigReleaseOwnership();
        }

        public final void done(ImageElem imageElem) {
            this.f30675a.onSuccess(TIMElem.buildImageElem(imageElem, TIMImageUploader.this.identifier));
            swigTakeOwnership();
        }

        public final void fail(int i, String str) {
            this.f30675a.onError(i, str);
            swigTakeOwnership();
        }
    }

    private TIMImageUploader(String str) {
        this.identifier = str;
    }

    private IMCoreUser getIMCoreUser() {
        return (TextUtils.isEmpty(this.identifier) ? TIMManager.getInstance() : TIMManager.getInstanceById(this.identifier)).getCoreUser();
    }

    public static TIMImageUploader getInstance() {
        return getInstanceById(TIMManager.getInstance().getIdentifier());
    }

    public static TIMImageUploader getInstanceById(String str) {
        return new TIMImageUploader(str);
    }

    public void cancelTask(int i) {
        getIMCoreUser().cancelTask((long) i);
    }

    public int compressPic(String str, String str2, int i) {
        String str3;
        if (str == null || str2 == null || !(i == 1 || i == 2)) {
            str3 = "invalid params";
        } else if (IMCoreWrapper.get().isIMCoreUserInited()) {
            return getIMCoreUser().compressPic(str, str2, i);
        } else {
            str3 = "sdk not initialized or not logged in.";
        }
        QLog.d(tag, 1, str3);
        return -1;
    }

    /* access modifiers changed from: protected */
    public String getIdentifier() {
        return this.identifier;
    }

    public int getUploadProgress(long j) {
        if (!IMCoreWrapper.get().isIMCoreUserInited()) {
            return -1;
        }
        return getIMCoreUser().getImageUploadProgrss(j);
    }

    public int submitUploadTask(String str, TIMValueCallBack<TIMImageElem> tIMValueCallBack) {
        if (tIMValueCallBack == null) {
            return -1;
        }
        if (IMCoreWrapper.get().isIMCoreUserInited()) {
            return (int) getIMCoreUser().submitUploadTask(str, new aa(tIMValueCallBack));
        }
        tIMValueCallBack.onError(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not initialized or not logged in.");
        return -1;
    }

    public int submitUploadTask(String str, TIMValueCallBack<TIMImageElem> tIMValueCallBack, int i) {
        if (tIMValueCallBack == null) {
            return -1;
        }
        if (IMCoreWrapper.get().isIMCoreUserInited()) {
            return (int) getIMCoreUser().submitUploadTask(str, new aa(tIMValueCallBack), i);
        }
        tIMValueCallBack.onError(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not initialized or not logged in.");
        return -1;
    }
}
