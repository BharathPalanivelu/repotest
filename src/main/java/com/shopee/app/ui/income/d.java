package com.shopee.app.ui.income;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.ui.common.MaterialTabView;
import com.shopee.app.ui.common.ao;
import com.shopee.app.ui.common.ap;
import com.shopee.app.ui.income.b.e;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class d extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    MaterialTabView f23170a;

    /* renamed from: b  reason: collision with root package name */
    UserInfo f23171b;

    /* renamed from: c  reason: collision with root package name */
    private final int f23172c;

    public interface b {
        void a(d dVar);
    }

    public d(Context context, int i) {
        super(context);
        this.f23172c = i;
        ((b) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        a aVar = new a(this.f23171b.isWalletFeatureOn(), this.f23172c);
        this.f23170a.setAdapter(aVar);
        if (aVar.b() <= 1) {
            this.f23170a.setShadowOffset(0);
        } else {
            this.f23170a.setTabIndicator(new ap(aVar.b()));
        }
        this.f23170a.a();
    }

    private static class a extends com.garena.android.uikit.a.a {

        /* renamed from: e  reason: collision with root package name */
        private static final String[] f23173e = {com.garena.android.appkit.tools.b.e(R.string.sp_label_escrow_income), com.garena.android.appkit.tools.b.e(R.string.sp_label_offline_income)};

        /* renamed from: f  reason: collision with root package name */
        private static final String[] f23174f = {com.garena.android.appkit.tools.b.e(R.string.sp_label_wallet_ongoing_orders), com.garena.android.appkit.tools.b.e(R.string.sp_label_wallet_completed_orders)};

        /* renamed from: c  reason: collision with root package name */
        private final int f23175c = 0;

        /* renamed from: d  reason: collision with root package name */
        private final int f23176d = 1;

        /* renamed from: g  reason: collision with root package name */
        private final boolean f23177g;
        private final int h;

        public View a(Context context) {
            return null;
        }

        public a(boolean z, int i) {
            this.f23177g = z;
            this.h = i;
        }

        public int b() {
            return this.h != 1 ? 2 : 1;
        }

        public com.garena.android.uikit.a.a.b d(Context context, int i) {
            ao aoVar = new ao(context);
            aoVar.setTitle(this.f23177g ? f23174f[i] : f23173e[i]);
            if (b() <= 1) {
                aoVar.setVisibility(8);
            }
            return aoVar;
        }

        public com.garena.android.uikit.a.a.a e(Context context, int i) {
            if (this.h != 0) {
                return e.a(context, 2);
            }
            if (i == 0) {
                return e.a(context, 2);
            }
            if (i != 1) {
                return new com.shopee.app.ui.e.a(context);
            }
            return e.a(context, this.f23177g ^ true ? 1 : 0);
        }
    }
}
