package com.shopee.live.livestreaming.ui.view;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.garena.android.appkit.tools.b;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.live.livestreaming.c;

public class f extends Dialog {

    /* renamed from: e  reason: collision with root package name */
    private static final String f29332e = "f";
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f29333a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f29334b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f29335c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public EditText f29336d;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Context f29337f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public InputMethodManager f29338g;
    private RelativeLayout h;
    /* access modifiers changed from: private */
    public int i = 0;
    private LinearLayout j;
    /* access modifiers changed from: private */
    public a k;
    /* access modifiers changed from: private */
    public boolean l = false;
    private long m = 50;

    public interface a {
        void a(String str, boolean z);
    }

    public f(Context context, int i2) {
        super(context, i2);
        this.f29337f = context;
        setContentView(c.f.live_streaming_dialog_input_text);
        this.f29336d = (EditText) findViewById(c.e.et_input_message);
        this.f29336d.getBackground().setColorFilter(b.a(c.b.transparent), PorterDuff.Mode.CLEAR);
        this.f29336d.setHint(b.e(c.g.live_streaming_viewer_msg_input_placeholder));
        this.f29334b = (ImageView) findViewById(c.e.confrim_btn);
        this.f29338g = (InputMethodManager) this.f29337f.getSystemService("input_method");
        this.f29334b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String trim = f.this.f29336d.getText().toString().trim();
                if (!TextUtils.isEmpty(trim)) {
                    f.this.k.a(trim, f.this.l);
                    f.this.f29338g.showSoftInput(f.this.f29336d, 2);
                    f.this.f29338g.hideSoftInputFromWindow(f.this.f29336d.getWindowToken(), 0);
                    f.this.f29336d.setText("");
                    f.this.dismiss();
                } else {
                    Toast.makeText(f.this.f29337f, "input can not be empty!", 1).show();
                }
                f.this.f29336d.setText((CharSequence) null);
            }
        });
        ((Button) findViewById(c.e.barrage_btn)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                f fVar = f.this;
                boolean unused = fVar.l = !fVar.l;
            }
        });
        this.f29335c = (LinearLayout) findViewById(c.e.barrage_area);
        this.f29335c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                f fVar = f.this;
                boolean unused = fVar.l = !fVar.l;
            }
        });
        this.f29336d.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (keyEvent != null && 66 == keyEvent.getKeyCode() && keyEvent.getAction() == 0) {
                    String trim = f.this.f29336d.getText().toString().trim();
                    if (!TextUtils.isEmpty(trim)) {
                        f.this.k.a(trim, f.this.l);
                        f.this.f29338g.showSoftInput(f.this.f29336d, 2);
                        f.this.f29338g.hideSoftInputFromWindow(f.this.f29336d.getWindowToken(), 0);
                        f.this.f29336d.setText("");
                        f.this.dismiss();
                    } else {
                        Toast.makeText(f.this.f29337f, "input can not be empty!", 1).show();
                    }
                    f.this.f29336d.setText((CharSequence) null);
                }
                return false;
            }
        });
        this.j = (LinearLayout) findViewById(c.e.confirm_area);
        this.j.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String trim = f.this.f29336d.getText().toString().trim();
                if (!TextUtils.isEmpty(trim)) {
                    f.this.k.a(trim, f.this.l);
                    f.this.f29338g.showSoftInput(f.this.f29336d, 2);
                    f.this.f29338g.hideSoftInputFromWindow(f.this.f29336d.getWindowToken(), 0);
                    f.this.f29336d.setText("");
                    f.this.dismiss();
                } else {
                    Toast.makeText(f.this.f29337f, "input can not be empty!", 1).show();
                }
                f.this.f29336d.setText((CharSequence) null);
            }
        });
        this.f29336d.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                Log.d("My test", "onKey " + keyEvent.getCharacters());
                return false;
            }
        });
        this.h = (RelativeLayout) findViewById(c.e.rl_outside_view);
        this.h.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (view.getId() != c.e.rl_inputdlg_view) {
                    f.this.dismiss();
                }
            }
        });
        this.f29333a = (LinearLayout) findViewById(c.e.rl_inputdlg_view);
        this.f29333a.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                Rect rect = new Rect();
                f.this.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int height = f.this.getWindow().getDecorView().getRootView().getHeight() - rect.bottom;
                if (height <= 0 && f.this.i > 0) {
                    f.this.f29338g.hideSoftInputFromWindow(f.this.f29336d.getWindowToken(), 0);
                    f.this.dismiss();
                }
                int unused = f.this.i = height;
            }
        });
        this.f29333a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                f.this.f29338g.hideSoftInputFromWindow(f.this.f29336d.getWindowToken(), 0);
                f.this.dismiss();
            }
        });
    }

    public void a(a aVar) {
        this.k = aVar;
    }

    public void dismiss() {
        this.f29338g.hideSoftInputFromWindow(this.f29336d.getWindowToken(), 0);
        super.dismiss();
        this.i = 0;
    }

    public void show() {
        super.show();
        this.f29336d.requestFocus();
        LinearLayout linearLayout = this.f29333a;
        if (linearLayout != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(linearLayout, "alpha", new float[]{BitmapDescriptorFactory.HUE_RED, 1.0f});
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (Build.VERSION.SDK_INT >= 18) {
                        f.this.f29333a.setClipBounds(new Rect(0, f.this.f29333a.getMeasuredHeight() - ((int) (((float) f.this.f29333a.getMeasuredHeight()) * valueAnimator.getAnimatedFraction())), f.this.f29333a.getMeasuredWidth(), f.this.f29333a.getMeasuredHeight()));
                    }
                }
            });
            ofFloat.setDuration(this.m);
            ofFloat.start();
        }
    }

    public void a(long j2) {
        if (j2 > 0) {
            this.m = j2;
        }
    }
}
