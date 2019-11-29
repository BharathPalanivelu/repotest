package com.shopee.live.livestreaming.util;

import android.app.Activity;
import android.content.Context;
import com.shopee.live.livestreaming.data.entity.LiveStreamingSessionEntity;
import com.shopee.live.livestreaming.network.service.InjectorUtils;
import com.shopee.live.livestreaming.network.task.EndLiveTask;
import com.shopee.live.livestreaming.ui.anchor.b;

public class l {

    /* renamed from: a  reason: collision with root package name */
    a f29451a;

    /* renamed from: b  reason: collision with root package name */
    private Context f29452b;

    /* renamed from: c  reason: collision with root package name */
    private EndLiveTask f29453c = InjectorUtils.provideEndLiveTask();

    /* renamed from: d  reason: collision with root package name */
    private LiveStreamingSessionEntity f29454d;

    /* renamed from: e  reason: collision with root package name */
    private com.shopee.sdk.ui.a f29455e;

    public interface a {
        void a();

        void a(int i);
    }

    public l(Context context) {
        this.f29452b = context;
        this.f29455e = new com.shopee.sdk.ui.a((Activity) context);
    }

    public void a(LiveStreamingSessionEntity liveStreamingSessionEntity) {
        this.f29454d = liveStreamingSessionEntity;
    }

    public void a(final int i) {
        this.f29453c.execute(new EndLiveTask.Data(f.a().f()), new EndLiveTask.Callback() {
            public void endSuccess() {
                b.o();
                if (l.this.f29451a != null) {
                    l.this.f29451a.a();
                }
            }

            public void onError(int i, String str) {
                b.b((long) i);
                if (l.this.f29451a != null) {
                    l.this.f29451a.a(i);
                }
            }
        });
    }

    public void a(a aVar) {
        this.f29451a = aVar;
    }
}
