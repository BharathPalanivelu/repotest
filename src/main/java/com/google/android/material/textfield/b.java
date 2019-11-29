package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.g.w;
import androidx.core.widget.i;
import androidx.legacy.widget.Space;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.material.a;
import java.util.ArrayList;
import java.util.List;

final class b {

    /* renamed from: a  reason: collision with root package name */
    private final Context f13527a;

    /* renamed from: b  reason: collision with root package name */
    private final TextInputLayout f13528b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f13529c;

    /* renamed from: d  reason: collision with root package name */
    private int f13530d;

    /* renamed from: e  reason: collision with root package name */
    private FrameLayout f13531e;

    /* renamed from: f  reason: collision with root package name */
    private int f13532f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Animator f13533g;
    private final float h = ((float) this.f13527a.getResources().getDimensionPixelSize(a.d.design_textinput_caption_translate_y));
    /* access modifiers changed from: private */
    public int i;
    private int j;
    private CharSequence k;
    private boolean l;
    /* access modifiers changed from: private */
    public TextView m;
    private int n;
    private CharSequence o;
    private boolean p;
    private TextView q;
    private int r;
    private Typeface s;

    /* access modifiers changed from: package-private */
    public boolean a(int i2) {
        return i2 == 0 || i2 == 1;
    }

    public b(TextInputLayout textInputLayout) {
        this.f13527a = textInputLayout.getContext();
        this.f13528b = textInputLayout;
    }

    /* access modifiers changed from: package-private */
    public void a(CharSequence charSequence) {
        c();
        this.o = charSequence;
        this.q.setText(charSequence);
        if (this.i != 2) {
            this.j = 2;
        }
        a(this.i, this.j, a(this.q, charSequence));
    }

    /* access modifiers changed from: package-private */
    public void a() {
        c();
        if (this.i == 2) {
            this.j = 0;
        }
        a(this.i, this.j, a(this.q, (CharSequence) null));
    }

    /* access modifiers changed from: package-private */
    public void b(CharSequence charSequence) {
        c();
        this.k = charSequence;
        this.m.setText(charSequence);
        if (this.i != 1) {
            this.j = 1;
        }
        a(this.i, this.j, a(this.m, charSequence));
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.k = null;
        c();
        if (this.i == 1) {
            if (!this.p || TextUtils.isEmpty(this.o)) {
                this.j = 0;
            } else {
                this.j = 2;
            }
        }
        a(this.i, this.j, a(this.m, (CharSequence) null));
    }

    private boolean a(TextView textView, CharSequence charSequence) {
        return w.A(this.f13528b) && this.f13528b.isEnabled() && (this.j != this.i || textView == null || !TextUtils.equals(textView.getText(), charSequence));
    }

    private void a(int i2, int i3, boolean z) {
        if (z) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f13533g = animatorSet;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = arrayList;
            int i4 = i2;
            int i5 = i3;
            a(arrayList2, this.p, this.q, 2, i4, i5);
            a(arrayList2, this.l, this.m, 1, i4, i5);
            com.google.android.material.a.b.a(animatorSet, arrayList);
            final TextView d2 = d(i2);
            final TextView d3 = d(i3);
            final int i6 = i3;
            final int i7 = i2;
            animatorSet.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    int unused = b.this.i = i6;
                    Animator unused2 = b.this.f13533g = null;
                    TextView textView = d2;
                    if (textView != null) {
                        textView.setVisibility(4);
                        if (i7 == 1 && b.this.m != null) {
                            b.this.m.setText((CharSequence) null);
                        }
                    }
                }

