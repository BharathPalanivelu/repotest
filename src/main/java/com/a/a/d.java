package com.a.a;

import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;

public class d implements b {

    /* renamed from: a  reason: collision with root package name */
    private final f f3108a;

    /* renamed from: b  reason: collision with root package name */
    private e f3109b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public View.OnClickListener f3110c;

    /* renamed from: d  reason: collision with root package name */
    private a f3111d;

    /* renamed from: e  reason: collision with root package name */
    private Object f3112e;

    protected d(a aVar) {
        this.f3108a = aVar.f3114a;
        this.f3109b = aVar.f3116c;
        this.f3110c = aVar.f3117d;
        this.f3111d = aVar.f3118e;
        this.f3112e = aVar.f3119f;
    }

    public void a(Object obj) {
        this.f3112e = obj;
    }

    public SpannableString a() {
        SpannedString c2 = c();
        if (TextUtils.isEmpty(c2)) {
            return new SpannableString("");
        }
        SpannableString spannableString = new SpannableString(c2);
        int length = spannableString.length();
        if (this.f3110c != null) {
            spannableString.setSpan(new ClickableSpan() {
                public void onClick(View view) {
                    d.this.f3110c.onClick(view);
                }
            }, 0, length, 33);
        }
        e eVar = this.f3109b;
        return eVar != null ? eVar.a(spannableString, 0, length) : spannableString;
    }

    private SpannedString c() {
        a aVar = this.f3111d;
        if (aVar != null) {
            return aVar.format(this.f3112e);
        }
        return new SpannedString(String.valueOf(this.f3112e));
    }

    public f b() {
        return this.f3108a;
    }

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final f f3114a;

        /* renamed from: b  reason: collision with root package name */
        private String f3115b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public e<a> f3116c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public View.OnClickListener f3117d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public a f3118e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public Object f3119f;

        public a(f fVar) {
            this.f3114a = fVar;
        }

        public a a(String str) {
            this.f3115b = str;
            return this;
        }

        public e<a> a() {
            this.f3116c = new e<>(this);
            return this.f3116c;
        }

        public a a(View.OnClickListener onClickListener) {
            this.f3117d = onClickListener;
            return this;
        }

        public a a(a aVar) {
            this.f3118e = aVar;
            return this;
        }

        public a a(Object obj) {
            this.f3119f = obj;
            return this;
        }

        public d b() {
            d dVar = new d(this);
            if (!TextUtils.isEmpty(this.f3115b)) {
                this.f3114a.a(this.f3115b, (b) dVar);
            }
            this.f3114a.a((b) dVar);
            return dVar;
        }
    }
}
