package com.shopee.app.ui.video;

import android.content.Context;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class g extends f implements a, b {

    /* renamed from: g  reason: collision with root package name */
    private boolean f25783g = false;
    private final c h = new c();

    public g(Context context, String str) {
        super(context, str);
        d();
    }

    public static f a(Context context, String str) {
        g gVar = new g(context, str);
        gVar.onFinishInflate();
        return gVar;
    }

    public void onFinishInflate() {
        if (!this.f25783g) {
            this.f25783g = true;
            inflate(getContext(), R.layout.video_viewer_layout_with_topbar, this);
            this.h.a((a) this);
        }
        super.onFinishInflate();
    }

    private void d() {
        c a2 = c.a(this.h);
        c.a((b) this);
        this.f25779e = AnimationUtils.loadAnimation(getContext(), R.anim.slide_out_from_top);
        this.f25780f = AnimationUtils.loadAnimation(getContext(), R.anim.slide_in_from_up);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f25776b = (ImageButton) aVar.internalFindViewById(R.id.back_button);
        this.f25777c = (VideoViewerView) aVar.internalFindViewById(R.id.video_viewer);
        this.f25778d = (RelativeLayout) aVar.internalFindViewById(R.id.video_player_toolbar);
        if (this.f25776b != null) {
            this.f25776b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    g.this.b();
                }
            });
        }
        a();
    }
}
