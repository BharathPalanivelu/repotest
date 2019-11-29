package com.shopee.feeds.feedlibrary.util;

import android.content.Context;
import com.garena.android.appkit.f.f;
import com.shopee.f.a.a.b;
import com.shopee.f.a.a.c;
import com.shopee.feeds.feedlibrary.data.entity.VideoEditEntity;
import com.shopee.feeds.feedlibrary.view.widget.a;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;

public class x {

    /* renamed from: a  reason: collision with root package name */
    a f28397a;

    /* renamed from: b  reason: collision with root package name */
    c f28398b;

    /* renamed from: c  reason: collision with root package name */
    private Context f28399c;

    /* renamed from: d  reason: collision with root package name */
    private OkHttpClient f28400d = new OkHttpClient.Builder().connectTimeout(60, TimeUnit.SECONDS).readTimeout(60, TimeUnit.SECONDS).writeTimeout(60, TimeUnit.SECONDS).build();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public com.shopee.feeds.feedlibrary.a.a f28401e;

    /* access modifiers changed from: private */
    public void a(int i) {
    }

    public void a() {
    }

    public x(Context context, a aVar) {
        this.f28399c = context;
        this.f28397a = aVar;
        this.f28398b = new c(context);
        this.f28398b.a(new c.a() {
            public void a() {
            }

            public void a(long j, long j2) {
                try {
                    x.this.a((int) (new BigDecimal((double) (((float) j) / ((float) j2))).setScale(2, 4).doubleValue() * 100.0d));
                } catch (Throwable th) {
                    h.b("", th.getMessage());
                }
            }

            public void a(final b.c cVar) {
                x.this.a();
                if (cVar == null || cVar.f27273a != 0) {
                    x.this.a(cVar.f27274b);
                } else {
                    f.a().a(new Runnable() {
                        public void run() {
                            if (x.this.f28401e != null) {
                                x.this.f28401e.a(cVar.f27276d, cVar.f27277e);
                            }
                        }
                    });
                }
            }

            public void a(int i) {
                h.b("", "");
            }
        });
    }

    public void a(String str, com.shopee.feeds.feedlibrary.a.a aVar, VideoEditEntity videoEditEntity) {
        c cVar = this.f28398b;
        if (cVar != null) {
            this.f28401e = aVar;
            cVar.a(videoEditEntity.getSignature(), str, videoEditEntity.getCoverPath());
            this.f28398b.d();
        }
    }

    public void b(String str, com.shopee.feeds.feedlibrary.a.a aVar, VideoEditEntity videoEditEntity) {
        c cVar = this.f28398b;
        if (cVar != null) {
            this.f28401e = aVar;
            cVar.a(videoEditEntity.getSignature(), str, videoEditEntity.getImageWaterMarkStorePath());
            this.f28398b.d();
        }
    }

    public void b() {
        c cVar = this.f28398b;
        if (cVar != null) {
            cVar.c();
        }
    }

    public void a(String str) {
        com.shopee.feeds.feedlibrary.a.a aVar = this.f28401e;
        if (aVar != null) {
            aVar.a(str);
        }
    }
}
