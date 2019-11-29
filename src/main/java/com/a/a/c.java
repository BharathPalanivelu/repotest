package com.a.a;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.View;
import com.litesuits.orm.db.assit.SQLBuilder;

public class c implements b {

    /* renamed from: a  reason: collision with root package name */
    private final f f3097a;

    /* renamed from: b  reason: collision with root package name */
    private final View.OnClickListener f3098b;

    /* renamed from: c  reason: collision with root package name */
    private final int f3099c;

    /* renamed from: d  reason: collision with root package name */
    private final int f3100d;

    /* renamed from: e  reason: collision with root package name */
    private final int f3101e;

    public c(a aVar) {
        this.f3097a = aVar.f3102a;
        this.f3098b = aVar.f3104c;
        this.f3099c = aVar.f3105d;
        this.f3100d = aVar.f3106e;
        this.f3101e = aVar.f3107f;
    }

    public SpannableString a() {
        SpannableString spannableString = new SpannableString(SQLBuilder.BLANK);
        int length = spannableString.length();
        int i = this.f3099c;
        if (i != -1) {
            Drawable d2 = this.f3097a.d(i);
            int i2 = this.f3101e;
            if (i2 != -1) {
                int i3 = this.f3100d;
                if (i3 != -1) {
                    d2.setBounds(0, 0, i3, i2);
                    spannableString.setSpan(new ImageSpan(d2), 0, length, 33);
                }
            }
            if (this.f3101e != -1 || this.f3100d == -1) {
                if (this.f3101e != -1) {
                    d2.setBounds(0, 0, (int) (((float) (d2.getIntrinsicWidth() * this.f3101e)) / (((float) d2.getIntrinsicHeight()) * 1.0f)), this.f3101e);
                } else {
                    d2.setBounds(0, 0, d2.getIntrinsicWidth(), d2.getIntrinsicHeight());
                }
                spannableString.setSpan(new ImageSpan(d2), 0, length, 33);
            } else {
                d2.setBounds(0, 0, this.f3100d, (int) (((float) (d2.getIntrinsicHeight() * this.f3100d)) / (((float) d2.getIntrinsicWidth()) * 1.0f)));
                spannableString.setSpan(new ImageSpan(d2), 0, length, 33);
            }
        }
        return spannableString;
    }

    public f b() {
        return this.f3097a;
    }

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final f f3102a;

        /* renamed from: b  reason: collision with root package name */
        private String f3103b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public View.OnClickListener f3104c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public int f3105d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public int f3106e = -1;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public int f3107f = -1;

        public a(f fVar) {
            this.f3102a = fVar;
        }

        public a a(int i) {
            this.f3105d = i;
            return this;
        }

        public a b(int i) {
            this.f3106e = i;
            return this;
        }

        public a c(int i) {
            this.f3107f = i;
            return this;
        }

        public c a() {
            c cVar = new c(this);
            this.f3102a.a((b) cVar);
            if (!TextUtils.isEmpty(this.f3103b)) {
                this.f3102a.a(this.f3103b, (b) cVar);
            }
            return cVar;
        }
    }
}
