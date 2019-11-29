package com.shopee.app.ui.product.add.a;

import android.text.TextWatcher;
import android.view.View;
import android.widget.LinearLayout;
import com.shopee.app.ui.common.TagEditText2;
import com.shopee.app.ui.product.b.d;
import com.shopee.app.util.q.e;
import com.shopee.shopeetracker.bimodel.TrackingType;
import d.d.b.j;

public final class a extends e {

    /* renamed from: a  reason: collision with root package name */
    private final View f23953a;

    /* renamed from: b  reason: collision with root package name */
    private final TagEditText2 f23954b;

    /* renamed from: c  reason: collision with root package name */
    private final d f23955c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(View view, TagEditText2 tagEditText2, LinearLayout linearLayout, d dVar) {
        super(linearLayout);
        j.b(view, "descriptionPanel");
        j.b(tagEditText2, "descriptionInputView");
        j.b(linearLayout, "addProductLayout");
        j.b(dVar, "validatorProvider");
        this.f23953a = view;
        this.f23954b = tagEditText2;
        this.f23955c = dVar;
        this.f23954b.addTextChangedListener(new TextWatcher(this) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f23956a;

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            {
                this.f23956a = r1;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
                if (r2 != null) goto L_0x000d;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void afterTextChanged(android.text.Editable r2) {
                /*
                    r1 = this;
                    com.shopee.app.ui.product.add.a.a r0 = r1.f23956a
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
                throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.product.add.a.a.AnonymousClass1.afterTextChanged(android.text.Editable):void");
            }
        });
    }

    public e.C0408e a() {
        return e.C0408e.DESCRIPTION;
    }

    public View b() {
        return this.f23953a;
    }

    public void c() {
        a(this.f23954b.getText().toString());
    }

    public final void a(String str) {
        j.b(str, TrackingType.INPUT);
        b(com.shopee.app.util.q.a.a(this.f23955c.b(), new e.a(str), false, 2, (Object) null));
    }
}
