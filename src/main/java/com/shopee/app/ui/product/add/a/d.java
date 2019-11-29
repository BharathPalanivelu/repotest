package com.shopee.app.ui.product.add.a;

import android.text.Html;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.garena.android.appkit.tools.b;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.shopee.app.ui.product.b.a.h;
import com.shopee.app.util.l;
import com.shopee.app.util.q.a;
import com.shopee.app.util.q.d;
import com.shopee.app.util.q.e;
import com.shopee.app.util.q.g;
import com.shopee.id.R;
import com.shopee.shopeetracker.bimodel.TrackingType;
import d.d.b.j;
import d.m;

public final class d extends e {

    /* renamed from: a  reason: collision with root package name */
    private final EditText f23967a;

    /* renamed from: b  reason: collision with root package name */
    private final TextView f23968b;

    /* renamed from: c  reason: collision with root package name */
    private final LinearLayout f23969c;

    /* renamed from: d  reason: collision with root package name */
    private final com.shopee.app.ui.product.b.d f23970d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(EditText editText, TextView textView, LinearLayout linearLayout, LinearLayout linearLayout2, com.shopee.app.ui.product.b.d dVar) {
        super(linearLayout2);
        j.b(editText, "titleInputText");
        j.b(textView, "productTitleLenCountText");
        j.b(linearLayout, "titleSection");
        j.b(linearLayout2, "addProductLayout");
        j.b(dVar, "validatorProvider");
        this.f23967a = editText;
        this.f23968b = textView;
        this.f23969c = linearLayout;
        this.f23970d = dVar;
        this.f23967a.addTextChangedListener(new TextWatcher(this) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ d f23971a;

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            {
                this.f23971a = r1;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
                if (r2 != null) goto L_0x000d;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void afterTextChanged(android.text.Editable r2) {
                /*
                    r1 = this;
                    com.shopee.app.ui.product.add.a.d r0 = r1.f23971a
                    if (r2 == 0) goto L_0x000b
                    java.lang.String r2 = r2.toString()
                    if (r2 == 0) goto L_0x000b
                    goto L_0x000d
                L_0x000b:
                    java.lang.String r2 = ""
                L_0x000d:
                    r0.a(r2)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.product.add.a.d.AnonymousClass1.afterTextChanged(android.text.Editable):void");
            }
        });
    }

    /* renamed from: a */
    public LinearLayout b() {
        return this.f23969c;
    }

    public e.C0408e d() {
        return e.C0408e.TITLE;
    }

    public void c() {
        a(this.f23967a.getText().toString());
    }

    public final void a(String str) {
        j.b(str, TrackingType.INPUT);
        com.shopee.app.util.q.d a2 = a.a(this.f23970d.b(), new e.d(str), false, 2, (Object) null);
        b(a2);
        a(a2, str.length());
    }

    private final void a(com.shopee.app.util.q.d dVar, int i) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            if (dVar instanceof d.c) {
                stringBuffer.append("<font color=" + l.w + SimpleComparison.GREATER_THAN_OPERATION);
                stringBuffer.append(i);
                stringBuffer.append("</font>");
            } else {
                stringBuffer.append(i);
            }
            g a2 = this.f23970d.b().a(d());
            if (a2 != null) {
                this.f23968b.setText(Html.fromHtml(b.a(R.string.sp_x_out_of_y, stringBuffer.toString(), Integer.valueOf(((h) a2).b()))));
                return;
            }
            throw new m("null cannot be cast to non-null type com.shopee.app.ui.product.validator.config.TitleValidatorConfig");
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }
}
