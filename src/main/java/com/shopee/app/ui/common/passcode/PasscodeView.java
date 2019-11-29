package com.shopee.app.ui.common.passcode;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.afollestad.materialdialogs.f;
import com.afollestad.materialdialogs.internal.MDButton;
import com.garena.android.appkit.tools.a.b;
import com.shopee.id.R;
import com.tencent.ijk.media.player.IjkMediaCodecInfo;
import java.util.ArrayList;
import java.util.Iterator;

public class PasscodeView extends LinearLayout implements a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<b> f21310a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public StringBuilder f21311b;

    /* renamed from: c  reason: collision with root package name */
    private int f21312c = 6;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f21313d;

    /* renamed from: e  reason: collision with root package name */
    private int f21314e = b.a.o;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public TextWatcher f21315f;

    /* renamed from: g  reason: collision with root package name */
    private f f21316g;

    public PasscodeView(Context context) {
        super(context);
        a(context);
    }

    public PasscodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public PasscodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    @TargetApi(21)
    public PasscodeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a(context);
    }

    private void a(Context context) {
        setOrientation(0);
        setGravity(17);
        this.f21310a = new ArrayList<>();
        this.f21311b = new StringBuilder();
        this.f21315f = new a(this);
    }

    private void c() {
        removeAllViews();
        removeAllViewsInLayout();
        if (this.f21312c >= 0) {
            for (int i = 0; i < this.f21312c; i++) {
                final b bVar = new b(getContext());
                bVar.setGravity(17);
                bVar.setHideUnderline(true);
                bVar.a((a) this);
                bVar.setCursorVisible(true);
                bVar.setRawInputType(18);
                bVar.setInputType(18);
                bVar.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1)});
                bVar.setLayoutParams(getPassCodeLayoutParams());
                bVar.setBackground(com.garena.android.appkit.tools.b.f(R.drawable.border_all_sides));
                bVar.setTextSize(1, (float) b.a.f7696g);
                bVar.addTextChangedListener(this.f21315f);
                bVar.setOnTouchListener(new View.OnTouchListener() {
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        if (motionEvent.getAction() != 0) {
                            bVar.removeTextChangedListener(PasscodeView.this.f21315f);
                            Iterator it = PasscodeView.this.f21310a.iterator();
                            while (it.hasNext()) {
                                ((b) it.next()).setText("");
                            }
                            bVar.addTextChangedListener(PasscodeView.this.f21315f);
                            com.garena.android.appkit.f.f.a().a(new Runnable() {
                                public void run() {
                                    int unused = PasscodeView.this.f21313d = 0;
                                    ((b) PasscodeView.this.f21310a.get(PasscodeView.this.f21313d)).requestFocus();
                                    PasscodeView.this.f21311b.delete(0, PasscodeView.this.f21311b.length());
                                    PasscodeView.this.d();
                                }
                            }, 400);
                        }
                        return false;
                    }
                });
                bVar.setOnKeyListener(new View.OnKeyListener() {
                    public boolean onKey(View view, int i, KeyEvent keyEvent) {
                        if (keyEvent.getKeyCode() != 67) {
                            return false;
                        }
                        bVar.removeTextChangedListener(PasscodeView.this.f21315f);
                        Iterator it = PasscodeView.this.f21310a.iterator();
                        while (it.hasNext()) {
                            ((b) it.next()).setText("");
                        }
                        bVar.addTextChangedListener(PasscodeView.this.f21315f);
                        com.garena.android.appkit.f.f.a().a(new Runnable() {
                            public void run() {
                                int unused = PasscodeView.this.f21313d = 0;
                                ((b) PasscodeView.this.f21310a.get(PasscodeView.this.f21313d)).requestFocus();
                                PasscodeView.this.f21311b.delete(0, PasscodeView.this.f21311b.length());
                                PasscodeView.this.d();
                            }
                        }, 400);
                        return true;
                    }
                });
                addView(bVar, i);
                this.f21310a.add(bVar);
            }
            com.garena.android.appkit.f.f.a().a(new Runnable() {
                public void run() {
                    com.shopee.app.c.a.b((View) PasscodeView.this.f21310a.get(0));
                }
            }, IjkMediaCodecInfo.RANK_LAST_CHANCE);
            return;
        }
        throw new IllegalStateException("Invalid PassCodeCount > 0 required");
    }

    private LinearLayout.LayoutParams getPassCodeLayoutParams() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, this.f21314e, 1.0f);
        layoutParams.setMargins(b.a.f7691b, 0, b.a.f7691b, 0);
        return layoutParams;
    }

    public void b() {
        int i = this.f21313d;
        if (i <= 0) {
            StringBuilder sb = this.f21311b;
            sb.delete(0, sb.length());
            return;
        }
        this.f21313d = i - 1;
        StringBuilder sb2 = this.f21311b;
        sb2.deleteCharAt(sb2.length() - 1);
        int i2 = this.f21313d;
        if (i2 >= 0) {
            this.f21310a.get(i2).requestFocus();
        }
        d();
    }

    public void a(char c2) {
        int i = this.f21313d;
        int i2 = this.f21312c;
        if (i < i2) {
            if (i < i2 - 1) {
                this.f21313d = i + 1;
                this.f21310a.get(this.f21313d).requestFocus();
            }
            this.f21311b.append(c2);
            d();
            this.f21311b.length();
            int i3 = this.f21312c;
        }
    }

    public void a() {
        b();
    }

    public void a(int i) {
        this.f21312c = i;
        c();
    }

    public String getPasscode() {
        return this.f21311b.toString();
    }

    public void setDialog(f fVar) {
        this.f21316g = fVar;
        d();
    }

    /* access modifiers changed from: private */
    public void d() {
        f fVar = this.f21316g;
        if (fVar != null) {
            MDButton a2 = fVar.a(com.afollestad.materialdialogs.b.POSITIVE);
            if (this.f21311b.length() == this.f21312c) {
                a2.setEnabled(true);
            } else {
                a2.setEnabled(false);
            }
        }
    }

    private class a implements TextWatcher {

        /* renamed from: b  reason: collision with root package name */
        private final a f21325b;

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public a(a aVar) {
            this.f21325b = aVar;
        }

        public void afterTextChanged(Editable editable) {
            if (editable != null) {
                if (editable.toString().length() == 1) {
                    a aVar = this.f21325b;
                    if (aVar != null) {
                        aVar.a(editable.toString().charAt(0));
                    }
                }
                if (TextUtils.isEmpty(editable.toString())) {
                    a aVar2 = this.f21325b;
                    if (aVar2 != null) {
                        aVar2.a();
                    }
                }
            }
        }
    }
}
