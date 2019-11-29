package com.shopee.live.livestreaming.ui.view.c;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.garena.android.appkit.tools.b;
import com.shopee.live.livestreaming.c;

public class h extends PopupWindow {
    public h(Context context) {
        super(context);
        setHeight(-2);
        setWidth(-2);
        setOutsideTouchable(true);
        setFocusable(true);
        setBackgroundDrawable(new ColorDrawable(0));
        View inflate = LayoutInflater.from(context).inflate(c.f.live_streaming_layout_show_product_tips, (ViewGroup) null, false);
        ((TextView) inflate.findViewById(c.e.tv_show_product_default_content)).setText(b.e(c.g.live_streaming_host_preview_no_product_shown_tip));
        setContentView(inflate);
    }
}
