package com.shopee.app.web.bridge.modules;

import android.content.Context;
import android.net.Uri;
import com.facebook.common.util.UriUtil;
import com.facebook.share.internal.ShareConstants;
import com.google.a.o;
import com.shopee.app.h.l;
import com.shopee.app.react.protocol.BridgeResult;
import com.shopee.app.web.bridge.WebBridgeModule;
import com.shopee.app.web.bridge.WebPromise;
import com.shopee.app.web.protocol.SaveMediaToDeviceAlbumMessage;
import d.d.b.j;
import java.io.File;

public class SaveMediaToDeviceAlbumModule extends WebBridgeModule {
    /* access modifiers changed from: protected */
    public String getBridgeName() {
        return "saveMediaToDeviceAlbum";
    }

    /* access modifiers changed from: protected */
    public void onInit() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SaveMediaToDeviceAlbumModule(Context context) {
        super(context);
        j.b(context, "context");
    }

    /* access modifiers changed from: protected */
    public void onBridgeInvoked(Object obj) {
        if (obj instanceof SaveMediaToDeviceAlbumMessage) {
            SaveMediaToDeviceAlbumMessage saveMediaToDeviceAlbumMessage = (SaveMediaToDeviceAlbumMessage) obj;
            File file = new File(saveMediaToDeviceAlbumMessage.getUrl());
            if (!file.isFile()) {
                onError("Invalid or non-existent file: " + saveMediaToDeviceAlbumMessage.getUrl() + ", or no Storage permission");
                return;
            }
            saveMedia(file);
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public void saveMedia(File file) {
        j.b(file, UriUtil.LOCAL_FILE_SCHEME);
        Uri a2 = l.a().a(file);
        if (a2 != null) {
            onSuccess(a2);
        } else {
            onError("Error saving file to device album");
        }
    }

    public void onSuccess(Uri uri) {
        j.b(uri, ShareConstants.MEDIA_URI);
        o oVar = new o();
        oVar.a("error", (Number) 0);
        oVar.a("errorMessage", "");
        oVar.a("mediaLocalUri", uri.toString());
        WebPromise promise = getPromise();
        if (promise != null) {
            promise.resolve(oVar);
        }
    }

    public static /* synthetic */ void onError$default(SaveMediaToDeviceAlbumModule saveMediaToDeviceAlbumModule, String str, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = "";
            }
            saveMediaToDeviceAlbumModule.onError(str);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onError");
    }

    public void onError(String str) {
        WebPromise promise = getPromise();
        if (promise != null) {
            promise.resolve(BridgeResult.Companion.fail(1, str).toJson());
        }
    }
}
