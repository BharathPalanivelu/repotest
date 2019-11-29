package com.shopee.feeds.feedlibrary.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.facebook.share.internal.ShareConstants;
import com.google.android.material.tabs.TabLayout;
import com.shopee.feeds.feedlibrary.adapter.c;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.data.d.b;
import com.shopee.feeds.feedlibrary.data.entity.FinishPdListEntity;
import com.shopee.feeds.feedlibrary.data.entity.ProductEntity;
import com.shopee.feeds.feedlibrary.data.entity.SaveProductEntity;
import com.shopee.feeds.feedlibrary.fragment.BaseTagProductFragment;
import com.shopee.feeds.feedlibrary.fragment.e;
import com.shopee.feeds.feedlibrary.fragment.f;
import com.shopee.feeds.feedlibrary.util.d;
import com.shopee.feeds.feedlibrary.view.easyviewpager.CustomScrollViewPager;
import java.util.ArrayList;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.m;

public class SelectProductActivity extends a {
    @BindView
    TextView btnTopBack;

    /* renamed from: c  reason: collision with root package name */
    c f7081c;

    /* renamed from: d  reason: collision with root package name */
    private f f7082d;

    /* renamed from: e  reason: collision with root package name */
    private e f7083e;

    /* renamed from: f  reason: collision with root package name */
    private int f7084f;

    /* renamed from: g  reason: collision with root package name */
    private int f7085g;
    private ArrayList<ProductEntity.ProductItem> h = new ArrayList<>();
    private boolean i = false;
    @BindView
    ImageView ivLeft;
    @BindView
    ImageView ivRight;
    private int j;
    private b k;
    @BindView
    RelativeLayout llTitleLayout;
    @BindView
    TabLayout tabLayout;
    @BindView
    TextView tvRight;
    @BindView
    CustomScrollViewPager viewPager;

