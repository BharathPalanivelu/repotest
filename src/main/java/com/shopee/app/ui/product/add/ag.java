package com.shopee.app.ui.product.add;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.garena.android.appkit.tools.b;
import com.shopee.app.data.store.RegionConfig;
import com.shopee.app.data.viewmodel.ModelDetail;
import com.shopee.app.g.d;
import com.shopee.app.util.bi;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class ag extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    EditText f23990a;

    /* renamed from: b  reason: collision with root package name */
    EditText f23991b;

    /* renamed from: c  reason: collision with root package name */
    EditText f23992c;

    /* renamed from: d  reason: collision with root package name */
    TextView f23993d;

    /* renamed from: e  reason: collision with root package name */
    TextView f23994e;

    /* renamed from: f  reason: collision with root package name */
    View f23995f;

    /* renamed from: g  reason: collision with root package name */
    TextView f23996g;
    int h;
    bi i;
    RegionConfig j;

    public interface a {
        void a(ag agVar);
    }

    public ag(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        ((a) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        d.a(this.f23990a);
        d.a(getContext(), this.f23991b);
        View view = new View(getContext());
        view.setBackgroundColor(b.a(R.color.black06));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.h);
        layoutParams.addRule(12);
        addView(view, layoutParams);
        this.f23992c.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                if (TextUtils.isEmpty(editable.toString().trim())) {
                    ag.this.f23992c.removeTextChangedListener(this);
                    ag.this.f23992c.setText("");
                    ag.this.f23992c.addTextChangedListener(this);
                }
            }
        });
        if (this.j.isFullBuild()) {
            this.f23995f.setVisibility(0);
        } else {
            this.f23995f.setVisibility(8);
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.i.a("DELETE_MODEL", new com.garena.android.appkit.b.a(this));
    }

    public String getModelName() {
        return this.f23992c.getText().toString();
    }

    public String getModelPrice() {
        return this.f23990a.getText().toString();
    }

    public String getModelStock() {
        return this.f23991b.getText().toString();
    }

    public void setPriceColor(boolean z) {
        if (z) {
            this.f23993d.setTextColor(b.a(R.color.primary));
        } else {
            this.f23993d.setTextColor(b.a(R.color.black87));
        }
    }

    public void setStockColor(boolean z) {
        if (z) {
            this.f23994e.setTextColor(b.a(R.color.primary));
        } else {
            this.f23994e.setTextColor(b.a(R.color.black87));
        }
    }

    public void setNameColor(boolean z) {
        if (z) {
            this.f23996g.setTextColor(b.a(R.color.primary));
        } else {
            this.f23996g.setTextColor(b.a(R.color.black87));
        }
    }

    public void a(ModelDetail modelDetail, boolean z) {
        this.f23992c.setText(modelDetail.getName());
        this.f23990a.setText(modelDetail.getDisplayPrice());
        if (z) {
            this.f23991b.addTextChangedListener(new TextWatcher() {
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void afterTextChanged(Editable editable) {
                    if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(editable.toString())) {
                        ag.this.f23991b.setTextColor(b.a(R.color.primary));
                    } else {
                        ag.this.f23991b.setTextColor(b.a(R.color.black87));
                    }
                }
            });
        }
        this.f23991b.setText(modelDetail.getDisplayStock());
    }

    public void a(TextWatcher textWatcher) {
        this.f23990a.addTextChangedListener(textWatcher);
    }
}
