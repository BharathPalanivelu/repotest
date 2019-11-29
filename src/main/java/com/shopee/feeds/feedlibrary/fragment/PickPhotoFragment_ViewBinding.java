package com.shopee.feeds.feedlibrary.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.a.a;
import butterknife.a.b;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.view.GalleryView;
import com.shopee.feeds.feedlibrary.view.preview.ContainerLayout;

public class PickPhotoFragment_ViewBinding implements Unbinder {

    /* renamed from: b  reason: collision with root package name */
    private PickPhotoFragment f28161b;

    /* renamed from: c  reason: collision with root package name */
    private View f28162c;

    /* renamed from: d  reason: collision with root package name */
    private View f28163d;

    /* renamed from: e  reason: collision with root package name */
    private View f28164e;

    /* renamed from: f  reason: collision with root package name */
    private View f28165f;

    /* renamed from: g  reason: collision with root package name */
    private View f28166g;

    public PickPhotoFragment_ViewBinding(final PickPhotoFragment pickPhotoFragment, View view) {
        this.f28161b = pickPhotoFragment;
        View a2 = b.a(view, c.e.btn_top_back, "field 'mTitle' and method 'onClick'");
        pickPhotoFragment.mTitle = (TextView) b.b(a2, c.e.btn_top_back, "field 'mTitle'", TextView.class);
        this.f28162c = a2;
        a2.setOnClickListener(new a() {
            public void a(View view) {
                pickPhotoFragment.onClick(view);
            }
        });
        View a3 = b.a(view, c.e.tv_right, "field 'mNextBtn' and method 'onClick'");
        pickPhotoFragment.mNextBtn = (TextView) b.b(a3, c.e.tv_right, "field 'mNextBtn'", TextView.class);
        this.f28163d = a3;
        a3.setOnClickListener(new a() {
            public void a(View view) {
                pickPhotoFragment.onClick(view);
            }
        });
        pickPhotoFragment.mGalleryView = (GalleryView) b.a(view, c.e.gallery_view, "field 'mGalleryView'", GalleryView.class);
        pickPhotoFragment.mContainer = (ContainerLayout) b.a(view, c.e.picture_preview, "field 'mContainer'", ContainerLayout.class);
        View a4 = b.a(view, c.e.iv_enlarge, "field 'mScaleBtn' and method 'onChangeScale'");
        pickPhotoFragment.mScaleBtn = (ImageView) b.b(a4, c.e.iv_enlarge, "field 'mScaleBtn'", ImageView.class);
        this.f28164e = a4;
        a4.setOnClickListener(new a() {
            public void a(View view) {
                pickPhotoFragment.onChangeScale();
            }
        });
        View a5 = b.a(view, c.e.iv_multi, "field 'mMultiBtn' and method 'onChangeMode'");
        pickPhotoFragment.mMultiBtn = (ImageView) b.b(a5, c.e.iv_multi, "field 'mMultiBtn'", ImageView.class);
        this.f28165f = a5;
        a5.setOnClickListener(new a() {
            public void a(View view) {
                pickPhotoFragment.onChangeMode();
            }
        });
        pickPhotoFragment.mLlNoContent = (LinearLayout) b.a(view, c.e.ll_no_content, "field 'mLlNoContent'", LinearLayout.class);
        pickPhotoFragment.mLlNoAccess = (LinearLayout) b.a(view, c.e.ll_no_access, "field 'mLlNoAccess'", LinearLayout.class);
        pickPhotoFragment.mLlLibrary = (LinearLayout) b.a(view, c.e.ll_library, "field 'mLlLibrary'", LinearLayout.class);
        pickPhotoFragment.mTvPermission = (TextView) b.a(view, c.e.tv_open_permission, "field 'mTvPermission'", TextView.class);
        pickPhotoFragment.mViewBlank = b.a(view, c.e.view_blank, "field 'mViewBlank'");
        pickPhotoFragment.mIvVideoStop = (ImageView) b.a(view, c.e.iv_video_stop, "field 'mIvVideoStop'", ImageView.class);
        pickPhotoFragment.mTvNoContent = (TextView) b.a(view, c.e.tv_no_content, "field 'mTvNoContent'", TextView.class);
        pickPhotoFragment.mTvPermissioOne = (TextView) b.a(view, c.e.tv_permission_one, "field 'mTvPermissioOne'", TextView.class);
        pickPhotoFragment.mTvPermissiTwo = (TextView) b.a(view, c.e.tv_permission_two, "field 'mTvPermissiTwo'", TextView.class);
        View a6 = b.a(view, c.e.iv_left, "method 'onClick'");
        this.f28166g = a6;
        a6.setOnClickListener(new a() {
            public void a(View view) {
                pickPhotoFragment.onClick(view);
            }
        });
    }
}
