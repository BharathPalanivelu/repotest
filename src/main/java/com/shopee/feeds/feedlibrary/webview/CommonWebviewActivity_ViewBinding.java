package com.shopee.feeds.feedlibrary.webview;

import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.a.a;
import butterknife.a.b;
import com.devspark.robototextview.widget.RobotoTextView;
import com.shopee.feeds.feedlibrary.c;

public class CommonWebviewActivity_ViewBinding implements Unbinder {

    /* renamed from: b  reason: collision with root package name */
    private CommonWebviewActivity f28737b;

    /* renamed from: c  reason: collision with root package name */
    private View f28738c;

    public CommonWebviewActivity_ViewBinding(final CommonWebviewActivity commonWebviewActivity, View view) {
        this.f28737b = commonWebviewActivity;
        View a2 = b.a(view, c.e.iv_left, "field 'ivLeft' and method 'onClick'");
        commonWebviewActivity.ivLeft = (ImageView) b.b(a2, c.e.iv_left, "field 'ivLeft'", ImageView.class);
        this.f28738c = a2;
        a2.setOnClickListener(new a() {
            public void a(View view) {
                commonWebviewActivity.onClick(view);
            }
        });
        commonWebviewActivity.btnTopBack = (RobotoTextView) b.a(view, c.e.btn_top_back, "field 'btnTopBack'", RobotoTextView.class);
        commonWebviewActivity.ivRight = (ImageView) b.a(view, c.e.iv_right, "field 'ivRight'", ImageView.class);
        commonWebviewActivity.tvRight = (RobotoTextView) b.a(view, c.e.tv_right, "field 'tvRight'", RobotoTextView.class);
        commonWebviewActivity.llTitleLayout = (RelativeLayout) b.a(view, c.e.ll_title_layout, "field 'llTitleLayout'", RelativeLayout.class);
        commonWebviewActivity.webviewContent = (WebView) b.a(view, c.e.webview_content, "field 'webviewContent'", WebView.class);
        commonWebviewActivity.webviewContainer = (FrameLayout) b.a(view, c.e.webview_container, "field 'webviewContainer'", FrameLayout.class);
        commonWebviewActivity.llMainLayout = (LinearLayout) b.a(view, c.e.ll_main_layout, "field 'llMainLayout'", LinearLayout.class);
    }
}