    public boolean e() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        c();
        super.onCreate(bundle);
        setContentView(c.f.feeds_activity_selec_product);
        ButterKnife.a((Activity) this);
        org.greenrobot.eventbus.c.a().a((Object) this);
        h();
        i();
        j();
    }

    private void h() {
        this.f7084f = d.b((Activity) this, ShareConstants.FEED_SOURCE_PARAM);
        this.j = d.b((Activity) this, "select");
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.get("save") != null) {
            SaveProductEntity saveProductEntity = (SaveProductEntity) extras.get("save");
            this.f7085g = saveProductEntity.getmPageType();
            this.h = saveProductEntity.getProductItems();
        }
    }

    private void i() {
        this.ivLeft.setImageResource(c.d.feeds_ic_close_gray);
        this.ivRight.setVisibility(0);
        this.ivRight.setImageResource(c.d.feeds_ic_search);
        this.btnTopBack.setText(com.garena.android.appkit.tools.b.e(c.g.feeds_nav_bar_title_select_product));
    }

    @OnClick
    public void onClick(View view) {
        int id = view.getId();
        if (id == c.e.iv_left) {
            finish();
        } else if (id == c.e.iv_right) {
            startActivity(new Intent(this, ProductSearchActivity.class));
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        org.greenrobot.eventbus.c.a().b(this);
    }

    public void f() {
        com.shopee.feeds.feedlibrary.util.b.e.e(this.f7087b);
    }

    private void j() {
        this.k = com.shopee.feeds.feedlibrary.b.b().a();
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.garena.android.appkit.tools.b.e(c.g.feeds_tab_bar_my_product));
        arrayList.add(com.garena.android.appkit.tools.b.e(c.g.feeds_tab_bar_my_favourite));
        this.f7081c = new com.shopee.feeds.feedlibrary.adapter.c(getSupportFragmentManager(), arrayList);
        this.tabLayout.setVisibility(0);
        int i2 = this.f7084f;
        if (i2 == 1) {
            this.f7082d = f.a(3, this.j, this.h);
            this.f7083e = e.a(4, this.j, this.h);
            k();
        } else if (i2 == 2) {
            this.f7082d = f.a(5, this.j, this.h);
            this.f7083e = e.a(6, this.j, this.h);
            k();
        }
        this.viewPager.setAdapter(this.f7081c);
        this.tabLayout.setupWithViewPager(this.viewPager);
        this.viewPager.setScroll(false);
        a((ArrayList<String>) arrayList);
        this.tabLayout.a((TabLayout.b) new TabLayout.c() {
            public void c(TabLayout.f fVar) {
            }

            public void a(TabLayout.f fVar) {
                View b2 = fVar.b();
                if (b2 != null && (b2 instanceof LinearLayout)) {
                    ((TextView) b2.findViewById(c.e.txt_tab)).setTextColor(SelectProductActivity.this.f7086a.getResources().getColor(c.b.main_text_color));
                }
            }

            public void b(TabLayout.f fVar) {
                View b2 = fVar.b();
                if (b2 != null && (b2 instanceof LinearLayout)) {
                    ((TextView) b2.findViewById(c.e.txt_tab)).setTextColor(SelectProductActivity.this.f7086a.getResources().getColor(c.b.grey_1000));
                }
            }
        });
        l();
        if (this.k.a()) {
            this.tabLayout.a(1).f();
            this.viewPager.setCurrentItem(1);
        }
        this.viewPager.addOnPageChangeListener(new ViewPager.f() {
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f2, int i2) {
            }

            public void onPageSelected(int i) {
                SelectProductActivity.this.a(i);
                SelectProductActivity.this.b(i);
            }
        });
    }

    private void k() {
        this.f7082d.a((BaseTagProductFragment.a) new BaseTagProductFragment.a() {
            public void a(ArrayList<ProductEntity.ProductItem> arrayList) {
                SelectProductActivity.this.a(5, arrayList);
            }
        });
        this.f7083e.a((BaseTagProductFragment.a) new BaseTagProductFragment.a() {
            public void a(ArrayList<ProductEntity.ProductItem> arrayList) {
                SelectProductActivity.this.a(6, arrayList);
            }
        });
        this.f7081c.a((Fragment) this.f7082d);
        this.f7081c.a((Fragment) this.f7083e);
    }

    @m(a = ThreadMode.MAIN)
    public void onMessageEvent(FinishPdListEntity finishPdListEntity) {
        if (finishPdListEntity instanceof FinishPdListEntity) {
            finish();
        }
    }

    /* access modifiers changed from: private */
    public void a(int i2) {
        if (this.f7084f != 2) {
            return;
        }
        if (i2 == 0) {
            this.f7083e.d();
        } else if (i2 == 1) {
            this.f7082d.d();
        }
    }

    private void a(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                TabLayout.f a2 = this.tabLayout.a(i2);
                if (a2.b() == null) {
                    a2.a(c.f.feeds_tab_item);
                }
                TextView textView = (TextView) a2.b().findViewById(c.e.txt_tab);
                textView.setText(arrayList.get(i2));
                if (i2 == 0) {
                    textView.setTextColor(this.f7086a.getResources().getColor(c.b.main_text_color));
                }
            }
        }
    }

    private void l() {
        ArrayList<ProductEntity.ProductItem> arrayList = this.h;
        if (arrayList != null && arrayList.size() > 0) {
            int i2 = this.f7085g;
            if (i2 == 5) {
                this.viewPager.setCurrentItem(0);
                this.f7082d.a(this.h);
            } else if (i2 == 6) {
                this.viewPager.setCurrentItem(1);
                this.f7083e.a(this.h);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(int i2, ArrayList<ProductEntity.ProductItem> arrayList) {
        if (this.j == 2) {
            if (arrayList != null && arrayList.size() > 0) {
                this.tvRight.setTextColor(getResources().getColor(c.b.main_color));
                this.tvRight.setEnabled(true);
            } else if (!this.i) {
                this.tvRight.setTextColor(getResources().getColor(c.b.grey_500));
                this.tvRight.setEnabled(false);
            }
            this.h.clear();
            this.h.addAll(arrayList);
            SaveProductEntity saveProductEntity = new SaveProductEntity();
            saveProductEntity.setmPageType(i2);
            saveProductEntity.setProductItems(arrayList);
            org.greenrobot.eventbus.c.a().c(saveProductEntity);
        }
    }

    /* access modifiers changed from: private */
    public void b(int i2) {
        if (i2 == 0) {
            com.shopee.feeds.feedlibrary.util.b.e.e(0);
        } else if (i2 == 1) {
            com.shopee.feeds.feedlibrary.util.b.e.e(1);
        }
    }
}
