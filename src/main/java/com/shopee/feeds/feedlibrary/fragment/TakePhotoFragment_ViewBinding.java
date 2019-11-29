package com.shopee.feeds.feedlibrary.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.a.a;
import butterknife.a.b;
import com.otaliastudios.cameraview.CameraView;
import com.shopee.feeds.feedlibrary.c;

public class TakePhotoFragment_ViewBinding implements Unbinder {

    /* renamed from: b  reason: collision with root package name */
    private TakePhotoFragment f28187b;

    /* renamed from: c  reason: collision with root package name */
    private View f28188c;

    /* renamed from: d  reason: collision with root package name */
    private View f28189d;

    /* renamed from: e  reason: collision with root package name */
    private View f28190e;

    /* renamed from: f  reason: collision with root package name */
    private View f28191f;

    public TakePhotoFragment_ViewBinding(final TakePhotoFragment takePhotoFragment, View view) {
        this.f28187b = takePhotoFragment;
        View a2 = b.a(view, c.e.iv_left, "field 'ivLeft' and method 'onClick'");
        takePhotoFragment.ivLeft = (ImageView) b.b(a2, c.e.iv_left, "field 'ivLeft'", ImageView.class);
        this.f28188c = a2;
        a2.setOnClickListener(new a() {
            public void a(View view) {
                takePhotoFragment.onClick(view);
            }
        });
        takePhotoFragment.btnTopBack = (TextView) b.a(view, c.e.btn_top_back, "field 'btnTopBack'", TextView.class);
        takePhotoFragment.ivRight = (ImageView) b.a(view, c.e.iv_right, "field 'ivRight'", ImageView.class);
        takePhotoFragment.tvRight = (TextView) b.a(view, c.e.tv_right, "field 'tvRight'", TextView.class);
        takePhotoFragment.llTitleLayout = (RelativeLayout) b.a(view, c.e.ll_title_layout, "field 'llTitleLayout'", RelativeLayout.class);
        takePhotoFragment.cameraView = (CameraView) b.a(view, c.e.camera_view, "field 'cameraView'", CameraView.class);
        View a3 = b.a(view, c.e.iv_take_photo, "field 'ivTakePhoto' and method 'onClick'");
        takePhotoFragment.ivTakePhoto = (ImageView) b.b(a3, c.e.iv_take_photo, "field 'ivTakePhoto'", ImageView.class);
        this.f28189d = a3;
        a3.setOnClickListener(new a() {
            public void a(View view) {
                takePhotoFragment.onClick(view);
            }
        });
        View a4 = b.a(view, c.e.iv_flash, "field 'mIvFlash' and method 'onClick'");
        takePhotoFragment.mIvFlash = (ImageView) b.b(a4, c.e.iv_flash, "field 'mIvFlash'", ImageView.class);
        this.f28190e = a4;
        a4.setOnClickListener(new a() {
            public void a(View view) {
                takePhotoFragment.onClick(view);
            }
        });
        takePhotoFragment.rl_frame = (RelativeLayout) b.a(view, c.e.rl_frame, "field 'rl_frame'", RelativeLayout.class);
        View a5 = b.a(view, c.e.iv_front, "field 'ivFront' and method 'onClick'");
        takePhotoFragment.ivFront = (ImageView) b.b(a5, c.e.iv_front, "field 'ivFront'", ImageView.class);
        this.f28191f = a5;
        a5.setOnClickListener(new a() {
            public void a(View view) {
                takePhotoFragment.onClick(view);
            }
        });
    }
}
