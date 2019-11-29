package com.shopee.feeds.feedlibrary.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.a.a;
import butterknife.a.b;
import com.devspark.robototextview.widget.RobotoTextView;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.view.InstagramListView;
import com.shopee.feeds.feedlibrary.view.preview.ContainerLayout;

public class InstagramFragment_ViewBinding implements Unbinder {

    /* renamed from: b  reason: collision with root package name */
    private InstagramFragment f28135b;

    /* renamed from: c  reason: collision with root package name */
    private View f28136c;

    /* renamed from: d  reason: collision with root package name */
    private View f28137d;

    /* renamed from: e  reason: collision with root package name */
    private View f28138e;

    /* renamed from: f  reason: collision with root package name */
    private View f28139f;

    /* renamed from: g  reason: collision with root package name */
    private View f28140g;
    private View h;
    private View i;

    public InstagramFragment_ViewBinding(final InstagramFragment instagramFragment, View view) {
        this.f28135b = instagramFragment;
        View a2 = b.a(view, c.e.btn_top_back, "field 'mTitle' and method 'onClick'");
        instagramFragment.mTitle = (TextView) b.b(a2, c.e.btn_top_back, "field 'mTitle'", TextView.class);
        this.f28136c = a2;
        a2.setOnClickListener(new a() {
            public void a(View view) {
                instagramFragment.onClick(view);
            }
        });
        View a3 = b.a(view, c.e.tv_right, "field 'mNextBtn' and method 'onClick'");
        instagramFragment.mNextBtn = (TextView) b.b(a3, c.e.tv_right, "field 'mNextBtn'", TextView.class);
        this.f28137d = a3;
        a3.setOnClickListener(new a() {
            public void a(View view) {
                instagramFragment.onClick(view);
            }
        });
        instagramFragment.mGalleryView = (InstagramListView) b.a(view, c.e.gallery_view, "field 'mGalleryView'", InstagramListView.class);
        instagramFragment.mContainer = (ContainerLayout) b.a(view, c.e.picture_preview, "field 'mContainer'", ContainerLayout.class);
        View a4 = b.a(view, c.e.iv_enlarge, "field 'mScaleBtn' and method 'onChangeScale'");
        instagramFragment.mScaleBtn = (ImageView) b.b(a4, c.e.iv_enlarge, "field 'mScaleBtn'", ImageView.class);
        this.f28138e = a4;
        a4.setOnClickListener(new a() {
            public void a(View view) {
                instagramFragment.onChangeScale();
            }
        });
        View a5 = b.a(view, c.e.iv_multi, "field 'mMultiBtn' and method 'onChangeMode'");
        instagramFragment.mMultiBtn = (ImageView) b.b(a5, c.e.iv_multi, "field 'mMultiBtn'", ImageView.class);
        this.f28139f = a5;
        a5.setOnClickListener(new a() {
            public void a(View view) {
                instagramFragment.onChangeMode();
            }
        });
        instagramFragment.mLlNoContent = (LinearLayout) b.a(view, c.e.ll_no_content, "field 'mLlNoContent'", LinearLayout.class);
        instagramFragment.mLlNoAccess = (LinearLayout) b.a(view, c.e.ll_no_access, "field 'mLlNoAccess'", LinearLayout.class);
        instagramFragment.mLlLibrary = (LinearLayout) b.a(view, c.e.ll_library, "field 'mLlLibrary'", LinearLayout.class);
        instagramFragment.mViewBlank = b.a(view, c.e.view_blank, "field 'mViewBlank'");
        instagramFragment.mIvVideoStop = (ImageView) b.a(view, c.e.iv_video_stop, "field 'mIvVideoStop'", ImageView.class);
        instagramFragment.mTvNoContent = (TextView) b.a(view, c.e.tv_no_content, "field 'mTvNoContent'", TextView.class);
        View a6 = b.a(view, c.e.tv_login_ins, "field 'mTvLoginIns' and method 'onClick'");
        instagramFragment.mTvLoginIns = (RobotoTextView) b.b(a6, c.e.tv_login_ins, "field 'mTvLoginIns'", RobotoTextView.class);
        this.f28140g = a6;
        a6.setOnClickListener(new a() {
            public void a(View view) {
                instagramFragment.onClick(view);
            }
        });
        instagramFragment.mTvLoginInsTips = (RobotoTextView) b.a(view, c.e.tv_login_ins_tips, "field 'mTvLoginInsTips'", RobotoTextView.class);
        instagramFragment.mLlInsParent = (LinearLayout) b.a(view, c.e.ll_ins_parent, "field 'mLlInsParent'", LinearLayout.class);
        instagramFragment.mLlWrongNet = (LinearLayout) b.a(view, c.e.ll_wrong_net, "field 'mLlWrongNet'", LinearLayout.class);
        instagramFragment.mTvRrongNetData = (RobotoTextView) b.a(view, c.e.tv_wrong_net_data, "field 'mTvRrongNetData'", RobotoTextView.class);
        View a7 = b.a(view, c.e.tv_retry, "field 'mTvRetry' and method 'onClick'");
        instagramFragment.mTvRetry = (RobotoTextView) b.b(a7, c.e.tv_retry, "field 'mTvRetry'", RobotoTextView.class);
        this.h = a7;
        a7.setOnClickListener(new a() {
            public void a(View view) {
                instagramFragment.onClick(view);
            }
        });
        View a8 = b.a(view, c.e.iv_left, "method 'onClick'");
        this.i = a8;
        a8.setOnClickListener(new a() {
            public void a(View view) {
                instagramFragment.onClick(view);
            }
        });
    }
}
