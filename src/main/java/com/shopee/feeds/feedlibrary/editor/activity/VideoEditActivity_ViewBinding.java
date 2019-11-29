package com.shopee.feeds.feedlibrary.editor.activity;

import android.view.View;
import butterknife.a.a;
import butterknife.a.b;
import com.shopee.feeds.feedlibrary.c;

public class VideoEditActivity_ViewBinding extends AbstractEditActivity_ViewBinding {

    /* renamed from: b  reason: collision with root package name */
    private VideoEditActivity f27896b;

    /* renamed from: c  reason: collision with root package name */
    private View f27897c;

    /* renamed from: d  reason: collision with root package name */
    private View f27898d;

    /* renamed from: e  reason: collision with root package name */
    private View f27899e;

    /* renamed from: f  reason: collision with root package name */
    private View f27900f;

    /* renamed from: g  reason: collision with root package name */
    private View f27901g;

    public VideoEditActivity_ViewBinding(final VideoEditActivity videoEditActivity, View view) {
        super(videoEditActivity, view);
        this.f27896b = videoEditActivity;
        View a2 = b.a(view, c.e.iv_left, "method 'onClick'");
        this.f27897c = a2;
        a2.setOnClickListener(new a() {
            public void a(View view) {
                videoEditActivity.onClick(view);
            }
        });
        View a3 = b.a(view, c.e.tv_right, "method 'onClick'");
        this.f27898d = a3;
        a3.setOnClickListener(new a() {
            public void a(View view) {
                videoEditActivity.onClick(view);
            }
        });
        View a4 = b.a(view, c.e.rl_add_tag, "method 'onClick'");
        this.f27899e = a4;
        a4.setOnClickListener(new a() {
            public void a(View view) {
                videoEditActivity.onClick(view);
            }
        });
        View a5 = b.a(view, c.e.iv_add_text, "method 'onClick'");
        this.f27900f = a5;
        a5.setOnClickListener(new a() {
            public void a(View view) {
                videoEditActivity.onClick(view);
            }
        });
        View a6 = b.a(view, c.e.iv_add_sticker, "method 'onClick'");
        this.f27901g = a6;
        a6.setOnClickListener(new a() {
            public void a(View view) {
                videoEditActivity.onClick(view);
            }
        });
    }
}
