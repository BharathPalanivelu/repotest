package com.shopee.app.util;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;
import android.view.View;
import com.a.a.a;

public class bg implements a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final View.OnClickListener f26244a;

    public bg(final Context context, final int i) {
        this.f26244a = new View.OnClickListener() {
            public void onClick(View view) {
                ((com.shopee.app.a.a) ((x) context).b()).a().c(i);
            }
        };
    }

    public SpannedString format(Object obj) {
        CharSequence charSequence = (CharSequence) obj;
        if (TextUtils.isEmpty(charSequence)) {
            return new SpannedString("");
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new bk() {
            public void onClick(View view) {
                bg.this.f26244a.onClick(view);
            }
        }, 0, spannableString.length(), 33);
        return new SpannedString(spannableString);
    }
}
