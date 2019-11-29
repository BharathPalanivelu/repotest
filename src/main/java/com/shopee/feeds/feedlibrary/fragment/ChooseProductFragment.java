package com.shopee.feeds.feedlibrary.fragment;

import a.h;
import a.k;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.devspark.robototextview.widget.RobotoTextView;
import com.garena.android.appkit.f.f;
import com.google.android.material.tabs.TabLayout;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.data.d.b;
import com.shopee.feeds.feedlibrary.data.entity.DownloadImgEvent;
import com.shopee.feeds.feedlibrary.data.entity.ModeChangeEntity;
import com.shopee.feeds.feedlibrary.data.entity.OriginImageInfo;
import com.shopee.feeds.feedlibrary.data.entity.ProductEntity;
import com.shopee.feeds.feedlibrary.fragment.BaseProductFragment;
import com.shopee.feeds.feedlibrary.util.d;
import com.shopee.feeds.feedlibrary.util.d.c;
import com.shopee.feeds.feedlibrary.util.j;
import com.shopee.feeds.feedlibrary.util.o;
import com.shopee.feeds.feedlibrary.util.q;
import com.shopee.feeds.feedlibrary.util.t;
import com.shopee.feeds.feedlibrary.util.v;
import com.shopee.feeds.feedlibrary.view.StickyNavLayout;
import com.shopee.feeds.feedlibrary.view.easyviewpager.CustomScrollViewPager;
import com.shopee.feeds.feedlibrary.view.preview.ContainerLayout;
import com.shopee.feeds.feedlibrary.view.preview.a;
import com.shopee.feeds.feedlibrary.view.preview.e;
import com.squareup.a.w;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.m;

public class ChooseProductFragment extends a {
    @BindView
    RobotoTextView btnTopBack;

    /* renamed from: d  reason: collision with root package name */
    c f7116d;

    /* renamed from: e  reason: collision with root package name */
    d f7117e;

    /* renamed from: f  reason: collision with root package name */
    c f7118f;

