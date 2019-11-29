package com.shopee.feeds.feedlibrary.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.a.a;
import butterknife.a.b;
import com.devspark.robototextview.widget.RobotoTextView;
import com.garena.cropimage.library.CropImageView;
import com.shopee.feeds.feedlibrary.c;

public class CropActivity_ViewBinding implements Unbinder {

    /* renamed from: b  reason: collision with root package name */
    private CropActivity f27387b;

    /* renamed from: c  reason: collision with root package name */
    private View f27388c;

    /* renamed from: d  reason: collision with root package name */
    private View f27389d;

    public CropActivity_ViewBinding(final CropActivity cropActivity, View view) {
        this.f27387b = cropActivity;
        cropActivity.cropImageView = (CropImageView) b.a(view, c.e.crop_image_view, "field 'cropImageView'", CropImageView.class);
        View a2 = b.a(view, c.e.iv_left, "field 'ivLeft' and method 'onClickLeft'");
        cropActivity.ivLeft = (ImageView) b.b(a2, c.e.iv_left, "field 'ivLeft'", ImageView.class);
        this.f27388c = a2;
        a2.setOnClickListener(new a() {
            public void a(View view) {
                cropActivity.onClickLeft();
            }
        });
        cropActivity.btnTopBack = (RobotoTextView) b.a(view, c.e.btn_top_back, "field 'btnTopBack'", RobotoTextView.class);
        cropActivity.ivRight = (ImageView) b.a(view, c.e.iv_right, "field 'ivRight'", ImageView.class);
        View a3 = b.a(view, c.e.tv_right, "field 'tvRight' and method 'onClick'");
        cropActivity.tvRight = (RobotoTextView) b.b(a3, c.e.tv_right, "field 'tvRight'", RobotoTextView.class);
        this.f27389d = a3;
        a3.setOnClickListener(new a() {
            public void a(View view) {
                cropActivity.onClick();
            }
        });
        cropActivity.llTitleLayout = (RelativeLayout) b.a(view, c.e.ll_title_layout, "field 'llTitleLayout'", RelativeLayout.class);
    }
}
