package com.bca.xco.widget.comp;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.TextView;
import com.bca.xco.widget.a.c;
import com.bca.xco.widget.h;

public class b extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private LayoutInflater f4716a;

    /* renamed from: b  reason: collision with root package name */
    private Context f4717b;

    /* renamed from: c  reason: collision with root package name */
    private com.bca.xco.widget.e.b f4718c;

    public b(Context context) {
        super(context);
        this.f4716a = LayoutInflater.from(context);
        a(context);
    }

    public void a(c cVar) {
        ((TextView) findViewById(h.d.xco_phone_number)).setText(cVar.b());
    }

    private void a(Context context) {
        this.f4718c = new com.bca.xco.widget.e.b();
        this.f4717b = context;
        requestWindowFeature(1);
        setContentView(h.e.xco_dialog_requestotp);
    }
}
