package com.shopee.app.web.bridge.modules;

import android.app.Activity;
import com.shopee.app.ui.c.a;
import com.shopee.app.ui.webview.g;
import com.shopee.id.R;
import com.shopee.web.sdk.bridge.a.f.b;
import d.a.j;
import java.util.List;

public final class FileDownloaderModule$onBridgeInvoked$$inlined$let$lambda$1 implements b.C0475b {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Object $data$inlined;
    final /* synthetic */ FileDownloaderModule this$0;

    FileDownloaderModule$onBridgeInvoked$$inlined$let$lambda$1(Activity activity, FileDownloaderModule fileDownloaderModule, Object obj) {
        this.$activity = activity;
        this.this$0 = fileDownloaderModule;
        this.$data$inlined = obj;
    }

    public void onResult(List<Boolean> list) {
        if (list != null) {
            if ((j.a(list) >= 0 ? list.get(0) : false).booleanValue()) {
                this.this$0.download();
                return;
            }
        }
        g access$getView = this.this$0.getView();
        if (access$getView != null) {
            access$getView.setDetachable(false);
        }
        a permissionHandler = this.this$0.getPermissionHandler();
        String e2 = com.garena.android.appkit.tools.b.e(R.string.sp_store_file_permission_hint);
        d.d.b.j.a((Object) e2, "BBAppResource.string(R.s…ore_file_permission_hint)");
        permissionHandler.a(e2);
        a permissionHandler2 = this.this$0.getPermissionHandler();
        Activity activity = this.$activity;
        d.d.b.j.a((Object) activity, "activity");
        permissionHandler2.a(activity, (List<String>) j.a("storage"), (b.C0475b) new b.C0475b(this) {
            final /* synthetic */ FileDownloaderModule$onBridgeInvoked$$inlined$let$lambda$1 this$0;

            {
                this.this$0 = r1;
            }

            public void onResult(List<Boolean> list) {
                if (list != null) {
                    if ((j.a(list) >= 0 ? list.get(0) : false).booleanValue()) {
                        this.this$0.this$0.download();
                        return;
                    }
                }
                this.this$0.this$0.onError("No Storage Permission");
            }
        });
    }
}
