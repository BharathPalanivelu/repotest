package com.shopee.app.ui.dialog;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.garena.android.appkit.d.a;
import com.garena.android.appkit.tools.b;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.shopee.id.R;

public class f extends RelativeLayout implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    ImageButton f21549a;

    /* renamed from: b  reason: collision with root package name */
    ImageButton f21550b;

    /* renamed from: c  reason: collision with root package name */
    TextView f21551c;

    /* renamed from: d  reason: collision with root package name */
    MaterialEditText f21552d;

    /* renamed from: e  reason: collision with root package name */
    String f21553e;

    /* renamed from: f  reason: collision with root package name */
    String f21554f;

    /* renamed from: g  reason: collision with root package name */
    private int f21555g = 0;
    private int h = Integer.MAX_VALUE;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public f(Context context) {
        super(context);
    }

    public f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public f(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f21551c.setText(b.a(R.string.sp_quantity_stock, Integer.valueOf(R.id.stock)));
        this.f21550b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                f fVar = f.this;
                fVar.a(fVar.f21552d, 1);
            }
        });
        this.f21549a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                f fVar = f.this;
                fVar.a(fVar.f21552d, -1);
            }
        });
        this.f21552d.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    f.this.f21552d.setSelection(f.this.f21552d.getText().length());
                }
            }
        });
        this.f21552d.addTextChangedListener(this);
    }

    /* access modifiers changed from: private */
    public void a(MaterialEditText materialEditText, int i) {
        String obj = materialEditText.getText().toString();
        if (obj.isEmpty()) {
            materialEditText.setText("1");
            return;
        }
        try {
            int parseInt = Integer.parseInt(obj) + i;
            if (parseInt < this.f21555g) {
                materialEditText.setText(String.valueOf(this.f21555g));
                materialEditText.setError(this.f21553e);
            } else if (parseInt > this.h) {
                materialEditText.setText(String.valueOf(this.h));
                materialEditText.setError(this.f21554f);
            } else {
                materialEditText.setText(String.valueOf(parseInt));
            }
        } catch (NumberFormatException unused) {
            materialEditText.setText("1");
        }
    }

    public void a(int i, int i2) {
        this.f21555g = i;
        this.h = i2;
    }

    public void a(String str, String str2, String str3) {
        this.f21551c.setText(str);
        this.f21553e = str2;
        this.f21554f = str3;
    }

    public void setQuantity(int i) {
        this.f21552d.setText(String.valueOf(i));
    }

    public int getQuantity() {
        String obj = this.f21552d.getText().toString();
        if (obj.isEmpty()) {
            return -1;
        }
        int i = 0;
        try {
            i = Integer.parseInt(obj);
        } catch (NumberFormatException e2) {
            a.a(e2);
        }
        int i2 = this.f21555g;
        if (i < i2) {
            this.f21552d.setText(String.valueOf(i2));
            this.f21552d.setError(this.f21553e);
            return -2;
        }
        int i3 = this.h;
        if (i <= i3) {
            return Integer.valueOf(this.f21552d.getText().toString()).intValue();
        }
        this.f21552d.setText(String.valueOf(i3));
        this.f21552d.setError(this.f21554f);
        return -3;
    }

    public void afterTextChanged(Editable editable) {
        a(editable);
    }

    private void a(Editable editable) {
        try {
            int parseInt = Integer.parseInt(editable.toString());
            boolean z = true;
            boolean z2 = parseInt != this.f21555g;
            if (parseInt == this.h) {
                z = false;
            }
            this.f21549a.setEnabled(z2);
            float f2 = 1.0f;
            this.f21549a.setAlpha(z2 ? 1.0f : 0.5f);
            this.f21550b.setEnabled(z);
            ImageButton imageButton = this.f21550b;
            if (!z) {
                f2 = 0.5f;
            }
            imageButton.setAlpha(f2);
        } catch (NumberFormatException e2) {
            a.a(e2);
        }
    }
}
