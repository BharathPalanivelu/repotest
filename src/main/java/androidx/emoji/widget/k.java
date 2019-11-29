package androidx.emoji.widget;

import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import androidx.core.util.e;
import androidx.emoji.b.d;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class k extends SpannableStringBuilder {

    /* renamed from: a  reason: collision with root package name */
    private final Class<?> f2110a;

    /* renamed from: b  reason: collision with root package name */
    private final List<a> f2111b = new ArrayList();

    k(Class<?> cls, CharSequence charSequence) {
        super(charSequence);
        e.a(cls, (Object) "watcherClass cannot be null");
        this.f2110a = cls;
    }

    k(Class<?> cls, CharSequence charSequence, int i, int i2) {
        super(charSequence, i, i2);
        e.a(cls, (Object) "watcherClass cannot be null");
        this.f2110a = cls;
    }

    static k a(Class<?> cls, CharSequence charSequence) {
        return new k(cls, charSequence);
    }

    private boolean a(Object obj) {
        return obj != null && a(obj.getClass());
    }

    private boolean a(Class<?> cls) {
        return this.f2110a == cls;
    }

    public CharSequence subSequence(int i, int i2) {
        return new k(this.f2110a, this, i, i2);
    }

    public void setSpan(Object obj, int i, int i2, int i3) {
        if (a(obj)) {
            a aVar = new a(obj);
            this.f2111b.add(aVar);
            obj = aVar;
        }
        super.setSpan(obj, i, i2, i3);
    }

    public <T> T[] getSpans(int i, int i2, Class<T> cls) {
        if (!a((Class<?>) cls)) {
            return super.getSpans(i, i2, cls);
        }
        a[] aVarArr = (a[]) super.getSpans(i, i2, a.class);
        T[] tArr = (Object[]) Array.newInstance(cls, aVarArr.length);
        for (int i3 = 0; i3 < aVarArr.length; i3++) {
            tArr[i3] = aVarArr[i3].f2112a;
        }
        return tArr;
    }

    public void removeSpan(Object obj) {
        a aVar;
        if (a(obj)) {
            aVar = b(obj);
            if (aVar != null) {
                obj = aVar;
            }
        } else {
            aVar = null;
        }
        super.removeSpan(obj);
        if (aVar != null) {
            this.f2111b.remove(aVar);
        }
    }

    public int getSpanStart(Object obj) {
        if (a(obj)) {
            a b2 = b(obj);
            if (b2 != null) {
                obj = b2;
            }
        }
        return super.getSpanStart(obj);
    }

    public int getSpanEnd(Object obj) {
        if (a(obj)) {
            a b2 = b(obj);
            if (b2 != null) {
                obj = b2;
            }
        }
        return super.getSpanEnd(obj);
    }

    public int getSpanFlags(Object obj) {
        if (a(obj)) {
            a b2 = b(obj);
            if (b2 != null) {
                obj = b2;
            }
        }
        return super.getSpanFlags(obj);
    }

    public int nextSpanTransition(int i, int i2, Class<a> cls) {
        if (a((Class<?>) cls)) {
            cls = a.class;
        }
        return super.nextSpanTransition(i, i2, cls);
    }

    private a b(Object obj) {
        for (int i = 0; i < this.f2111b.size(); i++) {
            a aVar = this.f2111b.get(i);
            if (aVar.f2112a == obj) {
                return aVar;
            }
        }
        return null;
    }

    public void a() {
        c();
    }

    public void b() {
        d();
        e();
    }

    private void c() {
        for (int i = 0; i < this.f2111b.size(); i++) {
            this.f2111b.get(i).a();
        }
    }

    private void d() {
        for (int i = 0; i < this.f2111b.size(); i++) {
            this.f2111b.get(i).b();
        }
    }

    private void e() {
        for (int i = 0; i < this.f2111b.size(); i++) {
            this.f2111b.get(i).onTextChanged(this, 0, length(), length());
        }
    }

    public SpannableStringBuilder replace(int i, int i2, CharSequence charSequence) {
        c();
        super.replace(i, i2, charSequence);
        d();
        return this;
    }

    public SpannableStringBuilder replace(int i, int i2, CharSequence charSequence, int i3, int i4) {
        c();
        super.replace(i, i2, charSequence, i3, i4);
        d();
        return this;
    }

    public SpannableStringBuilder insert(int i, CharSequence charSequence) {
        super.insert(i, charSequence);
        return this;
    }

    public SpannableStringBuilder insert(int i, CharSequence charSequence, int i2, int i3) {
        super.insert(i, charSequence, i2, i3);
        return this;
    }

    public SpannableStringBuilder delete(int i, int i2) {
        super.delete(i, i2);
        return this;
    }

    public SpannableStringBuilder append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    public SpannableStringBuilder append(char c2) {
        super.append(c2);
        return this;
    }

    public SpannableStringBuilder append(CharSequence charSequence, int i, int i2) {
        super.append(charSequence, i, i2);
        return this;
    }

    public SpannableStringBuilder append(CharSequence charSequence, Object obj, int i) {
        super.append(charSequence, obj, i);
        return this;
    }

    private static class a implements SpanWatcher, TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final Object f2112a;

        /* renamed from: b  reason: collision with root package name */
        private final AtomicInteger f2113b = new AtomicInteger(0);

        a(Object obj) {
            this.f2112a = obj;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            ((TextWatcher) this.f2112a).beforeTextChanged(charSequence, i, i2, i3);
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            ((TextWatcher) this.f2112a).onTextChanged(charSequence, i, i2, i3);
        }

        public void afterTextChanged(Editable editable) {
            ((TextWatcher) this.f2112a).afterTextChanged(editable);
        }

        public void onSpanAdded(Spannable spannable, Object obj, int i, int i2) {
            if (this.f2113b.get() <= 0 || !a(obj)) {
                ((SpanWatcher) this.f2112a).onSpanAdded(spannable, obj, i, i2);
            }
        }

        public void onSpanRemoved(Spannable spannable, Object obj, int i, int i2) {
            if (this.f2113b.get() <= 0 || !a(obj)) {
                ((SpanWatcher) this.f2112a).onSpanRemoved(spannable, obj, i, i2);
            }
        }

        public void onSpanChanged(Spannable spannable, Object obj, int i, int i2, int i3, int i4) {
            if (this.f2113b.get() <= 0 || !a(obj)) {
                ((SpanWatcher) this.f2112a).onSpanChanged(spannable, obj, i, i2, i3, i4);
            }
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            this.f2113b.incrementAndGet();
        }

        /* access modifiers changed from: package-private */
        public final void b() {
            this.f2113b.decrementAndGet();
        }

        private boolean a(Object obj) {
            return obj instanceof d;
        }
    }
}
