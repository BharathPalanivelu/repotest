package com.shopee.feeds.feedlibrary.view.edittext;

import android.content.Context;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.EditText;

public class a extends EditText {

    /* renamed from: a  reason: collision with root package name */
    int f28594a = -1;

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(attributeSet);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet);
    }

    public a(Context context) {
        super(context);
        a((AttributeSet) null);
    }

    private void a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            try {
                this.f28594a = attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLength", -1);
            } catch (Exception unused) {
                return;
            }
        }
        InputFilter inputFilter = getInputFilter();
        if (this.f28594a > 0) {
            setFilters(new InputFilter[]{inputFilter, new InputFilter.LengthFilter(this.f28594a)});
            return;
        }
        setFilters(new InputFilter[]{inputFilter});
    }

    public InputFilter getInputFilter() {
        return new InputFilter() {
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                StringBuffer stringBuffer = new StringBuffer();
                for (int i5 = i; i5 < i2; i5++) {
                    char charAt = charSequence.charAt(i5);
                    com.garena.android.appkit.d.a.e("char", charAt + "");
                    stringBuffer.append(charAt);
                }
                if (!(charSequence instanceof Spanned)) {
                    return stringBuffer;
                }
                SpannableString spannableString = new SpannableString(stringBuffer);
                TextUtils.copySpansFrom((Spanned) charSequence, i, i2, (Class) null, spannableString, 0);
                return spannableString;
            }
        };
    }
}
