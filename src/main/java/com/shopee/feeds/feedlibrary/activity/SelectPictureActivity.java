package com.shopee.feeds.feedlibrary.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.devspark.robototextview.widget.RobotoTextView;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.garena.cropimage.library.CropTouchImageView;
import com.google.a.l;
import com.google.a.o;
import com.google.android.material.tabs.TabLayout;
import com.shopee.feeds.feedlibrary.b;
import com.shopee.feeds.feedlibrary.bg.a;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.data.entity.AddMoreEntity;
import com.shopee.feeds.feedlibrary.data.entity.MediaCompressParam;
import com.shopee.feeds.feedlibrary.data.entity.ModeChangeEntity;
import com.shopee.feeds.feedlibrary.fragment.ChooseProductFragment;
import com.shopee.feeds.feedlibrary.fragment.InstagramFragment;
import com.shopee.feeds.feedlibrary.fragment.PickPhotoFragment;
import com.shopee.feeds.feedlibrary.fragment.TakePhotoFragment;
import com.shopee.feeds.feedlibrary.picture.e;
import com.shopee.feeds.feedlibrary.util.j;
import com.shopee.feeds.feedlibrary.util.r;
import com.shopee.feeds.feedlibrary.util.u;
import com.shopee.feeds.feedlibrary.util.y;
import com.shopee.feeds.feedlibrary.view.easyviewpager.CustomScrollViewPager;
import java.util.ArrayList;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.m;

public class SelectPictureActivity extends a {

    /* renamed from: c  reason: collision with root package name */
    public static String f7077c = "ShopeeFeedsCreatePost";

    /* renamed from: d  reason: collision with root package name */
    r f7078d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f7079e = false;

    /* renamed from: f  reason: collision with root package name */
    private int f7080f;
    @BindView
    TabLayout tabPost;
    @BindView
    View viewStatus;
    @BindView
    CustomScrollViewPager viewpagerContainer;