    /* renamed from: g  reason: collision with root package name */
    b f7119g;
    private View h;
    /* access modifiers changed from: private */
    public boolean i = true;
    @BindView
    TabLayout idStickynavlayoutIndicator;
    @BindView
    FrameLayout idStickynavlayoutTopview;
    @BindView
    CustomScrollViewPager idStickynavlayoutViewpager;
    @BindView
    ImageView ivLeft;
    @BindView
    ImageView ivRight;
    private boolean j = true;
    /* access modifiers changed from: private */
    public e k;
    /* access modifiers changed from: private */
    public a l;
    @BindView
    LinearLayout llMainChoose;
    @BindView
    RelativeLayout llTitleLayout;
    /* access modifiers changed from: private */
    public LinkedHashMap<String, String> m;
    @BindView
    ContainerLayout mContainer;
    @BindView
    ImageView mIvEnlarge;
    @BindView
    ImageView mIvMulti;
    @BindView
    View mViewBlank;
    @BindView
    ContainerLayout mViewShelter;
    private boolean n = true;
    private int o;
    /* access modifiers changed from: private */
    public o p;
    private LinkedHashMap<Integer, ProductEntity.ProductItem> q = new LinkedHashMap<>();
    /* access modifiers changed from: private */
    public LinkedHashMap<String, ArrayList<com.shopee.feeds.feedlibrary.editor.tag.a>> r = new LinkedHashMap<>();
    private boolean s = false;
    @BindView
    StickyNavLayout sticky_navlayout;
    private boolean t = false;
    @BindView
    RobotoTextView tvRight;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.h = LayoutInflater.from(getContext()).inflate(c.f.feeds_fragment_choose_product, viewGroup, false);
        ButterKnife.a(this, this.h);
        org.greenrobot.eventbus.c.a().a((Object) this);
        this.s = true;
        c();
        this.f7119g = com.shopee.feeds.feedlibrary.b.b().a();
        return this.h;
    }

    private void c() {
        d();
        this.mContainer.setmScale(true);
        this.k = new e(getContext(), this.mContainer, this.mIvMulti, this.mIvEnlarge, (ImageView) null);
        this.p = new o(getActivity(), this.tvRight);
        this.mIvEnlarge.setVisibility(4);
    }

    private void d() {
        this.btnTopBack.setText(com.garena.android.appkit.tools.b.e(c.g.feeds_nav_bar_title_select_product));
        this.tvRight.setVisibility(0);
        this.tvRight.setText(com.garena.android.appkit.tools.b.e(c.g.feeds_button_next));
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        j();
    }

    @OnClick
    public void onBackClick() {
        if (getActivity() != null) {
            com.shopee.feeds.feedlibrary.util.b.e.b();
            getActivity().finish();
        }
    }

    @OnClick
    public void onNextClick() {
        i();
    }

    @OnClick
    public void onChangeMode() {
        this.i = !this.i;
        this.k.a(this.i ? e.b.SINGLE : e.b.MULTIPLE);
        if (!this.i) {
            this.k.b(this.l);
            this.mIvMulti.setSelected(true);
            a(2);
            this.mViewBlank.setVisibility(8);
        } else {
            this.mIvMulti.setSelected(false);
            a(1);
            this.mViewBlank.setVisibility(0);
        }
        ModeChangeEntity modeChangeEntity = new ModeChangeEntity();
        modeChangeEntity.setmSingleMode(this.i);
        org.greenrobot.eventbus.c.a().c(modeChangeEntity);
        this.k.a(this.l);
        com.shopee.feeds.feedlibrary.util.b.e.a();
    }

    private void e() {
        this.i = !this.i;
        this.k.a(this.i ? e.b.SINGLE : e.b.MULTIPLE);
        if (!this.i) {
            this.k.b(this.l);
            this.mIvMulti.setSelected(true);
            a(2);
            this.mViewBlank.setVisibility(8);
        } else {
            this.mIvMulti.setSelected(false);
            a(1);
            this.mViewBlank.setVisibility(0);
        }
        this.k.a(this.l);
    }

    @OnClick
    public void onEnlarge() {
        if (!this.k.c()) {
            this.n = !this.n;
            this.k.a(this.n ? e.a.CENTER_CROP : e.a.CENTER_INSIDE);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.p.d();
        org.greenrobot.eventbus.c.a().b(this);
    }

    @m(a = ThreadMode.MAIN)
    public void onMediaSaved(a aVar) {
        if (this.m != null && aVar != null && aVar.l()) {
            if (this.m.containsKey(aVar.d())) {
                this.m.put(aVar.d(), aVar.j());
            }
            ArrayList arrayList = new ArrayList();
            for (String next : this.m.values()) {
                if (!TextUtils.isEmpty(next)) {
                    arrayList.add(next);
                } else {
                    return;
                }
            }
            h();
            this.p.b();
            a((ArrayList<String>) arrayList);
        }
    }

    @m(a = ThreadMode.MAIN)
    public void onVideoProgress(DownloadImgEvent downloadImgEvent) {
        if (!downloadImgEvent.isSuccess() && downloadImgEvent.isProduct()) {
            this.p.b();
        }
    }

    private a a(ProductEntity.ProductItem productItem) {
        if (productItem == null) {
            return null;
        }
        a aVar = new a(com.shopee.feeds.feedlibrary.data.c.b.b(productItem.getImage()), "image/jpg", t.a(productItem));
        aVar.e(19);
        return aVar;
    }

    private void a(int i2) {
        this.f7117e.a(i2, true);
        this.f7116d.a(i2, true);
    }

    /* access modifiers changed from: private */
    public void b(int i2) {
        if (i2 == 0) {
            this.o = 0;
            a((BaseProductFragment) this.f7117e);
            com.shopee.feeds.feedlibrary.util.b.e.a(0);
        } else if (i2 == 1) {
            this.o = 1;
            a((BaseProductFragment) this.f7116d);
            com.shopee.feeds.feedlibrary.util.b.e.a(1);
        }
        if (i2 != 1 || !this.s) {
            f();
        } else {
            f.a().a(new Runnable() {
                public void run() {
                    ChooseProductFragment chooseProductFragment = ChooseProductFragment.this;
                    chooseProductFragment.a((BaseProductFragment) chooseProductFragment.f7116d);
                    ChooseProductFragment.this.f();
                }
            }, 100);
        }
    }

    /* access modifiers changed from: private */
    public void f() {
        a aVar = this.l;
        if (aVar != null) {
            this.i = false;
            onChangeMode();
            g();
            this.s = false;
            return;
        }
        this.k.d(aVar);
    }

    /* access modifiers changed from: private */
    public void b(ProductEntity.ProductItem productItem) {
        if (productItem != null) {
            this.l = a(productItem);
            if (this.i) {
                this.k.a(this.l);
                this.sticky_navlayout.scrollTo(0, 0);
                return;
            }
            this.k.b(this.l);
            this.k.a(this.l);
        }
    }

    private void g() {
        e();
        e();
    }

    /* access modifiers changed from: private */
    public void c(ProductEntity.ProductItem productItem) {
        if (productItem != null) {
            this.k.c(a(productItem));
        }
    }

    /* access modifiers changed from: private */
    public void a(LinkedHashMap<Integer, ProductEntity.ProductItem> linkedHashMap) {
        if (linkedHashMap != null) {
            this.q.clear();
            this.q.putAll(linkedHashMap);
        }
    }

    private void h() {
        this.r.clear();
        k();
        LinkedHashMap<String, String> linkedHashMap = this.m;
        if (linkedHashMap != null && this.q != null && linkedHashMap.size() > 0 && this.q.size() > 0) {
            for (Map.Entry next : this.m.entrySet()) {
                String str = (String) next.getKey();
                String str2 = (String) next.getValue();
                for (ProductEntity.ProductItem next2 : this.q.values()) {
                    if (t.a(next2).equals(str)) {
                        com.shopee.feeds.feedlibrary.editor.tag.b bVar = new com.shopee.feeds.feedlibrary.editor.tag.b();
                        bVar.b(1);
                        bVar.a(next2);
                        bVar.c(next2.getName());
                        if (!d.a(next2.getPrice())) {
                            bVar.d(v.a() + v.b(next2.getPrice()));
                        }
                        bVar.b(next2.getItem_id());
                        bVar.c(next2.getShop_id());
                        bVar.a(String.valueOf(System.currentTimeMillis()));
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(bVar);
                        this.r.put(str2, arrayList);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean a(List<a> list) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            a aVar = list.get(i2);
            if (aVar == null || d.a(aVar.h())) {
                return false;
            }
        }
        return true;
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z && this.j) {
            d dVar = this.f7117e;
            if (dVar != null) {
                dVar.f();
            }
        }
    }

    private void i() {
        this.f7118f.b("android.permission.WRITE_EXTERNAL_STORAGE").a(new io.b.o<Boolean>() {
            public void a() {
            }

            public void a(io.b.b.b bVar) {
            }

            public void a(Throwable th) {
            }

            public void a(Boolean bool) {
                if (bool.booleanValue()) {
                    List<a> a2 = ChooseProductFragment.this.k.a();
                    if (ChooseProductFragment.this.a(a2)) {
                        LinkedHashMap unused = ChooseProductFragment.this.m = new LinkedHashMap();
                        for (a d2 : a2) {
                            ChooseProductFragment.this.m.put(d2.d(), "");
                        }
                        ChooseProductFragment.this.p.a(false);
                        ChooseProductFragment.this.p.a();
                        ChooseProductFragment.this.k.b(19);
                        com.shopee.feeds.feedlibrary.util.b.e.c();
                    }
                }
            }
        });
    }

    public void b() {
        if (this.f7119g == null) {
            this.f7119g = com.shopee.feeds.feedlibrary.b.b().a();
        }
        if (!this.t) {
            if (this.f7119g.a()) {
                TabLayout tabLayout = this.idStickynavlayoutIndicator;
                if (!(tabLayout == null || this.idStickynavlayoutViewpager == null)) {
                    tabLayout.a(1).f();
                    this.idStickynavlayoutViewpager.setCurrentItem(1);
                }
            }
            this.t = true;
        }
    }

    private void j() {
        this.f7118f = new com.shopee.feeds.feedlibrary.util.d.c(getActivity());
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.garena.android.appkit.tools.b.e(c.g.feeds_tab_bar_my_product));
        arrayList.add(com.garena.android.appkit.tools.b.e(c.g.feeds_tab_bar_my_favourite));
        com.shopee.feeds.feedlibrary.adapter.c cVar = new com.shopee.feeds.feedlibrary.adapter.c(getChildFragmentManager(), arrayList);
        this.f7117e = d.a(1, 1);
        this.f7116d = c.a(2, 1);
        this.f7117e.a((BaseProductFragment.a) new BaseProductFragment.a() {
            public void a(int i, ProductEntity.ProductItem productItem) {
                ChooseProductFragment.this.l();
                ChooseProductFragment.this.b(productItem);
                if (ChooseProductFragment.this.l != null) {
                    boolean unused = ChooseProductFragment.this.i = false;
                    ChooseProductFragment.this.onChangeMode();
                }
            }

            public void a(LinkedHashMap<Integer, ProductEntity.ProductItem> linkedHashMap) {
                ChooseProductFragment.this.a(linkedHashMap);
            }

            public void b(int i, ProductEntity.ProductItem productItem) {
                ChooseProductFragment.this.l();
                ChooseProductFragment.this.b(productItem);
            }

            public void c(int i, ProductEntity.ProductItem productItem) {
                ChooseProductFragment.this.c(productItem);
            }
        });
        this.f7116d.a((BaseProductFragment.a) new BaseProductFragment.a() {
            public void a(int i, ProductEntity.ProductItem productItem) {
                ChooseProductFragment.this.l();
                ChooseProductFragment.this.b(productItem);
                if (ChooseProductFragment.this.l != null) {
                    boolean unused = ChooseProductFragment.this.i = false;
                    ChooseProductFragment.this.onChangeMode();
                }
            }

            public void a(LinkedHashMap<Integer, ProductEntity.ProductItem> linkedHashMap) {
                ChooseProductFragment.this.a(linkedHashMap);
            }

            public void b(int i, ProductEntity.ProductItem productItem) {
                ChooseProductFragment.this.l();
                ChooseProductFragment.this.b(productItem);
            }

            public void c(int i, ProductEntity.ProductItem productItem) {
                ChooseProductFragment.this.c(productItem);
            }
        });
        cVar.a((Fragment) this.f7117e);
        cVar.a((Fragment) this.f7116d);
        this.idStickynavlayoutViewpager.setAdapter(cVar);
        this.idStickynavlayoutViewpager.setOffscreenPageLimit(2);
        this.idStickynavlayoutIndicator.setupWithViewPager(this.idStickynavlayoutViewpager);
        this.idStickynavlayoutViewpager.setScroll(false);
        this.idStickynavlayoutViewpager.addOnPageChangeListener(new ViewPager.f() {
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f2, int i2) {
            }

            public void onPageSelected(int i) {
                ChooseProductFragment.this.b(i);
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(BaseProductFragment baseProductFragment) {
        baseProductFragment.e();
        if (baseProductFragment.b(0) != null) {
            this.l = a(baseProductFragment.b(0));
            this.mViewShelter.setVisibility(8);
            return;
        }
        this.l = null;
        this.mViewShelter.setVisibility(0);
        this.mViewShelter.setBackgroundColor(getContext().getResources().getColor(c.b.white));
    }

    private void k() {
        if (this.q.size() <= 0) {
            int i2 = this.o;
            if (i2 == 0) {
                LinkedHashMap<Integer, ProductEntity.ProductItem> b2 = this.f7117e.b();
                if (b2 != null && b2.size() > 0) {
                    this.q.putAll(b2);
                }
            } else if (i2 == 1) {
                LinkedHashMap<Integer, ProductEntity.ProductItem> b3 = this.f7116d.b();
                if (b3 != null && b3.size() > 0) {
                    this.q.putAll(b3);
                }
            }
        }
    }

    private void a(final ArrayList<String> arrayList) {
        k.a(new Callable<Object>() {
            public Object call() throws Exception {
                HashMap hashMap = new HashMap();
                HashMap<String, String> d2 = ChooseProductFragment.this.k.d();
                if (d2 == null || d2.size() <= 0) {
                    return null;
                }
                for (Map.Entry entry : ChooseProductFragment.this.m.entrySet()) {
                    try {
                        String str = d2.get(ChooseProductFragment.this.a((String) entry.getKey()));
                        if (!d.a(str)) {
                            Bitmap h = w.a(ChooseProductFragment.this.getContext()).a(q.a(str)).h();
                            if (h != null) {
                                OriginImageInfo originImageInfo = new OriginImageInfo();
                                originImageInfo.setOriginal_resolution(h.getWidth() + " * " + h.getHeight());
                                originImageInfo.setOriginal_file_size(com.shopee.feeds.feedlibrary.util.k.f(str));
                                hashMap.put(entry.getValue(), originImageInfo);
                                h.recycle();
                            }
                        }
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                j.a().a((HashMap<String, OriginImageInfo>) hashMap);
                return null;
            }
        }).a(new h<Object, Object>() {
            public Object then(k<Object> kVar) throws Exception {
                j.a().d(3);
                com.shopee.feeds.feedlibrary.util.a.a(ChooseProductFragment.this.getActivity(), 1, arrayList, ChooseProductFragment.this.r);
                return null;
            }
        }, k.f377b);
    }

    /* access modifiers changed from: private */
    public String a(String str) {
        for (ProductEntity.ProductItem next : this.q.values()) {
            if (next != null && t.a(next).equals(str)) {
                return com.shopee.feeds.feedlibrary.data.c.b.b(next.getImage());
            }
        }
        return "";
    }

    /* access modifiers changed from: private */
    public void l() {
        if (this.mIvMulti.getVisibility() == 8) {
            this.mIvMulti.setVisibility(0);
        }
        if (this.mViewShelter.getVisibility() == 0) {
            this.mViewShelter.setVisibility(8);
        }
    }

    public void a() {
        com.shopee.feeds.feedlibrary.util.b.e.a(this.f7128a);
    }
}
