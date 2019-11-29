package com.shopee.feeds.feedlibrary.editor.activity;

import android.view.View;
import butterknife.a.a;
import butterknife.a.b;
import com.shopee.feeds.feedlibrary.c;

public class PhotoEditActivity_ViewBinding extends AbstractEditActivity_ViewBinding {

    /* renamed from: b  reason: collision with root package name */
    private PhotoEditActivity f27874b;

    /* renamed from: c  reason: collision with root package name */
    private View f27875c;

    /* renamed from: d  reason: collision with root package name */
    private View f27876d;

    /* renamed from: e  reason: collision with root package name */
    private View f27877e;

    /* renamed from: f  reason: collision with root package name */
    private View f27878f;

    /* renamed from: g  reason: collision with root package name */
    private View f27879g;

    public PhotoEditActivity_ViewBinding(final PhotoEditActivity photoEditActivity, View view) {
        super(photoEditActivity, view);
        this.f27874b = photoEditActivity;
        View a2 = b.a(view, c.e.iv_left, "method 'onClick'");
        this.f27875c = a2;
        a2.setOnClickListener(new a() {
            public void a(View view) {
                photoEditActivity.onClick(view);
            }
        });
        View a3 = b.a(view, c.e.tv_right, "method 'onClick'");
        this.f27876d = a3;
        a3.setOnClickListener(new a() {
            public void a(View view) {
                photoEditActivity.onClick(view);
            }
        });
        View a4 = b.a(view, c.e.rl_add_tag, "method 'onClick'");
        this.f27877e = a4;
        a4.setOnClickListener(new a() {
            public void a(View view) {
                photoEditActivity.onClick(view);
            }
        });
        View a5 = b.a(view, c.e.iv_add_text, "method 'onClick'");
        this.f27878f = a5;
        a5.setOnClickListener(new a() {
            public void a(View view) {
                photoEditActivity.onClick(view);
            }
        });
        View a6 = b.a(view, c.e.iv_add_sticker, "method 'onClick'");
        this.f27879g = a6;
        a6.setOnClickListener(new a() {
            public void a(View view) {
                photoEditActivity.onClick(view);
            }
        });
    }
}
