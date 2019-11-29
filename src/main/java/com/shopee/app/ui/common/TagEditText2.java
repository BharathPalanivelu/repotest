package com.shopee.app.ui.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.widget.EditText;
import com.a.a.f;
import com.shopee.app.a;
import com.shopee.id.R;
import com.tencent.qcloud.core.util.IOUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class TagEditText2 extends EditText {

    /* renamed from: a  reason: collision with root package name */
    private String f21014a = "";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public int f21015b = 0;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public c f21016c = new c();

    /* renamed from: d  reason: collision with root package name */
    private int f21017d;

    /* renamed from: e  reason: collision with root package name */
    private WeakReference<b> f21018e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public String f21019f = "@";

    /* renamed from: g  reason: collision with root package name */
    private String f21020g = ",;'%^$.:?+=-\"!*() ";
    /* access modifiers changed from: private */
    public boolean h = false;
    /* access modifiers changed from: private */
    public TextWatcher i = new TextWatcher() {

        /* renamed from: a  reason: collision with root package name */
        boolean f21021a;

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            boolean z = false;
            this.f21021a = (i3 > 2 && charSequence.length() == 0) || (i3 == 0 && i2 == 1 && TagEditText2.this.f21019f.equals(String.valueOf(charSequence.charAt(charSequence.length() - 1))));
            if (TagEditText2.this.f21015b == 1 && i3 == 0 && i2 == 1) {
                if (i < charSequence.length() && charSequence.charAt(i) == TagEditText2.this.f21019f.charAt(0)) {
                    z = true;
                }
                if (z) {
                    int unused = TagEditText2.this.f21015b = 2;
                }
            }
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            boolean z;
            int i4 = (i + i3) - 1;
            if (i4 > charSequence.length() - 1) {
                i4 = charSequence.length() - 1;
            }
            if (i4 < 0) {
                i4 = 0;
            }
            try {
                if (i < charSequence.length() && TagEditText2.this.a(charSequence.charAt(i4))) {
                    this.f21021a = true;
                }
            } catch (Exception unused) {
            }
            if (TagEditText2.this.f21015b == 0) {
                TagEditText2 tagEditText2 = TagEditText2.this;
                c unused2 = tagEditText2.f21016c = tagEditText2.a(charSequence, i);
                if (!(i < charSequence.length() && charSequence.charAt(i) == TagEditText2.this.f21019f.charAt(0)) || i3 != 1) {
                    c c2 = TagEditText2.this.f21016c;
                    if (!TextUtils.isEmpty(c2.f21028c) && c2.f21028c.charAt(0) == TagEditText2.this.f21019f.charAt(0)) {
                        int unused3 = TagEditText2.this.f21015b = 1;
                        TagEditText2.this.a(c2.f21026a, c2.f21028c.length());
                        try {
                            String charSequence2 = charSequence.subSequence(c2.f21026a, c2.f21027b).toString();
                            if (charSequence2.charAt(0) == TagEditText2.this.f21019f.charAt(0)) {
                                charSequence2 = charSequence2.substring(1);
                            }
                            TagEditText2.this.a(charSequence2.toLowerCase().trim());
                        } catch (Exception unused4) {
                        }
                    }
                } else {
                    int unused5 = TagEditText2.this.f21015b = 1;
                    TagEditText2.this.a(i, i3);
                }
            } else if (TagEditText2.this.f21015b == 1) {
                TagEditText2 tagEditText22 = TagEditText2.this;
                c unused6 = tagEditText22.f21016c = tagEditText22.a(charSequence, i4);
                if (i < charSequence.length()) {
                    z = TagEditText2.this.a(i < charSequence.length() ? charSequence.charAt(i) : IOUtils.DIR_SEPARATOR_WINDOWS);
                } else {
                    z = false;
                }
                if (!z || i3 != 1) {
                    c c3 = TagEditText2.this.f21016c;
                    if (!TextUtils.isEmpty(c3.f21028c) && c3.f21028c.charAt(0) != TagEditText2.this.f21019f.charAt(0)) {
                        int unused7 = TagEditText2.this.f21015b = 0;
                        TagEditText2.this.b();
                    }
                    if (TagEditText2.this.f21015b != 0) {
                        String charSequence3 = charSequence.subSequence(c3.f21026a, c3.f21027b).toString();
                        if (charSequence3.charAt(0) == TagEditText2.this.f21019f.charAt(0)) {
                            charSequence3 = charSequence3.substring(1);
                        }
                        TagEditText2.this.a(charSequence3.toLowerCase().trim());
                        return;
                    }
                    return;
                }
                int unused8 = TagEditText2.this.f21015b = 0;
                TagEditText2.this.b();
            } else if (TagEditText2.this.f21015b == 2) {
                int unused9 = TagEditText2.this.f21015b = 0;
                TagEditText2.this.b();
            }
        }

        public void afterTextChanged(Editable editable) {
            if (this.f21021a) {
                boolean unused = TagEditText2.this.h = true;
            }
            if (TagEditText2.this.h) {
                try {
                    TagEditText2.this.a(editable);
                } catch (Exception e2) {
                    com.garena.android.appkit.d.a.a(e2);
                }
            }
        }
    };
    private a j;
    private int k = 0;
    private int l = 0;

    public interface b {
        void a(int i);

        void a(int i, int i2);

        void a(String str);
    }

    /* access modifiers changed from: private */
    public boolean a(char c2) {
        if (c2 < 0 || c2 > 127) {
            return false;
        }
        if (c2 >= '0' && c2 <= '9') {
            return false;
        }
        if (c2 < 'A' || c2 > 'Z') {
            return (c2 < 'a' || c2 > 'z') && c2 != '_';
        }
        return false;
    }

    public TagEditText2(Context context) {
        super(context);
        a();
    }

    public TagEditText2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
        a(context, attributeSet);
    }

    public TagEditText2(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
        a(context, attributeSet);
    }

    private void a() {
        addTextChangedListener(this.i);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.b.TagEditText);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == 0) {
                this.f21020g = obtainStyledAttributes.getString(index);
            } else if (index == 1) {
                this.f21019f = obtainStyledAttributes.getString(index);
            }
        }
        obtainStyledAttributes.recycle();
    }

    public void a(int i2, int i3) {
        com.garena.android.appkit.d.a.b("TAGGER-BEG: " + this.f21016c.f21026a + " | " + this.f21016c.f21027b + " | " + this.f21016c.f21028c + " | ", new Object[0]);
        d();
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        this.f21014a = str;
        com.garena.android.appkit.d.a.b("TAGGER-QUR: " + this.f21016c.f21026a + " | " + this.f21016c.f21027b + " | " + this.f21016c.f21028c + " | " + str, new Object[0]);
        e();
    }

    /* access modifiers changed from: private */
    public void b() {
        com.garena.android.appkit.d.a.b("TAGGER-END: " + this.f21016c.f21026a + " | " + this.f21016c.f21027b + " | " + this.f21016c.f21028c + " | ", new Object[0]);
        d();
    }

    public void setMaximunHashTags(int i2) {
        this.f21017d = i2;
    }

    private static class c {

        /* renamed from: a  reason: collision with root package name */
        public int f21026a;

        /* renamed from: b  reason: collision with root package name */
        public int f21027b;

        /* renamed from: c  reason: collision with root package name */
        public CharSequence f21028c;

        private c() {
        }
    }

    /* access modifiers changed from: private */
    public c a(CharSequence charSequence, int i2) {
        int min = Math.min(i2, charSequence.length() - 1);
        while (true) {
            if (min >= 0) {
                if (a(charSequence.charAt(min)) || charSequence.charAt(min) == this.f21019f.charAt(0)) {
                    break;
                }
                min--;
            } else {
                min = 0;
                break;
            }
        }
        int length = charSequence.length();
        while (true) {
            if (i2 < charSequence.length()) {
                if (a(charSequence.charAt(i2)) || charSequence.charAt(i2) == this.f21019f.charAt(0)) {
                    break;
                }
                i2++;
            } else {
                i2 = length;
                break;
            }
        }
        c cVar = new c();
        cVar.f21026a = min;
        cVar.f21027b = i2;
        cVar.f21028c = charSequence.subSequence(min, i2);
        return cVar;
    }

    /* access modifiers changed from: private */
    public void a(Editable editable) {
        a aVar = this.j;
        if (aVar != null) {
            aVar.a();
        }
        this.j = new a(editable);
        postDelayed(this.j, 600);
    }

    private List<c> a(CharSequence charSequence) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(charSequence)) {
            return arrayList;
        }
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i2 > charSequence.length()) {
                break;
            } else if (i3 < charSequence.length()) {
                boolean z = true;
                boolean z2 = charSequence.charAt(i3) == '#';
                if (!z2 || i3 <= i4) {
                    z = false;
                }
                if ((!a(charSequence.charAt(i3)) || z2) && (!z2 || !z)) {
                    i3++;
                } else {
                    if (i3 > i4) {
                        c cVar = new c();
                        cVar.f21026a = i4;
                        cVar.f21027b = i3;
                        cVar.f21028c = charSequence.subSequence(i4, i3);
                        arrayList.add(cVar);
                    }
                    i4 = i3;
                    i3++;
                }
                i2++;
            } else if (i3 > i4) {
                c cVar2 = new c();
                cVar2.f21026a = i4;
                cVar2.f21027b = charSequence.length();
                cVar2.f21028c = charSequence.subSequence(i4, i3);
                arrayList.add(cVar2);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public void b(Editable editable) {
        this.k = this.l;
        this.l = 0;
        for (c next : a((CharSequence) editable)) {
            if (next.f21028c.charAt(0) == this.f21019f.charAt(0)) {
                if (a(next)) {
                    int i2 = this.l;
                    if (i2 < this.f21017d) {
                        this.l = i2 + 1;
                        a(editable, next);
                        editable.replace(next.f21026a, next.f21027b, f.a(getContext()).a(next.f21028c.toString()).a().d().b(com.garena.android.appkit.tools.b.a(R.color.primary)).c().b().a());
                    }
                }
                a(editable, next);
            } else {
                a(editable, next);
            }
        }
        com.garena.android.appkit.d.a.b("COUNT: " + this.l, new Object[0]);
        c();
    }

    private void a(Editable editable, c cVar) {
        for (StyleSpan styleSpan : (StyleSpan[]) editable.getSpans(cVar.f21026a, cVar.f21027b, StyleSpan.class)) {
            if (styleSpan.getStyle() == 1) {
                editable.removeSpan(styleSpan);
            }
        }
        for (ForegroundColorSpan removeSpan : (ForegroundColorSpan[]) editable.getSpans(cVar.f21026a, cVar.f21027b, ForegroundColorSpan.class)) {
            editable.removeSpan(removeSpan);
        }
    }

    private boolean a(c cVar) {
        if (cVar.f21028c.charAt(0) == this.f21019f.charAt(0) && cVar.f21028c.length() == 1) {
            return false;
        }
        if (cVar.f21028c.charAt(0) == this.f21019f.charAt(0) && cVar.f21028c.length() > 3) {
            return true;
        }
        if (cVar.f21028c.charAt(0) != this.f21019f.charAt(0) || cVar.f21028c.length() > 3) {
            return false;
        }
        try {
            Integer.parseInt(cVar.f21028c.subSequence(1, cVar.f21028c.length()).toString());
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    private void c() {
        WeakReference<b> weakReference = this.f21018e;
        if (weakReference != null && weakReference.get() != null && this.k - this.l != 0) {
            ((b) this.f21018e.get()).a(this.k, this.l);
        }
    }

    private void d() {
        WeakReference<b> weakReference = this.f21018e;
        if (weakReference != null && weakReference.get() != null) {
            ((b) this.f21018e.get()).a(this.f21015b);
        }
    }

    private void e() {
        WeakReference<b> weakReference = this.f21018e;
        if (weakReference != null && weakReference.get() != null) {
            ((b) this.f21018e.get()).a(this.f21014a);
        }
    }

    public void setTagModeChangeListener(b bVar) {
        this.f21018e = new WeakReference<>(bVar);
    }

    public int getMode() {
        return this.f21015b;
    }

    private class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private boolean f21024b;

        /* renamed from: c  reason: collision with root package name */
        private Editable f21025c;

        public a(Editable editable) {
            this.f21025c = editable;
        }

        public void a() {
            this.f21024b = true;
        }

        public void run() {
            if (!this.f21024b) {
                TagEditText2 tagEditText2 = TagEditText2.this;
                tagEditText2.removeTextChangedListener(tagEditText2.i);
                TagEditText2.this.b(this.f21025c);
                boolean unused = TagEditText2.this.h = false;
                TagEditText2 tagEditText22 = TagEditText2.this;
                tagEditText22.addTextChangedListener(tagEditText22.i);
            }
        }
    }
}
