package com.shopee.feeds.feedlibrary.editor.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.ViewPager;
import butterknife.OnClick;
import com.google.a.f;
import com.google.a.o;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.data.entity.MediaCompressParam;
import com.shopee.feeds.feedlibrary.data.entity.PhotoEditEntity;
import com.shopee.feeds.feedlibrary.data.entity.ProductEntity;
import com.shopee.feeds.feedlibrary.data.entity.RatingsEntity;
import com.shopee.feeds.feedlibrary.editor.a.a;
import com.shopee.feeds.feedlibrary.editor.b.d;
import com.shopee.feeds.feedlibrary.util.d.b;
import com.shopee.feeds.feedlibrary.util.e;
import com.shopee.feeds.feedlibrary.util.h;
import com.shopee.feeds.feedlibrary.util.j;
import com.shopee.feeds.feedlibrary.util.u;
import com.shopee.feeds.feedlibrary.util.w;
import com.shopee.feeds.feedlibrary.util.y;
import com.shopee.sdk.modules.ui.a.a;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class PhotoEditActivity extends AbstractEditActivity {
    private ArrayList<String> i = new ArrayList<>();
    private LinkedHashMap<String, ArrayList<com.shopee.feeds.feedlibrary.editor.tag.a>> j = new LinkedHashMap<>();
    private PhotoEditEntity k;
    private int l;
    /* access modifiers changed from: private */
    public com.shopee.feeds.feedlibrary.editor.a.a m;
    private SparseBooleanArray n = new SparseBooleanArray();
    /* access modifiers changed from: private */
    public a o;
    private RatingsEntity p = new RatingsEntity();
    private b q = null;
    /* access modifiers changed from: private */
    public boolean r = false;

    public String a() {
        return "ShopeeFeedsEditPage";
    }

    public boolean e() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void n() {
    }

    class a extends Handler {
        a() {
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 291) {
                PhotoEditActivity.this.tvRight.setTextColor(PhotoEditActivity.this.f7086a.getResources().getColor(c.b.main_color));
                PhotoEditActivity.this.tvRight.setEnabled(true);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        u();
        b(0);
    }

    private void u() {
        w();
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("tagPic")) {
            this.k = (PhotoEditEntity) extras.get("tagPic");
            this.i = this.k.getCurrentPathList();
            this.j = this.k.getTagInfoMap();
            this.l = this.k.getSource();
            j.a().d(false);
        } else if (!com.shopee.feeds.feedlibrary.bg.a.a().d()) {
            u.b(com.shopee.feeds.feedlibrary.b.b().c(), com.garena.android.appkit.tools.b.a(c.g.feeds_posts_max_tips, 3));
            finish();
            return;
        } else {
            j.a().C();
            this.p = new RatingsEntity();
            o b2 = b();
            h.b("%s", "getParam " + b2.toString());
            f fVar = new f();
            if (com.shopee.feeds.feedlibrary.data.c.c.f27687a == 0) {
                this.p.test();
            } else {
                this.p = (RatingsEntity) fVar.a(b2.toString(), RatingsEntity.class);
                this.p.resetImageUrl();
            }
            h.b("%s", "entity str  " + this.p.getComments());
            this.i = (ArrayList) this.p.getImageUrl();
            this.l = 0;
            j.a().d(4);
            j.a().d(true);
            this.f7092e.a(this.p.getShopId(), this.p.getItemIds(), (com.shopee.feeds.feedlibrary.a.a) new com.shopee.feeds.feedlibrary.a.a() {
                public void a(String str) {
                }

                public void a(Object obj, String str) {
                    ArrayList arrayList = (ArrayList) obj;
                    if (arrayList != null && arrayList.size() > 0) {
                        ProductEntity.ProductItem productItem = (ProductEntity.ProductItem) arrayList.get(0);
                        if (productItem != null) {
                            PhotoEditActivity.this.a(productItem);
                        }
                    }
                }
            });
        }
        A();
        this.o = new a();
        this.m = new com.shopee.feeds.feedlibrary.editor.a.a(this.f7086a, this.l);
        this.m.a((a.d) new a.d() {
            public void a() {
                com.garena.android.appkit.f.f.a().a(new Runnable() {
                    public void run() {
                        PhotoEditActivity.this.v();
                    }
                });
            }
        });
        this.m.a((a.C0427a) new a.C0427a() {
            public void a() {
                PhotoEditActivity.this.r();
            }

            public void b() {
                if (PhotoEditActivity.this.o != null) {
                    PhotoEditActivity.this.o.sendEmptyMessageDelayed(291, 600);
                }
            }
        });
        this.m.a((a.b) new a.b() {
            public void a(long j) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) PhotoEditActivity.this.tagViewpager.getLayoutParams();
                if (layoutParams != null && j > 0) {
                    layoutParams.height = (int) j;
                    PhotoEditActivity.this.tagViewpager.setLayoutParams(layoutParams);
                }
            }
        });
        this.tagViewpager.setOffscreenPageLimit(this.i.size());
        this.tagViewpager.setAdapter(this.m);
        ArrayList<String> arrayList = this.i;
        if (arrayList != null && arrayList.size() > 0) {
            this.m.a((List<String>) this.i);
            this.m.a(this.j);
        }
        this.indicator.setNumPages(this.i.size());
        this.indicator.setLocation(BitmapDescriptorFactory.HUE_RED);
        this.tagViewpager.setOffscreenPageLimit(this.i.size());
        this.tagViewpager.addOnPageChangeListener(new ViewPager.f() {
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f2, int i2) {
            }

            public void onPageSelected(int i) {
                PhotoEditActivity.this.m.a(i);
                PhotoEditActivity.this.indicator.setLocation((float) i);
                PhotoEditActivity.this.r();
                PhotoEditActivity.this.b(i);
            }
        });
        if (j.a().w()) {
            this.mAddTagLayout.setEnabled(false);
            this.ivAddTag.setImageDrawable(com.garena.android.appkit.tools.b.f(c.d.feeds_ic_tag_unavailable));
        }
        com.garena.android.appkit.f.f.a().a(new Runnable() {
            public void run() {
                y.b();
            }
        });
    }

    /* access modifiers changed from: private */
    public void v() {
        h.b("%s", "showBuyerRiview " + this.l);
        if (j.a().w()) {
            com.shopee.feeds.feedlibrary.editor.sticker.a.a aVar = new com.shopee.feeds.feedlibrary.editor.sticker.a.a();
            aVar.c(this.p.getBuyerName());
            aVar.d(this.p.getComments());
            aVar.b(this.p.getRatings());
            aVar.b(this.p.getRatingId());
            aVar.i(1.0f);
            aVar.j(w.a(1.0f));
            aVar.a(354);
            a(aVar);
        }
    }

    private void w() {
        this.btnTopBack.setText(com.garena.android.appkit.tools.b.e(c.g.feeds_nav_bar_title_edit_photo));
        this.ivLeft.setImageResource(c.d.feeds_ic_left_arrow);
        this.tvRight.setVisibility(0);
        this.tvRight.setText(com.garena.android.appkit.tools.b.e(c.g.feeds_button_next));
        this.tvTap.setText(com.garena.android.appkit.tools.b.e(c.g.feeds_product_tag_first_tips));
        this.tvRemove.setText(com.garena.android.appkit.tools.b.e(c.g.feeds_product_tag_second_tips));
        this.mTvMove.setText(com.garena.android.appkit.tools.b.e(c.g.feeds_product_tag_third_tips));
        this.tvRight.setTextColor(this.f7086a.getResources().getColor(c.b.grey_400));
        this.tvRight.setEnabled(false);
    }

    private void x() {
        com.shopee.sdk.modules.ui.a.a a2 = new a.C0472a().c(com.garena.android.appkit.tools.b.e(c.g.feeds_buyer_review_auth_setting)).d(com.garena.android.appkit.tools.b.e(c.g.feeds_buyer_review_auth_cancel)).b(com.garena.android.appkit.tools.b.e(c.g.feeds_buyer_review_auth_sub_title)).a(com.garena.android.appkit.tools.b.e(c.g.feeds_buyer_review_auth_main_title)).a();
        this.q = new b(this.f7086a);
        com.shopee.sdk.b.a().c().a(this, a2, new com.shopee.sdk.f.b<Integer>() {
            public void a(int i, String str) {
            }

            public void a(Integer num) {
                if (num.intValue() == 1) {
                    PhotoEditActivity.this.y();
                    PhotoEditActivity photoEditActivity = PhotoEditActivity.this;
                    photoEditActivity.h = false;
                    boolean unused = photoEditActivity.r = true;
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void y() {
        b.a(this);
    }

    @OnClick
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if (id == c.e.tv_right) {
            if (j.a().w()) {
                if (this.h) {
                    x();
                    return;
                } else if (this.r && !this.m.f()) {
                    x();
                    return;
                }
            }
            b(true);
            MediaCompressParam s = j.a().s();
            if (s == null || s.getAndroid() == null) {
                s = e.a();
            }
            this.m.a(s, (d.a) new d.a() {
                public void a() {
                    PhotoEditActivity.this.z();
                }
            }, (a.c) new a.c() {
                public void a(int i) {
                    PhotoEditActivity.this.b(false);
                    if (!j.a().w()) {
                        return;
                    }
                    if (i == -1) {
                        PhotoEditActivity photoEditActivity = PhotoEditActivity.this;
                        photoEditActivity.h = true;
                        u.b(photoEditActivity.f7086a, com.garena.android.appkit.tools.b.e(c.g.feeds_buyer_review_auth_fail_toast));
                        return;
                    }
                    PhotoEditActivity.this.h = false;
                }
            });
            com.shopee.feeds.feedlibrary.util.b.e.s();
        } else if (id == c.e.rl_add_tag) {
            com.shopee.feeds.feedlibrary.util.b.e.k();
        } else if (id == c.e.iv_add_text) {
            com.shopee.feeds.feedlibrary.util.b.e.l();
        } else if (id == c.e.iv_add_sticker) {
            com.shopee.feeds.feedlibrary.util.b.e.m();
        }
    }

    /* access modifiers changed from: private */
    public void z() {
        this.m.a((a.e) new a.e() {
            public void a(int i) {
                com.garena.android.appkit.f.f.a().a(new Runnable() {
                    public void run() {
                        PhotoEditActivity.this.b(false);
                        PhotoEditActivity.this.m.b();
                    }
                });
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        try {
            super.onDestroy();
            this.m.a((a.C0427a) null);
            if (this.o != null) {
                this.o.removeCallbacksAndMessages((Object) null);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void A() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.tagViewpager.getLayoutParams();
        WindowManager windowManager = (WindowManager) getSystemService("window");
        if (windowManager != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            layoutParams.height = displayMetrics.widthPixels;
            this.tagViewpager.setLayoutParams(layoutParams);
        }
    }

    /* access modifiers changed from: protected */
    public d i() {
        return this.m.c();
    }

    /* access modifiers changed from: protected */
    public d j() {
        return this.m.d();
    }

    /* access modifiers changed from: protected */
    public boolean k() {
        return i().k();
    }

    /* access modifiers changed from: protected */
    public boolean l() {
        return this.m.g();
    }

    /* access modifiers changed from: protected */
    public boolean a(int i2) {
        com.shopee.feeds.feedlibrary.editor.sticker.d stickerEditor = i().getStickerEditor();
        if (i2 == 1) {
            return stickerEditor.l();
        }
        if (i2 == 2) {
            return stickerEditor.m();
        }
        if (i2 == 3) {
            return stickerEditor.i();
        }
        if (i2 == 4) {
            return stickerEditor.k();
        }
        if (i2 != 5) {
            return false;
        }
        return stickerEditor.j();
    }

    /* access modifiers changed from: protected */
    public int m() {
        return this.m.h();
    }

    public void f() {
        com.shopee.feeds.feedlibrary.util.b.e.d(this.f7087b);
    }

    /* access modifiers changed from: private */
    public void b(int i2) {
        if (!this.n.get(i2)) {
            this.n.put(i2, true);
        }
    }

    /* access modifiers changed from: protected */
    public void r() {
        super.r();
        if (j.a().w()) {
            this.mAddTagLayout.setEnabled(false);
            this.ivAddTag.setImageDrawable(com.garena.android.appkit.tools.b.f(c.d.feeds_ic_tag_unavailable));
        }
        this.tvTagsNum.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public boolean t() {
        return this.m.i();
    }
}
