package com.shopee.app.ui.home;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.garena.android.uikit.a.c;
import com.google.android.gms.common.GoogleApiAvailability;
import com.shopee.app.application.ar;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.ChatBadgeStore;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.ax;
import com.shopee.app.data.store.bd;
import com.shopee.app.data.store.theme.ActionBarTheme;
import com.shopee.app.data.viewmodel.FollowCounter;
import com.shopee.app.data.viewmodel.MeCounter;
import com.shopee.app.tracking.a;
import com.shopee.app.tracking.f;
import com.shopee.app.tracking.trackingv3.b;
import com.shopee.app.ui.a.d;
import com.shopee.app.ui.a.r;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.common.au;
import com.shopee.app.ui.dialog.a;
import com.shopee.app.ui.follow.following.FollowingActivity;
import com.shopee.app.ui.home.bottom.BottomNavView;
import com.shopee.app.ui.home.d.g;
import com.shopee.app.ui.home.d.i;
import com.shopee.app.ui.home.q;
import com.shopee.app.upload.UploadManager;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.bi;
import com.shopee.app.util.s;
import com.shopee.app.util.v;
import com.shopee.app.util.x;
import com.shopee.feeds.feedlibrary.activity.SelectPictureActivity;
import com.shopee.id.R;
import com.shopee.sdk.modules.ui.navigator.NavigationPath;

public class m extends RelativeLayout implements c.b, r {
    public i A;
    public g B;
    private int C = 0;
    /* access modifiers changed from: private */
    public boolean D = false;
    private ActionBarTheme E = null;

    /* renamed from: a  reason: collision with root package name */
    c f22268a;

    /* renamed from: b  reason: collision with root package name */
    public BottomNavView f22269b;

    /* renamed from: c  reason: collision with root package name */
    View f22270c;

    /* renamed from: d  reason: collision with root package name */
    ImageView f22271d;

    /* renamed from: e  reason: collision with root package name */
    View f22272e;

    /* renamed from: f  reason: collision with root package name */
    SimpleDraweeView f22273f;

    /* renamed from: g  reason: collision with root package name */
    Activity f22274g;
    UserInfo h;
    i i;
    k j;
    ak k;
    bc l;
    f m;
    UploadManager n;
    SettingConfigStore o;
    a p;
    b q;
    ax r;
    MeCounter s;
    ChatBadgeStore t;
    l u;
    com.shopee.app.ui.common.i v;
    bi w;
    s x;
    bd y;
    FollowCounter z;

    public void a(int i2) {
    }

    public boolean f() {
        return false;
    }

    public au getCurrentWebPage() {
        return null;
    }

