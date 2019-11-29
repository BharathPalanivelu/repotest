package com.shopee.app.ui.activity;

import android.content.Context;
import android.view.View;
import com.shopee.app.ui.common.MaterialTabView;
import com.shopee.app.ui.common.ao;
import com.shopee.app.ui.common.ap;
import com.shopee.app.ui.home.a.n;
import com.shopee.id.R;

public class b extends MaterialTabView {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static int[] f19457a = {R.string.sp_label_all_activities, R.string.sp_label_comments};

    public b(Context context) {
        super(context);
        a aVar = new a();
        setTabIndicator(new ap(aVar.b()));
        setAdapter(aVar);
        a();
    }

    private static class a extends com.garena.android.uikit.a.a {
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
            aoVar.setTitle(b.f19457a[i]);
            return aoVar;
        }

        public com.garena.android.uikit.a.a.a e(Context context, int i) {
            if (i != 0) {
                return n.a(context, 4);
            }
            return n.a(context, -1);
        }
    }
}
