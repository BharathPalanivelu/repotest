package com.shopee.app.ui.chat2.block;

import android.content.Context;
import android.text.TextUtils;
import com.garena.android.appkit.tools.b;
import com.shopee.app.ui.a.o;
import com.shopee.app.ui.dialog.a;
import com.shopee.id.R;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private Context f20306a;

    /* renamed from: b  reason: collision with root package name */
    private a f20307b;

    public interface a extends o {
        void b(String str);

        void c(String str);
    }

    public c(Context context, a aVar) {
        this.f20306a = context;
        this.f20307b = aVar;
    }

    public void a(final int i, String str) {
        com.shopee.app.ui.dialog.a.a(this.f20306a, b.a(R.string.sp_unblock_user_x, str), b.a(R.string.sp_unblock_user_content2, str), b.e(R.string.sp_label_cancel), b.e(R.string.sp_unblock), (a.C0318a) new a.C0318a() {
            public void onNegative() {
            }

            public void onPositive() {
                c.this.a(i);
            }
        });
    }

    public void b(final int i, String str) {
        com.shopee.app.ui.dialog.a.a(this.f20306a, b.a(R.string.sp_block_user_x, str), b.a(R.string.sp_block_user_content2, str), b.e(R.string.sp_label_cancel), b.e(R.string.sp_block), (a.C0318a) new a.C0318a() {
            public void onNegative() {
            }

            public void onPositive() {
                c.this.b(i);
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(int i) {
        this.f20307b.x_();
        new com.shopee.app.network.d.c.a().a(i, false);
    }

    /* access modifiers changed from: private */
    public void b(int i) {
        this.f20307b.x_();
        new com.shopee.app.network.d.c.a().a(i, true);
    }

    public void a(com.shopee.app.network.c.d.a aVar) {
        String str = aVar.f17893b;
        if (TextUtils.isEmpty(str)) {
            if (aVar.f17892a != -100) {
                str = b.e(R.string.sp_unknown_error);
            } else {
                str = b.e(R.string.sp_network_error);
            }
        }
        this.f20307b.d();
        if (aVar.f17892a != 2) {
            this.f20307b.b(str);
        } else {
            this.f20307b.c(str);
        }
    }
}
