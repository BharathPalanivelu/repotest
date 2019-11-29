package com.shopee.feeds.feedlibrary.editor.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.a.a;
import butterknife.a.b;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.editor.sticker.CommentStickerEditorPanel;
import com.shopee.feeds.feedlibrary.view.PageIndicator;

public class AbstractEditActivity_ViewBinding implements Unbinder {

    /* renamed from: b  reason: collision with root package name */
    private AbstractEditActivity f27845b;

    /* renamed from: c  reason: collision with root package name */
    private View f27846c;

    /* renamed from: d  reason: collision with root package name */
    private View f27847d;

    /* renamed from: e  reason: collision with root package name */
    private View f27848e;

    /* renamed from: f  reason: collision with root package name */
    private View f27849f;

    /* renamed from: g  reason: collision with root package name */
    private View f27850g;

    public AbstractEditActivity_ViewBinding(final AbstractEditActivity abstractEditActivity, View view) {
        this.f27845b = abstractEditActivity;
        abstractEditActivity.rlTopTitle = (RelativeLayout) b.a(view, c.e.rl_top_layout, "field 'rlTopTitle'", RelativeLayout.class);
        View a2 = b.a(view, c.e.iv_left, "field 'ivLeft' and method 'onClick'");
        abstractEditActivity.ivLeft = (ImageView) b.b(a2, c.e.iv_left, "field 'ivLeft'", ImageView.class);
        this.f27846c = a2;
        a2.setOnClickListener(new a() {
            public void a(View view) {
                abstractEditActivity.onClick(view);
            }
        });
        abstractEditActivity.btnTopBack = (TextView) b.a(view, c.e.btn_top_back, "field 'btnTopBack'", TextView.class);
        abstractEditActivity.ivRight = (ImageView) b.a(view, c.e.iv_right, "field 'ivRight'", ImageView.class);
        View a3 = b.a(view, c.e.tv_right, "field 'tvRight' and method 'onClick'");
        abstractEditActivity.tvRight = (TextView) b.b(a3, c.e.tv_right, "field 'tvRight'", TextView.class);
        this.f27847d = a3;
        a3.setOnClickListener(new a() {
            public void a(View view) {
                abstractEditActivity.onClick(view);
            }
        });
        abstractEditActivity.llTitleLayout = (RelativeLayout) b.a(view, c.e.ll_title_layout, "field 'llTitleLayout'", RelativeLayout.class);
        abstractEditActivity.rlVideoContainer = (RelativeLayout) b.a(view, c.e.rl_video_container, "field 'rlVideoContainer'", RelativeLayout.class);
        abstractEditActivity.tagViewpager = (ViewPager) b.a(view, c.e.tag_viewpager, "field 'tagViewpager'", ViewPager.class);
        abstractEditActivity.tvTap = (TextView) b.a(view, c.e.tv_tap, "field 'tvTap'", TextView.class);
        abstractEditActivity.tvRemove = (TextView) b.a(view, c.e.tv_remove, "field 'tvRemove'", TextView.class);
        abstractEditActivity.indicator = (PageIndicator) b.a(view, c.e.page_indicator, "field 'indicator'", PageIndicator.class);
        abstractEditActivity.mTvMove = (TextView) b.a(view, c.e.tv_move, "field 'mTvMove'", TextView.class);
        View a4 = b.a(view, c.e.rl_add_tag, "field 'mAddTagLayout' and method 'onClick'");
        abstractEditActivity.mAddTagLayout = (RelativeLayout) b.b(a4, c.e.rl_add_tag, "field 'mAddTagLayout'", RelativeLayout.class);
        this.f27848e = a4;
        a4.setOnClickListener(new a() {
            public void a(View view) {
                abstractEditActivity.onClick(view);
            }
        });
        abstractEditActivity.tvTagsNum = (TextView) b.a(view, c.e.tv_tag_num, "field 'tvTagsNum'", TextView.class);
        abstractEditActivity.ivAddTag = (ImageView) b.a(view, c.e.iv_add_tag, "field 'ivAddTag'", ImageView.class);
        View a5 = b.a(view, c.e.iv_add_text, "field 'ivAddText' and method 'onClick'");
        abstractEditActivity.ivAddText = (ImageView) b.b(a5, c.e.iv_add_text, "field 'ivAddText'", ImageView.class);
        this.f27849f = a5;
        a5.setOnClickListener(new a() {
            public void a(View view) {
                abstractEditActivity.onClick(view);
            }
        });
        View a6 = b.a(view, c.e.iv_add_sticker, "field 'ivAddSticker' and method 'onClick'");
        abstractEditActivity.ivAddSticker = (ImageView) b.b(a6, c.e.iv_add_sticker, "field 'ivAddSticker'", ImageView.class);
        this.f27850g = a6;
        a6.setOnClickListener(new a() {
            public void a(View view) {
                abstractEditActivity.onClick(view);
            }
        });
        abstractEditActivity.commentStickerEditorPanel = (CommentStickerEditorPanel) b.a(view, c.e.comment_edit_panel, "field 'commentStickerEditorPanel'", CommentStickerEditorPanel.class);
        abstractEditActivity.mRvProduct = (RecyclerView) b.a(view, c.e.rv_product, "field 'mRvProduct'", RecyclerView.class);
    }
}
