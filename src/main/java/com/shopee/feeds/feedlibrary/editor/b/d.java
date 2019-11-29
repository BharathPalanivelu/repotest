package com.shopee.feeds.feedlibrary.editor.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.data.entity.SaveProductEntity;
import com.shopee.feeds.feedlibrary.editor.multitouch.Vector2D;
import com.shopee.feeds.feedlibrary.editor.multitouch.b;
import com.shopee.feeds.feedlibrary.editor.sticker.CommentStickerItemView;
import com.shopee.feeds.feedlibrary.editor.sticker.e;
import com.shopee.feeds.feedlibrary.editor.tag.c;
import com.shopee.feeds.feedlibrary.util.h;
import com.shopee.feeds.feedlibrary.util.j;
import com.shopee.feeds.feedlibrary.util.k;
import com.shopee.feeds.feedlibrary.view.CommonCheckButton;

public abstract class d<V extends View> extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    protected RelativeLayout f27926a;
    /* access modifiers changed from: protected */

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f27927b;
    /* access modifiers changed from: protected */

    /* renamed from: c  reason: collision with root package name */
    public V f27928c;

    /* renamed from: d  reason: collision with root package name */
    protected View f27929d;

    /* renamed from: e  reason: collision with root package name */
    protected RelativeLayout f27930e;

    /* renamed from: f  reason: collision with root package name */
    protected TextView f27931f;

    /* renamed from: g  reason: collision with root package name */
    protected ImageView f27932g;
    protected CommonCheckButton h;
    /* access modifiers changed from: protected */
    public String i;
    /* access modifiers changed from: protected */
    public c j;
    protected com.shopee.feeds.feedlibrary.editor.text.c k;
    protected com.shopee.feeds.feedlibrary.editor.sticker.d l;
    /* access modifiers changed from: private */
    public boolean m;
    /* access modifiers changed from: private */
    public float n;
    private float o;
    private float p;
    /* access modifiers changed from: private */
    public com.shopee.feeds.feedlibrary.editor.multitouch.b q;
    private GestureDetector r;
    /* access modifiers changed from: private */
    public float s;
    /* access modifiers changed from: private */
    public float t;

    public interface a {
        void a();
    }

    /* access modifiers changed from: protected */
    public abstract void a();

    public abstract void a(SaveProductEntity saveProductEntity);

    public abstract void b();

    public abstract int getSourceMode();

    public abstract V getSourceView();

    public d(Context context) {
        this(context, (AttributeSet) null);
    }

    public d(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public d(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.m = false;
        this.o = -1.0f;
        this.p = -1.0f;
        this.q = null;
        this.r = null;
        a(context);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void a(final Context context) {
        this.j = new c(this, new c.a() {
            public void a() {
                d.this.c();
            }
        });
        this.k = new com.shopee.feeds.feedlibrary.editor.text.c(this);
        this.l = new com.shopee.feeds.feedlibrary.editor.sticker.d(this);
        LayoutInflater.from(context).inflate(c.f.feeds_layout_editor_base_layer, this, true);
        this.f27926a = (RelativeLayout) findViewById(c.e.video_parent);
        this.f27927b = (RelativeLayout) findViewById(c.e.photo_parent);
        this.f27929d = findViewById(c.e.rl_delete);
        this.f27930e = (RelativeLayout) findViewById(c.e.rl_tag_logo);
        this.f27931f = (TextView) findViewById(c.e.tv_tag_logo_num);
        this.f27932g = (ImageView) findViewById(c.e.iv_tag_logo_arrow);
        this.h = (CommonCheckButton) findViewById(c.e.checkbox_mute);
        a();
        this.f27927b.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (d.this.q != null) {
                    d.this.q.a(view, motionEvent);
                }
                if (action == 0) {
                    float unused = d.this.n = motionEvent.getX();
                    float unused2 = d.this.s = motionEvent.getRawX();
                    float unused3 = d.this.t = motionEvent.getRawY();
                    boolean unused4 = d.this.m = true;
                } else if (action == 2) {
                    boolean unused5 = d.this.m = Math.abs(motionEvent.getX() - d.this.n) <= 10.0f;
                    com.garena.android.appkit.d.a.b("%s", "db onMove .");
                    com.shopee.feeds.feedlibrary.editor.multitouch.a e2 = d.this.getStickerEditor().e();
                    if (e2 != null) {
                        e2.a(d.this.s, d.this.t, motionEvent.getRawX() - d.this.s, motionEvent.getRawY() - d.this.t, context);
                    }
                    return false;
                } else if (action != 1 || !d.this.m || j.a().w()) {
                    return true;
                } else {
                    d.this.a(motionEvent.getX(), motionEvent.getY());
                    d.this.b();
                }
                return true;
            }
        });
        this.q = new com.shopee.feeds.feedlibrary.editor.multitouch.b(new b());
        if (Build.VERSION.SDK_INT >= 21) {
            this.f27930e.setTranslationZ(3.0f);
            this.h.setTranslationZ(3.0f);
            this.f27930e.setOutlineProvider((ViewOutlineProvider) null);
        }
    }

    private class b extends b.C0431b {

        /* renamed from: b  reason: collision with root package name */
        private Vector2D f27937b;

        private b() {
            this.f27937b = new Vector2D();
        }

        public boolean a(View view, com.shopee.feeds.feedlibrary.editor.multitouch.b bVar) {
            this.f27937b.set(bVar.d());
            return true;
        }

        public boolean b(View view, com.shopee.feeds.feedlibrary.editor.multitouch.b bVar) {
            com.garena.android.appkit.d.a.b("%s", "db onScale " + bVar.e());
            com.shopee.feeds.feedlibrary.editor.multitouch.a e2 = d.this.getStickerEditor().e();
            if (e2 != null) {
                e2.a(bVar.e(), Vector2D.a(this.f27937b, bVar.d()));
            }
            return false;
        }
    }

    public com.shopee.feeds.feedlibrary.editor.tag.c getTagEditor() {
        return this.j;
    }

    public com.shopee.feeds.feedlibrary.editor.text.c getTextEditor() {
        return this.k;
    }

    public com.shopee.feeds.feedlibrary.editor.sticker.d getStickerEditor() {
        return this.l;
    }

    public RelativeLayout getItemContainer() {
        return this.f27927b;
    }

    public View getDeleteView() {
        return this.f27929d;
    }

    public String getPath() {
        String str = this.i;
        return str == null ? "" : str;
    }

    public void a(float f2, float f3) {
        this.o = f2;
        this.p = f3;
    }

    public float getTapX() {
        return this.o;
    }

    public float getTapY() {
        return this.p;
    }

    public boolean k() {
        return this.j.e();
    }

    public void a(View view, ViewGroup.LayoutParams layoutParams) {
        this.f27927b.addView(view, layoutParams);
    }

    public RelativeLayout getPhotoParentView() {
        return this.f27927b;
    }

    /* access modifiers changed from: protected */
    public boolean l() {
        return androidx.core.content.b.b(getContext(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    /* access modifiers changed from: protected */
    public void g() {
        h.b("", "Photo Edit : clean child start hide -- " + k.g(this.i));
        this.f27930e.setVisibility(8);
        for (int i2 = 0; i2 < this.f27927b.getChildCount(); i2++) {
            View childAt = this.f27927b.getChildAt(i2);
            if ((childAt instanceof com.shopee.feeds.feedlibrary.editor.tag.d) || (childAt instanceof CommentStickerItemView) || (childAt instanceof e) || (childAt instanceof com.shopee.feeds.feedlibrary.editor.sticker.c) || (childAt instanceof com.shopee.feeds.feedlibrary.editor.sticker.a)) {
                childAt.setVisibility(8);
                h.b("", "Photo Edit : hide view when clean child -- " + k.g(this.i));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void m() {
        h.b("", "Photo Edit : save album start hide -- " + k.g(this.i));
        this.f27930e.setVisibility(8);
        for (int i2 = 0; i2 < this.f27927b.getChildCount(); i2++) {
            View childAt = this.f27927b.getChildAt(i2);
            if ((childAt instanceof com.shopee.feeds.feedlibrary.editor.tag.d) || (childAt instanceof CommentStickerItemView) || (childAt instanceof e) || (childAt instanceof com.shopee.feeds.feedlibrary.editor.sticker.c)) {
                h.b("", "Photo Edit : hide view when save album -- " + k.g(this.i));
                childAt.setVisibility(8);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void n() {
        for (int i2 = 0; i2 < this.f27927b.getChildCount(); i2++) {
            View childAt = this.f27927b.getChildAt(i2);
            if (childAt instanceof com.shopee.feeds.feedlibrary.editor.tag.d) {
                ((com.shopee.feeds.feedlibrary.editor.tag.d) childAt).b(false);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void h() {
        h.b("", "Photo Edit : clean child start resume..." + k.g(this.i));
        c();
        for (int i2 = 0; i2 < this.f27927b.getChildCount(); i2++) {
            View childAt = this.f27927b.getChildAt(i2);
            if ((childAt instanceof com.shopee.feeds.feedlibrary.editor.tag.d) || (childAt instanceof CommentStickerItemView) || (childAt instanceof e) || (childAt instanceof com.shopee.feeds.feedlibrary.editor.sticker.c) || (childAt instanceof com.shopee.feeds.feedlibrary.editor.sticker.a)) {
                h.b("", "Photo Edit : resume view when clean child.." + k.g(this.i));
                childAt.setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void o() {
        h.b("", "Photo Edit : save album start resume..." + k.g(this.i));
        c();
        for (int i2 = 0; i2 < this.f27927b.getChildCount(); i2++) {
            View childAt = this.f27927b.getChildAt(i2);
            if ((childAt instanceof com.shopee.feeds.feedlibrary.editor.tag.d) || (childAt instanceof CommentStickerItemView) || (childAt instanceof e) || (childAt instanceof com.shopee.feeds.feedlibrary.editor.sticker.c)) {
                h.b("", "Photo Edit : resume view when save album.." + k.g(this.i));
                childAt.setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void c() {
        if (getTagEditor().f27915d.size() > 0) {
            this.f27930e.setVisibility(0);
        } else {
            this.f27930e.setVisibility(8);
        }
    }

    public void p() {
        this.f27930e.setVisibility(0);
        this.f27931f.setVisibility(8);
        this.f27932g.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public boolean q() {
        return this.j.a().isEmpty() && this.k.a().isEmpty() && this.l.a().isEmpty();
    }
}
