package com.shopee.feeds.feedlibrary.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.garena.android.appkit.f.f;
import com.shopee.feeds.feedlibrary.adapter.b;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.util.d;
import com.shopee.feeds.feedlibrary.util.l;
import com.shopee.feeds.feedlibrary.view.VideoWrapView;
import com.shopee.feeds.feedlibrary.view.b.e;
import java.util.ArrayList;
import java.util.List;
import tencent.tls.platform.SigType;

public class PicPreviewActivity extends a {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<String> f27402c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private int f27403d = -1;

    /* renamed from: e  reason: collision with root package name */
    private int f27404e = -1;

    /* renamed from: f  reason: collision with root package name */
    private int f27405f;

    /* renamed from: g  reason: collision with root package name */
    private int f27406g;
    private b h;
    private boolean i = true;
    /* access modifiers changed from: private */
    public int j = 0;
    @BindView
    LinearLayout mDotContainer;
    @BindView
    VideoWrapView mVideoWrapView;
    @BindView
    RelativeLayout rlPic;
    @BindView
    ViewPager vpContent;

    public boolean e() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        c();
        super.onCreate(bundle);
        setContentView(c.f.feeds_activity_pic_preview);
        ButterKnife.a((Activity) this);
        h();
    }

    private void h() {
        this.f27404e = d.b((Activity) this, "source_mode");
        int i2 = this.f27404e;
        if (i2 == 1) {
            i();
        } else if (i2 == 2) {
            j();
        }
    }

    private void i() {
        this.vpContent.setVisibility(0);
        this.mVideoWrapView.setVisibility(8);
        this.rlPic.setClickable(false);
        this.f27402c = getIntent().getStringArrayListExtra("source_path");
        this.f27403d = d.b((Activity) this, "index");
        this.h = new b(this.f7086a);
        this.h.a((b.a) new b.a() {
            public void a(int i) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) PicPreviewActivity.this.mDotContainer.getLayoutParams();
                layoutParams.topMargin = ((PicPreviewActivity.this.rlPic.getMeasuredHeight() + i) / 2) + l.a(10, PicPreviewActivity.this);
                PicPreviewActivity.this.mDotContainer.setLayoutParams(layoutParams);
                if (PicPreviewActivity.this.f27402c != null && PicPreviewActivity.this.f27402c.size() > 1) {
                    PicPreviewActivity.this.mDotContainer.setVisibility(0);
                }
            }
        });
        this.h.a((e) new e() {
            public void a(ImageView imageView) {
                PicPreviewActivity.this.finish();
            }
        });
        this.vpContent.setAdapter(this.h);
        ArrayList<String> arrayList = this.f27402c;
        if (arrayList != null && arrayList.size() > 0) {
            this.h.a((List<String>) this.f27402c);
        }
        this.vpContent.setOffscreenPageLimit(this.f27402c.size());
        int i2 = this.f27403d;
        if (-1 != i2) {
            this.vpContent.setCurrentItem(i2);
        }
        a(this.f27403d);
        this.vpContent.addOnPageChangeListener(new ViewPager.f() {
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f2, int i2) {
            }

            public void onPageSelected(int i) {
                if (PicPreviewActivity.this.j >= 0) {
                    PicPreviewActivity.this.mDotContainer.getChildAt(PicPreviewActivity.this.j).setEnabled(false);
                    PicPreviewActivity.this.mDotContainer.getChildAt(i).setEnabled(true);
                    int unused = PicPreviewActivity.this.j = i;
                }
            }
        });
    }

    private void j() {
        this.vpContent.setVisibility(8);
        this.mVideoWrapView.setVisibility(0);
        this.f27405f = d.b((Activity) this, "videoWidth");
        this.f27406g = d.b((Activity) this, "videoHeight");
        this.f27402c = getIntent().getStringArrayListExtra("source_path");
        this.mVideoWrapView.a(this.f27405f, this.f27406g);
        this.mVideoWrapView.a();
        this.mVideoWrapView.d();
        this.mVideoWrapView.setVideoUrl(this.f27402c.get(0));
        this.mVideoWrapView.requestDisallowInterceptTouchEvent(true);
        f.a().a(new Runnable() {
            public void run() {
                PicPreviewActivity.this.mVideoWrapView.a(true);
            }
        }, 300);
    }

    private void a(int i2) {
        ArrayList<String> arrayList = this.f27402c;
        if (arrayList == null || arrayList.size() <= 1) {
            this.mDotContainer.setVisibility(8);
            this.j = -1;
            return;
        }
        this.mDotContainer.setVisibility(8);
        this.j = i2;
        int size = this.f27402c.size();
        for (int i3 = 0; i3 < size; i3++) {
            View view = new View(this);
            view.setBackground(com.garena.android.appkit.tools.b.f(c.d.feeds_preview_dot_bg));
            if (i2 == i3) {
                view.setEnabled(true);
            } else {
                view.setEnabled(false);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(l.a(6, this), l.a(6, this));
            if (i3 != 0) {
                layoutParams.leftMargin = l.a(8, this);
            }
            this.mDotContainer.addView(view, layoutParams);
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        if (this.f27404e == 2) {
            this.mVideoWrapView.b();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.f27404e != 2) {
            return;
        }
        if (!this.i) {
            this.mVideoWrapView.c();
        } else {
            this.i = false;
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }

    public static void a(Context context, int i2, int i3, List<String> list, int i4, int i5) {
        Intent intent = new Intent(context, PicPreviewActivity.class);
        intent.putExtra("index", i3);
        intent.putExtra("videoWidth", i4);
        intent.putExtra("videoHeight", i5);
        intent.putExtra("source_mode", i2);
        intent.putStringArrayListExtra("source_path", (ArrayList) list);
        intent.addFlags(SigType.TLS);
        context.startActivity(intent);
    }

    @OnClick
    public void onClick(View view) {
        finish();
    }
}
