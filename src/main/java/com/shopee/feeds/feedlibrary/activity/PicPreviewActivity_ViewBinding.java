package com.shopee.feeds.feedlibrary.activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.a.a;
import butterknife.a.b;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.view.VideoWrapView;

public class PicPreviewActivity_ViewBinding implements Unbinder {

    /* renamed from: b  reason: collision with root package name */
    private PicPreviewActivity f27411b;

    /* renamed from: c  reason: collision with root package name */
    private View f27412c;

    public PicPreviewActivity_ViewBinding(final PicPreviewActivity picPreviewActivity, View view) {
        this.f27411b = picPreviewActivity;
        picPreviewActivity.vpContent = (ViewPager) b.a(view, c.e.vp_content, "field 'vpContent'", ViewPager.class);
        View a2 = b.a(view, c.e.rl_pic, "field 'rlPic' and method 'onClick'");
        picPreviewActivity.rlPic = (RelativeLayout) b.b(a2, c.e.rl_pic, "field 'rlPic'", RelativeLayout.class);
        this.f27412c = a2;
        a2.setOnClickListener(new a() {
            public void a(View view) {
                picPreviewActivity.onClick(view);
            }
        });
        picPreviewActivity.mVideoWrapView = (VideoWrapView) b.a(view, c.e.video_wrap_view, "field 'mVideoWrapView'", VideoWrapView.class);
        picPreviewActivity.mDotContainer = (LinearLayout) b.a(view, c.e.dot_container, "field 'mDotContainer'", LinearLayout.class);
    }
}
