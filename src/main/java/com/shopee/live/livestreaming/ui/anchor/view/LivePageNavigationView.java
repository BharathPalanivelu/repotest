package com.shopee.live.livestreaming.ui.anchor.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.garena.android.appkit.tools.b;
import com.shopee.live.livestreaming.c;
import com.shopee.live.livestreaming.network.service.InjectorUtils;
import com.shopee.live.livestreaming.network.task.NotifyLiveTask;
import com.shopee.live.livestreaming.ui.view.MyButton;
import com.shopee.live.livestreaming.util.f;
import com.shopee.live.livestreaming.util.z;

public class LivePageNavigationView extends LinearLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    View f28876a;

    /* renamed from: b  reason: collision with root package name */
    TextView f28877b;

    /* renamed from: c  reason: collision with root package name */
    MyButton f28878c;

    /* renamed from: d  reason: collision with root package name */
    NotifyLiveTask f28879d;

    /* renamed from: e  reason: collision with root package name */
    a f28880e;

    public interface a {
        void a();

        void b();

        void c();
    }

    public LivePageNavigationView(Context context) {
        this(context, (AttributeSet) null);
    }

    public LivePageNavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LivePageNavigationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        this.f28876a = LayoutInflater.from(getContext()).inflate(c.f.live_streaming_layout_live_navigation, this, true);
        this.f28877b = (TextView) this.f28876a.findViewById(c.e.tv_live_back);
        this.f28878c = (MyButton) this.f28876a.findViewById(c.e.btn_go_live);
        this.f28877b.setOnClickListener(this);
        this.f28878c.setOnClickListener(this);
        this.f28877b.setText(b.e(c.g.live_streaming_host_preview_btn_back));
        this.f28878c.a(b.e(c.g.live_streaming_host_preview_btn_go_live), -1, 0);
        this.f28879d = InjectorUtils.provideNotifyLiveTask();
    }

    public void onClick(View view) {
        if (view.getId() == c.e.tv_live_back) {
            ((Activity) getContext()).finish();
        } else if (view.getId() == c.e.btn_go_live) {
            a aVar = this.f28880e;
            if (aVar != null) {
                aVar.a();
                com.shopee.live.livestreaming.ui.anchor.b.g();
            }
        }
    }

    public void a(boolean z) {
        this.f28879d.execute(new NotifyLiveTask.Data(f.a().f(), z), new NotifyLiveTask.Callback() {
            public void onLiveSuccess() {
                com.shopee.live.livestreaming.ui.anchor.b.h();
                if (LivePageNavigationView.this.f28880e != null) {
                    LivePageNavigationView.this.f28880e.b();
                }
            }

            public void onError(int i, String str) {
                if (i >= 0) {
                    com.shopee.live.livestreaming.ui.anchor.b.a((long) i);
                }
                if (i == 10015) {
                    z.a(LivePageNavigationView.this.getContext(), b.e(c.g.live_streaming_host_preview_no_permission_create_streaming_tip));
                } else {
                    z.a(LivePageNavigationView.this.getContext(), b.e(c.g.live_streaming_host_preview_go_live_failed_tip));
                }
                if (LivePageNavigationView.this.f28880e != null) {
                    LivePageNavigationView.this.f28880e.c();
                }
            }
        });
    }

    public void setOnNavigationCallback(a aVar) {
        this.f28880e = aVar;
    }
}
