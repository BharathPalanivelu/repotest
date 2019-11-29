package com.shopee.app.ui.product.newsearch;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.garena.android.appkit.b.i;
import com.garena.android.appkit.tools.b;
import com.garena.android.uikit.a.c;
import com.shopee.app.camera.ImageSearchHint;
import com.shopee.app.ui.a.r;
import com.shopee.app.ui.common.MaterialTabView;
import com.shopee.app.ui.common.ao;
import com.shopee.app.ui.common.ap;
import com.shopee.app.util.ak;
import com.shopee.app.util.s;
import com.shopee.app.util.x;
import com.shopee.app.web.protocol.SearchConfig;
import com.shopee.id.R;
import com.tencent.ijk.media.player.IjkMediaCodecInfo;

public class f extends FrameLayout implements c.b, r {
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final String[] f24696g = {b.e(R.string.sp_label_products), b.e(R.string.sp_label_users), b.e(R.string.sp_label_hashtags)};

    /* renamed from: a  reason: collision with root package name */
    MaterialTabView f24697a;

    /* renamed from: b  reason: collision with root package name */
    ImageSearchHint f24698b;

    /* renamed from: c  reason: collision with root package name */
    com.shopee.app.ui.actionbar.a f24699c;

    /* renamed from: d  reason: collision with root package name */
    com.shopee.app.tracking.a f24700d;

    /* renamed from: e  reason: collision with root package name */
    s f24701e;

    /* renamed from: f  reason: collision with root package name */
    ak f24702f;
    /* access modifiers changed from: private */
    public final boolean[] h;
    /* access modifiers changed from: private */
    public final int[] i;
    private final i j;
    /* access modifiers changed from: private */
    public final SearchConfig k;
    /* access modifiers changed from: private */
    public final String l;
    /* access modifiers changed from: private */
    public final int m;

    public void a(int i2) {
    }

