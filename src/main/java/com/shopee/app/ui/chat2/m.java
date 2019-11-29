package com.shopee.app.ui.chat2;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.shopee.app.ui.common.MaterialTabView;
import com.shopee.app.ui.common.ao;
import com.shopee.app.ui.common.ap;
import com.shopee.id.R;

public class m extends MaterialTabView {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public int[] f20531a = {R.string.sp_label_all_chat, R.string.sp_label_unread_chats};

    public m(Context context) {
        super(context);
        a aVar = new a();
        setTabIndicator(new ap(aVar.b()));
        setAdapter(aVar);
        a();
    }

    private class a extends com.garena.android.uikit.a.a {
        public View a(Context context) {
            return null;
        }

        public int b() {
            return 2;
        }

        private a() {
        }

        public com.garena.android.uikit.a.a.b d(Context context, int i) {
            ao aoVar = new ao(context);
            aoVar.setTitle(m.this.f20531a[i]);
            return aoVar;
        }

        public com.garena.android.uikit.a.a.a e(Context context, int i) {
            if (i != 0) {
                return new b(context, h.a(context, 1));
            }
            return new b(context, h.a(context, 0));
        }
    }

    private class b extends com.garena.android.uikit.a.a.a {
        public b(Context context, View view) {
            super(context);
            addView(view, new LinearLayout.LayoutParams(-1, -1));
        }
    }
}
