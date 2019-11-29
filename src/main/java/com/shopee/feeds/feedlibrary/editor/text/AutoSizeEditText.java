package com.shopee.feeds.feedlibrary.editor.text;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import com.devspark.robototextview.widget.RobotoEditText;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.HashMap;

public class AutoSizeEditText extends RobotoEditText {

    /* renamed from: a  reason: collision with root package name */
    private int f28034a = 28;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public float f28035b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public HashMap<Integer, Integer> f28036c;

    public AutoSizeEditText(Context context) {
        super(context);
        b();
    }

    public AutoSizeEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public AutoSizeEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b();
    }

    private void b() {
        this.f28036c = new HashMap<>();
        for (int i = 8; i <= 28; i++) {
            this.f28036c.put(Integer.valueOf(i), -1);
        }
        this.f28036c.put(28, 0);
        setTextSize(2, (float) this.f28034a);
        addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                if (AutoSizeEditText.this.f28035b <= BitmapDescriptorFactory.HUE_RED) {
                    return;
                }
                if (editable.length() > ((Integer) AutoSizeEditText.this.f28036c.get(Integer.valueOf(AutoSizeEditText.this.getIntTextSize()))).intValue()) {
                    if (((float) (AutoSizeEditText.this.getLineHeight() * AutoSizeEditText.this.getLineCount())) >= AutoSizeEditText.this.f28035b) {
                        AutoSizeEditText.this.a();
                    }
                    AutoSizeEditText.this.f28036c.put(Integer.valueOf(AutoSizeEditText.this.getIntTextSize()), Integer.valueOf(editable.length()));
                } else if (editable.length() < ((Integer) AutoSizeEditText.this.f28036c.get(Integer.valueOf(AutoSizeEditText.this.getIntTextSize()))).intValue()) {
                    int i = 28;
                    if (AutoSizeEditText.this.getIntTextSize() + 1 > 28) {
                        AutoSizeEditText.this.f28036c.put(28, Integer.valueOf(editable.length()));
                        return;
                    }
                    while (i >= AutoSizeEditText.this.getIntTextSize() + 1) {
                        int intValue = ((Integer) AutoSizeEditText.this.f28036c.get(Integer.valueOf(i))).intValue();
                        if (intValue <= 0 || intValue < editable.length()) {
                            i--;
                        } else {
                            AutoSizeEditText.this.a(i);
                            AutoSizeEditText.this.f28036c.put(Integer.valueOf(AutoSizeEditText.this.getIntTextSize()), Integer.valueOf(editable.length()));
                            return;
                        }
                    }
                }
            }
        });
    }

    public void setMaxHeight(float f2) {
        this.f28035b = f2;
    }

    public void a() {
        this.f28034a = Math.max(8, this.f28034a - 1);
        setTextSize(2, (float) this.f28034a);
    }

    public void a(int i) {
        this.f28034a = Math.min(28, Math.max(8, i));
        setTextSize(2, (float) this.f28034a);
    }

    public int getIntTextSize() {
        return this.f28034a;
    }

    public HashMap<Integer, Integer> getCharCountOfSize() {
        return this.f28036c;
    }

    public void setCharCountOfSize(HashMap<Integer, Integer> hashMap) {
        if (hashMap != null) {
            this.f28036c = hashMap;
        }
    }
}
