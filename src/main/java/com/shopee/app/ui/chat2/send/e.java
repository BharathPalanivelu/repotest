package com.shopee.app.ui.chat2.send;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.garena.android.appkit.tools.b;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.app.ui.common.TagEditText;
import com.shopee.app.ui.common.m;
import com.shopee.app.util.bc;
import com.shopee.app.util.bi;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class e extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    TagEditText f20929a;

    /* renamed from: b  reason: collision with root package name */
    ImageButton f20930b;

    /* renamed from: c  reason: collision with root package name */
    m f20931c;

    /* renamed from: d  reason: collision with root package name */
    ImageView f20932d;

    /* renamed from: e  reason: collision with root package name */
    Animation f20933e;

    /* renamed from: f  reason: collision with root package name */
    Animation f20934f;

    /* renamed from: g  reason: collision with root package name */
    Animation f20935g;
    Animation h;
    d i;
    bc j;
    bi k;
    private boolean l = false;
    private boolean m = false;
    private View.OnClickListener n = new View.OnClickListener() {
        public void onClick(View view) {
            e.this.k.a("CHAT_SEND_CLICK", new com.garena.android.appkit.b.a());
        }
    };
    private View.OnClickListener o = new View.OnClickListener() {
        public void onClick(View view) {
            e.this.k.a("ON_UNBLOCK_USER", new com.garena.android.appkit.b.a());
        }
    };

    public interface a {
        void a(e eVar);
    }

    public e(Context context) {
        super(context);
        a(context);
    }

    public e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public e(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    @TargetApi(21)
    public e(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        a(context);
    }

    private void a(Context context) {
        ((a) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.j.a(this.i);
        this.i.a(this);
        this.f20929a.addTextChangedListener(this.i);
        this.f20931c.setVisibility(0);
        this.f20930b.setEnabled(false);
        this.f20930b.setVisibility(8);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.i.a(this.f20929a.getText().toString(), this.f20929a.getUserTags());
    }

    /* access modifiers changed from: package-private */
    public void c() {
        k();
    }

    /* access modifiers changed from: package-private */
    public void d() {
        if (this.m) {
            this.i.h();
            this.f20932d.setImageResource(R.drawable.ic_chat_emoji);
        } else {
            this.i.g();
            this.f20932d.setImageResource(R.drawable.ic_chat_keyboard);
        }
        this.m = !this.m;
    }

    /* access modifiers changed from: private */
    public void k() {
        if (this.l) {
            this.i.f();
            RotateAnimation rotateAnimation = new RotateAnimation(45.0f, BitmapDescriptorFactory.HUE_RED, (float) (this.f20931c.getWidth() / 2), (float) (this.f20931c.getHeight() / 2));
            rotateAnimation.setDuration(500);
            rotateAnimation.setFillAfter(true);
            this.f20931c.startAnimation(rotateAnimation);
        } else {
            this.i.e();
            RotateAnimation rotateAnimation2 = new RotateAnimation(BitmapDescriptorFactory.HUE_RED, 45.0f, (float) (this.f20931c.getWidth() / 2), (float) (this.f20931c.getHeight() / 2));
            rotateAnimation2.setDuration(500);
            rotateAnimation2.setFillAfter(true);
            this.f20931c.startAnimation(rotateAnimation2);
        }
        this.l = !this.l;
    }

    public EditText getEditText() {
        return this.f20929a;
    }

    public void a(boolean z) {
        if (z) {
            this.f20932d.setVisibility(0);
        } else {
            this.f20932d.setVisibility(8);
        }
    }

    public void a(String str) {
        String str2;
        if (this.f20929a.getText() == null) {
            setText(str);
            return;
        }
        String obj = this.f20929a.getText().toString();
        if (obj.endsWith(SQLBuilder.BLANK) || obj.length() == 0) {
            str2 = obj.concat(str);
        } else {
            str2 = obj.concat(SQLBuilder.BLANK).concat(str);
        }
        setText(str2);
        this.f20929a.setSelection(str2.length());
    }

    public void setText(String str) {
        this.f20929a.setText(str);
    }

    public void e() {
        this.f20929a.setText("");
    }

    public boolean f() {
        return this.f20930b.isEnabled();
    }

    public void b(boolean z) {
        this.f20930b.setEnabled(z);
    }

    public void g() {
        this.f20931c.setClickable(false);
        this.f20930b.startAnimation(this.f20933e);
        this.f20930b.setVisibility(0);
        this.f20931c.startAnimation(this.f20934f);
        this.f20931c.setVisibility(8);
    }

    public void h() {
        this.f20931c.setClickable(true);
        this.f20930b.startAnimation(this.h);
        this.f20930b.setVisibility(8);
        this.f20931c.startAnimation(this.f20935g);
        this.f20931c.setVisibility(0);
    }

    public void c(boolean z) {
        if (z) {
            this.f20929a.setFocusable(true);
            this.f20929a.setFocusableInTouchMode(true);
            this.f20929a.setOnClickListener(this.n);
            this.f20929a.setHint(b.e(R.string.sp_send_message));
            this.f20931c.setColor(b.a(R.color.black65));
            this.f20931c.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    e.this.k();
                }
            });
            this.f20932d.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    e.this.d();
                }
            });
            return;
        }
        this.f20929a.setFocusable(false);
        this.f20929a.setOnClickListener(this.o);
        this.f20931c.setOnClickListener(this.o);
        this.f20929a.setHint("");
        this.f20931c.setColor(b.a(R.color.disable));
        this.f20932d.setOnClickListener(this.o);
    }

    public void i() {
        this.f20929a.setFocusable(false);
        this.f20929a.setOnClickListener((View.OnClickListener) null);
        this.f20931c.setOnClickListener((View.OnClickListener) null);
        this.f20929a.setHint(b.e(R.string.sp_user_banned_or_deleted));
        this.f20931c.setColor(b.a(R.color.disable));
    }

    public void j() {
        this.l = false;
        this.m = false;
        this.f20932d.setImageResource(R.drawable.ic_chat_emoji);
        this.f20931c.clearAnimation();
    }
}