    public f(Context context, String str, SearchConfig searchConfig, int i2) {
        super(context);
        this.k = searchConfig;
        this.l = str;
        this.h = b(searchConfig.isGlobalSearch() ? 1 : searchConfig.getSearchType());
        this.m = i2;
        this.i = new int[4];
        this.j = com.garena.a.a.a.b.a(this);
        ((e) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.j.a();
        a aVar = new a();
        this.f24697a.setAdapter(aVar);
        boolean z = true;
        int i2 = 0;
        if (getTabShownCount() > 1) {
            this.f24697a.setTabIndicator(new ap(aVar.b()));
        } else {
            this.f24697a.setShadowOffset(0);
        }
        this.f24697a.a();
        this.f24697a.setTabChangeListener(this);
        com.garena.android.appkit.f.f.a().a(new Runnable() {
            public void run() {
                View findViewById = f.this.f24699c.findViewById(R.id.search_edit);
                if (findViewById != null) {
                    com.shopee.app.c.a.b(findViewById);
                }
            }
        }, IjkMediaCodecInfo.RANK_LAST_CHANCE);
        if (!this.f24701e.a("image_search") || this.k.getSearchType() != 0) {
            z = false;
        }
        ImageSearchHint imageSearchHint = this.f24698b;
        if (!z) {
            i2 = 8;
        }
        imageSearchHint.setVisibility(i2);
        if (z) {
            this.f24698b.a();
        }
    }

    public void a(int i2, int i3) {
        if (i3 == 0) {
            String a2 = com.shopee.app.ui.follow.search.f.a(this.k);
            if (!TextUtils.isEmpty(a2)) {
                this.f24699c.setSearchPlaceholder(a2);
            } else if (TextUtils.isEmpty(this.k.getSearchPlaceholderActive())) {
                this.f24699c.setSearchPlaceholder(b.e(R.string.sp_search_products_and_shops));
            } else {
                this.f24699c.setSearchPlaceholder(this.k.getSearchPlaceholderActive());
            }
        } else if (i3 == 1) {
            this.f24699c.setSearchPlaceholder(b.e(R.string.sp_search_user));
        } else {
            this.f24699c.setSearchPlaceholder(b.e(R.string.sp_search_hashtags));
        }
    }

    public void b() {
        this.j.c();
        this.f24697a.b();
    }

    public void c() {
        com.shopee.app.c.a.a(getContext());
        this.j.d();
        this.f24697a.c();
    }

    public void d() {
        this.j.b();
        this.f24697a.d();
    }

    public void setSelectedIndex(int i2) {
        this.f24697a.setSelectedIndex(i2);
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        if (!TextUtils.isEmpty(str) && str.length() == 1 && str.charAt(0) == '#') {
            this.f24697a.setSelectedIndex(this.i[2]);
        }
    }

    public int getTabShownCount() {
        int i2 = 0;
        for (boolean z : this.h) {
            if (z) {
                i2++;
            }
        }
        return i2;
    }

    private boolean[] b(int i2) {
        boolean[] zArr = new boolean[4];
        for (int i3 = 3; i3 >= 0; i3--) {
            boolean z = true;
            if (((1 << i3) & i2) == 0) {
                z = false;
            }
            zArr[i3] = z;
        }
        return zArr;
    }

    /* access modifiers changed from: package-private */
    public void e() {
        this.f24702f.w(this.f24698b.getImage());
    }

    private class a extends com.garena.android.uikit.a.a {
        public View a(Context context) {
            return null;
        }

        private a() {
        }

        public int b() {
            return f.this.getTabShownCount();
        }

        public com.garena.android.uikit.a.a.b d(Context context, int i) {
            ao aoVar = new ao(context, f.f24696g[i]);
            aoVar.setTitle(f.f24696g[i]);
            if (b() <= 1) {
                aoVar.setVisibility(8);
            }
            return aoVar;
        }

        public com.garena.android.uikit.a.a.a e(Context context, int i) {
            if (f.this.h[2]) {
                com.garena.b.a.a.b("Deprecated", "Hashtag search is not supported anymore!");
            }
            com.garena.android.uikit.a.a.a aVar = null;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (f.this.h[3]) {
                            aVar = com.shopee.app.ui.product.newsearch.a.c.a(context, f.this.l, f.this.k);
                            f.this.i[3] = 3;
                        }
                    } else if (f.this.h[2]) {
                        f.this.i[2] = 2;
                    } else if (f.this.h[3]) {
                        aVar = com.shopee.app.ui.product.newsearch.a.c.a(context, f.this.l, f.this.k);
                        f.this.i[3] = 2;
                    }
                } else if (f.this.h[1]) {
                    aVar = com.shopee.app.ui.product.newsearch.a.i.a(context, f.this.l, f.this.k.isOfficialShopOnly());
                    f.this.i[1] = 1;
                } else if (f.this.h[2]) {
                    f.this.i[2] = 1;
                } else if (f.this.h[3]) {
                    aVar = com.shopee.app.ui.product.newsearch.a.c.a(context, f.this.l, f.this.k);
                    f.this.i[3] = 1;
                }
            } else if (f.this.h[0]) {
                aVar = com.shopee.app.ui.product.newsearch.a.f.a(context, f.this.l, f.this.k, f.this.m);
                f.this.i[0] = 0;
            } else if (f.this.h[1]) {
                aVar = com.shopee.app.ui.product.newsearch.a.i.a(context, f.this.l, f.this.k.isOfficialShopOnly());
                f.this.i[1] = 0;
            } else if (f.this.h[2]) {
                f.this.i[2] = 0;
            } else if (f.this.h[3]) {
                aVar = com.shopee.app.ui.product.newsearch.a.c.a(context, f.this.l, f.this.k);
                f.this.i[3] = 0;
            }
            return aVar == null ? new com.shopee.app.ui.e.a(context) : aVar;
        }
    }
}
