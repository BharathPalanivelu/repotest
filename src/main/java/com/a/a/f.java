package com.a.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.TextView;
import com.a.a.a.a;
import com.a.a.a.b;
import com.a.a.c;
import com.a.a.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private final Context f3127a;

    /* renamed from: b  reason: collision with root package name */
    private final String f3128b;

    /* renamed from: c  reason: collision with root package name */
    private final List<b> f3129c;

    /* renamed from: d  reason: collision with root package name */
    private final HashMap<String, b> f3130d;

    /* renamed from: e  reason: collision with root package name */
    private final List<Pair<d, f>> f3131e;

    private f(Context context) {
        this.f3127a = context;
        this.f3129c = new ArrayList();
        this.f3130d = new HashMap<>();
        this.f3131e = new ArrayList();
        this.f3128b = null;
    }

    public f(Context context, String str) {
        this.f3127a = context;
        this.f3129c = new ArrayList();
        this.f3130d = new HashMap<>();
        this.f3131e = new ArrayList();
        this.f3128b = str;
    }

    public d.a a() {
        return new d.a(this);
    }

    public d.a a(Object obj) {
        d.a aVar = new d.a(this);
        aVar.a(obj);
        return aVar;
    }

    public d.a a(String str) {
        d.a aVar = new d.a(this);
        aVar.a((Object) str);
        return aVar;
    }

    public d.a a(int i) {
        d.a aVar = new d.a(this);
        aVar.a((Object) c(i));
        return aVar;
    }

    public c.a b(int i) {
        c.a aVar = new c.a(this);
        aVar.a(i);
        return aVar;
    }

    public void a(TextView textView) {
        textView.setOnTouchListener(new b());
        textView.setText(new SpannableStringBuilder(c()));
    }

    private SpannedString c() {
        if (!TextUtils.isEmpty(this.f3128b)) {
            return a.a(Locale.getDefault(), this.f3128b, this.f3129c.toArray());
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (b a2 : this.f3129c) {
            spannableStringBuilder.append(a2.a());
        }
        return new SpannedString(spannableStringBuilder);
    }

    /* access modifiers changed from: protected */
    public String c(int i) {
        return this.f3127a.getResources().getString(i);
    }

    /* access modifiers changed from: protected */
    public Drawable d(int i) {
        return this.f3127a.getResources().getDrawable(i);
    }

    /* access modifiers changed from: protected */
    public void a(String str, b bVar) {
        if (!this.f3130d.containsKey(str)) {
            this.f3130d.put(str, bVar);
            return;
        }
        throw new RuntimeException("Unable to add or update key for this piece. Same key already exists.");
    }

    public static f a(Context context) {
        return new f(context);
    }

    public static f a(Context context, String str) {
        return new f(context, str);
    }

    public static f a(Context context, int i) {
        return new f(context, context.getResources().getString(i));
    }

    public d b(String str) {
        return (d) this.f3130d.get(str);
    }

    /* access modifiers changed from: protected */
    public void a(b bVar) {
        this.f3129c.add(bVar);
    }

    public SpannedString b() {
        return c();
    }
}