    public m(Context context, int i2) {
        super(context);
        setClipChildren(false);
        this.C = i2;
        setId(R.id.home_view);
        ((e) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.l.a(this.i);
        this.i.a(this);
        this.f22269b.setData(this.u.b());
        this.f22269b.setOnNavItemClickListener(new BottomNavView.a() {
            public void a(com.shopee.app.ui.home.bottom.a aVar) {
                a data = aVar.getData();
                if (data != null) {
                    if (m.this.u.c() && m.this.A != null) {
                        m.this.A.a();
                    }
                    if (!a.TAB_SELL.getId().equals(data.getId())) {
                        if (m.this.f22268a.getSelectedIndex() == data.getPos()) {
                            m.this.w.a().f7522b.a(Integer.valueOf(data.getPos())).a();
                        }
                        m.this.f22268a.a(data.getPos(), false);
                    } else if (m.this.h.isLoggedIn()) {
                        m.this.z();
                    } else {
                        com.shopee.app.ui.dialog.a.a(m.this.getContext(), (int) R.string.sp_login_msg_add_product, 0);
                    }
                    if ((a.TAB_HOME_RN.getId().equals(data.getId()) || a.TAB_MALL_RN.getId().equals(data.getId()) || a.TAB_FEED.getId().equals(data.getId())) && m.this.B != null) {
                        m.this.B.c(data.getId());
                    }
                    if (a.TAB_FEED.getId().equals(data.getId())) {
                        m.this.v();
                    }
                    com.shopee.app.ui.home.e.a.f22195a.a(data);
                }
            }
        });
        s();
        t();
        this.f22268a.setAdapter(this.j);
        this.f22268a.getViewPager().setOffscreenPageLimit(4);
        this.f22268a.setScrollLock(true);
        this.v.setShadowTopOffset(0);
        this.f22268a.a();
        this.f22268a.setTabChangeListener(this);
        this.f22268a.setSelectedIndex(this.C);
        if (!this.r.a()) {
            r();
            this.r.a(true);
        }
        d(this.C);
    }

    private void r() {
        if (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(ar.f()) != 0) {
            this.p.b();
        }
    }

    private void s() {
        if (this.u.d()) {
            com.shopee.app.ui.home.bottom.a a2 = this.f22269b.a(2);
            this.f22273f = a2.f22129d;
            this.f22272e = a2.f22126a;
        }
    }

    private void t() {
        u();
    }

    private void u() {
        if (!this.y.b() || !this.x.a("feed")) {
            return;
        }
        if (a.TAB_FEED.getPos() == this.C) {
            this.y.f(false);
            this.f22269b.a(a.TAB_FEED, false);
            return;
        }
        this.f22269b.a(a.TAB_FEED, true);
    }

    /* access modifiers changed from: private */
    public void v() {
        this.z.clearDot();
        this.z.clear();
        this.f22269b.b(a.TAB_FEED, false);
    }

    public void a(final v.a aVar) {
        if (this.f22273f != null) {
            this.D = true;
            this.f22273f.setController(((PipelineDraweeControllerBuilder) ((PipelineDraweeControllerBuilder) Fresco.newDraweeControllerBuilder().setImageRequest(ImageRequestBuilder.newBuilderWithResourceId(this.u.e()).build())).setControllerListener(new BaseControllerListener<ImageInfo>() {
                /* renamed from: a */
                public void onFinalImageSet(String str, ImageInfo imageInfo, Animatable animatable) {
                    super.onFinalImageSet(str, imageInfo, animatable);
                    if (m.this.D) {
                        v.a(animatable, aVar);
                        boolean unused = m.this.D = false;
                    }
                }
            })).build());
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("superState", super.onSaveInstanceState());
        this.C = this.f22268a.getSelectedIndex();
        bundle.putInt("tabPosition", this.C);
        return bundle;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.C = bundle.getInt("tabPosition", 0);
            this.f22268a.setSelectedIndex(this.C);
            parcelable = bundle.getParcelable("superState");
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void e() {
        this.i.e();
    }

    public void b() {
        this.f22268a.b();
        SimpleDraweeView simpleDraweeView = this.f22273f;
        if (simpleDraweeView != null && this.D) {
            simpleDraweeView.setVisibility(0);
            this.f22272e.setVisibility(4);
        }
    }

    public void c() {
        this.f22268a.c();
    }

    public void d() {
        this.f22268a.d();
    }

    public int getCurrentIndex() {
        return this.f22268a.getSelectedIndex();
    }

    /* access modifiers changed from: private */
    public void w() {
        this.k.a(0, this.n, this.h.isBACheckNeeded() && this.o.allowBACheck(), true);
        this.p.c(0);
    }

    /* access modifiers changed from: private */
    public void x() {
        this.k.a(1, this.n, this.h.isBACheckNeeded() && this.o.allowBACheck(), true);
        this.p.c(1);
    }

    /* access modifiers changed from: private */
    public void y() {
        this.k.a(2, this.n, this.h.isBACheckNeeded() && this.o.allowBACheck(), true);
        this.p.c(2);
    }

    public void setSelectedIndex(int i2) {
        if (i2 != 2) {
            this.f22268a.setSelectedIndex(i2);
        } else if (this.u.c()) {
            this.f22268a.setSelectedIndex(i2);
        }
    }

    public void setMeSubTabIndex(int i2) {
        this.j.a(i2);
    }

    public void g() {
        this.k.e();
    }

    public void h() {
        com.shopee.app.ui.dialog.a.a(getContext(), (int) R.string.sp_login_msg_actionbox, 1);
    }

    public void i() {
        com.shopee.app.ui.dialog.a.a(getContext(), (int) R.string.sp_login_msg_shopping_cart, 0);
    }

    public void j() {
        int i2 = this.C;
        if (i2 == 1) {
            A();
        } else if (i2 == 4) {
            B();
        }
    }

    public void k() {
        this.k.u();
    }

    public void l() {
        com.shopee.app.ui.dialog.a.a(getContext(), (int) R.string.sp_no_push_info, (int) R.string.button_cancel, (int) R.string.button_ok, (a.C0318a) new a.C0318a() {
            public void onNegative() {
            }

            public void onPositive() {
                m.this.k.af();
            }
        }, (a.g) new a.g() {
            public void a() {
            }
        });
    }

    public boolean m() {
        return this.f22268a.getSelectedIndex() == 0;
    }

    public boolean n() {
        return this.f22268a.getSelectedIndex() == 1;
    }

    public void a(int i2, int i3) {
        if (i2 != -1) {
            this.p.a(i3);
        }
        this.f22269b.setInactive(i2);
        this.f22269b.setActive(i3);
        if (i3 != this.C) {
            if (a.TAB_ME.getPos() == i3) {
                this.w.a().s.a();
            } else if (a.TAB_FEED.getPos() == i3) {
                v();
            }
        }
        this.C = i3;
        d(this.C);
        u();
    }

    /* access modifiers changed from: package-private */
    public void o() {
        com.shopee.sdk.b.a().e().a(this.f22274g, NavigationPath.a((Class<? extends Activity>) SelectPictureActivity.class));
        this.q.a("create_new_post", "", b.f19172a, "me");
    }

    /* access modifiers changed from: private */
    public void z() {
        com.shopee.app.ui.dialog.a.a(getContext(), com.garena.android.appkit.tools.b.e(R.string.sp_title_action_sheet_sell), new CharSequence[]{getResources().getString(R.string.sp_label_camera), getResources().getString(R.string.sp_label_photos), getResources().getString(R.string.sp_label_instagram)}, (a.c) new a.c() {
            public void a(com.afollestad.materialdialogs.f fVar, View view, int i, CharSequence charSequence) {
                if (i == 0) {
                    m.this.w();
                } else if (i != 1) {
                    m.this.y();
                } else {
                    m.this.x();
                }
            }
        });
    }

    private void A() {
        if (this.h.isLoggedIn()) {
            getContext().startActivity(new Intent(getContext(), FollowingActivity.class));
        } else {
            com.shopee.app.ui.dialog.a.a(getContext(), (int) R.string.sp_login_msg_add_friends, 0);
        }
    }

    private void B() {
        if (this.h.isLoggedIn()) {
            this.k.R();
        } else {
            com.shopee.app.ui.dialog.a.a(getContext(), (int) R.string.sp_login_msg_my_account, 0);
        }
    }

    public void setShowMeTabBadge(boolean z2) {
        this.f22269b.a(z2);
    }

    public int getReactTag() {
        return this.j.b(getCurrentIndex());
    }

    public int b(int i2) {
        return this.j.b(i2);
    }

    private void d(int i2) {
        ActionBarTheme actionBarTheme = this.E;
        int themeType = actionBarTheme != null ? actionBarTheme.getThemeType() : 0;
        ActionBarTheme actionBarTheme2 = this.E;
        String fullStandardBgUrl = actionBarTheme2 != null ? actionBarTheme2.getFullStandardBgUrl() : null;
        d x2 = ((com.shopee.app.ui.a.b) this.f22274g).x();
        this.v.setShadowTopOffset(0);
        if (i2 == 0) {
            x2.e();
            com.shopee.app.util.o.d.a().a(this.f22274g, i2);
        } else if (i2 != 1) {
            if (i2 == 2) {
                q a2 = this.u.a(i2);
                if (a2 instanceof q.b) {
                    x2.b(new a.C0296a().g(themeType).d(fullStandardBgUrl));
                    x2.getActionBar().setTitle(this.u.b(i2));
                    x2.getActionBar().a(false);
                    x2.getActionBar().a("ACTION_BAR_CART_PRIMARY", this.s.getCartCount());
                    x2.getActionBar().a("ACTION_BAR_ACTION_BOX_PRIMARY", this.t.getTotalCount());
                    com.shopee.app.util.o.d.a().a(this.f22274g, x2, themeType);
                } else if (a2 instanceof q.a) {
                    x2.e();
                    com.shopee.app.util.o.d.a().a(this.f22274g, i2);
                }
            } else if (i2 == 3) {
                x2.b(new a.C0296a().g(themeType).d(fullStandardBgUrl));
                x2.getActionBar().setTitle(com.garena.android.appkit.tools.b.e(a.TAB_NOTIFICATION.getTitleResId()));
                x2.getActionBar().a(false);
                x2.getActionBar().a("ACTION_BAR_CART_PRIMARY", this.s.getCartCount());
                x2.getActionBar().a("ACTION_BAR_ACTION_BOX_PRIMARY", this.t.getTotalCount());
                com.shopee.app.util.o.d.a().a(this.f22274g, x2, themeType);
            } else if (i2 == 4) {
                com.shopee.app.util.o.d.a().b(this.f22274g);
                x2.e();
            }
        } else if (this.u.a()) {
            x2.e();
            com.shopee.app.util.o.d.a().a(this.f22274g);
        } else {
            this.v.a(false, false);
            x2.b(new a.C0296a().g(themeType).d(fullStandardBgUrl));
            x2.getActionBar().setTitle(com.garena.android.appkit.tools.b.e(a.TAB_FEED.getTitleResId()));
            x2.getActionBar().a(true);
            x2.getActionBar().a("ACTION_BAR_CART_PRIMARY", this.s.getCartCount());
            x2.getActionBar().a("ACTION_BAR_ACTION_BOX_PRIMARY", this.t.getTotalCount());
            com.shopee.app.util.o.d.a().a(this.f22274g, x2, themeType);
        }
    }

    public void p() {
        SimpleDraweeView simpleDraweeView = this.f22273f;
        if (simpleDraweeView != null) {
            simpleDraweeView.setVisibility(4);
            this.f22272e.setVisibility(0);
        }
    }

    public void q() {
        this.i.e();
    }

    public void a(MeCounter meCounter) {
        try {
            ((com.shopee.app.ui.a.b) this.f22274g).x().getActionBar().a("ACTION_BAR_CART_PRIMARY", meCounter.getCartCount());
        } catch (Exception unused) {
        }
    }

    public void c(int i2) {
        try {
            ((com.shopee.app.ui.a.b) this.f22274g).x().getActionBar().a("ACTION_BAR_ACTION_BOX_PRIMARY", i2);
        } catch (Exception unused) {
        }
    }

    public void a(a aVar, boolean z2) {
        this.f22269b.b(aVar, z2);
    }

    public Activity getActivity() {
        return this.f22274g;
    }

    public void setActionBarTheme(ActionBarTheme actionBarTheme) {
        this.E = actionBarTheme;
        if (this.E != null) {
            d(this.C);
        }
    }
}
