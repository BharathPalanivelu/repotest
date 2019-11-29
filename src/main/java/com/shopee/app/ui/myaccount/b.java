package com.shopee.app.ui.myaccount;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.util.o;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class b extends com.shopee.app.ui.a.b implements x<d> {

    /* renamed from: a  reason: collision with root package name */
    String f23364a;

    /* renamed from: b  reason: collision with root package name */
    private d f23365b;

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        View inflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.verify_email_view, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.content)).setText(com.garena.android.appkit.tools.b.a(R.string.sp_email_hint, o.a(this.f23364a)));
        inflate.findViewById(R.id.btm_button).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                b.this.setResult(-1);
                b.this.finish();
            }
        });
        a(inflate);
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1).b((int) R.string.sp_verify_email_title).e(0);
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f23365b = a.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f23365b.a(this);
    }

    /* renamed from: c */
    public d b() {
        return this.f23365b;
    }
}
