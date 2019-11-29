package com.shopee.livequiz.ui.view.keyboard;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.livequiz.c;
import com.shopee.livequiz.c.e;
import com.shopee.livequiz.c.f;
import com.shopee.livequiz.g.g;
import com.shopee.livequiz.ui.view.keyboard.InputMotionLayout;

public class InputMotionLayout extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private RelativeLayout f30043a;

    /* renamed from: b  reason: collision with root package name */
    private RelativeLayout f30044b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f30045c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public EditText f30046d;

    /* renamed from: e  reason: collision with root package name */
    private View f30047e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f30048f;

    /* renamed from: g  reason: collision with root package name */
    private InputMethodManager f30049g;
    private ObjectAnimator h;
    /* access modifiers changed from: private */
    public b i;
    /* access modifiers changed from: private */
    public a j;
    /* access modifiers changed from: private */
    public a k;

    public interface a {
        void a();

        void a(String str);
    }

    public void setListener(a aVar) {
        this.k = aVar;
    }

    public InputMotionLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public InputMotionLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InputMotionLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        View inflate = LayoutInflater.from(context).inflate(c.f.livesdk_shopee_layout_input_motion, this);
        this.f30043a = (RelativeLayout) inflate.findViewById(c.d.rl_out_side);
        this.f30044b = (RelativeLayout) inflate.findViewById(c.d.rl_input_btn);
        this.f30045c = (RelativeLayout) inflate.findViewById(c.d.rl_input_expand);
        this.f30046d = (EditText) inflate.findViewById(c.d.et_danmaku);
        this.f30047e = inflate.findViewById(c.d.confirm_area);
        this.f30048f = (TextView) inflate.findViewById(c.d.tv_chat_here_hint);
        this.f30049g = (InputMethodManager) context.getSystemService("input_method");
        this.f30047e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String trim = InputMotionLayout.this.f30046d.getText().toString().trim();
                if (!TextUtils.isEmpty(trim)) {
                    InputMotionLayout.this.k.a(trim);
                }
                InputMotionLayout.this.f30046d.setText((CharSequence) null);
                InputMotionLayout.this.b();
            }
        });
        this.f30044b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (g.c() || InputMotionLayout.this.k == null) {
                    InputMotionLayout.this.c();
                } else {
                    InputMotionLayout.this.k.a();
                }
            }
        });
        this.f30046d.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (keyEvent == null || 66 != keyEvent.getKeyCode() || keyEvent.getAction() != 0) {
                    return false;
                }
                String trim = InputMotionLayout.this.f30046d.getText().toString().trim();
                if (!TextUtils.isEmpty(trim)) {
                    InputMotionLayout.this.k.a(trim);
                    InputMotionLayout.this.b();
                }
                InputMotionLayout.this.f30046d.setText((CharSequence) null);
                return false;
            }
        });
    }

    public void a(final Activity activity) {
        f.b(new e() {
            public void a() throws Exception {
                b unused = InputMotionLayout.this.i = new b(activity);
                a unused2 = InputMotionLayout.this.j = new a() {
                    public final void onKeyboardHeightChanged(boolean z, int i) {
                        InputMotionLayout.AnonymousClass4.this.a(z, i);
                    }
                };
                InputMotionLayout.this.i.a();
                InputMotionLayout.this.i.a(InputMotionLayout.this.j);
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void a(boolean z, int i) {
                if (z) {
                    InputMotionLayout inputMotionLayout = InputMotionLayout.this;
                    inputMotionLayout.a((View) inputMotionLayout.f30045c, -i);
                    return;
                }
                InputMotionLayout.this.f30045c.setTranslationY(BitmapDescriptorFactory.HUE_RED);
                InputMotionLayout.this.f30045c.setVisibility(8);
            }
        }, 500);
    }

    public void a() {
        b bVar = this.i;
        if (bVar != null) {
            bVar.a((a) null);
            this.i.b();
        }
    }

    public void setText(String str) {
        this.f30046d.setHint(str);
        this.f30048f.setText(str);
    }

    /* access modifiers changed from: private */
    public void b() {
        this.f30049g.hideSoftInputFromWindow(this.f30046d.getWindowToken(), 0);
    }

    /* access modifiers changed from: private */
    public void c() {
        this.f30046d.requestFocus();
        this.f30049g.showSoftInput(this.f30046d, 2);
    }

    /* access modifiers changed from: private */
    public void a(View view, int i2) {
        ObjectAnimator objectAnimator = this.h;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.h.cancel();
        }
        view.setVisibility(0);
        this.h = ObjectAnimator.ofFloat(view, "translationY", new float[]{this.f30045c.getTranslationY(), (float) i2});
        this.h.setDuration(150);
        this.h.start();
    }
}
