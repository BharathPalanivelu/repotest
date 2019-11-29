package com.shopee.app.web;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import com.afollestad.materialdialogs.f;
import com.shopee.app.h.r;
import com.shopee.app.ui.dialog.a;
import com.shopee.id.R;
import d.d.b.j;

final class RenderProcessGoneHandlerClient$doWhenRenderProcessGone$1 implements Runnable {
    final /* synthetic */ Context $context;
    final /* synthetic */ RenderProcessGoneHandlerClient this$0;

    RenderProcessGoneHandlerClient$doWhenRenderProcessGone$1(RenderProcessGoneHandlerClient renderProcessGoneHandlerClient, Context context) {
        this.this$0 = renderProcessGoneHandlerClient;
        this.$context = context;
    }

    public final void run() {
        Context context = this.$context;
        if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
            Dialog a2 = a.a(this.$context, 0, (int) R.string.sp_rn_exception_msg, 0, (int) R.string.sp_label_back_to_home, (f.b) new f.b(this) {
                final /* synthetic */ RenderProcessGoneHandlerClient$doWhenRenderProcessGone$1 this$0;

                {
                    this.this$0 = r1;
                }

                public void onPositive(f fVar) {
                    this.this$0.this$0.jumpToHome((Activity) this.this$0.$context);
                }
            });
            a2.setCancelable(false);
            RenderProcessGoneHandlerClient renderProcessGoneHandlerClient = this.this$0;
            j.a((Object) a2, "dialog");
            renderProcessGoneHandlerClient.subscribeToLifecycleEvents(a2, this.$context);
        } else if (!(this.$context instanceof Activity)) {
            r.a().b((int) R.string.sp_error_404);
        }
    }
}
