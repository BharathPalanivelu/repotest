package com.shopee.app.ui.setting.CustomerService;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.a.a.f;
import com.devspark.robototextview.widget.RobotoTextView;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.ui.setting.m;
import com.shopee.app.util.ak;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class b extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    ak f25001a;

    /* renamed from: b  reason: collision with root package name */
    RobotoTextView f25002b;

    /* renamed from: c  reason: collision with root package name */
    RobotoTextView f25003c;

    /* renamed from: d  reason: collision with root package name */
    int f25004d;

    /* renamed from: e  reason: collision with root package name */
    int f25005e;

    /* renamed from: f  reason: collision with root package name */
    UserInfo f25006f;

    public b(Context context) {
        super(context);
        setOrientation(1);
        ((m) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f25002b.setText("021 - 29119100");
        f a2 = f.a(getContext());
        a2.a("cs.id@shopeemobile.com").b();
        a2.a("\n").b();
        a2.a().a((Object) com.garena.android.appkit.tools.b.e(R.string.sp_feedback_with_email)).a().a(this.f25005e).b(this.f25004d).c().b();
        a2.a((TextView) this.f25003c);
    }

    /* access modifiers changed from: package-private */
    public void a(View view) {
        int id = view.getId();
        if (id == R.id.customer_email) {
            b();
        } else if (id == R.id.customer_phone) {
            this.f25001a.m("021 - 29119100");
        }
    }

    private void b() {
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.fromParts("mailto", "cs.id@shopeemobile.com", (String) null));
        intent.putExtra("android.intent.extra.SUBJECT", "[" + this.f25006f.getUsername() + "] ");
        getContext().startActivity(Intent.createChooser(intent, "Send email..."));
    }
}
