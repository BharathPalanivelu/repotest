package com.shopee.feeds.feedlibrary.activity;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.a.a;
import butterknife.a.b;
import com.devspark.robototextview.widget.RobotoTextView;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.view.ToogleButton;
import com.shopee.feeds.feedlibrary.view.edittext.LimitEditText;

public class CreatePostActivity_ViewBinding implements Unbinder {

    /* renamed from: b  reason: collision with root package name */
    private CreatePostActivity f27378b;

    /* renamed from: c  reason: collision with root package name */
    private View f27379c;

    /* renamed from: d  reason: collision with root package name */
    private View f27380d;

    public CreatePostActivity_ViewBinding(final CreatePostActivity createPostActivity, View view) {
        this.f27378b = createPostActivity;
        View a2 = b.a(view, c.e.iv_left, "field 'ivLeft' and method 'onClick'");
        createPostActivity.ivLeft = (ImageView) b.b(a2, c.e.iv_left, "field 'ivLeft'", ImageView.class);
        this.f27379c = a2;
        a2.setOnClickListener(new a() {
            public void a(View view) {
                createPostActivity.onClick(view);
            }
        });
        createPostActivity.btnTopBack = (RobotoTextView) b.a(view, c.e.btn_top_back, "field 'btnTopBack'", RobotoTextView.class);
        createPostActivity.ivRight = (ImageView) b.a(view, c.e.iv_right, "field 'ivRight'", ImageView.class);
        View a3 = b.a(view, c.e.tv_right, "field 'tvRight' and method 'onCreatePost'");
        createPostActivity.tvRight = (RobotoTextView) b.b(a3, c.e.tv_right, "field 'tvRight'", RobotoTextView.class);
        this.f27380d = a3;
        a3.setOnClickListener(new a() {
            public void a(View view) {
                createPostActivity.onCreatePost();
            }
        });
        createPostActivity.llTitleLayout = (RelativeLayout) b.a(view, c.e.ll_title_layout, "field 'llTitleLayout'", RelativeLayout.class);
        createPostActivity.rvPictures = (RecyclerView) b.a(view, c.e.rv_pictures, "field 'rvPictures'", RecyclerView.class);
        createPostActivity.limitEditText = (LimitEditText) b.a(view, c.e.et_limit, "field 'limitEditText'", LimitEditText.class);
        createPostActivity.rvTags = (RecyclerView) b.a(view, c.e.rv_tags, "field 'rvTags'", RecyclerView.class);
        createPostActivity.insToogle = (ToogleButton) b.a(view, c.e.ins_toogle, "field 'insToogle'", ToogleButton.class);
        createPostActivity.rlShareIns = (RelativeLayout) b.a(view, c.e.rl_share_ins, "field 'rlShareIns'", RelativeLayout.class);
        createPostActivity.albumToogle = (ToogleButton) b.a(view, c.e.album_toogle, "field 'albumToogle'", ToogleButton.class);
        createPostActivity.rlSaveAlbum = (RelativeLayout) b.a(view, c.e.rl_save_album, "field 'rlSaveAlbum'", RelativeLayout.class);
        createPostActivity.flBottomFrame = (FrameLayout) b.a(view, c.e.fl_bottom_frame, "field 'flBottomFrame'", FrameLayout.class);
        createPostActivity.mLlToogle = (LinearLayout) b.a(view, c.e.ll_toogle, "field 'mLlToogle'", LinearLayout.class);
        createPostActivity.mTvShareInsTitle = (TextView) b.a(view, c.e.tv_share_ins_title, "field 'mTvShareInsTitle'", TextView.class);
        createPostActivity.mTvSaveAlbumTitle = (TextView) b.a(view, c.e.tv_save_album_title, "field 'mTvSaveAlbumTitle'", TextView.class);
    }
}
