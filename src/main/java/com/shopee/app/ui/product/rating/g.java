package com.shopee.app.ui.product.rating;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import com.appsflyer.share.Constants;
import com.garena.android.uikit.image.browser.GImageBrowserView;
import com.google.a.o;
import com.shopee.app.data.viewmodel.ItemCommentInfo;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.product.rating.j;
import com.shopee.app.util.bc;
import com.shopee.app.util.n;
import com.shopee.app.util.x;
import com.shopee.id.R;
import com.squareup.a.af;
import com.squareup.a.w;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class g extends FrameLayout implements View.OnClickListener, GImageBrowserView.b, j.a {

    /* renamed from: a  reason: collision with root package name */
    GImageBrowserView f24757a;

    /* renamed from: b  reason: collision with root package name */
    ImageButton f24758b;

    /* renamed from: c  reason: collision with root package name */
    TextView f24759c;

    /* renamed from: d  reason: collision with root package name */
    Activity f24760d;

    /* renamed from: e  reason: collision with root package name */
    e f24761e;

    /* renamed from: f  reason: collision with root package name */
    bc f24762f;

    /* renamed from: g  reason: collision with root package name */
    n f24763g;
    r h;
    private final int i;
    private final int j;
    private final boolean k;
    private int l;
    private int m;
    private String n;
    private final long o;
    /* access modifiers changed from: private */
    public List<ItemCommentInfo> p;
    /* access modifiers changed from: private */
    public HashMap<Integer, j> q;
    /* access modifiers changed from: private */
    public boolean r = true;

    public g(Context context, int i2, long j2, int i3, boolean z, int i4, int i5, String str) {
        super(context);
        this.i = i2;
        this.o = j2;
        this.j = i3;
        this.k = z;
        this.l = i4;
        this.m = i5;
        this.n = str;
        ((c) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f24762f.a(this.f24761e);
        this.f24761e.a(this);
        this.p = new ArrayList();
        this.q = new HashMap<>();
        this.f24757a.setBackgroundColor(-16777216);
        this.f24757a.setAdapter(new b());
        this.f24757a.a();
        this.f24757a.setPageChangeListener(this);
        b();
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f24761e.a(this.i, this.o, this.j, this.k, this.l, this.m);
        this.h.b(true);
        this.h.a();
    }

    public void c() {
        j.f24772a = true;
    }

    public void d() {
        if (this.f24757a.getSelectedIndex() < this.p.size()) {
            Intent intent = new Intent();
            intent.putExtra("commentId", this.p.get(this.f24757a.getSelectedIndex()).getCmtId());
            this.f24760d.setResult(-1, intent);
            this.f24760d.finish();
            return;
        }
        this.f24760d.finish();
    }

    public void a(List<ItemCommentInfo> list) {
        this.h.b();
        this.p = new ArrayList(list);
        this.f24757a.a();
        TextView textView = this.f24759c;
        textView.setText((this.f24757a.getSelectedIndex() + 1) + Constants.URL_PATH_DELIMITER + this.p.size());
        for (Map.Entry next : this.q.entrySet()) {
            int intValue = ((Integer) next.getKey()).intValue();
            if (intValue < this.p.size()) {
                ((j) next.getValue()).setData(this.p.get(intValue));
            }
        }
    }

    public void e() {
        for (Map.Entry<Integer, j> value : this.q.entrySet()) {
            ((j) value.getValue()).d();
        }
    }

    public void onClick(View view) {
        this.r = !this.r;
        for (Map.Entry<Integer, j> value : this.q.entrySet()) {
            j jVar = (j) value.getValue();
            if (this.r) {
                a((View) jVar);
                a((View) this.f24758b);
                a((View) this.f24759c);
            } else {
                b((View) jVar);
                b((View) this.f24758b);
                b((View) this.f24759c);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void f() {
        d();
    }

    private void a(final View view) {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.fade_in_animation);
        view.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
                view.setVisibility(0);
            }
        });
    }

    private void b(final View view) {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.fade_out_animation);
        view.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                view.setVisibility(4);
            }
        });
    }

    public void setCurrentIndex(int i2) {
        this.f24757a.setSelectedIndex(i2);
    }

    public void a(int i2, int i3) {
        TextView textView = this.f24759c;
        textView.setText((this.f24757a.getSelectedIndex() + 1) + Constants.URL_PATH_DELIMITER + this.p.size());
        if (i3 >= this.p.size() - 2) {
            this.f24761e.e();
        }
    }

    public void g() {
        o oVar = new o();
        oVar.a("shopID", (Number) Integer.valueOf(this.i));
        oVar.a("itemID", (Number) Long.valueOf(this.o));
        oVar.a("eventID", this.n);
        this.f24763g.a("rating_load_more", new com.garena.android.appkit.b.a(oVar));
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        com.shopee.app.h.r.a().a(str);
    }

    private class b extends com.garena.android.uikit.image.browser.a<ItemCommentInfo> {
        private b() {
        }

        public List<ItemCommentInfo> a() {
            return g.this.p;
        }

        public View a(Context context, int i) {
            j a2 = k.a(context);
            a2.setData((ItemCommentInfo) g.this.p.get(i));
            a2.setToggleListener(g.this);
            a2.setVisibility(g.this.r ? 0 : 4);
            g.this.q.put(Integer.valueOf(i), a2);
            return a2;
        }

        public void a(com.garena.android.uikit.image.c.a aVar, ItemCommentInfo itemCommentInfo, int i) {
            String str = "http://cf.shopee.co.id/file/" + itemCommentInfo.getImages().get(0);
            a aVar2 = new a(aVar, str);
            aVar.setTag(aVar2);
            aVar.a();
            aVar.setImageOnTapListener(g.this);
            double b2 = (double) com.garena.android.appkit.tools.b.b();
            Double.isNaN(b2);
            w.a(g.this.getContext()).a(str).b((int) (b2 * 1.5d), com.garena.android.appkit.tools.b.d()).e().f().a(com.squareup.a.r.NO_CACHE, com.squareup.a.r.NO_STORE).a((af) aVar2);
        }

        public void a(View view, View view2, int i) {
            super.a(view, view2, i);
            g.this.q.remove(Integer.valueOf(i));
        }
    }

    private static class a implements af {

        /* renamed from: a  reason: collision with root package name */
        private final String f24768a;

        /* renamed from: b  reason: collision with root package name */
        private WeakReference<com.garena.android.uikit.image.c.a> f24769b;

        public void a(Drawable drawable) {
        }

        public void b(Drawable drawable) {
        }

        private a(com.garena.android.uikit.image.c.a aVar, String str) {
            this.f24769b = new WeakReference<>(aVar);
            this.f24768a = str;
        }

        public void a(Bitmap bitmap, w.d dVar) {
            com.garena.android.uikit.image.c.a aVar = (com.garena.android.uikit.image.c.a) this.f24769b.get();
            if (aVar != null) {
                aVar.setImageBitmap(bitmap);
            }
        }
    }
}
