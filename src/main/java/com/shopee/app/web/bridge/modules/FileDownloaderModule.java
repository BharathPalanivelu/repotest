package com.shopee.app.web.bridge.modules;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.webkit.CookieManager;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.shopee.app.react.protocol.BridgeResult;
import com.shopee.app.ui.c.a;
import com.shopee.app.web.bridge.WebBridgeModule;
import com.shopee.app.web.bridge.WebPromise;
import com.shopee.app.web.protocol.FileDownloadMessage;
import com.shopee.web.sdk.bridge.a.f.b;
import d.d.a.c;
import d.d.b.j;
import d.m;
import d.p;
import java.util.List;

public final class FileDownloaderModule extends WebBridgeModule {
    private FileDownloadMessage fileDownloadMessage;
    public a permissionHandler;

    /* access modifiers changed from: protected */
    public String getBridgeName() {
        return "downloadFile";
    }

    /* access modifiers changed from: protected */
    public void onInit() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileDownloaderModule(Context context) {
        super(context);
        j.b(context, "context");
        getComponent().inject(this);
    }

    public final a getPermissionHandler() {
        a aVar = this.permissionHandler;
        if (aVar == null) {
            j.b("permissionHandler");
        }
        return aVar;
    }

    public final void setPermissionHandler(a aVar) {
        j.b(aVar, "<set-?>");
        this.permissionHandler = aVar;
    }

    public void onRequestPermissionsResult(Activity activity, int i, String[] strArr, int[] iArr) {
        j.b(activity, "activity");
        j.b(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        j.b(iArr, "grantResults");
        a aVar = this.permissionHandler;
        if (aVar == null) {
            j.b("permissionHandler");
        }
        aVar.a(activity, i, iArr);
    }

    /* access modifiers changed from: protected */
    public void onBridgeInvoked(Object obj) {
        Activity activity = getActivity();
        if (activity != null) {
            if (obj != null) {
                try {
                    if ((obj instanceof FileDownloadMessage) && ((FileDownloadMessage) obj).getUrl() != null) {
                        this.fileDownloadMessage = (FileDownloadMessage) obj;
                        a aVar = this.permissionHandler;
                        if (aVar == null) {
                            j.b("permissionHandler");
                        }
                        j.a((Object) activity, "activity");
                        aVar.a((Context) activity, (List<String>) d.a.j.a("storage"), (b.C0475b) new FileDownloaderModule$onBridgeInvoked$$inlined$let$lambda$1(activity, this, obj));
                        return;
                    }
                } catch (Exception e2) {
                    onError(e2.getMessage());
                    return;
                }
            }
            throw new IllegalArgumentException("Url is required");
        }
    }

    /* access modifiers changed from: private */
    public final void download() {
        FileDownloadMessage fileDownloadMessage2 = this.fileDownloadMessage;
        Context context = getContext();
        if (!(fileDownloadMessage2 == null || context == null)) {
            try {
                Uri parse = Uri.parse(fileDownloadMessage2.getUrl());
                String fileName = fileDownloadMessage2.getFileName();
                if (fileName == null) {
                    j.a((Object) parse, ShareConstants.MEDIA_URI);
                    fileName = parse.getLastPathSegment();
                }
                String title = fileDownloadMessage2.getTitle();
                if (title == null) {
                    title = fileName;
                }
                DownloadManager.Request destinationInExternalPublicDir = new DownloadManager.Request(parse).setTitle(title).addRequestHeader("Cookie", CookieManager.getInstance().getCookie(fileDownloadMessage2.getUrl())).setDescription(fileDownloadMessage2.getDescription()).setNotificationVisibility(1).setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, fileName);
                Object systemService = context.getSystemService("download");
                if (systemService != null) {
                    ((DownloadManager) systemService).enqueue(destinationInExternalPublicDir);
                    onSuccess();
                } else {
                    throw new m("null cannot be cast to non-null type android.app.DownloadManager");
                }
            } catch (Exception e2) {
                com.garena.android.appkit.d.a.a(e2);
                onError(e2.getMessage());
            }
        }
        onError$default(this, (String) null, 1, (Object) null);
    }

    private final void onSuccess() {
        this.fileDownloadMessage = null;
        WebPromise promise = getPromise();
        if (promise != null) {
            promise.resolve(BridgeResult.Companion.success().toJson());
        }
    }

    static /* synthetic */ void onError$default(FileDownloaderModule fileDownloaderModule, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        fileDownloaderModule.onError(str);
    }

    /* access modifiers changed from: private */
    public final void onError(String str) {
        this.fileDownloadMessage = null;
        WebPromise promise = getPromise();
        if (promise != null) {
            promise.reject(BridgeResult.Companion.fail(1, str).toJson());
        }
    }

    private final <A, B> void ifNotNull(A a2, B b2, c<? super A, ? super B, p> cVar) {
        if (a2 != null && b2 != null) {
            cVar.a(a2, b2);
        }
    }
}
