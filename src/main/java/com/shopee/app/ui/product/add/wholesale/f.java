package com.shopee.app.ui.product.add.wholesale;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.shopee.app.a;
import com.shopee.id.R;
import d.d.b.j;
import java.util.HashMap;

public final class f extends LinearLayout {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public WholesaleTierModel f24198a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public k f24199b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f24200c;

    public f(Context context) {
        this(context, (AttributeSet) null, 0, 6, (g) null);
    }

    public View a(int i) {
        if (this.f24200c == null) {
            this.f24200c = new HashMap();
        }
        View view = (View) this.f24200c.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f24200c.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f(Context context, AttributeSet attributeSet, int i, int i2, g gVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        j.b(context, "context");
        View.inflate(context, R.layout.wholesale_item_view, this);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setOrientation(0);
        setPadding(0, (int) getResources().getDimension(R.dimen.spacing_small), 0, (int) getResources().getDimension(R.dimen.spacing_small));
        a();
    }

    private final void a() {
        com.shopee.app.g.d.a((EditText) a(a.C0250a.priceView));
        ((EditText) a(a.C0250a.minView)).addTextChangedListener(new a(this));
        ((EditText) a(a.C0250a.maxView)).addTextChangedListener(new b(this));
        ((EditText) a(a.C0250a.priceView)).addTextChangedListener(new c(this));
        ((EditText) a(a.C0250a.maxView)).setOnFocusChangeListener(new d(this));
        EditText editText = (EditText) a(a.C0250a.minView);
        j.a((Object) editText, "minView");
        editText.setOnFocusChangeListener(b.a());
    }

    public static final class a implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f24201a;

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        a(f fVar) {
            this.f24201a = fVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
            if (r2 != null) goto L_0x0013;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void afterTextChanged(android.text.Editable r2) {
            /*
                r1 = this;
                com.shopee.app.ui.product.add.wholesale.f r0 = r1.f24201a
                com.shopee.app.ui.product.add.wholesale.WholesaleTierModel r0 = r0.f24198a
                if (r0 == 0) goto L_0x0015
                if (r2 == 0) goto L_0x0011
                java.lang.String r2 = r2.toString()
                if (r2 == 0) goto L_0x0011
                goto L_0x0013
            L_0x0011:
                java.lang.String r2 = ""
            L_0x0013:
                r0.f24170a = r2
            L_0x0015:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.product.add.wholesale.f.a.afterTextChanged(android.text.Editable):void");
        }
    }

    public static final class b implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f24202a;

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        b(f fVar) {
            this.f24202a = fVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
            if (r2 != null) goto L_0x0013;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void afterTextChanged(android.text.Editable r2) {
            /*
                r1 = this;
                com.shopee.app.ui.product.add.wholesale.f r0 = r1.f24202a
                com.shopee.app.ui.product.add.wholesale.WholesaleTierModel r0 = r0.f24198a
                if (r0 == 0) goto L_0x0015
                if (r2 == 0) goto L_0x0011
                java.lang.String r2 = r2.toString()
                if (r2 == 0) goto L_0x0011
                goto L_0x0013
            L_0x0011:
                java.lang.String r2 = ""
            L_0x0013:
                r0.f24171b = r2
            L_0x0015:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.product.add.wholesale.f.b.afterTextChanged(android.text.Editable):void");
        }
    }

    public static final class c implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f24203a;

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        c(f fVar) {
            this.f24203a = fVar;
        }

        public void afterTextChanged(Editable editable) {
            WholesaleTierModel a2 = this.f24203a.f24198a;
            if (a2 != null) {
                a2.f24172c = editable != null ? editable.toString() : null;
            }
        }
    }

    static final class d implements View.OnFocusChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f24204a;

        d(f fVar) {
            this.f24204a = fVar;
        }

        public final void onFocusChange(View view, boolean z) {
            k b2 = this.f24204a.f24199b;
            if (b2 != null) {
                b2.a(this.f24204a.f24198a, view, z);
            }
        }
    }

    public final void setPresenter(k kVar) {
        j.b(kVar, "presenter");
        this.f24199b = kVar;
    }

    public final void a(WholesaleTierModel wholesaleTierModel) {
        j.b(wholesaleTierModel, "_data");
        this.f24198a = wholesaleTierModel;
        EditText editText = (EditText) a(a.C0250a.minView);
        editText.setEnabled(wholesaleTierModel.b());
        editText.setText(wholesaleTierModel.f24170a);
        EditText editText2 = (EditText) a(a.C0250a.maxView);
        editText2.setEnabled(wholesaleTierModel.a());
        editText2.setText(wholesaleTierModel.f24171b);
        EditText editText3 = (EditText) a(a.C0250a.priceView);
        editText3.setEnabled(wholesaleTierModel.a());
        editText3.setHint(String.valueOf(wholesaleTierModel.f24173d));
        editText3.setText(wholesaleTierModel.f24172c);
        ((ImageView) a(a.C0250a.deleteIcon)).setOnClickListener(new e(this));
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f24205a;

        e(f fVar) {
            this.f24205a = fVar;
        }

        public final void onClick(View view) {
            k b2 = this.f24205a.f24199b;
            if (b2 != null) {
                b2.a(this.f24205a.f24198a, (View) this.f24205a);
            }
        }
    }

    public final EditText getMinView() {
        EditText editText = (EditText) a(a.C0250a.minView);
        j.a((Object) editText, "minView");
        return editText;
    }
}
