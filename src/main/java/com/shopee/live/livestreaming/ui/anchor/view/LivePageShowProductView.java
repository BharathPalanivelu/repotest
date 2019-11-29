package com.shopee.live.livestreaming.ui.anchor.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.widget.h;
import com.garena.android.appkit.tools.b;
import com.shopee.live.livestreaming.a.e;
import com.shopee.live.livestreaming.c;
import com.shopee.live.livestreaming.data.entity.SessionProductEntity;
import com.shopee.live.livestreaming.data.store.LiveStreamingStore;
import com.shopee.live.livestreaming.network.service.InjectorUtils;
import com.shopee.live.livestreaming.network.task.UpLoadShowProductTask;
import com.shopee.live.livestreaming.util.ab;
import com.shopee.live.livestreaming.util.d;
import com.shopee.live.livestreaming.util.f;
import com.shopee.live.livestreaming.util.p;
import com.shopee.live.livestreaming.util.q;
import com.shopee.live.livestreaming.util.z;
import com.squareup.a.w;

public class LivePageShowProductView extends e implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    ImageView f28882b;

    /* renamed from: c  reason: collision with root package name */
    TextView f28883c;

    /* renamed from: d  reason: collision with root package name */
    ImageView f28884d;

    /* renamed from: e  reason: collision with root package name */
    RelativeLayout f28885e;

    /* renamed from: f  reason: collision with root package name */
    TextView f28886f;

    /* renamed from: g  reason: collision with root package name */
    LinearLayout f28887g;
    ProgressBar h;
    /* access modifiers changed from: private */
    public int i;
    private String j;
    /* access modifiers changed from: private */
    public LiveStreamingStore k;
    private UpLoadShowProductTask l;
    private SessionProductEntity.ProductItem m;
    /* access modifiers changed from: private */
    public a n;

    public interface a {
        void a();

        void a(int i, long j);
    }

    public LivePageShowProductView(Context context) {
        this(context, (AttributeSet) null);
    }

    public LivePageShowProductView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LivePageShowProductView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.j = "";
        h();
    }

    /* access modifiers changed from: protected */
    public int a() {
        return c.f.live_streaming_layout_show_product;
    }

    public void onClick(View view) {
        if (view.getId() == c.e.iv_product_show_close) {
            g();
        } else if (view.getId() == c.e.iv_show_product) {
            f();
        }
    }

    private void h() {
        this.f28882b = (ImageView) a(c.e.iv_show_product, this);
        this.f28883c = (TextView) a(c.e.tv_show_product_price);
        this.f28884d = (ImageView) a(c.e.iv_product_show_close, this);
        this.f28885e = (RelativeLayout) a(c.e.rl_show_product);
        this.f28886f = (TextView) a(c.e.tv_show_product_default);
        this.f28887g = (LinearLayout) a(c.e.ll_show_product_default);
        this.h = (ProgressBar) a(c.e.loading_progress);
        this.f28886f.setText(b.e(c.g.live_streaming_host_preview_no_product_shown));
        this.k = com.shopee.live.livestreaming.b.b().a();
        this.l = InjectorUtils.provideUpLoadShowProductTask();
    }

    public void b() {
        this.i = 17;
        if (this.m != null) {
            this.f28885e.setVisibility(0);
            this.f28887g.setVisibility(8);
        } else {
            this.f28885e.setVisibility(8);
            this.f28887g.setVisibility(0);
        }
        this.f28884d.setVisibility(0);
    }

    public void c() {
        this.i = 18;
        this.f28887g.setVisibility(8);
        this.f28884d.setVisibility(0);
    }

    public void d() {
        this.i = 20;
        this.f28887g.setVisibility(8);
        this.f28884d.setVisibility(8);
    }

    public void a(SessionProductEntity.ProductItem productItem) {
        this.m = productItem;
        if (productItem == null) {
            this.f28885e.setVisibility(8);
        } else if (d.a(productItem.getImage()) || productItem.getShop_id() <= 0 || productItem.getItem_id() <= 0) {
            this.f28885e.setVisibility(8);
        } else {
            if (!this.j.equals(productItem.getImage())) {
                this.j = productItem.getImage();
                w.a(getContext()).a(p.a(this.j)).a(c.d.live_streaming_ic_show_product_default).b(c.d.live_streaming_ic_show_product_default).a(this.f28882b);
            }
            String a2 = ab.a();
            if (!d.a(productItem.getPrice())) {
                TextView textView = this.f28883c;
                textView.setText(a2 + ab.a(productItem.getPrice()));
            } else if (!d.a(productItem.getPrice_before_discount())) {
                TextView textView2 = this.f28883c;
                textView2.setText(a2 + ab.a(productItem.getPrice_before_discount()));
            } else {
                TextView textView3 = this.f28883c;
                textView3.setText(a2 + ab.a(productItem.getPrice_min()));
            }
            if (this.f28885e.getVisibility() == 8 && this.i == 20) {
                com.shopee.live.livestreaming.ui.audience.c.a(productItem.getItem_id(), productItem.getShop_id());
            }
            this.f28885e.setVisibility(0);
        }
    }

    public void e() {
        if (!this.k.hasShow()) {
            this.f28887g.post(new Runnable() {
                public void run() {
                    h.a(new com.shopee.live.livestreaming.ui.view.c.h(com.shopee.live.livestreaming.b.b().c()), LivePageShowProductView.this.f28887g, 0, 0, 8388611);
                    LivePageShowProductView.this.k.setShowStatus(1);
                }
            });
        }
    }

    public void b(SessionProductEntity.ProductItem productItem) {
        this.m = productItem;
        this.f28887g.setVisibility(8);
        if (this.f28885e.getVisibility() == 8 && this.i == 20) {
            com.shopee.live.livestreaming.ui.audience.c.a(productItem.getItem_id(), productItem.getShop_id());
        }
        this.f28885e.setVisibility(0);
        if (!d.a(productItem.getImage())) {
            w.a(getContext()).a(p.a(productItem.getImage())).a(c.d.live_streaming_ic_show_product_default).b(c.d.live_streaming_ic_show_product_default).a(this.f28882b);
        } else {
            this.f28882b.setImageResource(c.d.live_streaming_ic_show_product_default);
        }
        String a2 = ab.a();
        if (!d.a(productItem.getPrice())) {
            TextView textView = this.f28883c;
            textView.setText(a2 + ab.a(productItem.getPrice()));
        } else if (!d.a(productItem.getPrice_before_discount())) {
            TextView textView2 = this.f28883c;
            textView2.setText(a2 + ab.a(productItem.getPrice_before_discount()));
        } else {
            TextView textView3 = this.f28883c;
            textView3.setText(a2 + ab.a(productItem.getPrice_min()));
        }
    }

    /* access modifiers changed from: protected */
    public void f() {
        a aVar = this.n;
        if (aVar != null) {
            SessionProductEntity.ProductItem productItem = this.m;
            if (productItem != null) {
                aVar.a(productItem.getShop_id(), this.m.getItem_id());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void g() {
        this.f28884d.setVisibility(8);
        this.h.setVisibility(0);
        this.l.execute(new UpLoadShowProductTask.Data(f.a().f(), (SessionProductEntity.ProductItem) null), new UpLoadShowProductTask.Callback() {
            public void upLoadSuccess() {
                LivePageShowProductView.this.f28884d.setVisibility(0);
                LivePageShowProductView.this.h.setVisibility(8);
                if (q.a(LivePageShowProductView.this.i)) {
                    LivePageShowProductView.this.f28885e.setVisibility(8);
                    LivePageShowProductView.this.f28887g.setVisibility(0);
                } else if (q.b(LivePageShowProductView.this.i)) {
                    LivePageShowProductView.this.f28885e.setVisibility(8);
                    LivePageShowProductView.this.f28887g.setVisibility(8);
                }
                if (LivePageShowProductView.this.n != null) {
                    LivePageShowProductView.this.n.a();
                }
            }

            public void onError(int i, String str) {
                LivePageShowProductView.this.f28884d.setVisibility(0);
                LivePageShowProductView.this.h.setVisibility(8);
                if (!d.a(str)) {
                    z.a(LivePageShowProductView.this.getContext(), str);
                }
            }
        });
    }

    public void setLiveMode(int i2) {
        this.i = i2;
    }

    public void setClickListener(a aVar) {
        this.n = aVar;
    }
}