                public void onAnimationStart(Animator animator) {
                    TextView textView = d3;
                    if (textView != null) {
                        textView.setVisibility(0);
                    }
                }
            });
            animatorSet.start();
        } else {
            a(i2, i3);
        }
        this.f13528b.updateEditTextBackground();
        this.f13528b.updateLabelState(z);
        this.f13528b.updateTextInputBoxState();
    }

    private void a(int i2, int i3) {
        if (i2 != i3) {
            if (i3 != 0) {
                TextView d2 = d(i3);
                if (d2 != null) {
                    d2.setVisibility(0);
                    d2.setAlpha(1.0f);
                }
            }
            if (i2 != 0) {
                TextView d3 = d(i2);
                if (d3 != null) {
                    d3.setVisibility(4);
                    if (i2 == 1) {
                        d3.setText((CharSequence) null);
                    }
                }
            }
            this.i = i3;
        }
    }

    private void a(List<Animator> list, boolean z, TextView textView, int i2, int i3, int i4) {
        if (textView != null && z) {
            if (i2 == i4 || i2 == i3) {
                list.add(a(textView, i4 == i2));
                if (i4 == i2) {
                    list.add(a(textView));
                }
            }
        }
    }

    private ObjectAnimator a(TextView textView, boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.ALPHA, new float[]{z ? 1.0f : BitmapDescriptorFactory.HUE_RED});
        ofFloat.setDuration(167);
        ofFloat.setInterpolator(com.google.android.material.a.a.f13098a);
        return ofFloat;
    }

    private ObjectAnimator a(TextView textView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.TRANSLATION_Y, new float[]{-this.h, 0.0f});
        ofFloat.setDuration(217);
        ofFloat.setInterpolator(com.google.android.material.a.a.f13101d);
        return ofFloat;
    }

    /* access modifiers changed from: package-private */
    public void c() {
        Animator animator = this.f13533g;
        if (animator != null) {
            animator.cancel();
        }
    }

    private TextView d(int i2) {
        if (i2 == 1) {
            return this.m;
        }
        if (i2 != 2) {
            return null;
        }
        return this.q;
    }

    /* access modifiers changed from: package-private */
    public void d() {
        if (n()) {
            w.b(this.f13529c, w.j(this.f13528b.getEditText()), 0, w.k(this.f13528b.getEditText()), 0);
        }
    }

    private boolean n() {
        return (this.f13529c == null || this.f13528b.getEditText() == null) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public void a(TextView textView, int i2) {
        if (this.f13529c == null && this.f13531e == null) {
            this.f13529c = new LinearLayout(this.f13527a);
            this.f13529c.setOrientation(0);
            this.f13528b.addView(this.f13529c, -1, -2);
            this.f13531e = new FrameLayout(this.f13527a);
            this.f13529c.addView(this.f13531e, -1, new FrameLayout.LayoutParams(-2, -2));
            this.f13529c.addView(new Space(this.f13527a), new LinearLayout.LayoutParams(0, 0, 1.0f));
            if (this.f13528b.getEditText() != null) {
                d();
            }
        }
        if (a(i2)) {
            this.f13531e.setVisibility(0);
            this.f13531e.addView(textView);
            this.f13532f++;
        } else {
            this.f13529c.addView(textView, i2);
        }
        this.f13529c.setVisibility(0);
        this.f13530d++;
    }

    /* access modifiers changed from: package-private */
    public void b(TextView textView, int i2) {
        if (this.f13529c != null) {
            if (a(i2)) {
                FrameLayout frameLayout = this.f13531e;
                if (frameLayout != null) {
                    this.f13532f--;
                    a((ViewGroup) frameLayout, this.f13532f);
                    this.f13531e.removeView(textView);
                    this.f13530d--;
                    a((ViewGroup) this.f13529c, this.f13530d);
                }
            }
            this.f13529c.removeView(textView);
            this.f13530d--;
            a((ViewGroup) this.f13529c, this.f13530d);
        }
    }

    private void a(ViewGroup viewGroup, int i2) {
        if (i2 == 0) {
            viewGroup.setVisibility(8);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z) {
        if (this.l != z) {
            c();
            if (z) {
                this.m = new AppCompatTextView(this.f13527a);
                this.m.setId(a.f.textinput_error);
                Typeface typeface = this.s;
                if (typeface != null) {
                    this.m.setTypeface(typeface);
                }
                b(this.n);
                this.m.setVisibility(4);
                w.f(this.m, 1);
                a(this.m, 0);
            } else {
                b();
                b(this.m, 0);
                this.m = null;
                this.f13528b.updateEditTextBackground();
                this.f13528b.updateTextInputBoxState();
            }
            this.l = z;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean e() {
        return this.l;
    }

    /* access modifiers changed from: package-private */
    public boolean f() {
        return this.p;
    }

    /* access modifiers changed from: package-private */
    public void b(boolean z) {
        if (this.p != z) {
            c();
            if (z) {
                this.q = new AppCompatTextView(this.f13527a);
                this.q.setId(a.f.textinput_helper_text);
                Typeface typeface = this.s;
                if (typeface != null) {
                    this.q.setTypeface(typeface);
                }
                this.q.setVisibility(4);
                w.f(this.q, 1);
                c(this.r);
                a(this.q, 1);
            } else {
                a();
                b(this.q, 1);
                this.q = null;
                this.f13528b.updateEditTextBackground();
                this.f13528b.updateTextInputBoxState();
            }
            this.p = z;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean g() {
        return e(this.j);
    }

    private boolean e(int i2) {
        if (i2 != 1 || this.m == null || TextUtils.isEmpty(this.k)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean h() {
        return f(this.i);
    }

    private boolean f(int i2) {
        return i2 == 2 && this.q != null && !TextUtils.isEmpty(this.o);
    }

    /* access modifiers changed from: package-private */
    public CharSequence i() {
        return this.k;
    }

    /* access modifiers changed from: package-private */
    public CharSequence j() {
        return this.o;
    }

    /* access modifiers changed from: package-private */
    public void a(Typeface typeface) {
        if (typeface != this.s) {
            this.s = typeface;
            a(this.m, typeface);
            a(this.q, typeface);
        }
    }

    private void a(TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    /* access modifiers changed from: package-private */
    public int k() {
        TextView textView = this.m;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public ColorStateList l() {
        TextView textView = this.m;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        TextView textView = this.m;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(int i2) {
        this.n = i2;
        TextView textView = this.m;
        if (textView != null) {
            this.f13528b.setTextAppearanceCompatWithErrorFallback(textView, i2);
        }
    }

    /* access modifiers changed from: package-private */
    public int m() {
        TextView textView = this.q;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public void b(ColorStateList colorStateList) {
        TextView textView = this.q;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    /* access modifiers changed from: package-private */
    public void c(int i2) {
        this.r = i2;
        TextView textView = this.q;
        if (textView != null) {
            i.a(textView, i2);
        }
    }
}