    public boolean e() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        setTheme(c.h.picture_default_style);
        c();
        super.onCreate(bundle);
        setContentView(c.f.feeds_activity_pic_select);
        org.greenrobot.eventbus.c.a().a((Object) this);
        ButterKnife.a((Activity) this);
        j.a().C();
        h();
    }

    private void h() {
        if (!a.a().d()) {
            u.b(b.b().c(), com.garena.android.appkit.tools.b.a(c.g.feeds_posts_max_tips, 3));
            finish();
            return;
        }
        j.a().d(false);
        CropTouchImageView.f7872b = 0.523f;
        CropTouchImageView.f7871a = 0.952f;
        this.f7078d = new r(this.f7086a);
        this.f7078d.d();
        i();
        o b2 = b();
        if (b2 != null && b2.b(NativeProtocol.WEB_DIALOG_PARAMS)) {
            o e2 = b2.e(NativeProtocol.WEB_DIALOG_PARAMS);
            if (e2 != null && e2.b(ShareConstants.WEB_DIALOG_PARAM_HASHTAG)) {
                l c2 = e2.c(ShareConstants.WEB_DIALOG_PARAM_HASHTAG);
                if (c2 != null) {
                    j.a().b(c2.c());
                }
            }
        }
        y.a((y.a) new y.a() {
            public void a(boolean z) {
                boolean unused = SelectPictureActivity.this.f7079e = z;
                SelectPictureActivity.this.a(z);
            }
        });
    }

    private void i() {
        e.a((Activity) this).a(com.shopee.feeds.feedlibrary.picture.c.a()).a(c.h.picture_default_style).c(5).d(1).e(4).b(2).m(true).n(true).b(true).k(false).j(true).a(false).h(false).i(true).b(160, 160).a(1, 1).g(false).l(false).c(true).d(false).e(true).f(true).o(true).f(100);
        com.shopee.feeds.feedlibrary.data.c.b.h();
        j();
    }

    /* access modifiers changed from: private */
    public void a(boolean z) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.garena.android.appkit.tools.b.e(c.g.feeds_tab_bar_library));
        arrayList.add(com.garena.android.appkit.tools.b.e(c.g.feeds_tab_bar_photo));
        arrayList.add(com.garena.android.appkit.tools.b.e(c.g.feeds_tab_bar_product));
        if (z) {
            arrayList.add("Instagram");
        }
        com.shopee.feeds.feedlibrary.adapter.c cVar = new com.shopee.feeds.feedlibrary.adapter.c(getSupportFragmentManager(), arrayList);
        cVar.a((Fragment) new PickPhotoFragment());
        cVar.a((Fragment) new TakePhotoFragment());
        final ChooseProductFragment chooseProductFragment = new ChooseProductFragment();
        cVar.a((Fragment) chooseProductFragment);
        if (z) {
            cVar.a((Fragment) new InstagramFragment());
        }
        this.viewpagerContainer.setAdapter(cVar);
        this.viewpagerContainer.setOffscreenPageLimit(4);
        this.tabPost.a((TabLayout.b) new TabLayout.c() {
            public void c(TabLayout.f fVar) {
            }

            public void a(TabLayout.f fVar) {
                View b2 = fVar.b();
                if (b2 != null && (b2 instanceof LinearLayout)) {
                    RobotoTextView robotoTextView = (RobotoTextView) b2.findViewById(c.e.txt_tab);
                    SelectPictureActivity.this.a(robotoTextView);
                    robotoTextView.setTextColor(SelectPictureActivity.this.f7086a.getResources().getColor(c.b.main_text_color));
                    robotoTextView.setTypeface(com.devspark.robototextview.b.a(SelectPictureActivity.this.f7086a, 8));
                    if (fVar.d() == 3) {
                        SelectPictureActivity.this.b(robotoTextView);
                    }
                }
                if (fVar.d() == 2) {
                    chooseProductFragment.b();
                }
            }

            public void b(TabLayout.f fVar) {
                View b2 = fVar.b();
                if (b2 != null && (b2 instanceof LinearLayout)) {
                    RobotoTextView robotoTextView = (RobotoTextView) b2.findViewById(c.e.txt_tab);
                    SelectPictureActivity.this.a(robotoTextView);
                    robotoTextView.setTextColor(SelectPictureActivity.this.f7086a.getResources().getColor(c.b.grey_1000));
                    robotoTextView.setTypeface(com.devspark.robototextview.b.a(SelectPictureActivity.this.f7086a, 4));
                    if (fVar.d() == 3) {
                        SelectPictureActivity.this.b(robotoTextView);
                    }
                }
            }
        });
        this.viewpagerContainer.addOnPageChangeListener(new ViewPager.f() {
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f2, int i2) {
            }

            public void onPageSelected(int i) {
                SelectPictureActivity.this.a(i);
            }
        });
        this.tabPost.setupWithViewPager(this.viewpagerContainer);
        a((ArrayList<String>) arrayList);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        try {
            super.onDestroy();
            org.greenrobot.eventbus.c.a().b(this);
            this.f7078d.f();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a(int i, String str, o oVar) {
        "Result Code: " + i + "\nData: " + oVar.toString() + "\nFrom: " + str;
    }

    public String a() {
        return f7077c;
    }

    @m(a = ThreadMode.MAIN)
    public void onMessageEvent(ModeChangeEntity modeChangeEntity) {
        if (!(modeChangeEntity instanceof ModeChangeEntity)) {
            return;
        }
        if (modeChangeEntity.ismSingleMode()) {
            this.tabPost.setVisibility(0);
            this.viewpagerContainer.setScroll(true);
            return;
        }
        this.tabPost.setVisibility(8);
        this.viewpagerContainer.setScroll(false);
    }

    @m(a = ThreadMode.MAIN)
    public void onMessageEvent(AddMoreEntity addMoreEntity) {
        if ((addMoreEntity instanceof AddMoreEntity) && addMoreEntity.getMode() != 1 && addMoreEntity.getMode() == 2) {
            this.viewpagerContainer.setCurrentItem(0);
        }
    }

    public void a(int i) {
        if (i == 0) {
            com.shopee.feeds.feedlibrary.util.b.e.c(0);
        } else if (i == 1) {
            com.shopee.feeds.feedlibrary.util.b.e.d(1);
        } else if (i == 2) {
            com.shopee.feeds.feedlibrary.util.b.e.b(2);
        } else if (i == 3) {
            com.shopee.feeds.feedlibrary.util.b.e.g(3);
        }
    }

    private void a(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                TabLayout.f a2 = this.tabPost.a(i);
                if (a2.b() == null) {
                    a2.a(c.f.feeds_pick_picture_tab_item);
                }
                final RobotoTextView robotoTextView = (RobotoTextView) a2.b().findViewById(c.e.txt_tab);
                robotoTextView.setText(arrayList.get(i));
                a(robotoTextView);
                if (i == 3) {
                    robotoTextView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                        public boolean onPreDraw() {
                            robotoTextView.getViewTreeObserver().removeOnPreDrawListener(this);
                            if (robotoTextView.getLineCount() <= 1) {
                                return false;
                            }
                            SelectPictureActivity.this.b(robotoTextView);
                            return false;
                        }
                    });
                }
                if (i == 0) {
                    robotoTextView.setTextColor(this.f7086a.getResources().getColor(c.b.main_text_color));
                    robotoTextView.setTypeface(com.devspark.robototextview.b.a((Context) this, 8));
                }
            }
        }
    }

    private void j() {
        this.f7078d.b();
        this.f7078d.c();
        this.f7078d.a((com.shopee.feeds.feedlibrary.a.a) new com.shopee.feeds.feedlibrary.a.a() {
            public void a(String str) {
            }

            public void a(Object obj, String str) {
                j.a().a((MediaCompressParam) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(RobotoTextView robotoTextView) {
        if (this.f7079e) {
            robotoTextView.setTextSize(13.0f);
        } else {
            robotoTextView.setTextSize(14.0f);
        }
    }

    /* access modifiers changed from: private */
    public void b(RobotoTextView robotoTextView) {
        int i = this.f7080f;
        if (i <= 0) {
            i = (robotoTextView.getWidth() - robotoTextView.getPaddingLeft()) - robotoTextView.getPaddingRight();
            this.f7080f = i;
        }
        if (i > 0) {
            TextPaint textPaint = new TextPaint(robotoTextView.getPaint());
            float textSize = textPaint.getTextSize();
            float f2 = 2.0f;
            while (textSize - f2 > 0.5f) {
                float f3 = (textSize + f2) / 2.0f;
                textPaint.setTextSize(f3);
                float f4 = (float) i;
                if (textPaint.measureText(robotoTextView.getText().toString()) >= f4) {
                    textSize = f3;
                } else if (textPaint.measureText(robotoTextView.getText().toString()) < f4) {
                    f2 = f3;
                }
            }
            robotoTextView.setTextSize(0, f2);
        }
    }
}
