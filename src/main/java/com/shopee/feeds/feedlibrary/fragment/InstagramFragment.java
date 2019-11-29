package com.shopee.feeds.feedlibrary.fragment;

import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.devspark.robototextview.widget.RobotoTextView;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.data.entity.DownloadImgEvent;
import com.shopee.feeds.feedlibrary.data.entity.FeedsInstagramData;
import com.shopee.feeds.feedlibrary.data.entity.GetInsTokenEntity;
import com.shopee.feeds.feedlibrary.data.entity.ModeChangeEntity;
import com.shopee.feeds.feedlibrary.data.entity.OriginImageInfo;
import com.shopee.feeds.feedlibrary.util.j;
import com.shopee.feeds.feedlibrary.util.n;
import com.shopee.feeds.feedlibrary.view.InstagramListView;
import com.shopee.feeds.feedlibrary.view.preview.ContainerLayout;
import com.shopee.feeds.feedlibrary.view.preview.a;
import com.shopee.feeds.feedlibrary.view.preview.e;
import com.shopee.feeds.feedlibrary.view.widget.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.m;

public class InstagramFragment extends a {

    /* renamed from: d  reason: collision with root package name */
    b f7120d;

    /* renamed from: e  reason: collision with root package name */
    private int f7121e = -1;

    /* renamed from: f  reason: collision with root package name */
    private boolean f7122f = true;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f7123g = true;
    /* access modifiers changed from: private */
    public e h;
    /* access modifiers changed from: private */
    public a i;
    private LinkedHashMap<String, String> j;
    private com.shopee.sdk.ui.a k;
    private LinkedHashMap<String, ArrayList<com.shopee.feeds.feedlibrary.editor.tag.a>> l = new LinkedHashMap<>();
    private n m;
    @BindView
    ContainerLayout mContainer;
    @BindView
    InstagramListView mGalleryView;
    @BindView
    ImageView mIvVideoStop;
    @BindView
    LinearLayout mLlInsParent;
    @BindView
    LinearLayout mLlLibrary;
    @BindView
    LinearLayout mLlNoAccess;
    @BindView
    LinearLayout mLlNoContent;
    @BindView
    LinearLayout mLlWrongNet;
    @BindView
    ImageView mMultiBtn;
    @BindView
    TextView mNextBtn;
    @BindView
    ImageView mScaleBtn;
    @BindView
    TextView mTitle;
    @BindView
    RobotoTextView mTvLoginIns;
    @BindView
    RobotoTextView mTvLoginInsTips;
    @BindView
    TextView mTvNoContent;
    @BindView
    RobotoTextView mTvRetry;
    @BindView
    RobotoTextView mTvRrongNetData;
    @BindView
    View mViewBlank;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(c.f.feeds_fragment_instagram, viewGroup, false);
        ButterKnife.a(this, inflate);
        org.greenrobot.eventbus.c.a().a((Object) this);
        b();
        c();
        return inflate;
    }

    private void b() {
        this.mTitle.setText(com.garena.android.appkit.tools.b.e(c.g.feeds_text_instagram));
        this.mNextBtn.setVisibility(0);
        this.mNextBtn.setText(com.garena.android.appkit.tools.b.e(c.g.feeds_button_next));
        this.mNextBtn.setTextColor(com.shopee.feeds.feedlibrary.b.b().f27287b.getResources().getColor(c.b.grey_400));
        this.mNextBtn.setEnabled(false);
    }

    @OnClick
    public void onClick(View view) {
        int id = view.getId();
        if (id == c.e.iv_left) {
            j();
            getActivity().finish();
        } else if (id == c.e.tv_right) {
            com.shopee.feeds.feedlibrary.util.b.e.C();
            List<a> a2 = this.h.a();
            if (a2.size() > 0) {
                LinkedHashMap<String, String> linkedHashMap = this.j;
                if (linkedHashMap == null) {
                    this.j = new LinkedHashMap<>();
                } else {
                    linkedHashMap.clear();
                }
                for (a h2 : a2) {
                    this.j.put(h2.h(), "");
                }
                this.k.a(false);
                a(true);
                this.h.b(20);
            }
        } else if (id == c.e.tv_login_ins) {
            com.shopee.feeds.feedlibrary.util.b.e.y();
            this.m.a();
        } else if (id == c.e.tv_retry) {
            com.shopee.feeds.feedlibrary.util.b.e.E();
            h();
            this.f7120d.c();
            this.m.b(false);
        }
    }

    @OnClick
    public void onChangeScale() {
        if (!this.h.c()) {
            com.shopee.feeds.feedlibrary.util.b.e.A();
            this.f7122f = !this.f7122f;
            this.h.a(this.f7122f ? e.a.CENTER_CROP : e.a.CENTER_INSIDE);
            com.shopee.feeds.feedlibrary.util.b.e.d();
        }
    }

    @OnClick
    public void onChangeMode() {
        com.shopee.feeds.feedlibrary.util.b.e.B();
        int i2 = 1;
        this.f7123g = !this.f7123g;
        InstagramListView instagramListView = this.mGalleryView;
        if (!this.f7123g) {
            i2 = 2;
        }
        instagramListView.setMode(i2);
        this.h.a(this.f7123g ? e.b.SINGLE : e.b.MULTIPLE);
        if (!this.f7123g) {
            this.h.b(this.i);
            this.mScaleBtn.setVisibility(8);
            this.mViewBlank.setVisibility(8);
            this.mMultiBtn.setBackgroundResource(c.d.feeds_bg_multi_press);
        } else {
            this.mScaleBtn.setVisibility(0);
            this.mViewBlank.setVisibility(0);
            this.mMultiBtn.setBackgroundResource(c.d.feeds_bg_multi_normal);
        }
        ModeChangeEntity modeChangeEntity = new ModeChangeEntity();
        modeChangeEntity.setmSingleMode(this.f7123g);
        org.greenrobot.eventbus.c.a().c(modeChangeEntity);
        this.h.a(this.i);
    }

    private void c() {
        this.f7120d = new b(getActivity());
        this.m = new n(getActivity());
        this.m.a((n.a) new n.a() {
            public void a(ArrayList<FeedsInstagramData> arrayList, boolean z) {
                if (arrayList != null && arrayList.size() > 0) {
                    if (z) {
                        InstagramFragment.this.f7120d.a();
                    } else {
                        InstagramFragment.this.f7120d.d();
                    }
                    InstagramFragment.this.d();
                    InstagramFragment.this.mGalleryView.a(arrayList.get(0));
                    InstagramFragment.this.mGalleryView.setLocalMediaList(arrayList);
                    InstagramFragment instagramFragment = InstagramFragment.this;
                    a unused = instagramFragment.i = instagramFragment.a(arrayList.get(0));
                    InstagramFragment.this.h.a(InstagramFragment.this.i);
                    InstagramFragment.this.a();
                }
            }

            public void a() {
                InstagramFragment.this.f7120d.d();
                com.shopee.feeds.feedlibrary.util.b.e.z();
                InstagramFragment.this.f();
                InstagramFragment.this.a();
            }

            public void b() {
                InstagramFragment.this.f7120d.d();
                InstagramFragment.this.e();
                InstagramFragment.this.a();
            }

            public void c() {
                com.shopee.feeds.feedlibrary.util.b.e.D();
                InstagramFragment.this.f7120d.b();
                InstagramFragment.this.g();
            }
        });
        this.h = new e(getContext(), this.mContainer, this.mMultiBtn, this.mScaleBtn, this.mIvVideoStop);
        this.k = new com.shopee.sdk.ui.a(getActivity());
        this.mGalleryView.setGalleryImageSelectedListener(new InstagramListView.a() {
            public void a(int i, FeedsInstagramData feedsInstagramData) {
                if (feedsInstagramData != null) {
                    InstagramFragment.this.mGalleryView.a(i);
                    InstagramFragment instagramFragment = InstagramFragment.this;
                    a unused = instagramFragment.i = instagramFragment.a(feedsInstagramData);
                    if (InstagramFragment.this.f7123g) {
                        InstagramFragment.this.h.a(InstagramFragment.this.i);
                        return;
                    }
                    InstagramFragment.this.h.b(InstagramFragment.this.i);
                    InstagramFragment.this.h.a(InstagramFragment.this.i);
                }
            }

            public void b(int i, FeedsInstagramData feedsInstagramData) {
                if (feedsInstagramData != null) {
                    InstagramFragment.this.h.c(InstagramFragment.this.a(feedsInstagramData));
                }
            }
        });
    }

    public void onPause() {
        super.onPause();
        this.h.b();
    }

    public void onDestroy() {
        super.onDestroy();
        org.greenrobot.eventbus.c.a().b(this);
    }

    public void onResume() {
        super.onResume();
        this.h.a(this.f7129b);
    }

    public void setUserVisibleHint(boolean z) {
        if (this.f7128a && z) {
            h();
            this.f7120d.c();
            this.m.a(false);
        }
        if (!this.f7128a) {
            this.f7120d.a(z);
        }
        super.setUserVisibleHint(z);
        e eVar = this.h;
        if (eVar == null) {
            return;
        }
        if (z) {
            eVar.a(z);
        } else {
            eVar.b();
        }
    }

    public void a() {
        i();
    }

    @m(a = ThreadMode.MAIN)
    public void onMediaSaved(a aVar) {
        if (this.j != null && aVar != null && aVar.m()) {
            if (this.j.containsKey(aVar.h())) {
                this.j.put(aVar.h(), aVar.j());
            }
            ArrayList arrayList = new ArrayList();
            for (String next : this.j.values()) {
                if (!TextUtils.isEmpty(next)) {
                    arrayList.add(next);
                } else {
                    return;
                }
            }
            a((ArrayList<String>) arrayList);
        }
    }

    @m(a = ThreadMode.MAIN)
    public void onDownloadImg(DownloadImgEvent downloadImgEvent) {
        if (!downloadImgEvent.isSuccess() && downloadImgEvent.isIns()) {
            a(false);
        }
    }

    @m(a = ThreadMode.MAIN)
    public void onGetInsTokenEvent(GetInsTokenEntity getInsTokenEntity) {
        if ((getInsTokenEntity instanceof GetInsTokenEntity) && this.m != null) {
            this.f7121e = -1;
            h();
            this.f7120d.c();
            this.m.a(true);
        }
    }

    /* access modifiers changed from: private */
    public a a(FeedsInstagramData feedsInstagramData) {
        a aVar = new a(feedsInstagramData.getImage(), "image/jpg", feedsInstagramData.getImage());
        aVar.e(20);
        return aVar;
    }

    private void a(boolean z) {
        if (z) {
            this.k.a();
            this.mNextBtn.setTextColor(com.shopee.feeds.feedlibrary.b.b().f27287b.getResources().getColor(c.b.grey_400));
            this.mNextBtn.setEnabled(false);
            return;
        }
        this.k.b();
        this.mNextBtn.setTextColor(com.shopee.feeds.feedlibrary.b.b().f27287b.getResources().getColor(c.b.main_color));
        this.mNextBtn.setEnabled(true);
    }

    /* access modifiers changed from: private */
    public void d() {
        this.f7121e = 3;
        this.mNextBtn.setTextColor(com.shopee.feeds.feedlibrary.b.b().f27287b.getResources().getColor(c.b.main_color));
        this.mNextBtn.setEnabled(true);
        this.mLlNoContent.setVisibility(8);
        this.mLlLibrary.setVisibility(0);
        this.mLlNoAccess.setVisibility(8);
        this.mLlWrongNet.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public void e() {
        this.f7121e = 2;
        this.mNextBtn.setTextColor(com.shopee.feeds.feedlibrary.b.b().f27287b.getResources().getColor(c.b.grey_400));
        this.mNextBtn.setEnabled(false);
        this.mLlNoContent.setVisibility(0);
        this.mLlNoAccess.setVisibility(8);
        this.mLlLibrary.setVisibility(8);
        this.mLlWrongNet.setVisibility(8);
        this.mTvNoContent.setText(com.garena.android.appkit.tools.b.e(c.g.feeds_album_empty_tips));
    }

    /* access modifiers changed from: private */
    public void f() {
        this.f7121e = 1;
        this.mNextBtn.setTextColor(com.shopee.feeds.feedlibrary.b.b().f27287b.getResources().getColor(c.b.grey_400));
        this.mNextBtn.setEnabled(false);
        this.mLlNoContent.setVisibility(8);
        this.mLlNoAccess.setVisibility(0);
        this.mLlLibrary.setVisibility(8);
        this.mLlWrongNet.setVisibility(8);
        this.mTvLoginInsTips.setText(com.garena.android.appkit.tools.b.e(c.g.feeds_instagram_login_main_tips));
        this.mTvLoginIns.setText(com.garena.android.appkit.tools.b.e(c.g.feeds_instagram_login_button_title));
        this.mTvLoginIns.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            public boolean onPreDraw() {
                InstagramFragment.this.mTvLoginIns.getViewTreeObserver().removeOnPreDrawListener(this);
                if (InstagramFragment.this.mTvLoginIns.getLineCount() <= 1) {
                    return false;
                }
                InstagramFragment instagramFragment = InstagramFragment.this;
                instagramFragment.a(instagramFragment.mTvLoginIns);
                return false;
            }
        });
    }

    /* access modifiers changed from: private */
    public void g() {
        this.f7121e = 4;
        this.mNextBtn.setTextColor(com.shopee.feeds.feedlibrary.b.b().f27287b.getResources().getColor(c.b.grey_400));
        this.mNextBtn.setEnabled(false);
        this.mLlNoContent.setVisibility(8);
        this.mLlNoAccess.setVisibility(8);
        this.mLlLibrary.setVisibility(8);
        this.mLlWrongNet.setVisibility(0);
        this.mTvRrongNetData.setText(com.garena.android.appkit.tools.b.e(c.g.feeds_product_failed_to_load));
        this.mTvRetry.setText(com.garena.android.appkit.tools.b.e(c.g.feeds_product_retry));
    }

    private void h() {
        this.mLlNoContent.setVisibility(8);
        this.mLlNoAccess.setVisibility(8);
        this.mLlLibrary.setVisibility(8);
        this.mLlWrongNet.setVisibility(8);
    }

    private void a(ArrayList<String> arrayList) {
        try {
            HashMap hashMap = new HashMap();
            HashMap<String, OriginImageInfo> e2 = this.h.e();
            if (e2 != null && e2.size() > 0) {
                for (Map.Entry next : this.j.entrySet()) {
                    OriginImageInfo originImageInfo = e2.get((String) next.getKey());
                    if (originImageInfo != null) {
                        hashMap.put(next.getValue(), originImageInfo);
                    }
                }
                j.a().a((HashMap<String, OriginImageInfo>) hashMap);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        a(false);
        j.a().d(5);
        com.shopee.feeds.feedlibrary.util.a.a(getContext(), 2, arrayList, this.l);
    }

    /* access modifiers changed from: private */
    public void a(RobotoTextView robotoTextView) {
        int width = (robotoTextView.getWidth() - robotoTextView.getPaddingLeft()) - robotoTextView.getPaddingRight();
        if (width > 0) {
            TextPaint textPaint = new TextPaint(robotoTextView.getPaint());
            float textSize = textPaint.getTextSize();
            float f2 = 2.0f;
            while (textSize - f2 > 0.5f) {
                float f3 = (textSize + f2) / 2.0f;
                textPaint.setTextSize(f3);
                float f4 = (float) width;
                if (textPaint.measureText(robotoTextView.getText().toString()) >= f4) {
                    textSize = f3;
                } else if (textPaint.measureText(robotoTextView.getText().toString()) < f4) {
                    f2 = f3;
                }
            }
            robotoTextView.setTextSize(0, f2);
        }
    }

    private void i() {
        int i2 = this.f7121e;
        if (i2 == -1) {
            return;
        }
        if (i2 == 1) {
            com.shopee.feeds.feedlibrary.util.b.e.a(this.f7128a, true, true);
        } else if (i2 == 2) {
            com.shopee.feeds.feedlibrary.util.b.e.a(this.f7128a, true, false);
        } else if (i2 == 3) {
            com.shopee.feeds.feedlibrary.util.b.e.a(this.f7128a, false, false);
        }
    }

    private void j() {
        int i2 = this.f7121e;
        if (i2 == -1) {
            return;
        }
        if (i2 == 1) {
            com.shopee.feeds.feedlibrary.util.b.e.b(true, true);
        } else if (i2 == 2) {
            com.shopee.feeds.feedlibrary.util.b.e.b(true, false);
        } else if (i2 == 3) {
            com.shopee.feeds.feedlibrary.util.b.e.b(false, false);
        }
    }
}
