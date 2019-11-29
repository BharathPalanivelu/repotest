package com.shopee.feeds.feedlibrary.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.devspark.robototextview.widget.RobotoTextView;
import com.garena.android.appkit.tools.b;
import com.garena.cropimage.library.CropImageView;
import com.garena.cropimage.library.a;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.util.d;
import com.shopee.feeds.feedlibrary.util.u;
import com.shopee.feeds.feedlibrary.view.preview.j;
import com.squareup.a.w;
import java.io.File;

public class CropActivity extends a implements CropImageView.c {
    @BindView
    RobotoTextView btnTopBack;

    /* renamed from: c  reason: collision with root package name */
    private String f27385c = "";
    @BindView
    CropImageView cropImageView;

    /* renamed from: d  reason: collision with root package name */
    private String f27386d = "";
    @BindView
    ImageView ivLeft;
    @BindView
    ImageView ivRight;
    @BindView
    RelativeLayout llTitleLayout;
    @BindView
    RobotoTextView tvRight;

    public boolean e() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(c.f.feeds_activity_crop);
        ButterKnife.a((Activity) this);
        h();
    }

    private void h() {
        i();
        this.f27385c = d.a((Activity) this, "path");
        b(this.f27385c);
    }

    private void i() {
        this.btnTopBack.setText("Crop");
        this.tvRight.setVisibility(0);
        this.tvRight.setText(b.e(c.g.feeds_button_done));
    }

    @OnClick
    public void onClickLeft() {
        finish();
    }

    @OnClick
    public void onClick() {
        this.cropImageView.a();
    }

    private void b(String str) {
        this.f27386d = j.a((Context) this);
        a params = this.cropImageView.getParams();
        params.a(str).b(this.f27386d).a(1024, 1024).b(1, 1);
        this.cropImageView.setParams(params);
        this.cropImageView.setCropImageCallback(this);
        this.cropImageView.setBitmapLoader(new com.garena.cropimage.library.c(w.a(this.f7086a).a(new File(str)), b.b(), b.b()));
    }

    public void a(CropImageView.g gVar) {
        if (gVar != CropImageView.g.SUCCESS) {
            u.a(this, "cropping error");
        }
    }
}
