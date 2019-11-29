package com.garena.sticker;

import android.content.SharedPreferences;
import android.util.Pair;
import com.garena.sticker.a.a;
import com.garena.sticker.model.StickerManifest;
import com.garena.sticker.model.StickerManifestPack;
import com.garena.sticker.model.StickerPack;
import com.google.a.f;
import io.b.d.g;
import io.b.j;
import io.b.m;
import io.b.q;
import io.b.u;
import java.util.List;
import okhttp3.OkHttpClient;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private a f8658a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public com.garena.sticker.a.b f8659b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f8660c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f8661d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public String f8662e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public com.garena.sticker.c.a f8663f;

    public b(SharedPreferences sharedPreferences, OkHttpClient okHttpClient, String str, String str2, String str3, float f2) {
        com.garena.sticker.d.a.a(str);
        this.f8661d = str3;
        this.f8660c = str2;
        this.f8662e = com.garena.sticker.d.a.a(f2);
        a aVar = new a(okHttpClient, str);
        this.f8658a = aVar.a();
        this.f8659b = aVar.b();
        this.f8663f = new com.garena.sticker.c.a(sharedPreferences, new f());
    }

    public q<StickerManifest> a() {
        return this.f8658a.a().d().a(new g<StickerManifest, u<StickerManifest>>() {
            /* renamed from: a */
            public u<StickerManifest> apply(final StickerManifest stickerManifest) throws Exception {
                b bVar = b.this;
                return bVar.a(bVar.f8663f.a(), stickerManifest).i().b(new g<List<StickerPack>, StickerManifest>() {
                    /* renamed from: a */
                    public StickerManifest apply(List<StickerPack> list) throws Exception {
                        return stickerManifest;
                    }
                });
            }
        }).b(new g<StickerManifest, StickerManifest>() {
            /* renamed from: a */
            public StickerManifest apply(StickerManifest stickerManifest) throws Exception {
                b.this.f8663f.a(stickerManifest);
                return stickerManifest;
            }
        }).a(q.a(this.f8663f.a()));
    }

    public j<com.garena.sticker.e.a> b() {
        return j.b(this.f8663f.a()).a(new g<StickerManifest, m<StickerManifestPack>>() {
            /* renamed from: a */
            public m<StickerManifestPack> apply(StickerManifest stickerManifest) throws Exception {
                return j.a(stickerManifest.getPacks());
            }
        }).a(new io.b.d.j<StickerManifestPack>() {
            public boolean a(StickerManifestPack stickerManifestPack) throws Exception {
                return stickerManifestPack.isAvailable(b.this.f8660c);
            }
        }).b(new g<StickerManifestPack, Pair<String, StickerPack>>() {
            /* renamed from: a */
            public Pair<String, StickerPack> apply(StickerManifestPack stickerManifestPack) throws Exception {
                return new Pair<>(stickerManifestPack.getPid(), b.this.f8663f.a(stickerManifestPack.getPid()));
            }
        }).a(new g<Pair<String, StickerPack>, m<com.garena.sticker.e.a>>() {
            /* renamed from: a */
            public m<com.garena.sticker.e.a> apply(Pair<String, StickerPack> pair) throws Exception {
                return j.b(new com.garena.sticker.b.a().a((String) pair.first, (StickerPack) pair.second, b.this.f8661d, b.this.f8662e));
            }
        });
    }

    /* access modifiers changed from: private */
    public j<StickerPack> a(final StickerManifest stickerManifest, StickerManifest stickerManifest2) {
        return j.a(stickerManifest2.getPacks()).a(new io.b.d.j<StickerManifestPack>() {
            public boolean a(StickerManifestPack stickerManifestPack) throws Exception {
                if (stickerManifest.getPacks() != null) {
                    for (StickerManifestPack next : stickerManifest.getPacks()) {
                        if (next.getPid().equals(stickerManifestPack.getPid())) {
                            return !next.getMd5().equals(stickerManifestPack.getMd5());
                        }
                    }
                }
                return true;
            }
        }).a(new g<StickerManifestPack, m<Pair<String, StickerPack>>>() {
            /* renamed from: a */
            public m<Pair<String, StickerPack>> apply(final StickerManifestPack stickerManifestPack) throws Exception {
                return b.this.f8659b.a(stickerManifestPack.getPid()).b(new g<StickerPack, Pair<String, StickerPack>>() {
                    /* renamed from: a */
                    public Pair<String, StickerPack> apply(StickerPack stickerPack) throws Exception {
                        return new Pair<>(stickerManifestPack.getPid(), stickerPack);
                    }
                });
            }
        }).b(new g<Pair<String, StickerPack>, StickerPack>() {
            /* renamed from: a */
            public StickerPack apply(Pair<String, StickerPack> pair) throws Exception {
                b.this.f8663f.a((String) pair.first, (StickerPack) pair.second);
                return (StickerPack) pair.second;
            }
        });
    }
}
