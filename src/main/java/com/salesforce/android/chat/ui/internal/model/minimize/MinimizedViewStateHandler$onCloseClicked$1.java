package com.salesforce.android.chat.ui.internal.model.minimize;

import d.d.a.a;
import d.d.b.k;
import d.p;

final class MinimizedViewStateHandler$onCloseClicked$1 extends k implements a<p> {
    final /* synthetic */ MinimizedViewStateHandler this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MinimizedViewStateHandler$onCloseClicked$1(MinimizedViewStateHandler minimizedViewStateHandler) {
        super(0);
        this.this$0 = minimizedViewStateHandler;
    }

    public final void invoke() {
        this.this$0.mChatUIClient.endChatSession();
        this.this$0.teardown();
    }
}
