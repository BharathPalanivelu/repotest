package com.afollestad.materialdialogs;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.afollestad.materialdialogs.f;
import com.afollestad.materialdialogs.g;
import com.afollestad.materialdialogs.internal.b;

class a extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    public RadioButton f3132a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f3133b;

    /* renamed from: c  reason: collision with root package name */
    private final f f3134c;

    /* renamed from: d  reason: collision with root package name */
    private final int f3135d;

    /* renamed from: e  reason: collision with root package name */
    private final e f3136e;

    public long getItemId(int i) {
        return (long) i;
    }

    public boolean hasStableIds() {
        return true;
    }

    public a(f fVar, int i) {
        this.f3134c = fVar;
        this.f3135d = i;
        this.f3136e = fVar.f3148b.f3165f;
    }

    public int getCount() {
        if (this.f3134c.f3148b.k != null) {
            return this.f3134c.f3148b.k.length;
        }
        return 0;
    }

    public Object getItem(int i) {
        return this.f3134c.f3148b.k[i];
    }

    @SuppressLint({"WrongViewCast"})
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f3134c.getContext()).inflate(this.f3135d, viewGroup, false);
        }
        TextView textView = (TextView) view.findViewById(g.f.title);
        int i2 = AnonymousClass1.f3137a[this.f3134c.q.ordinal()];
        if (i2 == 1) {
            RadioButton radioButton = (RadioButton) view.findViewById(g.f.control);
            boolean z = this.f3134c.f3148b.D == i;
            b.a(radioButton, this.f3134c.f3148b.p);
            radioButton.setChecked(z);
            if (z && this.f3133b) {
                this.f3132a = radioButton;
            }
        } else if (i2 == 2) {
            CheckBox checkBox = (CheckBox) view.findViewById(g.f.control);
            boolean contains = this.f3134c.r.contains(Integer.valueOf(i));
            b.a(checkBox, this.f3134c.f3148b.p);
            checkBox.setChecked(contains);
        }
        textView.setText(this.f3134c.f3148b.k[i]);
        textView.setTextColor(this.f3134c.f3148b.U);
        f fVar = this.f3134c;
        fVar.a(textView, fVar.f3148b.G);
        view.setTag(i + ":" + this.f3134c.f3148b.k[i]);
        ViewGroup viewGroup2 = (ViewGroup) view;
        a(viewGroup2);
        if (Build.VERSION.SDK_INT >= 21 && viewGroup2.getChildCount() == 2) {
            if (viewGroup2.getChildAt(0) instanceof CompoundButton) {
                viewGroup2.getChildAt(0).setBackground((Drawable) null);
            } else if (viewGroup2.getChildAt(1) instanceof CompoundButton) {
                viewGroup2.getChildAt(1).setBackground((Drawable) null);
            }
        }
        return view;
    }

    /* renamed from: com.afollestad.materialdialogs.a$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3137a = new int[f.g.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                com.afollestad.materialdialogs.f$g[] r0 = com.afollestad.materialdialogs.f.g.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3137a = r0
                int[] r0 = f3137a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.afollestad.materialdialogs.f$g r1 = com.afollestad.materialdialogs.f.g.SINGLE     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f3137a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.afollestad.materialdialogs.f$g r1 = com.afollestad.materialdialogs.f.g.MULTI     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.afollestad.materialdialogs.a.AnonymousClass1.<clinit>():void");
        }
    }

    @TargetApi(17)
    private void a(ViewGroup viewGroup) {
        ((LinearLayout) viewGroup).setGravity(this.f3136e.getGravityInt() | 16);
        if (viewGroup.getChildCount() != 2) {
            return;
        }
        if (this.f3136e == e.END && !a() && (viewGroup.getChildAt(0) instanceof CompoundButton)) {
            CompoundButton compoundButton = (CompoundButton) viewGroup.getChildAt(0);
            viewGroup.removeView(compoundButton);
            TextView textView = (TextView) viewGroup.getChildAt(0);
            viewGroup.removeView(textView);
            textView.setPadding(textView.getPaddingRight(), textView.getPaddingTop(), textView.getPaddingLeft(), textView.getPaddingBottom());
            viewGroup.addView(textView);
            viewGroup.addView(compoundButton);
        } else if (this.f3136e == e.START && a() && (viewGroup.getChildAt(1) instanceof CompoundButton)) {
            CompoundButton compoundButton2 = (CompoundButton) viewGroup.getChildAt(1);
            viewGroup.removeView(compoundButton2);
            TextView textView2 = (TextView) viewGroup.getChildAt(0);
            viewGroup.removeView(textView2);
            textView2.setPadding(textView2.getPaddingRight(), textView2.getPaddingTop(), textView2.getPaddingRight(), textView2.getPaddingBottom());
            viewGroup.addView(compoundButton2);
            viewGroup.addView(textView2);
        }
    }

    @TargetApi(17)
    private boolean a() {
        if (Build.VERSION.SDK_INT >= 17 && this.f3134c.b().a().getResources().getConfiguration().getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }
}
