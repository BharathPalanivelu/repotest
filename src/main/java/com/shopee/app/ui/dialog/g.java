package com.shopee.app.ui.dialog;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.shopee.id.R;

public class g extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    ImageView f21559a;

    /* renamed from: b  reason: collision with root package name */
    ImageView f21560b;

    /* renamed from: c  reason: collision with root package name */
    TextView f21561c;

    /* renamed from: d  reason: collision with root package name */
    MaterialEditText f21562d;

    /* renamed from: e  reason: collision with root package name */
    View f21563e;

    /* renamed from: f  reason: collision with root package name */
    String f21564f;

    /* renamed from: g  reason: collision with root package name */
    String f21565g;
    /* access modifiers changed from: private */
    public int h;
    private b i;
    private int j = com.garena.android.appkit.tools.b.a(R.color.primary);

    public interface b {
        void b(int i);
    }

    public g(Context context) {
        super(context);
    }

    public g(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public g(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void setOnQuantityChanged(b bVar) {
        this.i = bVar;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f21561c.setText(com.garena.android.appkit.tools.b.a(R.string.sp_quantity_stock, Integer.valueOf(this.h)));
        this.f21560b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String obj = g.this.f21562d.getText().toString();
                if (obj.isEmpty()) {
                    g.this.f21562d.setText("1");
                    return;
                }
                try {
                    int parseInt = Integer.parseInt(obj) + 1;
                    if (parseInt > g.this.h) {
                        g.this.f21562d.setText(String.valueOf(g.this.h));
                        g.this.f21562d.setError(g.this.f21565g);
                    } else {
                        g.this.f21562d.setText(String.valueOf(parseInt));
                    }
                    g.this.a(parseInt);
                } catch (NumberFormatException unused) {
                    g.this.f21562d.setText("1");
                }
            }
        });
        this.f21559a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String obj = g.this.f21562d.getText().toString();
                if (obj.isEmpty()) {
                    g.this.f21562d.setText("1");
                    return;
                }
                try {
                    int parseInt = Integer.parseInt(obj);
                    if (parseInt == 0) {
                        g.this.f21562d.setText(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                        g.this.f21562d.setError(g.this.f21564f);
                    }
                    int i = parseInt - 1;
                    if (i <= 0) {
                        g.this.f21562d.setText(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                        g.this.f21562d.setError(g.this.f21564f);
                    } else if (parseInt > g.this.h) {
                        g.this.f21562d.setText(String.valueOf(g.this.h));
                    } else {
                        g.this.f21562d.setText(String.valueOf(i));
                    }
                    g.this.a(i);
                } catch (NumberFormatException unused) {
                    g.this.f21562d.setText("1");
                }
            }
        });
        this.f21562d.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    g.this.f21562d.setSelection(g.this.f21562d.getText().length());
                }
            }
        });
        this.f21562d.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                try {
                    g.this.a(Integer.parseInt(editable.toString()));
                } catch (NumberFormatException unused) {
                }
            }
        });
        this.f21562d.setInputType(2);
    }

    /* access modifiers changed from: private */
    public void a(int i2) {
        b bVar = this.i;
        if (bVar != null) {
            bVar.b(i2);
        }
        boolean z = false;
        boolean z2 = i2 < this.h;
        this.f21560b.setClickable(z2);
        Drawable g2 = androidx.core.graphics.drawable.a.g(this.f21560b.getDrawable());
        Drawable g3 = androidx.core.graphics.drawable.a.g(this.f21559a.getDrawable());
        if (z2) {
            androidx.core.graphics.drawable.a.a(g2, this.j);
        } else {
            androidx.core.graphics.drawable.a.a(g2, com.garena.android.appkit.tools.b.a(R.color.black26));
        }
        if (i2 > 1) {
            z = true;
        }
        this.f21559a.setClickable(z);
        if (z) {
            androidx.core.graphics.drawable.a.a(g3, this.j);
        } else {
            androidx.core.graphics.drawable.a.a(g3, com.garena.android.appkit.tools.b.a(R.color.black26));
        }
    }

    public void a(int i2, int i3) {
        this.h = i2;
        if (i3 != 1) {
            this.f21561c.setText(com.garena.android.appkit.tools.b.a(R.string.sp_quantity_stock, Integer.valueOf(i2)));
        } else {
            this.f21561c.setText(com.garena.android.appkit.tools.b.e(R.string.sp_label_quantity));
        }
        this.f21562d.setFilters(new InputFilter[]{new a(1, i2)});
    }

    public void setQuantity(int i2) {
        if (i2 <= 0 || i2 > this.h) {
            i2 = 1;
        }
        this.f21562d.setText(String.valueOf(i2));
    }

    public int getQuantity() {
        String obj = this.f21562d.getText().toString();
        if (obj.isEmpty()) {
            return -1;
        }
        int i2 = 0;
        try {
            i2 = Integer.parseInt(obj);
        } catch (NumberFormatException e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
        if (i2 <= 0) {
            this.f21562d.setText(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            this.f21562d.setError(this.f21564f);
            return -2;
        }
        int i3 = this.h;
        if (i2 <= i3) {
            return Integer.parseInt(this.f21562d.getText().toString());
        }
        this.f21562d.setText(String.valueOf(i3));
        this.f21562d.setError(this.f21565g);
        return -3;
    }

    public void b() {
        this.f21563e.setVisibility(8);
    }

    public void c() {
        this.f21563e.setVisibility(0);
    }

    public void setEditable(boolean z) {
        this.f21562d.setEnabled(z);
        this.f21560b.setClickable(z);
        this.f21559a.setClickable(z);
        Drawable g2 = androidx.core.graphics.drawable.a.g(this.f21560b.getDrawable());
        Drawable g3 = androidx.core.graphics.drawable.a.g(this.f21559a.getDrawable());
        if (z) {
            androidx.core.graphics.drawable.a.a(g2, this.j);
            androidx.core.graphics.drawable.a.a(g3, this.j);
            return;
        }
        androidx.core.graphics.drawable.a.a(g2, com.garena.android.appkit.tools.b.a(R.color.black26));
        androidx.core.graphics.drawable.a.a(g3, com.garena.android.appkit.tools.b.a(R.color.black26));
    }

    public void setQuantityEditTextColor(int i2) {
        this.f21562d.setTextColor(i2);
    }

    public void setThemeColor(int i2) {
        this.j = i2;
    }

    static class a implements InputFilter {

        /* renamed from: a  reason: collision with root package name */
        private int f21570a;

        /* renamed from: b  reason: collision with root package name */
        private int f21571b;

        /* JADX WARNING: Removed duplicated region for block: B:6:0x000e A[ORIG_RETURN, RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean a(int r3, int r4, int r5) {
            /*
                r2 = this;
                r0 = 1
                r1 = 0
                if (r4 <= r3) goto L_0x0009
                if (r5 < r3) goto L_0x000e
                if (r5 > r4) goto L_0x000e
                goto L_0x000f
            L_0x0009:
                if (r5 < r4) goto L_0x000e
                if (r5 > r3) goto L_0x000e
                goto L_0x000f
            L_0x000e:
                r0 = 0
            L_0x000f:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.dialog.g.a.a(int, int, int):boolean");
        }

        public a(int i, int i2) {
            this.f21570a = i;
            this.f21571b = i2;
        }

        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            try {
                if (a(this.f21570a, this.f21571b, Integer.parseInt(spanned.toString() + charSequence.toString()))) {
                    return null;
                }
                return "";
            } catch (NumberFormatException unused) {
                return "";
            }
        }
    }
}
