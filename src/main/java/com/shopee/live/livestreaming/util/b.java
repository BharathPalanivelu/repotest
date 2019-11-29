package com.shopee.live.livestreaming.util;

import android.text.TextUtils;
import com.shopee.live.livestreaming.c;
import com.shopee.live.livestreaming.data.entity.LiveStreamingRoomConfigEntity;
import com.shopee.live.livestreaming.network.executor.RetryTask;
import com.shopee.live.livestreaming.network.service.InjectorUtils;
import com.shopee.live.livestreaming.network.task.GetUserConfigTask;
import com.shopee.live.livestreaming.network.task.PostCoinCanClaimTask;
import com.shopee.live.livestreaming.network.task.PostCoinClaimTask;
import com.shopee.live.livestreaming.network.task.PostCoinLockTask;
import com.shopee.live.livestreaming.network.task.PostCoinReleaseTask;
import com.shopee.live.livestreaming.ui.audience.c;
import com.shopee.live.livestreaming.ui.audience.e;
import java.util.HashMap;
import org.json.JSONObject;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private PostCoinCanClaimTask f29412a = InjectorUtils.providePostCoinCanClaimTask();

    /* renamed from: b  reason: collision with root package name */
    private PostCoinClaimTask f29413b = InjectorUtils.providePostCoinClaimTask();

    /* renamed from: c  reason: collision with root package name */
    private PostCoinLockTask f29414c = InjectorUtils.providePostCoinLockTask();

    /* renamed from: d  reason: collision with root package name */
    private PostCoinReleaseTask f29415d = InjectorUtils.providePostCoinReleaseTask();

    /* renamed from: e  reason: collision with root package name */
    private GetUserConfigTask f29416e = InjectorUtils.provideGetUserConfigTask();
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public e f29417f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public c f29418g;
    /* access modifiers changed from: private */
    public LiveStreamingRoomConfigEntity h;
    /* access modifiers changed from: private */
    public int i = 0;
    /* access modifiers changed from: private */
    public boolean j = false;
    /* access modifiers changed from: private */
    public boolean k = false;
    private int l;
    private int m;
    private String n;

    public b(e eVar) {
        this.f29417f = eVar;
        this.f29418g = new c(eVar);
        if (this.f29417f == null) {
            throw new NullPointerException("ICheckInCoin must be not null");
        }
    }

    public void a(int i2) {
        this.l = i2;
    }

    public void b(int i2) {
        this.m = i2;
        HashMap hashMap = new HashMap();
        hashMap.put("uid", Integer.valueOf(i2));
        this.n = new JSONObject(hashMap).toString();
    }

    public void a() {
        if (this.i == 0) {
            this.f29416e.execute(new GetUserConfigTask.Data(this.l, this.m), new GetUserConfigTask.Callback() {
                public void onSuccess(LiveStreamingRoomConfigEntity liveStreamingRoomConfigEntity) {
                    if (liveStreamingRoomConfigEntity != null) {
                        LiveStreamingRoomConfigEntity unused = b.this.h = liveStreamingRoomConfigEntity;
                        b.this.f29418g.a(liveStreamingRoomConfigEntity);
                        b.this.f29418g.a(liveStreamingRoomConfigEntity.getCoins_per_claim());
                        int unused2 = b.this.i = liveStreamingRoomConfigEntity.getCoin_status();
                        b.this.f29417f.m();
                        boolean unused3 = b.this.j = false;
                        b.this.f29418g.d();
                        if (b.this.f29418g.c()) {
                            b.this.f29417f.l();
                            return;
                        }
                        return;
                    }
                    b.this.f29417f.d();
                }

                public void onError(int i, String str) {
                    b.this.f29417f.b(str);
                    b.this.f29417f.d();
                }
            });
        } else {
            this.f29417f.d();
        }
    }

    public void b() {
        if (!TextUtils.isEmpty(this.n)) {
            this.f29414c.execute(new PostCoinLockTask.Data(this.l, this.n), new PostCoinLockTask.Callback() {
                public void onSuccess() {
                    boolean unused = b.this.k = true;
                    c.a(0);
                    b.this.f29417f.a(b.this.f29418g.b());
                    b.this.f29417f.j_(b.this.h.getRequired_watch_time());
                }

                public void onError(int i, String str) {
                    b.this.f29417f.k();
                    switch (i) {
                        case 7400000:
                            b.this.f29417f.g();
                            return;
                        case 7400001:
                            b.this.f29417f.f();
                            return;
                        default:
                            b.this.f29417f.d();
                            return;
                    }
                }
            });
        }
    }

    public void c() {
        this.k = false;
        if (!TextUtils.isEmpty(this.n)) {
            final RetryTask retryTask = new RetryTask();
            retryTask.execute(new RetryTask.Data(this.f29412a, new PostCoinCanClaimTask.Data(this.l, this.n), new PostCoinCanClaimTask.Callback() {
                public void onError(int i, String str) {
                }

                public void onSuccess() {
                    retryTask.handleResult(true);
                }
            }), null);
        }
    }

    public void d() {
        this.k = false;
        if (!TextUtils.isEmpty(this.n)) {
            this.f29412a.execute(new PostCoinCanClaimTask.Data(this.l, this.n), new PostCoinCanClaimTask.Callback() {
                public void onError(int i, String str) {
                }

                public void onSuccess() {
                }
            });
        }
    }

    public void e() {
        if (!this.j && !TextUtils.isEmpty(this.n)) {
            this.j = true;
            this.f29417f.i();
            this.f29413b.execute(new PostCoinClaimTask.Data(this.l, this.n), new PostCoinClaimTask.Callback() {
                public void onSuccess(int i) {
                    if (i < 0) {
                        i = 0;
                    }
                    b.this.f29417f.a(b.this.f29418g.a(), i);
                }

                public void onError(int i, String str) {
                    b.this.f29417f.k();
                    switch (i) {
                        case 7400000:
                            if (b.this.i == 0) {
                                b.this.f29417f.g();
                            } else {
                                b.this.f29417f.d();
                            }
                            b.this.f29417f.b(com.garena.android.appkit.tools.b.e(c.g.live_streaming_viewer_cic_fully_claimed));
                            break;
                        case 7400001:
                            if (b.this.i == 0) {
                                b.this.f29417f.f();
                            } else {
                                b.this.f29417f.d();
                            }
                            b.this.f29417f.b(com.garena.android.appkit.tools.b.e(c.g.live_streaming_viewer_cic_reachtimeslimit_toast));
                            break;
                        default:
                            b.this.d();
                            b.this.f29417f.j();
                            b.this.f29417f.h();
                            break;
                    }
                    boolean unused = b.this.j = false;
                }
            });
        }
    }

    public void f() {
        if (this.k && !TextUtils.isEmpty(this.n)) {
            this.f29415d.execute(new PostCoinReleaseTask.Data(this.l, this.n), null);
        }
    }
}
