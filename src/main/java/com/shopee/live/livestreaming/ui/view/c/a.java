package com.shopee.live.livestreaming.ui.view.c;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.garena.android.appkit.tools.b;
import com.shopee.live.livestreaming.c;

public class a extends PopupWindow {

    /* renamed from: a  reason: collision with root package name */
    RelativeLayout f29248a;

    /* renamed from: b  reason: collision with root package name */
    TextView f29249b;

    /* renamed from: c  reason: collision with root package name */
    C0447a f29250c;

    /* renamed from: com.shopee.live.livestreaming.ui.view.c.a$a  reason: collision with other inner class name */
    public interface C0447a {
        void a();
    }

    public a(Context context) {
        super(context);
        setHeight(-2);
        setWidth(-2);
        setOutsideTouchable(true);
        setFocusable(true);
        setBackgroundDrawable(new ColorDrawable(0));
        View inflate = LayoutInflater.from(context).inflate(c.f.live_streaming_layout_ban_to_comment, (ViewGroup) null, false);
        this.f29248a = (RelativeLayout) inflate.findViewById(c.e.rl_popup_tag);
        this.f29249b = (TextView) inflate.findViewById(c.e.container);
        this.f29249b.setText(b.e(c.g.live_streaming_host_msg_ban_popup_view_title));
        this.f29248a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (a.this.f29250c != null) {
                    a.this.f29250c.a();
                }
            }
        });
        setContentView(inflate);
    }

    public void a(C0447a aVar) {
        this.f29250c = aVar;
    }
}
